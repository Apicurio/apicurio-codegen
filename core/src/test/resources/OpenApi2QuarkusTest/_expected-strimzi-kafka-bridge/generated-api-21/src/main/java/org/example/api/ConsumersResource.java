package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import java.math.BigInteger;
import java.util.List;
import org.example.api.beans.Consumer;
import org.example.api.beans.ConsumerRecord;
import org.example.api.beans.CreatedConsumer;
import org.example.api.beans.OffsetCommitSeekList;
import org.example.api.beans.Partitions;
import org.example.api.beans.SubscribedTopicList;
import org.example.api.beans.Topics;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/consumers")
public interface ConsumersResource {
  /**
   * <p>
   * Creates a consumer instance in the given consumer group. You can optionally
   * specify a consumer name and supported configuration options. It returns a
   * base URI which must be used to construct URLs for subsequent requests against
   * this consumer instance.
   * </p>
   * 
   */
  @Path("/{groupid}")
  @POST
  @Produces("application/vnd.kafka.v2+json")
  @Consumes("application/vnd.kafka.v2+json")
  CreatedConsumer createConsumer(@PathParam("groupid") String groupid, @NotNull Consumer data);

  /**
   * <p>
   * Configures a subscribed consumer to seek (and subsequently read from) the
   * first offset in one or more given topic partitions.
   * </p>
   * 
   */
  @Path("/{groupid}/instances/{name}/positions/beginning")
  @POST
  @Consumes("application/vnd.kafka.v2+json")
  void seekToBeginning(@PathParam("groupid") String groupid, @PathParam("name") String name, @NotNull Partitions data);

  /**
   * <p>
   * Configures a subscribed consumer to seek (and subsequently read from) the
   * offset at the end of one or more of the given topic partitions.
   * </p>
   * 
   */
  @Path("/{groupid}/instances/{name}/positions/end")
  @POST
  @Consumes("application/vnd.kafka.v2+json")
  void seekToEnd(@PathParam("groupid") String groupid, @PathParam("name") String name, @NotNull Partitions data);

  /**
   * <p>
   * Retrieves a list of the topics to which the consumer is subscribed.
   * </p>
   * 
   */
  @Path("/{groupid}/instances/{name}/subscription")
  @GET
  @Produces("application/vnd.kafka.v2+json")
  SubscribedTopicList listSubscriptions(@PathParam("groupid") String groupid, @PathParam("name") String name);

  /**
   * <p>
   * Subscribes a consumer to one or more topics. You can describe the topics to
   * which the consumer will subscribe in a list (of <code>Topics</code> type) or
   * as a <code>topic_pattern</code> field. Each call replaces the subscriptions
   * for the subscriber.
   * </p>
   * 
   */
  @Path("/{groupid}/instances/{name}/subscription")
  @POST
  @Consumes("application/vnd.kafka.v2+json")
  void subscribe(@PathParam("groupid") String groupid, @PathParam("name") String name, @NotNull Topics data);

  /**
   * <p>
   * Unsubscribes a consumer from all topics.
   * </p>
   * 
   */
  @Path("/{groupid}/instances/{name}/subscription")
  @DELETE
  void unsubscribe(@PathParam("groupid") String groupid, @PathParam("name") String name);

  /**
   * <p>
   * Configures a subscribed consumer to fetch offsets from a particular offset
   * the next time it fetches a set of records from a given topic partition. This
   * overrides the default fetch behavior for consumers. You can specify one or
   * more topic partitions.
   * </p>
   * 
   */
  @Path("/{groupid}/instances/{name}/positions")
  @POST
  @Consumes("application/vnd.kafka.v2+json")
  void seek(@PathParam("groupid") String groupid, @PathParam("name") String name, @NotNull OffsetCommitSeekList data);

  /**
   * <p>
   * Assigns one or more topic partitions to a consumer.
   * </p>
   * 
   */
  @Path("/{groupid}/instances/{name}/assignments")
  @POST
  @Consumes("application/vnd.kafka.v2+json")
  void assign(@PathParam("groupid") String groupid, @PathParam("name") String name, @NotNull Partitions data);

  /**
   * <p>
   * Retrieves records for a subscribed consumer, including message values,
   * topics, and partitions. The request for this operation MUST use the base URL
   * (including the host and port) returned in the response from the
   * <code>POST</code> request to <code>/consumers/{groupid}</code> that was used
   * to create this consumer.
   * </p>
   * 
   */
  @Path("/{groupid}/instances/{name}/records")
  @GET
  @Produces({"application/vnd.kafka.binary.v2+json", "application/vnd.kafka.json.v2+json",
      "application/vnd.kafka.v2+json"})
  List<ConsumerRecord> poll(@PathParam("groupid") String groupid, @PathParam("name") String name,
      @QueryParam("timeout") BigInteger timeout, @QueryParam("max_bytes") BigInteger maxBytes);

  /**
   * <p>
   * Deletes a specified consumer instance. The request for this operation MUST
   * use the base URL (including the host and port) returned in the response from
   * the <code>POST</code> request to <code>/consumers/{groupid}</code> that was
   * used to create this consumer.
   * </p>
   * 
   */
  @Path("/{groupid}/instances/{name}")
  @DELETE
  void deleteConsumer(@PathParam("groupid") String groupid, @PathParam("name") String name);

  /**
   * <p>
   * Commits a list of consumer offsets. To commit offsets for all records fetched
   * by the consumer, leave the request body empty.
   * </p>
   * 
   */
  @Path("/{groupid}/instances/{name}/offsets")
  @POST
  @Consumes("application/vnd.kafka.v2+json")
  void commit(@PathParam("groupid") String groupid, @PathParam("name") String name, @NotNull OffsetCommitSeekList data);
}
