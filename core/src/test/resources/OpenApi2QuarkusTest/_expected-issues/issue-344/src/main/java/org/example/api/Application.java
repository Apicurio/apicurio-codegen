package org.example.api;

import org.eclipse.microprofile.openapi.annotations.OpenApiDefinition;

/**
 * sample api 1.0.0
 */
@OpenApiDefinition(info = @org.eclipse.microprofile.openapi.annotations.info.Info(title = "sample api", version = "1.0.0"))
public class Application extends jakarta.ws.rs.core.Application {
}
