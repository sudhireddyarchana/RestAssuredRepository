package apiTests;

import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonPathExample5 
{
	public static void main(String[] args) 
	{
		Response res=RestAssured.given() 
	                 .baseUri("https://restcountries.com") 
	                 .basePath("v3.1/all").when().get();
		//res.then().log().all();
		//1. get count of JSON objects in an Array of JSON objects(total response)
  
		int i=res.body().jsonPath().getInt("$.size()");
		System.out.println("count is :"+i);
		
		//2.get total count of fields in 1st country JSON object and display those fields
		
		int x=res.body().jsonPath().getInt("[0].size()");
		System.out.println(x);
		Map<String,Object> map=res.getBody().jsonPath().getMap("[0]");
		for(String k:map.keySet())
		{
		System.out.println(k+":"+map.get(k));	
		}
		System.out.println("Country fields :"+map.keySet());
	    
	
	    //find India and list out the borders
	
	    List<String> borders=res.getBody().jsonPath().getList("find{it.name.common in['INDIA','India','india']}.borders");
	    System.out.println("bordres:"+borders);
	}
}
