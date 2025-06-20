package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/car")
public interface CarResource {
  /**
   * <p>
   * This endpoint returns a list of cars with their details.
   * </p>
   *
   */
  @Operation(description = "This endpoint returns a list of cars with their details.", summary = "Returns a list of cars.")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  List<String> returnsAListOfCars(@NotNull List<String> data);
}