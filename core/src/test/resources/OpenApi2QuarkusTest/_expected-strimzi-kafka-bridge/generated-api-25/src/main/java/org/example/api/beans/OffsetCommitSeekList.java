
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * OffsetCommitSeekList
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "offsets"
})
@Generated("jsonschema2pojo")
public class OffsetCommitSeekList {

    @JsonProperty("offsets")
    private List<OffsetCommitSeek> offsets = new ArrayList<OffsetCommitSeek>();

    @JsonProperty("offsets")
    public List<OffsetCommitSeek> getOffsets() {
        return offsets;
    }

    @JsonProperty("offsets")
    public void setOffsets(List<OffsetCommitSeek> offsets) {
        this.offsets = offsets;
    }

}
