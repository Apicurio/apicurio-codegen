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
@Path("/gists")
public interface GistsResource {
  /**
   * 
   */
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
  @Path("/{gist_id}/star")
  @PUT
  void gists_star(@PathParam("gist_id") String gistId);

  /**
   * 
   */
  @Path("/{gist_id}/star")
  @DELETE
  void gists_unstar(@PathParam("gist_id") String gistId);

  /**
   * <p>
   * List the authenticated user's starred gists:
   * </p>
   * 
   */
  @Path("/starred")
  @GET
  @Produces("application/json")
  Response gists_list_starred(@QueryParam("since") String since, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{gist_id}/comments/{comment_id}")
  @GET
  @Produces("application/json")
  Response gists_get_comment(@PathParam("gist_id") String gistId, @PathParam("comment_id") Integer commentId);

  /**
   * 
   */
  @Path("/{gist_id}/comments/{comment_id}")
  @DELETE
  void gists_delete_comment(@PathParam("gist_id") String gistId, @PathParam("comment_id") Integer commentId);

  /**
   * 
   */
  @Path("/{gist_id}/comments/{comment_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response gists_update_comment(@PathParam("gist_id") String gistId, @PathParam("comment_id") Integer commentId,
      InputStream data);

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
  @Path("/public")
  @GET
  @Produces("application/json")
  Response gists_list_public(@QueryParam("since") String since, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{gist_id}")
  @GET
  @Produces("application/json")
  Response gists_get(@PathParam("gist_id") String gistId);

  /**
   * 
   */
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
  @Path("/{gist_id}")
  @PATCH
  @Produces("application/json")
  @Consumes("application/json")
  Response gists_update(@PathParam("gist_id") String gistId, InputStream data);

  /**
   * 
   */
  @Path("/{gist_id}/forks")
  @GET
  @Produces("application/json")
  Response gists_list_forks(@PathParam("gist_id") String gistId, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * <p>
   * <strong>Note</strong>: This was previously <code>/gists/:gist_id/fork</code>.
   * </p>
   * 
   */
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
  @GET
  @Produces("application/json")
  Response gists_list(@QueryParam("since") String since, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

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
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response gists_create(InputStream data);

  /**
   * 
   */
  @Path("/{gist_id}/commits")
  @GET
  @Produces("application/json")
  Response gists_list_commits(@PathParam("gist_id") String gistId, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{gist_id}/comments")
  @GET
  @Produces("application/json")
  Response gists_list_comments(@PathParam("gist_id") String gistId, @QueryParam("per_page") Integer perPage,
      @QueryParam("page") Integer page);

  /**
   * 
   */
  @Path("/{gist_id}/comments")
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Response gists_create_comment(@PathParam("gist_id") String gistId, InputStream data);

  /**
   * 
   */
  @Path("/{gist_id}/{sha}")
  @GET
  @Produces("application/json")
  Response gists_get_revision(@PathParam("gist_id") String gistId, @PathParam("sha") String sha);
}
