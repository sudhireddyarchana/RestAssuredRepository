package apitests;

import java.io.File;
import java.util.List;

import io.restassured.path.json.JsonPath;
import pojos.SamplePOJO1;

public class Test51
{
	public static void main(String[] args)
	{
		//Connect to a JSON file
		File f=new File("src\\test\\resources\\samplejson1.json");
		JsonPath jp=new JsonPath(f);
		//access JSON content into POJO class's object to de-serialize values
		SamplePOJO1 obj=jp.getObject("$",SamplePOJO1.class); 
		System.out.println(obj.getLocation().get(2));
		List<Object> l=obj.getAddress();
		System.out.println(l.get(l.size()-1)); //last value of array
        
	}

}
