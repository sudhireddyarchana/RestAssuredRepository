package apitests;

import java.io.File;
import java.util.List;

import io.restassured.path.json.JsonPath;
import pojos.Employees;

public class Test55 
{
	public static void main(String[] args)
	{
		//File payload deserialization using GPath expressions
		File f=new File("src\\test\\resources\\employees.json");
		JsonPath jp=new JsonPath(f); 
		//get status
		System.out.println(jp.getString("status"));
		//get message
		System.out.println(jp.getString("message"));
		//get count of employees in data
		System.out.println(jp.getInt("data.size()"));	
		//Get name of 10th employee
		System.out.println(jp.getString("data[9].employee_name"));	
		//use in-line assertions along with matured GPath expressions
		int x=jp.getInt("data.employee_age.min()");
		String y=jp.getString("data.find{it.employee_age=="+x+"}.employee_name");
		System.out.println(y+" is youngest employee with "+x+" years of age");
		int p=jp.getInt("data.employee_age.max()");
		String q=jp.getString("data.find{it.employee_age=="+p+"}.employee_name");
		System.out.println(q+" is youngest employee with "+p+" years of age");
		int l1=jp.getInt("data.employee_salary.max()");
		System.out.println(l1);
		String l2=jp.getString("data.find{it.employee_salary=="+l1+"}.employee_name");
		System.out.println(l2);
		int l3=jp.getInt("data.employee_salary.min()");
		System.out.println(l3);
		String l4=jp.getString("data.find{it.employee_salary=="+l3+"}.employee_name");
		System.out.println(l4);
	}
}







