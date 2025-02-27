package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/zen")
public interface ZenResource {
  /**
   * <p>
   * Get a random sentence from the Zen of GitHub
   * </p>
   *
   */
  @Operation(description = "Get a random sentence from the Zen of GitHub", summary = "Get the Zen of GitHub", operationId = "meta/get-zen")
  @GET
  @Produces("text/plain")
  String meta_get_zen();
}
