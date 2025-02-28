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
import java.math.BigInteger;
import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/notifications")
public interface NotificationsResource {
  /**
   *
   */
  @Operation(description = "", summary = "Get a thread", operationId = "activity/get-thread")
  @Path("/threads/{thread_id}")
  @GET
  @Produces("application/json")
  Response activity_get_thread(@PathParam("thread_id") BigInteger threadId);

  /**
   *
   */
  @Operation(description = "", summary = "Mark a thread as read", operationId = "activity/mark-thread-as-read")
  @Path("/threads/{thread_id}")
  @PATCH
  void activity_mark_thread_as_read(@PathParam("thread_id") BigInteger threadId);

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
  @Operation(description = "This checks to see if the current user is subscribed to a thread. You can also [get a repository subscription](https://developer.github.com/v3/activity/watching/#get-a-repository-subscription).\n\nNote that subscriptions are only generated if a user is participating in a conversation--for example, they've replied to the thread, were **@mentioned**, or manually subscribe to a thread.", summary = "Get a thread subscription for the authenticated user", operationId = "activity/get-thread-subscription-for-authenticated-user")
  @Path("/threads/{thread_id}/subscription")
  @GET
  @Produces("application/json")
  Response activity_get_thread_subscription_for_authenticated_user(@PathParam("thread_id") BigInteger threadId);

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
  @Operation(description = "If you are watching a repository, you receive notifications for all threads by default. Use this endpoint to ignore future notifications for threads until you comment on the thread or get an **@mention**.\n\nYou can also use this endpoint to subscribe to threads that you are currently not receiving notifications for or to subscribed to threads that you have previously ignored.\n\nUnsubscribing from a conversation in a repository that you are not watching is functionally equivalent to the [Delete a thread subscription](https://developer.github.com/v3/activity/notifications/#delete-a-thread-subscription) endpoint.", summary = "Set a thread subscription", operationId = "activity/set-thread-subscription")
  @Path("/threads/{thread_id}/subscription")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response activity_set_thread_subscription(@PathParam("thread_id") BigInteger threadId, @NotNull InputStream data);

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
  @Operation(description = "Mutes all future notifications for a conversation until you comment on the thread or get an **@mention**. If you are watching the repository of the thread, you will still receive notifications. To ignore future notifications for a repository you are watching, use the [Set a thread subscription](https://developer.github.com/v3/activity/notifications/#set-a-thread-subscription) endpoint and set `ignore` to `true`.", summary = "Delete a thread subscription", operationId = "activity/delete-thread-subscription")
  @Path("/threads/{thread_id}/subscription")
  @DELETE
  void activity_delete_thread_subscription(@PathParam("thread_id") BigInteger threadId);

  /**
   * <p>
   * List all notifications for the current user, sorted by most recently updated.
   * </p>
   *
   */
  @Operation(description = "List all notifications for the current user, sorted by most recently updated.", summary = "List notifications for the authenticated user", operationId = "activity/list-notifications-for-authenticated-user")
  @GET
  @Produces("application/json")
  Response activity_list_notifications_for_authenticated_user(@QueryParam("all") @DefaultValue("false") Boolean all,
      @QueryParam("participating") @DefaultValue("false") Boolean participating, @QueryParam("since") String since,
      @QueryParam("before") String before, @QueryParam("per_page") @DefaultValue("30") BigInteger perPage,
      @QueryParam("page") @DefaultValue("1") BigInteger page);

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
  @Operation(description = "Marks all notifications as \"read\" removes it from the [default view on GitHub](https://github.com/notifications). If the number of notifications is too large to complete in one request, you will receive a `202 Accepted` status and GitHub will run an asynchronous process to mark notifications as \"read.\" To check whether any \"unread\" notifications remain, you can use the [List notifications for the authenticated user](https://developer.github.com/v3/activity/notifications/#list-notifications-for-the-authenticated-user) endpoint and pass the query parameter `all=false`.", summary = "Mark notifications as read", operationId = "activity/mark-notifications-as-read")
  @PUT
  @Produces("application/json")
  @Consumes("application/json")
  Response activity_mark_notifications_as_read(@NotNull InputStream data);
}
