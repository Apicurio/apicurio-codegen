package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/meta")
public interface MetaResource {
  /**
   * <p>
   * This endpoint provides a list of GitHub's IP addresses. For more information,
   * see &quot;<a href=
   * "https://help.github.com/articles/about-github-s-ip-addresses/">About
   * GitHub's IP addresses</a>.&quot;
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  Response meta_get();
}
