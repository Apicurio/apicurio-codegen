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

package io.apicurio.codegen.cli;

import io.apicurio.hub.api.codegen.OpenApi2JaxRs;
import io.apicurio.hub.api.codegen.OpenApi2Quarkus;
import io.apicurio.hub.api.codegen.OpenApi2Thorntail;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.apache.commons.io.FileUtils;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

@Command(name = "apicurio-codegen", mixinStandardHelpOptions = true, helpCommand = true)
@RegisterForReflection(targets = {
        java.lang.Object.class,
        java.util.Map.class,
        javax.annotation.processing.Generated.class,
        // The following list is generated running `jbang cli/tools/extractRegisterForReflection.java`
        io.apicurio.datamodels.asyncapi.models.AaiChannelBindings.class,
        io.apicurio.datamodels.asyncapi.models.AaiChannelBindingsDefinition.class,
        io.apicurio.datamodels.asyncapi.models.AaiChannelItem.class,
        io.apicurio.datamodels.asyncapi.models.AaiComponents.class,
        io.apicurio.datamodels.asyncapi.models.AaiContact.class,
        io.apicurio.datamodels.asyncapi.models.AaiCorrelationId.class,
        io.apicurio.datamodels.asyncapi.models.AaiDocument.class,
        io.apicurio.datamodels.asyncapi.models.AaiExternalDocumentation.class,
        io.apicurio.datamodels.asyncapi.models.AaiHeaderItem.class,
        io.apicurio.datamodels.asyncapi.models.AaiInfo.class,
        io.apicurio.datamodels.asyncapi.models.AaiLicense.class,
        io.apicurio.datamodels.asyncapi.models.AaiMessage.class,
        io.apicurio.datamodels.asyncapi.models.AaiMessageBase.class,
        io.apicurio.datamodels.asyncapi.models.AaiMessageBindings.class,
        io.apicurio.datamodels.asyncapi.models.AaiMessageBindingsDefinition.class,
        io.apicurio.datamodels.asyncapi.models.AaiMessageTrait.class,
        io.apicurio.datamodels.asyncapi.models.AaiMessageTraitDefinition.class,
        io.apicurio.datamodels.asyncapi.models.AaiOAuthFlows.class,
        io.apicurio.datamodels.asyncapi.models.AaiOperation.class,
        io.apicurio.datamodels.asyncapi.models.AaiOperationBase.class,
        io.apicurio.datamodels.asyncapi.models.AaiOperationBindings.class,
        io.apicurio.datamodels.asyncapi.models.AaiOperationBindingsDefinition.class,
        io.apicurio.datamodels.asyncapi.models.AaiOperationTrait.class,
        io.apicurio.datamodels.asyncapi.models.AaiOperationTraitDefinition.class,
        io.apicurio.datamodels.asyncapi.models.AaiParameter.class,
        io.apicurio.datamodels.asyncapi.models.AaiSchema.class,
        io.apicurio.datamodels.asyncapi.models.AaiSecurityRequirement.class,
        io.apicurio.datamodels.asyncapi.models.AaiSecurityScheme.class,
        io.apicurio.datamodels.asyncapi.models.AaiServer.class,
        io.apicurio.datamodels.asyncapi.models.AaiServerBindings.class,
        io.apicurio.datamodels.asyncapi.models.AaiServerBindingsDefinition.class,
        io.apicurio.datamodels.asyncapi.models.AaiServerVariable.class,
        io.apicurio.datamodels.asyncapi.models.AaiTag.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20AuthorizationCodeOAuthFlow.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20ChannelBindings.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20ChannelBindingsDefinition.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20ChannelItem.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20ClientCredentialsOAuthFlow.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Components.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Contact.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20CorrelationId.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Document.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20ExternalDocumentation.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20HeaderItem.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20ImplicitOAuthFlow.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Info.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20License.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Message.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20MessageBindings.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20MessageBindingsDefinition.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20MessageTrait.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20MessageTraitDefinition.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20OAuthFlows.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Operation.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20OperationBindings.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20OperationBindingsDefinition.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20OperationTrait.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20OperationTraitDefinition.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Parameter.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20PasswordOAuthFlow.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Schema.Aai20AdditionalPropertiesSchema.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Schema.Aai20AllOfSchema.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Schema.Aai20AnyOfSchema.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Schema.Aai20NotSchema.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Schema.Aai20OneOfSchema.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Schema.Aai20PropertySchema.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Schema.Aai30ItemsSchema.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Schema.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20SchemaDefinition.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20SecurityRequirement.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20SecurityScheme.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Server.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20ServerBindings.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20ServerBindingsDefinition.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20ServerVariable.class,
        io.apicurio.datamodels.asyncapi.v2.models.Aai20Tag.class,
        io.apicurio.datamodels.core.models.Document.class,
        io.apicurio.datamodels.core.models.ExtensibleNode.class,
        io.apicurio.datamodels.core.models.Extension.class,
        io.apicurio.datamodels.core.models.common.AuthorizationCodeOAuthFlow.class,
        io.apicurio.datamodels.core.models.common.ClientCredentialsOAuthFlow.class,
        io.apicurio.datamodels.core.models.common.Components.class,
        io.apicurio.datamodels.core.models.common.Contact.class,
        io.apicurio.datamodels.core.models.common.ExternalDocumentation.class,
        io.apicurio.datamodels.core.models.common.ImplicitOAuthFlow.class,
        io.apicurio.datamodels.core.models.common.Info.class,
        io.apicurio.datamodels.core.models.common.License.class,
        io.apicurio.datamodels.core.models.common.ModernSecurityScheme.class,
        io.apicurio.datamodels.core.models.common.OAuthFlow.class,
        io.apicurio.datamodels.core.models.common.OAuthFlows.class,
        io.apicurio.datamodels.core.models.common.Operation.class,
        io.apicurio.datamodels.core.models.common.Parameter.class,
        io.apicurio.datamodels.core.models.common.PasswordOAuthFlow.class,
        io.apicurio.datamodels.core.models.common.Schema.class,
        io.apicurio.datamodels.core.models.common.SecurityRequirement.class,
        io.apicurio.datamodels.core.models.common.SecurityScheme.class,
        io.apicurio.datamodels.core.models.common.Server.class,
        io.apicurio.datamodels.core.models.common.ServerVariable.class,
        io.apicurio.datamodels.core.models.common.Tag.class,
        io.apicurio.datamodels.openapi.models.OasContact.class,
        io.apicurio.datamodels.openapi.models.OasDocument.class,
        io.apicurio.datamodels.openapi.models.OasExternalDocumentation.class,
        io.apicurio.datamodels.openapi.models.OasHeader.class,
        io.apicurio.datamodels.openapi.models.OasInfo.class,
        io.apicurio.datamodels.openapi.models.OasLicense.class,
        io.apicurio.datamodels.openapi.models.OasOperation.class,
        io.apicurio.datamodels.openapi.models.OasParameter.class,
        io.apicurio.datamodels.openapi.models.OasPathItem.class,
        io.apicurio.datamodels.openapi.models.OasPaths.class,
        io.apicurio.datamodels.openapi.models.OasResponse.class,
        io.apicurio.datamodels.openapi.models.OasResponses.class,
        io.apicurio.datamodels.openapi.models.OasSchema.class,
        io.apicurio.datamodels.openapi.models.OasSecurityRequirement.class,
        io.apicurio.datamodels.openapi.models.OasTag.class,
        io.apicurio.datamodels.openapi.models.OasXML.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Contact.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Definitions.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Document.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Example.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20ExternalDocumentation.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Header.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Headers.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Info.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Items.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20License.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Operation.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Parameter.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20ParameterDefinition.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20ParameterDefinitions.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20PathItem.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Paths.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Response.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20ResponseDefinition.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20ResponseDefinitions.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Responses.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Schema.Oas20AdditionalPropertiesSchema.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Schema.Oas20AllOfSchema.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Schema.Oas20ItemsSchema.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Schema.Oas20PropertySchema.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Schema.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20SchemaDefinition.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Scopes.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20SecurityDefinitions.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20SecurityRequirement.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20SecurityScheme.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20Tag.class,
        io.apicurio.datamodels.openapi.v2.models.Oas20XML.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30AuthorizationCodeOAuthFlow.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Callback.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30CallbackDefinition.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30CallbackPathItem.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30ClientCredentialsOAuthFlow.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Components.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Contact.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Discriminator.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Document.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Encoding.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Example.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30ExampleDefinition.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30ExternalDocumentation.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Header.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30HeaderDefinition.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30ImplicitOAuthFlow.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Info.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30License.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Link.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30LinkDefinition.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30LinkParameterExpression.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30LinkRequestBodyExpression.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30LinkServer.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30MediaType.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30OAuthFlows.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Operation.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Parameter.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30ParameterDefinition.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30PasswordOAuthFlow.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30PathItem.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Paths.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30RequestBody.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30RequestBodyDefinition.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Response.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30ResponseDefinition.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Responses.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Schema.Oas30AdditionalPropertiesSchema.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Schema.Oas30AllOfSchema.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Schema.Oas30AnyOfSchema.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Schema.Oas30ItemsSchema.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Schema.Oas30NotSchema.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Schema.Oas30OneOfSchema.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Schema.Oas30PropertySchema.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Schema.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30SchemaDefinition.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30SecurityRequirement.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30SecurityScheme.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Server.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30ServerVariable.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30Tag.class,
        io.apicurio.datamodels.openapi.v3.models.Oas30XML.class
})
public class GenerateJavaSources implements Runnable {

