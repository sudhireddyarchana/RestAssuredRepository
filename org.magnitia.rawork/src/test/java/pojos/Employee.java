package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee 
{
	//All fields as private properties
	@JsonProperty("id") private int id;
	@JsonProperty("employee_name") private String en;
	@JsonProperty("employee_salary") private long sal;
	@JsonProperty("employee_age") private int age;
	@JsonProperty("profile_image") private String img;

	//public setters and getters
	public void setId(int x)
	{ 
		this.id=x; 
	} 
	public int getId()
	{
		return(this.id);
	}
	    
	public void setEmpName(String x)   
	{ 
		this.en=x; 
	} 
	public String getEmpName()
	{
		return(this.en);
	}
	   
	public void setEmpSal(long x) 
	{ 
		this.sal=x; 
	} 
	public long getEmpSal()
	{
		return(this.sal);
	}  
	
	public void setEmpAge(int x)
	{ 
		this.age=x; 
	} 
	public int getEmpAge()
	{
		return(this.age);
	}
	
	public void setEmpProfileImg(String x)   
	{ 
		this.img=x; 
	} 
	public String getEmpProfileImg()
	{
		return(this.img);
	}    
}
