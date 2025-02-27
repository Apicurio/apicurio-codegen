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
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/orgs")
public interface OrgsResource {
  /**
   * <p>
   * Lists repositories for the specified organization.
   * </p>
   *
   */
  @Operation(description = "Lists repositories for the specified organization.", summary = "List organization repositories", operationId = "repos/list-for-org")
  @Path("/{org}/repos")
  @GET
  @Produces("application/json")
  Response repos_list_for_org(@PathParam("org") String org, @QueryParam("type") String type,
      @QueryParam("sort") @DefaultValue("created") String sort, @QueryParam("direction") String direction,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Creates a new repository in the specified organization. The authenticated
   * user must be a member of the organization.
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
  @Operation(description = "Creates a new repository in the specified organization. The authenticated user must be a member of the organization.\n\n**OAuth scope requirements**\n\nWhen using [OAuth](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/), authorizations must include:\n\n*   `public_repo` scope or `repo` scope to create a public repository\n*   `repo` scope to create a private repository", summary = "Create an organization repository", operationId = "repos/create-in-org")
  @Path("/{org}/repos")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response repos_create_in_org(@PathParam("org") String org, @NotNull InputStream data);

  /**
   * <p>
   * Lists the most recent migrations.
   * </p>
   *
   */
  @Operation(description = "Lists the most recent migrations.", summary = "List organization migrations", operationId = "migrations/list-for-org")
  @Path("/{org}/migrations")
  @GET
  @Produces("application/json")
  Response migrations_list_for_org(@PathParam("org") String org,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Initiates the generation of a migration archive.
   * </p>
   *
   */
  @Operation(description = "Initiates the generation of a migration archive.", summary = "Start an organization migration", operationId = "migrations/start-for-org")
  @Path("/{org}/migrations")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response migrations_start_for_org(@PathParam("org") String org, @NotNull InputStream data);

  /**
   * <p>
   * Unlocks a repository that was locked for migration. You should unlock each
   * migrated repository and
   * <a href="https://developer.github.com/v3/repos/#delete-a-repository">delete
   * them</a> when the migration is complete and you no longer need the source
   * data.
   * </p>
   *
   */
  @Operation(description = "Unlocks a repository that was locked for migration. You should unlock each migrated repository and [delete them](https://developer.github.com/v3/repos/#delete-a-repository) when the migration is complete and you no longer need the source data.", summary = "Unlock an organization repository", operationId = "migrations/unlock-repo-for-org")
  @Path("/{org}/migrations/{migration_id}/repos/{repo_name}/lock")
  @DELETE
  void migrations_unlock_repo_for_org(@PathParam("org") String org, @PathParam("migration_id") BigInteger migrationId,
      @PathParam("repo_name") String repoName);

  /**
   * <p>
   * List all the repositories for this organization migration.
   * </p>
   *
   */
  @Operation(description = "List all the repositories for this organization migration.", summary = "List repositories in an organization migration", operationId = "migrations/list-repos-for-org")
  @Path("/{org}/migrations/{migration_id}/repositories")
  @GET
  @Produces("application/json")
  Response migrations_list_repos_for_org(@PathParam("org") String org,
      @PathParam("migration_id") BigInteger migrationId, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Fetches the URL to a migration archive.
   * </p>
   *
   */
  @Operation(description = "Fetches the URL to a migration archive.", summary = "Download an organization migration archive", operationId = "migrations/download-archive-for-org")
  @Path("/{org}/migrations/{migration_id}/archive")
  @GET
  void migrations_download_archive_for_org(@PathParam("org") String org,
      @PathParam("migration_id") BigInteger migrationId);

  /**
   * <p>
   * Deletes a previous migration archive. Migration archives are automatically
   * deleted after seven days.
   * </p>
   *
   */
  @Operation(description = "Deletes a previous migration archive. Migration archives are automatically deleted after seven days.", summary = "Delete an organization migration archive", operationId = "migrations/delete-archive-for-org")
  @Path("/{org}/migrations/{migration_id}/archive")
  @DELETE
  void migrations_delete_archive_for_org(@PathParam("org") String org,
      @PathParam("migration_id") BigInteger migrationId);

  /**
   * <p>
   * Fetches the status of a migration.
   * </p>
   * <p>
   * The <code>state</code> of a migration can be one of the following values:
   * </p>
   * <ul>
   * <li><code>pending</code>, which means the migration hasn't started yet.</li>
   * <li><code>exporting</code>, which means the migration is in progress.</li>
   * <li><code>exported</code>, which means the migration finished
   * successfully.</li>
   * <li><code>failed</code>, which means the migration failed.</li>
   * </ul>
   *
   */
  @Operation(description = "Fetches the status of a migration.\n\nThe `state` of a migration can be one of the following values:\n\n*   `pending`, which means the migration hasn't started yet.\n*   `exporting`, which means the migration is in progress.\n*   `exported`, which means the migration finished successfully.\n*   `failed`, which means the migration failed.", summary = "Get an organization migration status", operationId = "migrations/get-status-for-org")
  @Path("/{org}/migrations/{migration_id}")
  @GET
  @Produces("application/json")
  Response migrations_get_status_for_org(@PathParam("org") String org,
      @PathParam("migration_id") BigInteger migrationId);

  /**
   * <p>
   * Shows which group of GitHub users can interact with this organization and
   * when the restriction expires. If there are no restrictions, you will see an
   * empty response.
   * </p>
   *
   */
  @Operation(description = "Shows which group of GitHub users can interact with this organization and when the restriction expires. If there are no restrictions, you will see an empty response.", summary = "Get interaction restrictions for an organization", operationId = "interactions/get-restrictions-for-org")
  @Path("/{org}/interaction-limits")
  @GET
  @Produces("application/json")
  Response interactions_get_restrictions_for_org(@PathParam("org") String org);

  /**
   * <p>
   * Temporarily restricts interactions to certain GitHub users in any public
   * repository in the given organization. You must be an organization owner to
   * set these restrictions.
   * </p>
   *
   */
  @Operation(description = "Temporarily restricts interactions to certain GitHub users in any public repository in the given organization. You must be an organization owner to set these restrictions.", summary = "Set interaction restrictions for an organization", operationId = "interactions/set-restrictions-for-org")
  @Path("/{org}/interaction-limits")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response interactions_set_restrictions_for_org(@PathParam("org") String org, @NotNull InputStream data);

  /**
   * <p>
   * Removes all interaction restrictions from public repositories in the given
   * organization. You must be an organization owner to remove restrictions.
   * </p>
   *
   */
  @Operation(description = "Removes all interaction restrictions from public repositories in the given organization. You must be an organization owner to remove restrictions.", summary = "Remove interaction restrictions for an organization", operationId = "interactions/remove-restrictions-for-org")
  @Path("/{org}/interaction-limits")
  @DELETE
  void interactions_remove_restrictions_for_org(@PathParam("org") String org);

  /**
   *
   */
  @Operation(description = "", summary = "List public organization events", operationId = "activity/list-public-org-events")
  @Path("/{org}/events")
  @GET
  @Produces("application/json")
  Response activity_list_public_org_events(@PathParam("org") String org,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Lists the projects in an organization. Returns a <code>404 Not Found</code>
   * status if projects are disabled in the organization. If you do not have
   * sufficient privileges to perform this action, a <code>401 Unauthorized</code>
   * or <code>410 Gone</code> status is returned.
   * </p>
   *
   */
  @Operation(description = "Lists the projects in an organization. Returns a `404 Not Found` status if projects are disabled in the organization. If you do not have sufficient privileges to perform this action, a `401 Unauthorized` or `410 Gone` status is returned.", summary = "List organization projects", operationId = "projects/list-for-org")
  @Path("/{org}/projects")
  @GET
  @Produces("application/json")
  Response projects_list_for_org(@PathParam("org") String org, @QueryParam("state") @DefaultValue("open") String state,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Creates an organization project board. Returns a <code>404 Not Found</code>
   * status if projects are disabled in the organization. If you do not have
   * sufficient privileges to perform this action, a <code>401 Unauthorized</code>
   * or <code>410 Gone</code> status is returned.
   * </p>
   *
   */
  @Operation(description = "Creates an organization project board. Returns a `404 Not Found` status if projects are disabled in the organization. If you do not have sufficient privileges to perform this action, a `401 Unauthorized` or `410 Gone` status is returned.", summary = "Create an organization project", operationId = "projects/create-for-org")
  @Path("/{org}/projects")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response projects_create_for_org(@PathParam("org") String org, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Note:</strong> You can also specify a team or organization with
   * <code>team_id</code> and <code>org_id</code> using the route
   * <code>DELETE /organizations/:org_id/team/:team_id/discussions/:discussion_number/reactions/:reaction_id</code>.
   * </p>
   * <p>
   * Delete a reaction to a
   * <a href="https://developer.github.com/v3/teams/discussions/">team
   * discussion</a>. OAuth access tokens require the <code>write:discussion</code>
   * <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "**Note:** You can also specify a team or organization with `team_id` and `org_id` using the route `DELETE /organizations/:org_id/team/:team_id/discussions/:discussion_number/reactions/:reaction_id`.\n\nDelete a reaction to a [team discussion](https://developer.github.com/v3/teams/discussions/). OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Delete team discussion reaction", operationId = "reactions/delete-for-team-discussion")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}/reactions/{reaction_id}")
  @DELETE
  void reactions_delete_for_team_discussion(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("discussion_number") BigInteger discussionNumber, @PathParam("reaction_id") BigInteger reactionId);

  /**
   * <p>
   * <strong>Note:</strong> You can also specify a team or organization with
   * <code>team_id</code> and <code>org_id</code> using the route
   * <code>DELETE /organizations/:org_id/team/:team_id/discussions/:discussion_number/comments/:comment_number/reactions/:reaction_id</code>.
   * </p>
   * <p>
   * Delete a reaction to a
   * <a href="https://developer.github.com/v3/teams/discussion_comments/">team
   * discussion comment</a>. OAuth access tokens require the
   * <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "**Note:** You can also specify a team or organization with `team_id` and `org_id` using the route `DELETE /organizations/:org_id/team/:team_id/discussions/:discussion_number/comments/:comment_number/reactions/:reaction_id`.\n\nDelete a reaction to a [team discussion comment](https://developer.github.com/v3/teams/discussion_comments/). OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Delete team discussion comment reaction", operationId = "reactions/delete-for-team-discussion-comment")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}/comments/{comment_number}/reactions/{reaction_id}")
  @DELETE
  void reactions_delete_for_team_discussion_comment(@PathParam("org") String org,
      @PathParam("team_slug") String teamSlug, @PathParam("discussion_number") BigInteger discussionNumber,
      @PathParam("comment_number") BigInteger commentNumber, @PathParam("reaction_id") BigInteger reactionId);

  /**
   * <p>
   * List the reactions to a
   * <a href="https://developer.github.com/v3/teams/discussion_comments/">team
   * discussion comment</a>. OAuth access tokens require the
   * <code>read:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/:org_id/team/:team_id/discussions/:discussion_number/comments/:comment_number/reactions</code>.
   * </p>
   *
   */
  @Operation(description = "List the reactions to a [team discussion comment](https://developer.github.com/v3/teams/discussion_comments/). OAuth access tokens require the `read:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/:org_id/team/:team_id/discussions/:discussion_number/comments/:comment_number/reactions`.", summary = "List reactions for a team discussion comment", operationId = "reactions/list-for-team-discussion-comment-in-org")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}/comments/{comment_number}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_team_discussion_comment_in_org(@PathParam("org") String org,
      @PathParam("team_slug") String teamSlug, @PathParam("discussion_number") BigInteger discussionNumber,
      @PathParam("comment_number") BigInteger commentNumber, @QueryParam("content") String content,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Create a reaction to a
   * <a href="https://developer.github.com/v3/teams/discussion_comments/">team
   * discussion comment</a>. OAuth access tokens require the
   * <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * A response with a <code>Status: 200 OK</code> means that you already added
   * the reaction type to this team discussion comment.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>POST /organizations/:org_id/team/:team_id/discussions/:discussion_number/comments/:comment_number/reactions</code>.
   * </p>
   *
   */
  @Operation(description = "Create a reaction to a [team discussion comment](https://developer.github.com/v3/teams/discussion_comments/). OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/). A response with a `Status: 200 OK` means that you already added the reaction type to this team discussion comment.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `POST /organizations/:org_id/team/:team_id/discussions/:discussion_number/comments/:comment_number/reactions`.", summary = "Create reaction for a team discussion comment", operationId = "reactions/create-for-team-discussion-comment-in-org")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}/comments/{comment_number}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_team_discussion_comment_in_org(@PathParam("org") String org,
      @PathParam("team_slug") String teamSlug, @PathParam("discussion_number") BigInteger discussionNumber,
      @PathParam("comment_number") BigInteger commentNumber, @NotNull InputStream data);

  /**
   * <p>
   * List the reactions to a
   * <a href="https://developer.github.com/v3/teams/discussions/">team
   * discussion</a>. OAuth access tokens require the <code>read:discussion</code>
   * <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/:org_id/team/:team_id/discussions/:discussion_number/reactions</code>.
   * </p>
   *
   */
  @Operation(description = "List the reactions to a [team discussion](https://developer.github.com/v3/teams/discussions/). OAuth access tokens require the `read:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/:org_id/team/:team_id/discussions/:discussion_number/reactions`.", summary = "List reactions for a team discussion", operationId = "reactions/list-for-team-discussion-in-org")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_team_discussion_in_org(@PathParam("org") String org,
      @PathParam("team_slug") String teamSlug, @PathParam("discussion_number") BigInteger discussionNumber,
      @QueryParam("content") String content, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Create a reaction to a
   * <a href="https://developer.github.com/v3/teams/discussions/">team
   * discussion</a>. OAuth access tokens require the <code>write:discussion</code>
   * <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * A response with a <code>Status: 200 OK</code> means that you already added
   * the reaction type to this team discussion.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>POST /organizations/:org_id/team/:team_id/discussions/:discussion_number/reactions</code>.
   * </p>
   *
   */
  @Operation(description = "Create a reaction to a [team discussion](https://developer.github.com/v3/teams/discussions/). OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/). A response with a `Status: 200 OK` means that you already added the reaction type to this team discussion.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `POST /organizations/:org_id/team/:team_id/discussions/:discussion_number/reactions`.", summary = "Create reaction for a team discussion", operationId = "reactions/create-for-team-discussion-in-org")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_team_discussion_in_org(@PathParam("org") String org,
      @PathParam("team_slug") String teamSlug, @PathParam("discussion_number") BigInteger discussionNumber,
      @NotNull InputStream data);

  /**
   * <p>
   * Listing and deleting credential authorizations is available to organizations
   * with GitHub Enterprise Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a>.
   * </p>
   * <p>
   * An authenticated organization owner with the <code>read:org</code> scope can
   * list all credential authorizations for an organization that uses SAML single
   * sign-on (SSO). The credentials are either personal access tokens or SSH keys
   * that organization members have authorized for the organization. For more
   * information, see <a href=
   * "https://help.github.com/en/articles/about-authentication-with-saml-single-sign-on">About
   * authentication with SAML single sign-on</a>.
   * </p>
   *
   */
  @Operation(description = "Listing and deleting credential authorizations is available to organizations with GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products).\n\nAn authenticated organization owner with the `read:org` scope can list all credential authorizations for an organization that uses SAML single sign-on (SSO). The credentials are either personal access tokens or SSH keys that organization members have authorized for the organization. For more information, see [About authentication with SAML single sign-on](https://help.github.com/en/articles/about-authentication-with-saml-single-sign-on).", summary = "List SAML SSO authorizations for an organization", operationId = "orgs/list-saml-sso-authorizations")
  @Path("/{org}/credential-authorizations")
  @GET
  @Produces("application/json")
  Response orgs_list_saml_sso_authorizations(@PathParam("org") String org);

  /**
   * <p>
   * List all teams associated with an invitation. In order to see invitations in
   * an organization, the authenticated user must be an organization owner.
   * </p>
   *
   */
  @Operation(description = "List all teams associated with an invitation. In order to see invitations in an organization, the authenticated user must be an organization owner.", summary = "List organization invitation teams", operationId = "orgs/list-invitation-teams")
  @Path("/{org}/invitations/{invitation_id}/teams")
  @GET
  @Produces("application/json")
  Response orgs_list_invitation_teams(@PathParam("org") String org, @PathParam("invitation_id") BigInteger invitationId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * When an organization member is converted to an outside collaborator, they'll
   * only have access to the repositories that their current team membership
   * allows. The user will no longer be a member of the organization. For more
   * information, see &quot;<a href=
   * "https://help.github.com/articles/converting-an-organization-member-to-an-outside-collaborator/">Converting
   * an organization member to an outside collaborator</a>&quot;.
   * </p>
   *
   */
  @Operation(description = "When an organization member is converted to an outside collaborator, they'll only have access to the repositories that their current team membership allows. The user will no longer be a member of the organization. For more information, see \"[Converting an organization member to an outside collaborator](https://help.github.com/articles/converting-an-organization-member-to-an-outside-collaborator/)\".", summary = "Convert an organization member to outside collaborator", operationId = "orgs/convert-member-to-outside-collaborator")
  @Path("/{org}/outside_collaborators/{username}")
  @PUT
  void orgs_convert_member_to_outside_collaborator(@PathParam("org") String org,
      @PathParam("username") String username);

  /**
   * <p>
   * Removing a user from this list will remove them from all the organization's
   * repositories.
   * </p>
   *
   */
  @Operation(description = "Removing a user from this list will remove them from all the organization's repositories.", summary = "Remove outside collaborator from an organization", operationId = "orgs/remove-outside-collaborator")
  @Path("/{org}/outside_collaborators/{username}")
  @DELETE
  void orgs_remove_outside_collaborator(@PathParam("org") String org, @PathParam("username") String username);

  /**
   * <p>
   * In order to get a user's membership with an organization, the authenticated
   * user must be an organization member.
   * </p>
   *
   */
  @Operation(description = "In order to get a user's membership with an organization, the authenticated user must be an organization member.", summary = "Get organization membership for a user", operationId = "orgs/get-membership-for-user")
  @Path("/{org}/memberships/{username}")
  @GET
  @Produces("application/json")
  Response orgs_get_membership_for_user(@PathParam("org") String org, @PathParam("username") String username);

  /**
   * <p>
   * Only authenticated organization owners can add a member to the organization
   * or update the member's role.
   * </p>
   * <ul>
   * <li>
   * <p>
   * If the authenticated user is <em>adding</em> a member to the organization,
   * the invited user will receive an email inviting them to the organization. The
   * user's <a href=
   * "https://developer.github.com/v3/orgs/members/#get-organization-membership-for-a-user">membership
   * status</a> will be <code>pending</code> until they accept the invitation.
   * </p>
   * </li>
   * <li>
   * <p>
   * Authenticated users can <em>update</em> a user's membership by passing the
   * <code>role</code> parameter. If the authenticated user changes a member's
   * role to <code>admin</code>, the affected user will receive an email notifying
   * them that they've been made an organization owner. If the authenticated user
   * changes an owner's role to <code>member</code>, no email will be sent.
   * </p>
   * </li>
   * </ul>
   * <p>
   * <strong>Rate limits</strong>
   * </p>
   * <p>
   * To prevent abuse, the authenticated user is limited to 50 organization
   * invitations per 24 hour period. If the organization is more than one month
   * old or on a paid plan, the limit is 500 invitations per 24 hour period.
   * </p>
   *
   */
  @Operation(description = "Only authenticated organization owners can add a member to the organization or update the member's role.\n\n*   If the authenticated user is _adding_ a member to the organization, the invited user will receive an email inviting them to the organization. The user's [membership status](https://developer.github.com/v3/orgs/members/#get-organization-membership-for-a-user) will be `pending` until they accept the invitation.\n    \n*   Authenticated users can _update_ a user's membership by passing the `role` parameter. If the authenticated user changes a member's role to `admin`, the affected user will receive an email notifying them that they've been made an organization owner. If the authenticated user changes an owner's role to `member`, no email will be sent.\n\n**Rate limits**\n\nTo prevent abuse, the authenticated user is limited to 50 organization invitations per 24 hour period. If the organization is more than one month old or on a paid plan, the limit is 500 invitations per 24 hour period.", summary = "Set organization membership for a user", operationId = "orgs/set-membership-for-user")
  @Path("/{org}/memberships/{username}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response orgs_set_membership_for_user(@PathParam("org") String org, @PathParam("username") String username,
      @NotNull InputStream data);

  /**
   * <p>
   * In order to remove a user's membership with an organization, the
   * authenticated user must be an organization owner.
   * </p>
   * <p>
   * If the specified user is an active member of the organization, this will
   * remove them from the organization. If the specified user has been invited to
   * the organization, this will cancel their invitation. The specified user will
   * receive an email notification in both cases.
   * </p>
   *
   */
  @Operation(description = "In order to remove a user's membership with an organization, the authenticated user must be an organization owner.\n\nIf the specified user is an active member of the organization, this will remove them from the organization. If the specified user has been invited to the organization, this will cancel their invitation. The specified user will receive an email notification in both cases.", summary = "Remove organization membership for a user", operationId = "orgs/remove-membership-for-user")
  @Path("/{org}/memberships/{username}")
  @DELETE
  void orgs_remove_membership_for_user(@PathParam("org") String org, @PathParam("username") String username);

  /**
   *
   */
  @Operation(description = "", summary = "Get an organization webhook", operationId = "orgs/get-webhook")
  @Path("/{org}/hooks/{hook_id}")
  @GET
  @Produces("application/json")
  Response orgs_get_webhook(@PathParam("org") String org, @PathParam("hook_id") BigInteger hookId);

  /**
   *
   */
  @Operation(description = "", summary = "Delete an organization webhook", operationId = "orgs/delete-webhook")
  @Path("/{org}/hooks/{hook_id}")
  @DELETE
  void orgs_delete_webhook(@PathParam("org") String org, @PathParam("hook_id") BigInteger hookId);

  /**
   *
   */
  @Operation(description = "", summary = "Update an organization webhook", operationId = "orgs/update-webhook")
  @Path("/{org}/hooks/{hook_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response orgs_update_webhook(@PathParam("org") String org, @PathParam("hook_id") BigInteger hookId,
      @NotNull InputStream data);

  /**
   * <p>
   * To see many of the organization response values, you need to be an
   * authenticated organization owner with the <code>admin:org</code> scope. When
   * the value of <code>two_factor_requirement_enabled</code> is
   * <code>true</code>, the organization requires all members, billing managers,
   * and outside collaborators to enable <a href=
   * "https://help.github.com/articles/securing-your-account-with-two-factor-authentication-2fa/">two-factor
   * authentication</a>.
   * </p>
   * <p>
   * GitHub Apps with the <code>Organization plan</code> permission can use this
   * endpoint to retrieve information about an organization's GitHub plan. See
   * &quot;<a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/">Authenticating
   * with GitHub Apps</a>&quot; for details. For an example response, see
   * &quot;<a href=
   * "https://developer.github.com/v3/orgs/#response-with-github-plan-information">Response
   * with GitHub plan information</a>.&quot;
   * </p>
   *
   */
  @Operation(description = "To see many of the organization response values, you need to be an authenticated organization owner with the `admin:org` scope. When the value of `two_factor_requirement_enabled` is `true`, the organization requires all members, billing managers, and outside collaborators to enable [two-factor authentication](https://help.github.com/articles/securing-your-account-with-two-factor-authentication-2fa/).\n\nGitHub Apps with the `Organization plan` permission can use this endpoint to retrieve information about an organization's GitHub plan. See \"[Authenticating with GitHub Apps](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/)\" for details. For an example response, see \"[Response with GitHub plan information](https://developer.github.com/v3/orgs/#response-with-github-plan-information).\"", summary = "Get an organization", operationId = "orgs/get")
  @Path("/{org}")
  @GET
  @Produces("application/json")
  Response orgs_get(@PathParam("org") String org);

  /**
   * <p>
   * <strong>Parameter Deprecation Notice:</strong> GitHub will replace and
   * discontinue <code>members_allowed_repository_creation_type</code> in favor of
   * more granular permissions. The new input parameters are
   * <code>members_can_create_public_repositories</code>,
   * <code>members_can_create_private_repositories</code> for all organizations
   * and <code>members_can_create_internal_repositories</code> for organizations
   * associated with an enterprise account using GitHub Enterprise Cloud or GitHub
   * Enterprise Server 2.20+. For more information, see the <a href=
   * "https://developer.github.com/changes/2019-12-03-internal-visibility-changes">blog
   * post</a>.
   * </p>
   * <p>
   * Enables an authenticated organization owner with the <code>admin:org</code>
   * scope to update the organization's profile and member privileges.
   * </p>
   *
   */
  @Operation(description = "**Parameter Deprecation Notice:** GitHub will replace and discontinue `members_allowed_repository_creation_type` in favor of more granular permissions. The new input parameters are `members_can_create_public_repositories`, `members_can_create_private_repositories` for all organizations and `members_can_create_internal_repositories` for organizations associated with an enterprise account using GitHub Enterprise Cloud or GitHub Enterprise Server 2.20+. For more information, see the [blog post](https://developer.github.com/changes/2019-12-03-internal-visibility-changes).\n\nEnables an authenticated organization owner with the `admin:org` scope to update the organization's profile and member privileges.", summary = "Update an organization", operationId = "orgs/update")
  @Path("/{org}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response orgs_update(@PathParam("org") String org, @NotNull InputStream data);

  /**
   * <p>
   * This will trigger a
   * <a href="https://developer.github.com/webhooks/#ping-event">ping event</a> to
   * be sent to the hook.
   * </p>
   *
   */
  @Operation(description = "This will trigger a [ping event](https://developer.github.com/webhooks/#ping-event) to be sent to the hook.", summary = "Ping an organization webhook", operationId = "orgs/ping-webhook")
  @Path("/{org}/hooks/{hook_id}/pings")
  @POST
  void orgs_ping_webhook(@PathParam("org") String org, @PathParam("hook_id") BigInteger hookId);

  /**
   * <p>
   * Check if a user is, publicly or privately, a member of the organization.
   * </p>
   *
   */
  @Operation(description = "Check if a user is, publicly or privately, a member of the organization.", summary = "Check organization membership for a user", operationId = "orgs/check-membership-for-user")
  @Path("/{org}/members/{username}")
  @GET
  void orgs_check_membership_for_user(@PathParam("org") String org, @PathParam("username") String username);

  /**
   * <p>
   * Removing a user from this list will remove them from all teams and they will
   * no longer have any access to the organization's repositories.
   * </p>
   *
   */
  @Operation(description = "Removing a user from this list will remove them from all teams and they will no longer have any access to the organization's repositories.", summary = "Remove an organization member", operationId = "orgs/remove-member")
  @Path("/{org}/members/{username}")
  @DELETE
  void orgs_remove_member(@PathParam("org") String org, @PathParam("username") String username);

  /**
   * <p>
   * Lists all GitHub Apps in an organization. The installation count includes all
   * GitHub Apps installed on repositories in the organization. You must be an
   * organization owner with <code>admin:read</code> scope to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Lists all GitHub Apps in an organization. The installation count includes all GitHub Apps installed on repositories in the organization. You must be an organization owner with `admin:read` scope to use this endpoint.", summary = "List app installations for an organization", operationId = "orgs/list-app-installations")
  @Path("/{org}/installations")
  @GET
  @Produces("application/json")
  Response orgs_list_app_installations(@PathParam("org") String org,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Check public organization membership for a user", operationId = "orgs/check-public-membership-for-user")
  @Path("/{org}/public_members/{username}")
  @GET
  void orgs_check_public_membership_for_user(@PathParam("org") String org, @PathParam("username") String username);

  /**
   * <p>
   * The user can publicize their own membership. (A user cannot publicize the
   * membership for another user.)
   * </p>
   * <p>
   * Note that you'll need to set <code>Content-Length</code> to zero when calling
   * out to this endpoint. For more information, see
   * &quot;<a href="https://developer.github.com/v3/#http-verbs">HTTP
   * verbs</a>.&quot;
   * </p>
   *
   */
  @Operation(description = "The user can publicize their own membership. (A user cannot publicize the membership for another user.)\n\nNote that you'll need to set `Content-Length` to zero when calling out to this endpoint. For more information, see \"[HTTP verbs](https://developer.github.com/v3/#http-verbs).\"", summary = "Set public organization membership for the authenticated user", operationId = "orgs/set-public-membership-for-authenticated-user")
  @Path("/{org}/public_members/{username}")
  @PUT
  void orgs_set_public_membership_for_authenticated_user(@PathParam("org") String org,
      @PathParam("username") String username);

  /**
   *
   */
  @Operation(description = "", summary = "Remove public organization membership for the authenticated user", operationId = "orgs/remove-public-membership-for-authenticated-user")
  @Path("/{org}/public_members/{username}")
  @DELETE
  void orgs_remove_public_membership_for_authenticated_user(@PathParam("org") String org,
      @PathParam("username") String username);

  /**
   * <p>
   * List all users who are outside collaborators of an organization.
   * </p>
   *
   */
  @Operation(description = "List all users who are outside collaborators of an organization.", summary = "List outside collaborators for an organization", operationId = "orgs/list-outside-collaborators")
  @Path("/{org}/outside_collaborators")
  @GET
  @Produces("application/json")
  Response orgs_list_outside_collaborators(@PathParam("org") String org,
      @QueryParam("filter") @DefaultValue("all") String filter,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * The return hash contains a <code>role</code> field which refers to the
   * Organization Invitation role and will be one of the following values:
   * <code>direct_member</code>, <code>admin</code>, <code>billing_manager</code>,
   * <code>hiring_manager</code>, or <code>reinstate</code>. If the invitee is not
   * a GitHub member, the <code>login</code> field in the return hash will be
   * <code>null</code>.
   * </p>
   *
   */
  @Operation(description = "The return hash contains a `role` field which refers to the Organization Invitation role and will be one of the following values: `direct_member`, `admin`, `billing_manager`, `hiring_manager`, or `reinstate`. If the invitee is not a GitHub member, the `login` field in the return hash will be `null`.", summary = "List pending organization invitations", operationId = "orgs/list-pending-invitations")
  @Path("/{org}/invitations")
  @GET
  @Produces("application/json")
  Response orgs_list_pending_invitations(@PathParam("org") String org,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Invite people to an organization by using their GitHub user ID or their email
   * address. In order to create invitations in an organization, the authenticated
   * user must be an organization owner.
   * </p>
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   *
   */
  @Operation(description = "Invite people to an organization by using their GitHub user ID or their email address. In order to create invitations in an organization, the authenticated user must be an organization owner.\n\nThis endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.", summary = "Create an organization invitation", operationId = "orgs/create-invitation")
  @Path("/{org}/invitations")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response orgs_create_invitation(@PathParam("org") String org, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "List organization webhooks", operationId = "orgs/list-webhooks")
  @Path("/{org}/hooks")
  @GET
  @Produces("application/json")
  Response orgs_list_webhooks(@PathParam("org") String org,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Here's how you can create a hook that posts payloads in JSON format:
   * </p>
   *
   */
  @Operation(description = "Here's how you can create a hook that posts payloads in JSON format:", summary = "Create an organization webhook", operationId = "orgs/create-webhook")
  @Path("/{org}/hooks")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response orgs_create_webhook(@PathParam("org") String org, @NotNull InputStream data);

  /**
   * <p>
   * List the users blocked by an organization.
   * </p>
   *
   */
  @Operation(description = "List the users blocked by an organization.", summary = "List users blocked by an organization", operationId = "orgs/list-blocked-users")
  @Path("/{org}/blocks")
  @GET
  @Produces("application/json")
  Response orgs_list_blocked_users(@PathParam("org") String org);

  /**
   *
   */
  @Operation(description = "", summary = "Check if a user is blocked by an organization", operationId = "orgs/check-blocked-user")
  @Path("/{org}/blocks/{username}")
  @GET
  void orgs_check_blocked_user(@PathParam("org") String org, @PathParam("username") String username);

  /**
   *
   */
  @Operation(description = "", summary = "Block a user from an organization", operationId = "orgs/block-user")
  @Path("/{org}/blocks/{username}")
  @PUT
  void orgs_block_user(@PathParam("org") String org, @PathParam("username") String username);

  /**
   *
   */
  @Operation(description = "", summary = "Unblock a user from an organization", operationId = "orgs/unblock-user")
  @Path("/{org}/blocks/{username}")
  @DELETE
  void orgs_unblock_user(@PathParam("org") String org, @PathParam("username") String username);

  /**
   * <p>
   * List all users who are members of an organization. If the authenticated user
   * is also a member of this organization then both concealed and public members
   * will be returned.
   * </p>
   *
   */
  @Operation(description = "List all users who are members of an organization. If the authenticated user is also a member of this organization then both concealed and public members will be returned.", summary = "List organization members", operationId = "orgs/list-members")
  @Path("/{org}/members")
  @GET
  @Produces("application/json")
  Response orgs_list_members(@PathParam("org") String org, @QueryParam("filter") @DefaultValue("all") String filter,
      @QueryParam("role") @DefaultValue("all") String role,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Listing and deleting credential authorizations is available to organizations
   * with GitHub Enterprise Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a>.
   * </p>
   * <p>
   * An authenticated organization owner with the <code>admin:org</code> scope can
   * remove a credential authorization for an organization that uses SAML SSO.
   * Once you remove someone's credential authorization, they will need to create
   * a new personal access token or SSH key and authorize it for the organization
   * they want to access.
   * </p>
   *
   */
  @Operation(description = "Listing and deleting credential authorizations is available to organizations with GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products).\n\nAn authenticated organization owner with the `admin:org` scope can remove a credential authorization for an organization that uses SAML SSO. Once you remove someone's credential authorization, they will need to create a new personal access token or SSH key and authorize it for the organization they want to access.", summary = "Remove a SAML SSO authorization for an organization", operationId = "orgs/remove-saml-sso-authorization")
  @Path("/{org}/credential-authorizations/{credential_id}")
  @DELETE
  void orgs_remove_saml_sso_authorization(@PathParam("org") String org,
      @PathParam("credential_id") BigInteger credentialId);

  /**
   * <p>
   * Members of an organization can choose to have their membership publicized or
   * not.
   * </p>
   *
   */
  @Operation(description = "Members of an organization can choose to have their membership publicized or not.", summary = "List public organization members", operationId = "orgs/list-public-members")
  @Path("/{org}/public_members")
  @GET
  @Produces("application/json")
  Response orgs_list_public_members(@PathParam("org") String org,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * <strong>Warning:</strong> The self-hosted runners API for organizations is
   * currently in public beta and subject to change.
   * </p>
   * <p>
   * Gets a specific self-hosted runner for an organization. You must authenticate
   * using an access token with the <code>admin:org</code> scope to use this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "**Warning:** The self-hosted runners API for organizations is currently in public beta and subject to change.\n\nGets a specific self-hosted runner for an organization. You must authenticate using an access token with the `admin:org` scope to use this endpoint.", summary = "Get a self-hosted runner for an organization", operationId = "actions/get-self-hosted-runner-for-org")
  @Path("/{org}/actions/runners/{runner_id}")
  @GET
  @Produces("application/json")
  Response actions_get_self_hosted_runner_for_org(@PathParam("org") String org,
      @PathParam("runner_id") BigInteger runnerId);

  /**
   * <p>
   * <strong>Warning:</strong> The self-hosted runners API for organizations is
   * currently in public beta and subject to change.
   * </p>
   * <p>
   * Forces the removal of a self-hosted runner from an organization. You can use
   * this endpoint to completely remove the runner when the machine you were using
   * no longer exists. You must authenticate using an access token with the
   * <code>admin:org</code> scope to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "**Warning:** The self-hosted runners API for organizations is currently in public beta and subject to change.\n\nForces the removal of a self-hosted runner from an organization. You can use this endpoint to completely remove the runner when the machine you were using no longer exists. You must authenticate using an access token with the `admin:org` scope to use this endpoint.", summary = "Delete a self-hosted runner from an organization", operationId = "actions/delete-self-hosted-runner-from-org")
  @Path("/{org}/actions/runners/{runner_id}")
  @DELETE
  void actions_delete_self_hosted_runner_from_org(@PathParam("org") String org,
      @PathParam("runner_id") BigInteger runnerId);

  /**
   * <p>
   * <strong>Warning:</strong> The self-hosted runners API for organizations is
   * currently in public beta and subject to change.
   * </p>
   * <p>
   * Lists all self-hosted runners for an organization. You must authenticate
   * using an access token with the <code>admin:org</code> scope to use this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "**Warning:** The self-hosted runners API for organizations is currently in public beta and subject to change.\n\nLists all self-hosted runners for an organization. You must authenticate using an access token with the `admin:org` scope to use this endpoint.", summary = "List self-hosted runners for an organization", operationId = "actions/list-self-hosted-runners-for-org")
  @Path("/{org}/actions/runners")
  @GET
  @Produces("application/json")
  Response actions_list_self_hosted_runners_for_org(@PathParam("org") String org,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Gets a single organization secret without revealing its encrypted value. You
   * must authenticate using an access token with the <code>admin:org</code> scope
   * to use this endpoint. GitHub Apps must have the <code>secrets</code>
   * organization permission to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Gets a single organization secret without revealing its encrypted value. You must authenticate using an access token with the `admin:org` scope to use this endpoint. GitHub Apps must have the `secrets` organization permission to use this endpoint.", summary = "Get an organization secret", operationId = "actions/get-org-secret")
  @Path("/{org}/actions/secrets/{secret_name}")
  @GET
  @Produces("application/json")
  Response actions_get_org_secret(@PathParam("org") String org, @PathParam("secret_name") String secretName);

  /**
   * <p>
   * Creates or updates an organization secret with an encrypted value. Encrypt
   * your secret using <a href=
   * "https://libsodium.gitbook.io/doc/bindings_for_other_languages">LibSodium</a>.
   * You must authenticate using an access token with the <code>admin:org</code>
   * scope to use this endpoint. GitHub Apps must have the <code>secrets</code>
   * organization permission to use this endpoint.
   * </p>
   * <h4>Example encrypting a secret using Node.js</h4>
   * <p>
   * Encrypt your secret using the
   * <a href="https://github.com/github/tweetsodium">tweetsodium</a> library.
   * </p>
   *
   * <pre>
   * <code>const sodium = require('tweetsodium');

  const key = &quot;base64-encoded-public-key&quot;;
  const value = &quot;plain-text-secret&quot;;

  // Convert the message and key to Uint8Array's (Buffer implements that interface)
  const messageBytes = Buffer.from(value);
  const keyBytes = Buffer.from(key, 'base64');

  // Encrypt using LibSodium.
  const encryptedBytes = sodium.seal(messageBytes, keyBytes);

  // Base64 the encrypted secret
  const encrypted = Buffer.from(encryptedBytes).toString('base64');

  console.log(encrypted);
  </code>
   * </pre>
   *
   * <h4>Example encrypting a secret using Python</h4>
   * <p>
   * Encrypt your secret using <a href=
   * "https://pynacl.readthedocs.io/en/stable/public/#nacl-public-sealedbox">pynacl</a>
   * with Python 3.
   * </p>
   *
   * <pre>
   * <code>from base64 import b64encode
  from nacl import encoding, public

  def encrypt(public_key: str, secret_value: str) -&gt; str:
    &quot;&quot;&quot;Encrypt a Unicode string using the public key.&quot;&quot;&quot;
    public_key = public.PublicKey(public_key.encode(&quot;utf-8&quot;), encoding.Base64Encoder())
    sealed_box = public.SealedBox(public_key)
    encrypted = sealed_box.encrypt(secret_value.encode(&quot;utf-8&quot;))
    return b64encode(encrypted).decode(&quot;utf-8&quot;)
  </code>
   * </pre>
   *
   * <h4>Example encrypting a secret using C#</h4>
   * <p>
   * Encrypt your secret using the
   * <a href="https://www.nuget.org/packages/Sodium.Core/">Sodium.Core</a>
   * package.
   * </p>
   *
   * <pre>
   * <code>var secretValue = System.Text.Encoding.UTF8.GetBytes(&quot;mySecret&quot;);
  var publicKey = Convert.FromBase64String(&quot;2Sg8iYjAxxmI2LvUXpJjkYrMxURPc8r+dB7TJyvvcCU=&quot;);

  var sealedPublicKeyBox = Sodium.SealedPublicKeyBox.Create(secretValue, publicKey);

  Console.WriteLine(Convert.ToBase64String(sealedPublicKeyBox));
  </code>
   * </pre>
   *
   * <h4>Example encrypting a secret using Ruby</h4>
   * <p>
   * Encrypt your secret using the
   * <a href="https://github.com/RubyCrypto/rbnacl">rbnacl</a> gem.
   * </p>
   *
   * <pre>
   * <code class="language-ruby">require &quot;rbnacl&quot;
  require &quot;base64&quot;

  key = Base64.decode64(&quot;+ZYvJDZMHUfBkJdyq5Zm9SKqeuBQ4sj+6sfjlH4CgG0=&quot;)
  public_key = RbNaCl::PublicKey.new(key)

  box = RbNaCl::Boxes::Sealed.from_public_key(public_key)
  encrypted_secret = box.encrypt(&quot;my_secret&quot;)

  # Print the base64 encoded secret
  puts Base64.strict_encode64(encrypted_secret)
  </code>
   * </pre>
   *
   */
  @Operation(description = "Creates or updates an organization secret with an encrypted value. Encrypt your secret using\n[LibSodium](https://libsodium.gitbook.io/doc/bindings_for_other_languages). You must authenticate using an access\ntoken with the `admin:org` scope to use this endpoint. GitHub Apps must have the `secrets` organization permission to\nuse this endpoint.\n\n#### Example encrypting a secret using Node.js\n\nEncrypt your secret using the [tweetsodium](https://github.com/github/tweetsodium) library.\n\n```\nconst sodium = require('tweetsodium');\n\nconst key = \"base64-encoded-public-key\";\nconst value = \"plain-text-secret\";\n\n// Convert the message and key to Uint8Array's (Buffer implements that interface)\nconst messageBytes = Buffer.from(value);\nconst keyBytes = Buffer.from(key, 'base64');\n\n// Encrypt using LibSodium.\nconst encryptedBytes = sodium.seal(messageBytes, keyBytes);\n\n// Base64 the encrypted secret\nconst encrypted = Buffer.from(encryptedBytes).toString('base64');\n\nconsole.log(encrypted);\n```\n\n\n#### Example encrypting a secret using Python\n\nEncrypt your secret using [pynacl](https://pynacl.readthedocs.io/en/stable/public/#nacl-public-sealedbox) with Python 3.\n\n```\nfrom base64 import b64encode\nfrom nacl import encoding, public\n\ndef encrypt(public_key: str, secret_value: str) -> str:\n  \"\"\"Encrypt a Unicode string using the public key.\"\"\"\n  public_key = public.PublicKey(public_key.encode(\"utf-8\"), encoding.Base64Encoder())\n  sealed_box = public.SealedBox(public_key)\n  encrypted = sealed_box.encrypt(secret_value.encode(\"utf-8\"))\n  return b64encode(encrypted).decode(\"utf-8\")\n```\n\n#### Example encrypting a secret using C#\n\nEncrypt your secret using the [Sodium.Core](https://www.nuget.org/packages/Sodium.Core/) package.\n\n```\nvar secretValue = System.Text.Encoding.UTF8.GetBytes(\"mySecret\");\nvar publicKey = Convert.FromBase64String(\"2Sg8iYjAxxmI2LvUXpJjkYrMxURPc8r+dB7TJyvvcCU=\");\n\nvar sealedPublicKeyBox = Sodium.SealedPublicKeyBox.Create(secretValue, publicKey);\n\nConsole.WriteLine(Convert.ToBase64String(sealedPublicKeyBox));\n```\n\n#### Example encrypting a secret using Ruby\n\nEncrypt your secret using the [rbnacl](https://github.com/RubyCrypto/rbnacl) gem.\n\n```ruby\nrequire \"rbnacl\"\nrequire \"base64\"\n\nkey = Base64.decode64(\"+ZYvJDZMHUfBkJdyq5Zm9SKqeuBQ4sj+6sfjlH4CgG0=\")\npublic_key = RbNaCl::PublicKey.new(key)\n\nbox = RbNaCl::Boxes::Sealed.from_public_key(public_key)\nencrypted_secret = box.encrypt(\"my_secret\")\n\n# Print the base64 encoded secret\nputs Base64.strict_encode64(encrypted_secret)\n```", summary = "Create or update an organization secret", operationId = "actions/create-or-update-org-secret")
  @Path("/{org}/actions/secrets/{secret_name}")
  @PUT
  @Consumes("application/json")
  void actions_create_or_update_org_secret(@PathParam("org") String org, @PathParam("secret_name") String secretName,
      @NotNull InputStream data);

  /**
   * <p>
   * Deletes a secret in an organization using the secret name. You must
   * authenticate using an access token with the <code>admin:org</code> scope to
   * use this endpoint. GitHub Apps must have the <code>secrets</code>
   * organization permission to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Deletes a secret in an organization using the secret name. You must authenticate using an access token with the `admin:org` scope to use this endpoint. GitHub Apps must have the `secrets` organization permission to use this endpoint.", summary = "Delete an organization secret", operationId = "actions/delete-org-secret")
  @Path("/{org}/actions/secrets/{secret_name}")
  @DELETE
  void actions_delete_org_secret(@PathParam("org") String org, @PathParam("secret_name") String secretName);

  /**
   * <p>
   * Lists all secrets available in an organization without revealing their
   * encrypted values. You must authenticate using an access token with the
   * <code>admin:org</code> scope to use this endpoint. GitHub Apps must have the
   * <code>secrets</code> organization permission to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Lists all secrets available in an organization without revealing their encrypted values. You must authenticate using an access token with the `admin:org` scope to use this endpoint. GitHub Apps must have the `secrets` organization permission to use this endpoint.", summary = "List organization secrets", operationId = "actions/list-org-secrets")
  @Path("/{org}/actions/secrets")
  @GET
  @Produces("application/json")
  Response actions_list_org_secrets(@PathParam("org") String org,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * <strong>Warning:</strong> The self-hosted runners API for organizations is
   * currently in public beta and subject to change.
   * </p>
   * <p>
   * Returns a token that you can pass to the <code>config</code> script. The
   * token expires after one hour. You must authenticate using an access token
   * with the <code>admin:org</code> scope to use this endpoint.
   * </p>
   * <h4>Example using registration token</h4>
   * <p>
   * Configure your self-hosted runner, replacing <code>TOKEN</code> with the
   * registration token provided by this endpoint.
   * </p>
   *
   * <pre>
   * <code>./config.sh --url https://github.com/octo-org --token TOKEN
  </code>
   * </pre>
   *
   */
  @Operation(description = "**Warning:** The self-hosted runners API for organizations is currently in public beta and subject to change.\n\n\nReturns a token that you can pass to the `config` script. The token expires after one hour. You must authenticate\nusing an access token with the `admin:org` scope to use this endpoint.\n\n#### Example using registration token\n\nConfigure your self-hosted runner, replacing `TOKEN` with the registration token provided by this endpoint.\n\n```\n./config.sh --url https://github.com/octo-org --token TOKEN\n```", summary = "Create a registration token for an organization", operationId = "actions/create-registration-token-for-org")
  @Path("/{org}/actions/runners/registration-token")
  @POST
  @Produces("application/json")
  Response actions_create_registration_token_for_org(@PathParam("org") String org);

  /**
   * <p>
   * Adds a repository to an organization secret when the <code>visibility</code>
   * for repository access is set to <code>selected</code>. The visibility is set
   * when you <a href=
   * "https://developer.github.com/v3/actions/secrets/#create-or-update-an-organization-secret">Create
   * or update an organization secret</a>. You must authenticate using an access
   * token with the <code>admin:org</code> scope to use this endpoint. GitHub Apps
   * must have the <code>secrets</code> organization permission to use this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "Adds a repository to an organization secret when the `visibility` for repository access is set to `selected`. The visibility is set when you [Create or update an organization secret](https://developer.github.com/v3/actions/secrets/#create-or-update-an-organization-secret). You must authenticate using an access token with the `admin:org` scope to use this endpoint. GitHub Apps must have the `secrets` organization permission to use this endpoint.", summary = "Add selected repository to an organization secret", operationId = "actions/add-selected-repo-to-org-secret")
  @Path("/{org}/actions/secrets/{secret_name}/repositories/{repository_id}")
  @PUT
  void actions_add_selected_repo_to_org_secret(@PathParam("org") String org,
      @PathParam("secret_name") String secretName, @PathParam("repository_id") BigInteger repositoryId);

  /**
   * <p>
   * Removes a repository from an organization secret when the
   * <code>visibility</code> for repository access is set to
   * <code>selected</code>. The visibility is set when you <a href=
   * "https://developer.github.com/v3/actions/secrets/#create-or-update-an-organization-secret">Create
   * or update an organization secret</a>. You must authenticate using an access
   * token with the <code>admin:org</code> scope to use this endpoint. GitHub Apps
   * must have the <code>secrets</code> organization permission to use this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "Removes a repository from an organization secret when the `visibility` for repository access is set to `selected`. The visibility is set when you [Create or update an organization secret](https://developer.github.com/v3/actions/secrets/#create-or-update-an-organization-secret). You must authenticate using an access token with the `admin:org` scope to use this endpoint. GitHub Apps must have the `secrets` organization permission to use this endpoint.", summary = "Remove selected repository from an organization secret", operationId = "actions/remove-selected-repo-from-org-secret")
  @Path("/{org}/actions/secrets/{secret_name}/repositories/{repository_id}")
  @DELETE
  void actions_remove_selected_repo_from_org_secret(@PathParam("org") String org,
      @PathParam("secret_name") String secretName, @PathParam("repository_id") BigInteger repositoryId);

  /**
   * <p>
   * <strong>Warning:</strong> The self-hosted runners API for organizations is
   * currently in public beta and subject to change.
   * </p>
   * <p>
   * Lists binaries for the runner application that you can download and run. You
   * must authenticate using an access token with the <code>admin:org</code> scope
   * to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "**Warning:** The self-hosted runners API for organizations is currently in public beta and subject to change.\n\nLists binaries for the runner application that you can download and run. You must authenticate using an access token with the `admin:org` scope to use this endpoint.", summary = "List runner applications for an organization", operationId = "actions/list-runner-applications-for-org")
  @Path("/{org}/actions/runners/downloads")
  @GET
  @Produces("application/json")
  Response actions_list_runner_applications_for_org(@PathParam("org") String org);

  /**
   * <p>
   * <strong>Warning:</strong> The self-hosted runners API for organizations is
   * currently in public beta and subject to change.
   * </p>
   * <p>
   * Returns a token that you can pass to the <code>config</code> script to remove
   * a self-hosted runner from an organization. The token expires after one hour.
   * You must authenticate using an access token with the <code>admin:org</code>
   * scope to use this endpoint.
   * </p>
   * <h4>Example using remove token</h4>
   * <p>
   * To remove your self-hosted runner from an organization, replace
   * <code>TOKEN</code> with the remove token provided by this endpoint.
   * </p>
   *
   * <pre>
   * <code>./config.sh remove --token TOKEN
  </code>
   * </pre>
   *
   */
  @Operation(description = "**Warning:** The self-hosted runners API for organizations is currently in public beta and subject to change.\n\n\nReturns a token that you can pass to the `config` script to remove a self-hosted runner from an organization. The\ntoken expires after one hour. You must authenticate using an access token with the `admin:org` scope to use this\nendpoint.\n\n#### Example using remove token\n\nTo remove your self-hosted runner from an organization, replace `TOKEN` with the remove token provided by this\nendpoint.\n\n```\n./config.sh remove --token TOKEN\n```", summary = "Create a remove token for an organization", operationId = "actions/create-remove-token-for-org")
  @Path("/{org}/actions/runners/remove-token")
  @POST
  @Produces("application/json")
  Response actions_create_remove_token_for_org(@PathParam("org") String org);

  /**
   * <p>
   * Lists all repositories that have been selected when the
   * <code>visibility</code> for repository access to a secret is set to
   * <code>selected</code>. You must authenticate using an access token with the
   * <code>admin:org</code> scope to use this endpoint. GitHub Apps must have the
   * <code>secrets</code> organization permission to use this endpoint.
   * </p>
   *
   */
  @Operation(description = "Lists all repositories that have been selected when the `visibility` for repository access to a secret is set to `selected`. You must authenticate using an access token with the `admin:org` scope to use this endpoint. GitHub Apps must have the `secrets` organization permission to use this endpoint.", summary = "List selected repositories for an organization secret", operationId = "actions/list-selected-repos-for-org-secret")
  @Path("/{org}/actions/secrets/{secret_name}/repositories")
  @GET
  @Produces("application/json")
  Response actions_list_selected_repos_for_org_secret(@PathParam("org") String org,
      @PathParam("secret_name") String secretName);

  /**
   * <p>
   * Replaces all repositories for an organization secret when the
   * <code>visibility</code> for repository access is set to
   * <code>selected</code>. The visibility is set when you <a href=
   * "https://developer.github.com/v3/actions/secrets/#create-or-update-an-organization-secret">Create
   * or update an organization secret</a>. You must authenticate using an access
   * token with the <code>admin:org</code> scope to use this endpoint. GitHub Apps
   * must have the <code>secrets</code> organization permission to use this
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "Replaces all repositories for an organization secret when the `visibility` for repository access is set to `selected`. The visibility is set when you [Create or update an organization secret](https://developer.github.com/v3/actions/secrets/#create-or-update-an-organization-secret). You must authenticate using an access token with the `admin:org` scope to use this endpoint. GitHub Apps must have the `secrets` organization permission to use this endpoint.", summary = "Set selected repositories for an organization secret", operationId = "actions/set-selected-repos-for-org-secret")
  @Path("/{org}/actions/secrets/{secret_name}/repositories")
  @PUT
  @Consumes("application/json")
  void actions_set_selected_repos_for_org_secret(@PathParam("org") String org,
      @PathParam("secret_name") String secretName, @NotNull InputStream data);

  /**
   * <p>
   * Gets your public key, which you need to encrypt secrets. You need to encrypt
   * a secret before you can create or update secrets. You must authenticate using
   * an access token with the <code>admin:org</code> scope to use this endpoint.
   * GitHub Apps must have the <code>secrets</code> organization permission to use
   * this endpoint.
   * </p>
   *
   */
  @Operation(description = "Gets your public key, which you need to encrypt secrets. You need to encrypt a secret before you can create or update secrets. You must authenticate using an access token with the `admin:org` scope to use this endpoint. GitHub Apps must have the `secrets` organization permission to use this endpoint.", summary = "Get an organization public key", operationId = "actions/get-org-public-key")
  @Path("/{org}/actions/secrets/public-key")
  @GET
  @Produces("application/json")
  Response actions_get_org_public_key(@PathParam("org") String org);

  /**
   * <p>
   * Checks whether a team has <code>admin</code>, <code>push</code>,
   * <code>maintain</code>, <code>triage</code>, or <code>pull</code> permission
   * for a repository. Repositories inherited through a parent team will also be
   * checked.
   * </p>
   * <p>
   * You can also get information about the specified repository, including what
   * permissions the team grants on it, by passing the following custom
   * <a href="https://developer.github.com/v3/media/">media type</a> via the
   * <code>application/vnd.github.v3.repository+json</code> accept header.
   * </p>
   * <p>
   * If a team doesn't have permission for the repository, you will receive a
   * <code>404 Not Found</code> response status.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}/repos/{owner}/{repo}</code>.
   * </p>
   *
   */
  @Operation(description = "Checks whether a team has `admin`, `push`, `maintain`, `triage`, or `pull` permission for a repository. Repositories inherited through a parent team will also be checked.\n\nYou can also get information about the specified repository, including what permissions the team grants on it, by passing the following custom [media type](https://developer.github.com/v3/media/) via the `application/vnd.github.v3.repository+json` accept header.\n\nIf a team doesn't have permission for the repository, you will receive a `404 Not Found` response status.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}/repos/{owner}/{repo}`.", summary = "Check team permissions for a repository", operationId = "teams/check-permissions-for-repo-in-org")
  @Path("/{org}/teams/{team_slug}/repos/{owner}/{repo}")
  @GET
  @Produces("application/vnd.github.v3.repository+json")
  Response teams_check_permissions_for_repo_in_org(@PathParam("org") String org,
      @PathParam("team_slug") String teamSlug, @PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * To add a repository to a team or update the team's permission on a
   * repository, the authenticated user must have admin access to the repository,
   * and must be able to see the team. The repository must be owned by the
   * organization, or a direct fork of a repository owned by the organization. You
   * will get a <code>422 Unprocessable Entity</code> status if you attempt to add
   * a repository to a team that is not owned by the organization. Note that, if
   * you choose not to pass any parameters, you'll need to set
   * <code>Content-Length</code> to zero when calling out to this endpoint. For
   * more information, see
   * &quot;<a href="https://developer.github.com/v3/#http-verbs">HTTP
   * verbs</a>.&quot;
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>PUT /organizations/{org_id}/team/{team_id}/repos/{owner}/{repo}</code>.
   * </p>
   * <p>
   * For more information about the permission levels, see &quot;<a href=
   * "https://help.github.com/en/github/setting-up-and-managing-organizations-and-teams/repository-permission-levels-for-an-organization#permission-levels-for-repositories-owned-by-an-organization">Repository
   * permission levels for an organization</a>&quot;.
   * </p>
   *
   */
  @Operation(description = "To add a repository to a team or update the team's permission on a repository, the authenticated user must have admin access to the repository, and must be able to see the team. The repository must be owned by the organization, or a direct fork of a repository owned by the organization. You will get a `422 Unprocessable Entity` status if you attempt to add a repository to a team that is not owned by the organization. Note that, if you choose not to pass any parameters, you'll need to set `Content-Length` to zero when calling out to this endpoint. For more information, see \"[HTTP verbs](https://developer.github.com/v3/#http-verbs).\"\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `PUT /organizations/{org_id}/team/{team_id}/repos/{owner}/{repo}`.\n\nFor more information about the permission levels, see \"[Repository permission levels for an organization](https://help.github.com/en/github/setting-up-and-managing-organizations-and-teams/repository-permission-levels-for-an-organization#permission-levels-for-repositories-owned-by-an-organization)\".", summary = "Add or update team repository permissions", operationId = "teams/add-or-update-repo-permissions-in-org")
  @Path("/{org}/teams/{team_slug}/repos/{owner}/{repo}")
  @PUT
  @Consumes("application/json")
  void teams_add_or_update_repo_permissions_in_org(@PathParam("org") String org,
      @PathParam("team_slug") String teamSlug, @PathParam("owner") String owner, @PathParam("repo") String repo,
      @NotNull InputStream data);

  /**
   * <p>
   * If the authenticated user is an organization owner or a team maintainer, they
   * can remove any repositories from the team. To remove a repository from a team
   * as an organization member, the authenticated user must have admin access to
   * the repository and must be able to see the team. This does not delete the
   * repository, it just removes it from the team.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>DELETE /organizations/{org_id}/team/{team_id}/repos/{owner}/{repo}</code>.
   * </p>
   *
   */
  @Operation(description = "If the authenticated user is an organization owner or a team maintainer, they can remove any repositories from the team. To remove a repository from a team as an organization member, the authenticated user must have admin access to the repository and must be able to see the team. This does not delete the repository, it just removes it from the team.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `DELETE /organizations/{org_id}/team/{team_id}/repos/{owner}/{repo}`.", summary = "Remove a repository from a team", operationId = "teams/remove-repo-in-org")
  @Path("/{org}/teams/{team_slug}/repos/{owner}/{repo}")
  @DELETE
  void teams_remove_repo_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * Team members will include the members of child teams.
   * </p>
   * <p>
   * To list members in a team, the team must be visible to the authenticated
   * user.
   * </p>
   *
   */
  @Operation(description = "Team members will include the members of child teams.\n\nTo list members in a team, the team must be visible to the authenticated user.", summary = "List team members", operationId = "teams/list-members-in-org")
  @Path("/{org}/teams/{team_slug}/members")
  @GET
  @Produces("application/json")
  Response teams_list_members_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @QueryParam("role") @DefaultValue("all") String role,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * List all comments on a team discussion. OAuth access tokens require the
   * <code>read:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}/comments</code>.
   * </p>
   *
   */
  @Operation(description = "List all comments on a team discussion. OAuth access tokens require the `read:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}/comments`.", summary = "List discussion comments", operationId = "teams/list-discussion-comments-in-org")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}/comments")
  @GET
  @Produces("application/json")
  Response teams_list_discussion_comments_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("discussion_number") BigInteger discussionNumber,
      @QueryParam("direction") @DefaultValue("desc") String direction,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Creates a new comment on a team discussion. OAuth access tokens require the
   * <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>POST /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}/comments</code>.
   * </p>
   *
   */
  @Operation(description = "Creates a new comment on a team discussion. OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\nThis endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `POST /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}/comments`.", summary = "Create a discussion comment", operationId = "teams/create-discussion-comment-in-org")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}/comments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_create_discussion_comment_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("discussion_number") BigInteger discussionNumber, @NotNull InputStream data);

  /**
   * <p>
   * List all discussions on a team's page. OAuth access tokens require the
   * <code>read:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}/discussions</code>.
   * </p>
   *
   */
  @Operation(description = "List all discussions on a team's page. OAuth access tokens require the `read:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}/discussions`.", summary = "List discussions", operationId = "teams/list-discussions-in-org")
  @Path("/{org}/teams/{team_slug}/discussions")
  @GET
  @Produces("application/json")
  Response teams_list_discussions_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @QueryParam("direction") @DefaultValue("desc") String direction,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Creates a new discussion post on a team's page. OAuth access tokens require
   * the <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   * <p>
   * This endpoint triggers <a href=
   * "https://help.github.com/articles/about-notifications/">notifications</a>.
   * Creating content too quickly using this endpoint may result in abuse rate
   * limiting. See
   * &quot;<a href="https://developer.github.com/v3/#abuse-rate-limits">Abuse rate
   * limits</a>&quot; and &quot;<a href=
   * "https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits">Dealing
   * with abuse rate limits</a>&quot; for details.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>POST /organizations/{org_id}/team/{team_id}/discussions</code>.
   * </p>
   *
   */
  @Operation(description = "Creates a new discussion post on a team's page. OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\nThis endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `POST /organizations/{org_id}/team/{team_id}/discussions`.", summary = "Create a discussion", operationId = "teams/create-discussion-in-org")
  @Path("/{org}/teams/{team_slug}/discussions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_create_discussion_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @NotNull InputStream data);

  /**
   * <p>
   * Get a specific discussion on a team's page. OAuth access tokens require the
   * <code>read:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}</code>.
   * </p>
   *
   */
  @Operation(description = "Get a specific discussion on a team's page. OAuth access tokens require the `read:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}`.", summary = "Get a discussion", operationId = "teams/get-discussion-in-org")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}")
  @GET
  @Produces("application/json")
  Response teams_get_discussion_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("discussion_number") BigInteger discussionNumber);

  /**
   * <p>
   * Delete a discussion from a team's page. OAuth access tokens require the
   * <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>DELETE /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}</code>.
   * </p>
   *
   */
  @Operation(description = "Delete a discussion from a team's page. OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `DELETE /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}`.", summary = "Delete a discussion", operationId = "teams/delete-discussion-in-org")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}")
  @DELETE
  void teams_delete_discussion_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("discussion_number") BigInteger discussionNumber);

  /**
   * <p>
   * Edits the title and body text of a discussion post. Only the parameters you
   * provide are updated. OAuth access tokens require the
   * <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>PATCH /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}</code>.
   * </p>
   *
   */
  @Operation(description = "Edits the title and body text of a discussion post. Only the parameters you provide are updated. OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `PATCH /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}`.", summary = "Update a discussion", operationId = "teams/update-discussion-in-org")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_update_discussion_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("discussion_number") BigInteger discussionNumber, @NotNull InputStream data);

  /**
   * <p>
   * Lists the organization projects for a team.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}/projects</code>.
   * </p>
   *
   */
  @Operation(description = "Lists the organization projects for a team.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}/projects`.", summary = "List team projects", operationId = "teams/list-projects-in-org")
  @Path("/{org}/teams/{team_slug}/projects")
  @GET
  @Produces("application/json")
  Response teams_list_projects_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Checks whether a team has <code>read</code>, <code>write</code>, or
   * <code>admin</code> permissions for an organization project. The response
   * includes projects inherited from a parent team.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}/projects/{project_id}</code>.
   * </p>
   *
   */
  @Operation(description = "Checks whether a team has `read`, `write`, or `admin` permissions for an organization project. The response includes projects inherited from a parent team.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}/projects/{project_id}`.", summary = "Check team permissions for a project", operationId = "teams/check-permissions-for-project-in-org")
  @Path("/{org}/teams/{team_slug}/projects/{project_id}")
  @GET
  @Produces("application/json")
  Response teams_check_permissions_for_project_in_org(@PathParam("org") String org,
      @PathParam("team_slug") String teamSlug, @PathParam("project_id") BigInteger projectId);

  /**
   * <p>
   * Adds an organization project to a team. To add a project to a team or update
   * the team's permission on a project, the authenticated user must have
   * <code>admin</code> permissions for the project. The project and team must be
   * part of the same organization.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>PUT /organizations/{org_id}/team/{team_id}/projects/{project_id}</code>.
   * </p>
   *
   */
  @Operation(description = "Adds an organization project to a team. To add a project to a team or update the team's permission on a project, the authenticated user must have `admin` permissions for the project. The project and team must be part of the same organization.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `PUT /organizations/{org_id}/team/{team_id}/projects/{project_id}`.", summary = "Add or update team project permissions", operationId = "teams/add-or-update-project-permissions-in-org")
  @Path("/{org}/teams/{team_slug}/projects/{project_id}")
  @PUT
  @Consumes("application/json")
  void teams_add_or_update_project_permissions_in_org(@PathParam("org") String org,
      @PathParam("team_slug") String teamSlug, @PathParam("project_id") BigInteger projectId,
      @NotNull InputStream data);

  /**
   * <p>
   * Removes an organization project from a team. An organization owner or a team
   * maintainer can remove any project from the team. To remove a project from a
   * team as an organization member, the authenticated user must have
   * <code>read</code> access to both the team and project, or <code>admin</code>
   * access to the team or project. This endpoint removes the project from the
   * team, but does not delete the project.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>DELETE /organizations/{org_id}/team/{team_id}/projects/{project_id}</code>.
   * </p>
   *
   */
  @Operation(description = "Removes an organization project from a team. An organization owner or a team maintainer can remove any project from the team. To remove a project from a team as an organization member, the authenticated user must have `read` access to both the team and project, or `admin` access to the team or project. This endpoint removes the project from the team, but does not delete the project.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `DELETE /organizations/{org_id}/team/{team_id}/projects/{project_id}`.", summary = "Remove a project from a team", operationId = "teams/remove-project-in-org")
  @Path("/{org}/teams/{team_slug}/projects/{project_id}")
  @DELETE
  void teams_remove_project_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("project_id") BigInteger projectId);

