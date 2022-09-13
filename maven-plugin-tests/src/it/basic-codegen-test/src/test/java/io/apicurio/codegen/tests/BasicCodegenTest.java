/*
 * Copyright 2022 Red Hat Inc
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

package io.apicurio.codegen.tests;

import org.junit.Test;

import io.apicurio.codegen.tests.basic.api.beans.Widget;

/**
 * Just verify that the code was generated and the jax-rs and widget classes
 * can be loaded.
 * @author eric.wittmann@gmail.com
 */
public class BasicCodegenTest {

    @Test
    public void test() throws Exception {
        Class.forName("io.apicurio.codegen.tests.basic.api.beans.Widget");
        Class.forName("io.apicurio.codegen.tests.basic.api.WidgetsResource");
        
        Widget widget = new Widget();
        widget.setName("Test");
        widget.setDescription("A test widget.");
        widget.toString();
    }

}
