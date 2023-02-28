package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.util.List;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/api/v3/widgets")
public interface WidgetsResource {
  @GET
  @Produces("application/json")
  List<String> getWidgets();
}
