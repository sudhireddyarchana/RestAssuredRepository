package pojos;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({"name","weight","height"})
@Generated("batch263apistudents")
public class MyData4 
{
    @JsonProperty("name")
    private String n;
    @JsonProperty("weight")
    private Integer w;

    @JsonProperty("height")
    private Float h;

    @JsonProperty("name")
    public String getName() 
    {
        return(n);
    }
    @JsonProperty("name")
    public void setName(String x) 
    {
        this.n=x;
    }

    @JsonProperty("weight")
    public Integer getWeight()
    {
        return(w);
    }
    @JsonProperty("weight")
    public void setWeight(Integer x)
    {
        this.w=x;
    }

    @JsonProperty("height")
    public Float getHeight()
    {
        return(h);
    }
    @JsonProperty("height")
    public void setHeight(Float x)
    {
        this.h=x;
    }
}
