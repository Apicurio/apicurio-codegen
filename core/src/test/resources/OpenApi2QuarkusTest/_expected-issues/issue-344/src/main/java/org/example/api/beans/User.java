
package org.example.api.beans;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "email",
    "age"
})
@Generated("jsonschema2pojo")
public class User {

    /**
     * User ID (optional on creation)
     *
     */
    @JsonProperty("id")
    @JsonPropertyDescription("User ID (optional on creation)")
    private Integer id;
    /**
     * User's full name
     * (Required)
     *
     */
    @JsonProperty("name")
    @JsonPropertyDescription("User's full name")
    @Size(min = 3, max = 50)
    @NotNull
    private String name;
    /**
     * Valid email address
     * (Required)
     *
     */
    @Email
    @JsonProperty("email")
    @JsonPropertyDescription("Valid email address")
    @NotNull
    private String email;
    /**
     * User's age (must be between 0 and 150)
     * (Required)
     *
     */
    @JsonProperty("age")
    @JsonPropertyDescription("User's age (must be between 0 and 150)")
    @DecimalMin("0")
    @DecimalMax("1.5E+2")
    @NotNull
    private Integer age;

    /**
     * User ID (optional on creation)
     *
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * User ID (optional on creation)
     *
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * User's full name
     * (Required)
     *
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * User's full name
     * (Required)
     *
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Valid email address
     * (Required)
     *
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * Valid email address
     * (Required)
     *
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * User's age (must be between 0 and 150)
     * (Required)
     *
     */
    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    /**
     * User's age (must be between 0 and 150)
     * (Required)
     *
     */
    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

}