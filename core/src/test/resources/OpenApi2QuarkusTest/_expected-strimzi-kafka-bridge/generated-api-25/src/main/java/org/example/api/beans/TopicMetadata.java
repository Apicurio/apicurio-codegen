
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TopicMetadata
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "configs",
    "partitions"
})
@Generated("jsonschema2pojo")
public class TopicMetadata {

    /**
     * Name of the topic
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name of the topic")
    private String name;
    /**
     * Per-topic configuration overrides
     * 
     */
    @JsonProperty("configs")
    @JsonPropertyDescription("Per-topic configuration overrides")
    private Configs configs;
    @JsonProperty("partitions")
    private List<PartitionMetadata> partitions = new ArrayList<PartitionMetadata>();

    /**
     * Name of the topic
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the topic
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Per-topic configuration overrides
     * 
     */
    @JsonProperty("configs")
    public Configs getConfigs() {
        return configs;
    }

    /**
     * Per-topic configuration overrides
     * 
     */
    @JsonProperty("configs")
    public void setConfigs(Configs configs) {
        this.configs = configs;
    }

    @JsonProperty("partitions")
    public List<PartitionMetadata> getPartitions() {
        return partitions;
    }

    @JsonProperty("partitions")
    public void setPartitions(List<PartitionMetadata> partitions) {
        this.partitions = partitions;
    }

}
