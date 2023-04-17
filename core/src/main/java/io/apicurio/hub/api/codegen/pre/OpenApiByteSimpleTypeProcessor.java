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

import com.squareup.javapoet.ArrayTypeName;
import io.apicurio.datamodels.combined.visitors.CombinedVisitorAdapter;
import io.apicurio.datamodels.core.models.Extension;
import io.apicurio.datamodels.core.models.common.IDefinition;
import io.apicurio.datamodels.core.models.common.IPropertySchema;
import io.apicurio.datamodels.core.models.common.Schema;
import io.apicurio.datamodels.openapi.models.OasSchema;
import io.apicurio.datamodels.openapi.v3.models.Oas30Schema.Oas30AnyOfSchema;
import io.apicurio.datamodels.openapi.v3.models.Oas30Schema.Oas30NotSchema;
import io.apicurio.datamodels.openapi.v3.models.Oas30Schema.Oas30OneOfSchema;
import io.apicurio.hub.api.codegen.CodegenExtensions;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApiByteSimpleTypeProcessor extends CombinedVisitorAdapter {

    /**
     * @see io.apicurio.datamodels.core.visitors.VisitorAdapter#visitSchema(Schema)
     */
    @Override
    public void visitSchema(Schema node) {
        OasSchema schema = (OasSchema) node;
        if ("string".equals(schema.type) && "byte".equals(schema.format)) {
            schema.type = "object";
            // workaround for a jsonschema2pojo limitation
            schema.addExtraProperty("existingJavaType", "APICURIO_CODEGEN_BYTE_ARRAY_REPRESENTATION");
        }
    }

    /**
     * @see io.apicurio.datamodels.openapi.visitors.OasVisitorAdapter#visitItemsSchema(OasSchema)
     */
    @Override
    public void visitItemsSchema(OasSchema node) {
        visitSchema(node);
    }

    /**
     * @see io.apicurio.datamodels.openapi.visitors.OasVisitorAdapter#visitPropertySchema(IPropertySchema)
     */
    @Override
    public void visitPropertySchema(IPropertySchema node) {
        visitSchema((Schema) node);
    }

    /**
     * @see CombinedVisitorAdapter#visitSchemaDefinition(IDefinition)
     */
    @Override
    public void visitSchemaDefinition(IDefinition node) {
        visitSchema((Schema) node);
    }

    /**
     * @see CombinedVisitorAdapter#visitAdditionalPropertiesSchema(OasSchema)
     */
    @Override
    public void visitAdditionalPropertiesSchema(OasSchema node) {
        visitSchema(node);
    }

    /**
     * @see CombinedVisitorAdapter#visitOneOfSchema(Oas30OneOfSchema)
     */
    @Override
    public void visitOneOfSchema(Oas30OneOfSchema node) {
        visitSchema(node);
    }

    /**
     * @see CombinedVisitorAdapter#visitAllOfSchema(OasSchema)
     */
    @Override
    public void visitAllOfSchema(OasSchema node) {
        visitSchema(node);
    }

    /**
     * @see CombinedVisitorAdapter#visitAnyOfSchema(Oas30AnyOfSchema)
     */
    @Override
    public void visitAnyOfSchema(Oas30AnyOfSchema node) {
        visitSchema(node);
    }

    /**
     * @see CombinedVisitorAdapter#visitNotSchema(Oas30NotSchema)
     */
    @Override
    public void visitNotSchema(Oas30NotSchema node) {
        visitSchema(node);
    }

}
