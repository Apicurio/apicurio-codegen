
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ProducerRecordList
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "records"
})
@Generated("jsonschema2pojo")
public class ProducerRecordList {

    @JsonProperty("records")
    private List<ProducerRecord> records = new ArrayList<ProducerRecord>();

    @JsonProperty("records")
    public List<ProducerRecord> getRecords() {
        return records;
    }

    @JsonProperty("records")
    public void setRecords(List<ProducerRecord> records) {
        this.records = records;
    }

}
