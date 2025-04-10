package org.example.api;

import org.eclipse.microprofile.openapi.annotations.OpenApiDefinition;

/**
 * Beer API 1.0.0
 */
@OpenApiDefinition(info = @org.eclipse.microprofile.openapi.annotations.info.Info(title = "Beer API", version = "1.0.0"))
public class Application extends jakarta.ws.rs.core.Application {
}
