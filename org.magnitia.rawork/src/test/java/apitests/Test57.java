package apitests;

import java.io.File;

import io.restassured.path.json.JsonPath;

public class Test57 
{
	public static void main(String[] args) throws Exception
	{
		File f=new File("src\\test\\resources\\jsonpayload.json");
		JsonPath jp=new JsonPath(f);
		//get 2nd car
		System.out.println(jp.getString("data5.msa.cars[1]"));
		//get height of 1st json object in data4
		try
		{
			System.out.println(jp.getFloat("data4[1].height"));
		}
		catch(Exception ex)
		{
			System.out.println("no height");
		}
		//get all names in data4
		System.out.println(jp.getList("data4.name"));
	}
}







