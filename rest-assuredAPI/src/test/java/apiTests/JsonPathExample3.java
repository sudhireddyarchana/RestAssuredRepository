package apiTests;

import java.io.File;
import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;

public class JsonPathExample3 
{
   public static void main(String[] args) 
   {
	//connect to JSON file
	   File f= new File("src\\test\\resources\\Employees.json");
	   JsonPath jp= new JsonPath(f);
	   //Get count of fields in total response body
	   int x=jp.getInt("size()");
	   System.out.println(x);
	  //Get and display all fields names in total response
	  Map<String,Object>m= jp.getMap("$");
	  System.out.println(m.keySet());
	 //Get count of unnamed JSON objects in "data" field
	  int s=jp.getInt("data.size()");//24
	  System.out.println(s);
	 //Get count of fields in 1st JSON object in "data" field
	  int k=jp.getInt("data[0].size()");//5
	  System.out.println(k);
	 //Get count of fields in last JSON object in "data" field
	 int g= jp.getInt("data[-1].size()");//5
	 System.out.println(g);
	 //Get "status" field value using GPath
	 String st=jp.getString("status");
     System.out.println(st);
     //Get "status" field size using GPath
     int b=jp.getInt("status.length()");//7
     System.out.println(b);
     //Get "message" field value using GPath
     String msg=jp.getString("message");
     System.out.println(msg);
     //Get "employee_name" field value in 1st JSON object of "data"
     String name=jp.getString("data[0].employee_name");
	 System.out.println(name);
	//Get list of all "employee_name" fields values in all JSON objects of "data"
	 List<String>l=jp.getList("data.employee_name");
	 for(int i=0;i<l.size();i++)
	 {
		System.out.print(l.get(i)+","); 
	 }
	 //Get 1st JSON object of "data" 
	 Map<String,Object>t=jp.getMap("data[0]");
	 for(String j:t.keySet())
	 {
		 System.out.println(j +" is:"+t.get(j));
	 }
	//get all unnamed JSON objects of "data"
			List<Map<String,Object>> lm1=jp.getList("data");
			for(int i=0;i<lm1.size();i++) //on list
			{
				System.out.println("Employee-"+(i+1));
				System.out.println("------------------");
				for(String k1:lm1.get(i).keySet()) //on map
				{
					System.out.println(k1+" is "+lm1.get(i).get(k1));
				}
			}
   }
}
