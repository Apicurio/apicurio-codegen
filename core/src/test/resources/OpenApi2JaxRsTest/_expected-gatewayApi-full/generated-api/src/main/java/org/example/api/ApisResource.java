package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.example.api.beans.API;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/apis")
public interface ApisResource {
  /**
   * <p>
   * Publish an API and make it immediately available on the gateway.
   * </p>
   *
   */
  @Operation(description = "Publish an API and make it immediately available on the gateway.", summary = "Publish an API")
  @PUT
  @Consumes("application/json")
  void publishAnAPI(@NotNull API data);
}
