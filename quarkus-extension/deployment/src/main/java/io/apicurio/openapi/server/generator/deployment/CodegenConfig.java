package io.apicurio.openapi.server.generator.deployment;

import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.common.utils.StringUtil;

import java.nio.file.Path;

@ConfigRoot(name = CodegenConfig.CODEGEN_TIME_CONFIG_PREFIX, phase = ConfigPhase.BUILD_TIME)
public class CodegenConfig {

    static final String CODEGEN_TIME_CONFIG_PREFIX = "apicurio.codegen.openapi";
    private static final String BASE_PACKAGE_PROP_FORMAT = "%s.base-package";
    static final String BUILD_TIME_SPEC_PREFIX_FORMAT = CODEGEN_TIME_CONFIG_PREFIX + ".spec.%s";


    public static String getBasePackagePropertyName(final Path openApiFilePath) {
        return String.format(BASE_PACKAGE_PROP_FORMAT, getBuildTimeSpecPropertyPrefix(openApiFilePath));
    }

    public static String getBuildTimeSpecPropertyPrefix(final Path openApiFilePath) {
        return String.format(BUILD_TIME_SPEC_PREFIX_FORMAT, openApiFilePath);
    }
}
