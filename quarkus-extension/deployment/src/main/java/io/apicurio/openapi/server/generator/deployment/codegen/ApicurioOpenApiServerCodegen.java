package io.apicurio.openapi.server.generator.deployment.codegen;

import io.apicurio.hub.api.codegen.JaxRsProjectSettings;
import io.apicurio.hub.api.codegen.OpenApi2JaxRs;
import io.quarkus.bootstrap.prebuild.CodeGenException;
import io.quarkus.deployment.CodeGenContext;
import io.quarkus.deployment.CodeGenProvider;
import org.apache.commons.io.IOUtils;
import org.eclipse.microprofile.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import static io.apicurio.openapi.server.generator.deployment.CodegenConfig.getBasePackagePropertyName;
import static io.apicurio.openapi.server.generator.deployment.CodegenConfig.getSpecPropertyName;

public class ApicurioOpenApiServerCodegen implements CodeGenProvider {

    private static final Logger log = LoggerFactory.getLogger(ApicurioOpenApiServerCodegen.class);

    private static final String DEFAULT_PACKAGE = "io.apicurio.api";

    @Override
    public String providerId() {
        return "APICURIO_OPENAPI_SERVER";
    }

    @Override
    public String inputExtension() {
        return "APICURIO_OPENAPI_SERVER";
    }

    @Override
    public String inputDirectory() {
        return "openapi";
    }

    @Override
    public boolean trigger(CodeGenContext context) throws CodeGenException {
        final Path outDir = context.outDir();
        generate(context.config(), outDir.toFile());
        return true;
    }

    public void generate(Config config, final File outDir) throws CodeGenException {
        final URL openApiResource = getClass().getResource(config.getValue(getSpecPropertyName(), String.class));
        Objects.requireNonNull(openApiResource);
        File openApiSpec = new File(openApiResource.toString());
        final String basePackage = getBasePackage(config);

        log.info("Generating JAX-RS interfaces and beans from: " + openApiSpec);
        if (openApiSpec.isFile()) {
            throw new CodeGenException("Input spec not found.");
        }

        if (outDir.isFile()) {
            throw new CodeGenException(
                    "Output directory is unexpectedly a file (should be a directory or non-existent).");
        }

        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        JaxRsProjectSettings projectSettings = new JaxRsProjectSettings();
        projectSettings.setJavaPackage(basePackage);
        projectSettings.setReactive(false);
        projectSettings.setCodeOnly(true);
        projectSettings.setCliGenCI(false);
        projectSettings.setMavenFileStructure(false);
        projectSettings.setIncludeSpec(false);
        projectSettings.setCliGenCI(false);

        // Generate code - output a ZIP file.
        File zipFile = new File(outDir, "generated-code.zip");
        try (FileOutputStream fos = new FileOutputStream(zipFile)) {
            OpenApi2JaxRs generator = new OpenApi2JaxRs();
            generator.setSettings(projectSettings);
            generator.setOpenApiDocument(openApiResource);
            log.info("Generating code...");
            generator.generate(fos);
        } catch (Exception e) {
            log.error("Error generating code from openapi spec", e);
            throw new CodeGenException(e);
        }

        // Unpack the temporary ZIP file
        log.info("Code generated, unpacking the output ZIP.");
        try {
            unzip(zipFile, outDir);
        } catch (IOException e) {
            log.error("Error generating code from openapi spec", e);
            throw new CodeGenException(e);
        } finally {
            // Delete the temporary ZIP file
            zipFile.delete();
        }

        log.info("Code successfully generated.");
    }

    private void unzip(File fromZipFile, File toOutputDir) throws ZipException, IOException {
        try (java.util.zip.ZipFile zipFile = new ZipFile(fromZipFile)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                File entryDestination = new File(toOutputDir, entry.getName());
                if (entry.isDirectory()) {
                    entryDestination.mkdirs();
                } else {
                    entryDestination.getParentFile().mkdirs();
                    try (InputStream in = zipFile.getInputStream(entry);
                         OutputStream out = new FileOutputStream(entryDestination)) {
                        IOUtils.copy(in, out);
                    }
                }
            }
        }
    }

    private String getBasePackage(final Config config) {
        return config
                .getOptionalValue(getBasePackagePropertyName(), String.class)
                .orElse(DEFAULT_PACKAGE);
    }
}
