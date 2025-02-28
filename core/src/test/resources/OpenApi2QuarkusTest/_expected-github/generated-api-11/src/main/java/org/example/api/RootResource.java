package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/")
public interface RootResource {
  /**
   * <p>
   * Get Hypermedia links to resources accessible in GitHub's REST API
   * </p>
   *
   */
  @Operation(description = "Get Hypermedia links to resources accessible in GitHub's REST API", summary = "GitHub API Root", operationId = "meta/root")
  @GET
  @Produces("application/json")
  Response meta_root();
}
