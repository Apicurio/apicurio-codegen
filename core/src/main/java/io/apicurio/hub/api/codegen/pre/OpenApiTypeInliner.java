/*
 * Copyright 2021 JBoss Inc
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

package io.apicurio.hub.api.codegen.pre;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.apicurio.datamodels.Library;
import io.apicurio.datamodels.models.Extensible;
import io.apicurio.datamodels.models.Node;
import io.apicurio.datamodels.models.Schema;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31Schema;
import io.apicurio.datamodels.refs.LocalReferenceResolver;
import io.apicurio.hub.api.codegen.CodegenExtensions;
import io.apicurio.hub.api.codegen.jaxrs.TraversingOpenApi31VisitorAdapter;
import io.apicurio.hub.api.codegen.util.CodegenUtil;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApiTypeInliner extends TraversingOpenApi31VisitorAdapter {

    @Override
    public void visitSchema(Schema node) {
        OpenApi31Schema schema = (OpenApi31Schema) node;

        LocalReferenceResolver resolver = new LocalReferenceResolver();
        if (schema.get$ref() != null) {
            Node referencedSchemaDefNode = resolver.resolveRef(schema.get$ref(), schema);
            if (referencedSchemaDefNode != null) {
                OpenApi31Schema referencedSchema = (OpenApi31Schema) referencedSchemaDefNode;
                if (isSimpleType(referencedSchema)) {
                    inlineSchema(schema, referencedSchema);
                    markForRemoval(referencedSchema);
                } else if (isArrayType(referencedSchema)) {
                    inlineSchema(schema, referencedSchema);
                    markForRemoval(referencedSchema);
                } else if (isInlineSchema((Extensible) referencedSchemaDefNode)) {
                    inlineSchema(schema, (OpenApi31Schema) referencedSchemaDefNode);
                    markForRemoval((Extensible) referencedSchemaDefNode);
                }
            }
        }
    }

    /**
     * Returns true if the given schema is a simple type (e.g. string, integer, etc).
     * or is a primitive type that should be inlined
     * @param schema
     */
    private boolean isSimpleType(OpenApi31Schema schema) {
        if ("string".equals(schema.getType())) {
            return schema.getEnum() == null;
        } else {
            return "integer".equals(schema.getType()) || "number".equals(schema.getType()) ||
                    "boolean".equals(schema.getType());
        }
    }

    /**
     * Returns true if the given schema is an array type.
     * @param schema
     */
    private boolean isArrayType(OpenApi31Schema schema) {
        return "array".equals(schema.getType());
    }

    /**
     * Copies all properties from the schema definition into the node, removing the $ref.
     * @param schema
     * @param schemaDef
     */
    private void inlineSchema(OpenApi31Schema schema, OpenApi31Schema schemaDef) {
        schema.set$ref(null);

        // Copy everything from schemaDef into schema by serializing the former into a JSON
        // object and then deserialing that into the latter.
        ObjectNode serializedSchemaDef = Library.writeNode(schemaDef);
        Library.readNode(serializedSchemaDef, schema);
    }

    /**
     * Returns true if the schema definition is annotated with "x-codegen-inline" : "true".
     * @param referencedSchemaDefNode
     */
    private boolean isInlineSchema(Extensible referencedSchemaDefNode) {
        JsonNode extension = CodegenUtil.getExtension(referencedSchemaDefNode, CodegenExtensions.INLINE);
        if (extension == null || extension.isNull()) {
            return false;
        }
        return extension.asBoolean(false);
    }

    /**
     * @param node
     */
    private void markForRemoval(Extensible node) {
        node.addExtension(CodegenExtensions.INLINED, factory.booleanNode(true));
    }

}
