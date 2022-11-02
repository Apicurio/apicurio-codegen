package io.apicurio.openapi.server.generator.deployment.codegen;

import io.apicurio.hub.api.codegen.JaxRsProjectSettings;
import io.apicurio.hub.api.codegen.OpenApi2JaxRs;
import io.apicurio.openapi.server.generator.deployment.CodegenConfig;
import io.quarkus.bootstrap.prebuild.CodeGenException;
import io.quarkus.deployment.CodeGenContext;
import io.quarkus.deployment.CodeGenProvider;
import org.apache.commons.io.IOUtils;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.eclipse.microprofile.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class ApicurioOpenApiServerGeneratorCodeGen implements CodeGenProvider {

    private static final Logger log = LoggerFactory.getLogger(ApicurioOpenApiServerGeneratorCodeGen.class);
    private static final String DEFAULT_PACKAGE = "org.openapi.quarkus";


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
        final Path openApiDir = context.inputDir();

        return true;
    }

    public void generate(final Config config, final File openApiFilePath, final File outDir) throws CodeGenException {
        log.info("Generating JAX-RS interfaces and beans from: " + openApiFilePath);
        if (openApiFilePath == null || !openApiFilePath.isFile()) {
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
        projectSettings.setReactive(false);

        // Generate code - output a ZIP file.
        File zipFile = new File(outDir, "generated-code.zip");
        try (FileOutputStream fos = new FileOutputStream(zipFile)) {
            OpenApi2JaxRs generator = new OpenApi2JaxRs();
            generator.setSettings(projectSettings);
            generator.setUpdateOnly(true);
            generator.setOpenApiDocument(openApiFilePath.toURI().toURL());
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
}
