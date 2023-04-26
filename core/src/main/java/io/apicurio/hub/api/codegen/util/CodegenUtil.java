/*
 * Copyright 2019 JBoss Inc
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

package io.apicurio.hub.api.codegen.util;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;

import io.apicurio.datamodels.models.Document;
import io.apicurio.datamodels.models.Extensible;
import io.apicurio.datamodels.models.openapi.OpenApiSchema;
import io.apicurio.datamodels.models.openapi.v20.OpenApi20Document;
import io.apicurio.datamodels.models.openapi.v20.OpenApi20Schema;
import io.apicurio.datamodels.models.openapi.v30.OpenApi30Document;
import io.apicurio.datamodels.models.openapi.v30.OpenApi30Schema;
import io.apicurio.hub.api.codegen.CodegenExtensions;

public final class CodegenUtil {

    public static final String schemaToPackageName(OpenApiSchema schema, String defaultPackage) {
        String pname = defaultPackage;

        if (schema != null) {
            JsonNode extension = getExtension((Extensible) schema, CodegenExtensions.PACKAGE);
            if (extension != null && !extension.isNull()) {
                String packageName = String.valueOf(extension.asText());
                if (!packageName.trim().isEmpty()) {
                    pname = packageName;
                }
            }
        }

        return pname;
    }

    public static final String schemaRefToFQCN(Document document, String schemaRef, String defaultPackage) {
        String cname = "GeneratedClass_" + System.currentTimeMillis();
        String pname = defaultPackage;
        if (schemaRef.startsWith("#/definitions/")) {
            cname = schemaRef.substring(14);
            OpenApi20Document doc20 = (OpenApi20Document) document;
            if (doc20.getDefinitions() != null) {
                OpenApi20Schema definition = doc20.getDefinitions().getItem(cname);
                pname = CodegenUtil.schemaToPackageName(definition, pname);
            }
        }
        if (schemaRef.startsWith("#/components/schemas/")) {
            cname = schemaRef.substring(21);
            OpenApi30Document doc30 = (OpenApi30Document) document;
            if (doc30.getComponents() != null) {
                OpenApi30Schema definition = (OpenApi30Schema) doc30.getComponents().getSchemas().get(cname);
                pname = CodegenUtil.schemaToPackageName(definition, pname);
            }
        }
        return pname + "." + StringUtils.capitalize(cname);
    }

    public static JsonNode getExtension(Extensible node, String name) {
        if (node != null && node.getExtensions() != null && node.getExtensions().containsKey(name)) {
            return node.getExtensions().get(name);
        }
        return null;
    }

}
