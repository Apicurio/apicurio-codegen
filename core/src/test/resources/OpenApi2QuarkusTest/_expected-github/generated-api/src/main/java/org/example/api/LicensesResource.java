package org.example.api;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.math.BigInteger;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/licenses")
public interface LicensesResource {
  /**
   * 
   */
  @Path("/{license}")
  @GET
  @Produces("application/json")
  Response licenses_get(@PathParam("license") String license);

  /**
   * 
   */
  @GET
  @Produces("application/json")
  Response licenses_get_all_commonly_used(@QueryParam("featured") Boolean featured,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage);
}
