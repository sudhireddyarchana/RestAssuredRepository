package apitests;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Test43 
{
	@Test
	public void method()
	{
		//Connect to JSON file
		File f=new File("src\\test\\resources\\employees.json");
		JsonPath jp=new JsonPath(f);
		//Analyze response via GPath expressions with JAVA loops and Control statements
		//Get count of fields in total response body
		int s1=jp.getInt("size()"); //3
		System.out.println(s1);
		//Get and display all fields names in total response
		Map<String,Object> m=jp.getMap("$");
		System.out.println(m.keySet());
		//Get count of unnamed JSON objects in "data" field
		int s2=jp.getInt("data.size()"); //24
		System.out.println(s2);
		//Get count of fields in 1st JSON object in "data" field
		int s3=jp.getInt("data[0].size()"); //5
		System.out.println(s3);
		//Get count of fields in last JSON object in "data" field
		int s4=jp.getInt("data[-1].size()"); //5
		System.out.println(s4);
		//Get "status" field value using GPath
		String x=jp.getString("status");
		System.out.println(x);
		//Get "status" field value length using GPath
		String len=jp.getString("status.length()");
		System.out.println(len);
		//Get "message" field value using GPath
		String y=jp.getString("message");
		System.out.println(y);
		//Get "employee_name" field value in 1st JSON object of "data"
		String z=jp.getString("data[0].employee_name");
		System.out.println(z);
		//Get list of all "employee_name" fields values in all JSON objects of "data"
		List<String> l=jp.getList("data.employee_name");
		for(int i=0;i<l.size();i++)
		{
			System.out.print(l.get(i)+","); //display in one line
		}
		System.out.println();
		//Get "employee_name" field value in last JSON object of "data"
		String w=jp.getString("data[-1].employee_name");
		System.out.println(w);
		//Get 1st JSON object of "data" 
		Map<String,Object> m1=jp.getMap("data[0]");
		for(String k:m1.keySet())
		{
			System.out.println(k+" is "+m1.get(k));
		}
		//get all unnamed JSON objects of "data"
		List<Map<String,Object>> lm1=jp.getList("data");
		for(int i=0;i<lm1.size();i++) //on list
		{
			System.out.println("Employee-"+(i+1));
			System.out.println("------------------");
			for(String k:lm1.get(i).keySet()) //on map
			{
				System.out.println(k+" is "+lm1.get(i).get(k));
			}
		}
		//Advanced GPath expressions
		//Get specific value using a "find" in GPath
		String p=jp.getString("data.find{it.id==1}.employee_name");
		System.out.println(p);
		String q=jp.getString("data.find{it.id==1 && it.employee_age==61}.employee_name");
		System.out.println(q);
		String r=jp.getString(
	             "data.find{it.id==1 || it.employee_name=='Tiger Nixon'}.employee_salary");
		System.out.println(r);
		//Get list of values using a "findAll" in GPath
		List<String> el1=jp.getList(
				                 "data.findAll{it.employee_salary>=300000}.employee_name");
		for(int i=0;i<el1.size();i++)
		{
			System.out.print(el1.get(i)+","); //display in one line
		}
		System.out.println();
		List<String> el2=jp.getList(
             "data.findAll{it.employee_salary>=300000 && it.employee_age>=60}.employee_name");
		for(int i=0;i<el2.size();i++)
		{
			System.out.print(el2.get(i)+","); //display in one line
		}
		System.out.println();
		//Get a JSON Object using "find" in GPath
		Map<String,Object> m2=jp.getMap("data.find{it.id==1}");
		for(String k:m2.keySet())
		{
			System.out.println(k+":"+m2.get(k));
		}
		//get multiple JSON Objects using "findAll" in GPath
		List<Map<String,Object>> lm2=jp.getList(
				"data.findAll{it.employee_salary>=300000 && it.employee_age>=60}");
		for(int i=0;i<lm2.size();i++) //for list
		{
			System.out.println("Matched Employee-"+(i+1));
			System.out.println("------------------"); //for map
			for(String k:lm2.get(i).keySet())
			{
				System.out.println(k+" is "+lm2.get(i).get(k));
			}
		}
	}
}
