
package org.example.api.beans;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusType {

    ACTIVE("ACTIVE"),
    IN_PROGRESS("IN-PROGRESS"),
    NOT_STARTED("NOT-STARTED"),
    RE_OPENED("RE-OPENED"),
    MULTI__DASH("MULTI--DASH"),
    WITHSPACE("WITH SPACE"),
    WITHDOT("WITH.DOT"),
    WITHSYMBOL("WITH@SYMBOL"),
    _123_STARTS_WITH_DIGIT("123-STARTS-WITH-DIGIT");
    private final String value;
    private final static Map<String, StatusType> CONSTANTS = new HashMap<String, StatusType>();

    static {
        for (StatusType c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    private StatusType(String value) {
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
    public static StatusType fromValue(String value) {
        StatusType constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}