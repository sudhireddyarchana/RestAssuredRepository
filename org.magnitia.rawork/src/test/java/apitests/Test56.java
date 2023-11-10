package apitests;

import java.io.File;

import io.restassured.path.json.JsonPath;
import pojos.MyMainpojo;

public class Test56 
{
	public static void main(String[] args)
	{
		File f=new File("src\\test\\resources\\jsonpayload.json");
		JsonPath jp=new JsonPath(f);
		MyMainpojo obj=jp.getObject("$",MyMainpojo.class);
		//get 2nd car
		System.out.println(obj.getData5().getMsa().getCars().get(1));
		//get height of 1st json object in data4
		System.out.println(obj.getData4().get(0).getHeight());
		//get all names in data4
		for(int i=0;i<obj.getData4().size();i++)
		{
			System.out.println(obj.getData4().get(i).getName());
		}
	}
}







