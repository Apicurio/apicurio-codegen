
package org.example.api.beans;

import java.util.Date;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "mylong",
    "myint",
    "mydate",
    "mymap",
    "id",
    "mybytearray",
    "mysimpleap",
    "mystructuredap"
})
@Generated("jsonschema2pojo")
public class SampleDataType {

    @JsonProperty("name")
    private String name;
    @JsonProperty("mylong")
    private Long mylong;
    @JsonProperty("myint")
    private Integer myint;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    @JsonProperty("mydate")
    private Date mydate;
    @JsonProperty("mymap")
    private Map<String, Object> mymap;
    /**
     *
     */
    @JsonProperty("id")
    @JsonPropertyDescription("")
    private String id;
    @JsonProperty("mybytearray")
    private byte[] mybytearray;
    @JsonProperty("mysimpleap")
    private MySimpleAdditionalProperties mysimpleap;
    @JsonProperty("mystructuredap")
    private MyStructuredAdditionalProperties mystructuredap;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("mylong")
    public Long getMylong() {
        return mylong;
    }

    @JsonProperty("mylong")
    public void setMylong(Long mylong) {
        this.mylong = mylong;
    }

    @JsonProperty("myint")
    public Integer getMyint() {
        return myint;
    }

    @JsonProperty("myint")
    public void setMyint(Integer myint) {
        this.myint = myint;
    }

    @JsonProperty("mydate")
    public Date getMydate() {
        return mydate;
    }

    @JsonProperty("mydate")
    public void setMydate(Date mydate) {
        this.mydate = mydate;
    }

    @JsonProperty("mymap")
    public Map<String, Object> getMymap() {
        return mymap;
    }

    @JsonProperty("mymap")
    public void setMymap(Map<String, Object> mymap) {
        this.mymap = mymap;
    }

    /**
     *
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     *
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("mybytearray")
    public byte[] getMybytearray() {
        return mybytearray;
    }

    @JsonProperty("mybytearray")
    public void setMybytearray(byte[] mybytearray) {
        this.mybytearray = mybytearray;
    }

    @JsonProperty("mysimpleap")
    public MySimpleAdditionalProperties getMysimpleap() {
        return mysimpleap;
    }

    @JsonProperty("mysimpleap")
    public void setMysimpleap(MySimpleAdditionalProperties mysimpleap) {
        this.mysimpleap = mysimpleap;
    }

    @JsonProperty("mystructuredap")
    public MyStructuredAdditionalProperties getMystructuredap() {
        return mystructuredap;
    }

    @JsonProperty("mystructuredap")
    public void setMystructuredap(MyStructuredAdditionalProperties mystructuredap) {
        this.mystructuredap = mystructuredap;
    }

}