
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Topics
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "topics",
    "topic_pattern"
})
@Generated("jsonschema2pojo")
public class Topics {

    @JsonProperty("topics")
    private List<String> topics = new ArrayList<String>();
    /**
     * A regex topic pattern for matching multiple topics
     * 
     */
    @JsonProperty("topic_pattern")
    @JsonPropertyDescription("A regex topic pattern for matching multiple topics")
    private String topicPattern;

    @JsonProperty("topics")
    public List<String> getTopics() {
        return topics;
    }

    @JsonProperty("topics")
    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    /**
     * A regex topic pattern for matching multiple topics
     * 
     */
    @JsonProperty("topic_pattern")
    public String getTopicPattern() {
        return topicPattern;
    }

    /**
     * A regex topic pattern for matching multiple topics
     * 
     */
    @JsonProperty("topic_pattern")
    public void setTopicPattern(String topicPattern) {
        this.topicPattern = topicPattern;
    }

}
