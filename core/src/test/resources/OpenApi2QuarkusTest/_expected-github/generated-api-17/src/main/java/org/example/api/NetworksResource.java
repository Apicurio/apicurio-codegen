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
@Path("/networks")
public interface NetworksResource {
  /**
   * 
   */
  @Path("/{owner}/{repo}/events")
  @GET
  @Produces("application/json")
  Response activity_list_public_events_for_repo_network(@PathParam("owner") String owner,
      @PathParam("repo") String repo, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);
}
