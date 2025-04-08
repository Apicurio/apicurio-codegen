package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/ping")
public interface PingResource {
  /**
   * <p>
   * very simple sample endpoint
   * </p>
   *
   */
  @Operation(description = "very simple sample endpoint", summary = "returns a single \"pong\" string.")
  @GET
  @Produces("text/plain")
  String returnsASinglePongString();
}
