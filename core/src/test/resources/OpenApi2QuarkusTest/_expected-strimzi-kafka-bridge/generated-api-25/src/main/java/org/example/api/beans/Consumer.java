
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Consumer
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "format",
    "auto.offset.reset",
    "fetch.min.bytes",
    "consumer.request.timeout.ms",
    "enable.auto.commit",
    "isolation.level"
})
@Generated("jsonschema2pojo")
public class Consumer {

    /**
     * The unique name for the consumer instance. The name is unique within the scope of the consumer group. The name is used in URLs. If a name is not specified, a randomly generated name is assigned.
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("The unique name for the consumer instance. The name is unique within the scope of the consumer group. The name is used in URLs. If a name is not specified, a randomly generated name is assigned.")
    private String name;
    /**
     * The allowable message format for the consumer, which can be `binary` (default) or `json`. The messages are converted into a JSON format. 
     * 
     */
    @JsonProperty("format")
    @JsonPropertyDescription("The allowable message format for the consumer, which can be `binary` (default) or `json`. The messages are converted into a JSON format. ")
    private String format;
    /**
     * Resets the offset position for the consumer. If set to `latest` (default), messages are read from the latest offset. If set to `earliest`, messages are read from the first offset.
     * 
     */
    @JsonProperty("auto.offset.reset")
    @JsonPropertyDescription("Resets the offset position for the consumer. If set to `latest` (default), messages are read from the latest offset. If set to `earliest`, messages are read from the first offset.")
    private String autoOffsetReset;
    /**
     * Sets the minimum amount of data, in bytes, for the consumer to receive. The broker waits until the data to send exceeds this amount. Default is `1` byte.
     * 
     */
    @JsonProperty("fetch.min.bytes")
    @JsonPropertyDescription("Sets the minimum amount of data, in bytes, for the consumer to receive. The broker waits until the data to send exceeds this amount. Default is `1` byte.")
    private Integer fetchMinBytes;
    /**
     * Sets the maximum amount of time, in milliseconds, for the consumer to wait for messages for a request. If the timeout period is reached without a response, an error is returned. Default is `30000` (30 seconds).
     * 
     */
    @JsonProperty("consumer.request.timeout.ms")
    @JsonPropertyDescription("Sets the maximum amount of time, in milliseconds, for the consumer to wait for messages for a request. If the timeout period is reached without a response, an error is returned. Default is `30000` (30 seconds).")
    private Integer consumerRequestTimeoutMs;
    /**
     * If set to `true` (default), message offsets are committed automatically for the consumer. If set to `false`, message offsets must be committed manually.
     * 
     */
    @JsonProperty("enable.auto.commit")
    @JsonPropertyDescription("If set to `true` (default), message offsets are committed automatically for the consumer. If set to `false`, message offsets must be committed manually.")
    private Boolean enableAutoCommit;
    /**
     * If set to `read_uncommitted` (default), all transaction records are retrieved, indpendent of any transaction outcome. If set to `read_committed`, the records from committed transactions are retrieved.
     * 
     */
    @JsonProperty("isolation.level")
    @JsonPropertyDescription("If set to `read_uncommitted` (default), all transaction records are retrieved, indpendent of any transaction outcome. If set to `read_committed`, the records from committed transactions are retrieved.")
    private String isolationLevel;

    /**
     * The unique name for the consumer instance. The name is unique within the scope of the consumer group. The name is used in URLs. If a name is not specified, a randomly generated name is assigned.
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * The unique name for the consumer instance. The name is unique within the scope of the consumer group. The name is used in URLs. If a name is not specified, a randomly generated name is assigned.
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The allowable message format for the consumer, which can be `binary` (default) or `json`. The messages are converted into a JSON format. 
     * 
     */
    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    /**
     * The allowable message format for the consumer, which can be `binary` (default) or `json`. The messages are converted into a JSON format. 
     * 
     */
    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Resets the offset position for the consumer. If set to `latest` (default), messages are read from the latest offset. If set to `earliest`, messages are read from the first offset.
     * 
     */
    @JsonProperty("auto.offset.reset")
    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    /**
     * Resets the offset position for the consumer. If set to `latest` (default), messages are read from the latest offset. If set to `earliest`, messages are read from the first offset.
     * 
     */
    @JsonProperty("auto.offset.reset")
    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

    /**
     * Sets the minimum amount of data, in bytes, for the consumer to receive. The broker waits until the data to send exceeds this amount. Default is `1` byte.
     * 
     */
    @JsonProperty("fetch.min.bytes")
    public Integer getFetchMinBytes() {
        return fetchMinBytes;
    }

    /**
     * Sets the minimum amount of data, in bytes, for the consumer to receive. The broker waits until the data to send exceeds this amount. Default is `1` byte.
     * 
     */
    @JsonProperty("fetch.min.bytes")
    public void setFetchMinBytes(Integer fetchMinBytes) {
        this.fetchMinBytes = fetchMinBytes;
    }

    /**
     * Sets the maximum amount of time, in milliseconds, for the consumer to wait for messages for a request. If the timeout period is reached without a response, an error is returned. Default is `30000` (30 seconds).
     * 
     */
    @JsonProperty("consumer.request.timeout.ms")
    public Integer getConsumerRequestTimeoutMs() {
        return consumerRequestTimeoutMs;
    }

    /**
     * Sets the maximum amount of time, in milliseconds, for the consumer to wait for messages for a request. If the timeout period is reached without a response, an error is returned. Default is `30000` (30 seconds).
     * 
     */
    @JsonProperty("consumer.request.timeout.ms")
    public void setConsumerRequestTimeoutMs(Integer consumerRequestTimeoutMs) {
        this.consumerRequestTimeoutMs = consumerRequestTimeoutMs;
    }

    /**
     * If set to `true` (default), message offsets are committed automatically for the consumer. If set to `false`, message offsets must be committed manually.
     * 
     */
    @JsonProperty("enable.auto.commit")
    public Boolean getEnableAutoCommit() {
        return enableAutoCommit;
    }

    /**
     * If set to `true` (default), message offsets are committed automatically for the consumer. If set to `false`, message offsets must be committed manually.
     * 
     */
    @JsonProperty("enable.auto.commit")
    public void setEnableAutoCommit(Boolean enableAutoCommit) {
        this.enableAutoCommit = enableAutoCommit;
    }

    /**
     * If set to `read_uncommitted` (default), all transaction records are retrieved, indpendent of any transaction outcome. If set to `read_committed`, the records from committed transactions are retrieved.
     * 
     */
    @JsonProperty("isolation.level")
    public String getIsolationLevel() {
        return isolationLevel;
    }

    /**
     * If set to `read_uncommitted` (default), all transaction records are retrieved, indpendent of any transaction outcome. If set to `read_committed`, the records from committed transactions are retrieved.
     * 
     */
    @JsonProperty("isolation.level")
    public void setIsolationLevel(String isolationLevel) {
        this.isolationLevel = isolationLevel;
    }

}
