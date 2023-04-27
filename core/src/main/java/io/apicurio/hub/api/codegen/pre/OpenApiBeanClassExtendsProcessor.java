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

/**
 * Pre processes the OpenAPI document to handle the x-codegen-extendsClass extension.
 * @author eric.wittmann@gmail.com
 */
public class OpenApiBeanClassExtendsProcessor extends TraversingOpenApi31VisitorAdapter {

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitSchema(io.apicurio.datamodels.models.Schema)
     */
    @Override
    public void visitSchema(Schema node) {
        if (NodeUtil.isDefinition(node)) {
            OpenApi31Schema schema = (OpenApi31Schema) node;
            JsonNode extension = CodegenUtil.getExtension(schema, CodegenExtensions.EXTENDS_CLASS);
            if (extension != null && !extension.isNull() && extension.isTextual()) {
                schema.removeExtension(CodegenExtensions.EXTENDS_CLASS);
                schema.addExtraProperty("extendsJavaClass", extension);
            }
        }
    }

}
