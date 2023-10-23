package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

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
  @GET
  @Produces("text/plain")
  String metrics();
}
