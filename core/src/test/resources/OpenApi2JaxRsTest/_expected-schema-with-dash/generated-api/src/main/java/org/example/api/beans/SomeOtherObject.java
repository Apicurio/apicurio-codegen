
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exampleProperty"
})
@Generated("jsonschema2pojo")
public class SomeOtherObject {

    @JsonProperty("exampleProperty")
    private String exampleProperty;

    @JsonProperty("exampleProperty")
    public String getExampleProperty() {
        return exampleProperty;
    }

    @JsonProperty("exampleProperty")
    public void setExampleProperty(String exampleProperty) {
        this.exampleProperty = exampleProperty;
    }

}
