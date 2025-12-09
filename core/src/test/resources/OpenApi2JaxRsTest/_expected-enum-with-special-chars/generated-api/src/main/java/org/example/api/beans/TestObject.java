
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status"
})
@Generated("jsonschema2pojo")
public class TestObject {

    @JsonProperty("status")
    private StatusType status;

    @JsonProperty("status")
    public StatusType getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(StatusType status) {
        this.status = status;
    }

}