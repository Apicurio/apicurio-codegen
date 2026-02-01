/*
 * Copyright 2019 Red Hat
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

package io.apicurio.hub.api.codegen.jaxrs;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import io.apicurio.datamodels.models.Document;
import io.apicurio.datamodels.models.Schema;
import io.apicurio.datamodels.models.openapi.OpenApiMediaType;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31Schema;
import io.apicurio.hub.api.codegen.JaxRsProjectSettings;
import io.apicurio.hub.api.codegen.beans.CodegenJavaArgument;
import io.apicurio.hub.api.codegen.beans.CodegenJavaMethod;
import io.apicurio.hub.api.codegen.util.CodegenUtil;

import static io.apicurio.hub.api.codegen.util.CodegenUtil.containsValue;

/**
 * Utility class for processing multipart/form-data request bodies.
 * Extracts form field parameters from OpenAPI schema properties.
 *
 * @author <a href="https://github.com/lpieprzyk">lpieprzyk</a>
 */
public class MultipartFormDataRequestBodyCreator {

    private MultipartFormDataRequestBodyCreator() {
        // Functional class
    }

    /**
     * Processes a multipart/form-data media type by creating individual form field parameters
     * instead of a generic body parameter.
     *
     * @param mediaType the OpenAPI media type to process
     * @param methodTemplate the method template to modify with form field parameters
     * @param settings the project settings for type mapping
     * @param document the OpenAPI document for reference resolution
     */
    public static void processMultipartFormData(OpenApiMediaType mediaType,
                                                CodegenJavaMethod methodTemplate,
                                                JaxRsProjectSettings settings,
                                                Document document) {
        if (mediaType.getSchema() != null) {
            OpenApi31Schema schema = (OpenApi31Schema) mediaType.getSchema();
            if (containsValue(schema.getType(), "object")) {
                Map<String, Schema> properties = schema.getProperties();
                if (properties != null) {
                    // Add multipart/form-data to consumes
                    methodTemplate.getConsumes().add("MediaType.MULTIPART_FORM_DATA");
                    // Create individual form field parameters
                    createIndividualFormFieldParams(methodTemplate, settings, document, properties, schema);
                }
            }
        }
    }

    /**
     * Adds individual form field parameters to the method template based on the provided schema properties.
     *
     * @param methodTemplate the method template to modify with form field parameters
     * @param settings the project settings used for type mapping and configuration
     * @param document the OpenAPI document used for reference resolution
     * @param properties a map of property names to their corresponding schema definitions
     * @param schema the parent schema containing details about required fields
     */
    private static void createIndividualFormFieldParams(CodegenJavaMethod methodTemplate,
                                                        JaxRsProjectSettings settings,
                                                        Document document,
                                                        Map<String, Schema> properties,
                                                        OpenApi31Schema schema) {
        for (Map.Entry<String, Schema> property : properties.entrySet()) {
            String fieldName = property.getKey();
            Schema fieldSchema = property.getValue();

            CodegenJavaArgument cgArgument = createFormFieldArgument(fieldName, fieldSchema, schema, settings, document);
            methodTemplate.getArguments().add(cgArgument);
        }
    }

    /**
     * Creates a CodegenJavaArgument for a form field based on the schema property.
     *
     * @param fieldName the name of the form field
     * @param fieldSchema the schema definition for the field
     * @param parentSchema the parent schema containing the required field list
     * @param settings the project settings for type mapping
     * @param document the OpenAPI document for reference resolution
     * @return the configured CodegenJavaArgument
     */
    private static CodegenJavaArgument createFormFieldArgument(String fieldName, Schema fieldSchema, OpenApi31Schema parentSchema, JaxRsProjectSettings settings, Document document) {
        CodegenJavaArgument cgArgument = new CodegenJavaArgument();
        cgArgument.setName(fieldName);
        cgArgument.setIn("form");

        boolean isRequired = checkIfFieldIsRequired(fieldName, parentSchema);
        cgArgument.setRequired(isRequired);

        defineArgumentTypeForSchema(cgArgument, fieldSchema, settings, document);
        return cgArgument;
    }

    /**
     * Checks whether a specified field is marked as required in the given parent schema.
     *
     * @param fieldName the name of the field to check
     * @param parentSchema the parent schema containing the list of required fields
     * @return true if the field is marked as required, false otherwise
     */
    private static boolean checkIfFieldIsRequired(String fieldName, OpenApi31Schema parentSchema) {
        boolean isRequired = false;
        if (parentSchema != null && parentSchema.getRequired() != null) {
            isRequired = parentSchema.getRequired().contains(fieldName);
        }
        return isRequired;
    }

