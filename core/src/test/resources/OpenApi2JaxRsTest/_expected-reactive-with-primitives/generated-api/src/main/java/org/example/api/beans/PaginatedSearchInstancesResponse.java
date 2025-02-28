
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * PaginatedSearchInstancesResponse
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "next_page_offset",
    "instances",
    "total_count"
})
@Generated("jsonschema2pojo")
public class PaginatedSearchInstancesResponse {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("next_page_offset")
    private Integer nextPageOffset;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("instances")
    private List<CuratedInstance> instances = new ArrayList<CuratedInstance>();
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("total_count")
    private Long totalCount;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("next_page_offset")
    public Integer getNextPageOffset() {
        return nextPageOffset;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("next_page_offset")
    public void setNextPageOffset(Integer nextPageOffset) {
        this.nextPageOffset = nextPageOffset;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("instances")
    public List<CuratedInstance> getInstances() {
        return instances;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("instances")
    public void setInstances(List<CuratedInstance> instances) {
        this.instances = instances;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("total_count")
    public Long getTotalCount() {
        return totalCount;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("total_count")
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

}
