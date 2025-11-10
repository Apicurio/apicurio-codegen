
package org.example.api.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "petId",
    "quantity",
    "shipDate",
    "status",
    "complete"
})
@Generated("jsonschema2pojo")
public class Order {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("petId")
    private Long petId;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    @JsonProperty("shipDate")
    private Date shipDate;
    /**
     * Order Status
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Order Status")
    private Order.Status status;
    @JsonProperty("complete")
    private Boolean complete;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("petId")
    public Long getPetId() {
        return petId;
    }

    @JsonProperty("petId")
    public void setPetId(Long petId) {
        this.petId = petId;
    }

    @JsonProperty("quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("shipDate")
    public Date getShipDate() {
        return shipDate;
    }

    @JsonProperty("shipDate")
    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    /**
     * Order Status
     * 
     */
    @JsonProperty("status")
    public Order.Status getStatus() {
        return status;
    }

    /**
     * Order Status
     * 
     */
    @JsonProperty("status")
    public void setStatus(Order.Status status) {
        this.status = status;
    }

    @JsonProperty("complete")
    public Boolean getComplete() {
        return complete;
    }

    @JsonProperty("complete")
    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public enum Status {

        PLACED("placed"),
        APPROVED("approved"),
        DELIVERED("delivered");
        private final String value;
        private final static Map<String, Order.Status> CONSTANTS = new HashMap<String, Order.Status>();

        static {
            for (Order.Status c: values()) {
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
        public static Order.Status fromValue(String value) {
            Order.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
