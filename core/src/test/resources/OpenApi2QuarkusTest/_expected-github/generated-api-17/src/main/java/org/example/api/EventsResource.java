package org.example.api;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.math.BigInteger;
import org.eclipse.microprofile.openapi.annotations.Operation;

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
  @Operation(description = "We delay the public events feed by five minutes, which means the most recent event returned by the public events API actually occurred at least five minutes ago.", summary = "List public events", operationId = "activity/list-public-events")
  @GET
  @Produces("application/json")
  Response activity_list_public_events(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);
}
