
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * BridgeInfo
 * <p>
 * Information about Kafka Bridge instance.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bridge_version"
})
@Generated("jsonschema2pojo")
public class BridgeInfo {

    @JsonProperty("bridge_version")
    private String bridgeVersion;

    @JsonProperty("bridge_version")
    public String getBridgeVersion() {
        return bridgeVersion;
    }

    @JsonProperty("bridge_version")
    public void setBridgeVersion(String bridgeVersion) {
        this.bridgeVersion = bridgeVersion;
    }

}
