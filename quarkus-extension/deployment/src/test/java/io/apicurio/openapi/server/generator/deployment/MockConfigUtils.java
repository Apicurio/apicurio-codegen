package io.apicurio.openapi.server.generator.deployment;

import io.smallrye.config.PropertiesConfigSource;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Objects;

public final class MockConfigUtils {

    private MockConfigUtils() {
    }

    public static Config getTestConfig(String propertiesFile) {
        PropertiesConfigSource configSource;
        try {
            configSource = new PropertiesConfigSource(getResource(propertiesFile));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return ConfigProviderResolver
                .instance()
                .getBuilder()
                .withSources(configSource)
                .build();
    }

    private static URL getResource(String resourcePath) {
        return Objects.requireNonNull(MockConfigUtils.class.getResource(resourcePath));
    }
}

