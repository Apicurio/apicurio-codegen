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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.apicurio.datamodels.Library;
import io.apicurio.datamodels.models.Document;
import io.apicurio.datamodels.models.Extensible;
import io.apicurio.datamodels.models.Info;
import io.apicurio.datamodels.models.Node;
import io.apicurio.datamodels.models.Operation;
import io.apicurio.datamodels.models.Parameter;
import io.apicurio.datamodels.models.Referenceable;
import io.apicurio.datamodels.models.Schema;
import io.apicurio.datamodels.models.openapi.OpenApiMediaType;
import io.apicurio.datamodels.models.openapi.OpenApiOperation;
import io.apicurio.datamodels.models.openapi.OpenApiParameter;
import io.apicurio.datamodels.models.openapi.OpenApiPathItem;
import io.apicurio.datamodels.models.openapi.OpenApiRequestBody;
import io.apicurio.datamodels.models.openapi.OpenApiResponse;
import io.apicurio.datamodels.models.openapi.OpenApiSchema;
import io.apicurio.datamodels.models.openapi.v30.OpenApi30MediaType;
import io.apicurio.datamodels.models.openapi.v30.OpenApi30Parameter;
import io.apicurio.datamodels.models.openapi.v30.OpenApi30Response;
import io.apicurio.datamodels.models.openapi.v30.OpenApi30Schema;
import io.apicurio.datamodels.util.NodeUtil;
import io.apicurio.hub.api.codegen.CodegenExtensions;
import io.apicurio.hub.api.codegen.beans.CodegenBeanAnnotationDirective;
import io.apicurio.hub.api.codegen.beans.CodegenInfo;
import io.apicurio.hub.api.codegen.beans.CodegenJavaArgument;
import io.apicurio.hub.api.codegen.beans.CodegenJavaBean;
import io.apicurio.hub.api.codegen.beans.CodegenJavaInterface;
import io.apicurio.hub.api.codegen.beans.CodegenJavaMethod;
import io.apicurio.hub.api.codegen.beans.CodegenJavaReturn;
import io.apicurio.hub.api.codegen.util.CodegenUtil;
import io.apicurio.hub.api.codegen.util.SchemaSigner;

/**
 * Visitor used to create a Codegen Info object from a OpenAPI document.
 * @author eric.wittmann@gmail.com
 */
public class OpenApi2CodegenVisitor extends TraversingOpenApi30VisitorAdapter {

    private ObjectMapper mapper = new ObjectMapper();

    private String packageName;
    private Map<String, String> interfacesIndex = new HashMap<>();
    private CodegenInfo codegenInfo = new CodegenInfo();

    private CodegenJavaInterface _currentInterface;
    private List<CodegenJavaMethod> _currentMethods;
    private CodegenJavaArgument _currentArgument;

    private int _methodCounter = 1;

    private boolean _processPathItemParams = false;

    private String currentPath;

