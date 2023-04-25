package org.example.api;

import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import org.example.api.beans.API;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/apis")
public interface ApisResource {
  /**
   * <p>
   * Publish an API and make it immediately available on the gateway.
   * </p>
   * 
   */
  @PUT
  void publishAnAPI(API body);
}
