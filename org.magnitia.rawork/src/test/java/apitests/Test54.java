package apitests;

import java.io.File;

import io.restassured.path.json.JsonPath;
import pojos.Employees;

public class Test54 
{
	public static void main(String[] args)
	{
		//File payload deserialization using POJO class object and getters
		File f=new File("src\\test\\resources\\employees.json");
		JsonPath jp=new JsonPath(f); 
		Employees obj=jp.getObject("$",Employees.class); //total payload in file
		//get status
		System.out.println(obj.getStatus());	
		//get message
		System.out.println(obj.getMessage());
		//get count of employees in data
		System.out.println(obj.getData().size());	
		//Get name of 10th employee
		System.out.println(obj.getData().get(9).getEmpName());	
		//use "if" conditions and "loops" along with TestNG assertions 
		//get youngest employee name
		int minage=obj.getData().get(0).getEmpAge();
		String enma=obj.getData().get(0).getEmpName();
		for(int i=1;i<obj.getData().size();i++)
		{
			if(minage>obj.getData().get(i).getEmpAge())
			{
				minage=obj.getData().get(i).getEmpAge();
				enma=obj.getData().get(i).getEmpName();
			}
		}
		System.out.println(enma+" is youngest employee with "+minage+" years of age");
		//get oldest employee name
		int maxage=obj.getData().get(0).getEmpAge();
		String enmax=obj.getData().get(0).getEmpName();
		for(int i=1;i<obj.getData().size();i++)
		{
			if(maxage<obj.getData().get(i).getEmpAge())
			{
				maxage=obj.getData().get(i).getEmpAge();
				enmax=obj.getData().get(i).getEmpName();
			}
		}
		System.out.println(enmax+" is oldest employee with "+maxage+" years of age");
		//get max and min sal employee names via hard code in java
		long max=obj.getData().get(0).getEmpSal();
		long min=obj.getData().get(0).getEmpSal();
		for(int i=1; i<obj.getData().size();i++) //2nd employee to last employee
		{
			if(max<obj.getData().get(i).getEmpSal())
			{
				max=obj.getData().get(i).getEmpSal();
			}
			if(min>obj.getData().get(i).getEmpSal())
			{
				min=obj.getData().get(i).getEmpSal();
			}
		}
		System.out.println(max);	
		System.out.println(min);	
		for(int i=0; i<obj.getData().size();i++) //1st employee to last employee
		{
			if(max==obj.getData().get(i).getEmpSal())
			{
				System.out.println(obj.getData().get(i).getEmpName());	
			}
			if(min==obj.getData().get(i).getEmpSal())
			{
				System.out.println(obj.getData().get(i).getEmpName());	
			}
		}
	}
}







