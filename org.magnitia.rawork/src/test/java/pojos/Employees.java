package pojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employees 
{
	//All fields as private properties
	@JsonProperty("status") private String s;
	@JsonProperty("data") private List<Employee> d;
	@JsonProperty("message") private String msg;
	
	//public setters and getters
	public void setStatus(String x)
	{ 
		this.s=x; 
	} 
	public String getStatus()
	{
		return(this.s);
	}
	    
	public void setData(List<Employee> x)   
	{ 
		this.d=x; 
	} 
	public List<Employee> getData()
	{
		return(this.d);
	}
	   
	public void setMessage(String x) 
	{ 
		this.msg=x; 
	} 
	public String getMessage()
	{
		return(this.msg);
	}
}
