package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/organizations")
public interface OrganizationsResource {
  /**
   * Lists all organizations, in the order that they were created on GitHub.
   *
   * **Note:** Pagination is powered exclusively by the `since` parameter. Use the [Link header](https://developer.github.com/v3/#link-header) to get the URL for the next page of organizations.
   */
  @GET
  @Produces("application/json")
  Response orgs_list(@QueryParam("since") String since, @QueryParam("per_page") Integer perPage);
}
