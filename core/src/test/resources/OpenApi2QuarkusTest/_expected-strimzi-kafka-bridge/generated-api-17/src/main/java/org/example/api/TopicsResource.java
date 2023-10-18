package org.example.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import java.math.BigInteger;
import java.util.List;
import org.example.api.beans.OffsetRecordSentList;
import org.example.api.beans.OffsetsSummary;
import org.example.api.beans.PartitionMetadata;
import org.example.api.beans.ProducerRecordList;
import org.example.api.beans.ProducerRecordToPartitionList;
import org.example.api.beans.TopicMetadata;

/**
 * A JAX-RS interface. An implementation of this interface must be provided.
 */
@Path("/topics")
public interface TopicsResource {
  /**
   * <p>
   * Retrieves a list of all topics.
   * </p>
   * 
   */
  @GET
  @Produces("application/vnd.kafka.v2+json")
  List<String> listTopics();

  /**
   * <p>
   * Retrieves the metadata about a given topic.
   * </p>
   * 
   */
  @Path("/{topicname}")
  @GET
  @Produces("application/vnd.kafka.v2+json")
  TopicMetadata getTopic(@PathParam("topicname") String topicname, @QueryParam("async") Boolean async);

  /**
   * <p>
   * Sends one or more records to a given topic, optionally specifying a
   * partition, key, or both.
   * </p>
   * 
   */
  @Path("/{topicname}")
  @POST
  @Produces("application/vnd.kafka.v2+json")
  @Consumes({"application/vnd.kafka.binary.v2+json", "application/vnd.kafka.json.v2+json"})
  OffsetRecordSentList send(@PathParam("topicname") String topicname, @QueryParam("async") Boolean async,
      @NotNull ProducerRecordList data);

  /**
   * <p>
   * Retrieves a list of partitions for the topic.
   * </p>
   * 
   */
  @Path("/{topicname}/partitions")
  @GET
  @Produces("application/vnd.kafka.v2+json")
  List<PartitionMetadata> listPartitions(@PathParam("topicname") String topicname);

  /**
   * <p>
   * Retrieves partition metadata for the topic partition.
   * </p>
   * 
   */
  @Path("/{topicname}/partitions/{partitionid}")
  @GET
  @Produces("application/vnd.kafka.v2+json")
  PartitionMetadata getPartition(@PathParam("topicname") String topicname,
      @PathParam("partitionid") BigInteger partitionid, @QueryParam("async") Boolean async);

  /**
   * <p>
   * Sends one or more records to a given topic partition, optionally specifying a
   * key.
   * </p>
   * 
   */
  @Path("/{topicname}/partitions/{partitionid}")
  @POST
  @Produces("application/vnd.kafka.v2+json")
  @Consumes({"application/vnd.kafka.binary.v2+json", "application/vnd.kafka.json.v2+json"})
  OffsetRecordSentList sendToPartition(@PathParam("topicname") String topicname,
      @PathParam("partitionid") BigInteger partitionid, @QueryParam("async") Boolean async,
      @NotNull ProducerRecordToPartitionList data);

  /**
   * <p>
   * Retrieves a summary of the offsets for the topic partition.
   * </p>
   * 
   */
  @Path("/{topicname}/partitions/{partitionid}/offsets")
  @GET
  @Produces("application/vnd.kafka.v2+json")
  OffsetsSummary getOffsets(@PathParam("topicname") String topicname, @PathParam("partitionid") BigInteger partitionid);
}
