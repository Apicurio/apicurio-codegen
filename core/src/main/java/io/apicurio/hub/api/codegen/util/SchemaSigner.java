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

package io.apicurio.hub.api.codegen.util;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

import io.apicurio.datamodels.models.Schema;
import io.apicurio.datamodels.models.openapi.v31.OpenApi31Schema;
import io.apicurio.hub.api.codegen.jaxrs.TraversingOpenApi31VisitorAdapter;

/**
 * @author eric.wittmann@gmail.com
 */
public class SchemaSigner extends TraversingOpenApi31VisitorAdapter {

    private StringBuilder sigSource = new StringBuilder();

    /**
     * Constructor.
     */
    public SchemaSigner() {
    }

    public String getSignature() {
        if (this.sigSource.length() == 0) {
            return null;
        }
        return DigestUtils.sha256Hex(this.sigSource.toString());
    }

    /**
     * @see io.apicurio.datamodels.combined.visitors.CombinedAllNodeVisitor#visitSchema(io.apicurio.datamodels.core.models.common.Schema)
     */
    @Override
    public void visitSchema(Schema node) {
        OpenApi31Schema schema = (OpenApi31Schema) node;
        // Right now we only support simple types.
        if (schema.getType() != null && !schema.getType().equals("object") && !schema.getType().equals("array") && schema.get$ref() == null) {
            // Type
            this.sigSource.append("TYPE:");
            this.sigSource.append(schema.getType());
            // Format
            if (schema.getFormat() != null) {
                this.sigSource.append("|FORMAT:");
                this.sigSource.append(schema.getFormat());
            }
            // Enum
            if (schema.getEnum() != null && schema.getEnum().size() > 0) {
                this.sigSource.append("|ENUM:");
                String[] options = schema.getEnum().toArray(new String[schema.getEnum().size()]);
                Arrays.sort(options);
                for (String option : options) {
                    this.sigSource.append(option);
                    this.sigSource.append(",");
                }
            }


            // Max
            if (schema.getMaximum() != null) {
                this.sigSource.append("|MAX:");
                this.sigSource.append(schema.getMaximum());
            }
            // Max Items
            if (schema.getMaxItems() != null) {
                this.sigSource.append("|MAXITEMS:");
                this.sigSource.append(schema.getMaxItems());
            }
            // Max Length
            if (schema.getMaxLength() != null) {
                this.sigSource.append("|MAXLENGTH:");
                this.sigSource.append(schema.getMaxLength());
            }
            // Min
            if (schema.getMinimum() != null) {
                this.sigSource.append("|MIN:");
                this.sigSource.append(schema.getMinimum());
            }
            // Min Items
            if (schema.getMinItems() != null) {
                this.sigSource.append("|MINITEMS:");
                this.sigSource.append(schema.getMinItems());
            }
            // Min Length
            if (schema.getMinLength() != null) {
                this.sigSource.append("|MINLENGTH:");
                this.sigSource.append(schema.getMinLength());
            }
            // Min Properties
            if (schema.getMinProperties() != null) {
                this.sigSource.append("|MINPROPS:");
                this.sigSource.append(schema.getMinProperties());
            }
            // Multiple Of
            if (schema.getMultipleOf() != null) {
                this.sigSource.append("|MULTIPLEOF:");
                this.sigSource.append(schema.getMultipleOf());
            }
            // Pattern
            if (schema.getPattern() != null) {
                this.sigSource.append("|PATTERN:");
                this.sigSource.append(schema.getPattern());
            }
        }
    }

}
