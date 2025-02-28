
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 *
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "source",
    "facts",
    "metadata"
})
@Generated("jsonschema2pojo")
public class Instance {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("name")
    private String name;
    /**
     *
     * <p>
     *
     * (Required)
     *
     */
    @JsonProperty("source")
    private Source source;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("facts")
    private Facts facts;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("metadata")
    private Metadata metadata;

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
     * <p>
     *
     * (Required)
     *
     */
    @JsonProperty("source")
    public Source getSource() {
        return source;
    }

    /**
     *
     * <p>
     *
     * (Required)
     *
     */
    @JsonProperty("source")
    public void setSource(Source source) {
        this.source = source;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("facts")
    public Facts getFacts() {
        return facts;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("facts")
    public void setFacts(Facts facts) {
        this.facts = facts;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}
