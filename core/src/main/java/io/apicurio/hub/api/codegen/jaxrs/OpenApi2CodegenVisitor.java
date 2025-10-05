/*
 * Copyright 2019 Red Hat
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

package io.apicurio.hub.api.codegen.jaxrs;

import static io.apicurio.hub.api.codegen.util.CodegenUtil.containsValue;
import static io.apicurio.hub.api.codegen.util.CodegenUtil.toStringList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.apicurio.datamodels.Library;
import io.apicurio.datamodels.models.Document;
import io.apicurio.datamodels.models.Extensible;
import io.apicurio.datamodels.models.Info;
import io.apicurio.datamodels.models.Node;
import io.apicurio.datamodels.models.Operation;
import io.apicurio.datamodels.models.Parameter;
import io.apicurio.datamodels.models.Schema;
import io.apicurio.datamodels.models.openapi.OpenApiMediaType;
import io.apicurio.datamodels.models.openapi.OpenApiOperation;
import io.apicurio.datamodels.models.openapi.OpenApiParameter;
import io.apicurio.datamodels.models.openapi.OpenApiParametersParent;
import io.apicurio.datamodels.models.openapi.OpenApiPathItem;
import io.apicurio.datamodels.models.openapi.OpenApiRequestBody;
import io.apicurio.datamodels.models.openapi.OpenApiResponse;
import io.apicurio.datamodels.models.openapi.OpenApiSchema;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31MediaType;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31Parameter;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31Response;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31Schema;
import io.apicurio.datamodels.util.NodeUtil;
import io.apicurio.hub.api.codegen.CodegenExtensions;
import io.apicurio.hub.api.codegen.JaxRsProjectSettings;
import io.apicurio.hub.api.codegen.beans.CodegenBeanAnnotationDirective;
import io.apicurio.hub.api.codegen.beans.CodegenInfo;
import io.apicurio.hub.api.codegen.beans.CodegenJavaArgument;
import io.apicurio.hub.api.codegen.beans.CodegenJavaBean;
import io.apicurio.hub.api.codegen.beans.CodegenJavaInterface;
import io.apicurio.hub.api.codegen.beans.CodegenJavaMethod;
import io.apicurio.hub.api.codegen.beans.CodegenJavaReturn;
import io.apicurio.hub.api.codegen.beans.CodegenJavaSchema;
import io.apicurio.hub.api.codegen.util.CodegenUtil;
import io.apicurio.hub.api.codegen.util.SchemaSigner;

/**
 * Visitor used to create a Codegen Info object from a OpenAPI document.
 * @author eric.wittmann@gmail.com
 */
public class OpenApi2CodegenVisitor extends TraversingOpenApi31VisitorAdapter {

    private ObjectMapper mapper = new ObjectMapper();

    private JaxRsProjectSettings settings;
    private Map<String, String> interfacesIndex = new HashMap<>();
    private CodegenInfo codegenInfo = new CodegenInfo();

    private CodegenJavaInterface _currentInterface;
    private List<CodegenJavaMethod> _currentMethods;

    private int _methodCounter = 1;

    private boolean _processPathItemParams = false;

    private String currentPath;

    /**
     * Constructor.
     * @param settings
     * @param interfaces
     * @param target
     */
    public OpenApi2CodegenVisitor(JaxRsProjectSettings settings, List<InterfaceInfo> interfaces, CodegenTarget target) {
        this.settings = settings;

        this.codegenInfo.setName("Generated API");
        this.codegenInfo.setVersion("1.0.0");
        this.codegenInfo.setInterfaces(new ArrayList<>());
        this.codegenInfo.setBeans(new ArrayList<>());

        for (InterfaceInfo iface : interfaces) {
            for (String path : iface.paths) {
                this.interfacesIndex.put(path, iface.name);
            }
        }
    }

    /**
     * Gets the CodegenInfo object that was created by the visitor.
     */
    public CodegenInfo getCodegenInfo() {
        return this.codegenInfo;
    }

