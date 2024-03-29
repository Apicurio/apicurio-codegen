
package io.apicurio.registry.types;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@io.quarkus.runtime.annotations.RegisterForReflection
public enum ReferenceType {

    OUTBOUND("OUTBOUND"),
    INBOUND("INBOUND");
    private final String value;
    private final static Map<String, ReferenceType> CONSTANTS = new HashMap<String, ReferenceType>();

    static {
        for (ReferenceType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private ReferenceType(String value) {
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
    public static ReferenceType fromValue(String value) {
        ReferenceType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
