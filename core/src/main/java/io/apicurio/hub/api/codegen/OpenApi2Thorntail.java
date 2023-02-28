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

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import io.apicurio.datamodels.Library;
import io.apicurio.datamodels.core.util.VisitorUtil;
import io.apicurio.datamodels.core.visitors.TraverserDirection;
import io.apicurio.hub.api.codegen.beans.CodegenJavaArgument;
import io.apicurio.hub.api.codegen.beans.CodegenJavaBean;
import io.apicurio.hub.api.codegen.beans.CodegenJavaInterface;
import io.apicurio.hub.api.codegen.beans.CodegenJavaMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import io.apicurio.hub.api.codegen.jaxrs.CodegenTarget;
import io.apicurio.hub.api.codegen.jaxrs.InterfacesVisitor;
import io.apicurio.hub.api.codegen.jaxrs.OpenApi2CodegenVisitor;
import org.apache.commons.io.IOUtils;

import io.apicurio.hub.api.codegen.beans.CodegenInfo;
import org.apache.commons.lang.StringUtils;

import javax.lang.model.element.Modifier;


/**
 * Class used to generate a Thorntail JAX-RS project from an OpenAPI document.
 * 
 * @author eric.wittmann@gmail.com
 */
public class OpenApi2Thorntail extends OpenApi2JaxRs {

    /**
     * Constructor.
     */
    public OpenApi2Thorntail() {
        super();
    }
    
    /**
     * @see io.apicurio.hub.api.codegen.OpenApi2JaxRs#generateAll(io.apicurio.hub.api.codegen.beans.CodegenInfo, java.lang.StringBuilder, java.util.zip.ZipOutputStream)
     */
    @Override
    protected void generateAll(CodegenInfo info, StringBuilder log, ZipOutputStream zipOutput)
            throws IOException {
        super.generateAll(info, log, zipOutput);
        if (!this.isUpdateOnly()) {
            log.append("Generating Dockerfile\r\n");
            zipOutput.putNextEntry(new ZipEntry("Dockerfile"));
            zipOutput.write(generateDockerfile().getBytes());
            zipOutput.closeEntry();

            log.append("Generating openshift-template.yml\r\n");
            zipOutput.putNextEntry(new ZipEntry("openshift-template.yml"));
            zipOutput.write(generateOpenshiftTemplate().getBytes());
            zipOutput.closeEntry();

            log.append("Generating src/main/resources/META-INF/microprofile-config.properties\r\n");
            zipOutput.putNextEntry(new ZipEntry("src/main/resources/META-INF/microprofile-config.properties"));
            zipOutput.write(generateMicroprofileConfigProperties().getBytes());
            zipOutput.closeEntry();
        }
    }

    /**
     * Generates the JaxRsApplication java class.
     */
    @Override
    protected String generateJaxRsApplication() throws IOException {
        TypeSpec jaxRsApp = TypeSpec.classBuilder(ClassName.get(this.settings.javaPackage, "JaxRsApplication"))
                .addModifiers(Modifier.PUBLIC)
                .superclass(ClassName.get("javax.ws.rs.core", "Application"))
                .addAnnotation(ClassName.get("javax.enterprise.context", "ApplicationScoped"))
                .addAnnotation(AnnotationSpec.builder(ClassName.get("javax.ws.rs", "ApplicationPath"))
                        .addMember("value", "$S", "/")
                        .build())
                .addJavadoc("The JAX-RS application.\n")
                .build();
        JavaFile javaFile = JavaFile.builder(this.settings.javaPackage, jaxRsApp).skipJavaLangImports(true).build();
        return javaFile.toString();
    }

