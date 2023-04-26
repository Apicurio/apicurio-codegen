/*
 * Copyright 2018 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.hub.api.codegen;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.lang.model.SourceVersion;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.Type;
import org.jboss.forge.roaster.model.source.Import;
import org.jboss.forge.roaster.model.source.Importer;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.source.JavaInterfaceSource;
import org.jboss.forge.roaster.model.source.MethodSource;
import org.jboss.forge.roaster.model.util.Types;
import org.jsonschema2pojo.Annotator;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.Schema;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.rules.Rule;
import org.jsonschema2pojo.rules.RuleFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.codemodel.JClassContainer;
import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JType;

import io.apicurio.datamodels.Library;
import io.apicurio.datamodels.TraverserDirection;
import io.apicurio.datamodels.VisitorUtil;
import io.apicurio.datamodels.models.Document;
import io.apicurio.datamodels.models.Extensible;
import io.apicurio.datamodels.models.ModelType;
import io.apicurio.datamodels.models.openapi.OpenApiDocument;
import io.apicurio.datamodels.util.ModelTypeUtil;
import io.apicurio.hub.api.codegen.beans.CodegenBeanAnnotationDirective;
import io.apicurio.hub.api.codegen.beans.CodegenInfo;
import io.apicurio.hub.api.codegen.beans.CodegenJavaBean;
import io.apicurio.hub.api.codegen.beans.CodegenJavaInterface;
import io.apicurio.hub.api.codegen.jaxrs.CodegenTarget;
import io.apicurio.hub.api.codegen.jaxrs.InterfacesVisitor;
import io.apicurio.hub.api.codegen.jaxrs.OpenApi2CodegenVisitor;
import io.apicurio.hub.api.codegen.post.JavaBeanPostProcessor;
import io.apicurio.hub.api.codegen.pre.DocumentPreProcessor;
import io.apicurio.hub.api.codegen.util.CodegenUtil;
import io.apicurio.hub.api.codegen.util.IndexedCodeWriter;


/**
 * Class used to generate a simple JAX-RS project from an OpenAPI document.
 *
 * @author eric.wittmann@gmail.com
 */
public class OpenApi2JaxRs {

    protected static ObjectMapper mapper = new ObjectMapper();
    protected static Charset utf8 = StandardCharsets.UTF_8;
    protected static GenerationConfig config = new DefaultGenerationConfig() {
        @Override
        public boolean isUsePrimitives() {
            return false;
        }

        @Override
        public boolean isIncludeHashcodeAndEquals() {
            return false;
        }

        @Override
        public boolean isIncludeAdditionalProperties() {
            return false;
        }

        @Override
        public boolean isIncludeToString() {
            return false;
        }
    };
    protected static JavaBeanPostProcessor postProcessor = new JavaBeanPostProcessor();

    protected String openApiDoc;
    protected transient Document document;
    protected JaxRsProjectSettings settings;
    protected boolean updateOnly;

    /**
     * Constructor.
     */
    public OpenApi2JaxRs() {
        this.settings = new JaxRsProjectSettings();
        this.settings.artifactId = "generated-api";
        this.settings.groupId = "org.example.api";
        this.settings.javaPackage = "org.example.api";
    }

    /**
     * Configure the settings.
     *
     * @param settings
     */
    public void setSettings(JaxRsProjectSettings settings) {
        this.settings = settings;
    }

    /**
     * Sets the OpenAPI document.
     *
     * @param content
     * @throws IOException
     */
    public void setOpenApiDocument(String content) {
        this.openApiDoc = content;
    }

    /**
     * Sets the OpenAPI document via a URL to the content.
     *
     * @param url
     * @throws IOException
     */
    public void setOpenApiDocument(URL url) throws IOException {
        try (InputStream is = url.openStream()) {
            this.setOpenApiDocument(is);
        }
    }

    /**
     * Sets the OpenAPI document via an input stream.  The stream must be closed
     * by the caller.
     *
     * @param stream
     * @throws IOException
     */
    public void setOpenApiDocument(InputStream stream) throws IOException {
        this.openApiDoc = IOUtils.toString(stream, utf8);
    }

