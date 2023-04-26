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

import io.apicurio.datamodels.models.openapi.v30.OpenApi30Schema;
import io.apicurio.hub.api.codegen.jaxrs.TraversingOpenApi30VisitorAdapter;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApiByteSimpleTypeProcessor extends TraversingOpenApi30VisitorAdapter {

    /**
     * @see io.apicurio.datamodels.models.openapi.v30.visitors.OpenApi30VisitorAdapter#visitSchema(io.apicurio.datamodels.models.Schema)
     */
    @Override
    public void visitSchema(io.apicurio.datamodels.models.Schema node) {
        OpenApi30Schema schema = (OpenApi30Schema) node;
        if ("string".equals(schema.getType()) && "byte".equals(schema.getFormat())) {
            schema.setType("object");
            // workaround for a jsonschema2pojo limitation
            schema.addExtraProperty("existingJavaType", factory.textNode("APICURIO_CODEGEN_BYTE_ARRAY_REPRESENTATION"));
        }
    }

}
