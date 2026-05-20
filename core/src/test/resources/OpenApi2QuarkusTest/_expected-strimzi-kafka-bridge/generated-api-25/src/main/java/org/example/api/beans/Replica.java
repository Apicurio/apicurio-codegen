
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Replica
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "broker",
    "leader",
    "in_sync"
})
@Generated("jsonschema2pojo")
public class Replica {

    @JsonProperty("broker")
    private Integer broker;
    @JsonProperty("leader")
    private Boolean leader;
    @JsonProperty("in_sync")
    private Boolean inSync;

    @JsonProperty("broker")
    public Integer getBroker() {
        return broker;
    }

    @JsonProperty("broker")
    public void setBroker(Integer broker) {
        this.broker = broker;
    }

    @JsonProperty("leader")
    public Boolean getLeader() {
        return leader;
    }

    @JsonProperty("leader")
    public void setLeader(Boolean leader) {
        this.leader = leader;
    }

    @JsonProperty("in_sync")
    public Boolean getInSync() {
        return inSync;
    }

    @JsonProperty("in_sync")
    public void setInSync(Boolean inSync) {
        this.inSync = inSync;
    }

}
