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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import io.apicurio.datamodels.Library;
import io.apicurio.datamodels.models.Schema;
import io.apicurio.datamodels.models.openapi.v30.OpenApi30Schema;
import io.apicurio.datamodels.refs.LocalReferenceResolver;
import io.apicurio.hub.api.codegen.jaxrs.TraversingOpenApi30VisitorAdapter;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApiAllOfProcessor extends TraversingOpenApi30VisitorAdapter {

    /**
     * @see io.apicurio.datamodels.models.openapi.v30.visitors.OpenApi30VisitorAdapter#visitSchema(io.apicurio.datamodels.models.Schema)
     */
    @Override
    public void visitSchema(Schema node) {
        OpenApi30Schema schema = (OpenApi30Schema) node;
        if (schema.getAllOf() != null) {
            List<String> required = new ArrayList<>();
            schema.getAllOf().forEach(allOfSchema -> {
                OpenApi30Schema allOf = (OpenApi30Schema) allOfSchema;
                if (allOf.get$ref() != null) {
                    LocalReferenceResolver resolver = new LocalReferenceResolver();
                    allOf = (OpenApi30Schema) resolver.resolveRef(allOf.get$ref(), allOf);
                }
                if (allOf != null) {
                    if (allOf.getRequired() != null) {
                        required.addAll(allOf.getRequired());
                    }
                    ObjectNode serializedAllOf = Library.writeNode(allOf);
                    Library.readNode(serializedAllOf, schema);
                }
            });
            schema.clearAllOf();
            schema.set$ref(null);
            schema.setRequired(required);
        }
    }

}
