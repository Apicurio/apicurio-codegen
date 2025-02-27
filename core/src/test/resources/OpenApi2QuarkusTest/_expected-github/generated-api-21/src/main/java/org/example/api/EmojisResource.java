package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/emojis")
public interface EmojisResource {
  /**
   * <p>
   * Lists all the emojis available to use on GitHub.
   * </p>
   *
   */
  @Operation(description = "Lists all the emojis available to use on GitHub.", summary = "Get emojis", operationId = "emojis/get")
  @GET
  @Produces("application/json")
  Response emojis_get();
}
