
package org.example.api.beans;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SourceType {

    GCP("GCP");
    private final String value;
    private final static Map<String, SourceType> CONSTANTS = new HashMap<String, SourceType>();

    static {
        for (SourceType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private SourceType(String value) {
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
    public static SourceType fromValue(String value) {
        SourceType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
