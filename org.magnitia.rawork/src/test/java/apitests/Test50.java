package apitests;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.SamplePOJO1;

public class Test50
{
	public static void main(String[] args) throws Exception
	{
		//Serialization(prepare a JSON pay-load using setters for HTTP request)
		SamplePOJO1 obj=new SamplePOJO1();
		obj.setName("Ravinder");
		obj.setAge(28);
		obj.setHeight((float)6.2);
		List<String> temp1=new ArrayList<String>();
		temp1.add("Hyderabad");
		temp1.add("Bengaluru");
		temp1.add("Newyork");
		temp1.add("Chicago");
		temp1.add("Atlanta");
		obj.setLocation(temp1);
		obj.setMarried(true);
		List<Object> temp2=new ArrayList<Object>();
		temp2.add(123);
		temp2.add("gandhi street");
		temp2.add("koti");
		temp2.add("Hyderabad");
		temp2.add(500038);
		obj.setAddress(temp2);
		ObjectMapper om=new ObjectMapper();
		System.out.println(om.writeValueAsString(obj));
	}
}
