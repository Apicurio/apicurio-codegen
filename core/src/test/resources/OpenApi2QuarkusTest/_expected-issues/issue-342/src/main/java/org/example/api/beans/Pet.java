
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
    private String name;
    /**
     * Pet's species
     * (Required)
     *
     */
    @JsonProperty("species")
    @JsonPropertyDescription("Pet's species")
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

}