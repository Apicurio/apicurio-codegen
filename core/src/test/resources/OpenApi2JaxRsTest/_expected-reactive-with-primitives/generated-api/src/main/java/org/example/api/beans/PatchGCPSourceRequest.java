
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * PatchGCPSourceRequest
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "gather_facts_on_ingest"
})
@Generated("jsonschema2pojo")
public class PatchGCPSourceRequest {

    @JsonProperty("name")
    private String name;
    @JsonProperty("gather_facts_on_ingest")
    private Boolean gatherFactsOnIngest;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("gather_facts_on_ingest")
    public Boolean getGatherFactsOnIngest() {
        return gatherFactsOnIngest;
    }

    @JsonProperty("gather_facts_on_ingest")
    public void setGatherFactsOnIngest(Boolean gatherFactsOnIngest) {
        this.gatherFactsOnIngest = gatherFactsOnIngest;
    }

}
