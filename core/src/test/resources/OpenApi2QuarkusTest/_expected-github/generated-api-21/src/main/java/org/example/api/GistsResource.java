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
@Path("/gists")
public interface GistsResource {
  /**
   *
   */
  @Operation(description = "", summary = "Check if a gist is starred", operationId = "gists/check-is-starred")
  @Path("/{gist_id}/star")
  @GET
  void gists_check_is_starred(@PathParam("gist_id") String gistId);

  /**
   * <p>
   * Note that you'll need to set <code>Content-Length</code> to zero when calling
   * out to this endpoint. For more information, see
   * &quot;<a href="https://developer.github.com/v3/#http-verbs">HTTP
   * verbs</a>.&quot;
   * </p>
   *
   */
  @Operation(description = "Note that you'll need to set `Content-Length` to zero when calling out to this endpoint. For more information, see \"[HTTP verbs](https://developer.github.com/v3/#http-verbs).\"", summary = "Star a gist", operationId = "gists/star")
  @Path("/{gist_id}/star")
  @PUT
  void gists_star(@PathParam("gist_id") String gistId);

  /**
   *
   */
  @Operation(description = "", summary = "Unstar a gist", operationId = "gists/unstar")
  @Path("/{gist_id}/star")
  @DELETE
  void gists_unstar(@PathParam("gist_id") String gistId);

  /**
   * <p>
   * List the authenticated user's starred gists:
   * </p>
   *
   */
  @Operation(description = "List the authenticated user's starred gists:", summary = "List starred gists", operationId = "gists/list-starred")
  @Path("/starred")
  @GET
  @Produces("application/json")
  Response gists_list_starred(@QueryParam("since") String since,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Get a gist comment", operationId = "gists/get-comment")
  @Path("/{gist_id}/comments/{comment_id}")
  @GET
  @Produces("application/json")
  Response gists_get_comment(@PathParam("gist_id") String gistId, @PathParam("comment_id") BigInteger commentId);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a gist comment", operationId = "gists/delete-comment")
  @Path("/{gist_id}/comments/{comment_id}")
  @DELETE
  void gists_delete_comment(@PathParam("gist_id") String gistId, @PathParam("comment_id") BigInteger commentId);

  /**
   *
   */
  @Operation(description = "", summary = "Update a gist comment", operationId = "gists/update-comment")
  @Path("/{gist_id}/comments/{comment_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response gists_update_comment(@PathParam("gist_id") String gistId, @PathParam("comment_id") BigInteger commentId,
      @NotNull InputStream data);

  /**
   * <p>
   * List public gists sorted by most recently updated to least recently updated.
   * </p>
   * <p>
   * Note: With
   * <a href="https://developer.github.com/v3/#pagination">pagination</a>, you can
   * fetch up to 3000 gists. For example, you can fetch 100 pages with 30 gists
   * per page or 30 pages with 100 gists per page.
   * </p>
   *
   */
  @Operation(description = "List public gists sorted by most recently updated to least recently updated.\n\nNote: With [pagination](https://developer.github.com/v3/#pagination), you can fetch up to 3000 gists. For example, you can fetch 100 pages with 30 gists per page or 30 pages with 100 gists per page.", summary = "List public gists", operationId = "gists/list-public")
  @Path("/public")
  @GET
  @Produces("application/json")
  Response gists_list_public(@QueryParam("since") String since,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Get a gist", operationId = "gists/get")
  @Path("/{gist_id}")
  @GET
  @Produces("application/json")
  Response gists_get(@PathParam("gist_id") String gistId);

  /**
   *
   */
  @Operation(description = "", summary = "Delete a gist", operationId = "gists/delete")
  @Path("/{gist_id}")
  @DELETE
  void gists_delete(@PathParam("gist_id") String gistId);

  /**
   * <p>
   * Allows you to update or delete a gist file and rename gist files. Files from
   * the previous version of the gist that aren't explicitly changed during an
   * edit are unchanged.
   * </p>
   *
   */
  @Operation(description = "Allows you to update or delete a gist file and rename gist files. Files from the previous version of the gist that aren't explicitly changed during an edit are unchanged.", summary = "Update a gist", operationId = "gists/update")
  @Path("/{gist_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response gists_update(@PathParam("gist_id") String gistId, InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "List gist forks", operationId = "gists/list-forks")
  @Path("/{gist_id}/forks")
  @GET
  @Produces("application/json")
  Response gists_list_forks(@PathParam("gist_id") String gistId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * <strong>Note</strong>: This was previously <code>/gists/:gist_id/fork</code>.
   * </p>
   *
   */
  @Operation(description = "**Note**: This was previously `/gists/:gist_id/fork`.", summary = "Fork a gist", operationId = "gists/fork")
  @Path("/{gist_id}/forks")
  @POST
  @Produces("application/json")
  Response gists_fork(@PathParam("gist_id") String gistId);

  /**
   * <p>
   * Lists the authenticated user's gists or if called anonymously, this endpoint
   * returns all public gists:
   * </p>
   *
   */
  @Operation(description = "Lists the authenticated user's gists or if called anonymously, this endpoint returns all public gists:", summary = "List gists for the authenticated user", operationId = "gists/list")
  @GET
  @Produces("application/json")
  Response gists_list(@QueryParam("since") String since, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   * <p>
   * Allows you to add a new gist with one or more files.
   * </p>
   * <p>
   * <strong>Note:</strong> Don't name your files &quot;gistfile&quot; with a
   * numerical suffix. This is the format of the automatic naming scheme that Gist
   * uses internally.
   * </p>
   *
   */
  @Operation(description = "Allows you to add a new gist with one or more files.\n\n**Note:** Don't name your files \"gistfile\" with a numerical suffix. This is the format of the automatic naming scheme that Gist uses internally.", summary = "Create a gist", operationId = "gists/create")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response gists_create(@NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "List gist commits", operationId = "gists/list-commits")
  @Path("/{gist_id}/commits")
  @GET
  @Produces("application/json")
  Response gists_list_commits(@PathParam("gist_id") String gistId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "List gist comments", operationId = "gists/list-comments")
  @Path("/{gist_id}/comments")
  @GET
  @Produces("application/json")
  Response gists_list_comments(@PathParam("gist_id") String gistId,
      @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

  /**
   *
   */
  @Operation(description = "", summary = "Create a gist comment", operationId = "gists/create-comment")
  @Path("/{gist_id}/comments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response gists_create_comment(@PathParam("gist_id") String gistId, @NotNull InputStream data);

  /**
   *
   */
  @Operation(description = "", summary = "Get a gist revision", operationId = "gists/get-revision")
  @Path("/{gist_id}/{sha}")
  @GET
  @Produces("application/json")
  Response gists_get_revision(@PathParam("gist_id") String gistId, @PathParam("sha") String sha);
}
