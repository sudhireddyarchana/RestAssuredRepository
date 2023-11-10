package apiTests;

import java.io.File;
import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;

public class JsonPathExample4 {

	public static void main(String[] args)
	{
		//connect to JSON file
		   File f= new File("src\\test\\resources\\Employees.json");
		   JsonPath jp= new JsonPath(f);
		   
		 //Get a JSON Object using "find" in GPath
		   
		   Map<String,Object> map=jp.getMap("data.find{it.id==2}");
		   for(String k:map.keySet())
		   {
			   System.out.println(k+":"+map.get(k));
		   }
		 //Get specific value using a "find" in GPath
		   
		  String emp_age= jp.getString("data.find{it.id==1}.employee_age");
		  System.out.println(emp_age);
		  
		  //get employee_name by using AND condition
		  //If both conditions Satisfy it will write true
		  String name=jp.getString("data.find{it.id==1&&it.employee_age==66}.employee_name");
		  System.out.println(name);
		  
		  //get employee_name by using OR condition
		  //If any one condition Satisfy it will write true
		  
		  String name1=jp.getString("data.find{it.id==1||it.employee_age==66}.employee_name");
          System.out.println(name1);
          
          //get employee_names by using age
          
          List<Object> names=jp.getList("data.findAll{it.employee_age>=60}.employee_name");
          for(int i=0;i<names.size();i++)
          {
        	  System.out.println(names.get(i));
          }
          
          //get employees_salary by using age
          
          List<Object> emp=jp.getList("data.findAll{it.employee_age>=60}.employee_salary");
          for(int i=0;i<emp.size();i++)
          {
        	  System.out.println(emp.get(i));
          }
	}

}
