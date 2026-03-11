
package org.example.api.beans;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "status"
})
@Generated("jsonschema2pojo")
@jakarta.enterprise.context.ApplicationScoped
@lombok.ToString(callSuper=true, includeFieldNames=true)
public class BeanWithInlineEnum {

    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    private BeanWithInlineEnum.Status status;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("status")
    public BeanWithInlineEnum.Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(BeanWithInlineEnum.Status status) {
        this.status = status;
    }

    public enum Status {

        ACTIVE("ACTIVE"),
        INACTIVE("INACTIVE");
        private final String value;
        private final static Map<String, BeanWithInlineEnum.Status> CONSTANTS = new HashMap<String, BeanWithInlineEnum.Status>();

        static {
            for (BeanWithInlineEnum.Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Status(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static BeanWithInlineEnum.Status fromValue(String value) {
            BeanWithInlineEnum.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
