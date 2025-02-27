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
  @Operation(description = "List issues assigned to the authenticated user across all visible repositories including owned repositories, member\nrepositories, and organization repositories. You can use the `filter` query parameter to fetch issues that are not\nnecessarily assigned to you. See the [Parameters table](https://developer.github.com/v3/issues/#parameters) for more\ninformation.\n\n\n**Note**: GitHub's REST API v3 considers every pull request an issue, but not every issue is a pull request. For this\nreason, \"Issues\" endpoints may return both issues and pull requests in the response. You can identify pull requests by\nthe `pull_request` key. Be aware that the `id` of a pull request returned from \"Issues\" endpoints will be an _issue id_. To find out the pull\nrequest id, use the \"[List pull requests](https://developer.github.com/v3/pulls/#list-pull-requests)\" endpoint.", summary = "List issues assigned to the authenticated user", operationId = "issues/list")
  @GET
  @Produces("application/json")
  Response issues_list(@QueryParam("filter") @DefaultValue("assigned") String filter,
      @QueryParam("state") @DefaultValue("open") String state, @QueryParam("labels") String labels,
      @QueryParam("sort") @DefaultValue("created") String sort,
      @QueryParam("direction") @DefaultValue("desc") String direction, @QueryParam("since") String since,
      @QueryParam("collab") Boolean collab, @QueryParam("orgs") Boolean orgs, @QueryParam("owned") Boolean owned,
      @QueryParam("pulls") Boolean pulls, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);
}
