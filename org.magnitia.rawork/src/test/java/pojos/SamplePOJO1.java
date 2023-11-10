package pojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SamplePOJO1 
{
	//private JAVA properties which match with fields in JSON
	@JsonProperty("name") private String n; 
	@JsonProperty("age") private int a;
	@JsonProperty("height") private float h;
	@JsonProperty("location") private List<String> l;
	@JsonProperty("married") private boolean m;
	@JsonProperty("address") private List<Object> ad;
	//public setter and getter methods
	public void setName(String x) 
    { 
		 this.n=x; 
	} 
    public String getName()
    { 
		 return(this.n); 
	} 
    public void setAge(int x) 
    { 
		 this.a=x; 
	} 
    public int getAge()
    { 
		 return(this.a); 
	} 
    public void setHeight(float x) 
    { 
		 this.h=x; 
	} 
    public float getHeight()
    { 
		 return(this.h); 
	} 
    public void setLocation(List<String> x) 
    { 
		 this.l=x; 
	} 
    public List<String> getLocation()
    { 
		 return(this.l); 
	} 
    public void setMarried(boolean x) 
    { 
		 this.m=x; 
	} 
    public boolean getMarried()
    { 
		 return(this.m); 
	} 
    public void setAddress(List<Object> x) 
    { 
		 this.ad=x; 
	} 
    public List<Object> getAddress()
    { 
		 return(this.ad); 
	} 
}