    /**
     * Generates a JaxRs project and streams the generated ZIP to the given
     * output stream.
     *
     * @param output
     * @throws IOException
     */
    public final void generate(OutputStream output) throws IOException {
        StringBuilder log = new StringBuilder();

        try (ZipOutputStream zos = new ZipOutputStream(output)) {
            try {
                CodegenInfo info = getInfoFromApiDoc();
                generateAll(info, log, zos);
            } catch (Exception e) {
                // If we get an error, put an PROJECT_GENERATION_ERROR file into the ZIP.
                zos.putNextEntry(new ZipEntry("PROJECT_GENERATION_FAILED.txt"));
                zos.write("An unexpected server error was encountered while generating the project.  See\r\n".getBytes());
                zos.write("the details of the error below.\r\n\r\n".getBytes());
                zos.write("Generation Log:\r\n\r\n".getBytes());
                zos.write(log.toString().getBytes(utf8));
                zos.write("\r\n\r\nServer Stack Trace:\r\n".getBytes());

                PrintWriter writer = new PrintWriter(zos);
                e.printStackTrace(writer);
                writer.flush();
                zos.closeEntry();
            }
        }
    }

    /**
     * Generates all of the content for storage in the ZIP.  Responsible for generating all classes
     * and other resources that make up the generated project.
     *
     * @param info
     * @param log
     * @param zipOutput
     * @throws IOException
     */
    protected void generateAll(CodegenInfo info, StringBuilder log, ZipOutputStream zipOutput) throws IOException {
        if (!this.updateOnly && !this.settings.codeOnly) {
            log.append("Generating pom.xml\r\n");
            String pomXml = generatePomXml(info);
            if (pomXml != null) {
                zipOutput.putNextEntry(new ZipEntry("pom.xml"));
                zipOutput.write(pomXml.getBytes(utf8));
                zipOutput.closeEntry();
            }
        }

        if (this.settings.cliGenCI) {
            log.append("Generating .github/workflows/release_cli.yaml\r\n");
            zipOutput.putNextEntry(new ZipEntry(".github/workflows/release_cli.yaml"));
            zipOutput.write(IOUtils.toString(getResource("release_cli.yaml"), Charset.forName("UTF-8")).getBytes(utf8));
            zipOutput.closeEntry();
        }

        if (settings.isIncludeSpec()) {
            String specPath = "META-INF/openapi.json";
            if (settings.isMavenFileStructure()) {
                specPath = "src/main/resources/" + specPath;
            }
            log.append("Generating " + specPath + "\r\n");
            zipOutput.putNextEntry(new ZipEntry(specPath));
            zipOutput.write(this.openApiDoc.getBytes(utf8));
            zipOutput.closeEntry();
        }

        if (!this.updateOnly) {
            String appFileName = javaPackageToZipPath(this.settings.javaPackage) + "JaxRsApplication.java";
            String jaxRsApp = generateJaxRsApplication();
            if (jaxRsApp != null) {
                log.append("Generating " + appFileName + "\r\n");
                zipOutput.putNextEntry(new ZipEntry(appFileName));
                zipOutput.write(jaxRsApp.getBytes(utf8));
                zipOutput.closeEntry();
            }
        }

        // Generate the java beans from data types
        IndexedCodeWriter codeWriter = new IndexedCodeWriter();
        for (CodegenJavaBean bean : info.getBeans()) {
            log.append("Generating Bean: " + bean.getPackage() + "." + bean.getName() + "\r\n");
            generateJavaBean(bean, info, codeWriter);
        }
        // Post-process generated java bean classes
        for (String className : codeWriter.keys()) {
            ByteArrayOutputStream beanData = codeWriter.getContent(className);
            List<CodegenBeanAnnotationDirective> annotations = new ArrayList<>();
            annotations.addAll(info.getBeanAnnotations());
            CodegenJavaBean bean = codeWriter.getBean(className);
            if (bean != null && bean.getAnnotations() != null) {
                annotations.addAll(bean.getAnnotations());
            }

            ByteArrayOutputStream processedBeanData = postProcessor.process(className, annotations, beanData);
            if (beanData != processedBeanData) {
                codeWriter.set(className, processedBeanData);
            }
        }
        // Write all of the java beans classes to the ZIP file
        for (String key : codeWriter.keys()) {
            String javaClassFileName = javaClassToZipPath(key);
            log.append("Adding to zip: " + javaClassFileName + "\r\n");
            zipOutput.putNextEntry(new ZipEntry(javaClassFileName));
            zipOutput.write(codeWriter.getContent(key).toByteArray());
            zipOutput.closeEntry();
        }

        // Generate the JAX-RS interfaces
        for (CodegenJavaInterface iface : info.getInterfaces()) {
            log.append("Generating Interface: " + iface.getPackage() + "." + iface.getName() + "\r\n");
            String javaInterface = generateJavaInterface(info, iface);
            String javaInterfaceFileName = javaPackageToZipPath(iface.getPackage()) + iface.getName() + ".java";
            log.append("Adding to zip: " + javaInterfaceFileName + "\r\n");
            zipOutput.putNextEntry(new ZipEntry(javaInterfaceFileName));
            zipOutput.write(javaInterface.getBytes(utf8));
            zipOutput.closeEntry();
        }

    }

