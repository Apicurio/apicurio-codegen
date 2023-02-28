package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/emojis")
public interface EmojisResource {
  /**
   * Lists all the emojis available to use on GitHub.
   */
  @GET
  @Produces("application/json")
  Response emojis_get();
}
