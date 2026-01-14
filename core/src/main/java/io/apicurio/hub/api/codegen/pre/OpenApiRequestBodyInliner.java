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
import io.apicurio.datamodels.models.openapi.OpenApiRequestBody;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31RequestBody;
import io.apicurio.datamodels.refs.LocalReferenceResolver;
import io.apicurio.hub.api.codegen.jaxrs.TraversingOpenApi31VisitorAdapter;

/**
 * This visitor inlines request bodies that are defined by reference.
 * It copies all properties from the referenced request body definition into the node, removing the $ref.
 *
 */
public class OpenApiRequestBodyInliner extends TraversingOpenApi31VisitorAdapter {

    @Override
    public void visitRequestBody(OpenApiRequestBody node) {
        OpenApi31RequestBody requestBody = (OpenApi31RequestBody) node;
        LocalReferenceResolver localReferenceResolver = new LocalReferenceResolver();
        if (requestBody.get$ref() != null) {
            var resolvedRef = localReferenceResolver.resolveRef(requestBody.get$ref(), requestBody);
            Node referencedRequestBodyDefNode = (resolvedRef != null && resolvedRef.isNode()) ? resolvedRef.asNode() : null;
            if (referencedRequestBodyDefNode != null) {
                inlineRequestBody(requestBody, referencedRequestBodyDefNode);
            }
        }
    }

    /**
     * Copies all properties from the request body definition into the node, removing the $ref.
     * @param requestBody
     * @param responseDef
     */
    private void inlineRequestBody(OpenApi31RequestBody requestBody, Node responseDef) {
        requestBody.set$ref(null);

        // Copy everything from schemaDef into schema by serializing the former into a JSON
        // object and then deserializing that into the latter.
        ObjectNode serializedParamDef = Library.writeNode(responseDef);
        Library.readNode(serializedParamDef, requestBody);
    }

}
