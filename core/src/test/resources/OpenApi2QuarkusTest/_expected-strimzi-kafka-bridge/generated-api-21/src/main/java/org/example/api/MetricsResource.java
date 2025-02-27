package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/metrics")
public interface MetricsResource {
  /**
   * <p>
   * Retrieves the bridge metrics in Prometheus format.
   * </p>
   *
   */
  @Operation(description = "Retrieves the bridge metrics in Prometheus format.", operationId = "metrics")
  @GET
  @Produces("text/plain")
  String metrics();
}
