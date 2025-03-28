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

package io.apicurio.hub.api.codegen.post;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import io.apicurio.hub.api.codegen.beans.CodegenBeanAnnotationDirective;

/**
 * @author eric.wittmann@gmail.com
 */
public class JavaBeanPostProcessor {

    /**
     * Provides an opportunity to post-process a java bean class that was generated by the
     * codegen layer.
     * @param className
     * @param annotations
     * @param beanData
     * @throws IOException
     */
    public ByteArrayOutputStream process(String className, List<CodegenBeanAnnotationDirective> annotations, ByteArrayOutputStream beanData) throws IOException {
        boolean modified = false;
        String content = beanData.toString(StandardCharsets.UTF_8.name());
        if (content.contains("import java.lang.String;")) {
            content = content.replaceAll("import java.lang.String;", "");
            modified = true;
        }
        if (content.contains("java.lang.String")) {
            content = content.replaceAll("java.lang.String", "String");
            modified = true;
        }
        if (content.contains("APICURIO_CODEGEN_BYTE_ARRAY_REPRESENTATION")) {
            content = content.replaceAll("APICURIO_CODEGEN_BYTE_ARRAY_REPRESENTATION", "byte[]");
            modified = true;
        }

        boolean isEnum = content.contains("public enum");

        // TODO add the annotations as imports first, then use local names rather than FQN
        if (annotations != null && !annotations.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            int annotationCount = 0;
            for (CodegenBeanAnnotationDirective annotation : annotations) {
                if (annotation.isExcludeEnums() && isEnum) {
                    // skip this annotation - should not be applied to enums
                } else {
                    builder.append("@");
                    builder.append(annotation.getAnnotation());
                    builder.append("\n");
                    annotationCount++;
                }
            }
            if (annotationCount > 0) {
                content = content.replace("public class ", builder.toString() + "public class ");
                content = content.replace("public enum ", builder.toString() + "public enum ");
                modified = true;
            }
        }

        if (modified) {
            ByteArrayOutputStream rval = new ByteArrayOutputStream();
            rval.write(content.getBytes(StandardCharsets.UTF_8.name()));
            return rval;
        }
        return beanData;
    }

}
