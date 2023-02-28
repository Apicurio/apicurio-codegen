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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;

import io.apicurio.datamodels.Library;
import io.apicurio.datamodels.combined.visitors.CombinedVisitorAdapter;
import io.apicurio.datamodels.core.models.Document;
import io.apicurio.datamodels.core.models.DocumentType;
import io.apicurio.datamodels.core.models.Extension;
import io.apicurio.datamodels.core.models.Node;
import io.apicurio.datamodels.core.models.common.IDefinition;
import io.apicurio.datamodels.core.models.common.Info;
import io.apicurio.datamodels.core.models.common.Operation;
import io.apicurio.datamodels.core.models.common.Parameter;
import io.apicurio.datamodels.core.util.VisitorUtil;
import io.apicurio.datamodels.openapi.models.OasOperation;
import io.apicurio.datamodels.openapi.models.OasParameter;
import io.apicurio.datamodels.openapi.models.OasPathItem;
import io.apicurio.datamodels.openapi.models.OasResponse;
import io.apicurio.datamodels.openapi.models.OasSchema;
import io.apicurio.datamodels.openapi.v2.models.Oas20Document;
import io.apicurio.datamodels.openapi.v2.models.Oas20Operation;
import io.apicurio.datamodels.openapi.v2.models.Oas20Parameter;
import io.apicurio.datamodels.openapi.v2.models.Oas20Response;
import io.apicurio.datamodels.openapi.v3.models.Oas30MediaType;
import io.apicurio.datamodels.openapi.v3.models.Oas30Parameter;
import io.apicurio.datamodels.openapi.v3.models.Oas30RequestBody;
import io.apicurio.datamodels.openapi.v3.models.Oas30Response;
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
public class OpenApi2CodegenVisitor extends CombinedVisitorAdapter {

    private String packageName;
    private Map<String, String> interfacesIndex = new HashMap<>();
    private CodegenInfo codegenInfo = new CodegenInfo();

    private CodegenJavaInterface _currentInterface;
    private List<CodegenJavaMethod> _currentMethods;
    private CodegenJavaArgument _currentArgument;
    private CodegenTarget codegenTarget;

    private int _methodCounter = 1;

    private boolean _processPathItemParams = false;

