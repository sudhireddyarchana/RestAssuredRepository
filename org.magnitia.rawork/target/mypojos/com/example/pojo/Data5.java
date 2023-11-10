
package com.example.pojo;

import java.util.HashMap;
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
    "eng",
    "msa"
})
@Generated("jsonschema2pojo")
public class Data5 {

    @JsonProperty("eng")
    private Eng eng;
    @JsonProperty("msa")
    private Msa msa;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("eng")
    public Eng getEng() {
        return eng;
    }

    @JsonProperty("eng")
    public void setEng(Eng eng) {
        this.eng = eng;
    }

    public Data5 withEng(Eng eng) {
        this.eng = eng;
        return this;
    }

    @JsonProperty("msa")
    public Msa getMsa() {
        return msa;
    }

    @JsonProperty("msa")
    public void setMsa(Msa msa) {
        this.msa = msa;
    }

    public Data5 withMsa(Msa msa) {
        this.msa = msa;
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

    public Data5 withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Data5 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("eng");
        sb.append('=');
        sb.append(((this.eng == null)?"<null>":this.eng));
        sb.append(',');
        sb.append("msa");
        sb.append('=');
        sb.append(((this.msa == null)?"<null>":this.msa));
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
        result = ((result* 31)+((this.msa == null)? 0 :this.msa.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.eng == null)? 0 :this.eng.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data5) == false) {
            return false;
        }
        Data5 rhs = ((Data5) other);
        return ((((this.msa == rhs.msa)||((this.msa!= null)&&this.msa.equals(rhs.msa)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.eng == rhs.eng)||((this.eng!= null)&&this.eng.equals(rhs.eng))));
    }

}
