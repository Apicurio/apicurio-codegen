package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/healthy")
public interface HealthyResource {
  /**
   * <p>
   * Check if the bridge is running. This does not necessarily imply that it is
   * ready to accept requests.
   * </p>
   *
   */
  @Operation(description = "Check if the bridge is running. This does not necessarily imply that it is ready to accept requests.", operationId = "healthy")
  @GET
  void healthy();
}
