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
import io.apicurio.datamodels.models.openapi.v30.OpenApi30Schema;
import io.apicurio.hub.api.codegen.CodegenExtensions;
import io.apicurio.hub.api.codegen.jaxrs.TraversingOpenApi30VisitorAdapter;
import io.apicurio.hub.api.codegen.util.CodegenUtil;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApiDateTimeSimpleTypeProcessor extends TraversingOpenApi30VisitorAdapter {

    @Override
    public void visitSchema(Schema node) {
        OpenApi30Schema schema = (OpenApi30Schema) node;
        // Switch from int64 format to utc-millisec so that jsonschema2pojo will generate a Long instead of an Integer
        if ("string".equals(schema.getType()) && "date-time".equals(schema.getFormat())) {
            String formatPattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
            JsonNode ext = CodegenUtil.getExtension(schema, CodegenExtensions.FORMAT_PATTERN);
            if (ext != null && !ext.isNull() && ext.isTextual()) {
                formatPattern = ext.asText();
            }
            schema.addExtraProperty("customDateTimePattern", factory.textNode(formatPattern));
        }
    }

}
