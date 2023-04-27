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
import io.apicurio.datamodels.models.Node;
import io.apicurio.datamodels.models.openapi.OpenApiResponse;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31Response;
import io.apicurio.datamodels.refs.LocalReferenceResolver;
import io.apicurio.hub.api.codegen.jaxrs.TraversingOpenApi31VisitorAdapter;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApiResponseInliner extends TraversingOpenApi31VisitorAdapter {

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitResponse(io.apicurio.datamodels.models.openapi.OpenApiResponse)
     */
    @Override
    public void visitResponse(OpenApiResponse node) {
        OpenApi31Response response = (OpenApi31Response) node;
        LocalReferenceResolver resolver = new LocalReferenceResolver();
        if (response.get$ref() != null) {
            Node referencedResponseDefNode = resolver.resolveRef(response.get$ref(), response);
            if (referencedResponseDefNode != null) {
                inlineResponse(response, referencedResponseDefNode);
            }
        }
    }

    /**
     * Copies all properties from the response definition into the node, removing the $ref.
     * @param response
     * @param responseDef
     */
    private void inlineResponse(OpenApi31Response response, Node responseDef) {
        response.set$ref(null);

        // Copy everything from schemaDef into schema by serializing the former into a JSON
        // object and then deserializing that into the latter.
        ObjectNode serializedParamDef = Library.writeNode(responseDef);
        Library.readNode(serializedParamDef, response);
    }

}
