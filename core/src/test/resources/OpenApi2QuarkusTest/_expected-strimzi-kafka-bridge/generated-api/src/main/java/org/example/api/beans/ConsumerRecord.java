
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ConsumerRecord
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "offset",
    "partition",
    "topic",
    "value",
    "headers"
})
@Generated("jsonschema2pojo")
public class ConsumerRecord {

    @JsonProperty("key")
    private String key;
    @JsonProperty("offset")
    private Long offset;
    @JsonProperty("partition")
    private Integer partition;
    @JsonProperty("topic")
    private String topic;
    @JsonProperty("value")
    private String value;
    /**
     * KafkaHeaderList
     * <p>
     * 
     * 
     */
    @JsonProperty("headers")
    private List<KafkaHeader> headers = new ArrayList<KafkaHeader>();

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("offset")
    public Long getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Long offset) {
        this.offset = offset;
    }

    @JsonProperty("partition")
    public Integer getPartition() {
        return partition;
    }

    @JsonProperty("partition")
    public void setPartition(Integer partition) {
        this.partition = partition;
    }

    @JsonProperty("topic")
    public String getTopic() {
        return topic;
    }

    @JsonProperty("topic")
    public void setTopic(String topic) {
        this.topic = topic;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * KafkaHeaderList
     * <p>
     * 
     * 
     */
    @JsonProperty("headers")
    public List<KafkaHeader> getHeaders() {
        return headers;
    }

    /**
     * KafkaHeaderList
     * <p>
     * 
     * 
     */
    @JsonProperty("headers")
    public void setHeaders(List<KafkaHeader> headers) {
        this.headers = headers;
    }

}
