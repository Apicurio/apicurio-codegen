package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/issues")
public interface IssuesResource {
  /**
   * <p>
   * List issues assigned to the authenticated user across all visible
   * repositories including owned repositories, member repositories, and
   * organization repositories. You can use the <code>filter</code> query
   * parameter to fetch issues that are not necessarily assigned to you. See the
   * <a href="https://developer.github.com/v3/issues/#parameters">Parameters
   * table</a> for more information.
   * </p>
   * <p>
   * <strong>Note</strong>: GitHub's REST API v3 considers every pull request an
   * issue, but not every issue is a pull request. For this reason,
   * &quot;Issues&quot; endpoints may return both issues and pull requests in the
   * response. You can identify pull requests by the <code>pull_request</code>
   * key. Be aware that the <code>id</code> of a pull request returned from
   * &quot;Issues&quot; endpoints will be an <em>issue id</em>. To find out the
   * pull request id, use the &quot;<a href=
   * "https://developer.github.com/v3/pulls/#list-pull-requests">List pull
   * requests</a>&quot; endpoint.
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  Response issues_list(@QueryParam("filter") String filter, @QueryParam("state") String state,
      @QueryParam("labels") String labels, @QueryParam("sort") String sort, @QueryParam("direction") String direction,
      @QueryParam("since") String since, @QueryParam("collab") Boolean collab, @QueryParam("orgs") Boolean orgs,
      @QueryParam("owned") Boolean owned, @QueryParam("pulls") Boolean pulls, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);
}
