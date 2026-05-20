
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * SubscribedTopicList
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "topics",
    "partitions"
})
@Generated("jsonschema2pojo")
public class SubscribedTopicList {

    /**
     * Topics
     * <p>
     * 
     * 
     */
    @JsonProperty("topics")
    private Topics topics;
    @JsonProperty("partitions")
    private List<AssignedTopicPartitions> partitions = new ArrayList<AssignedTopicPartitions>();

    /**
     * Topics
     * <p>
     * 
     * 
     */
    @JsonProperty("topics")
    public Topics getTopics() {
        return topics;
    }

    /**
     * Topics
     * <p>
     * 
     * 
     */
    @JsonProperty("topics")
    public void setTopics(Topics topics) {
        this.topics = topics;
    }

    @JsonProperty("partitions")
    public List<AssignedTopicPartitions> getPartitions() {
        return partitions;
    }

    @JsonProperty("partitions")
    public void setPartitions(List<AssignedTopicPartitions> partitions) {
        this.partitions = partitions;
    }

}
