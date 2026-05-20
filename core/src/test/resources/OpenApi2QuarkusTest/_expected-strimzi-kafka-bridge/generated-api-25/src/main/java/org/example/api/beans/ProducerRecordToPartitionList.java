
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ProducerRecordToPartitionList
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "records"
})
@Generated("jsonschema2pojo")
public class ProducerRecordToPartitionList {

    @JsonProperty("records")
    private List<ProducerRecordToPartition> records = new ArrayList<ProducerRecordToPartition>();

    @JsonProperty("records")
    public List<ProducerRecordToPartition> getRecords() {
        return records;
    }

    @JsonProperty("records")
    public void setRecords(List<ProducerRecordToPartition> records) {
        this.records = records;
    }

}
