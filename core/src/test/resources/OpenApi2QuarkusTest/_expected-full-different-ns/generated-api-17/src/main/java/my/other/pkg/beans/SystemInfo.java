
package my.other.pkg.beans;

import java.util.Date;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Root Type for SystemInfo
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "description",
    "version",
    "builtOn"
})
@Generated("jsonschema2pojo")
@io.quarkus.runtime.annotations.RegisterForReflection
@lombok.experimental.SuperBuilder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString(callSuper = true)
public class SystemInfo {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("version")
    private String version;
    @JsonProperty("builtOn")
    private Date builtOn;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("builtOn")
    public Date getBuiltOn() {
        return builtOn;
    }

    @JsonProperty("builtOn")
    public void setBuiltOn(Date builtOn) {
        this.builtOn = builtOn;
    }

}