    /**
     * Constructor.
     * @param packageName
     * @param interfaces
     */
    public OpenApi2CodegenVisitor(String packageName, List<InterfaceInfo> interfaces, CodegenTarget target) {
        this.codegenInfo.setName("Thorntail API");
        this.codegenInfo.setVersion("1.0.0");
        this.codegenInfo.setInterfaces(new ArrayList<>());
        this.codegenInfo.setBeans(new ArrayList<>());
        this.codegenTarget = target;

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
    private static String createSignature(OasSchema node) {
        SchemaSigner signer = new SchemaSigner();
        Library.visitNode(node, signer);
        return signer.getSignature();
    }

    /**
     * @see io.apicurio.datamodels.combined.visitors.CombinedVisitorAdapter#visitDocument(io.apicurio.datamodels.core.models.Document)
     */
    @Override
    public void visitDocument(Document node) {
        // Extract some configuration from the "x-codegen" root extension property
        processCodegenConfig(node.getExtension("x-codegen"));
    }

    @SuppressWarnings("unchecked")
    private void processCodegenConfig(Extension extension) {
        if (extension != null && extension.value instanceof Map) {
            Map<String, Object> codegen = (Map<String, Object>) extension.value;
            
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
    }

    /**
     * @see io.apicurio.datamodels.combined.visitors.CombinedVisitorAdapter#visitInfo(io.apicurio.datamodels.core.models.common.Info)
     */
    @Override
    public void visitInfo(Info node) {
        this.codegenInfo.setName(node.title);
        if (node.description != null) {
            this.codegenInfo.setDescription(node.description);
        }
        this.codegenInfo.setVersion(node.version);
    }

    /**
     * @see io.apicurio.datamodels.combined.visitors.CombinedVisitorAdapter#visitPathItem(io.apicurio.datamodels.openapi.models.OasPathItem)
     */
    @Override
    public void visitPathItem(OasPathItem node) {
        String path = node.getPath();
        CodegenJavaInterface cgInterface = this.getOrCreateInterface(path);
        this._currentInterface = cgInterface;
    }

    /**
     * @see io.apicurio.datamodels.combined.visitors.CombinedVisitorAdapter#visitOperation(io.apicurio.datamodels.core.models.common.Operation)
     */
    @Override
    public void visitOperation(Operation node) {
        OasOperation op = (OasOperation) node;
        CodegenJavaMethod method = new CodegenJavaMethod();
        method.setName(this.methodName(op));
        method.setPath(this.methodPath(op));
        method.setMethod(node.getType());
        method.setProduces(new HashSet<>());
        method.setConsumes(new HashSet<>());
        method.setArguments(new ArrayList<>());
        if (node.description != null) { method.setDescription(node.description); }

        // Handle 2.0 "produces" and "consumes"
        if (node.ownerDocument().getDocumentType() == DocumentType.openapi2) {
            List<String> produces = ((Oas20Operation) node).produces;
            if (produces == null) {
                produces = ((Oas20Document) node.ownerDocument()).produces;
            }
            if (produces != null) {
                method.setProduces(new HashSet<>(produces));
            }

            List<String> consumes = ((Oas20Operation) node).consumes;
            if (consumes == null) {
                consumes = ((Oas20Document) node.ownerDocument()).consumes;
            }
            if (consumes != null) {
                method.setConsumes(new HashSet<>(consumes));
            }
        }

        boolean async = false;
        Extension asyncExt = node.getExtension(CodegenExtensions.ASYNC);
        if (asyncExt != null && asyncExt.value != null) {
            async = Boolean.valueOf(asyncExt.value.toString());
        }
        method.setAsync(async);

        this._currentMethods = new ArrayList<>();
        this._currentMethods.add(method);
        this._currentInterface.getMethods().add(method);

        // Be sure to process path and query parameters found on the parent!
        this._processPathItemParams = true;
        List<OasParameter> parentParams = ((OasPathItem) node.parent()).parameters;
        if (parentParams != null && parentParams.size() > 0) {
            for (OasParameter parentParam : parentParams) {
                VisitorUtil.visitNode(parentParam, this);
            }
        }
        this._processPathItemParams = false;
    }

    /**
     * @see io.apicurio.datamodels.combined.visitors.CombinedVisitorAdapter#visitParameter(io.apicurio.datamodels.core.models.common.Parameter)
     */
    @Override
    public void visitParameter(Parameter node) {
        // Skip processing of the parameter if it is defined at the path level.
        if (!this._processPathItemParams && this.isPathItem(node.parent())) {
            return;
        }

        OasParameter param = (OasParameter) node;

        CodegenJavaArgument cgArgument = new CodegenJavaArgument();
        cgArgument.setName(param.name);
        cgArgument.setIn(param.in);

        this._currentArgument = cgArgument;

        if (param.required != null) {
            cgArgument.setRequired(param.required);
        }

        this._currentMethods.forEach(method -> method.getArguments().add(cgArgument));

        if (param.ownerDocument().getDocumentType() == DocumentType.openapi2) {
            this.visit20Parameter((Oas20Parameter) param);
        }
        if (param.ownerDocument().getDocumentType() == DocumentType.openapi3) {
            this.visit30Parameter((Oas30Parameter) param);
        }
    }
    private void visit20Parameter(Oas20Parameter node) {
        CodegenJavaReturn cgReturn = this.returnFromSchema((OasSchema) node.schema);
        if (cgReturn != null) {
            if (cgReturn.getCollection() != null) { this._currentArgument.setCollection(cgReturn.getCollection()); }
            if (cgReturn.getType() != null) { this._currentArgument.setType(cgReturn.getType()); }
            if (cgReturn.getFormat() != null) { this._currentArgument.setFormat(cgReturn.getFormat()); }

            this._currentArgument.setTypeSignature(createSignature((OasSchema) node.schema));
        } else if (node.type != null) {
            if (node.type != null) { this._currentArgument.setType(node.type); }
            if (node.format != null) { this._currentArgument.setFormat(node.format); }
            // TODO:: sign the argument from the type and format on the node.
        }
    }
    private void visit30Parameter(Oas30Parameter node) {
        List<Oas30MediaType> mediaTypes = node.getMediaTypes();
        if (mediaTypes.size() > 0) {
            Oas30MediaType mediaType = mediaTypes.get(0);
            CodegenJavaReturn cgReturn = this.returnFromSchema(mediaType.schema);
            if (cgReturn != null) {
                if (cgReturn.getCollection() != null) { this._currentArgument.setCollection(cgReturn.getCollection()); }
                if (cgReturn.getType() != null) { this._currentArgument.setType(cgReturn.getType()); }
                if (cgReturn.getFormat() != null) { this._currentArgument.setFormat(cgReturn.getFormat()); }
                this._currentArgument.setTypeSignature(createSignature(mediaType.schema));
            }
        } else if (node.schema != null) {
            CodegenJavaReturn cgReturn = this.returnFromSchema((OasSchema) node.schema);
            if (cgReturn != null) {
                if (cgReturn.getCollection() != null) { this._currentArgument.setCollection(cgReturn.getCollection()); }
                if (cgReturn.getType() != null) { this._currentArgument.setType(cgReturn.getType()); }
                if (cgReturn.getFormat() != null) { this._currentArgument.setFormat(cgReturn.getFormat()); }
                this._currentArgument.setTypeSignature(createSignature((OasSchema) node.schema));
            }
        }
    }

    /**
     * @see io.apicurio.datamodels.combined.visitors.CombinedVisitorAdapter#visitRequestBody(io.apicurio.datamodels.openapi.v3.models.Oas30RequestBody)
     */
    @Override
    public void visitRequestBody(Oas30RequestBody node) {
        List<Oas30MediaType> mediaTypes = node.getMediaTypes();

        Map<CodegenJavaReturn, Set<String>> allReturnTypes = new HashMap<>();
        if (mediaTypes != null && mediaTypes.size() > 0) {
            mediaTypes.forEach(mediaType -> {
                CodegenJavaReturn cgReturn = this.returnFromSchema(mediaType.schema);
                if (cgReturn == null) {
                    cgReturn = new CodegenJavaReturn();
                }
                allReturnTypes.merge(cgReturn, Collections.singleton(mediaType.getName()), (set1, set2) -> {
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
     * @see io.apicurio.datamodels.combined.visitors.CombinedVisitorAdapter#visitResponse(io.apicurio.datamodels.openapi.models.OasResponse)
     */
    @Override
    public void visitResponse(OasResponse node) {
        // Note: if there are multiple 2xx responses, only the first one will
        // become the method return value.
        if (node.getStatusCode() != null && node.getStatusCode().indexOf("2") == 0 && this._currentMethods.get(0).getReturn() == null) {
            if (node.ownerDocument().getDocumentType() == DocumentType.openapi2) {
                this.visit20Response((Oas20Response) node);
            }
            if (node.ownerDocument().getDocumentType() == DocumentType.openapi3) {
                this.visit30Response((Oas30Response) node);
            }
        }
    }
    private void visit20Response(Oas20Response node) {
        if (node.getStatusCode() != null && node.getStatusCode().indexOf("2") == 0) {
            this._currentMethods.forEach(_currentMethod -> _currentMethod.setReturn(this.returnFromSchema(node.schema)));
        }
    }
    private void visit30Response(Oas30Response node) {
        List<Oas30MediaType> mediaTypes = node.getMediaTypes();
        // TODO if there are multiple response media types, handle it somehow - probably by returning a JAX-RS Response object
        if (mediaTypes != null && mediaTypes.size() > 0) {
            Oas30MediaType mediaType = mediaTypes.get(0);
            Extension returnTypeExt = mediaType.getExtension(CodegenExtensions.RETURN_TYPE);
            CodegenJavaReturn cgReturn = null;
            if (returnTypeExt != null) {
                String returnType = (String) returnTypeExt.value;
                CodegenJavaReturn customReturn = new CodegenJavaReturn();
                customReturn.setType(returnType);
                cgReturn = customReturn;
            } else {
                cgReturn = this.returnFromSchema(mediaType.schema);
            }

            // If no return was created, it was because we couldn't figure it out from the
            // schema (likely no schema declared) so we should create something to
            // indicate that we DO want a return value, but we don't know what it is.
            if (cgReturn == null) {
                CodegenJavaReturn unknownReturn = new CodegenJavaReturn();
                if (codegenTarget.equals(CodegenTarget.THORNTAIL)) {
                    unknownReturn.setType("javax.ws.rs.core.Response");
                } else {
                    unknownReturn.setType("jakarta.ws.rs.core.Response");
                }

                cgReturn = unknownReturn;
            }
            
            final CodegenJavaReturn _return = cgReturn;
            this._currentMethods.forEach(_currentMethod -> _currentMethod.setReturn(_return));
        }
        // Push all of the media types onto the "produces" array for the method.
        for (Oas30MediaType mt : mediaTypes) {
            this._currentMethods.forEach(_currentMethod -> _currentMethod.getProduces().add(mt.getName()));
        }
    }

    /**
     * @see io.apicurio.datamodels.combined.visitors.CombinedVisitorAdapter#visitSchemaDefinition(io.apicurio.datamodels.core.models.common.IDefinition)
     */
    @Override
    public void visitSchemaDefinition(IDefinition node) {
        String name = node.getName();
        OasSchema schema = (OasSchema) node;

        CodegenJavaBean bean = new CodegenJavaBean();
        bean.setName(name);
        bean.setPackage(CodegenUtil.schemaToPackageName(schema, this.packageName + ".beans"));
        bean.set$schema((JsonNode) Library.writeNode(schema));
        bean.setSignature(createSignature(schema));
        bean.setAnnotations(annotations(schema.getExtension(CodegenExtensions.ANNOTATIONS)));

        this.codegenInfo.getBeans().add(bean);
    }

    /**
     * Extracts the additional annotations the bean should have added to it from the x-codegen-annotations
     * extension point.
     * @param extension
     */
    private List<CodegenBeanAnnotationDirective> annotations(Extension extension) {
        if (extension != null && extension.value instanceof List) {
            List<?> annotationExtensions = (List<?>) extension.value;
            return annotations(annotationExtensions);
        } else {
            return Collections.emptyList();
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

    private String methodName(OasOperation operation) {
        if (operation.operationId != null && operation.operationId.length() > 0) {
            return this.operationIdToMethodName(operation.operationId);
        }
        if (operation.summary != null && operation.summary.length() > 0) {
            String[] nameSegments = operation.summary.split(" ");
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

    private String methodPath(OasOperation operation) {
        String path = ((OasPathItem) operation.parent()).getPath();
        if (path.equals(this._currentInterface.getPath())) {
            return null;
        }
        path = path.substring(this._currentInterface.getPath().length());
        if ("/".equals(path)) {
            return null;
        }
        return path;
    }

    private CodegenJavaReturn returnFromSchema(OasSchema schema) {
        if (schema == null) {
            return null;
        }
        CodegenJavaReturn cgReturn = new CodegenJavaReturn();
        cgReturn.setType(null);
        if (schema.$ref != null) {
            cgReturn.setType(this.typeFromSchemaRef(schema.ownerDocument(), schema.$ref));
        } else if ("array".equals(schema.type)) {
            cgReturn.setCollection("list");
            OasSchema items = (OasSchema) schema.items;
            CodegenJavaReturn subReturn = this.returnFromSchema(items);
            if (subReturn != null && subReturn.getType() != null) {
                cgReturn.setType(subReturn.getType());
            }
            if (subReturn != null && subReturn.getFormat() != null) {
                cgReturn.setFormat(subReturn.getFormat());
            }
        } else {
            if (schema.type != null) {
                cgReturn.setType(schema.type);
            }
            if (schema.format != null) {
                cgReturn.setFormat(schema.format);
            }
        }
        return cgReturn;
    }

    private String typeFromSchemaRef(Document document, String schemaRef) {
        return CodegenUtil.schemaRefToFQCN(document, schemaRef, this.packageName + ".beans");
    }

    private boolean isPathItem(Node node) {
        PathItemDetectionVisitor viz = new PathItemDetectionVisitor();
        VisitorUtil.visitNode(node, viz);
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
