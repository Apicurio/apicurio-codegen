
package org.example.api.beans;

import java.util.UUID;
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
    "id",
    "name",
    "last_synced",
    "instance_count",
    "credentials_id",
    "type"
})
@Generated("jsonschema2pojo")
public class Source {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("id")
    private String id;
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
    @JsonProperty("last_synced")
    private Long lastSynced;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("instance_count")
    private Integer instanceCount;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("credentials_id")
    private UUID credentialsId;
    /**
     * SourceType
     * <p>
     *
     * (Required)
     *
     */
    @JsonProperty("type")
    private SourceType type;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

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
    @JsonProperty("last_synced")
    public Long getLastSynced() {
        return lastSynced;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("last_synced")
    public void setLastSynced(Long lastSynced) {
        this.lastSynced = lastSynced;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("instance_count")
    public Integer getInstanceCount() {
        return instanceCount;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("instance_count")
    public void setInstanceCount(Integer instanceCount) {
        this.instanceCount = instanceCount;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("credentials_id")
    public UUID getCredentialsId() {
        return credentialsId;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("credentials_id")
    public void setCredentialsId(UUID credentialsId) {
        this.credentialsId = credentialsId;
    }

    /**
     * SourceType
     * <p>
     *
     * (Required)
     *
     */
    @JsonProperty("type")
    public SourceType getType() {
        return type;
    }

    /**
     * SourceType
     * <p>
     *
     * (Required)
     *
     */
    @JsonProperty("type")
    public void setType(SourceType type) {
        this.type = type;
    }

}
