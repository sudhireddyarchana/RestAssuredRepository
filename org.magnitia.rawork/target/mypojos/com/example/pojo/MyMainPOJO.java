
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
    "data1",
    "data2",
    "data3",
    "data4",
    "data5"
})
@Generated("jsonschema2pojo")
public class MyMainPOJO {

    @JsonProperty("data1")
    private String data1;
    @JsonProperty("data2")
    private List<String> data2 = new ArrayList<String>();
    @JsonProperty("data3")
    private Data3 data3;
    @JsonProperty("data4")
    private List<Data4> data4 = new ArrayList<Data4>();
    @JsonProperty("data5")
    private Data5 data5;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("data1")
    public String getData1() {
        return data1;
    }

    @JsonProperty("data1")
    public void setData1(String data1) {
        this.data1 = data1;
    }

    public MyMainPOJO withData1(String data1) {
        this.data1 = data1;
        return this;
    }

    @JsonProperty("data2")
    public List<String> getData2() {
        return data2;
    }

    @JsonProperty("data2")
    public void setData2(List<String> data2) {
        this.data2 = data2;
    }

    public MyMainPOJO withData2(List<String> data2) {
        this.data2 = data2;
        return this;
    }

    @JsonProperty("data3")
    public Data3 getData3() {
        return data3;
    }

    @JsonProperty("data3")
    public void setData3(Data3 data3) {
        this.data3 = data3;
    }

    public MyMainPOJO withData3(Data3 data3) {
        this.data3 = data3;
        return this;
    }

    @JsonProperty("data4")
    public List<Data4> getData4() {
        return data4;
    }

    @JsonProperty("data4")
    public void setData4(List<Data4> data4) {
        this.data4 = data4;
    }

    public MyMainPOJO withData4(List<Data4> data4) {
        this.data4 = data4;
        return this;
    }

    @JsonProperty("data5")
    public Data5 getData5() {
        return data5;
    }

    @JsonProperty("data5")
    public void setData5(Data5 data5) {
        this.data5 = data5;
    }

    public MyMainPOJO withData5(Data5 data5) {
        this.data5 = data5;
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

    public MyMainPOJO withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MyMainPOJO.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("data1");
        sb.append('=');
        sb.append(((this.data1 == null)?"<null>":this.data1));
        sb.append(',');
        sb.append("data2");
        sb.append('=');
        sb.append(((this.data2 == null)?"<null>":this.data2));
        sb.append(',');
        sb.append("data3");
        sb.append('=');
        sb.append(((this.data3 == null)?"<null>":this.data3));
        sb.append(',');
        sb.append("data4");
        sb.append('=');
        sb.append(((this.data4 == null)?"<null>":this.data4));
        sb.append(',');
        sb.append("data5");
        sb.append('=');
        sb.append(((this.data5 == null)?"<null>":this.data5));
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
        result = ((result* 31)+((this.data5 == null)? 0 :this.data5 .hashCode()));
        result = ((result* 31)+((this.data4 == null)? 0 :this.data4 .hashCode()));
        result = ((result* 31)+((this.data3 == null)? 0 :this.data3 .hashCode()));
        result = ((result* 31)+((this.data2 == null)? 0 :this.data2 .hashCode()));
        result = ((result* 31)+((this.data1 == null)? 0 :this.data1 .hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MyMainPOJO) == false) {
            return false;
        }
        MyMainPOJO rhs = ((MyMainPOJO) other);
        return (((((((this.data5 == rhs.data5)||((this.data5 != null)&&this.data5 .equals(rhs.data5)))&&((this.data4 == rhs.data4)||((this.data4 != null)&&this.data4 .equals(rhs.data4))))&&((this.data3 == rhs.data3)||((this.data3 != null)&&this.data3 .equals(rhs.data3))))&&((this.data2 == rhs.data2)||((this.data2 != null)&&this.data2 .equals(rhs.data2))))&&((this.data1 == rhs.data1)||((this.data1 != null)&&this.data1 .equals(rhs.data1))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
