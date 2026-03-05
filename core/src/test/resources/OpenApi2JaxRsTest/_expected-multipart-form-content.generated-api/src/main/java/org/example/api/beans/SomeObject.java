
package org.example.api.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "someList"
})
@Generated("jsonschema2pojo")
public class SomeObject {

    @JsonProperty("someList")
    private List<SomeOtherObject> someList = new ArrayList<SomeOtherObject>();

    @JsonProperty("someList")
    public List<SomeOtherObject> getSomeList() {
        return someList;
    }

    @JsonProperty("someList")
    public void setSomeList(List<SomeOtherObject> someList) {
        this.someList = someList;
    }

}