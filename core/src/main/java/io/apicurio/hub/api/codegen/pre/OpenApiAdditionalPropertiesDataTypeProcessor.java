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

import io.apicurio.datamodels.models.Schema;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31Schema;
import io.apicurio.datamodels.models.union.BooleanUnionValueImpl;
import io.apicurio.hub.api.codegen.jaxrs.TraversingOpenApi31VisitorAdapter;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApiAdditionalPropertiesDataTypeProcessor extends TraversingOpenApi31VisitorAdapter {

    /**
     * @see io.apicurio.datamodels.models.openapi.v31.visitors.OpenApi31VisitorAdapter#visitSchema(io.apicurio.datamodels.models.Schema)
     */
    @Override
    public void visitSchema(Schema node) {
        OpenApi31Schema schema = (OpenApi31Schema) node;
        if (schema.getAdditionalProperties() != null && (schema.getAdditionalProperties().isSchema() ||
                (schema.getAdditionalProperties().isBoolean() && schema.getAdditionalProperties().asBoolean()))) {
            // WORKAROUND: https://github.com/joelittlejohn/jsonschema2pojo/pull/1515
            schema.setAdditionalProperties(new BooleanUnionValueImpl(Boolean.TRUE));
        } else {
            schema.setAdditionalProperties(new BooleanUnionValueImpl(Boolean.FALSE));
        }
    }
}