    /**
     * Creates a unique signature for the given schema.  The signature is used to determine whether two schemas
     * are the same.
     * @param node
     */
    private static String createSignature(OpenApi31Schema node) {
        SchemaSigner signer = new SchemaSigner();
        Library.visitNode(node, signer);
        return signer.getSignature();
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitDocument(io.apicurio.datamodels.models.Document)
     */
    @Override
    public void visitDocument(Document node) {
        JsonNode codegen = CodegenUtil.getExtension((Extensible) node, CodegenExtensions.CODEGEN);
        try {
            if (codegen != null) {
                // Extract some configuration from the "x-codegen" root extension property
                processCodegenConfig(mapper.readerFor(Map.class).readValue(codegen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitInfo(io.apicurio.datamodels.models.Info)
     */
    @Override
    public void visitInfo(Info node) {
        this.codegenInfo.setName(node.getTitle());
        if (node.getDescription() != null) {
            this.codegenInfo.setDescription(node.getDescription());
        }
        this.codegenInfo.setVersion(node.getVersion());
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitPathItem(io.apicurio.datamodels.models.openapi.OpenApiPathItem)
     */
    @Override
    public void visitPathItem(OpenApiPathItem node) {
        currentPath = getPathTemplate(node);
        CodegenJavaInterface cgInterface = this.getOrCreateInterface(currentPath);
        this._currentInterface = cgInterface;
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitOperation(io.apicurio.datamodels.models.Operation)
     */
    @Override
    public void visitOperation(Operation node) {
        OpenApiOperation op = (OpenApiOperation) node;
        CodegenJavaMethod method = new CodegenJavaMethod();
        method.setName(this.methodName(op));
        method.setPath(this.methodPath(op));
        method.setMethod(getOperationMethod(op));
        method.setProduces(new HashSet<>());
        method.setConsumes(new HashSet<>());
        method.setArguments(new ArrayList<>());
        if (node.getDescription() != null) {
            method.setDescription(node.getDescription());
        }
        if (node.getSummary() != null) {
            method.setSummary(node.getSummary());
        }

        if (((OpenApiOperation) node).getOperationId() != null) {
            method.setOperationId(((OpenApiOperation) node).getOperationId());
        }

        Boolean async = null;
        JsonNode asyncExt = CodegenUtil.getExtension((Extensible) node, CodegenExtensions.ASYNC);
        if (asyncExt != null) {
            async = asyncExt.asBoolean();
        }
        method.setAsync(async);

        this._currentMethods = new ArrayList<>();
        this._currentMethods.add(method);
        this._currentInterface.getMethods().add(method);

        // Be sure to process path and query parameters found on the parent!
        this._processPathItemParams = true;
        List<OpenApiParameter> parentParams = ((OpenApiParametersParent) node.parent()).getParameters();
        if (parentParams != null && parentParams.size() > 0) {
            for (OpenApiParameter parentParam : parentParams) {
                parentParam.accept(this);
            }
        }
        this._processPathItemParams = false;
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitParameter(io.apicurio.datamodels.models.Parameter)
     */
    @Override
    public void visitParameter(Parameter node) {
        // Skip processing of parameter definitions (found in /components/parameters)
        if (NodeUtil.isDefinition(node)) {
            return;
        }

        // Skip processing of the parameter if it is defined at the path level.
        if (!this._processPathItemParams && this.isPathItem(node.parent())) {
            return;
        }

        OpenApi31Parameter param = (OpenApi31Parameter) node;

        CodegenJavaArgument cgArgument = new CodegenJavaArgument();
        cgArgument.setName(param.getName());
        cgArgument.setIn(param.getIn());
        cgArgument.setRequired(Boolean.TRUE.equals(param.isRequired()));

        this._currentMethods.forEach(method -> method.getArguments().add(cgArgument));

        /*
         * Attempt to apply the schema from the `content` section's first media type to this
         * parameter. If no `content` section exists or the first media type's schema is not
         * present, map the schema attributes from the `schema` directly set on the parameter
         * in the OpenAPI, if present.
         */
        Optional.ofNullable(param.getContent())
            .map(Map::values) // gives the collection of media types
            .map(Collection::stream)
            .flatMap(Stream::findFirst)
            .map(OpenApi31MediaType::getSchema)
            .map(OpenApi31Schema.class::cast)
            .or(() -> Optional.ofNullable((OpenApi31Schema) ((OpenApi31Parameter) node).getSchema()))
            .ifPresent(schema -> {
                setSchemaProperties(cgArgument, schema);
                cgArgument.setTypeSignature(createSignature(schema));
            });

        cgArgument.setAnnotations(annotations(CodegenUtil.getExtension(param, CodegenExtensions.ANNOTATIONS)));
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitRequestBody(io.apicurio.datamodels.models.openapi.OpenApiRequestBody)
     */
    @Override
    public void visitRequestBody(OpenApiRequestBody node) {
        // Only process inline request bodies.
        if (NodeUtil.isDefinition(node)) {
            return;
        }

        Map<String, OpenApiMediaType> content = node.getContent();
        if (content == null) {
            content = new HashMap<>();
        }

        Map<CodegenJavaReturn, Set<String>> allReturnTypes = new LinkedHashMap<>();
        if (!content.isEmpty()) {
            content.entrySet().forEach(entry -> {
                String name = entry.getKey();
                OpenApiMediaType mediaType = entry.getValue();
                CodegenJavaReturn cgReturn = new CodegenJavaReturn();
                if (mediaType.getSchema() != null) {
                    setSchemaProperties(cgReturn, (OpenApi31Schema) mediaType.getSchema());
                }
                allReturnTypes.merge(cgReturn, Collections.singleton(name), (set1, set2) -> {
                    Set<String> merged = new HashSet<>();
                    merged.addAll(set1);
                    merged.addAll(set2);
                    return merged;
                });
            });
        }

        // If the set of return types is > 1 then we need to generate a java method for each one.  This means
        // duplicating the current cgMethod.

        if (!allReturnTypes.isEmpty()) {
            CodegenJavaMethod methodTemplate = this._currentMethods.get(0);
            List<CodegenJavaMethod> methods = allReturnTypes.entrySet().stream().map(entry -> {
                CodegenJavaReturn returnType = entry.getKey();
                Set<String> types = entry.getValue();

                CodegenJavaMethod clonedMethod = methodTemplate.clone();
                clonedMethod.getConsumes().addAll(types);

                CodegenJavaArgument cgArgument = new CodegenJavaArgument();
                cgArgument.setName("data");
                cgArgument.setIn("body");
                cgArgument.setRequired(true);

                if (returnType.getCollection() != null) { cgArgument.setCollection(returnType.getCollection()); }
                if (returnType.getType() != null) { cgArgument.setType(returnType.getType()); }
                if (returnType.getFormat() != null) { cgArgument.setFormat(returnType.getFormat()); }

                clonedMethod.getArguments().add(cgArgument);

                return clonedMethod;
            }).collect(Collectors.toList());
            this._currentInterface.getMethods().remove(methodTemplate);
            this._currentInterface.getMethods().addAll(methods);
            this._currentMethods = methods;
        }
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitResponse(io.apicurio.datamodels.models.openapi.OpenApiResponse)
     */
    @Override
    public void visitResponse(OpenApiResponse node) {
        // Skip processing of response definitions (defined in /components/responses)
        if (NodeUtil.isDefinition(node)) {
            return;
        }

        String statusCode = getMappedNodeName(node);
        // Note: if there are multiple 2xx responses, only the first one will
        // become the method return value.
        if (statusCode != null && statusCode.indexOf("2") == 0 && this._currentMethods.get(0).getReturn() == null) {
            OpenApi31Response response = (OpenApi31Response) node;
            Map<String, OpenApi31MediaType> content = response.getContent();
            if (content == null) {
                content = new HashMap<>();
            }

            // TODO if there are multiple response media types, handle it somehow - probably by returning a JAX-RS Response object
            if (!content.isEmpty()) {
                Entry<String, OpenApi31MediaType> firstContent = content.entrySet().iterator().next();
                OpenApi31MediaType mediaType = firstContent.getValue();

                JsonNode returnTypeExt = CodegenUtil.getExtension(mediaType, CodegenExtensions.RETURN_TYPE);
                CodegenJavaReturn cgReturn = null;
                if (returnTypeExt != null) {
                    String returnType = returnTypeExt.asText();
                    CodegenJavaReturn customReturn = new CodegenJavaReturn();
                    customReturn.setType(returnType);
                    cgReturn = customReturn;
                } else if (mediaType.getSchema() != null) {
                    cgReturn = new CodegenJavaReturn();
                    setSchemaProperties(cgReturn, (OpenApi31Schema) mediaType.getSchema());
                }

                // If no return was created, it was because we couldn't figure it out from the
                // schema (likely no schema declared) so we should create something to
                // indicate that we DO want a return value, but we don't know what it is.
                if (cgReturn == null) {
                    CodegenJavaReturn unknownReturn = new CodegenJavaReturn();
                    unknownReturn.setType("jakarta.ws.rs.core.Response");
                    cgReturn = unknownReturn;
                }

                final CodegenJavaReturn _return = cgReturn;
                this._currentMethods.forEach(_currentMethod -> _currentMethod.setReturn(_return));
            }
            // Push all of the media types onto the "produces" array for the method.
            content.entrySet().forEach(entry -> {
                this._currentMethods.forEach(_currentMethod -> _currentMethod.getProduces().add(entry.getKey()));
            });
        }
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitSchema(io.apicurio.datamodels.models.Schema)
     */
    @Override
    public void visitSchema(Schema node) {
        if (NodeUtil.isDefinition(node)) {
            String name = getMappedNodeName(node);
            OpenApiSchema schema = (OpenApiSchema) node;

            CodegenJavaBean bean = new CodegenJavaBean();
            bean.setName(name);
            bean.setPackage(CodegenUtil.schemaToPackageName(schema, this.settings.getJavaPackage() + ".beans"));
            bean.set$schema(Library.writeNode(schema));
            bean.setSignature(createSignature((OpenApi31Schema) schema));
            bean.setAnnotations(annotations(CodegenUtil.getExtension((Extensible) schema, CodegenExtensions.ANNOTATIONS)));

            this.codegenInfo.getBeans().add(bean);
        }
    }

    private void processCodegenConfig(Map<String, Object> codegen) {
        // Process 'bean-annotations'
        List<?> annotations = (List<?>) codegen.get("bean-annotations");
        if (annotations != null) {
            this.codegenInfo.setBeanAnnotations(annotations(annotations));
        }

        // Process 'contextRoot'
        String cr = (String) codegen.get("contextRoot");
        if (cr != null) {
            this.codegenInfo.setContextRoot(cr);
        }

        //process suppress date-time formats
        Boolean suppressDateTimeFormat = (Boolean) codegen.get("suppress-date-time-formatting");
        if (suppressDateTimeFormat != null) {
            this.codegenInfo.setSuppressDateTimeFormats(suppressDateTimeFormat);
        }
    }

    /**
     * Extracts the additional annotations the bean should have added to it from the x-codegen-annotations
     * extension point.
     * @param extension
     */
    private List<CodegenBeanAnnotationDirective> annotations(JsonNode extension) {
        try {
            if (extension != null && extension.isArray()) {
                List<?> annotationExtensions = mapper.readerFor(List.class).readValue(extension);
                return annotations(annotationExtensions);
            } else {
                return Collections.emptyList();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private static List<CodegenBeanAnnotationDirective> annotations(List<?> annotationExtensions) {
        return annotationExtensions.stream().map(annotationExtension -> {
            if (annotationExtension instanceof String) {
                CodegenBeanAnnotationDirective directive = new CodegenBeanAnnotationDirective();
                directive.setAnnotation((String) annotationExtension);
                return directive;
            } else if (annotationExtension instanceof Map) {
                Map<String, Object> aeMap = (Map<String, Object>) annotationExtension;
                String annotation = (String) aeMap.get("annotation");
                Boolean excludeEnums = (Boolean) aeMap.get("excludeEnums");
                if (annotation == null) {
                    return null;
                }

                CodegenBeanAnnotationDirective directive = new CodegenBeanAnnotationDirective();
                directive.setAnnotation(annotation);
                if (excludeEnums != null) {
                    directive.setExcludeEnums(excludeEnums);
                }
                return directive;
            } else {
                return null;
            }
        }).filter(item -> item != null).collect(Collectors.toUnmodifiableList());
    }

    private CodegenJavaInterface getOrCreateInterface(String path) {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        String interfaceName = this.interfacesIndex.get(path);
        for (CodegenJavaInterface cgInterface : this.codegenInfo.getInterfaces()) {
            if (cgInterface.getName().equals(interfaceName)) {
                return cgInterface;
            }
        }
        String ifacePath = "/";
        if (!"Root".equals(interfaceName) && !"RootResource".equals(interfaceName)) {
            ifacePath = "/" + path.split("/")[1];
        }
        CodegenJavaInterface cgInterface = new CodegenJavaInterface();
        cgInterface.setName(interfaceName);
        cgInterface.setPackage(this.settings.getJavaPackage());
        cgInterface.setPath(ifacePath);
        cgInterface.setMethods(new ArrayList<>());
        this.codegenInfo.getInterfaces().add(cgInterface);
        return cgInterface;
    }

    private String methodName(OpenApiOperation operation) {
        if (operation.getOperationId() != null && operation.getOperationId().length() > 0) {
            return this.operationIdToMethodName(operation.getOperationId());
        }
        if (operation.getSummary() != null && operation.getSummary().length() > 0) {
            String[] nameSegments = operation.getSummary().split(" ");
            StringBuilder builder = new StringBuilder();
            for (String segment : nameSegments) {
                String sanitized = segment.replaceAll("\\W", "");
                builder.append(capitalize(sanitized));
            }
            String cname = builder.toString();
            if (cname.trim().length() > 0) {
                return decapitalize(builder.toString());
            }
        }
        return "generatedMethod" + this._methodCounter++;
    }

    private String operationIdToMethodName(String operationId) {
        return operationId.replaceAll("[^a-zA-Z0-9_]", "_");
    }

    private String methodPath(OpenApiOperation operation) {
        String path = currentPath;
        if (path.equals(this._currentInterface.getPath())) {
            return null;
        }
        path = path.substring(this._currentInterface.getPath().length());
        if ("/".equals(path)) {
            return null;
        }
        return path;
    }

    private void setSchemaProperties(CodegenJavaSchema target, OpenApi31Schema schema) {
        if (schema == null) {
            return;
        }

        target.setType((List<String>) null);
        String $ref = schema.get$ref();

        if ($ref != null) {
            target.setType(this.typeFromSchemaRef((Document) schema.root(), $ref));
        } else if (containsValue(schema.getType(), "array")) {
            if (schema.getItems() != null) {
                setSchemaProperties(target, schema.getItems());
            }

            setIfPresent(schema::getMaxItems, value -> target.setMaxItems(value.longValue()));
            setIfPresent(schema::getMinItems, value -> target.setMinItems(value.longValue()));

            if (Boolean.TRUE.equals(schema.isUniqueItems())) {
                target.setCollection("set");
            } else {
                target.setCollection("list");
            }
        } else if (containsValue(schema.getType(), "object")) {
            setIfPresent(() -> toStringList(schema.getType()), target::setType);
            setIfPresent(schema::getFormat, target::setFormat);
            // TODO: Consider representing object as map
            //if (schema.getAdditionalProperties() != null && schema.getAdditionalProperties().isSchema()) {
            //    setSchemaProperties(target, (OpenApi31Schema) schema.getAdditionalProperties().asSchema());
            //}
            //
            //setIfPresent(schema::isNullable, target::setNullable);
            //setIfPresent(schema::getMaxProperties, value -> target.setMaxProperties(value.longValue()));
            //setIfPresent(schema::getMinProperties, value -> target.setMinProperties(value.longValue()));
            //target.setCollection("map");
        } else if (containsValue(schema.getType(), "string")) {
            setIfPresent(() -> toStringList(schema.getType()), target::setType);
            setIfPresent(schema::getFormat, target::setFormat);
            setIfPresent(schema::getMaxLength, value -> target.setMaxLength(value.longValue()));
            setIfPresent(schema::getMinLength, value -> target.setMinLength(value.longValue()));
            setIfPresent(schema::getPattern, target::setPattern);
        } else if (containsValue(schema.getType(), "integer", "number")) {
            setIfPresent(() -> toStringList(schema.getType()), target::setType);
            setIfPresent(schema::getFormat, target::setFormat);

            if (schema.getExclusiveMaximum() != null) {
                target.setMaximum(schema.getExclusiveMaximum());
                target.setExclusiveMaximum(true);
            } else {
                target.setMaximum(schema.getMaximum());
                target.setExclusiveMaximum(false);
            }

            if (schema.getExclusiveMinimum() != null) {
                target.setMinimum(schema.getExclusiveMinimum());
                target.setExclusiveMinimum(true);
            } else {
                target.setMinimum(schema.getMinimum());
                target.setExclusiveMinimum(false);
            }
        } else {
            setIfPresent(() -> toStringList(schema.getType()), target::setType);
            setIfPresent(schema::getFormat, target::setFormat);
        }

        setIfPresent(schema::getDefault, defaultValue -> {
            if (defaultValue.isValueNode()) {
                target.setDefaultValue(defaultValue.asText());
            }
        });
    }

    private <T> void setIfPresent(Supplier<T> source, Consumer<T> target) {
        T value = source.get();

        if (value != null) {
            target.accept(value);
        }
    }

    private List<String> typeFromSchemaRef(Document document, String schemaRef) {
        return List.of(CodegenUtil.schemaRefToFQCN(settings, document, schemaRef, this.settings.getJavaPackage() + ".beans"));
    }

    private boolean isPathItem(Node node) {
        PathItemDetectionVisitor viz = new PathItemDetectionVisitor();
        node.accept(viz);
        return viz.isPathItem;
    }

    /**
     * Capitalizes a word.
     * @param word
     */
    private String capitalize(String word) {
        if (word == null || word.trim().length() == 0) {
            return "";
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    /**
     * De-capitalizes a word.
     * @param word
     */
    private String decapitalize(String word) {
        if (word == null || word.trim().length() == 0) {
            return "";
        }
        return word.substring(0, 1).toLowerCase() + word.substring(1);
    }

}
