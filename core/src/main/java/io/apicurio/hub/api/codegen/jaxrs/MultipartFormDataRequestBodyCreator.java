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
 * Extracts form-field parameters from OpenAPI schema properties.
 *
 * @author <a href="https://github.com/lpieprzyk">lpieprzyk</a>
 */
public class MultipartFormDataRequestBodyCreator {

    private static final String JAVA_LANG_STRING = "java.lang.String";
    private static final String JBOSS_FILE_UPLOAD = "org.jboss.resteasy.plugins.providers.multipart.FileUpload";
    private static final String JAVA_TIME_LOCAL_DATE = "java.time.LocalDate";
    private static final String JAVA_TIME_LOCAL_DATE_TIME = "java.time.LocalDateTime";
    private static final String JAVA_LANG_LONG = "java.lang.Long";
    private static final String JAVA_LANG_INTEGER = "java.lang.Integer";
    private static final String JAVA_LANG_DOUBLE = "java.lang.Double";
    private static final String JAVA_LANG_FLOAT = "java.lang.Float";
    private static final String JAVA_MATH_BIG_DECIMAL = "java.math.BigDecimal";
    private static final String JAVA_UTIL_LIST = "java.util.List";
    private static final String JAVA_UTIL_MAP = "java.util.Map";
    private static final String JAVA_LANG_OBJECT = "java.lang.Object";
    private static final String JAVA_LANG_BOOLEAN = "java.lang.Boolean";

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
                    methodTemplate.getConsumes().add("MediaType.MULTIPART_FORM_DATA");
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
        if (!validateSchemaAndSetDefaults(argument, fieldSchema)) {
            return;
        }
        OpenApi31Schema oas31Schema = (OpenApi31Schema) fieldSchema;
        if (resolveSchemaReference(argument, oas31Schema, settings, document)) {
            return;
        }
        if (handleArrayType(argument, oas31Schema, settings, document)) {
            return;
        }
        mapSchemaTypeToJavaType(argument, oas31Schema);
    }
    
    private static boolean validateSchemaAndSetDefaults(CodegenJavaArgument argument, Schema fieldSchema) {
        if (fieldSchema == null) {
            argument.setType(Collections.singletonList(JAVA_LANG_STRING));
            return false;
        }
        if (!(fieldSchema instanceof OpenApi31Schema)) {
            argument.setType(Collections.singletonList(JAVA_LANG_STRING));
            return false;
        }
        return true;
    }

    private static boolean resolveSchemaReference(CodegenJavaArgument argument, OpenApi31Schema oas31Schema, JaxRsProjectSettings settings, Document document) {
        String ref = oas31Schema.get$ref();
        if (ref != null) {
            String className = CodegenUtil.schemaRefToFQCN(settings, document, ref, settings.getJavaPackage() + ".beans");
            argument.setType(Collections.singletonList(className));
            return true;
        }
        return false;
    }

    private static boolean mapStringType(CodegenJavaArgument argument, OpenApi31Schema oas31Schema) {
        if (!containsValue(oas31Schema.getType(), "string")) {
            return false;
        }
        String format = oas31Schema.getFormat();
        if ("binary".equals(format)) {
            argument.setType(Collections.singletonList(JBOSS_FILE_UPLOAD));
            argument.setFormat("binary");
        } else if ("date".equals(format)) {
            argument.setType(Collections.singletonList(JAVA_TIME_LOCAL_DATE));
            argument.setFormat("date");
        } else if ("date-time".equals(format)) {
            argument.setType(Collections.singletonList(JAVA_TIME_LOCAL_DATE_TIME));
            argument.setFormat("date-time");
        } else {
            argument.setType(Collections.singletonList(JAVA_LANG_STRING));
        }
        return true;
    }

    private static boolean mapIntegerType(CodegenJavaArgument argument, OpenApi31Schema oas31Schema) {
        if (!containsValue(oas31Schema.getType(), "integer")) {
            return false;
        }
        String format = oas31Schema.getFormat();
        if ("int64".equals(format) || "long".equals(format)) {
            argument.setType(Collections.singletonList(JAVA_LANG_LONG));
        } else {
            argument.setType(Collections.singletonList(JAVA_LANG_INTEGER));
        }
        if (format != null) {
            argument.setFormat(format);
        }
        return true;
    }

    private static boolean mapNumberType(CodegenJavaArgument argument, OpenApi31Schema oas31Schema) {
        if (!containsValue(oas31Schema.getType(), "number")) {
            return false;
        }

        String format = oas31Schema.getFormat();
        if ("double".equals(format)) {
            argument.setType(Collections.singletonList(JAVA_LANG_DOUBLE));
        } else if ("float".equals(format)) {
            argument.setType(Collections.singletonList(JAVA_LANG_FLOAT));
        } else {
            argument.setType(Collections.singletonList(JAVA_MATH_BIG_DECIMAL));
        }
        if (format != null) {
            argument.setFormat(format);
        }
        return true;
    }


    private static boolean mapBooleanType(CodegenJavaArgument argument, OpenApi31Schema oas31Schema) {
        if (!containsValue(oas31Schema.getType(), "boolean")) {
            return false;
        }
        argument.setType(Collections.singletonList(JAVA_LANG_BOOLEAN));
        return true;
    }

    private static void mapObjectOrFallbackType(CodegenJavaArgument argument, OpenApi31Schema oas31Schema) {
        if (containsValue(oas31Schema.getType(), "object") || oas31Schema.getType() == null) {
            argument.setType(Collections.singletonList(JAVA_UTIL_MAP + "<" + JAVA_LANG_STRING + ", " + JAVA_LANG_OBJECT + ">"));
        } else {
            // Fallback to String for unknown types
            argument.setType(Collections.singletonList(JAVA_LANG_STRING));
        }
    }

    private static boolean handleArrayType(CodegenJavaArgument argument, OpenApi31Schema oas31Schema, JaxRsProjectSettings settings, Document document) {
        if (!containsValue(oas31Schema.getType(), "array")) {
            return false;
        }
        if (oas31Schema.getItems() != null) {
            CodegenJavaArgument itemArgument = new CodegenJavaArgument();
            defineArgumentTypeForSchema(itemArgument, oas31Schema.getItems(), settings, document);

            List<String> itemTypes = itemArgument.getType();
            if (itemTypes != null && !itemTypes.isEmpty()) {
                String itemType = itemTypes.get(0);
                argument.setType(Collections.singletonList(JAVA_UTIL_LIST + "<" + getSimpleClassName(itemType) + ">"));
            } else {
                argument.setType(Collections.singletonList(JAVA_UTIL_LIST + "<" + JAVA_LANG_STRING + ">"));
            }
        } else {
            argument.setType(Collections.singletonList(JAVA_UTIL_LIST + "<" + JAVA_LANG_STRING + ">"));
        }
        return true;
    }

    private static void mapSchemaTypeToJavaType(CodegenJavaArgument argument, OpenApi31Schema oas31Schema) {
        if (mapStringType(argument, oas31Schema)) {
            return;
        }
        if (mapIntegerType(argument, oas31Schema)) {
            return;
        }
        if (mapNumberType(argument, oas31Schema)) {
            return;
        }
        if (mapBooleanType(argument, oas31Schema)) {
            return;
        }
        mapObjectOrFallbackType(argument, oas31Schema);
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