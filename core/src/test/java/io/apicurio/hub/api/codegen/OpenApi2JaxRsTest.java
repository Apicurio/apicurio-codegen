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

import java.io.IOException;

import org.junit.Test;

/**
 * @author eric.wittmann@gmail.com
 */
public class OpenApi2JaxRsTest extends OpenApi2TestBase {

    private static enum UpdateOnly {
        yes, no
    }
    private static enum Reactive {
        yes, no
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFull() throws IOException {
        doFullTest("OpenApi2JaxRsTest/beer-api.json", UpdateOnly.no, Reactive.no, "_expected-full/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFullPrefixed() throws IOException {
        doFullTest("OpenApi2JaxRsTest/beer-api.json", UpdateOnly.no, Reactive.no, false,
                "_expected-full-prefixed/generated-api", "Test", "", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFullSuffixed() throws IOException {
        doFullTest("OpenApi2JaxRsTest/beer-api.json", UpdateOnly.no, Reactive.no, false,
                "_expected-full-suffixed/generated-api", "", "Test", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFull_GatewayApi() throws IOException {
        doFullTest("OpenApi2JaxRsTest/gateway-api.json", UpdateOnly.no, Reactive.no, "_expected-gatewayApi-full/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFull_RegistryApi() throws IOException {
        doFullTest("OpenApi2JaxRsTest/registry-api.json", UpdateOnly.no, Reactive.no, "_expected-registryApi-full/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFull_RegistryApiV2() throws IOException {
        doFullTest("OpenApi2JaxRsTest/registry-api-v2.json", UpdateOnly.yes, Reactive.no, "_expected-registry-api-v2/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateUpdateOnly() throws IOException {
        doFullTest("OpenApi2JaxRsTest/beer-api.json", UpdateOnly.yes, Reactive.no, "_expected-full/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFullReactive() throws IOException {
        doFullTest("OpenApi2JaxRsTest/beer-api.json", UpdateOnly.no, Reactive.yes, "_expected-reactive-full/generated-api", false);
    }

    @Test
    public void testGenerateFullReactiveWithPrimitives() throws IOException {
        doFullTest("OpenApi2JaxRsTest/reactive-with-primitives.json", UpdateOnly.no, Reactive.yes, "_expected-reactive-with-primitives/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateWithCLIGenCI() throws IOException {
        doFullTest("OpenApi2JaxRsTest/beer-api.json", UpdateOnly.no, Reactive.no, true,
                "_expected-full-with-ci/generated-api", "", "", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFull_Issue885Api() throws IOException {
        // Note: I can't seem to get this working in the maven build, but it works in Eclipse.
        doFullTest("OpenApi2JaxRsTest/issue-885-api.json", UpdateOnly.no, Reactive.no, "_expected-issue885Api-full/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFull_MultipleMediaTypes() throws IOException {
        doFullTest("OpenApi2JaxRsTest/mmt-api.json", UpdateOnly.no, Reactive.no, "_expected-mmt-full/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFull_ContextRoot() throws IOException {
        doFullTest("OpenApi2JaxRsTest/context-root.json", UpdateOnly.no, Reactive.no, "_expected-context-root/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFull_SimpleType() throws IOException {
        doFullTest("OpenApi2JaxRsTest/simple-type.json", UpdateOnly.no, Reactive.no, "_expected-simple-type/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFull_BeanAnnotations() throws IOException {
        doFullTest("OpenApi2JaxRsTest/bean-annotations.json", UpdateOnly.no, Reactive.no, "_expected-bean-annotations/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFull_Inheritance() throws IOException {
        doFullTest("OpenApi2JaxRsTest/inheritance.json", UpdateOnly.yes, Reactive.no, "_expected-inheritance/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFull_NZDAX() throws IOException {
        doFullTest("OpenApi2JaxRsTest/nzdax.json", UpdateOnly.yes, Reactive.no, "_expected-nzdax/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testGenerateFull_CustomResponseType() throws IOException {
        doFullTest("OpenApi2JaxRsTest/custom-response-type.json", UpdateOnly.yes, Reactive.no, "_expected-custom-response-type/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testSchemaExtends() throws IOException {
        doFullTest("OpenApi2JaxRsTest/schema-extends.json", UpdateOnly.yes, Reactive.no, "_expected-schema-extends/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testMasStudio() throws IOException {
        doFullTest("OpenApi2JaxRsTest/mas-studio.json", UpdateOnly.no, Reactive.no, "_expected-mas-studio/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testPetStore() throws IOException {
        doFullTest("OpenApi2JaxRsTest/petstore-openapi.json", UpdateOnly.no, Reactive.no, "_expected-petstore/generated-api", false);
    }

    /**
     * Test method for {@link io.apicurio.hub.api.codegen.OpenApi2JaxRs#generate()}.
     */
    @Test
    public void testConstraintParameters() throws IOException {
        doFullTest("OpenApi2JaxRsTest/constrained-parameters.json", UpdateOnly.no, Reactive.no, "_expected-constrained-parameters/generated-api", false);
    }

        @Test
    public void testSchemaWithDash() throws IOException {
        doFullTest("OpenApi2JaxRsTest/schema-with-dash.json", UpdateOnly.no, Reactive.no, "_expected-schema-with-dash/generated-api", false);
    }

    /**
     * Shared test method.
     * @param apiDef
     * @param updateOnly
     * @param reactive
     * @param expectedFilesPath
     * @param debug
     * @throws IOException
     */
    private void doFullTest(String apiDef, UpdateOnly updateOnly, Reactive reactive, String expectedFilesPath, boolean debug) throws IOException {
        doFullTest(apiDef, updateOnly, reactive, false, expectedFilesPath, "", "", debug);
    }

    /**
     * Shared test method.
     * @param apiDef
     * @param updateOnly
     * @param reactive
     * @param generateCLiGenCI
     * @param expectedFilesPath
     * @param namePrefix
     * @param nameSuffix
     * @param debug
     * @throws IOException
     */
    private void doFullTest(String apiDef, UpdateOnly updateOnly, Reactive reactive, boolean generateCLiGenCI,
            String expectedFilesPath, String namePrefix, String nameSuffix, boolean debug) throws IOException {
        JaxRsProjectSettings settings = new JaxRsProjectSettings();
        settings.codeOnly = false;
        settings.reactive = reactive == Reactive.yes;
        settings.cliGenCI = generateCLiGenCI;
        settings.artifactId = "generated-api";
        settings.groupId = "org.example.api";
        settings.javaPackage = "org.example.api";
        settings.classNamePrefix = namePrefix;
        settings.classNameSuffix = nameSuffix;

        OpenApi2JaxRs generator = new OpenApi2JaxRs();
        generator.setSettings(settings);
        generator.setUpdateOnly(updateOnly == UpdateOnly.yes);
        generator.setOpenApiDocument(getClass().getClassLoader().getResource(apiDef));

        super.doFullTest(generator, expectedFilesPath, debug);
    }

}
