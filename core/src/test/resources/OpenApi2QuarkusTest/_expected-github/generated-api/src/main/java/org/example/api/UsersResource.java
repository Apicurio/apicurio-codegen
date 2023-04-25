package org.example.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/users")
public interface UsersResource {
  /**
   * <p>
   * Lists public repositories for the specified user.
   * </p>
   * 
   */
  @Path("/{username}/repos")
  @GET
  @Produces("application/json")
  Response repos_list_for_user(@PathParam("username") String username, @QueryParam("type") String type,
      @QueryParam("sort") String sort, @QueryParam("direction") String direction,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{username}/events/public")
  @GET
  @Produces("application/json")
  Response activity_list_public_events_for_user(@PathParam("username") String username,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * This is the user's organization dashboard. You must be authenticated as the
   * user to view this.
   * </p>
   * 
   */
  @Path("/{username}/events/orgs/{org}")
  @GET
  @Produces("application/json")
  Response activity_list_org_events_for_authenticated_user(@PathParam("username") String username,
      @PathParam("org") String org, @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * These are events that you've received by watching repos and following users.
   * If you are authenticated as the given user, you will see private events.
   * Otherwise, you'll only see public events.
   * </p>
   * 
   */
  @Path("/{username}/received_events")
  @GET
  @Produces("application/json")
  Response activity_list_received_events_for_user(@PathParam("username") String username,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Lists repositories a user has starred.
   * </p>
   * <p>
   * You can also find out <em>when</em> stars were created by passing the
   * following custom <a href="https://developer.github.com/v3/media/">media
   * type</a> via the <code>Accept</code> header:
   * </p>
   * 
   */
  @Path("/{username}/starred")
  @GET
  @Produces({"application/json", "application/vnd.github.v3.star+json"})
  Response activity_list_repos_starred_by_user(@PathParam("username") String username, @QueryParam("sort") String sort,
      @QueryParam("direction") String direction, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * Lists repositories a user is watching.
   * </p>
   * 
   */
  @Path("/{username}/subscriptions")
  @GET
  @Produces("application/json")
  Response activity_list_repos_watched_by_user(@PathParam("username") String username,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * If you are authenticated as the given user, you will see your private events.
   * Otherwise, you'll only see public events.
   * </p>
   * 
   */
  @Path("/{username}/events")
  @GET
  @Produces("application/json")
  Response activity_list_events_for_authenticated_user(@PathParam("username") String username,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{username}/received_events/public")
  @GET
  @Produces("application/json")
  Response activity_list_received_public_events_for_user(@PathParam("username") String username,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{username}/projects")
  @GET
  @Produces("application/json")
  Response projects_list_for_user(@PathParam("username") String username, @QueryParam("state") String state,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * List <a href=
   * "https://help.github.com/articles/publicizing-or-concealing-organization-membership">public
   * organization memberships</a> for the specified user.
   * </p>
   * <p>
   * This method only lists <em>public</em> memberships, regardless of
   * authentication. If you need to fetch all of the organization memberships
   * (public and private) for the authenticated user, use the <a href=
   * "https://developer.github.com/v3/orgs/#list-organizations-for-the-authenticated-user">List
   * organizations for the authenticated user</a> API instead.
   * </p>
   * 
   */
  @Path("/{username}/orgs")
  @GET
  @Produces("application/json")
  Response orgs_list_for_user(@PathParam("username") String username, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * Lists the people who the specified user follows.
   * </p>
   * 
   */
  @Path("/{username}/following")
  @GET
  @Produces("application/json")
  Response users_list_following_for_user(@PathParam("username") String username,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Provides publicly available information about someone with a GitHub account.
   * </p>
   * <p>
   * GitHub Apps with the <code>Plan</code> user permission can use this endpoint
   * to retrieve information about a user's GitHub plan. The GitHub App must be
   * authenticated as a user. See &quot;<a href=
   * "https://developer.github.com/apps/building-github-apps/identifying-and-authorizing-users-for-github-apps/">Identifying
   * and authorizing users for GitHub Apps</a>&quot; for details about
   * authentication. For an example response, see &quot;<a href=
   * "https://developer.github.com/v3/users/#response-with-github-plan-information">Response
   * with GitHub plan information</a>.&quot;
   * </p>
   * <p>
   * The <code>email</code> key in the following response is the publicly visible
   * email address from your GitHub
   * <a href="https://github.com/settings/profile">profile page</a>. When setting
   * up your profile, you can select a primary email address to be “public” which
   * provides an email entry for this endpoint. If you do not set a public email
   * address for <code>email</code>, then it will have a value of
   * <code>null</code>. You only see publicly visible email addresses when
   * authenticated with GitHub. For more information, see
   * <a href="https://developer.github.com/v3/#authentication">Authentication</a>.
   * </p>
   * <p>
   * The Emails API enables you to list all of your email addresses, and toggle a
   * primary email to be visible publicly. For more information, see
   * &quot;<a href="https://developer.github.com/v3/users/emails/">Emails
   * API</a>&quot;.
   * </p>
   * 
   */
  @Path("/{username}")
  @GET
  @Produces("application/json")
  Response users_get_by_username(@PathParam("username") String username);

  /**
   * <p>
   * Lists the GPG keys for a user. This information is accessible by anyone.
   * </p>
   * 
   */
  @Path("/{username}/gpg_keys")
  @GET
  @Produces("application/json")
  Response users_list_gpg_keys_for_user(@PathParam("username") String username, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{username}/following/{target_user}")
  @GET
  void users_check_following_for_user(@PathParam("username") String username,
      @PathParam("target_user") String targetUser);

  /**
   * <p>
   * Lists all users, in the order that they signed up on GitHub. This list
   * includes personal user accounts and organization accounts.
   * </p>
   * <p>
   * Note: Pagination is powered exclusively by the <code>since</code> parameter.
   * Use the <a href="https://developer.github.com/v3/#link-header">Link
   * header</a> to get the URL for the next page of users.
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  Response users_list(@QueryParam("since") String since, @QueryParam("per_page") Integer perPage);

  /**
   * <p>
   * Provides hovercard information when authenticated through basic auth or OAuth
   * with the <code>repo</code> scope. You can find out more about someone in
   * relation to their pull requests, issues, repositories, and organizations.
   * </p>
   * <p>
   * The <code>subject_type</code> and <code>subject_id</code> parameters provide
   * context for the person's hovercard, which returns more information than
   * without the parameters. For example, if you wanted to find out more about
   * <code>octocat</code> who owns the <code>Spoon-Knife</code> repository via
   * cURL, it would look like this:
   * </p>
   * 
   * <pre>
   * <code class="language-shell"> curl -u username:token
    https://api.github.com/users/octocat/hovercard?subject_type=repository&amp;subject_id=1300192
  </code>
   * </pre>
   * 
   */
  @Path("/{username}/hovercard")
  @GET
  @Produces("application/json")
  Response users_get_context_for_user(@PathParam("username") String username,
      @QueryParam("subject_type") String subjectType, @QueryParam("subject_id") String subjectId);

  /**
   * <p>
   * Lists the <em>verified</em> public SSH keys for a user. This is accessible by
   * anyone.
   * </p>
   * 
   */
  @Path("/{username}/keys")
  @GET
  @Produces("application/json")
  Response users_list_public_keys_for_user(@PathParam("username") String username,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Lists the people following the specified user.
   * </p>
   * 
   */
  @Path("/{username}/followers")
  @GET
  @Produces("application/json")
  Response users_list_followers_for_user(@PathParam("username") String username,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * Enables an authenticated GitHub App to find the user’s installation
   * information.
   * </p>
   * <p>
   * You must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint.
   * </p>
   * 
   */
  @Path("/{username}/installation")
  @GET
  @Produces("application/json")
  Response apps_get_user_installation(@PathParam("username") String username);

  /**
   * <p>
   * Lists public gists for the specified user:
   * </p>
   * 
   */
  @Path("/{username}/gists")
  @GET
  @Produces("application/json")
  Response gists_list_for_user(@PathParam("username") String username, @QueryParam("since") String since,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

  /**
   * <p>
   * <strong>Warning:</strong> The Billing API is currently in public beta and
   * subject to change.
   * </p>
   * <p>
   * Gets the estimated paid and estimated total storage used for GitHub Actions
   * and Github Packages.
   * </p>
   * <p>
   * Paid minutes only apply to packages stored for private repositories. For more
   * information, see &quot;<a href=
   * "https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-packages">Managing
   * billing for GitHub Packages</a>.&quot;
   * </p>
   * <p>
   * Access tokens must have the <code>user</code> scope.
   * </p>
   * 
   */
  @Path("/{username}/settings/billing/shared-storage")
  @GET
  @Produces("application/json")
  Response billing_get_shared_storage_billing_user(@PathParam("username") String username);

  /**
   * <p>
   * <strong>Warning:</strong> The Billing API is currently in public beta and
   * subject to change.
   * </p>
   * <p>
   * Gets the free and paid storage used for GitHub Packages in gigabytes.
   * </p>
   * <p>
   * Paid minutes only apply to packages stored for private repositories. For more
   * information, see &quot;<a href=
   * "https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-packages">Managing
   * billing for GitHub Packages</a>.&quot;
   * </p>
   * <p>
   * Access tokens must have the <code>user</code> scope.
   * </p>
   * 
   */
  @Path("/{username}/settings/billing/packages")
  @GET
  @Produces("application/json")
  Response billing_get_github_packages_billing_user(@PathParam("username") String username);

  /**
   * <p>
   * <strong>Warning:</strong> The Billing API is currently in public beta and
   * subject to change.
   * </p>
   * <p>
   * Gets the summary of the free and paid GitHub Actions minutes used.
   * </p>
   * <p>
   * Paid minutes only apply to workflows in private repositories that use
   * GitHub-hosted runners. Minutes used is listed for each GitHub-hosted runner
   * operating system. Any job re-runs are also included in the usage. The usage
   * does not include the multiplier for macOS and Windows runners and is not
   * rounded up to the nearest whole minute. For more information, see
   * &quot;<a href=
   * "https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-actions">Managing
   * billing for GitHub Actions</a>&quot;.
   * </p>
   * <p>
   * Access tokens must have the <code>user</code> scope.
   * </p>
   * 
   */
  @Path("/{username}/settings/billing/actions")
  @GET
  @Produces("application/json")
  Response billing_get_github_actions_billing_user(@PathParam("username") String username);
}
