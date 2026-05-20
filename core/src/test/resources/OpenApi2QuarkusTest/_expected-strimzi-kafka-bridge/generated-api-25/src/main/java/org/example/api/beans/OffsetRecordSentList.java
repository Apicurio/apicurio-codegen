
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * OffsetRecordSentList
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "offsets"
})
@Generated("jsonschema2pojo")
public class OffsetRecordSentList {

    @JsonProperty("offsets")
    private List<OffsetRecordSent> offsets = new ArrayList<OffsetRecordSent>();

    @JsonProperty("offsets")
    public List<OffsetRecordSent> getOffsets() {
        return offsets;
    }

    @JsonProperty("offsets")
    public void setOffsets(List<OffsetRecordSent> offsets) {
        this.offsets = offsets;
    }

}
