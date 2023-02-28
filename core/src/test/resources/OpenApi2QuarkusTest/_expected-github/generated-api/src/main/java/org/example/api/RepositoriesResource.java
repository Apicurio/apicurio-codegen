package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/repositories")
public interface RepositoriesResource {
  /**
   * Lists all public repositories in the order that they were created.
   *
   * Note: Pagination is powered exclusively by the `since` parameter. Use the [Link header](https://developer.github.com/v3/#link-header) to get the URL for the next page of repositories.
   */
  @GET
  @Produces("application/json")
  Response repos_list_public(@QueryParam("per_page") Integer perPage,
      @QueryParam("since") String since, @QueryParam("visibility") String visibility);
}
