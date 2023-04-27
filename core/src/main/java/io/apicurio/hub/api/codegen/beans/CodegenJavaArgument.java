/*
 * Copyright 2018 JBoss Inc
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

import java.util.List;
import java.util.Objects;

/**
 * @author eric.wittmann@gmail.com
 */
public class CodegenJavaArgument extends CodegenJavaSchema {

    private String name;
    private String in;
    private boolean required;
    private String typeSignature;
    private List<CodegenBeanAnnotationDirective> annotations;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(annotations, in, name, required, typeSignature);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        CodegenJavaArgument other = (CodegenJavaArgument) obj;
        return Objects.equals(annotations, other.annotations) && Objects.equals(in, other.in)
                && Objects.equals(name, other.name) && required == other.required
                && Objects.equals(typeSignature, other.typeSignature);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the in
     */
    public String getIn() {
        return in;
    }

    /**
     * @param in the in to set
     */
    public void setIn(String in) {
        this.in = in;
    }

    /**
     * @return the required
     */
    public boolean getRequired() {
        return required;
    }

    /**
     * @param required the required to set
     */
    public void setRequired(boolean required) {
        this.required = required;
    }

    /**
     * @return the typeSignature
     */
    public String getTypeSignature() {
        return typeSignature;
    }

    /**
     * @param typeSignature the typeSignature to set
     */
    public void setTypeSignature(String typeSignature) {
        this.typeSignature = typeSignature;
    }

    /**
     * @return the annotations
     */
    public List<CodegenBeanAnnotationDirective> getAnnotations() {
        return annotations;
    }

    /**
     * @param annotations the annotations to set
     */
    public void setAnnotations(List<CodegenBeanAnnotationDirective> annotations) {
        this.annotations = annotations;
    }
}
