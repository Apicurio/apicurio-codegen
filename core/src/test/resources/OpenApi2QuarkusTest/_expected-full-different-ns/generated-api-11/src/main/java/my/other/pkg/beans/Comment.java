
package my.other.pkg.beans;

import java.util.Date;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Root Type for NewComment
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "value",
    "createdOn",
    "createdBy",
    "commentId"
})
@Generated("jsonschema2pojo")
@io.quarkus.runtime.annotations.RegisterForReflection
@lombok.experimental.SuperBuilder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode
@lombok.ToString(callSuper = true)
public class Comment {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    private String value;
    /**
     * 
     * (Required)
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    @JsonProperty("createdOn")
    private Date createdOn;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("createdBy")
    @JsonPropertyDescription("")
    private String createdBy;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("commentId")
    @JsonPropertyDescription("")
    private String commentId;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("createdOn")
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("createdOn")
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("createdBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("commentId")
    public String getCommentId() {
        return commentId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("commentId")
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

}
