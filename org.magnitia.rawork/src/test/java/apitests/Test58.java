package apitests;

import java.io.File;

import io.restassured.path.json.JsonPath;
import pojos.MyMainpojo;

public class Test58
{
	public static void main(String[] args)
	{
		//File payload schema testing
		File f=new File("src\\test\\resources\\jsonpayload.json");
		JsonPath jp=new JsonPath(f); 
		try
		{
			MyMainpojo obj=jp.getObject("$",MyMainpojo.class); //total payload
			System.out.println("Json Schema validation passed");
		}
		catch(Exception ex)
		{
			System.out.println("Json Schema validation failed");
			System.out.println(ex.getMessage());
		}
	}
}
