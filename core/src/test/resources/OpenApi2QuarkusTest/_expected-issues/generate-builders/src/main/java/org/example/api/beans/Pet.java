
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "species",
    "age"
})
@Generated("jsonschema2pojo")
public class Pet {

    /**
     * Unique identifier for the pet
     *
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Unique identifier for the pet")
    private Integer id;
    /**
     * Pet's name
     * (Required)
     *
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Pet's name")
    @NotNull
    private String name;
    /**
     * Pet's species
     * (Required)
     *
     */
    @JsonProperty("species")
    @JsonPropertyDescription("Pet's species")
    @NotNull
    private String species;
    /**
     * Pet's age in years
     *
     */
    @JsonProperty("age")
    @JsonPropertyDescription("Pet's age in years")
    private Integer age;

    /**
     * Unique identifier for the pet
     *
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Unique identifier for the pet
     *
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    public Pet withId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Pet's name
     * (Required)
     *
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Pet's name
     * (Required)
     *
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Pet withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Pet's species
     * (Required)
     *
     */
    @JsonProperty("species")
    public String getSpecies() {
        return species;
    }

    /**
     * Pet's species
     * (Required)
     *
     */
    @JsonProperty("species")
    public void setSpecies(String species) {
        this.species = species;
    }

    public Pet withSpecies(String species) {
        this.species = species;
        return this;
    }

    /**
     * Pet's age in years
     *
     */
    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    /**
     * Pet's age in years
     *
     */
    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    public Pet withAge(Integer age) {
        this.age = age;
        return this;
    }

}