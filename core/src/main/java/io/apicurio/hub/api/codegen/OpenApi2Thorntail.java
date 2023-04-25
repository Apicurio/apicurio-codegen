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

import io.apicurio.datamodels.Library;
import io.apicurio.datamodels.core.util.VisitorUtil;
import io.apicurio.datamodels.core.visitors.TraverserDirection;
import io.apicurio.hub.api.codegen.beans.CodegenInfo;
import io.apicurio.hub.api.codegen.beans.CodegenJavaBean;
import io.apicurio.hub.api.codegen.beans.CodegenJavaInterface;
import io.apicurio.hub.api.codegen.jaxrs.CodegenTarget;
import io.apicurio.hub.api.codegen.jaxrs.InterfacesVisitor;
import io.apicurio.hub.api.codegen.jaxrs.OpenApi2CodegenVisitor;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * Class used to generate a Thorntail JAX-RS project from an OpenAPI document.
 *
 * @author eric.wittmann@gmail.com
 */
public class OpenApi2Thorntail extends OpenApi2JaxRs {

    /**
     * Constructor.
     */
    public OpenApi2Thorntail() {
        super();
    }

    /**
     * @see io.apicurio.hub.api.codegen.OpenApi2JaxRs#generateAll(io.apicurio.hub.api.codegen.beans.CodegenInfo, java.lang.StringBuilder, java.util.zip.ZipOutputStream)
     */
    @Override
    protected void generateAll(CodegenInfo info, StringBuilder log, ZipOutputStream zipOutput)
            throws IOException {
        super.generateAll(info, log, zipOutput);
        if (!this.isUpdateOnly()) {
            log.append("Generating Dockerfile\r\n");
            zipOutput.putNextEntry(new ZipEntry("Dockerfile"));
            zipOutput.write(generateDockerfile().getBytes());
            zipOutput.closeEntry();

            log.append("Generating openshift-template.yml\r\n");
            zipOutput.putNextEntry(new ZipEntry("openshift-template.yml"));
            zipOutput.write(generateOpenshiftTemplate().getBytes());
            zipOutput.closeEntry();

            log.append("Generating src/main/resources/META-INF/microprofile-config.properties\r\n");
            zipOutput.putNextEntry(new ZipEntry("src/main/resources/META-INF/microprofile-config.properties"));
            zipOutput.write(generateMicroprofileConfigProperties().getBytes());
            zipOutput.closeEntry();
        }
    }

    /**
     * Generates the JaxRsApplication java class.
     */
    @Override
    protected String generateJaxRsApplication() {
        return generateJaxRsApplication("javax");
    }

    /**
     * Generates a Jax-rs interface from the given codegen information.
     * @param info
     * @param interfaceInfo
     */
    @Override
    protected String generateJavaInterface(CodegenInfo info, CodegenJavaInterface interfaceInfo) {
        return generateJavaInterface(info, interfaceInfo, "javax");
    }

    @Override
    protected CodegenInfo getInfoFromApiDoc() throws IOException {
        document = Library.readDocumentFromJSONString(openApiDoc);

        // Pre-process the document
        document = preProcess(document);

        // Figure out the breakdown of the interfaces.
        InterfacesVisitor iVisitor = new InterfacesVisitor();
        VisitorUtil.visitTree(document, iVisitor, TraverserDirection.down);

        // Then generate the CodegenInfo object.
        OpenApi2CodegenVisitor cgVisitor = new OpenApi2CodegenVisitor(this.settings.javaPackage, iVisitor.getInterfaces(), CodegenTarget.THORNTAIL);
        VisitorUtil.visitTree(document, cgVisitor, TraverserDirection.down);

        // Now resolve any inline schemas/types
        CodegenInfo info = cgVisitor.getCodegenInfo();
        info.getInterfaces().forEach(iface -> {
            iface.getMethods().forEach(method -> {
                method.getArguments().forEach(arg -> {
                    String argTypeSig = arg.getTypeSignature();
                    CodegenJavaBean matchingBean = findMatchingBean(info, argTypeSig);
                    if (matchingBean != null) {
                        arg.setType(matchingBean.getPackage() + "." + StringUtils.capitalize(matchingBean.getName()));
                    }
                });
            });
        });
        String contextRoot = getContextRoot(document);
        if (contextRoot != null) {
            info.setContextRoot(contextRoot);
        }
        return info;
    }

    /**
     * Generates the Dockerfile.
     */
    private String generateDockerfile() throws IOException {
        String template = IOUtils.toString(getResource("Dockerfile"), Charset.forName("UTF-8"));
        return template.replace("$ARTIFACT_ID$", this.getSettings().artifactId);
    }

    /**
     * Generates the openshift-template.yml file.
     */
    private String generateOpenshiftTemplate() throws IOException {
        String template = IOUtils.toString(getResource("openshift-template.yml"), Charset.forName("UTF-8"));
        return template.replace("$ARTIFACT_ID$", this.getSettings().artifactId);
    }

    /**
     * Generates the microprofile-config.properties file to include in the generated project.
     */
    private String generateMicroprofileConfigProperties() throws IOException {
        String template = IOUtils.toString(getResource("microprofile-config.properties"), Charset.forName("UTF-8"));
        return template;
    }

}
