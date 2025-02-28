package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.example.api.beans.Client;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/clients")
public interface ClientsResource {
  /**
   * <p>
   * Register a Client and make it immediately available on the gateway.
   * </p>
   *
   */
  @Operation(description = "Register a Client and make it immediately available on the gateway.", summary = "Register a Client")
  @PUT
  @Consumes("application/json")
  void registerAClient(@NotNull Client data);
}
