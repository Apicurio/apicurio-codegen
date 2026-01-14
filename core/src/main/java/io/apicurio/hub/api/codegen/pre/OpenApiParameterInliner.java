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

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.apicurio.datamodels.Library;
import io.apicurio.datamodels.models.Extensible;
import io.apicurio.datamodels.models.Node;
import io.apicurio.datamodels.models.Parameter;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31Parameter;
import io.apicurio.datamodels.refs.LocalReferenceResolver;
import io.apicurio.hub.api.codegen.CodegenExtensions;
import io.apicurio.hub.api.codegen.jaxrs.TraversingOpenApi31VisitorAdapter;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApiParameterInliner extends TraversingOpenApi31VisitorAdapter {

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitParameter(io.apicurio.datamodels.models.Parameter)
     */
    @Override
    public void visitParameter(Parameter node) {
        OpenApi31Parameter param = (OpenApi31Parameter) node;

        LocalReferenceResolver resolver = new LocalReferenceResolver();
        if (param.get$ref() != null) {
            var resolvedRef = resolver.resolveRef(param.get$ref(), param);
            Node referencedParameterDefNode = (resolvedRef != null && resolvedRef.isNode()) ? resolvedRef.asNode() : null;
            if (referencedParameterDefNode != null) {
                inlineParameter(param, referencedParameterDefNode);
                markForRemoval((Extensible) referencedParameterDefNode);
            }
        }
    }

    /**
     * Copies all properties from the parameter definition into the node, removing the $ref.
     * @param param
     * @param paramDef
     */
    private void inlineParameter(OpenApi31Parameter param, Node paramDef) {
        param.set$ref(null);

        // Copy everything from schemaDef into schema by serializing the former into a JSON
        // object and then deserializing that into the latter.
        ObjectNode serializedParamDef = Library.writeNode(paramDef);
        Library.readNode(serializedParamDef, param);
    }

    private void markForRemoval(Extensible node) {
        node.addExtension(CodegenExtensions.INLINED, factory.booleanNode(true));
    }

}
