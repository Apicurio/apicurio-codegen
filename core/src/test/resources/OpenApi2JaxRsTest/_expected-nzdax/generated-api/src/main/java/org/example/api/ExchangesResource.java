package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.util.List;
import org.example.api.beans.Exchange;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/exchanges")
public interface ExchangesResource {
  /**
   * <p>
   * List all support exchanges by this server
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  List<Exchange> list();
}
