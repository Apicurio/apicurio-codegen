package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

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
  @GET
  @Produces("text/plain")
  String meta_get_zen();
}
