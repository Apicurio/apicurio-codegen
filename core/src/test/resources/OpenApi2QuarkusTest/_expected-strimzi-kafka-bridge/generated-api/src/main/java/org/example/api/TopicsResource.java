package org.example.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import java.util.List;
import org.example.api.beans.OffsetRecordSentList;
import org.example.api.beans.OffsetsSummary;
import org.example.api.beans.PartitionMetadata;
import org.example.api.beans.ProducerRecordList;
import org.example.api.beans.ProducerRecordToPartitionList;
import org.example.api.beans.TopicMetadata;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/topics")
public interface TopicsResource {
  /**
   * Retrieves a list of all topics.
   */
  @GET
  @Produces("application/vnd.kafka.v2+json")
  List<String> listTopics();

  /**
   * Retrieves the metadata about a given topic.
   */
  @Path("/{topicname}")
  @GET
  @Produces("application/vnd.kafka.v2+json")
  TopicMetadata getTopic(@PathParam("topicname") String topicname,
      @QueryParam("async") Boolean async);

  /**
   * Sends one or more records to a given topic, optionally specifying a partition, key, or both.
   */
  @Path("/{topicname}")
  @POST
  @Produces("application/vnd.kafka.v2+json")
  @Consumes({"application/vnd.kafka.binary.v2+json", "application/vnd.kafka.json.v2+json"})
  OffsetRecordSentList send(@PathParam("topicname") String topicname,
      @QueryParam("async") Boolean async, ProducerRecordList data);

  /**
   * Retrieves a list of partitions for the topic.
   */
  @Path("/{topicname}/partitions")
  @GET
  @Produces("application/vnd.kafka.v2+json")
  List<PartitionMetadata> listPartitions(@PathParam("topicname") String topicname);

  /**
   * Retrieves partition metadata for the topic partition.
   */
  @Path("/{topicname}/partitions/{partitionid}")
  @GET
  @Produces("application/vnd.kafka.v2+json")
  PartitionMetadata getPartition(@PathParam("topicname") String topicname,
      @PathParam("partitionid") Integer partitionid, @QueryParam("async") Boolean async);

  /**
   * Sends one or more records to a given topic partition, optionally specifying a key.
   */
  @Path("/{topicname}/partitions/{partitionid}")
  @POST
  @Produces("application/vnd.kafka.v2+json")
  @Consumes({"application/vnd.kafka.binary.v2+json", "application/vnd.kafka.json.v2+json"})
  OffsetRecordSentList sendToPartition(@PathParam("topicname") String topicname,
      @PathParam("partitionid") Integer partitionid, @QueryParam("async") Boolean async,
      ProducerRecordToPartitionList data);

  /**
   * Retrieves a summary of the offsets for the topic partition.
   */
  @Path("/{topicname}/partitions/{partitionid}/offsets")
  @GET
  @Produces("application/vnd.kafka.v2+json")
  OffsetsSummary getOffsets(@PathParam("topicname") String topicname,
      @PathParam("partitionid") Integer partitionid);
}
