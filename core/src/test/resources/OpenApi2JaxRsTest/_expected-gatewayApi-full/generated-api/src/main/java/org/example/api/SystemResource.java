package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.example.api.beans.SystemStatus;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/system")
public interface SystemResource {
  /**
   * <p>
   * Get current gateway status. Useful for determining whether a given gateway is
   * responding correctly (routing, finished booting, error, etc) and verifying
   * that provided auth credentials are correct, and/or the auth server is
   * reachable (if applicable).
   * </p>
   * 
   */
  @Path("/status")
  @GET
  @Produces("application/json")
  SystemStatus getGatewayStatus();
}
