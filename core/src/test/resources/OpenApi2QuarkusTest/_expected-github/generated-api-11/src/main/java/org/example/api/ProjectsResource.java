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
@Path("/projects")
public interface ProjectsResource {
  /**
   *
   */
  @Operation(description = "", summary = "Move a project column", operationId = "projects/move-column")
  @Path("/columns/{column_id}/moves")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response projects_move_column(@PathParam("column_id") BigInteger columnId, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Get a project card", operationId = "projects/get-card")
  @Path("/columns/cards/{card_id}")
  @GET
  @Produces("application/json")
  Response projects_get_card(@PathParam("card_id") BigInteger cardId);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a project card", operationId = "projects/delete-card")
  @Path("/columns/cards/{card_id}")
  @DELETE
  void projects_delete_card(@PathParam("card_id") BigInteger cardId);

  /**
   *
   */
  @Operation(description = "", summary = "Update an existing project card", operationId = "projects/update-card")
  @Path("/columns/cards/{card_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response projects_update_card(@PathParam("card_id") BigInteger cardId, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Get a project column", operationId = "projects/get-column")
  @Path("/columns/{column_id}")
  @GET
  @Produces("application/json")
  Response projects_get_column(@PathParam("column_id") BigInteger columnId);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a project column", operationId = "projects/delete-column")
  @Path("/columns/{column_id}")
  @DELETE
  void projects_delete_column(@PathParam("column_id") BigInteger columnId);

  /**
   *
   */
  @Operation(description = "", summary = "Update an existing project column", operationId = "projects/update-column")
  @Path("/columns/{column_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response projects_update_column(@PathParam("column_id") BigInteger columnId, @NotNull InputStream data);

  /**
   * <p>
   * Gets a project by its <code>id</code>. Returns a <code>404 Not Found</code>
   * status if projects are disabled. If you do not have sufficient privileges to
   * perform this action, a <code>401 Unauthorized</code> or <code>410 Gone</code>
   * status is returned.
   * </p>
   *
   */
  @Operation(description = "Gets a project by its `id`. Returns a `404 Not Found` status if projects are disabled. If you do not have sufficient privileges to perform this action, a `401 Unauthorized` or `410 Gone` status is returned.", summary = "Get a project", operationId = "projects/get")
  @Path("/{project_id}")
  @GET
  @Produces("application/json")
  Response projects_get(@PathParam("project_id") BigInteger projectId);

  /**
   * <p>
   * Deletes a project board. Returns a <code>404 Not Found</code> status if
   * projects are disabled.
   * </p>
   *
   */
  @Operation(description = "Deletes a project board. Returns a `404 Not Found` status if projects are disabled.", summary = "Delete a project", operationId = "projects/delete")
  @Path("/{project_id}")
  @DELETE
  void projects_delete(@PathParam("project_id") BigInteger projectId);

  /**
   * <p>
   * Updates a project board's information. Returns a <code>404 Not Found</code>
   * status if projects are disabled. If you do not have sufficient privileges to
   * perform this action, a <code>401 Unauthorized</code> or <code>410 Gone</code>
   * status is returned.
   * </p>
   *
   */
  @Operation(description = "Updates a project board's information. Returns a `404 Not Found` status if projects are disabled. If you do not have sufficient privileges to perform this action, a `401 Unauthorized` or `410 Gone` status is returned.", summary = "Update a project", operationId = "projects/update")
  @Path("/{project_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response projects_update(@PathParam("project_id") BigInteger projectId, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "List project columns", operationId = "projects/list-columns")
  @Path("/{project_id}/columns")
  @GET
  @Produces("application/json")
  Response projects_list_columns(@PathParam("project_id") BigInteger projectId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Create a project column", operationId = "projects/create-column")
  @Path("/{project_id}/columns")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response projects_create_column(@PathParam("project_id") BigInteger projectId, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "List project cards", operationId = "projects/list-cards")
  @Path("/columns/{column_id}/cards")
  @GET
  @Produces("application/json")
  Response projects_list_cards(@PathParam("column_id") BigInteger columnId,
      @QueryParam("archived_state") @DefaultValue("not_archived") String archivedState,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * <strong>Note</strong>: GitHub's REST API v3 considers every pull request an
   * issue, but not every issue is a pull request. For this reason,
   * &quot;Issues&quot; endpoints may return both issues and pull requests in the
   * response. You can identify pull requests by the <code>pull_request</code>
   * key.
   * </p>
   * <p>
   * Be aware that the <code>id</code> of a pull request returned from
   * &quot;Issues&quot; endpoints will be an <em>issue id</em>. To find out the
   * pull request id, use the &quot;<a href=
   * "https://developer.github.com/v3/pulls/#list-pull-requests">List pull
   * requests</a>&quot; endpoint.
   * </p>
   *
   */
  @Operation(description = "**Note**: GitHub's REST API v3 considers every pull request an issue, but not every issue is a pull request. For this reason, \"Issues\" endpoints may return both issues and pull requests in the response. You can identify pull requests by the `pull_request` key.\n\nBe aware that the `id` of a pull request returned from \"Issues\" endpoints will be an _issue id_. To find out the pull request id, use the \"[List pull requests](https://developer.github.com/v3/pulls/#list-pull-requests)\" endpoint.", summary = "Create a project card", operationId = "projects/create-card")
  @Path("/columns/{column_id}/cards")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response projects_create_card(@PathParam("column_id") BigInteger columnId, @NotNull InputStream data);

  /**
   * <p>
   * Adds a collaborator to an organization project and sets their permission
   * level. You must be an organization owner or a project <code>admin</code> to
   * add a collaborator.
   * </p>
   *
   */
  @Operation(description = "Adds a collaborator to an organization project and sets their permission level. You must be an organization owner or a project `admin` to add a collaborator.", summary = "Add project collaborator", operationId = "projects/add-collaborator")
  @Path("/{project_id}/collaborators/{username}")
  @PUT
  @Consumes("application/json")
  void projects_add_collaborator(@PathParam("project_id") BigInteger projectId, @PathParam("username") String username,
      @NotNull InputStream data);

  /**
   * <p>
   * Removes a collaborator from an organization project. You must be an
   * organization owner or a project <code>admin</code> to remove a collaborator.
   * </p>
   *
   */
  @Operation(description = "Removes a collaborator from an organization project. You must be an organization owner or a project `admin` to remove a collaborator.", summary = "Remove user as a collaborator", operationId = "projects/remove-collaborator")
  @Path("/{project_id}/collaborators/{username}")
  @DELETE
  void projects_remove_collaborator(@PathParam("project_id") BigInteger projectId,
      @PathParam("username") String username);

  /**
   * <p>
   * Returns the collaborator's permission level for an organization project.
   * Possible values for the <code>permission</code> key: <code>admin</code>,
   * <code>write</code>, <code>read</code>, <code>none</code>. You must be an
   * organization owner or a project <code>admin</code> to review a user's
   * permission level.
   * </p>
   *
   */
  @Operation(description = "Returns the collaborator's permission level for an organization project. Possible values for the `permission` key: `admin`, `write`, `read`, `none`. You must be an organization owner or a project `admin` to review a user's permission level.", summary = "Get project permission for a user", operationId = "projects/get-permission-for-user")
  @Path("/{project_id}/collaborators/{username}/permission")
  @GET
  @Produces("application/json")
  Response projects_get_permission_for_user(@PathParam("project_id") BigInteger projectId,
      @PathParam("username") String username);

  /**
   *
   */
  @Operation(description = "", summary = "Move a project card", operationId = "projects/move-card")
  @Path("/columns/cards/{card_id}/moves")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response projects_move_card(@PathParam("card_id") BigInteger cardId, @NotNull InputStream data);

  /**
   * <p>
   * Lists the collaborators for an organization project. For a project, the list
   * of collaborators includes outside collaborators, organization members that
   * are direct collaborators, organization members with access through team
   * memberships, organization members with access through default organization
   * permissions, and organization owners. You must be an organization owner or a
   * project <code>admin</code> to list collaborators.
   * </p>
   *
   */
  @Operation(description = "Lists the collaborators for an organization project. For a project, the list of collaborators includes outside collaborators, organization members that are direct collaborators, organization members with access through team memberships, organization members with access through default organization permissions, and organization owners. You must be an organization owner or a project `admin` to list collaborators.", summary = "List project collaborators", operationId = "projects/list-collaborators")
  @Path("/{project_id}/collaborators")
  @GET
  @Produces("application/json")
  Response projects_list_collaborators(@PathParam("project_id") BigInteger projectId,
      @QueryParam("affiliation") @DefaultValue("all") String affiliation,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);
}
