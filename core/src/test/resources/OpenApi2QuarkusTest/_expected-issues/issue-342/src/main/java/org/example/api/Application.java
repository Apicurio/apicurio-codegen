package org.example.api;

import org.eclipse.microprofile.openapi.annotations.OpenApiDefinition;

/**
 * Pet Store API 1.0.0
 */
@OpenApiDefinition(info = @org.eclipse.microprofile.openapi.annotations.info.Info(title = "Pet Store API", version = "1.0.0"))
public class Application extends jakarta.ws.rs.core.Application {
}