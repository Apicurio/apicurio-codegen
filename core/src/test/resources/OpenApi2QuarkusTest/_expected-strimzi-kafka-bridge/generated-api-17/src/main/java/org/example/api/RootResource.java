package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.example.api.beans.BridgeInfo;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/")
public interface RootResource {
  /**
   * <p>
   * Retrieves information about the Kafka Bridge instance, in JSON format.
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  BridgeInfo info();
}
