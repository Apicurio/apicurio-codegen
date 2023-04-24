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
public class OpenApi2QuarkusTest extends OpenApi2TestBase {

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2Quarkus#generate()}.
     */
    @Test
    public void testGenerateFull() throws IOException {
        doFullTest("OpenApi2QuarkusTest/beer-api.json", false, "_expected-full/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2Quarkus#generate()}.
     */
    @Test
    public void testGitHubApisFull() throws IOException {
        doFullTest("OpenApi2QuarkusTest/github-apis-deref.json", false, "_expected-github/generated-api", false);
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
        OpenApi2Quarkus generator = new OpenApi2Quarkus();
        generator.setUpdateOnly(updateOnly);
        generator.setOpenApiDocument(getClass().getClassLoader().getResource(apiDef));
        super.doFullTest(generator, expectedFilesPath, debug);
    }

}
