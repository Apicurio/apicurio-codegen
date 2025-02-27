package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/octocat")
public interface OctocatResource {
  /**
   * <p>
   * Get the octocat as ASCII art
   * </p>
   *
   */
  @Operation(description = "Get the octocat as ASCII art", summary = "Get Octocat", operationId = "meta/get-octocat")
  @GET
  @Produces("application/octocat-stream")
  String meta_get_octocat(@QueryParam("s") String s);
}