  /**
   * <p>
   * Get a specific comment on a team discussion. OAuth access tokens require the
   * <code>read:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}/comments/{comment_number}</code>.
   * </p>
   *
   */
  @Operation(description = "Get a specific comment on a team discussion. OAuth access tokens require the `read:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}/comments/{comment_number}`.", summary = "Get a discussion comment", operationId = "teams/get-discussion-comment-in-org")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}/comments/{comment_number}")
  @GET
  @Produces("application/json")
  Response teams_get_discussion_comment_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("discussion_number") BigInteger discussionNumber,
      @PathParam("comment_number") BigInteger commentNumber);

  /**
   * <p>
   * Deletes a comment on a team discussion. OAuth access tokens require the
   * <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>DELETE /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}/comments/{comment_number}</code>.
   * </p>
   *
   */
  @Operation(description = "Deletes a comment on a team discussion. OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `DELETE /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}/comments/{comment_number}`.", summary = "Delete a discussion comment", operationId = "teams/delete-discussion-comment-in-org")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}/comments/{comment_number}")
  @DELETE
  void teams_delete_discussion_comment_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("discussion_number") BigInteger discussionNumber,
      @PathParam("comment_number") BigInteger commentNumber);

  /**
   * <p>
   * Edits the body text of a discussion comment. OAuth access tokens require the
   * <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>PATCH /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}/comments/{comment_number}</code>.
   * </p>
   *
   */
  @Operation(description = "Edits the body text of a discussion comment. OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `PATCH /organizations/{org_id}/team/{team_id}/discussions/{discussion_number}/comments/{comment_number}`.", summary = "Update a discussion comment", operationId = "teams/update-discussion-comment-in-org")
  @Path("/{org}/teams/{team_slug}/discussions/{discussion_number}/comments/{comment_number}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_update_discussion_comment_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("discussion_number") BigInteger discussionNumber,
      @PathParam("comment_number") BigInteger commentNumber, @NotNull InputStream data);

  /**
   * <p>
   * Lists a team's repositories visible to the authenticated user.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}/repos</code>.
   * </p>
   *
   */
  @Operation(description = "Lists a team's repositories visible to the authenticated user.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}/repos`.", summary = "List team repositories", operationId = "teams/list-repos-in-org")
  @Path("/{org}/teams/{team_slug}/repos")
  @GET
  @Produces("application/json")
  Response teams_list_repos_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Team synchronization is available for organizations using GitHub Enterprise
   * Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * List IdP groups available in an organization. You can limit your page results
   * using the <code>per_page</code> parameter. GitHub generates a url-encoded
   * <code>page</code> token using a cursor value for where the next page begins.
   * For more information on cursor pagination, see &quot;<a href=
   * "https://dev.to/jackmarchant/offset-and-cursor-pagination-explained-b89">Offset
   * and Cursor Pagination explained</a>.&quot;
   * </p>
   * <p>
   * The <code>per_page</code> parameter provides pagination for a list of IdP
   * groups the authenticated user can access in an organization. For example, if
   * the user <code>octocat</code> wants to see two groups per page in
   * <code>octo-org</code> via cURL, it would look like this:
   * </p>
   *
   */
  @Operation(description = "Team synchronization is available for organizations using GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nList IdP groups available in an organization. You can limit your page results using the `per_page` parameter. GitHub generates a url-encoded `page` token using a cursor value for where the next page begins. For more information on cursor pagination, see \"[Offset and Cursor Pagination explained](https://dev.to/jackmarchant/offset-and-cursor-pagination-explained-b89).\"\n\nThe `per_page` parameter provides pagination for a list of IdP groups the authenticated user can access in an organization. For example, if the user `octocat` wants to see two groups per page in `octo-org` via cURL, it would look like this:", summary = "List IdP groups for an organization", operationId = "teams/list-idp-groups-for-org")
  @Path("/{org}/team-sync/groups")
  @GET
  @Produces("application/json")
  Response teams_list_idp_groups_for_org(@PathParam("org") String org,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Team members will include the members of child teams.
   * </p>
   * <p>
   * To get a user's membership with a team, the team must be visible to the
   * authenticated user.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}/memberships/{username}</code>.
   * </p>
   * <p>
   * <strong>Note:</strong> The <code>role</code> for organization owners returns
   * as <code>maintainer</code>. For more information about
   * <code>maintainer</code> roles, see
   * <a href="https://developer.github.com/v3/teams/#create-a-team">Create a
   * team</a>.
   * </p>
   *
   */
  @Operation(description = "Team members will include the members of child teams.\n\nTo get a user's membership with a team, the team must be visible to the authenticated user.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}/memberships/{username}`.\n\n**Note:** The `role` for organization owners returns as `maintainer`. For more information about `maintainer` roles, see [Create a team](https://developer.github.com/v3/teams/#create-a-team).", summary = "Get team membership for a user", operationId = "teams/get-membership-for-user-in-org")
  @Path("/{org}/teams/{team_slug}/memberships/{username}")
  @GET
  @Produces("application/json")
  Response teams_get_membership_for_user_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("username") String username);

  /**
   * <p>
   * Team synchronization is available for organizations using GitHub Enterprise
   * Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Adds an organization member to a team. An authenticated organization owner or
   * team maintainer can add organization members to a team.
   * </p>
   * <p>
   * <strong>Note:</strong> When you have team synchronization set up for a team
   * with your organization's identity provider (IdP), you will see an error if
   * you attempt to use the API for making changes to the team's membership. If
   * you have access to manage group membership in your IdP, you can manage GitHub
   * team membership through your identity provider, which automatically adds and
   * removes team members in an organization. For more information, see
   * &quot;<a href=
   * "https://help.github.com/articles/synchronizing-teams-between-your-identity-provider-and-github/">Synchronizing
   * teams between your identity provider and GitHub</a>.&quot;
   * </p>
   * <p>
   * An organization owner can add someone who is not part of the team's
   * organization to a team. When an organization owner adds someone to a team who
   * is not an organization member, this endpoint will send an invitation to the
   * person via email. This newly-created membership will be in the
   * &quot;pending&quot; state until the person accepts the invitation, at which
   * point the membership will transition to the &quot;active&quot; state and the
   * user will be added as a member of the team.
   * </p>
   * <p>
   * If the user is already a member of the team, this endpoint will update the
   * role of the team member's role. To update the membership of a team member,
   * the authenticated user must be an organization owner or a team maintainer.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>PUT /organizations/{org_id}/team/{team_id}/memberships/{username}</code>.
   * </p>
   *
   */
  @Operation(description = "Team synchronization is available for organizations using GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nAdds an organization member to a team. An authenticated organization owner or team maintainer can add organization members to a team.\n\n**Note:** When you have team synchronization set up for a team with your organization's identity provider (IdP), you will see an error if you attempt to use the API for making changes to the team's membership. If you have access to manage group membership in your IdP, you can manage GitHub team membership through your identity provider, which automatically adds and removes team members in an organization. For more information, see \"[Synchronizing teams between your identity provider and GitHub](https://help.github.com/articles/synchronizing-teams-between-your-identity-provider-and-github/).\"\n\nAn organization owner can add someone who is not part of the team's organization to a team. When an organization owner adds someone to a team who is not an organization member, this endpoint will send an invitation to the person via email. This newly-created membership will be in the \"pending\" state until the person accepts the invitation, at which point the membership will transition to the \"active\" state and the user will be added as a member of the team.\n\nIf the user is already a member of the team, this endpoint will update the role of the team member's role. To update the membership of a team member, the authenticated user must be an organization owner or a team maintainer.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `PUT /organizations/{org_id}/team/{team_id}/memberships/{username}`.", summary = "Add or update team membership for a user", operationId = "teams/add-or-update-membership-for-user-in-org")
  @Path("/{org}/teams/{team_slug}/memberships/{username}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_add_or_update_membership_for_user_in_org(@PathParam("org") String org,
      @PathParam("team_slug") String teamSlug, @PathParam("username") String username, @NotNull InputStream data);

  /**
   * <p>
   * Team synchronization is available for organizations using GitHub Enterprise
   * Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * To remove a membership between a user and a team, the authenticated user must
   * have 'admin' permissions to the team or be an owner of the organization that
   * the team is associated with. Removing team membership does not delete the
   * user, it just removes their membership from the team.
   * </p>
   * <p>
   * <strong>Note:</strong> When you have team synchronization set up for a team
   * with your organization's identity provider (IdP), you will see an error if
   * you attempt to use the API for making changes to the team's membership. If
   * you have access to manage group membership in your IdP, you can manage GitHub
   * team membership through your identity provider, which automatically adds and
   * removes team members in an organization. For more information, see
   * &quot;<a href=
   * "https://help.github.com/articles/synchronizing-teams-between-your-identity-provider-and-github/">Synchronizing
   * teams between your identity provider and GitHub</a>.&quot;
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>DELETE /organizations/{org_id}/team/{team_id}/memberships/{username}</code>.
   * </p>
   *
   */
  @Operation(description = "Team synchronization is available for organizations using GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nTo remove a membership between a user and a team, the authenticated user must have 'admin' permissions to the team or be an owner of the organization that the team is associated with. Removing team membership does not delete the user, it just removes their membership from the team.\n\n**Note:** When you have team synchronization set up for a team with your organization's identity provider (IdP), you will see an error if you attempt to use the API for making changes to the team's membership. If you have access to manage group membership in your IdP, you can manage GitHub team membership through your identity provider, which automatically adds and removes team members in an organization. For more information, see \"[Synchronizing teams between your identity provider and GitHub](https://help.github.com/articles/synchronizing-teams-between-your-identity-provider-and-github/).\"\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `DELETE /organizations/{org_id}/team/{team_id}/memberships/{username}`.", summary = "Remove team membership for a user", operationId = "teams/remove-membership-for-user-in-org")
  @Path("/{org}/teams/{team_slug}/memberships/{username}")
  @DELETE
  void teams_remove_membership_for_user_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @PathParam("username") String username);

  /**
   * <p>
   * The return hash contains a <code>role</code> field which refers to the
   * Organization Invitation role and will be one of the following values:
   * <code>direct_member</code>, <code>admin</code>, <code>billing_manager</code>,
   * <code>hiring_manager</code>, or <code>reinstate</code>. If the invitee is not
   * a GitHub member, the <code>login</code> field in the return hash will be
   * <code>null</code>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}/invitations</code>.
   * </p>
   *
   */
  @Operation(description = "The return hash contains a `role` field which refers to the Organization Invitation role and will be one of the following values: `direct_member`, `admin`, `billing_manager`, `hiring_manager`, or `reinstate`. If the invitee is not a GitHub member, the `login` field in the return hash will be `null`.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}/invitations`.", summary = "List pending team invitations", operationId = "teams/list-pending-invitations-in-org")
  @Path("/{org}/teams/{team_slug}/invitations")
  @GET
  @Produces("application/json")
  Response teams_list_pending_invitations_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Gets a team using the team's <code>slug</code>. GitHub generates the
   * <code>slug</code> from the team <code>name</code>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}</code>.
   * </p>
   *
   */
  @Operation(description = "Gets a team using the team's `slug`. GitHub generates the `slug` from the team `name`.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}`.", summary = "Get a team by name", operationId = "teams/get-by-name")
  @Path("/{org}/teams/{team_slug}")
  @GET
  @Produces("application/json")
  Response teams_get_by_name(@PathParam("org") String org, @PathParam("team_slug") String teamSlug);

  /**
   * <p>
   * To delete a team, the authenticated user must be an organization owner or
   * team maintainer.
   * </p>
   * <p>
   * If you are an organization owner, deleting a parent team will delete all of
   * its child teams as well.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>DELETE /organizations/{org_id}/team/{team_id}</code>.
   * </p>
   *
   */
  @Operation(description = "To delete a team, the authenticated user must be an organization owner or team maintainer.\n\nIf you are an organization owner, deleting a parent team will delete all of its child teams as well.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `DELETE /organizations/{org_id}/team/{team_id}`.", summary = "Delete a team", operationId = "teams/delete-in-org")
  @Path("/{org}/teams/{team_slug}")
  @DELETE
  void teams_delete_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug);

  /**
   * <p>
   * To edit a team, the authenticated user must either be an organization owner
   * or a team maintainer.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>PATCH /organizations/{org_id}/team/{team_id}</code>.
   * </p>
   *
   */
  @Operation(description = "To edit a team, the authenticated user must either be an organization owner or a team maintainer.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `PATCH /organizations/{org_id}/team/{team_id}`.", summary = "Update a team", operationId = "teams/update-in-org")
  @Path("/{org}/teams/{team_slug}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_update_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @NotNull InputStream data);

  /**
   * <p>
   * Lists all teams in an organization that are visible to the authenticated
   * user.
   * </p>
   *
   */
  @Operation(description = "Lists all teams in an organization that are visible to the authenticated user.", summary = "List teams", operationId = "teams/list")
  @Path("/{org}/teams")
  @GET
  @Produces("application/json")
  Response teams_list(@PathParam("org") String org, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * To create a team, the authenticated user must be a member or owner of
   * <code>{org}</code>. By default, organization members can create teams.
   * Organization owners can limit team creation to organization owners. For more
   * information, see &quot;<a href=
   * "https://help.github.com/en/articles/setting-team-creation-permissions-in-your-organization">Setting
   * team creation permissions</a>.&quot;
   * </p>
   * <p>
   * When you create a new team, you automatically become a team maintainer
   * without explicitly adding yourself to the optional array of
   * <code>maintainers</code>. For more information, see &quot;<a href=
   * "https://help.github.com/en/github/setting-up-and-managing-organizations-and-teams/about-teams">About
   * teams</a>&quot;.
   * </p>
   *
   */
  @Operation(description = "To create a team, the authenticated user must be a member or owner of `{org}`. By default, organization members can create teams. Organization owners can limit team creation to organization owners. For more information, see \"[Setting team creation permissions](https://help.github.com/en/articles/setting-team-creation-permissions-in-your-organization).\"\n\nWhen you create a new team, you automatically become a team maintainer without explicitly adding yourself to the optional array of `maintainers`. For more information, see \"[About teams](https://help.github.com/en/github/setting-up-and-managing-organizations-and-teams/about-teams)\".", summary = "Create a team", operationId = "teams/create")
  @Path("/{org}/teams")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_create(@PathParam("org") String org, @NotNull InputStream data);

  /**
   * <p>
   * Lists the child teams of the team specified by <code>{team_slug}</code>.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}/teams</code>.
   * </p>
   *
   */
  @Operation(description = "Lists the child teams of the team specified by `{team_slug}`.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}/teams`.", summary = "List child teams", operationId = "teams/list-child-in-org")
  @Path("/{org}/teams/{team_slug}/teams")
  @GET
  @Produces("application/json")
  Response teams_list_child_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Team synchronization is available for organizations using GitHub Enterprise
   * Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * List IdP groups connected to a team on GitHub.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>GET /organizations/{org_id}/team/{team_id}/team-sync/group-mappings</code>.
   * </p>
   *
   */
  @Operation(description = "Team synchronization is available for organizations using GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nList IdP groups connected to a team on GitHub.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `GET /organizations/{org_id}/team/{team_id}/team-sync/group-mappings`.", summary = "List IdP groups for a team", operationId = "teams/list-idp-groups-in-org")
  @Path("/{org}/teams/{team_slug}/team-sync/group-mappings")
  @GET
  @Produces("application/json")
  Response teams_list_idp_groups_in_org(@PathParam("org") String org, @PathParam("team_slug") String teamSlug);

  /**
   * <p>
   * Team synchronization is available for organizations using GitHub Enterprise
   * Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * Creates, updates, or removes a connection between a team and an IdP group.
   * When adding groups to a team, you must include all new and existing groups to
   * avoid replacing existing groups with the new ones. Specifying an empty
   * <code>groups</code> array will remove all connections for a team.
   * </p>
   * <p>
   * <strong>Note:</strong> You can also specify a team by <code>org_id</code> and
   * <code>team_id</code> using the route
   * <code>PATCH /organizations/{org_id}/team/{team_id}/team-sync/group-mappings</code>.
   * </p>
   *
   */
  @Operation(description = "Team synchronization is available for organizations using GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nCreates, updates, or removes a connection between a team and an IdP group. When adding groups to a team, you must include all new and existing groups to avoid replacing existing groups with the new ones. Specifying an empty `groups` array will remove all connections for a team.\n\n**Note:** You can also specify a team by `org_id` and `team_id` using the route `PATCH /organizations/{org_id}/team/{team_id}/team-sync/group-mappings`.", summary = "Create or update IdP group connections", operationId = "teams/create-or-update-idp-group-connections-in-org")
  @Path("/{org}/teams/{team_slug}/team-sync/group-mappings")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_create_or_update_idp_group_connections_in_org(@PathParam("org") String org,
      @PathParam("team_slug") String teamSlug, @NotNull InputStream data);

  /**
   * <p>
   * List issues in an organization assigned to the authenticated user.
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
  @Operation(description = "List issues in an organization assigned to the authenticated user.\n\n**Note**: GitHub's REST API v3 considers every pull request an issue, but not every issue is a pull request. For this\nreason, \"Issues\" endpoints may return both issues and pull requests in the response. You can identify pull requests by\nthe `pull_request` key. Be aware that the `id` of a pull request returned from \"Issues\" endpoints will be an _issue id_. To find out the pull\nrequest id, use the \"[List pull requests](https://developer.github.com/v3/pulls/#list-pull-requests)\" endpoint.", summary = "List organization issues assigned to the authenticated user", operationId = "issues/list-for-org")
  @Path("/{org}/issues")
  @GET
  @Produces("application/json")
  Response issues_list_for_org(@PathParam("org") String org,
      @QueryParam("filter") @DefaultValue("assigned") String filter,
      @QueryParam("state") @DefaultValue("open") String state, @QueryParam("labels") String labels,
      @QueryParam("sort") @DefaultValue("created") String sort,
      @QueryParam("direction") @DefaultValue("desc") String direction, @QueryParam("since") String since,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Enables an authenticated GitHub App to find the organization's installation
   * information.
   * </p>
   * <p>
   * You must use a <a href=
   * "https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app">JWT</a>
   * to access this endpoint.
   * </p>
   *
   */
  @Operation(description = "Enables an authenticated GitHub App to find the organization's installation information.\n\nYou must use a [JWT](https://developer.github.com/apps/building-github-apps/authenticating-with-github-apps/#authenticating-as-a-github-app) to access this endpoint.", summary = "Get an organization installation for the authenticated app", operationId = "apps/get-org-installation")
  @Path("/{org}/installation")
  @GET
  @Produces("application/json")
  Response apps_get_org_installation(@PathParam("org") String org);

  /**
   * <p>
   * <strong>Warning:</strong> The Billing API is currently in public beta and
   * subject to change.
   * </p>
   * <p>
   * Gets the free and paid storage usued for GitHub Packages in gigabytes.
   * </p>
   * <p>
   * Paid minutes only apply to packages stored for private repositories. For more
   * information, see &quot;<a href=
   * "https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-packages">Managing
   * billing for GitHub Packages</a>.&quot;
   * </p>
   * <p>
   * Access tokens must have the <code>read:org</code> scope.
   * </p>
   *
   */
  @Operation(description = "**Warning:** The Billing API is currently in public beta and subject to change.\n\nGets the free and paid storage usued for GitHub Packages in gigabytes.\n\nPaid minutes only apply to packages stored for private repositories. For more information, see \"[Managing billing for GitHub Packages](https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-packages).\"\n\nAccess tokens must have the `read:org` scope.", summary = "Get GitHub Packages billing for an organization", operationId = "billing/get-github-packages-billing-org")
  @Path("/{org}/settings/billing/packages")
  @GET
  @Produces("application/json")
  Response billing_get_github_packages_billing_org(@PathParam("org") String org);

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
   * Access tokens must have the <code>read:org</code> scope.
   * </p>
   *
   */
  @Operation(description = "**Warning:** The Billing API is currently in public beta and subject to change.\n\nGets the estimated paid and estimated total storage used for GitHub Actions and Github Packages.\n\nPaid minutes only apply to packages stored for private repositories. For more information, see \"[Managing billing for GitHub Packages](https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-packages).\"\n\nAccess tokens must have the `read:org` scope.", summary = "Get shared storage billing for an organization", operationId = "billing/get-shared-storage-billing-org")
  @Path("/{org}/settings/billing/shared-storage")
  @GET
  @Produces("application/json")
  Response billing_get_shared_storage_billing_org(@PathParam("org") String org);

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
   * Access tokens must have the <code>read:org</code> scope.
   * </p>
   *
   */
  @Operation(description = "**Warning:** The Billing API is currently in public beta and subject to change.\n\nGets the summary of the free and paid GitHub Actions minutes used.\n\nPaid minutes only apply to workflows in private repositories that use GitHub-hosted runners. Minutes used is listed for each GitHub-hosted runner operating system. Any job re-runs are also included in the usage. The usage does not include the multiplier for macOS and Windows runners and is not rounded up to the nearest whole minute. For more information, see \"[Managing billing for GitHub Actions](https://help.github.com/github/setting-up-and-managing-billing-and-payments-on-github/managing-billing-for-github-actions)\".\n\nAccess tokens must have the `read:org` scope.", summary = "Get GitHub Actions billing for an organization", operationId = "billing/get-github-actions-billing-org")
  @Path("/{org}/settings/billing/actions")
  @GET
  @Produces("application/json")
  Response billing_get_github_actions_billing_org(@PathParam("org") String org);
}