    @Option(names = { "-s", "--spec" }, description = "The specification to be used", required = true)
    File spec = null;

    @Option(names = { "-o", "--output" }, description = "The ZIP archive to be generated", required = true)
    File out = null;

    @Option(names = { "--code-only" }, description = "Generates only the code and do not scaffold the entire project")
    boolean codeOnly = true;

    @Option(names = { "--update-only" }, description = "Generates only updated files")
    boolean updateOnly = false;

    @Option(names = { "--reactive" }, description = "Generate the reactive version")
    boolean reactive = false;

    @Option(names = { "--artifact-id" }, description = "The generated artifact id")
    String artifactId = "generated-api";

    @Option(names = { "--group-id" }, description = "The generated group id")
    String groupId = "org.example.api";

    @Option(names = { "--java-package" }, description = "The target java package")
    String javaPackage = "org.example.api";

    enum Generator {
        JAX_RS,
        QUARKUS,
        THORNTAIL
    }

    @Option(names = { "--generator" }, description = "The generator to be used")
    Generator generatorType = Generator.JAX_RS;

    @Override
    public void run() {

        OpenApi2JaxRs.JaxRsProjectSettings settings = new OpenApi2JaxRs.JaxRsProjectSettings();
        settings.codeOnly = codeOnly;
        settings.reactive = reactive;
        settings.artifactId = artifactId;
        settings.groupId = groupId;
        settings.javaPackage = javaPackage;

        OpenApi2JaxRs generator = null;
        switch (generatorType) {
            case JAX_RS:
                generator = new OpenApi2JaxRs();
                break;
            case QUARKUS:
                generator = new OpenApi2Quarkus();
                break;
            case THORNTAIL:
                generator = new OpenApi2Thorntail();
                break;
        }
        generator.setSettings(settings);
        generator.setUpdateOnly(updateOnly);
        try {
            generator.setOpenApiDocument(new FileInputStream(spec));

            ByteArrayOutputStream outputStream = generator.generate();

            FileUtils.writeByteArrayToFile(out, outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new GenerateJavaSources()).execute(args);
        System.exit(exitCode);
    }
}
