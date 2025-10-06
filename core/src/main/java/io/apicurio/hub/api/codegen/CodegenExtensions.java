/*
 * Copyright 2021 Red Hat Inc
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

package io.apicurio.hub.api.codegen;

/**
 * @author eric.wittmann@gmail.com
 */
public class CodegenExtensions {

    /* Serves as the main configuration key under which all global x-codegen settings are defined. */
    public static final String CODEGEN = "x-codegen";
    /* Custom package name used when generating a bean class from an object schema */
    public static final String PACKAGE = "x-codegen-package";
    /* Used to set a generated method to be asynchronous */
    public static final String ASYNC = "x-codegen-async";
    /* Used to override the return type of a generated REST method */
    public static final String RETURN_TYPE = "x-codegen-returnType";
    /* Used to specify extra java annotations to add to a generated bean class */
    public static final String ANNOTATIONS = "x-codegen-annotations";
    /* Used to specify the common context path for all generated REST endpoints */
    public static final String CONTEXT_ROOT = "x-codegen-contextRoot";
    /* Used to override the date-time format pattern for a Date bean property */
    public static final String FORMAT_PATTERN = "x-codegen-formatPattern";
    /* Used to indicate that a data type is inlined instead of generating a separate bean class */
    public static final String INLINE = "x-codegen-inline";
    public static final String INLINED = "x-codegen-inlined";
    /* Used to override the type of a generated bean class */
    public static final String TYPE = "x-codegen-type";
    /* Used to indicate the super class for a generated bean class */
    public static final String EXTENDS_CLASS = "x-codegen-extendsClass";
}
