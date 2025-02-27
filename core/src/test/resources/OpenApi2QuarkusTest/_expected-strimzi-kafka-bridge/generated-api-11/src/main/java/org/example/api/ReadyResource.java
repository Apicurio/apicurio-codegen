package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/ready")
public interface ReadyResource {
  /**
   * <p>
   * Check if the bridge is ready and can accept requests.
   * </p>
   *
   */
  @Operation(description = "Check if the bridge is ready and can accept requests.", operationId = "ready")
  @GET
  void ready();
}
