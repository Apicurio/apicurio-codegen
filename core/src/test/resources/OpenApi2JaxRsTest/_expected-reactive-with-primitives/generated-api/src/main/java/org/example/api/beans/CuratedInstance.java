
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
    "id",
    "source",
    "creation_time",
    "internal_ip",
    "external_ip",
    "operating_system",
    "machine_type",
    "node_status",
    "uptime",
    "zone"
})
@Generated("jsonschema2pojo")
public class CuratedInstance {

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
    @JsonProperty("id")
    private String id;
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
    @JsonProperty("creation_time")
    private Long creationTime;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("internal_ip")
    private String internalIp;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("external_ip")
    private String externalIp;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("operating_system")
    private String operatingSystem;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("machine_type")
    private String machineType;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("node_status")
    private String nodeStatus;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("uptime")
    private Long uptime;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("zone")
    private String zone;

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
    @JsonProperty("creation_time")
    public Long getCreationTime() {
        return creationTime;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("creation_time")
    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("internal_ip")
    public String getInternalIp() {
        return internalIp;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("internal_ip")
    public void setInternalIp(String internalIp) {
        this.internalIp = internalIp;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("external_ip")
    public String getExternalIp() {
        return externalIp;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("external_ip")
    public void setExternalIp(String externalIp) {
        this.externalIp = externalIp;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("operating_system")
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("operating_system")
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("machine_type")
    public String getMachineType() {
        return machineType;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("machine_type")
    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("node_status")
    public String getNodeStatus() {
        return nodeStatus;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("node_status")
    public void setNodeStatus(String nodeStatus) {
        this.nodeStatus = nodeStatus;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("uptime")
    public Long getUptime() {
        return uptime;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("uptime")
    public void setUptime(Long uptime) {
        this.uptime = uptime;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

}
