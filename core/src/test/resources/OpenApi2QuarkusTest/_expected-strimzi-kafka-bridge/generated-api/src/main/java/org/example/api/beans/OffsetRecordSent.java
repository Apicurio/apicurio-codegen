
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * OffsetRecordSent
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "partition",
    "offset"
})
@Generated("jsonschema2pojo")
public class OffsetRecordSent {

    @JsonProperty("partition")
    private Integer partition;
    @JsonProperty("offset")
    private Long offset;

    @JsonProperty("partition")
    public Integer getPartition() {
        return partition;
    }

    @JsonProperty("partition")
    public void setPartition(Integer partition) {
        this.partition = partition;
    }

    @JsonProperty("offset")
    public Long getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(Long offset) {
        this.offset = offset;
    }

}
