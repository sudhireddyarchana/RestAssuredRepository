package pojos;

import java.util.ArrayList;

import javax.annotation.processing.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"data1","data2","data3","data4","data5"})
@Generated("batch263apistudents")
public class MyMainpojo 
{
    @JsonProperty("data1")
    private String d1;
    @JsonProperty("data2")
    private ArrayList<Object> d2;
    @JsonProperty("data3")
    private MyData3 d3;
    @JsonProperty("data4")
    private ArrayList<MyData4> d4;
    @JsonProperty("data5")
    private MyData5 d5; 

    @JsonProperty("data1")
    public String getData1() 
    {
        return(d1);
    }
    @JsonProperty("data1")
    public void setData1(String data1) 
    {
        this.d1=data1;
    }

    @JsonProperty("data2")
    public ArrayList<Object> getData2() 
    {
        return(d2);
    }
    @JsonProperty("data2")
    public void setData2(ArrayList<Object> data2)
    {
        this.d2=data2;
    }

    @JsonProperty("data3")
    public MyData3 getData3()
    {
        return(d3);
    }
    @JsonProperty("data3")
    public void setData3(MyData3 data3)
    {
        this.d3=data3;
    }

    @JsonProperty("data4")
    public ArrayList<MyData4> getData4() 
    {
        return(d4);
    }
    @JsonProperty("data4")
    public void setData4(ArrayList<MyData4> data4)
    {
        this.d4=data4;
    }

    @JsonProperty("data5")
    public MyData5 getData5()
    {
        return(d5);
    }
    @JsonProperty("data5")
    public void setData5(MyData5 x) 
    {
        this.d5=x;
    }
}
