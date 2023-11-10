package pojos;


import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"official","common"})
@Generated("batch263apistudents")
public class MyEng
{
    @JsonProperty("official")
    private String o;
    
    @JsonProperty("common")
    private Object c;

    @JsonProperty("official")
    public String getOfficial()
    {
        return(o);
    }
    @JsonProperty("official")
    public void setOfficial(String x)
    {
        this.o=x;
    }

    @JsonProperty("common")
    public Object getCommon() 
    {
        return(c);
    }
    @JsonProperty("common")
    public void setCommon(Object x)
    {
        this.c=x;
    }
}
