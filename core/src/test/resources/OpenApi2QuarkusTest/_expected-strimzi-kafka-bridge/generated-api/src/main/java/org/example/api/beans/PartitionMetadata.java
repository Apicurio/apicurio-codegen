
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * PartitionMetadata
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "partition",
    "leader",
    "replicas"
})
@Generated("jsonschema2pojo")
public class PartitionMetadata {

    @JsonProperty("partition")
    private Integer partition;
    @JsonProperty("leader")
    private Integer leader;
    @JsonProperty("replicas")
    private List<Replica> replicas = new ArrayList<Replica>();

    @JsonProperty("partition")
    public Integer getPartition() {
        return partition;
    }

    @JsonProperty("partition")
    public void setPartition(Integer partition) {
        this.partition = partition;
    }

    @JsonProperty("leader")
    public Integer getLeader() {
        return leader;
    }

    @JsonProperty("leader")
    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    @JsonProperty("replicas")
    public List<Replica> getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(List<Replica> replicas) {
        this.replicas = replicas;
    }

}
