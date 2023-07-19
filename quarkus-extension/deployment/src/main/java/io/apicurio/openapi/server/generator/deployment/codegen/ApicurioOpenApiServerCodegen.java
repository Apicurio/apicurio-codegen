package io.apicurio.openapi.server.generator.deployment.codegen;

import static io.apicurio.openapi.server.generator.deployment.CodegenConfig.getBasePackagePropertyName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eclipse.microprofile.config.Config;

import io.apicurio.hub.api.codegen.JaxRsProjectSettings;
import io.apicurio.openapi.server.generator.deployment.CodegenConfig;
import io.quarkus.bootstrap.model.ExtensionCapabilities;
import io.quarkus.bootstrap.prebuild.CodeGenException;
import io.quarkus.deployment.CodeGenContext;
import io.quarkus.deployment.CodeGenProvider;

public class ApicurioOpenApiServerCodegen implements CodeGenProvider {

    private static final String DEFAULT_PACKAGE = "io.apicurio.api";
    private static final Predicate<String> RESTEASY_REACTIVE_PREDICATE = "io.quarkus.resteasy.reactive"::equals;

    @Override
    public String providerId() {
        return "jaxrs";
    }

    @Override
    public String inputExtension() {
        return "json";
    }

    @Override
    public String inputDirectory() {
        return "resources";
    }

    @Override
    public boolean shouldRun(Path sourceDir, Config config) {
        return sourceDir != null && config.getOptionalValue(CodegenConfig.getSpecPropertyName(), String.class)
                .isPresent();
    }

    @Override
    public boolean trigger(CodeGenContext context) throws CodeGenException {
        final Path openApiDir = context.inputDir();
        final Path outDir = context.outDir();
        final Optional<String> spec = context.config().getOptionalValue(CodegenConfig.getSpecPropertyName(), String.class);

        if (Files.isDirectory(openApiDir) && spec.isPresent()) {
            final ApicurioCodegenWrapper apicurioCodegenWrapper =
                    new ApicurioCodegenWrapper(outDir.toFile(), projectSettings(context));

            Path openApiResource = openApiDir.resolve(spec.get());

            if (openApiResource.getFileName().endsWith(inputExtension())) {
                throw new CodeGenException("The OpenApi file name doesn't ends with: " + inputExtension() + " and is an invalid input for the generator");
            }
            if (!openApiResource.toFile().exists()) {
                throw new CodeGenException("The OpenApi file doesn't exists in the path: " + openApiResource.toFile().getAbsolutePath());
            }

            apicurioCodegenWrapper.generate(openApiResource);

            return true;
        }

        return false;
    }

    private static JaxRsProjectSettings projectSettings(CodeGenContext context) {
        Config config = context.config();
        JaxRsProjectSettings projectSettings = new JaxRsProjectSettings();

        projectSettings.setJavaPackage(config
                .getOptionalValue(getBasePackagePropertyName(), String.class)
                .orElse(DEFAULT_PACKAGE));

        projectSettings.setReactive(config
                .getOptionalValue(CodegenConfig.getReactivePropertyName(), Boolean.class)
                .orElseGet(() -> context.applicationModel()
                            .getExtensionCapabilities()
                            .stream()
                            .map(ExtensionCapabilities::getProvidesCapabilities)
                            .flatMap(Collection::stream)
                            .anyMatch(RESTEASY_REACTIVE_PREDICATE)));

        projectSettings.setCodeOnly(true);
        projectSettings.setMavenFileStructure(false);
        projectSettings.setIncludeSpec(false);
        projectSettings.setCliGenCI(false);

        return projectSettings;
    }
}
