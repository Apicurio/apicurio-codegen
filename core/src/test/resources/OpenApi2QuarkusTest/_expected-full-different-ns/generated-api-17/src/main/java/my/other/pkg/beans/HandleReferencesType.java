
package my.other.pkg.beans;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@io.quarkus.runtime.annotations.RegisterForReflection
public enum HandleReferencesType {

    PRESERVE("PRESERVE"),
    DEREFERENCE("DEREFERENCE"),
    REWRITE("REWRITE");
    private final String value;
    private final static Map<String, HandleReferencesType> CONSTANTS = new HashMap<String, HandleReferencesType>();

    static {
        for (HandleReferencesType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private HandleReferencesType(String value) {
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
    public static HandleReferencesType fromValue(String value) {
        HandleReferencesType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
