package Pojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyPojo3 
{
   //private JAVA properties which match with fields in JSON
   @JsonProperty("name") private String n;
   @JsonProperty("age") private int a;
   @JsonProperty("height") private float h;
   @JsonProperty("location") private List<String> l;
   @JsonProperty("married") private Boolean m;
   @JsonProperty("address") private List<Object> ad;
  //public setter and getter methods
   public void setName(String name)
   {
	   this.n=name;
   }
   public String getName()
   {
	   return(this.n);
   }
   public void setAge(int age)
   {
	   this.a=age;
   }
   public int getAge()
   {
	   return(this.a);
   }
   public void setHeight(Float height)
   {
	   this.h=height;
   }
   public Float getHeight()
   {
	   return(this.h);
   }
   public void setLocation(List<String> location)
   {
	   this.l=location;
   }
   public List<String> getLocation()
   {
	   return(this.l);
   }
   public void setMarried(Boolean status)
   {
	   this.m=status;
   }
   public Boolean getMarried()
   {
	   return(this.m);
   }
   public void setAddress(List<Object> address)
   {
	   this.ad=address;
   }
   public List<Object> getAddress()
   {
	   return(this.ad);
   }
}
