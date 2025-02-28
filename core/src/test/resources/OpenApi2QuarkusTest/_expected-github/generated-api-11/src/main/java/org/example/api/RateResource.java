package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

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
  @Operation(description = "**Note:** Accessing this endpoint does not count against your REST API rate limit.\n\n**Note:** The `rate` object is deprecated. If you're writing new API client code or updating existing code, you should use the `core` object instead of the `rate` object. The `core` object contains the same information that is present in the `rate` object.", summary = "Get rate limit status for the authenticated user", operationId = "rate-limit/get")
  @GET
  @Produces("application/json")
  Response rate_limit_get();
}