    /**
     * Generates a Jax-rs interface from the given codegen information.
     * @param info
     * @param _interface
     */
    @Override
    protected String generateJavaInterface(CodegenInfo info, CodegenJavaInterface _interface) {
        // Create the JAX-RS interface spec itself.
        TypeSpec.Builder interfaceBuilder = TypeSpec
                .interfaceBuilder(ClassName.get(_interface.getPackage(), _interface.getName()));
        String jaxRsPath = info.getContextRoot() + _interface.getPath();
        interfaceBuilder.addModifiers(Modifier.PUBLIC)
                .addAnnotation(AnnotationSpec.builder(Path.class).addMember("value", "$S", jaxRsPath).build())
                .addJavadoc("A JAX-RS interface.  An implementation of this interface must be provided.\n");

        // Add specs for all the methods.
        for (CodegenJavaMethod cgMethod : _interface.getMethods()) {
            com.squareup.javapoet.MethodSpec.Builder methodBuilder = MethodSpec.methodBuilder(cgMethod.getName());
            methodBuilder.addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT);
            // The @Path annotation.
            if (cgMethod.getPath() != null) {
                methodBuilder.addAnnotation(AnnotationSpec.builder(Path.class).addMember("value", "$S", cgMethod.getPath()).build());
            }
            // The @GET, @PUT, @POST, etc annotation
            methodBuilder.addAnnotation(AnnotationSpec.builder(ClassName.get("javax.ws.rs", cgMethod.getMethod().toUpperCase())).build());
            // The @Produces annotation
            if (cgMethod.getProduces() != null && !cgMethod.getProduces().isEmpty()) {
                methodBuilder.addAnnotation(AnnotationSpec.builder(Produces.class)
                        .addMember("value", "$L", toStringArrayLiteral(cgMethod.getProduces())).build());
            }
            // The @Consumes annotation
            if (cgMethod.getConsumes() != null && !cgMethod.getConsumes().isEmpty()) {
                methodBuilder.addAnnotation(AnnotationSpec.builder(Consumes.class)
                        .addMember("value", "$L", toStringArrayLiteral(cgMethod.getConsumes())).build());
            }
            // The method return type.
            if (cgMethod.getReturn() != null) {
                TypeName returnType = generateTypeName(cgMethod.getReturn().getCollection(),
                        cgMethod.getReturn().getType(), cgMethod.getReturn().getFormat(), true,
                        ClassName.get("javax.ws.rs.core", "Response"));
                if (getSettings().reactive || cgMethod.isAsync()) {
                    returnType = generateReactiveTypeName(returnType);
                }
                methodBuilder.returns(returnType);
            }

            // The method arguments.
            if (cgMethod.getArguments() != null && !cgMethod.getArguments().isEmpty()) {
                for (CodegenJavaArgument cgArgument : cgMethod.getArguments()) {
                    TypeName defaultParamType = ClassName.OBJECT;
                    if (cgArgument.getIn().equals("body")) {
                        defaultParamType = ClassName.get("java.io", "InputStream");
                    }
                    TypeName paramType = generateTypeName(cgArgument.getCollection(), cgArgument.getType(),
                            cgArgument.getFormat(), cgArgument.getRequired(), defaultParamType);
                    if (cgArgument.getTypeSignature() != null) {
                        // TODO try to find a re-usable data type that matches the type signature
                    }
                    com.squareup.javapoet.ParameterSpec.Builder paramBuilder = ParameterSpec.builder(paramType,
                            paramNameToJavaArgName(cgArgument.getName()));
                    if (cgArgument.getIn().equals("path")) {
                        paramBuilder.addAnnotation(AnnotationSpec.builder(PathParam.class)
                                .addMember("value", "$S", cgArgument.getName()).build());
                    }
                    if (cgArgument.getIn().equals("query")) {
                        paramBuilder.addAnnotation(AnnotationSpec.builder(QueryParam.class)
                                .addMember("value", "$S", cgArgument.getName()).build());
                    }
                    if (cgArgument.getIn().equals("header")) {
                        paramBuilder.addAnnotation(AnnotationSpec.builder(HeaderParam.class)
                                .addMember("value", "$S", cgArgument.getName()).build());
                    }
                    methodBuilder.addParameter(paramBuilder.build());
                }
            }

            // TODO:: error responses (4xx and 5xx)
            // Should errors be modeled in some way?  JAX-RS has a few ways to handle them.  I'm inclined to
            // not generate anything in the interface for error responses.

            // Javadoc
            if (cgMethod.getDescription() != null) {
                methodBuilder.addJavadoc(cgMethod.getDescription());
                methodBuilder.addJavadoc("\n");
            }

            interfaceBuilder.addMethod(methodBuilder.build());
        }

        TypeSpec jaxRsInterface = interfaceBuilder.build();

        JavaFile javaFile = JavaFile.builder(_interface.getPackage(), jaxRsInterface).skipJavaLangImports(true).build();
        return javaFile.toString();
    }

    @Override
    protected CodegenInfo getInfoFromApiDoc() throws IOException {
        document = Library.readDocumentFromJSONString(openApiDoc);

        // Pre-process the document
        document = preProcess(document);

        // Figure out the breakdown of the interfaces.
        InterfacesVisitor iVisitor = new InterfacesVisitor();
        VisitorUtil.visitTree(document, iVisitor, TraverserDirection.down);

        // Then generate the CodegenInfo object.
        OpenApi2CodegenVisitor cgVisitor = new OpenApi2CodegenVisitor(this.settings.javaPackage, iVisitor.getInterfaces(), CodegenTarget.THORNTAIL);
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

    /**
     * Generates the Dockerfile.
     */
    private String generateDockerfile() throws IOException {
        String template = IOUtils.toString(getResource("Dockerfile"), Charset.forName("UTF-8"));
        return template.replace("$ARTIFACT_ID$", this.getSettings().artifactId);
    }

    /**
     * Generates the openshift-template.yml file.
     */
    private String generateOpenshiftTemplate() throws IOException {
        String template = IOUtils.toString(getResource("openshift-template.yml"), Charset.forName("UTF-8"));
        return template.replace("$ARTIFACT_ID$", this.getSettings().artifactId);
    }

    /**
     * Generates the microprofile-config.properties file to include in the generated project.
     */
    private String generateMicroprofileConfigProperties() throws IOException {
        String template = IOUtils.toString(getResource("microprofile-config.properties"), Charset.forName("UTF-8"));
        return template;
    }

}
