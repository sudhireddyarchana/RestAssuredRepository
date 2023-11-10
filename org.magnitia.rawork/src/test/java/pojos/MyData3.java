package pojos;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name","age"})
@Generated("batch263apistudents")
public class MyData3 
{
    @JsonProperty("name")
    private String n;
    
    @JsonProperty("age")
    private Integer a;

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

    @JsonProperty("age")
    public Integer getAge()
    {
        return(a);
    }

    @JsonProperty("age")
    public void setAge(Integer x)
    {
        this.a=x;
    }
}
