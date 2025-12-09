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

import io.apicurio.datamodels.models.Schema;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31Schema;
import io.apicurio.datamodels.util.NodeUtil;
import io.apicurio.hub.api.codegen.CodegenExtensions;
import io.apicurio.hub.api.codegen.jaxrs.TraversingOpenApi31VisitorAdapter;
import io.apicurio.hub.api.codegen.util.CodegenUtil;

import java.util.Map;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApiMapDataTypeProcessor extends TraversingOpenApi31VisitorAdapter {

    private static final Map<String, String> EXTENSION_NAMES = Map.of(
            "StringMap",
            "java.util.Map<String,String>",
            "StringObjectMap",
            "java.util.Map<String,Object>"
    );

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitSchema(io.apicurio.datamodels.models.Schema)
     */
    @Override
    public void visitSchema(Schema node) {
        if (NodeUtil.isDefinition(node)) {
            OpenApi31Schema schema = (OpenApi31Schema) node;
            if (isMapType(schema)) {
                schema.setAdditionalProperties(null);
                String javaType = EXTENSION_NAMES.get(CodegenUtil.getExtension(schema, CodegenExtensions.TYPE).asText());
                schema.addExtraProperty("existingJavaType", factory.textNode(javaType));
            }
        }
    }

    private boolean isMapType(OpenApi31Schema schema) {
        JsonNode extension = CodegenUtil.getExtension(schema, CodegenExtensions.TYPE);
        if (extension == null || !extension.isTextual()) {
            return false;
        }
        return EXTENSION_NAMES.get(extension.asText()) != null;
    }

}
