package apiTests;

import java.io.File;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class JsonPathExample2 
{
	public static void main(String[] args) 
	{
		 //connect to JSON file
		  
		File f=new File("src\\test\\resources\\JsonPayload.json");
		JsonPath jp= new JsonPath(f);
		//get data1 value
		String x=jp.getString("data1");
		System.out.println(x);
		
		//get data3 name value
		String name=jp.getString("data3.name");
		System.out.println("name is:"+name);
		
		//get data4 name value
		
		String y=jp.getString("data4[1].name");
		System.out.println(y);

		//get data5 values
		
		String w=jp.getString("data5.eng.official");
		System.out.println(w);
		String z=jp.getString("data5.msa.cars[1]");
		System.out.println(z);
		List<String> l=jp.getList("data5.msa.cars");
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i));
		}
	}

}
