package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/user")
public interface UserResource {
  /**
   * <p>
   * When authenticating as a user, this endpoint will list all currently open
   * repository invitations for that user.
   * </p>
   *
   */
  @Operation(description = "When authenticating as a user, this endpoint will list all currently open repository invitations for that user.", summary = "List repository invitations for the authenticated user", operationId = "repos/list-invitations-for-authenticated-user")
  @Path("/repository_invitations")
  @GET
  @Produces("application/json")
  Response repos_list_invitations_for_authenticated_user(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Decline a repository invitation", operationId = "repos/decline-invitation")
  @Path("/repository_invitations/{invitation_id}")
  @DELETE
  void repos_decline_invitation(@PathParam("invitation_id") BigInteger invitationId);

  /**
   *
   */
  @Operation(description = "", summary = "Accept a repository invitation", operationId = "repos/accept-invitation")
  @Path("/repository_invitations/{invitation_id}")
  @PATCH
  void repos_accept_invitation(@PathParam("invitation_id") BigInteger invitationId);

  /**
   * <p>
   * Lists repositories that the authenticated user has explicit permission
   * (<code>:read</code>, <code>:write</code>, or <code>:admin</code>) to access.
   * </p>
   * <p>
   * The authenticated user has explicit permission to access repositories they
   * own, repositories where they are a collaborator, and repositories that they
   * can access through an organization membership.
   * </p>
   *
   */
  @Operation(description = "Lists repositories that the authenticated user has explicit permission (`:read`, `:write`, or `:admin`) to access.\n\nThe authenticated user has explicit permission to access repositories they own, repositories where they are a collaborator, and repositories that they can access through an organization membership.", summary = "List repositories for the authenticated user", operationId = "repos/list-for-authenticated-user")
  @Path("/repos")
  @GET
  @Produces("application/json")
  Response repos_list_for_authenticated_user(@QueryParam("visibility") @DefaultValue("all") String visibility,
      @QueryParam("affiliation") @DefaultValue("owner,collaborator,organization_member") String affiliation,
      @QueryParam("type") @DefaultValue("all") String type, @QueryParam("sort") @DefaultValue("full_name") String sort,
      @QueryParam("direction") String direction, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page, @QueryParam("since") String since,
      @QueryParam("before") String before);

  /**
   * <p>
   * Creates a new repository for the authenticated user.
   * </p>
   * <p>
   * <strong>OAuth scope requirements</strong>
   * </p>
   * <p>
   * When using <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">OAuth</a>,
   * authorizations must include:
   * </p>
   * <ul>
   * <li><code>public_repo</code> scope or <code>repo</code> scope to create a
   * public repository</li>
   * <li><code>repo</code> scope to create a private repository</li>
   * </ul>
   *
   */
  @Operation(description = "Creates a new repository for the authenticated user.\n\n**OAuth scope requirements**\n\nWhen using [OAuth](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/), authorizations must include:\n\n*   `public_repo` scope or `repo` scope to create a public repository\n*   `repo` scope to create a private repository", summary = "Create a repository for the authenticated user", operationId = "repos/create-for-authenticated-user")
  @Path("/repos")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_for_authenticated_user(@NotNull InputStream data);

  /**
   * <p>
   * Fetches a single user migration. The response includes the <code>state</code>
   * of the migration, which can be one of the following values:
   * </p>
   * <ul>
   * <li><code>pending</code> - the migration hasn't started yet.</li>
   * <li><code>exporting</code> - the migration is in progress.</li>
   * <li><code>exported</code> - the migration finished successfully.</li>
   * <li><code>failed</code> - the migration failed.</li>
   * </ul>
   * <p>
   * Once the migration has been <code>exported</code> you can <a href=
   * "https://developer.github.com/v3/migrations/users/#download-a-user-migration-archive">download
   * the migration archive</a>.
   * </p>
   *
   */
  @Operation(description = "Fetches a single user migration. The response includes the `state` of the migration, which can be one of the following values:\n\n*   `pending` - the migration hasn't started yet.\n*   `exporting` - the migration is in progress.\n*   `exported` - the migration finished successfully.\n*   `failed` - the migration failed.\n\nOnce the migration has been `exported` you can [download the migration archive](https://developer.github.com/v3/migrations/users/#download-a-user-migration-archive).", summary = "Get a user migration status", operationId = "migrations/get-status-for-authenticated-user")
  @Path("/migrations/{migration_id}")
  @GET
  @Produces("application/json")
  Response migrations_get_status_for_authenticated_user(@PathParam("migration_id") BigInteger migrationId,
      @QueryParam("exclude") List<String> exclude);

  /**
   * <p>
   * Unlocks a repository. You can lock repositories when you <a href=
   * "https://developer.github.com/v3/migrations/users/#start-a-user-migration">start
   * a user migration</a>. Once the migration is complete you can unlock each
   * repository to begin using it again or
   * <a href="https://developer.github.com/v3/repos/#delete-a-repository">delete
   * the repository</a> if you no longer need the source data. Returns a status of
   * <code>404 Not Found</code> if the repository is not locked.
   * </p>
   *
   */
  @Operation(description = "Unlocks a repository. You can lock repositories when you [start a user migration](https://developer.github.com/v3/migrations/users/#start-a-user-migration). Once the migration is complete you can unlock each repository to begin using it again or [delete the repository](https://developer.github.com/v3/repos/#delete-a-repository) if you no longer need the source data. Returns a status of `404 Not Found` if the repository is not locked.", summary = "Unlock a user repository", operationId = "migrations/unlock-repo-for-authenticated-user")
  @Path("/migrations/{migration_id}/repos/{repo_name}/lock")
  @DELETE
  void migrations_unlock_repo_for_authenticated_user(@PathParam("migration_id") BigInteger migrationId,
      @PathParam("repo_name") String repoName);

  /**
   * <p>
   * Lists all the repositories for this user migration.
   * </p>
   *
   */
  @Operation(description = "Lists all the repositories for this user migration.", summary = "List repositories for a user migration", operationId = "migrations/list-repos-for-user")
  @Path("/migrations/{migration_id}/repositories")
  @GET
  @Produces("application/json")
  Response migrations_list_repos_for_user(@PathParam("migration_id") BigInteger migrationId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Lists all migrations a user has started.
   * </p>
   *
   */
  @Operation(description = "Lists all migrations a user has started.", summary = "List user migrations", operationId = "migrations/list-for-authenticated-user")
  @Path("/migrations")
  @GET
  @Produces("application/json")
  Response migrations_list_for_authenticated_user(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Initiates the generation of a user migration archive.
   * </p>
   *
   */
  @Operation(description = "Initiates the generation of a user migration archive.", summary = "Start a user migration", operationId = "migrations/start-for-authenticated-user")
  @Path("/migrations")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response migrations_start_for_authenticated_user(@NotNull InputStream data);

  /**
   * <p>
   * Fetches the URL to download the migration archive as a <code>tar.gz</code>
   * file. Depending on the resources your repository uses, the migration archive
   * can contain JSON files with data for these objects:
   * </p>
   * <ul>
   * <li>attachments</li>
   * <li>bases</li>
   * <li>commit_comments</li>
   * <li>issue_comments</li>
   * <li>issue_events</li>
   * <li>issues</li>
   * <li>milestones</li>
   * <li>organizations</li>
   * <li>projects</li>
   * <li>protected_branches</li>
   * <li>pull_request_reviews</li>
   * <li>pull_requests</li>
   * <li>releases</li>
   * <li>repositories</li>
   * <li>review_comments</li>
   * <li>schema</li>
   * <li>users</li>
   * </ul>
   * <p>
   * The archive will also contain an <code>attachments</code> directory that
   * includes all attachment files uploaded to GitHub.com and a
   * <code>repositories</code> directory that contains the repository's Git data.
   * </p>
   *
   */
  @Operation(description = "Fetches the URL to download the migration archive as a `tar.gz` file. Depending on the resources your repository uses, the migration archive can contain JSON files with data for these objects:\n\n*   attachments\n*   bases\n*   commit\\_comments\n*   issue\\_comments\n*   issue\\_events\n*   issues\n*   milestones\n*   organizations\n*   projects\n*   protected\\_branches\n*   pull\\_request\\_reviews\n*   pull\\_requests\n*   releases\n*   repositories\n*   review\\_comments\n*   schema\n*   users\n\nThe archive will also contain an `attachments` directory that includes all attachment files uploaded to GitHub.com and a `repositories` directory that contains the repository's Git data.", summary = "Download a user migration archive", operationId = "migrations/get-archive-for-authenticated-user")
  @Path("/migrations/{migration_id}/archive")
  @GET
  void migrations_get_archive_for_authenticated_user(@PathParam("migration_id") BigInteger migrationId);

  /**
   * <p>
   * Deletes a previous migration archive. Downloadable migration archives are
   * automatically deleted after seven days. Migration metadata, which is returned
   * in the <a href=
   * "https://developer.github.com/v3/migrations/users/#list-user-migrations">List
   * user migrations</a> and <a href=
   * "https://developer.github.com/v3/migrations/users/#get-a-user-migration-status">Get
   * a user migration status</a> endpoints, will continue to be available even
   * after an archive is deleted.
   * </p>
   *
   */
  @Operation(description = "Deletes a previous migration archive. Downloadable migration archives are automatically deleted after seven days. Migration metadata, which is returned in the [List user migrations](https://developer.github.com/v3/migrations/users/#list-user-migrations) and [Get a user migration status](https://developer.github.com/v3/migrations/users/#get-a-user-migration-status) endpoints, will continue to be available even after an archive is deleted.", summary = "Delete a user migration archive", operationId = "migrations/delete-archive-for-authenticated-user")
  @Path("/migrations/{migration_id}/archive")
  @DELETE
  void migrations_delete_archive_for_authenticated_user(@PathParam("migration_id") BigInteger migrationId);

  /**
   *
   */
  @Operation(description = "", summary = "Check if a repository is starred by the authenticated user", operationId = "activity/check-repo-is-starred-by-authenticated-user")
  @Path("/starred/{owner}/{repo}")
  @GET
  void activity_check_repo_is_starred_by_authenticated_user(@PathParam("owner") String owner,
      @PathParam("repo") String repo);

  /**
   * <p>
   * Note that you'll need to set <code>Content-Length</code> to zero when calling
   * out to this endpoint. For more information, see
   * &quot;<a href="https://developer.github.com/v3/#http-verbs">HTTP
   * verbs</a>.&quot;
   * </p>
   *
   */
  @Operation(description = "Note that you'll need to set `Content-Length` to zero when calling out to this endpoint. For more information, see \"[HTTP verbs](https://developer.github.com/v3/#http-verbs).\"", summary = "Star a repository for the authenticated user", operationId = "activity/star-repo-for-authenticated-user")
  @Path("/starred/{owner}/{repo}")
  @PUT
  void activity_star_repo_for_authenticated_user(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   *
   */
  @Operation(description = "", summary = "Unstar a repository for the authenticated user", operationId = "activity/unstar-repo-for-authenticated-user")
  @Path("/starred/{owner}/{repo}")
  @DELETE
  void activity_unstar_repo_for_authenticated_user(@PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Lists repositories the authenticated user is watching.
   * </p>
   *
   */
  @Operation(description = "Lists repositories the authenticated user is watching.", summary = "List repositories watched by the authenticated user", operationId = "activity/list-watched-repos-for-authenticated-user")
  @Path("/subscriptions")
  @GET
  @Produces("application/json")
  Response activity_list_watched_repos_for_authenticated_user(
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Lists repositories the authenticated user has starred.
   * </p>
   * <p>
   * You can also find out <em>when</em> stars were created by passing the
   * following custom <a href="https://developer.github.com/v3/media/">media
   * type</a> via the <code>Accept</code> header:
   * </p>
   *
   */
  @Operation(description = "Lists repositories the authenticated user has starred.\n\nYou can also find out _when_ stars were created by passing the following custom [media type](https://developer.github.com/v3/media/) via the `Accept` header:", summary = "List repositories starred by the authenticated user", operationId = "activity/list-repos-starred-by-authenticated-user")
  @Path("/starred")
  @GET
  @Produces({"application/json", "application/vnd.github.v3.star+json"})
  Response activity_list_repos_starred_by_authenticated_user(@QueryParam("sort") @DefaultValue("created") String sort,
      @QueryParam("direction") @DefaultValue("desc") String direction,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Create a user project", operationId = "projects/create-for-authenticated-user")
  @Path("/projects")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response projects_create_for_authenticated_user(@NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "List organization memberships for the authenticated user", operationId = "orgs/list-memberships-for-authenticated-user")
  @Path("/memberships/orgs")
  @GET
  @Produces("application/json")
  Response orgs_list_memberships_for_authenticated_user(@QueryParam("state") String state,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Get an organization membership for the authenticated user", operationId = "orgs/get-membership-for-authenticated-user")
  @Path("/memberships/orgs/{org}")
  @GET
  @Produces("application/json")
  Response orgs_get_membership_for_authenticated_user(@PathParam("org") String org);

  /**
   *
   */
  @Operation(description = "", summary = "Update an organization membership for the authenticated user", operationId = "orgs/update-membership-for-authenticated-user")
  @Path("/memberships/orgs/{org}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response orgs_update_membership_for_authenticated_user(@PathParam("org") String org, @NotNull InputStream data);

  /**
   * <p>
   * List organizations for the authenticated user.
   * </p>
   * <p>
   * <strong>OAuth scope requirements</strong>
   * </p>
   * <p>
   * This only lists organizations that your authorization allows you to operate
   * on in some way (e.g., you can list teams with <code>read:org</code> scope,
   * you can publicize your organization membership with <code>user</code> scope,
   * etc.). Therefore, this API requires at least <code>user</code> or
   * <code>read:org</code> scope. OAuth requests with insufficient scope receive a
   * <code>403 Forbidden</code> response.
   * </p>
   *
   */
  @Operation(description = "List organizations for the authenticated user.\n\n**OAuth scope requirements**\n\nThis only lists organizations that your authorization allows you to operate on in some way (e.g., you can list teams with `read:org` scope, you can publicize your organization membership with `user` scope, etc.). Therefore, this API requires at least `user` or `read:org` scope. OAuth requests with insufficient scope receive a `403 Forbidden` response.", summary = "List organizations for the authenticated user", operationId = "orgs/list-for-authenticated-user")
  @Path("/orgs")
  @GET
  @Produces("application/json")
  Response orgs_list_for_authenticated_user(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Lists the people following the authenticated user.
   * </p>
   *
   */
  @Operation(description = "Lists the people following the authenticated user.", summary = "List followers of the authenticated user", operationId = "users/list-followers-for-authenticated-user")
  @Path("/followers")
  @GET
  @Produces("application/json")
  Response users_list_followers_for_authenticated_user(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Lists the people who the authenticated user follows.
   * </p>
   *
   */
  @Operation(description = "Lists the people who the authenticated user follows.", summary = "List the people the authenticated user follows", operationId = "users/list-followed-by-authenticated")
  @Path("/following")
  @GET
  @Produces("application/json")
  Response users_list_followed_by_authenticated(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Lists the current user's GPG keys. Requires that you are authenticated via
   * Basic Auth or via OAuth with at least <code>read:gpg_key</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "Lists the current user's GPG keys. Requires that you are authenticated via Basic Auth or via OAuth with at least `read:gpg_key` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "List GPG keys for the authenticated user", operationId = "users/list-gpg-keys-for-authenticated")
  @Path("/gpg_keys")
  @GET
  @Produces("application/json")
  Response users_list_gpg_keys_for_authenticated(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Adds a GPG key to the authenticated user's GitHub account. Requires that you
   * are authenticated via Basic Auth, or OAuth with at least
   * <code>write:gpg_key</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "Adds a GPG key to the authenticated user's GitHub account. Requires that you are authenticated via Basic Auth, or OAuth with at least `write:gpg_key` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Create a GPG key for the authenticated user", operationId = "users/create-gpg-key-for-authenticated")
  @Path("/gpg_keys")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response users_create_gpg_key_for_authenticated(@NotNull InputStream data);

  /**
   * <p>
   * View extended details for a single public SSH key. Requires that you are
   * authenticated via Basic Auth or via OAuth with at least
   * <code>read:public_key</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "View extended details for a single public SSH key. Requires that you are authenticated via Basic Auth or via OAuth with at least `read:public_key` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Get a public SSH key for the authenticated user", operationId = "users/get-public-ssh-key-for-authenticated")
  @Path("/keys/{key_id}")
  @GET
  @Produces("application/json")
  Response users_get_public_ssh_key_for_authenticated(@PathParam("key_id") BigInteger keyId);

  /**
   * <p>
   * Removes a public SSH key from the authenticated user's GitHub account.
   * Requires that you are authenticated via Basic Auth or via OAuth with at least
   * <code>admin:public_key</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "Removes a public SSH key from the authenticated user's GitHub account. Requires that you are authenticated via Basic Auth or via OAuth with at least `admin:public_key` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Delete a public SSH key for the authenticated user", operationId = "users/delete-public-ssh-key-for-authenticated")
  @Path("/keys/{key_id}")
  @DELETE
  void users_delete_public_ssh_key_for_authenticated(@PathParam("key_id") BigInteger keyId);

  /**
   * <p>
   * View extended details for a single GPG key. Requires that you are
   * authenticated via Basic Auth or via OAuth with at least
   * <code>read:gpg_key</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "View extended details for a single GPG key. Requires that you are authenticated via Basic Auth or via OAuth with at least `read:gpg_key` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Get a GPG key for the authenticated user", operationId = "users/get-gpg-key-for-authenticated")
  @Path("/gpg_keys/{gpg_key_id}")
  @GET
  @Produces("application/json")
  Response users_get_gpg_key_for_authenticated(@PathParam("gpg_key_id") BigInteger gpgKeyId);

  /**
   * <p>
   * Removes a GPG key from the authenticated user's GitHub account. Requires that
   * you are authenticated via Basic Auth or via OAuth with at least
   * <code>admin:gpg_key</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "Removes a GPG key from the authenticated user's GitHub account. Requires that you are authenticated via Basic Auth or via OAuth with at least `admin:gpg_key` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Delete a GPG key for the authenticated user", operationId = "users/delete-gpg-key-for-authenticated")
  @Path("/gpg_keys/{gpg_key_id}")
  @DELETE
  void users_delete_gpg_key_for_authenticated(@PathParam("gpg_key_id") BigInteger gpgKeyId);

  /**
   * <p>
   * Lists all of your email addresses, and specifies which one is visible to the
   * public. This endpoint is accessible with the <code>user:email</code> scope.
   * </p>
   *
   */
  @Operation(description = "Lists all of your email addresses, and specifies which one is visible to the public. This endpoint is accessible with the `user:email` scope.", summary = "List email addresses for the authenticated user", operationId = "users/list-emails-for-authenticated")
  @Path("/emails")
  @GET
  @Produces("application/json")
  Response users_list_emails_for_authenticated(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * This endpoint is accessible with the <code>user</code> scope.
   * </p>
   *
   */
  @Operation(description = "This endpoint is accessible with the `user` scope.", summary = "Add an email address for the authenticated user", operationId = "users/add-email-for-authenticated")
  @Path("/emails")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response users_add_email_for_authenticated(@NotNull InputStream data);

  /**
   * <p>
   * This endpoint is accessible with the <code>user</code> scope.
   * </p>
   *
   */
  @Operation(description = "This endpoint is accessible with the `user` scope.", summary = "Delete an email address for the authenticated user", operationId = "users/delete-email-for-authenticated")
  @Path("/emails")
  @DELETE
  @Consumes("application/json")
  void users_delete_email_for_authenticated(@NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Check if a person is followed by the authenticated user", operationId = "users/check-person-is-followed-by-authenticated")
  @Path("/following/{username}")
  @GET
  void users_check_person_is_followed_by_authenticated(@PathParam("username") String username);

  /**
   * <p>
   * Note that you'll need to set <code>Content-Length</code> to zero when calling
   * out to this endpoint. For more information, see
   * &quot;<a href="https://developer.github.com/v3/#http-verbs">HTTP
   * verbs</a>.&quot;
   * </p>
   * <p>
   * Following a user requires the user to be logged in and authenticated with
   * basic auth or OAuth with the <code>user:follow</code> scope.
   * </p>
   *
   */
  @Operation(description = "Note that you'll need to set `Content-Length` to zero when calling out to this endpoint. For more information, see \"[HTTP verbs](https://developer.github.com/v3/#http-verbs).\"\n\nFollowing a user requires the user to be logged in and authenticated with basic auth or OAuth with the `user:follow` scope.", summary = "Follow a user", operationId = "users/follow")
  @Path("/following/{username}")
  @PUT
  void users_follow(@PathParam("username") String username);

  /**
   * <p>
   * Unfollowing a user requires the user to be logged in and authenticated with
   * basic auth or OAuth with the <code>user:follow</code> scope.
   * </p>
   *
   */
  @Operation(description = "Unfollowing a user requires the user to be logged in and authenticated with basic auth or OAuth with the `user:follow` scope.", summary = "Unfollow a user", operationId = "users/unfollow")
  @Path("/following/{username}")
  @DELETE
  void users_unfollow(@PathParam("username") String username);

  /**
   * <p>
   * If the user is blocked:
   * </p>
   * <p>
   * If the user is not blocked:
   * </p>
   *
   */
  @Operation(description = "If the user is blocked:\n\nIf the user is not blocked:", summary = "Check if a user is blocked by the authenticated user", operationId = "users/check-blocked")
  @Path("/blocks/{username}")
  @GET
  void users_check_blocked(@PathParam("username") String username);

  /**
   *
   */
  @Operation(description = "", summary = "Block a user", operationId = "users/block")
  @Path("/blocks/{username}")
  @PUT
  void users_block(@PathParam("username") String username);

  /**
   *
   */
  @Operation(description = "", summary = "Unblock a user", operationId = "users/unblock")
  @Path("/blocks/{username}")
  @DELETE
  void users_unblock(@PathParam("username") String username);

  /**
   * <p>
   * Lists your publicly visible email address, which you can set with the
   * <a href=
   * "https://developer.github.com/v3/users/emails/#set-primary-email-visibility-for-the-authenticated-user">Set
   * primary email visibility for the authenticated user</a> endpoint. This
   * endpoint is accessible with the <code>user:email</code> scope.
   * </p>
   *
   */
  @Operation(description = "Lists your publicly visible email address, which you can set with the [Set primary email visibility for the authenticated user](https://developer.github.com/v3/users/emails/#set-primary-email-visibility-for-the-authenticated-user) endpoint. This endpoint is accessible with the `user:email` scope.", summary = "List public email addresses for the authenticated user", operationId = "users/list-public-emails-for-authenticated")
  @Path("/public_emails")
  @GET
  @Produces("application/json")
  Response users_list_public_emails_for_authenticated(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * List the users you've blocked on your personal account.
   * </p>
   *
   */
  @Operation(description = "List the users you've blocked on your personal account.", summary = "List users blocked by the authenticated user", operationId = "users/list-blocked-by-authenticated")
  @Path("/blocks")
  @GET
  @Produces("application/json")
  Response users_list_blocked_by_authenticated();

  /**
   * <p>
   * Lists the public SSH keys for the authenticated user's GitHub account.
   * Requires that you are authenticated via Basic Auth or via OAuth with at least
   * <code>read:public_key</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "Lists the public SSH keys for the authenticated user's GitHub account. Requires that you are authenticated via Basic Auth or via OAuth with at least `read:public_key` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "List public SSH keys for the authenticated user", operationId = "users/list-public-ssh-keys-for-authenticated")
  @Path("/keys")
  @GET
  @Produces("application/json")
  Response users_list_public_ssh_keys_for_authenticated(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Adds a public SSH key to the authenticated user's GitHub account. Requires
   * that you are authenticated via Basic Auth, or OAuth with at least
   * <code>write:public_key</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "Adds a public SSH key to the authenticated user's GitHub account. Requires that you are authenticated via Basic Auth, or OAuth with at least `write:public_key` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Create a public SSH key for the authenticated user", operationId = "users/create-public-ssh-key-for-authenticated")
  @Path("/keys")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response users_create_public_ssh_key_for_authenticated(@NotNull InputStream data);

  /**
   * <p>
   * If the authenticated user is authenticated through basic authentication or
   * OAuth with the <code>user</code> scope, then the response lists public and
   * private profile information.
   * </p>
   * <p>
   * If the authenticated user is authenticated through OAuth without the
   * <code>user</code> scope, then the response lists only public profile
   * information.
   * </p>
   *
   */
  @Operation(description = "If the authenticated user is authenticated through basic authentication or OAuth with the `user` scope, then the response lists public and private profile information.\n\nIf the authenticated user is authenticated through OAuth without the `user` scope, then the response lists only public profile information.", summary = "Get the authenticated user", operationId = "users/get-authenticated")
  @GET
  @Produces("application/json")
  Response users_get_authenticated();

  /**
   * <p>
   * <strong>Note:</strong> If your email is set to private and you send an
   * <code>email</code> parameter as part of this request to update your profile,
   * your privacy settings are still enforced: the email address will not be
   * displayed on your public profile or via the API.
   * </p>
   *
   */
  @Operation(description = "**Note:** If your email is set to private and you send an `email` parameter as part of this request to update your profile, your privacy settings are still enforced: the email address will not be displayed on your public profile or via the API.", summary = "Update the authenticated user", operationId = "users/update-authenticated")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response users_update_authenticated(@NotNull InputStream data);

  /**
   * <p>
   * Sets the visibility for your primary email addresses.
   * </p>
   *
   */
  @Operation(description = "Sets the visibility for your primary email addresses.", summary = "Set primary email visibility for the authenticated user", operationId = "users/set-primary-email-visibility-for-authenticated")
  @Path("/email/visibility")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response users_set_primary_email_visibility_for_authenticated(@NotNull InputStream data);

  /**
   * <p>
   * List all of the teams across all of the organizations to which the
   * authenticated user belongs. This method requires <code>user</code>,
   * <code>repo</code>, or <code>read:org</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>
   * when authenticating via
   * <a href="https://developer.github.com/apps/building-oauth-apps/">OAuth</a>.
   * </p>
   *
   */
  @Operation(description = "List all of the teams across all of the organizations to which the authenticated user belongs. This method requires `user`, `repo`, or `read:org` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/) when authenticating via [OAuth](https://developer.github.com/apps/building-oauth-apps/).", summary = "List teams for the authenticated user", operationId = "teams/list-for-authenticated-user")
  @Path("/teams")
  @GET
  @Produces("application/json")
  Response teams_list_for_authenticated_user(@QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * List issues across owned and member repositories assigned to the
   * authenticated user.
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
  @Operation(description = "List issues across owned and member repositories assigned to the authenticated user.\n\n**Note**: GitHub's REST API v3 considers every pull request an issue, but not every issue is a pull request. For this\nreason, \"Issues\" endpoints may return both issues and pull requests in the response. You can identify pull requests by\nthe `pull_request` key. Be aware that the `id` of a pull request returned from \"Issues\" endpoints will be an _issue id_. To find out the pull\nrequest id, use the \"[List pull requests](https://developer.github.com/v3/pulls/#list-pull-requests)\" endpoint.", summary = "List user account issues assigned to the authenticated user", operationId = "issues/list-for-authenticated-user")
  @Path("/issues")
  @GET
  @Produces("application/json")
  Response issues_list_for_authenticated_user(@QueryParam("filter") @DefaultValue("assigned") String filter,
      @QueryParam("state") @DefaultValue("open") String state, @QueryParam("labels") String labels,
      @QueryParam("sort") @DefaultValue("created") String sort,
      @QueryParam("direction") @DefaultValue("desc") String direction, @QueryParam("since") String since,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Lists installations of your GitHub App that the authenticated user has
   * explicit permission (<code>:read</code>, <code>:write</code>, or
   * <code>:admin</code>) to access.
   * </p>
   * <p>
   * You must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/identifying-and-authorizing-users-for-github-apps/#identifying-users-on-your-site">user-to-server
   * OAuth access token</a>, created for a user who has authorized your GitHub
   * App, to access this endpoint.
   * </p>
   * <p>
   * The authenticated user has explicit permission to access repositories they
   * own, repositories where they are a collaborator, and repositories that they
   * can access through an organization membership.
   * </p>
   * <p>
   * You can find the permissions for the installation under the
   * <code>permissions</code> key.
   * </p>
   *
   */
  @Operation(description = "Lists installations of your GitHub App that the authenticated user has explicit permission (`:read`, `:write`, or `:admin`) to access.\n\nYou must use a [user-to-server OAuth access token](https://developer.github.com/apps/building-github-apps/identifying-and-authorizing-users-for-github-apps/#identifying-users-on-your-site), created for a user who has authorized your GitHub App, to access this endpoint.\n\nThe authenticated user has explicit permission to access repositories they own, repositories where they are a collaborator, and repositories that they can access through an organization membership.\n\nYou can find the permissions for the installation under the `permissions` key.", summary = "List app installations accessible to the user access token", operationId = "apps/list-installations-for-authenticated-user")
  @Path("/installations")
  @GET
  @Produces("application/json")
  Response apps_list_installations_for_authenticated_user(
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * List repositories that the authenticated user has explicit permission
   * (<code>:read</code>, <code>:write</code>, or <code>:admin</code>) to access
   * for an installation.
   * </p>
   * <p>
   * The authenticated user has explicit permission to access repositories they
   * own, repositories where they are a collaborator, and repositories that they
   * can access through an organization membership.
   * </p>
   * <p>
   * You must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/identifying-and-authorizing-users-for-github-apps/#identifying-users-on-your-site">user-to-server
   * OAuth access token</a>, created for a user who has authorized your GitHub
   * App, to access this endpoint.
   * </p>
   * <p>
   * The access the user has to each repository is included in the hash under the
   * <code>permissions</code> key.
   * </p>
   *
   */
  @Operation(description = "List repositories that the authenticated user has explicit permission (`:read`, `:write`, or `:admin`) to access for an installation.\n\nThe authenticated user has explicit permission to access repositories they own, repositories where they are a collaborator, and repositories that they can access through an organization membership.\n\nYou must use a [user-to-server OAuth access token](https://developer.github.com/apps/building-github-apps/identifying-and-authorizing-users-for-github-apps/#identifying-users-on-your-site), created for a user who has authorized your GitHub App, to access this endpoint.\n\nThe access the user has to each repository is included in the hash under the `permissions` key.", summary = "List repositories accessible to the user access token", operationId = "apps/list-installation-repos-for-authenticated-user")
  @Path("/installations/{installation_id}/repositories")
  @GET
  @Produces("application/json")
  Response apps_list_installation_repos_for_authenticated_user(@PathParam("installation_id") BigInteger installationId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Lists the active subscriptions for the authenticated user. You must use a
   * <a href=
   * "https://developer.github.com/apps/building-github-apps/identifying-and-authorizing-users-for-github-apps/#identifying-users-on-your-site">user-to-server
   * OAuth access token</a>, created for a user who has authorized your GitHub
   * App, to access this endpoint. . OAuth Apps must authenticate using an
   * <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/">OAuth
   * token</a>.
   * </p>
   *
   */
  @Operation(description = "Lists the active subscriptions for the authenticated user. You must use a [user-to-server OAuth access token](https://developer.github.com/apps/building-github-apps/identifying-and-authorizing-users-for-github-apps/#identifying-users-on-your-site), created for a user who has authorized your GitHub App, to access this endpoint. . OAuth Apps must authenticate using an [OAuth token](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/).", summary = "List subscriptions for the authenticated user", operationId = "apps/list-subscriptions-for-authenticated-user")
  @Path("/marketplace_purchases")
  @GET
  @Produces("application/json")
  Response apps_list_subscriptions_for_authenticated_user(
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Add a single repository to an installation. The authenticated user must have
   * admin access to the repository.
   * </p>
   * <p>
   * You must use a personal access token (which you can create via the <a href=
   * "https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/">command
   * line</a> or the <a href=
   * "https://developer.github.com/v3/oauth_authorizations/#create-a-new-authorization">OAuth
   * Authorizations API</a>) or
   * <a href="https://developer.github.com/v3/auth/#basic-authentication">Basic
   * Authentication</a> to access this endpoint.
   * </p>
   *
   */
  @Operation(description = "Add a single repository to an installation. The authenticated user must have admin access to the repository.\n\nYou must use a personal access token (which you can create via the [command line](https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/) or the [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/#create-a-new-authorization)) or [Basic Authentication](https://developer.github.com/v3/auth/#basic-authentication) to access this endpoint.", summary = "Add a repository to an app installation", operationId = "apps/add-repo-to-installation")
  @Path("/installations/{installation_id}/repositories/{repository_id}")
  @PUT
  void apps_add_repo_to_installation(@PathParam("installation_id") BigInteger installationId,
      @PathParam("repository_id") BigInteger repositoryId);

  /**
   * <p>
   * Remove a single repository from an installation. The authenticated user must
   * have admin access to the repository.
   * </p>
   * <p>
   * You must use a personal access token (which you can create via the <a href=
   * "https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/">command
   * line</a> or the <a href=
   * "https://developer.github.com/v3/oauth_authorizations/#create-a-new-authorization">OAuth
   * Authorizations API</a>) or
   * <a href="https://developer.github.com/v3/auth/#basic-authentication">Basic
   * Authentication</a> to access this endpoint.
   * </p>
   *
   */
  @Operation(description = "Remove a single repository from an installation. The authenticated user must have admin access to the repository.\n\nYou must use a personal access token (which you can create via the [command line](https://help.github.com/articles/creating-a-personal-access-token-for-the-command-line/) or the [OAuth Authorizations API](https://developer.github.com/v3/oauth_authorizations/#create-a-new-authorization)) or [Basic Authentication](https://developer.github.com/v3/auth/#basic-authentication) to access this endpoint.", summary = "Remove a repository from an app installation", operationId = "apps/remove-repo-from-installation")
  @Path("/installations/{installation_id}/repositories/{repository_id}")
  @DELETE
  void apps_remove_repo_from_installation(@PathParam("installation_id") BigInteger installationId,
      @PathParam("repository_id") BigInteger repositoryId);

  /**
   * <p>
   * Lists the active subscriptions for the authenticated user. You must use a
   * <a href=
   * "https://developer.github.com/apps/building-github-apps/identifying-and-authorizing-users-for-github-apps/#identifying-users-on-your-site">user-to-server
   * OAuth access token</a>, created for a user who has authorized your GitHub
   * App, to access this endpoint. . OAuth Apps must authenticate using an
   * <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/">OAuth
   * token</a>.
   * </p>
   *
   */
  @Operation(description = "Lists the active subscriptions for the authenticated user. You must use a [user-to-server OAuth access token](https://developer.github.com/apps/building-github-apps/identifying-and-authorizing-users-for-github-apps/#identifying-users-on-your-site), created for a user who has authorized your GitHub App, to access this endpoint. . OAuth Apps must authenticate using an [OAuth token](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/).", summary = "List subscriptions for the authenticated user (stubbed)", operationId = "apps/list-subscriptions-for-authenticated-user-stubbed")
  @Path("/marketplace_purchases/stubbed")
  @GET
  @Produces("application/json")
  Response apps_list_subscriptions_for_authenticated_user_stubbed(
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);
}
