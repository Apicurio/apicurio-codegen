package io.apicurio.hub.api.codegen.beans;

import java.util.Objects;

public class CodegenJavaSchema {

    private String collection;
    private String type;
    private String format;
    private String constant;
    private Number maximum;
    private Boolean exclusiveMaximum;
    private Number minimum;
    private Boolean exclusiveMinimum;
    private Long maxLength;
    private Long minLength;
    private String pattern;
    private Long maxItems;
    private Long minItems;
    private Boolean uniqueItems;
    private Long maxProperties;
    private Long minProperties;
    private Boolean nullable;
    private String defaultValue;

    @Override
    public int hashCode() {
        return Objects.hash(collection, constant, defaultValue, exclusiveMaximum, exclusiveMinimum, format, maxItems,
                maxLength, maxProperties, maximum, minItems, minLength, minProperties, minimum, nullable, pattern, type,
                uniqueItems);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CodegenJavaSchema other = (CodegenJavaSchema) obj;
        return Objects.equals(collection, other.collection) && Objects.equals(constant, other.constant)
                && Objects.equals(defaultValue, other.defaultValue)
                && Objects.equals(exclusiveMaximum, other.exclusiveMaximum)
                && Objects.equals(exclusiveMinimum, other.exclusiveMinimum) && Objects.equals(format, other.format)
                && Objects.equals(maxItems, other.maxItems) && Objects.equals(maxLength, other.maxLength)
                && Objects.equals(maxProperties, other.maxProperties) && Objects.equals(maximum, other.maximum)
                && Objects.equals(minItems, other.minItems) && Objects.equals(minLength, other.minLength)
                && Objects.equals(minProperties, other.minProperties) && Objects.equals(minimum, other.minimum)
                && Objects.equals(nullable, other.nullable) && Objects.equals(pattern, other.pattern)
                && Objects.equals(type, other.type) && Objects.equals(uniqueItems, other.uniqueItems);
    }

    /**
     * @return the collection
     */
    public String getCollection() {
        return collection;
    }

    /**
     * @param collection the collection to set
     */
    public void setCollection(String collection) {
        this.collection = collection;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * @return the constant
     */
    public String getConstant() {
        return constant;
    }

    /**
     * @param constant the constant to set
     */
    public void setConstant(String constant) {
        this.constant = constant;
    }

    /**
     * @return the maximum
     */
    public Number getMaximum() {
        return maximum;
    }

    /**
     * @param maximum the maximum to set
     */
    public void setMaximum(Number maximum) {
        this.maximum = maximum;
    }

    /**
     * @return the exclusiveMaximum
     */
    public Boolean getExclusiveMaximum() {
        return exclusiveMaximum;
    }

    /**
     * @param exclusiveMaximum the exclusiveMaximum to set
     */
    public void setExclusiveMaximum(Boolean exclusiveMaximum) {
        this.exclusiveMaximum = exclusiveMaximum;
    }

    /**
     * @return the minimum
     */
    public Number getMinimum() {
        return minimum;
    }

    /**
     * @param minimum the minimum to set
     */
    public void setMinimum(Number minimum) {
        this.minimum = minimum;
    }

    /**
     * @return the exclusiveMinimum
     */
    public Boolean getExclusiveMinimum() {
        return exclusiveMinimum;
    }

    /**
     * @param exclusiveMinimum the exclusiveMinimum to set
     */
    public void setExclusiveMinimum(Boolean exclusiveMinimum) {
        this.exclusiveMinimum = exclusiveMinimum;
    }

    /**
     * @return the maxLength
     */
    public Long getMaxLength() {
        return maxLength;
    }

    /**
     * @param maxLength the maxLength to set
     */
    public void setMaxLength(Long maxLength) {
        this.maxLength = maxLength;
    }

    /**
     * @return the minLength
     */
    public Long getMinLength() {
        return minLength;
    }

    /**
     * @param minLength the minLength to set
     */
    public void setMinLength(Long minLength) {
        this.minLength = minLength;
    }

    /**
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * @return the maxItems
     */
    public Long getMaxItems() {
        return maxItems;
    }

    /**
     * @param maxItems the maxItems to set
     */
    public void setMaxItems(Long maxItems) {
        this.maxItems = maxItems;
    }

    /**
     * @return the minItems
     */
    public Long getMinItems() {
        return minItems;
    }

    /**
     * @param minItems the minItems to set
     */
    public void setMinItems(Long minItems) {
        this.minItems = minItems;
    }

    /**
     * @return the uniqueItems
     */
    public Boolean getUniqueItems() {
        return uniqueItems;
    }

    /**
     * @param uniqueItems the uniqueItems to set
     */
    public void setUniqueItems(Boolean uniqueItems) {
        this.uniqueItems = uniqueItems;
    }

    /**
     * @return the maxProperties
     */
    public Long getMaxProperties() {
        return maxProperties;
    }

    /**
     * @param maxProperties the maxProperties to set
     */
    public void setMaxProperties(Long maxProperties) {
        this.maxProperties = maxProperties;
    }

    /**
     * @return the minProperties
     */
    public Long getMinProperties() {
        return minProperties;
    }

    /**
     * @param minProperties the minProperties to set
     */
    public void setMinProperties(Long minProperties) {
        this.minProperties = minProperties;
    }

    /**
     * @return the nullable
     */
    public Boolean getNullable() {
        return nullable;
    }

    /**
     * @param nullable the nullable to set
     */
    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    /**
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @param defaultValue the defaultValue to set
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

}
