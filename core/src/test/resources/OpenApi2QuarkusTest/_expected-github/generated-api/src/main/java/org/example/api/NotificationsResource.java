package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
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
@Path("/notifications")
public interface NotificationsResource {
  /**
   * 
   */
  @Path("/threads/{thread_id}")
  @GET
  @Produces("application/json")
  Response activity_get_thread(@PathParam("thread_id") Integer threadId);

  /**
   * 
   */
  @Path("/threads/{thread_id}")
  @PATCH
  void activity_mark_thread_as_read(@PathParam("thread_id") Integer threadId);

  /**
   * <p>
   * This checks to see if the current user is subscribed to a thread. You can
   * also <a href=
   * "https://developer.github.com/v3/activity/watching/#get-a-repository-subscription">get
   * a repository subscription</a>.
   * </p>
   * <p>
   * Note that subscriptions are only generated if a user is participating in a
   * conversation--for example, they've replied to the thread, were
   * <strong>@mentioned</strong>, or manually subscribe to a thread.
   * </p>
   * 
   */
  @Path("/threads/{thread_id}/subscription")
  @GET
  @Produces("application/json")
  Response activity_get_thread_subscription_for_authenticated_user(@PathParam("thread_id") Integer threadId);

  /**
   * <p>
   * If you are watching a repository, you receive notifications for all threads
   * by default. Use this endpoint to ignore future notifications for threads
   * until you comment on the thread or get an <strong>@mention</strong>.
   * </p>
   * <p>
   * You can also use this endpoint to subscribe to threads that you are currently
   * not receiving notifications for or to subscribed to threads that you have
   * previously ignored.
   * </p>
   * <p>
   * Unsubscribing from a conversation in a repository that you are not watching
   * is functionally equivalent to the <a href=
   * "https://developer.github.com/v3/activity/notifications/#delete-a-thread-subscription">Delete
   * a thread subscription</a> endpoint.
   * </p>
   * 
   */
  @Path("/threads/{thread_id}/subscription")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response activity_set_thread_subscription(@PathParam("thread_id") Integer threadId, @NotNull InputStream data);

  /**
   * <p>
   * Mutes all future notifications for a conversation until you comment on the
   * thread or get an <strong>@mention</strong>. If you are watching the
   * repository of the thread, you will still receive notifications. To ignore
   * future notifications for a repository you are watching, use the <a href=
   * "https://developer.github.com/v3/activity/notifications/#set-a-thread-subscription">Set
   * a thread subscription</a> endpoint and set <code>ignore</code> to
   * <code>true</code>.
   * </p>
   * 
   */
  @Path("/threads/{thread_id}/subscription")
  @DELETE
  void activity_delete_thread_subscription(@PathParam("thread_id") Integer threadId);

  /**
   * <p>
   * List all notifications for the current user, sorted by most recently updated.
   * </p>
   * 
   */
  @GET
  @Produces("application/json")
  Response activity_list_notifications_for_authenticated_user(@QueryParam("all") @DefaultValue("false") Boolean all,
      @QueryParam("participating") @DefaultValue("false") Boolean participating, @QueryParam("since") String since,
      @QueryParam("before") String before, @QueryParam("per_page") @DefaultValue("30") Integer perPage,
      @QueryParam("page") @DefaultValue("1") Integer page);

  /**
   * <p>
   * Marks all notifications as &quot;read&quot; removes it from the
   * <a href="https://github.com/notifications">default view on GitHub</a>. If the
   * number of notifications is too large to complete in one request, you will
   * receive a <code>202 Accepted</code> status and GitHub will run an
   * asynchronous process to mark notifications as &quot;read.&quot; To check
   * whether any &quot;unread&quot; notifications remain, you can use the <a href=
   * "https://developer.github.com/v3/activity/notifications/#list-notifications-for-the-authenticated-user">List
   * notifications for the authenticated user</a> endpoint and pass the query
   * parameter <code>all=false</code>.
   * </p>
   * 
   */
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response activity_mark_notifications_as_read(@NotNull InputStream data);
}
