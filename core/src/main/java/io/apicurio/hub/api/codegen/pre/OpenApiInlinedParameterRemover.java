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
import io.apicurio.datamodels.models.Parameter;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31Components;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31Parameter;
import io.apicurio.datamodels.models.visitors.CombinedVisitorAdapter;
import io.apicurio.datamodels.util.NodeUtil;
import io.apicurio.hub.api.codegen.CodegenExtensions;
import io.apicurio.hub.api.codegen.jaxrs.TraversingOpenApi31VisitorAdapter;
import io.apicurio.hub.api.codegen.util.CodegenUtil;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApiInlinedParameterRemover extends TraversingOpenApi31VisitorAdapter {

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitParameter(io.apicurio.datamodels.models.Parameter)
     */
    @Override
    public void visitParameter(Parameter node) {
        if (NodeUtil.isDefinition(node)) {
            OpenApi31Parameter param = (OpenApi31Parameter) node;
            if (wasInlined(param)) {
                final String definitionName = getMappedNodeName(node);
                Library.visitTree(param.root(), new CombinedVisitorAdapter() {
                    @Override
                    public void visitComponents(Components node) {
                        OpenApi31Components components = (OpenApi31Components) node;
                        components.getParameters().remove(definitionName);
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
