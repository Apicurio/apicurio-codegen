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

/**
 * @author eric.wittmann@gmail.com
 */
public class CodegenJavaReturn {

    private String collection;
    private String type;
    private String format;

    /**
     * Constructor.
     */
    public CodegenJavaReturn() {
    }

    /**
     * @return the collection
     */
    public String getCollection() {
        return collection;
    }

    /**
     * @param collection the collection to set
     */
    public void setCollection(String collection) {
        this.collection = collection;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }
}
