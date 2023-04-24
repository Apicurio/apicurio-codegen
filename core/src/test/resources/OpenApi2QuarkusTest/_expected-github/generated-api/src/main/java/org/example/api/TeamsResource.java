package org.example.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
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
  @Path("/{team_id}/discussions/{discussion_number}/comments/{comment_number}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_team_discussion_comment_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("discussion_number") Integer discussionNumber, @PathParam("comment_number") Integer commentNumber,
      @QueryParam("content") String content, @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

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
  @Path("/{team_id}/discussions/{discussion_number}/comments/{comment_number}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_team_discussion_comment_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("discussion_number") Integer discussionNumber, @PathParam("comment_number") Integer commentNumber,
      InputStream data);

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
  @Path("/{team_id}/discussions/{discussion_number}/reactions")
  @GET
  @Produces("application/json")
  Response reactions_list_for_team_discussion_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("discussion_number") Integer discussionNumber, @QueryParam("content") String content,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

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
  @Path("/{team_id}/discussions/{discussion_number}/reactions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response reactions_create_for_team_discussion_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("discussion_number") Integer discussionNumber, InputStream data);

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
  @Path("/{team_id}/members/{username}")
  @GET
  void teams_get_member_legacy(@PathParam("team_id") Integer teamId, @PathParam("username") String username);

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
  @Path("/{team_id}/members/{username}")
  @PUT
  void teams_add_member_legacy(@PathParam("team_id") Integer teamId, @PathParam("username") String username);

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
  @Path("/{team_id}/members/{username}")
  @DELETE
  void teams_remove_member_legacy(@PathParam("team_id") Integer teamId, @PathParam("username") String username);

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
  @Path("/{team_id}/discussions/{discussion_number}/comments/{comment_number}")
  @GET
  @Produces("application/json")
  Response teams_get_discussion_comment_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("discussion_number") Integer discussionNumber, @PathParam("comment_number") Integer commentNumber);

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
  @Path("/{team_id}/discussions/{discussion_number}/comments/{comment_number}")
  @DELETE
  void teams_delete_discussion_comment_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("discussion_number") Integer discussionNumber, @PathParam("comment_number") Integer commentNumber);

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
  @Path("/{team_id}/discussions/{discussion_number}/comments/{comment_number}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_update_discussion_comment_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("discussion_number") Integer discussionNumber, @PathParam("comment_number") Integer commentNumber,
      InputStream data);

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
  @Path("/{team_id}/repos/{owner}/{repo}")
  @GET
  @Produces("application/vnd.github.v3.repository+json")
  Response teams_check_permissions_for_repo_legacy(@PathParam("team_id") Integer teamId,
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
  @Path("/{team_id}/repos/{owner}/{repo}")
  @PUT
  @Consumes("application/json")
  void teams_add_or_update_repo_permissions_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("owner") String owner, @PathParam("repo") String repo, InputStream data);

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
  @Path("/{team_id}/repos/{owner}/{repo}")
  @DELETE
  void teams_remove_repo_legacy(@PathParam("team_id") Integer teamId, @PathParam("owner") String owner,
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
  @Path("/{team_id}/memberships/{username}")
  @GET
  @Produces("application/json")
  Response teams_get_membership_for_user_legacy(@PathParam("team_id") Integer teamId,
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
  @Path("/{team_id}/memberships/{username}")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_add_or_update_membership_for_user_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("username") String username, InputStream data);

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
  @Path("/{team_id}/memberships/{username}")
  @DELETE
  void teams_remove_membership_for_user_legacy(@PathParam("team_id") Integer teamId,
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
  @Path("/{team_id}/discussions/{discussion_number}")
  @GET
  @Produces("application/json")
  Response teams_get_discussion_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("discussion_number") Integer discussionNumber);

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
  @Path("/{team_id}/discussions/{discussion_number}")
  @DELETE
  void teams_delete_discussion_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("discussion_number") Integer discussionNumber);

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
  @Path("/{team_id}/discussions/{discussion_number}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_update_discussion_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("discussion_number") Integer discussionNumber, InputStream data);

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
  @Path("/{team_id}")
  @GET
  @Produces("application/json")
  Response teams_get_legacy(@PathParam("team_id") Integer teamId);

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
  @Path("/{team_id}")
  @DELETE
  void teams_delete_legacy(@PathParam("team_id") Integer teamId);

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
  @Path("/{team_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_update_legacy(@PathParam("team_id") Integer teamId, InputStream data);

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
  @Path("/{team_id}/team-sync/group-mappings")
  @GET
  @Produces("application/json")
  Response teams_list_idp_groups_for_legacy(@PathParam("team_id") Integer teamId);

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
  @Path("/{team_id}/team-sync/group-mappings")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_create_or_update_idp_group_connections_legacy(@PathParam("team_id") Integer teamId, InputStream data);

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
  @Path("/{team_id}/invitations")
  @GET
  @Produces("application/json")
  Response teams_list_pending_invitations_legacy(@PathParam("team_id") Integer teamId,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

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
  @Path("/{team_id}/discussions/{discussion_number}/comments")
  @GET
  @Produces("application/json")
  Response teams_list_discussion_comments_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("discussion_number") Integer discussionNumber, @QueryParam("direction") String direction,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);

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
  @Path("/{team_id}/discussions/{discussion_number}/comments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_create_discussion_comment_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("discussion_number") Integer discussionNumber, InputStream data);

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
  @Path("/{team_id}/repos")
  @GET
  @Produces("application/json")
  Response teams_list_repos_legacy(@PathParam("team_id") Integer teamId, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

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
  @Path("/{team_id}/teams")
  @GET
  @Produces("application/json")
  Response teams_list_child_legacy(@PathParam("team_id") Integer teamId, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

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
  @Path("/{team_id}/projects/{project_id}")
  @GET
  @Produces("application/json")
  Response teams_check_permissions_for_project_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("project_id") Integer projectId);

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
  @Path("/{team_id}/projects/{project_id}")
  @PUT
  @Consumes("application/json")
  void teams_add_or_update_project_permissions_legacy(@PathParam("team_id") Integer teamId,
      @PathParam("project_id") Integer projectId, InputStream data);

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
  @Path("/{team_id}/projects/{project_id}")
  @DELETE
  void teams_remove_project_legacy(@PathParam("team_id") Integer teamId, @PathParam("project_id") Integer projectId);

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
  @Path("/{team_id}/projects")
  @GET
  @Produces("application/json")
  Response teams_list_projects_legacy(@PathParam("team_id") Integer teamId, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

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
  @Path("/{team_id}/discussions")
  @GET
  @Produces("application/json")
  Response teams_list_discussions_legacy(@PathParam("team_id") Integer teamId,
      @QueryParam("direction") String direction, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

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
  @Path("/{team_id}/discussions")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response teams_create_discussion_legacy(@PathParam("team_id") Integer teamId, InputStream data);

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
  @Path("/{team_id}/members")
  @GET
  @Produces("application/json")
  Response teams_list_members_legacy(@PathParam("team_id") Integer teamId, @QueryParam("role") String role,
      @QueryParam("per_page") Integer perPage, @QueryParam("page") Integer page);
}
