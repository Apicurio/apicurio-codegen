package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/")
public interface RootResource {
  /**
   * Get Hypermedia links to resources accessible in GitHub's REST API
   */
  @GET
  @Produces("application/json")
  Response meta_root();
}