    /**
     * Constructor.
     * @param packageName
     * @param interfaces
     */
    public OpenApi2CodegenVisitor(String packageName, List<InterfaceInfo> interfaces, CodegenTarget target) {
        this.codegenInfo.setName("Generated API");
        this.codegenInfo.setVersion("1.0.0");
        this.codegenInfo.setInterfaces(new ArrayList<>());
        this.codegenInfo.setBeans(new ArrayList<>());

        this.packageName = packageName;
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
    private static String createSignature(OpenApi30Schema node) {
        SchemaSigner signer = new SchemaSigner();
        Library.visitNode(node, signer);
        return signer.getSignature();
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v30.visitors.OpenApi30VisitorAdapter#visitDocument(io.apicurio.datamodels.core.models.Document)
     */
    @Override
    public void visitDocument(Document node) {
        try {
            JsonNode codegen = CodegenUtil.getExtension((Extensible) node, "x-codegen");
            if (codegen != null) {
                // Extract some configuration from the "x-codegen" root extension property
                processCodegenConfig(mapper.readerFor(Map.class).readValue(codegen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v30.visitors.OpenApi30VisitorAdapter#visitInfo(io.apicurio.datamodels.core.models.common.Info)
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
     * @see io.apicurio.datamodels.models.openapi.v30.visitors.OpenApi30VisitorAdapter#visitPathItem(io.apicurio.datamodels.openapi.models.OpenApiPathItem)
     */
    @Override
    public void visitPathItem(OpenApiPathItem node) {
        currentPath = getPathTemplate(node);
        CodegenJavaInterface cgInterface = this.getOrCreateInterface(currentPath);
        this._currentInterface = cgInterface;
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v30.visitors.OpenApi30VisitorAdapter#visitOperation(io.apicurio.datamodels.core.models.common.Operation)
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
        if (node.getDescription() != null) { method.setDescription(node.getDescription()); }

        boolean async = false;
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
        List<OpenApiParameter> parentParams = ((OpenApiPathItem) node.parent()).getParameters();
        if (parentParams != null && parentParams.size() > 0) {
            for (OpenApiParameter parentParam : parentParams) {
                parentParam.accept(this);
            }
        }
        this._processPathItemParams = false;
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v30.visitors.OpenApi30VisitorAdapter#visitParameter(io.apicurio.datamodels.models.Parameter)
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

        OpenApi30Parameter param = (OpenApi30Parameter) node;

        CodegenJavaArgument cgArgument = new CodegenJavaArgument();
        cgArgument.setName(param.getName());
        cgArgument.setIn(param.getIn());

        this._currentArgument = cgArgument;

        if (param.isRequired() != null) {
            cgArgument.setRequired(param.isRequired());
        }

        this._currentMethods.forEach(method -> method.getArguments().add(cgArgument));

        Map<String,OpenApi30MediaType> content = param.getContent();
        if (content != null && !content.isEmpty()) {
            Collection<OpenApi30MediaType> mediaTypes = content.values();
            OpenApi30MediaType mediaType = mediaTypes.iterator().next();
            CodegenJavaReturn cgReturn = this.returnFromSchema((OpenApi30Schema) mediaType.getSchema());
            if (cgReturn != null) {
                if (cgReturn.getCollection() != null) { this._currentArgument.setCollection(cgReturn.getCollection()); }
                if (cgReturn.getType() != null) { this._currentArgument.setType(cgReturn.getType()); }
                if (cgReturn.getFormat() != null) { this._currentArgument.setFormat(cgReturn.getFormat()); }
                this._currentArgument.setTypeSignature(createSignature((OpenApi30Schema) mediaType.getSchema()));
            }
        } else if (node.getSchema() != null) {
            CodegenJavaReturn cgReturn = this.returnFromSchema((OpenApi30Schema) node.getSchema());
            if (cgReturn != null) {
                if (cgReturn.getCollection() != null) { this._currentArgument.setCollection(cgReturn.getCollection()); }
                if (cgReturn.getType() != null) { this._currentArgument.setType(cgReturn.getType()); }
                if (cgReturn.getFormat() != null) { this._currentArgument.setFormat(cgReturn.getFormat()); }
                this._currentArgument.setTypeSignature(createSignature((OpenApi30Schema) node.getSchema()));
            }
        }
    }

    /**
     * @see io.apicurio.datamodels.models.openapi.v30.visitors.OpenApi30VisitorAdapter#visitRequestBody(io.apicurio.datamodels.models.openapi.OpenApiRequestBody)
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

        Map<CodegenJavaReturn, Set<String>> allReturnTypes = new HashMap<>();
        if (!content.isEmpty()) {
            content.entrySet().forEach(entry -> {
                String name = entry.getKey();
                OpenApiMediaType mediaType = entry.getValue();
                CodegenJavaReturn cgReturn = this.returnFromSchema((OpenApi30Schema) mediaType.getSchema());
                if (cgReturn == null) {
                    cgReturn = new CodegenJavaReturn();
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
     * @see io.apicurio.datamodels.models.openapi.v30.visitors.OpenApi30VisitorAdapter#visitResponse(io.apicurio.datamodels.openapi.models.OpenApiResponse)
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
            OpenApi30Response response = (OpenApi30Response) node;
            Map<String, OpenApi30MediaType> content = response.getContent();
            if (content == null) {
                content = new HashMap<>();
            }

            // TODO if there are multiple response media types, handle it somehow - probably by returning a JAX-RS Response object
            if (!content.isEmpty()) {
                Entry<String, OpenApi30MediaType> firstContent = content.entrySet().iterator().next();
                OpenApi30MediaType mediaType = firstContent.getValue();

                JsonNode returnTypeExt = CodegenUtil.getExtension(mediaType, CodegenExtensions.RETURN_TYPE);
                CodegenJavaReturn cgReturn = null;
                if (returnTypeExt != null) {
                    String returnType = returnTypeExt.asText();
                    CodegenJavaReturn customReturn = new CodegenJavaReturn();
                    customReturn.setType(returnType);
                    cgReturn = customReturn;
                } else {
                    cgReturn = this.returnFromSchema((OpenApi30Schema) mediaType.getSchema());
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

    @Override
    public void visitSchema(Schema node) {
        if (NodeUtil.isDefinition(node)) {
            String name = getMappedNodeName(node);
            OpenApiSchema schema = (OpenApiSchema) node;

            CodegenJavaBean bean = new CodegenJavaBean();
            bean.setName(name);
            bean.setPackage(CodegenUtil.schemaToPackageName(schema, this.packageName + ".beans"));
            bean.set$schema(Library.writeNode(schema));
            bean.setSignature(createSignature((OpenApi30Schema) schema));
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
        cgInterface.setPackage(this.packageName);
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

    private CodegenJavaReturn returnFromSchema(OpenApi30Schema schema) {
        if (schema == null) {
            return null;
        }
        CodegenJavaReturn cgReturn = new CodegenJavaReturn();
        cgReturn.setType(null);
        String $ref = ((Referenceable) schema).get$ref();
        if ($ref != null) {
            cgReturn.setType(this.typeFromSchemaRef((Document) schema.root(), $ref));
        } else if ("array".equals(schema.getType())) {
            cgReturn.setCollection("list");
            OpenApiSchema items = schema.getItems();
            CodegenJavaReturn subReturn = this.returnFromSchema((OpenApi30Schema) items);
            if (subReturn != null && subReturn.getType() != null) {
                cgReturn.setType(subReturn.getType());
            }
            if (subReturn != null && subReturn.getFormat() != null) {
                cgReturn.setFormat(subReturn.getFormat());
            }
        } else {
            if (schema.getType() != null) {
                cgReturn.setType(schema.getType());
            }
            if (schema.getFormat() != null) {
                cgReturn.setFormat(schema.getFormat());
            }
        }
        return cgReturn;
    }

    private String typeFromSchemaRef(Document document, String schemaRef) {
        return CodegenUtil.schemaRefToFQCN(document, schemaRef, this.packageName + ".beans");
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
