
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * PaginatedSearchInstancesRequest
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "filters"
})
@Generated("jsonschema2pojo")
public class PaginatedSearchInstancesRequest {

    @JsonProperty("filters")
    private List<SearchFilter> filters = new ArrayList<SearchFilter>();

    @JsonProperty("filters")
    public List<SearchFilter> getFilters() {
        return filters;
    }

    @JsonProperty("filters")
    public void setFilters(List<SearchFilter> filters) {
        this.filters = filters;
    }

}