    /**
     * Defines the appropriate type and format for the argument based on the schema definition.
     *
     * @param argument the argument to configure
     * @param fieldSchema the schema to analyze
     * @param settings the project settings for type mapping
     * @param document the OpenAPI document for reference resolution
     */
    private static void defineArgumentTypeForSchema(CodegenJavaArgument argument,
                                                    Schema fieldSchema,
                                                    JaxRsProjectSettings settings,
                                                    Document document) {
        if (fieldSchema == null) {
            argument.setType(Collections.singletonList("java.lang.String"));
            return;
        }
        if (!(fieldSchema instanceof OpenApi31Schema)) {
            argument.setType(Collections.singletonList("java.lang.String"));
            return;
        }
        OpenApi31Schema oas31Schema = (OpenApi31Schema) fieldSchema;
        // Handle schema references ($ref)
        String ref = oas31Schema.get$ref();
        if (ref != null) {
            String className = CodegenUtil.schemaRefToFQCN(settings, document, ref, settings.getJavaPackage() + ".beans");
            argument.setType(Collections.singletonList(className));
            return;
        }

        String format = oas31Schema.getFormat();

        // Handle array types
        if (containsValue(oas31Schema.getType(), "array")) {
            if (oas31Schema.getItems() != null) {
                // Create a temporary argument to get the item type
                CodegenJavaArgument itemArgument = new CodegenJavaArgument();
                defineArgumentTypeForSchema(itemArgument, oas31Schema.getItems(), settings, document);

                List<String> itemTypes = itemArgument.getType();
                if (itemTypes != null && !itemTypes.isEmpty()) {
                    String itemType = itemTypes.get(0);
                    argument.setType(Collections.singletonList("java.util.List<" + getSimpleClassName(itemType) + ">"));
                } else {
                    argument.setType(Collections.singletonList("java.util.List<java.lang.String>"));
                }
            } else {
                argument.setType(Collections.singletonList("java.util.List<java.lang.String>"));
            }
            return;
        }

        // Handle string types with formats
        if (containsValue(oas31Schema.getType(), "string")) {
            if ("binary".equals(format)) {
                argument.setType(Collections.singletonList("org.jboss.resteasy.plugins.providers.multipart.FileUpload"));
                argument.setFormat("binary");
            } else if ("date".equals(format)) {
                argument.setType(Collections.singletonList("java.time.LocalDate"));
                argument.setFormat("date");
            } else if ("date-time".equals(format)) {
                argument.setType(Collections.singletonList("java.time.LocalDateTime"));
                argument.setFormat("date-time");
            } else {
                argument.setType(Collections.singletonList("java.lang.String"));
            }
            return;
        }

        // Handle integer types
        if (containsValue(oas31Schema.getType(), "integer")) {
            if ("int64".equals(format) || "long".equals(format)) {
                argument.setType(Collections.singletonList("java.lang.Long"));
            } else {
                argument.setType(Collections.singletonList("java.lang.Integer"));
            }
            if (format != null) {
                argument.setFormat(format);
            }
            return;
        }

        // Handle number types
        if (containsValue(oas31Schema.getType(), "number")) {
            if ("double".equals(format)) {
                argument.setType(Collections.singletonList("java.lang.Double"));
            } else if ("float".equals(format)) {
                argument.setType(Collections.singletonList("java.lang.Float"));
            } else {
                argument.setType(Collections.singletonList("java.math.BigDecimal"));
            }
            if (format != null) {
                argument.setFormat(format);
            }
            return;
        }

        // Handle boolean types
        if (containsValue(oas31Schema.getType(), "boolean")) {
            argument.setType(Collections.singletonList("java.lang.Boolean"));
            return;
        }

        // Handle object types and fallback
        if (containsValue(oas31Schema.getType(), "object") || oas31Schema.getType() == null) {
            // For objects without properties, use a generic Map
            argument.setType(Collections.singletonList("java.util.Map<java.lang.String, java.lang.Object>"));
        } else {
            // Fallback to String for unknown types
            argument.setType(Collections.singletonList("java.lang.String"));
        }
    }

    /**
     * Extracts the simple class name from a fully qualified class name for use in generics.
     *
     * @param className the fully qualified class name
     * @return the simple class name
     */
    private static String getSimpleClassName(String className) {
        if (className == null) {
            return "Object";
        }
        int lastDot = className.lastIndexOf('.');
        return lastDot >= 0 ? className.substring(lastDot + 1) : className;
    }
}