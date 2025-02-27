package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/codes_of_conduct")
public interface CodesResource {
  /**
   *
   */
  @Operation(description = "", summary = "Get a code of conduct", operationId = "codes-of-conduct/get-conduct-code")
  @Path("/{key}")
  @GET
  @Produces("application/json")
  Response codes_of_conduct_get_conduct_code(@PathParam("key") String key);

  /**
   *
   */
  @Operation(description = "", summary = "Get all codes of conduct", operationId = "codes-of-conduct/get-all-codes-of-conduct")
  @GET
  @Produces("application/json")
  Response codes_of_conduct_get_all_codes_of_conduct();
}
