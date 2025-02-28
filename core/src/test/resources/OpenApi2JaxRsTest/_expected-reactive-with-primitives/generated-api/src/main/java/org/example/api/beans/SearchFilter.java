
package org.example.api.beans;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 *
 * <p>
 *
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "operator",
    "value",
    "type"
})
@Generated("jsonschema2pojo")
public class SearchFilter {

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("key")
    private String key;
    /**
     *
     * (Required)
     *
     */
    @JsonProperty("operator")
    private SearchFilter.Operator operator;
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
    @JsonProperty("type")
    private SearchFilter.Type type;

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("operator")
    public SearchFilter.Operator getOperator() {
        return operator;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("operator")
    public void setOperator(SearchFilter.Operator operator) {
        this.operator = operator;
    }

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
    @JsonProperty("type")
    public SearchFilter.Type getType() {
        return type;
    }

    /**
     *
     * (Required)
     *
     */
    @JsonProperty("type")
    public void setType(SearchFilter.Type type) {
        this.type = type;
    }

    public enum Operator {

        lt("lt"),
        eq("eq"),
        gt("gt"),
        contains("contains"),
        not_contains("not_contains");
        private final String value;
        private final static Map<String, SearchFilter.Operator> CONSTANTS = new HashMap<String, SearchFilter.Operator>();

        static {
            for (SearchFilter.Operator c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Operator(String value) {
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
        public static SearchFilter.Operator fromValue(String value) {
            SearchFilter.Operator constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        GCP_METADATA("GCP_METADATA"),
        FACTS("FACTS"),
        SOURCE("SOURCE"),
        ASSIGNED_POLICY("ASSIGNED_POLICY"),
        NODE("NODE");
        private final String value;
        private final static Map<String, SearchFilter.Type> CONSTANTS = new HashMap<String, SearchFilter.Type>();

        static {
            for (SearchFilter.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Type(String value) {
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
        public static SearchFilter.Type fromValue(String value) {
            SearchFilter.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
