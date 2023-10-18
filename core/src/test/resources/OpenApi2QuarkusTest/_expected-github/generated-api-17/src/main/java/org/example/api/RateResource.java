package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/rate_limit")
public interface RateResource {
  /**
   * <p>
   * <strong>Note:</strong> Accessing this endpoint does not count against your
   * REST API rate limit.
   * </p>
   * <p>
   * <strong>Note:</strong> The <code>rate</code> object is deprecated. If you're
   * writing new API client code or updating existing code, you should use the
   * <code>core</code> object instead of the <code>rate</code> object. The
   * <code>core</code> object contains the same information that is present in the
   * <code>rate</code> object.
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  Response rate_limit_get();
}
