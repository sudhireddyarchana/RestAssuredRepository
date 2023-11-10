package pojos;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"eng","msa"})
@Generated("batch263apistudents")
public class MyData5 
{
    @JsonProperty("eng")
    private MyEng e;
    @JsonProperty("msa")
    private MyMsa m;

    @JsonProperty("eng")
    public MyEng getEng()
    {
        return(e);
    }
    @JsonProperty("eng")
    public void setEng(MyEng x)
    {
        this.e=x;
    }

    @JsonProperty("msa")
    public MyMsa getMsa()
    {
        return(m);
    }
    @JsonProperty("msa")
    public void setMsa(MyMsa x)
    {
        this.m=x;
    }
}
