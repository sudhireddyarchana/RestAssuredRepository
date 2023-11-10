package pojos;

import java.util.List;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"cars","ITR"})
@Generated("batch263apistudents")
public class MyMsa
{
    @JsonProperty("cars")
    private List<String> c;
    @JsonProperty("ITR")
    private Boolean i;

    @JsonProperty("cars")
    public List<String> getCars()
    {
        return(c);
    }
    @JsonProperty("cars")
    public void setCars(List<String> x)
    {
        this.c=x;
    }

    @JsonProperty("ITR")
    public Boolean getItr()
    {
        return(i);
    }
    @JsonProperty("ITR")
    public void setItr(Boolean x)
    {
        this.i=x;
    }
}
