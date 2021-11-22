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

package io.apicurio.hub.api.codegen.beans;

/**
 * @author eric.wittmann@gmail.com
 */
public class CodegenBeanAnnotationDirective {

    private String annotation;
    private boolean excludeEnums;

    /**
     * @return the annotation
     */
    public String getAnnotation() {
        return annotation;
    }

    /**
     * @param annotation the annotation to set
     */
    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    /**
     * @return the excludeEnums
     */
    public boolean isExcludeEnums() {
        return excludeEnums;
    }

    /**
     * @param excludeEnums the excludeEnums to set
     */
    public void setExcludeEnums(boolean excludeEnums) {
        this.excludeEnums = excludeEnums;
    }

}
