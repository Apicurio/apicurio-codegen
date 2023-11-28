package org.example.api;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.math.BigInteger;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/reactions")
public interface ReactionsResource {
  /**
   * <p>
   * <strong>Deprecation Notice:</strong> This endpoint route is deprecated and
   * will be removed from the Reactions API. We recommend migrating your existing
   * code to use the new delete reactions endpoints. For more information, see
   * this <a href=
   * "https://developer.github.com/changes/2020-02-26-new-delete-reactions-endpoints/">blog
   * post</a>.
   * </p>
   * <p>
   * OAuth access tokens require the <code>write:discussion</code> <a href=
   * "https://developer.github.com/apps/building-oauth-apps/understanding-scopes-for-oauth-apps/">scope</a>,
   * when deleting a
   * <a href="https://developer.github.com/v3/teams/discussions/">team
   * discussion</a> or
   * <a href="https://developer.github.com/v3/teams/discussion_comments/">team
   * discussion comment</a>.
   * </p>
   * 
   */
  @Path("/{reaction_id}")
  @DELETE
  void reactions_delete_legacy(@PathParam("reaction_id") BigInteger reactionId);
}
