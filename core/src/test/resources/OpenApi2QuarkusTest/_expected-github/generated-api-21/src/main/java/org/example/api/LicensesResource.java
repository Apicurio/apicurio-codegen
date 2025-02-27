package org.example.api;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.math.BigInteger;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/licenses")
public interface LicensesResource {
  /**
   *
   */
  @Operation(description = "", summary = "Get a license", operationId = "licenses/get")
  @Path("/{license}")
  @GET
  @Produces("application/json")
  Response licenses_get(@PathParam("license") String license);

  /**
   *
   */
  @Operation(description = "", summary = "Get all commonly used licenses", operationId = "licenses/get-all-commonly-used")
  @GET
  @Produces("application/json")
  Response licenses_get_all_commonly_used(@QueryParam("featured") Boolean featured,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage);
}
