package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/rate_limit")
public interface RateResource {
  /**
   * **Note:** Accessing this endpoint does not count against your REST API rate limit.
   *
   * **Note:** The `rate` object is deprecated. If you're writing new API client code or updating existing code, you should use the `core` object instead of the `rate` object. The `core` object contains the same information that is present in the `rate` object.
   */
  @GET
  @Produces("application/json")
  Response rate_limit_get();
}
