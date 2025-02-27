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
@Path("/teams")
public interface TeamsResource {
  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/reactions/#list-reactions-for-a-team-discussion-comment"><code>List reactions for a team discussion comment</code></a>
   * endpoint.
   * </p>
   * <p>
   * List the reactions to a
   * <a href="https://developer.github.com/v3/teams/discussion_comments/">team
   * discussion comment</a>. OAuth access tokens require the
   * <code>read:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`List reactions for a team discussion comment`](https://developer.github.com/v3/reactions/#list-reactions-for-a-team-discussion-comment) endpoint.\n\nList the reactions to a [team discussion comment](https://developer.github.com/v3/teams/discussion_comments/). OAuth access tokens require the `read:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "List reactions for a team discussion comment (Legacy)", operationId = "reactions/list-for-team-discussion-comment-legacy")
  @Path("/{team_id}/discussions/{discussion_number}/comments/{comment_number}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_team_discussion_comment_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("discussion_number") BigInteger discussionNumber,
      @PathParam("comment_number") BigInteger commentNumber, @QueryParam("content") String content,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/reactions/#create-reaction-for-a-team-discussion-comment"><code>Create reaction for a team discussion comment</code></a>
   * endpoint.
   * </p>
   * <p>
   * Create a reaction to a
   * <a href="https://developer.github.com/v3/teams/discussion_comments/">team
   * discussion comment</a>. OAuth access tokens require the
   * <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * A response with a <code>Status: 200 OK</code> means that you already added
   * the reaction type to this team discussion comment.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`Create reaction for a team discussion comment`](https://developer.github.com/v3/reactions/#create-reaction-for-a-team-discussion-comment) endpoint.\n\nCreate a reaction to a [team discussion comment](https://developer.github.com/v3/teams/discussion_comments/). OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/). A response with a `Status: 200 OK` means that you already added the reaction type to this team discussion comment.", summary = "Create reaction for a team discussion comment (Legacy)", operationId = "reactions/create-for-team-discussion-comment-legacy")
  @Path("/{team_id}/discussions/{discussion_number}/comments/{comment_number}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_team_discussion_comment_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("discussion_number") BigInteger discussionNumber,
      @PathParam("comment_number") BigInteger commentNumber, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/reactions/#list-reactions-for-a-team-discussion"><code>List reactions for a team discussion</code></a>
   * endpoint.
   * </p>
   * <p>
   * List the reactions to a
   * <a href="https://developer.github.com/v3/teams/discussions/">team
   * discussion</a>. OAuth access tokens require the <code>read:discussion</code>
   * <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`List reactions for a team discussion`](https://developer.github.com/v3/reactions/#list-reactions-for-a-team-discussion) endpoint.\n\nList the reactions to a [team discussion](https://developer.github.com/v3/teams/discussions/). OAuth access tokens require the `read:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "List reactions for a team discussion (Legacy)", operationId = "reactions/list-for-team-discussion-legacy")
  @Path("/{team_id}/discussions/{discussion_number}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_team_discussion_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("discussion_number") BigInteger discussionNumber, @QueryParam("content") String content,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/reactions/#create-reaction-for-a-team-discussion"><code>Create reaction for a team discussion</code></a>
   * endpoint.
   * </p>
   * <p>
   * Create a reaction to a
   * <a href="https://developer.github.com/v3/teams/discussions/">team
   * discussion</a>. OAuth access tokens require the <code>write:discussion</code>
   * <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * A response with a <code>Status: 200 OK</code> means that you already added
   * the reaction type to this team discussion.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`Create reaction for a team discussion`](https://developer.github.com/v3/reactions/#create-reaction-for-a-team-discussion) endpoint.\n\nCreate a reaction to a [team discussion](https://developer.github.com/v3/teams/discussions/). OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/). A response with a `Status: 200 OK` means that you already added the reaction type to this team discussion.", summary = "Create reaction for a team discussion (Legacy)", operationId = "reactions/create-for-team-discussion-legacy")
  @Path("/{team_id}/discussions/{discussion_number}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_team_discussion_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("discussion_number") BigInteger discussionNumber, @NotNull InputStream data);

  /**
   * <p>
   * The &quot;Get team member&quot; endpoint (described below) is deprecated.
   * </p>
   * <p>
   * We recommend using the <a href=
   * "https://developer.github.com/v3/teams/members/#get-team-membership-for-a-user">Get
   * team membership for a user</a> endpoint instead. It allows you to get both
   * active and pending memberships.
   * </p>
   * <p>
   * To list members in a team, the team must be visible to the authenticated
   * user.
   * </p>
   *
   */
  @Operation(description = "The \"Get team member\" endpoint (described below) is deprecated.\n\nWe recommend using the [Get team membership for a user](https://developer.github.com/v3/teams/members/#get-team-membership-for-a-user) endpoint instead. It allows you to get both active and pending memberships.\n\nTo list members in a team, the team must be visible to the authenticated user.", summary = "Get team member (Legacy)", operationId = "teams/get-member-legacy")
  @Path("/{team_id}/members/{username}")
  @GET
  void teams_get_member_legacy(@PathParam("team_id") BigInteger teamId, @PathParam("username") String username);

  /**
   * <p>
   * The &quot;Add team member&quot; endpoint (described below) is deprecated.
   * </p>
   * <p>
   * We recommend using the <a href=
   * "https://developer.github.com/v3/teams/members/#add-or-update-team-membership-for-a-user">Add
   * or update team membership for a user</a> endpoint instead. It allows you to
   * invite new organization members to your teams.
   * </p>
   * <p>
   * Team synchronization is available for organizations using GitHub Enterprise
   * Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * To add someone to a team, the authenticated user must be an organization
   * owner or a team maintainer in the team they're changing. The person being
   * added to the team must be a member of the team's organization.
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
   * Note that you'll need to set <code>Content-Length</code> to zero when calling
   * out to this endpoint. For more information, see
   * &quot;<a href="https://developer.github.com/v3/#http-verbs">HTTP
   * verbs</a>.&quot;
   * </p>
   *
   */
  @Operation(description = "The \"Add team member\" endpoint (described below) is deprecated.\n\nWe recommend using the [Add or update team membership for a user](https://developer.github.com/v3/teams/members/#add-or-update-team-membership-for-a-user) endpoint instead. It allows you to invite new organization members to your teams.\n\nTeam synchronization is available for organizations using GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nTo add someone to a team, the authenticated user must be an organization owner or a team maintainer in the team they're changing. The person being added to the team must be a member of the team's organization.\n\n**Note:** When you have team synchronization set up for a team with your organization's identity provider (IdP), you will see an error if you attempt to use the API for making changes to the team's membership. If you have access to manage group membership in your IdP, you can manage GitHub team membership through your identity provider, which automatically adds and removes team members in an organization. For more information, see \"[Synchronizing teams between your identity provider and GitHub](https://help.github.com/articles/synchronizing-teams-between-your-identity-provider-and-github/).\"\n\nNote that you'll need to set `Content-Length` to zero when calling out to this endpoint. For more information, see \"[HTTP verbs](https://developer.github.com/v3/#http-verbs).\"", summary = "Add team member (Legacy)", operationId = "teams/add-member-legacy")
  @Path("/{team_id}/members/{username}")
  @PUT
  void teams_add_member_legacy(@PathParam("team_id") BigInteger teamId, @PathParam("username") String username);

  /**
   * <p>
   * The &quot;Remove team member&quot; endpoint (described below) is deprecated.
   * </p>
   * <p>
   * We recommend using the <a href=
   * "https://developer.github.com/v3/teams/members/#remove-team-membership-for-a-user">Remove
   * team membership for a user</a> endpoint instead. It allows you to remove both
   * active and pending memberships.
   * </p>
   * <p>
   * Team synchronization is available for organizations using GitHub Enterprise
   * Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * To remove a team member, the authenticated user must have 'admin' permissions
   * to the team or be an owner of the org that the team is associated with.
   * Removing a team member does not delete the user, it just removes them from
   * the team.
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
   *
   */
  @Operation(description = "The \"Remove team member\" endpoint (described below) is deprecated.\n\nWe recommend using the [Remove team membership for a user](https://developer.github.com/v3/teams/members/#remove-team-membership-for-a-user) endpoint instead. It allows you to remove both active and pending memberships.\n\nTeam synchronization is available for organizations using GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nTo remove a team member, the authenticated user must have 'admin' permissions to the team or be an owner of the org that the team is associated with. Removing a team member does not delete the user, it just removes them from the team.\n\n**Note:** When you have team synchronization set up for a team with your organization's identity provider (IdP), you will see an error if you attempt to use the API for making changes to the team's membership. If you have access to manage group membership in your IdP, you can manage GitHub team membership through your identity provider, which automatically adds and removes team members in an organization. For more information, see \"[Synchronizing teams between your identity provider and GitHub](https://help.github.com/articles/synchronizing-teams-between-your-identity-provider-and-github/).\"", summary = "Remove team member (Legacy)", operationId = "teams/remove-member-legacy")
  @Path("/{team_id}/members/{username}")
  @DELETE
  void teams_remove_member_legacy(@PathParam("team_id") BigInteger teamId, @PathParam("username") String username);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/discussion_comments/#get-a-discussion-comment">Get
   * a discussion comment</a> endpoint.
   * </p>
   * <p>
   * Get a specific comment on a team discussion. OAuth access tokens require the
   * <code>read:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Get a discussion comment](https://developer.github.com/v3/teams/discussion_comments/#get-a-discussion-comment) endpoint.\n\nGet a specific comment on a team discussion. OAuth access tokens require the `read:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Get a discussion comment (Legacy)", operationId = "teams/get-discussion-comment-legacy")
  @Path("/{team_id}/discussions/{discussion_number}/comments/{comment_number}")
  @GET
  @Produces("application/json")
  Response teams_get_discussion_comment_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("discussion_number") BigInteger discussionNumber,
      @PathParam("comment_number") BigInteger commentNumber);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/discussion_comments/#delete-a-discussion-comment">Delete
   * a discussion comment</a> endpoint.
   * </p>
   * <p>
   * Deletes a comment on a team discussion. OAuth access tokens require the
   * <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Delete a discussion comment](https://developer.github.com/v3/teams/discussion_comments/#delete-a-discussion-comment) endpoint.\n\nDeletes a comment on a team discussion. OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Delete a discussion comment (Legacy)", operationId = "teams/delete-discussion-comment-legacy")
  @Path("/{team_id}/discussions/{discussion_number}/comments/{comment_number}")
  @DELETE
  void teams_delete_discussion_comment_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("discussion_number") BigInteger discussionNumber,
      @PathParam("comment_number") BigInteger commentNumber);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/discussion_comments/#update-a-discussion-comment">Update
   * a discussion comment</a> endpoint.
   * </p>
   * <p>
   * Edits the body text of a discussion comment. OAuth access tokens require the
   * <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Update a discussion comment](https://developer.github.com/v3/teams/discussion_comments/#update-a-discussion-comment) endpoint.\n\nEdits the body text of a discussion comment. OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Update a discussion comment (Legacy)", operationId = "teams/update-discussion-comment-legacy")
  @Path("/{team_id}/discussions/{discussion_number}/comments/{comment_number}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_update_discussion_comment_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("discussion_number") BigInteger discussionNumber,
      @PathParam("comment_number") BigInteger commentNumber, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Note</strong>: Repositories inherited through a parent team will also
   * be checked.
   * </p>
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/#check-team-permissions-for-a-repository">Check
   * team permissions for a repository</a> endpoint.
   * </p>
   * <p>
   * You can also get information about the specified repository, including what
   * permissions the team grants on it, by passing the following custom
   * <a href="https://developer.github.com/v3/media/">media type</a> via the
   * <code>Accept</code> header:
   * </p>
   *
   */
  @Operation(description = "**Note**: Repositories inherited through a parent team will also be checked.\n\n**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Check team permissions for a repository](https://developer.github.com/v3/teams/#check-team-permissions-for-a-repository) endpoint.\n\nYou can also get information about the specified repository, including what permissions the team grants on it, by passing the following custom [media type](https://developer.github.com/v3/media/) via the `Accept` header:", summary = "Check team permissions for a repository (Legacy)", operationId = "teams/check-permissions-for-repo-legacy")
  @Path("/{team_id}/repos/{owner}/{repo}")
  @GET
  @Produces("application/vnd.github.v3.repository+json")
  Response teams_check_permissions_for_repo_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("owner") String owner, @PathParam("repo") String repo);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/#add-or-update-team-repository-permissions">Add
   * or update team repository permissions</a> endpoint.
   * </p>
   * <p>
   * To add a repository to a team or update the team's permission on a
   * repository, the authenticated user must have admin access to the repository,
   * and must be able to see the team. The repository must be owned by the
   * organization, or a direct fork of a repository owned by the organization. You
   * will get a <code>422 Unprocessable Entity</code> status if you attempt to add
   * a repository to a team that is not owned by the organization.
   * </p>
   * <p>
   * Note that, if you choose not to pass any parameters, you'll need to set
   * <code>Content-Length</code> to zero when calling out to this endpoint. For
   * more information, see
   * &quot;<a href="https://developer.github.com/v3/#http-verbs">HTTP
   * verbs</a>.&quot;
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Add or update team repository permissions](https://developer.github.com/v3/teams/#add-or-update-team-repository-permissions) endpoint.\n\nTo add a repository to a team or update the team's permission on a repository, the authenticated user must have admin access to the repository, and must be able to see the team. The repository must be owned by the organization, or a direct fork of a repository owned by the organization. You will get a `422 Unprocessable Entity` status if you attempt to add a repository to a team that is not owned by the organization.\n\nNote that, if you choose not to pass any parameters, you'll need to set `Content-Length` to zero when calling out to this endpoint. For more information, see \"[HTTP verbs](https://developer.github.com/v3/#http-verbs).\"", summary = "Add or update team repository permissions (Legacy)", operationId = "teams/add-or-update-repo-permissions-legacy")
  @Path("/{team_id}/repos/{owner}/{repo}")
  @PUT
  @Consumes("application/json")
  void teams_add_or_update_repo_permissions_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("owner") String owner, @PathParam("repo") String repo, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/#remove-a-repository-from-a-team">Remove
   * a repository from a team</a> endpoint.
   * </p>
   * <p>
   * If the authenticated user is an organization owner or a team maintainer, they
   * can remove any repositories from the team. To remove a repository from a team
   * as an organization member, the authenticated user must have admin access to
   * the repository and must be able to see the team. NOTE: This does not delete
   * the repository, it just removes it from the team.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Remove a repository from a team](https://developer.github.com/v3/teams/#remove-a-repository-from-a-team) endpoint.\n\nIf the authenticated user is an organization owner or a team maintainer, they can remove any repositories from the team. To remove a repository from a team as an organization member, the authenticated user must have admin access to the repository and must be able to see the team. NOTE: This does not delete the repository, it just removes it from the team.", summary = "Remove a repository from a team (Legacy)", operationId = "teams/remove-repo-legacy")
  @Path("/{team_id}/repos/{owner}/{repo}")
  @DELETE
  void teams_remove_repo_legacy(@PathParam("team_id") BigInteger teamId, @PathParam("owner") String owner,
      @PathParam("repo") String repo);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/members/#get-team-membership-for-a-user">Get
   * team membership for a user</a> endpoint.
   * </p>
   * <p>
   * Team members will include the members of child teams.
   * </p>
   * <p>
   * To get a user's membership with a team, the team must be visible to the
   * authenticated user.
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
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Get team membership for a user](https://developer.github.com/v3/teams/members/#get-team-membership-for-a-user) endpoint.\n\nTeam members will include the members of child teams.\n\nTo get a user's membership with a team, the team must be visible to the authenticated user.\n\n**Note:** The `role` for organization owners returns as `maintainer`. For more information about `maintainer` roles, see [Create a team](https://developer.github.com/v3/teams/#create-a-team).", summary = "Get team membership for a user (Legacy)", operationId = "teams/get-membership-for-user-legacy")
  @Path("/{team_id}/memberships/{username}")
  @GET
  @Produces("application/json")
  Response teams_get_membership_for_user_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("username") String username);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/members/#add-or-update-team-membership-for-a-user">Add
   * or update team membership for a user</a> endpoint.
   * </p>
   * <p>
   * Team synchronization is available for organizations using GitHub Enterprise
   * Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * If the user is already a member of the team's organization, this endpoint
   * will add the user to the team. To add a membership between an organization
   * member and a team, the authenticated user must be an organization owner or a
   * team maintainer.
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
   * If the user is unaffiliated with the team's organization, this endpoint will
   * send an invitation to the user via email. This newly-created membership will
   * be in the &quot;pending&quot; state until the user accepts the invitation, at
   * which point the membership will transition to the &quot;active&quot; state
   * and the user will be added as a member of the team. To add a membership
   * between an unaffiliated user and a team, the authenticated user must be an
   * organization owner.
   * </p>
   * <p>
   * If the user is already a member of the team, this endpoint will update the
   * role of the team member's role. To update the membership of a team member,
   * the authenticated user must be an organization owner or a team maintainer.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Add or update team membership for a user](https://developer.github.com/v3/teams/members/#add-or-update-team-membership-for-a-user) endpoint.\n\nTeam synchronization is available for organizations using GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nIf the user is already a member of the team's organization, this endpoint will add the user to the team. To add a membership between an organization member and a team, the authenticated user must be an organization owner or a team maintainer.\n\n**Note:** When you have team synchronization set up for a team with your organization's identity provider (IdP), you will see an error if you attempt to use the API for making changes to the team's membership. If you have access to manage group membership in your IdP, you can manage GitHub team membership through your identity provider, which automatically adds and removes team members in an organization. For more information, see \"[Synchronizing teams between your identity provider and GitHub](https://help.github.com/articles/synchronizing-teams-between-your-identity-provider-and-github/).\"\n\nIf the user is unaffiliated with the team's organization, this endpoint will send an invitation to the user via email. This newly-created membership will be in the \"pending\" state until the user accepts the invitation, at which point the membership will transition to the \"active\" state and the user will be added as a member of the team. To add a membership between an unaffiliated user and a team, the authenticated user must be an organization owner.\n\nIf the user is already a member of the team, this endpoint will update the role of the team member's role. To update the membership of a team member, the authenticated user must be an organization owner or a team maintainer.", summary = "Add or update team membership for a user (Legacy)", operationId = "teams/add-or-update-membership-for-user-legacy")
  @Path("/{team_id}/memberships/{username}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_add_or_update_membership_for_user_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("username") String username, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/members/#remove-team-membership-for-a-user">Remove
   * team membership for a user</a> endpoint.
   * </p>
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
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Remove team membership for a user](https://developer.github.com/v3/teams/members/#remove-team-membership-for-a-user) endpoint.\n\nTeam synchronization is available for organizations using GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nTo remove a membership between a user and a team, the authenticated user must have 'admin' permissions to the team or be an owner of the organization that the team is associated with. Removing team membership does not delete the user, it just removes their membership from the team.\n\n**Note:** When you have team synchronization set up for a team with your organization's identity provider (IdP), you will see an error if you attempt to use the API for making changes to the team's membership. If you have access to manage group membership in your IdP, you can manage GitHub team membership through your identity provider, which automatically adds and removes team members in an organization. For more information, see \"[Synchronizing teams between your identity provider and GitHub](https://help.github.com/articles/synchronizing-teams-between-your-identity-provider-and-github/).\"", summary = "Remove team membership for a user (Legacy)", operationId = "teams/remove-membership-for-user-legacy")
  @Path("/{team_id}/memberships/{username}")
  @DELETE
  void teams_remove_membership_for_user_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("username") String username);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/discussions/#get-a-discussion">Get a
   * discussion</a> endpoint.
   * </p>
   * <p>
   * Get a specific discussion on a team's page. OAuth access tokens require the
   * <code>read:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Get a discussion](https://developer.github.com/v3/teams/discussions/#get-a-discussion) endpoint.\n\nGet a specific discussion on a team's page. OAuth access tokens require the `read:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Get a discussion (Legacy)", operationId = "teams/get-discussion-legacy")
  @Path("/{team_id}/discussions/{discussion_number}")
  @GET
  @Produces("application/json")
  Response teams_get_discussion_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("discussion_number") BigInteger discussionNumber);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/discussions/#delete-a-discussion"><code>Delete a discussion</code></a>
   * endpoint.
   * </p>
   * <p>
   * Delete a discussion from a team's page. OAuth access tokens require the
   * <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`Delete a discussion`](https://developer.github.com/v3/teams/discussions/#delete-a-discussion) endpoint.\n\nDelete a discussion from a team's page. OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Delete a discussion (Legacy)", operationId = "teams/delete-discussion-legacy")
  @Path("/{team_id}/discussions/{discussion_number}")
  @DELETE
  void teams_delete_discussion_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("discussion_number") BigInteger discussionNumber);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/discussions/#update-a-discussion">Update
   * a discussion</a> endpoint.
   * </p>
   * <p>
   * Edits the title and body text of a discussion post. Only the parameters you
   * provide are updated. OAuth access tokens require the
   * <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Update a discussion](https://developer.github.com/v3/teams/discussions/#update-a-discussion) endpoint.\n\nEdits the title and body text of a discussion post. Only the parameters you provide are updated. OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "Update a discussion (Legacy)", operationId = "teams/update-discussion-legacy")
  @Path("/{team_id}/discussions/{discussion_number}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_update_discussion_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("discussion_number") BigInteger discussionNumber, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the
   * <a href="https://developer.github.com/v3/teams/#get-a-team-by-name">Get a
   * team by name</a> endpoint.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the [Get a team by name](https://developer.github.com/v3/teams/#get-a-team-by-name) endpoint.", summary = "Get a team (Legacy)", operationId = "teams/get-legacy")
  @Path("/{team_id}")
  @GET
  @Produces("application/json")
  Response teams_get_legacy(@PathParam("team_id") BigInteger teamId);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new
   * <a href="https://developer.github.com/v3/teams/#delete-a-team">Delete a
   * team</a> endpoint.
   * </p>
   * <p>
   * To delete a team, the authenticated user must be an organization owner or
   * team maintainer.
   * </p>
   * <p>
   * If you are an organization owner, deleting a parent team will delete all of
   * its child teams as well.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Delete a team](https://developer.github.com/v3/teams/#delete-a-team) endpoint.\n\nTo delete a team, the authenticated user must be an organization owner or team maintainer.\n\nIf you are an organization owner, deleting a parent team will delete all of its child teams as well.", summary = "Delete a team (Legacy)", operationId = "teams/delete-legacy")
  @Path("/{team_id}")
  @DELETE
  void teams_delete_legacy(@PathParam("team_id") BigInteger teamId);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new
   * <a href="https://developer.github.com/v3/teams/#update-a-team">Update a
   * team</a> endpoint.
   * </p>
   * <p>
   * To edit a team, the authenticated user must either be an organization owner
   * or a team maintainer.
   * </p>
   * <p>
   * <strong>Note:</strong> With nested teams, the <code>privacy</code> for parent
   * teams cannot be <code>secret</code>.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Update a team](https://developer.github.com/v3/teams/#update-a-team) endpoint.\n\nTo edit a team, the authenticated user must either be an organization owner or a team maintainer.\n\n**Note:** With nested teams, the `privacy` for parent teams cannot be `secret`.", summary = "Update a team (Legacy)", operationId = "teams/update-legacy")
  @Path("/{team_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_update_legacy(@PathParam("team_id") BigInteger teamId, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/team_sync/#list-idp-groups-for-a-team"><code>List IdP groups for a team</code></a>
   * endpoint.
   * </p>
   * <p>
   * Team synchronization is available for organizations using GitHub Enterprise
   * Cloud. For more information, see <a href=
   * "https://help.github.com/github/getting-started-with-github/githubs-products">GitHub's
   * products</a> in the GitHub Help documentation.
   * </p>
   * <p>
   * List IdP groups connected to a team on GitHub.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`List IdP groups for a team`](https://developer.github.com/v3/teams/team_sync/#list-idp-groups-for-a-team) endpoint.\n\nTeam synchronization is available for organizations using GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nList IdP groups connected to a team on GitHub.", summary = "List IdP groups for a team (Legacy)", operationId = "teams/list-idp-groups-for-legacy")
  @Path("/{team_id}/team-sync/group-mappings")
  @GET
  @Produces("application/json")
  Response teams_list_idp_groups_for_legacy(@PathParam("team_id") BigInteger teamId);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/team_sync/#create-or-update-idp-group-connections"><code>Create or update IdP group connections</code></a>
   * endpoint.
   * </p>
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
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`Create or update IdP group connections`](https://developer.github.com/v3/teams/team_sync/#create-or-update-idp-group-connections) endpoint.\n\nTeam synchronization is available for organizations using GitHub Enterprise Cloud. For more information, see [GitHub's products](https://help.github.com/github/getting-started-with-github/githubs-products) in the GitHub Help documentation.\n\nCreates, updates, or removes a connection between a team and an IdP group. When adding groups to a team, you must include all new and existing groups to avoid replacing existing groups with the new ones. Specifying an empty `groups` array will remove all connections for a team.", summary = "Create or update IdP group connections (Legacy)", operationId = "teams/create-or-update-idp-group-connections-legacy")
  @Path("/{team_id}/team-sync/group-mappings")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_create_or_update_idp_group_connections_legacy(@PathParam("team_id") BigInteger teamId,
      @NotNull InputStream data);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/members/#list-pending-team-invitations"><code>List pending team invitations</code></a>
   * endpoint.
   * </p>
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
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`List pending team invitations`](https://developer.github.com/v3/teams/members/#list-pending-team-invitations) endpoint.\n\nThe return hash contains a `role` field which refers to the Organization Invitation role and will be one of the following values: `direct_member`, `admin`, `billing_manager`, `hiring_manager`, or `reinstate`. If the invitee is not a GitHub member, the `login` field in the return hash will be `null`.", summary = "List pending team invitations (Legacy)", operationId = "teams/list-pending-invitations-legacy")
  @Path("/{team_id}/invitations")
  @GET
  @Produces("application/json")
  Response teams_list_pending_invitations_legacy(@PathParam("team_id") BigInteger teamId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/discussion_comments/#list-discussion-comments">List
   * discussion comments</a> endpoint.
   * </p>
   * <p>
   * List all comments on a team discussion. OAuth access tokens require the
   * <code>read:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [List discussion comments](https://developer.github.com/v3/teams/discussion_comments/#list-discussion-comments) endpoint.\n\nList all comments on a team discussion. OAuth access tokens require the `read:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "List discussion comments (Legacy)", operationId = "teams/list-discussion-comments-legacy")
  @Path("/{team_id}/discussions/{discussion_number}/comments")
  @GET
  @Produces("application/json")
  Response teams_list_discussion_comments_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("discussion_number") BigInteger discussionNumber,
      @QueryParam("direction") @DefaultValue("desc") String direction,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/discussion_comments/#create-a-discussion-comment">Create
   * a discussion comment</a> endpoint.
   * </p>
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
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Create a discussion comment](https://developer.github.com/v3/teams/discussion_comments/#create-a-discussion-comment) endpoint.\n\nCreates a new comment on a team discussion. OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\nThis endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.", summary = "Create a discussion comment (Legacy)", operationId = "teams/create-discussion-comment-legacy")
  @Path("/{team_id}/discussions/{discussion_number}/comments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_create_discussion_comment_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("discussion_number") BigInteger discussionNumber, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new
   * <a href="https://developer.github.com/v3/teams/#list-team-repositories">List
   * team repositories</a> endpoint.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [List team repositories](https://developer.github.com/v3/teams/#list-team-repositories) endpoint.", summary = "List team repositories (Legacy)", operationId = "teams/list-repos-legacy")
  @Path("/{team_id}/repos")
  @GET
  @Produces("application/json")
  Response teams_list_repos_legacy(@PathParam("team_id") BigInteger teamId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/#list-child-teams"><code>List child teams</code></a>
   * endpoint.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`List child teams`](https://developer.github.com/v3/teams/#list-child-teams) endpoint.", summary = "List child teams (Legacy)", operationId = "teams/list-child-legacy")
  @Path("/{team_id}/teams")
  @GET
  @Produces("application/json")
  Response teams_list_child_legacy(@PathParam("team_id") BigInteger teamId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/#check-team-permissions-for-a-project">Check
   * team permissions for a project</a> endpoint.
   * </p>
   * <p>
   * Checks whether a team has <code>read</code>, <code>write</code>, or
   * <code>admin</code> permissions for an organization project. The response
   * includes projects inherited from a parent team.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Check team permissions for a project](https://developer.github.com/v3/teams/#check-team-permissions-for-a-project) endpoint.\n\nChecks whether a team has `read`, `write`, or `admin` permissions for an organization project. The response includes projects inherited from a parent team.", summary = "Check team permissions for a project (Legacy)", operationId = "teams/check-permissions-for-project-legacy")
  @Path("/{team_id}/projects/{project_id}")
  @GET
  @Produces("application/json")
  Response teams_check_permissions_for_project_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("project_id") BigInteger projectId);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/#add-or-update-team-project-permissions">Add
   * or update team project permissions</a> endpoint.
   * </p>
   * <p>
   * Adds an organization project to a team. To add a project to a team or update
   * the team's permission on a project, the authenticated user must have
   * <code>admin</code> permissions for the project. The project and team must be
   * part of the same organization.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Add or update team project permissions](https://developer.github.com/v3/teams/#add-or-update-team-project-permissions) endpoint.\n\nAdds an organization project to a team. To add a project to a team or update the team's permission on a project, the authenticated user must have `admin` permissions for the project. The project and team must be part of the same organization.", summary = "Add or update team project permissions (Legacy)", operationId = "teams/add-or-update-project-permissions-legacy")
  @Path("/{team_id}/projects/{project_id}")
  @PUT
  @Consumes("application/json")
  void teams_add_or_update_project_permissions_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("project_id") BigInteger projectId, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/#remove-a-project-from-a-team">Remove
   * a project from a team</a> endpoint.
   * </p>
   * <p>
   * Removes an organization project from a team. An organization owner or a team
   * maintainer can remove any project from the team. To remove a project from a
   * team as an organization member, the authenticated user must have
   * <code>read</code> access to both the team and project, or <code>admin</code>
   * access to the team or project. <strong>Note:</strong> This endpoint removes
   * the project from the team, but does not delete it.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [Remove a project from a team](https://developer.github.com/v3/teams/#remove-a-project-from-a-team) endpoint.\n\nRemoves an organization project from a team. An organization owner or a team maintainer can remove any project from the team. To remove a project from a team as an organization member, the authenticated user must have `read` access to both the team and project, or `admin` access to the team or project. **Note:** This endpoint removes the project from the team, but does not delete it.", summary = "Remove a project from a team (Legacy)", operationId = "teams/remove-project-legacy")
  @Path("/{team_id}/projects/{project_id}")
  @DELETE
  void teams_remove_project_legacy(@PathParam("team_id") BigInteger teamId,
      @PathParam("project_id") BigInteger projectId);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/#list-team-projects"><code>List team projects</code></a>
   * endpoint.
   * </p>
   * <p>
   * Lists the organization projects for a team.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`List team projects`](https://developer.github.com/v3/teams/#list-team-projects) endpoint.\n\nLists the organization projects for a team.", summary = "List team projects (Legacy)", operationId = "teams/list-projects-legacy")
  @Path("/{team_id}/projects")
  @GET
  @Produces("application/json")
  Response teams_list_projects_legacy(@PathParam("team_id") BigInteger teamId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/discussions/#list-discussions"><code>List discussions</code></a>
   * endpoint.
   * </p>
   * <p>
   * List all discussions on a team's page. OAuth access tokens require the
   * <code>read:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`List discussions`](https://developer.github.com/v3/teams/discussions/#list-discussions) endpoint.\n\nList all discussions on a team's page. OAuth access tokens require the `read:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).", summary = "List discussions (Legacy)", operationId = "teams/list-discussions-legacy")
  @Path("/{team_id}/discussions")
  @GET
  @Produces("application/json")
  Response teams_list_discussions_legacy(@PathParam("team_id") BigInteger teamId,
      @QueryParam("direction") @DefaultValue("desc") String direction,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/discussions/#create-a-discussion"><code>Create a discussion</code></a>
   * endpoint.
   * </p>
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
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`Create a discussion`](https://developer.github.com/v3/teams/discussions/#create-a-discussion) endpoint.\n\nCreates a new discussion post on a team's page. OAuth access tokens require the `write:discussion` [scope](https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/).\n\nThis endpoint triggers [notifications](https://help.github.com/articles/about-notifications/). Creating content too quickly using this endpoint may result in abuse rate limiting. See \"[Abuse rate limits](https://developer.github.com/v3/#abuse-rate-limits)\" and \"[Dealing with abuse rate limits](https://developer.github.com/v3/guides/best-practices-for-integrators/#dealing-with-abuse-rate-limits)\" for details.", summary = "Create a discussion (Legacy)", operationId = "teams/create-discussion-legacy")
  @Path("/{team_id}/discussions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_create_discussion_legacy(@PathParam("team_id") BigInteger teamId, @NotNull InputStream data);

  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Teams API. We recommend migrating your existing code
   * to use the new <a href=
   * "https://developer.github.com/v3/teams/members/#list-team-members"><code>List team members</code></a>
   * endpoint.
   * </p>
   * <p>
   * Team members will include the members of child teams.
   * </p>
   *
   */
  @Operation(description = "**Deprecation Notice:** This endpoint route is deprecated and will be removed from the Teams API. We recommend migrating your existing code to use the new [`List team members`](https://developer.github.com/v3/teams/members/#list-team-members) endpoint.\n\nTeam members will include the members of child teams.", summary = "List team members (Legacy)", operationId = "teams/list-members-legacy")
  @Path("/{team_id}/members")
  @GET
  @Produces("application/json")
  Response teams_list_members_legacy(@PathParam("team_id") BigInteger teamId,
      @QueryParam("role") @DefaultValue("all") String role,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);
}
