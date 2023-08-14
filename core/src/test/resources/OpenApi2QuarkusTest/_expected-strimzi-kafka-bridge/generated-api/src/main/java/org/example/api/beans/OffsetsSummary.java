
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * OffsetsSummary
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "beginning_offset",
    "end_offset"
})
@Generated("jsonschema2pojo")
public class OffsetsSummary {

    @JsonProperty("beginning_offset")
    private Long beginningOffset;
    @JsonProperty("end_offset")
    private Long endOffset;

    @JsonProperty("beginning_offset")
    public Long getBeginningOffset() {
        return beginningOffset;
    }

    @JsonProperty("beginning_offset")
    public void setBeginningOffset(Long beginningOffset) {
        this.beginningOffset = beginningOffset;
    }

    @JsonProperty("end_offset")
    public Long getEndOffset() {
        return endOffset;
    }

    @JsonProperty("end_offset")
    public void setEndOffset(Long endOffset) {
        this.endOffset = endOffset;
    }

}