    /**
     * Generate the JaxRs project.
     *
     * @throws IOException
     */
    public ByteArrayOutputStream generate() throws IOException {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            this.generate(output);
            return output;
        }
    }

    private String javaClassToZipPath(String javaClass) {
        return (settings.isMavenFileStructure() ? "src/main/java/" : "") + javaClass.replace('.', '/') + ".java";
    }

    /**
     * Processes the OpenAPI document to produce a CodegenInfo object that contains everything
     * needed to generate appropriate Java class(es).
     */
    protected CodegenInfo getInfoFromApiDoc() throws IOException {
        document = Library.readDocumentFromJSONString(openApiDoc);

        // If the document is OpenAPI 2.0, upgrade/transform it to 3.0
        if (ModelTypeUtil.isOpenApi2Model(document)) {
            document = Library.transformDocument(document, ModelType.OPENAPI30);
        }

        // Pre-process the document
        document = preProcess(document);

        // Figure out the breakdown of the interfaces.
        InterfacesVisitor iVisitor = new InterfacesVisitor();
        VisitorUtil.visitTree(document, iVisitor, TraverserDirection.down);

        // Then generate the CodegenInfo object.
        OpenApi2CodegenVisitor cgVisitor = new OpenApi2CodegenVisitor(this.settings.javaPackage, iVisitor.getInterfaces(), CodegenTarget.JAX_RS);
        VisitorUtil.visitTree(document, cgVisitor, TraverserDirection.down);

        // Now resolve any inline schemas/types
        CodegenInfo info = cgVisitor.getCodegenInfo();
        info.getInterfaces().forEach(iface -> {
            iface.getMethods().forEach(method -> {
                method.getArguments().forEach(arg -> {
                    String argTypeSig = arg.getTypeSignature();
                    CodegenJavaBean matchingBean = findMatchingBean(info, argTypeSig);
                    if (matchingBean != null) {
                        arg.setType(matchingBean.getPackage() + "." + StringUtils.capitalize(matchingBean.getName()));
                    }
                });
            });
        });
        String contextRoot = getContextRoot(document);
        if (contextRoot != null) {
            info.setContextRoot(contextRoot);
        }
        return info;
    }

    protected String getContextRoot(Document document) {
        OpenApiDocument oaiDoc = (OpenApiDocument) document;
        if (oaiDoc.getPaths() != null) {
            JsonNode extension = CodegenUtil.getExtension((Extensible) oaiDoc.getPaths(), CodegenExtensions.CONTEXT_ROOT);
            if (extension != null && !extension.isNull()) {
                return extension.asText();
            }
        }
        return null;
    }

    /**
     * Pre-process the document to modify it in the following ways:
     *
     * 1) Inline any re-usable simple-type schemas
     * 2) Check for the "x-codegen-contextRoot" property in the Paths object and prepend its value to all paths
     *
     * @param document
     */
    protected Document preProcess(Document document) {
        DocumentPreProcessor preprocessor = new DocumentPreProcessor();
        preprocessor.process(document);

        if (Boolean.FALSE) {
            System.out.println("-------------------------");
            System.out.println(Library.writeDocumentToJSONString(document));
            System.out.println("-------------------------");
            System.exit(1);
        }

        return document;
    }

    /**
     * Find a bean that matches the schema signature.
     *
     * @param info
     * @param typeSignature
     */
    protected static CodegenJavaBean findMatchingBean(CodegenInfo info, String typeSignature) {
        if (typeSignature == null) {
            return null;
        }
        for (CodegenJavaBean bean : info.getBeans()) {
            if (typeSignature.equals(bean.getSignature())) {
                return bean;
            }
        }
        return null;
    }

    /**
     * Generates the pom.xml file.
     *
     * @param info
     */
    protected String generatePomXml(CodegenInfo info) throws IOException {
        String template = IOUtils.toString(getResource("pom.xml"), Charset.forName("UTF-8"));
        return template.replace("$GROUP_ID$", this.settings.groupId)
                .replace("$ARTIFACT_ID$", this.settings.artifactId)
                .replace("$VERSION$", info.getVersion())
                .replace("$NAME$", info.getName())
                .replace("$DESCRIPTION$", info.getDescription());
    }

    /**
     * Generates the JaxRsApplication Java class.
     */
    protected String generateJaxRsApplication(String topLevelPackage) {
        JavaClassSource jaxRsApp = Roaster.create(JavaClassSource.class)
                .setPackage(this.settings.javaPackage)
                .setPublic()
                .setName("JaxRsApplication")
                .setSuperType(String.format("%s.ws.rs.core.Application", topLevelPackage))
                .getJavaDoc()
                .setFullText("The JAX-RS application.")
                .getOrigin()
                .addAnnotation(String.format("%s.enterprise.context.ApplicationScoped", topLevelPackage))
                .getOrigin()
                .addAnnotation(String.format("%s.ws.rs.ApplicationPath", topLevelPackage))
                .setStringValue("/")
                .getOrigin();

        sortImports(jaxRsApp);

        return jaxRsApp.toString() + "\n";
    }

    /**
     * Generates the JaxRsApplication java class.
     */
    protected String generateJaxRsApplication() {
        return generateJaxRsApplication("jakarta");
    }

    void sortImports(Importer<?> javaSource) {
        javaSource.getImports()
        .stream()
        .sorted(Comparator.comparing(Import::getQualifiedName))
        .forEach(i -> {
            javaSource.removeImport(i);
            javaSource.addImport(i);
        });
    }

    /**
     * Generates a Jax-rs interface from the given codegen information.
     * @param info
     * @param interfaceInfo
     */
    protected String generateJavaInterface(CodegenInfo info, CodegenJavaInterface interfaceInfo, String topLevelPackage) {
        String jaxRsPath = info.getContextRoot() + interfaceInfo.getPath();
        final Parser markdownParser = Parser.builder().build();
        final HtmlRenderer htmlRenderer = HtmlRenderer.builder().build();

        JavaInterfaceSource resourceInterface = Roaster.create(JavaInterfaceSource.class)
                .setPackage(interfaceInfo.getPackage())
                .setPublic()
                .setName(interfaceInfo.getName())
                .getJavaDoc()
                .setFullText("A JAX-RS interface. An implementation of this interface must be provided.")
                .getOrigin()
                .addAnnotation(String.format("%s.ws.rs.Path", topLevelPackage))
                .setStringValue(jaxRsPath)
                .getOrigin();

        interfaceInfo.getMethods().forEach(methodInfo -> {
            MethodSource<JavaInterfaceSource> operationMethod = resourceInterface.addMethod()
                    .setName(methodInfo.getName());

            Optional.ofNullable(methodInfo.getDescription()).ifPresent(description -> {
                operationMethod.getJavaDoc()
                .setFullText(htmlRenderer.render(markdownParser.parse(description)));
            });

            Optional.ofNullable(methodInfo.getPath()).ifPresent(path ->
            operationMethod.addAnnotation(String.format("%s.ws.rs.Path", topLevelPackage)).setStringValue(path));

            operationMethod.addAnnotation(String.format("%s.ws.rs.%s", topLevelPackage, methodInfo.getMethod().toUpperCase()));

            Optional.ofNullable(methodInfo.getProduces())
            .filter(Predicate.not(Collection::isEmpty))
            .map(OpenApi2JaxRs::toStringArrayLiteral)
            .ifPresent(produces ->
            operationMethod.addAnnotation(String.format("%s.ws.rs.Produces", topLevelPackage)).setLiteralValue(produces));

            Optional.ofNullable(methodInfo.getConsumes())
            .filter(Predicate.not(Collection::isEmpty))
            .map(OpenApi2JaxRs::toStringArrayLiteral)
            .ifPresent(consumes ->
            operationMethod.addAnnotation(String.format("%s.ws.rs.Consumes", topLevelPackage)).setLiteralValue(consumes));

            Optional.ofNullable(methodInfo.getReturn())
            .map(rt -> generateTypeName(
                    rt.getCollection(),
                    rt.getType(),
                    rt.getFormat(),
                    true,
                    String.format("%s.ws.rs.core.Response", topLevelPackage)))
            .map(rt -> getSettings().reactive || methodInfo.isAsync() ? generateReactiveTypeName(rt) : rt)
            .map(Object::toString)
            .ifPresentOrElse(
                    operationMethod::setReturnType,
                    operationMethod::setReturnTypeVoid);

            Optional.ofNullable(methodInfo.getArguments())
            .map(Collection::stream)
            .orElseGet(Stream::empty)
            .forEach(arg -> {
                String methodArgName = paramNameToJavaArgName(arg.getName());
                String defaultParamType = Object.class.getName();

                if (arg.getIn().equals("body")) {
                    // Swagger 2.0?
                    defaultParamType = InputStream.class.getName();
                }

                Type<?> paramType = generateTypeName(arg.getCollection(), arg.getType(),
                        arg.getFormat(), arg.getRequired(), defaultParamType);

                if (arg.getTypeSignature() != null) {
                    // TODO try to find a re-usable data type that matches the type signature
                }

                resourceInterface.addImport(paramType);
                var paramTypeName = Types.toSimpleName(paramType.getQualifiedNameWithGenerics());
                var param = operationMethod.addParameter(paramTypeName, methodArgName);

                switch (arg.getIn()) {
                    case "path":
                        param.addAnnotation(String.format("%s.ws.rs.PathParam", topLevelPackage))
                        .setStringValue(arg.getName());
                        break;
                    case "query":
                        param.addAnnotation(String.format("%s.ws.rs.QueryParam", topLevelPackage))
                        .setStringValue(arg.getName());
                        break;
                    case "header":
                        param.addAnnotation(String.format("%s.ws.rs.HeaderParam", topLevelPackage))
                        .setStringValue(arg.getName());
                        break;
                    case "cookie":
                        param.addAnnotation(String.format("%s.ws.rs.CookieParam", topLevelPackage))
                        .setStringValue(arg.getName());
                        break;
                    default:
                        break;
                }
            });
        });

        sortImports(resourceInterface);

        return Roaster.format(getFormatterProperties(), resourceInterface.toUnformattedString());
    }

    protected String generateJavaInterface(CodegenInfo info, CodegenJavaInterface interfaceInfo) {
        return generateJavaInterface(info, interfaceInfo, "jakarta");
    }

    public static Properties getFormatterProperties() {
        Properties formattingProperties = new Properties();
        formattingProperties.setProperty("org.eclipse.jdt.core.formatter.indentation.size", "2");
        formattingProperties.setProperty("org.eclipse.jdt.core.formatter.tabulation.char", "space");
        formattingProperties.setProperty("org.eclipse.jdt.core.formatter.tabulation.size", "2");
        formattingProperties.setProperty("org.eclipse.jdt.core.formatter.insert_new_line_at_end_of_file_if_missing", "insert");
        formattingProperties.setProperty("org.eclipse.jdt.core.formatter.blank_lines_after_last_class_body_declaration", "0");
        formattingProperties.setProperty("org.eclipse.jdt.core.formatter.blank_lines_before_first_class_body_declaration", "0");
        formattingProperties.setProperty("org.eclipse.jdt.core.formatter.number_of_empty_lines_to_preserve", "0");
        formattingProperties.setProperty("org.eclipse.jdt.core.formatter.blank_lines_after_package", "1");
        formattingProperties.setProperty("org.eclipse.jdt.core.formatter.blank_lines_after_imports", "1");
        formattingProperties.setProperty("org.eclipse.jdt.core.formatter.comment.format_javadoc_comments", "true");
        formattingProperties.setProperty("org.eclipse.jdt.core.formatter.blank_lines_before_method", "1");
        return formattingProperties;
    }

    static final Map<String, Type<?>> TYPE_CACHE = new HashMap<>();

    static Type<?> parseType(String value) {
        return TYPE_CACHE.computeIfAbsent(value, k -> {
            String stub = "public class Stub { public void method( " + value + " arg0 ) {} }";
            JavaClassSource temp = (JavaClassSource) Roaster.parse(stub);
            return temp.getMethods().get(0).getParameters().get(0).getType();
        });
    }

    /**
     * Generates the java type name for a collection (optional) and type.  Examples include list/string,
     * null/org.example.Bean, list/org.example.OtherBean, etc.
     *
     * @param collection
     * @param type
     * @param format
     * @param required
     * @param defaultType
     */
    protected Type<?> generateTypeName(String collection, String type, String format, Boolean required, String defaultType) {
        if (type == null) {
            return parseType(defaultType);
        }
        if (required == null) {
            required = Boolean.FALSE;
        }

        boolean isList = "list".equals(collection);
        Type<?> coreType = null;

        if (type.equals("string")) {
            coreType = parseType(String.class.getName());

            if (format != null) {
                if (format.equals("date") || format.equals("date-time")) {
                    coreType = parseType(Date.class.getName());
                }
                if (format.equals("binary") && collection == null) {
                    coreType = parseType(defaultType);
                }
                if (format.equals("byte")) {
                    coreType = parseType("byte[]");
                }
            }
        } else if (type.equals("integer")) {
            if (config.isUseLongIntegers() || "int64".equals(format) || "utc-millisec".equals(format)) {
                coreType = (required && !isList && format != null) ? parseType("long") : parseType(Long.class.getName());
            } else {
                coreType = (required && !isList && format != null) ? parseType("int") : parseType(Integer.class.getName());
            }
        } else if (type.equals("number")) {
            coreType = parseType(Number.class.getName());
            if (format != null) {
                if (format.equals("float")) {
                    coreType = (required && !isList) ? parseType("float") : parseType(Float.class.getName());
                } else if (format.equals("double")) {
                    coreType = (required && !isList) ? parseType("double") : parseType(Double.class.getName());
                }
            }
        } else if (type.equals("boolean")) {
            coreType = parseType(Boolean.class.getName());
        } else if (Types.isQualified(type)) {
            try {
                coreType = parseType(type);
            } catch (Exception e) {
                return parseType(defaultType);
            }
        } else {
            return parseType(defaultType);
        }

        if (collection == null) {
            return coreType;
        }

        if ("list".equals(collection)) {
            return parseType(String.format("java.util.List<%s>", coreType.toString()));
        }

        return parseType(defaultType);
    }

    /**
     * Generates the reactive java type name for a collection (optional) and type.  Examples include list/string,
     * null/org.example.Bean, list/org.example.OtherBean, etc.
     *
     * @param coreType
     */
    protected Type<?> generateReactiveTypeName(Type<?> coreType) {
        return parseType(String.format("java.util.concurrent.CompletionStage<%s>", coreType.toString()));
    }

    /**
     * Converts a set of strings into an array literal format.
     *
     * @param values
     */
    protected static String toStringArrayLiteral(Set<String> values) {
        StringBuilder builder = new StringBuilder();

        if (values.size() == 1) {
            builder.append("\"");
            builder.append(values.iterator().next().replace("\"", "\\\""));
            builder.append("\"");
        } else {
            builder.append("{");
            boolean first = true;
            for (String value : values) {
                if (!first) {
                    builder.append(", ");
                }
                builder.append("\"");
                builder.append(value.replace("\"", "\\\""));
                builder.append("\"");
                first = false;
            }
            builder.append("}");
        }
        return builder.toString();
    }

    /**
     * Generates a Java Bean class for the given bean info.  The bean info should
     * have a name, package, and JSON Schema.  This information will be used to
     * generate a POJO.
     *
     * @param bean
     * @param info
     * @param codeWriter
     * @throws IOException
     */
    private void generateJavaBean(CodegenJavaBean bean, CodegenInfo info, IndexedCodeWriter codeWriter) throws IOException {
        JCodeModel codeModel = new JCodeModel();

        SchemaMapper schemaMapper = new SchemaMapper(
                new JaxRsRuleFactory(config, new Jackson2Annotator(config), new SchemaStore() {
                    @Override
                    public Schema create(Schema parent, String path, String refFragmentPathDelimiters) {
                        String beanClassname = schemaRefToFQCN(path);
                        for (CodegenJavaBean cgBean : info.getBeans()) {
                            String cgBeanFQCN = cgBean.getPackage() + "." + StringUtils.capitalize(cgBean.getName());
                            if (beanClassname.equals(cgBeanFQCN)) {
                                Schema schema = new Schema(classnameToUri(beanClassname), cgBean.get$schema(), null);
                                JType jclass = codeModel._getClass(beanClassname);
                                if (jclass == null) {
                                    jclass = codeModel.directClass(beanClassname);
                                }
                                schema.setJavaType(jclass);
                                return schema;
                            }
                        }
                        // TODO if we get here, we probably want to return an empty schema
                        return super.create(parent, path, refFragmentPathDelimiters);
                    }
                }),
                new SchemaGenerator());
        String source = mapper.writeValueAsString(bean.get$schema());
        schemaMapper.generate(codeModel, bean.getName(), bean.getPackage(), source);
        codeModel.build(codeWriter);

        String fqcn = bean.getPackage() + "." + bean.getName();
        codeWriter.indexBean(fqcn, bean);
    }

    protected URL getResource(String name) {
        return getClass().getResource(getResourceName(name));
    }

    protected String getResourceName(String name) {
        return "_" + getClass().getSimpleName() + "/" + name;
    }

    protected URI classnameToUri(String path) {
        return URI.create(path.replace('.', '/') + ".java");
    }

    protected String schemaRefToFQCN(String path) {
        return CodegenUtil.schemaRefToFQCN(document, path, this.settings.javaPackage + ".beans");
    }

    protected String javaPackageToZipPath(String javaPackage) {
        return (settings.isMavenFileStructure() ? "src/main/java/" : "") + javaPackageToPath(javaPackage);
    }

    private static String javaPackageToPath(String javaPackage) {
        return javaPackage.replaceAll("[^A-Za-z0-9.]", "").replace('.', '/') + "/";
    }

    protected static String paramNameToJavaArgName(String paramName) {
        if (paramName == null) {
            return null;
        }
        String[] split = paramName.replaceAll("[^a-zA-Z0-9_]", "_").split("_");
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for (String term : split) {
            if (term.trim().length() == 0) {
                continue;
            }
            if (first) {
                builder.append(decapitalize(term));
                first = false;
            } else {
                builder.append(capitalize(term));
            }
        }
        String rval = builder.toString();
        if (!SourceVersion.isName(rval)) {
            rval = "_" + rval;
        }
        return rval;
    }

    private static String capitalize(String term) {
        if (term.length() == 1) {
            return term.toUpperCase();
        }
        return term.substring(0, 1).toUpperCase() + term.substring(1);
    }

    private static String decapitalize(String term) {
        if (term.length() == 1) {
            return term.toLowerCase();
        }
        return term.substring(0, 1).toLowerCase() + term.substring(1);
    }

    /**
     * @return the updateOnly
     */
    public boolean isUpdateOnly() {
        return updateOnly;
    }

    /**
     * @return the settings
     */
    public JaxRsProjectSettings getSettings() {
        return this.settings;
    }

    /**
     * @param updateOnly the updateOnly to set
     */
    public void setUpdateOnly(boolean updateOnly) {
        this.updateOnly = updateOnly;
    }

    public static class JaxRsRuleFactory extends RuleFactory {

        /**
         * Constructor.
         */
        public JaxRsRuleFactory(GenerationConfig generationConfig, Annotator annotator, SchemaStore schemaStore) {
            super(generationConfig, annotator, schemaStore);
        }

        /**
         * @see org.jsonschema2pojo.rules.RuleFactory#getEnumRule()
         */
        @Override
        public Rule<JClassContainer, JType> getEnumRule() {
            return new JaxRsEnumRule(this);
        }
    }

}
