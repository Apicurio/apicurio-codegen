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
@Path("/repositories")
public interface RepositoriesResource {
  /**
   * <p>
   * Lists all public repositories in the order that they were created.
   * </p>
   * <p>
   * Note: Pagination is powered exclusively by the <code>since</code> parameter.
   * Use the <a href="https://developer.github.com/v3/#link-header">Link
   * header</a> to get the URL for the next page of repositories.
   * </p>
   *
   */
  @Operation(description = "Lists all public repositories in the order that they were created.\n\nNote: Pagination is powered exclusively by the `since` parameter. Use the [Link header](https://developer.github.com/v3/#link-header) to get the URL for the next page of repositories.", summary = "List public repositories", operationId = "repos/list-public")
  @GET
  @Produces("application/json")
  Response repos_list_public(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("since") String since, @QueryParam("visibility") String visibility);
}
