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

package io.apicurio.hub.api.codegen;

import org.junit.Test;

import java.io.IOException;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApi2ThorntailTest extends OpenApi2TestBase {

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2Thorntail#generate()}.
     */
    @Test
    public void testGenerateFull() throws IOException {
        doFullTest("OpenApi2ThorntailTest/beer-api.json", false, "_expected-full/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2Thorntail#generate()}.
     */
    @Test
    public void testGenerateFull_GatewayApi() throws IOException {
        doFullTest("OpenApi2ThorntailTest/gateway-api.json", false, "_expected-gatewayApi-full/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2Thorntail#generate()}.
     */
    @Test
    public void testGenerateUpdateOnly() throws IOException {
        doFullTest("OpenApi2ThorntailTest/beer-api.json", true, "_expected-full/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2Thorntail#generate()}.
     */
    @Test
    public void testGenerateFull_RdaApi() throws IOException {
        doFullTest("OpenApi2ThorntailTest/rda-api.json", false, "_expected-rda", false);
    }

    /**
     * Shared test method.
     * @param apiDef
     * @param updateOnly
     * @param expectedFilesPath
     * @param debug
     * @throws IOException
     */
    private void doFullTest(String apiDef, boolean updateOnly, String expectedFilesPath, boolean debug) throws IOException {
        OpenApi2Thorntail generator = new OpenApi2Thorntail();
        generator.setUpdateOnly(updateOnly);
        generator.setOpenApiDocument(getClass().getClassLoader().getResource(apiDef));
        super.doFullTest(generator, expectedFilesPath, debug);
    }
}
