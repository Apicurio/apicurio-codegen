
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * KafkaHeader
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "value"
})
@Generated("jsonschema2pojo")
public class KafkaHeader {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    private String key;
    /**
     * The header value in binary format, base64-encoded
     * (Required)
     * 
     */
    @JsonProperty("value")
    @JsonPropertyDescription("The header value in binary format, base64-encoded")
    private byte[] value;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * The header value in binary format, base64-encoded
     * (Required)
     * 
     */
    @JsonProperty("value")
    public byte[] getValue() {
        return value;
    }

    /**
     * The header value in binary format, base64-encoded
     * (Required)
     * 
     */
    @JsonProperty("value")
    public void setValue(byte[] value) {
        this.value = value;
    }

}
