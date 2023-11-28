
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * OffsetCommitSeek
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "partition",
    "offset",
    "topic"
})
@Generated("jsonschema2pojo")
public class OffsetCommitSeek {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("partition")
    private Integer partition;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("offset")
    private Long offset;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("topic")
    private String topic;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("partition")
    public Integer getPartition() {
        return partition;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("partition")
    public void setPartition(Integer partition) {
        this.partition = partition;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("offset")
    public Long getOffset() {
        return offset;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("offset")
    public void setOffset(Long offset) {
        this.offset = offset;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("topic")
    public String getTopic() {
        return topic;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("topic")
    public void setTopic(String topic) {
        this.topic = topic;
    }

}
