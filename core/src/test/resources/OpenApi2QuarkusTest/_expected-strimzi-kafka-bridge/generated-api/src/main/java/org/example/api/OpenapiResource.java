package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/openapi")
public interface OpenapiResource {
  /**
   * Retrieves the OpenAPI v2 specification in JSON format.
   */
  @GET
  @Produces("application/json")
  String openapi();
}
