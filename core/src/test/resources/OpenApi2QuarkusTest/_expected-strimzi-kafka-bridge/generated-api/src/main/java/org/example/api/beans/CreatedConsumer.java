
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * CreatedConsumer
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "instance_id",
    "base_uri"
})
@Generated("jsonschema2pojo")
public class CreatedConsumer {

    /**
     * Unique ID for the consumer instance in the group.
     * 
     */
    @JsonProperty("instance_id")
    @JsonPropertyDescription("Unique ID for the consumer instance in the group.")
    private String instanceId;
    /**
     * Base URI used to construct URIs for subsequent requests against this consumer instance.
     * 
     */
    @JsonProperty("base_uri")
    @JsonPropertyDescription("Base URI used to construct URIs for subsequent requests against this consumer instance.")
    private String baseUri;

    /**
     * Unique ID for the consumer instance in the group.
     * 
     */
    @JsonProperty("instance_id")
    public String getInstanceId() {
        return instanceId;
    }

    /**
     * Unique ID for the consumer instance in the group.
     * 
     */
    @JsonProperty("instance_id")
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    /**
     * Base URI used to construct URIs for subsequent requests against this consumer instance.
     * 
     */
    @JsonProperty("base_uri")
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * Base URI used to construct URIs for subsequent requests against this consumer instance.
     * 
     */
    @JsonProperty("base_uri")
    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

}
