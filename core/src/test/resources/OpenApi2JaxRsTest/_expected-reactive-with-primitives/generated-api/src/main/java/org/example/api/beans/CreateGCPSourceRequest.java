
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * CreateGCPSourceRequest
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "gather_facts_on_ingest",
    "credentials"
})
@Generated("jsonschema2pojo")
public class CreateGCPSourceRequest {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("name")
    private String name;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("gather_facts_on_ingest")
    private Boolean gatherFactsOnIngest = true;
    /**
     * GCPCredential
     * <p>
     *
     * (Required)
     *
     */
    @JsonProperty("credentials")
    private GCPCredential credentials;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("gather_facts_on_ingest")
    public Boolean getGatherFactsOnIngest() {
        return gatherFactsOnIngest;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("gather_facts_on_ingest")
    public void setGatherFactsOnIngest(Boolean gatherFactsOnIngest) {
        this.gatherFactsOnIngest = gatherFactsOnIngest;
    }

    /**
     * GCPCredential
     * <p>
     *
     * (Required)
     *
     */
    @JsonProperty("credentials")
    public GCPCredential getCredentials() {
        return credentials;
    }

    /**
     * GCPCredential
     * <p>
     *
     * (Required)
     *
     */
    @JsonProperty("credentials")
    public void setCredentials(GCPCredential credentials) {
        this.credentials = credentials;
    }

}
