
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Partitions
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "partitions"
})
@Generated("jsonschema2pojo")
public class Partitions {

    @JsonProperty("partitions")
    private List<Partition> partitions = new ArrayList<Partition>();

    @JsonProperty("partitions")
    public List<Partition> getPartitions() {
        return partitions;
    }

    @JsonProperty("partitions")
    public void setPartitions(List<Partition> partitions) {
        this.partitions = partitions;
    }

}
