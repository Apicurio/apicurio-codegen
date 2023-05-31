package io.apicurio.openapi.server.generator.deployment.codegen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.IOUtils;
import org.jboss.logging.Logger;

import io.apicurio.hub.api.codegen.JaxRsProjectSettings;
import io.apicurio.hub.api.codegen.OpenApi2JaxRs;
import io.quarkus.bootstrap.prebuild.CodeGenException;

public class ApicurioCodegenWrapper {

    private static final Logger log = Logger.getLogger(ApicurioCodegenWrapper.class);

    private final File outdir;
    private final JaxRsProjectSettings projectSettings;

    public ApicurioCodegenWrapper(File outdir, JaxRsProjectSettings projectSettings) {
        this.outdir = outdir;
        this.projectSettings = projectSettings;
    }

    public void generate(Path openApiResource) throws CodeGenException {
        final File openApiFile = openApiResource.toFile();

        log.infof("Generating JAX-RS interfaces and beans from: %s", openApiResource);

        if (outdir.isFile()) {
            throw new CodeGenException(
                    "Output directory is unexpectedly a file (should be a directory or non-existent).");
        }

        if (!outdir.exists()) {
            outdir.mkdirs();
        }

        // Generate code - output a ZIP file.
        File zipFile = new File(outdir, "generated-code.zip");
        try (FileOutputStream fos = new FileOutputStream(zipFile)) {
            OpenApi2JaxRs generator = new OpenApi2JaxRs();
            generator.setSettings(projectSettings);
            generator.setUpdateOnly(true);
            generator.setOpenApiDocument(new FileInputStream(openApiFile));
            log.info("Generating code...");
            generator.generate(fos);
        } catch (Exception e) {
            log.error("Error generating code from openapi spec", e);
            throw new CodeGenException(e);
        }

        // Unpack the temporary ZIP file
        log.info("Code generated, unpacking the output ZIP.");
        try {
            unzip(zipFile, outdir);
        } catch (IOException e) {
            log.error("Error generating code from openapi spec", e);
            throw new CodeGenException(e);
        } finally {
            // Delete the temporary ZIP file
            zipFile.delete();
        }

        log.info("Code successfully generated.");
    }

    private void unzip(File fromZipFile, File toOutputDir) throws IOException {
        try (ZipFile zipFile = new ZipFile(fromZipFile)) {
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
