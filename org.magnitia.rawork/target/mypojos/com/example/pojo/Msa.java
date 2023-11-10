
package com.example.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cars",
    "ITR"
})
@Generated("jsonschema2pojo")
public class Msa {

    @JsonProperty("cars")
    private List<String> cars = new ArrayList<String>();
    @JsonProperty("ITR")
    private Boolean itr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cars")
    public List<String> getCars() {
        return cars;
    }

    @JsonProperty("cars")
    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public Msa withCars(List<String> cars) {
        this.cars = cars;
        return this;
    }

    @JsonProperty("ITR")
    public Boolean getItr() {
        return itr;
    }

    @JsonProperty("ITR")
    public void setItr(Boolean itr) {
        this.itr = itr;
    }

    public Msa withItr(Boolean itr) {
        this.itr = itr;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Msa withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Msa.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cars");
        sb.append('=');
        sb.append(((this.cars == null)?"<null>":this.cars));
        sb.append(',');
        sb.append("itr");
        sb.append('=');
        sb.append(((this.itr == null)?"<null>":this.itr));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.cars == null)? 0 :this.cars.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.itr == null)? 0 :this.itr.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Msa) == false) {
            return false;
        }
        Msa rhs = ((Msa) other);
        return ((((this.cars == rhs.cars)||((this.cars!= null)&&this.cars.equals(rhs.cars)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.itr == rhs.itr)||((this.itr!= null)&&this.itr.equals(rhs.itr))));
    }

}
