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

import io.apicurio.datamodels.Library;
import io.apicurio.datamodels.TraverserDirection;
import io.apicurio.datamodels.models.Components;
import io.apicurio.datamodels.models.Extensible;
import io.apicurio.datamodels.models.Schema;
import io.apicurio.datamodels.models.openapi.v30.OpenApi30Components;
import io.apicurio.datamodels.models.openapi.v30.OpenApi30Schema;
import io.apicurio.datamodels.models.visitors.CombinedVisitorAdapter;
import io.apicurio.datamodels.util.NodeUtil;
import io.apicurio.hub.api.codegen.CodegenExtensions;
import io.apicurio.hub.api.codegen.jaxrs.TraversingOpenApi30VisitorAdapter;
import io.apicurio.hub.api.codegen.util.CodegenUtil;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApiInlinedSchemaRemover extends TraversingOpenApi30VisitorAdapter {

    @Override
    public void visitSchema(Schema node) {
        OpenApi30Schema schema = (OpenApi30Schema) node;
        if (NodeUtil.isDefinition(schema)) {
            if (wasInlined(schema)) {
                String definitionName = getMappedNodeName(schema);
                Library.visitTree(schema.root(), new CombinedVisitorAdapter() {
                    @Override
                    public void visitComponents(Components node) {
                        OpenApi30Components components = (OpenApi30Components) node;
                        components.getSchemas().remove(definitionName);
                    }
                }, TraverserDirection.down);
            }
        }
    }

    private boolean wasInlined(Extensible node) {
        JsonNode inlinedExt = CodegenUtil.getExtension(node, CodegenExtensions.INLINED);
        if (inlinedExt == null || inlinedExt.isNull()) {
            return false;
        }
        return inlinedExt.asBoolean(false);
    }

}
