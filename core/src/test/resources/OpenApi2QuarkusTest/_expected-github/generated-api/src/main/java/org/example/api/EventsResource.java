package org.example.api;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.math.BigInteger;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/events")
public interface EventsResource {
  /**
   * <p>
   * We delay the public events feed by five minutes, which means the most recent
   * event returned by the public events API actually occurred at least five
   * minutes ago.
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  Response activity_list_public_events(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);
}
