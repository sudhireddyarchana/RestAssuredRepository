package runners;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Pojos.MyPojo3;

public class MyPojo3RunnerClass {

	public static void main(String[] args) throws Exception 
	{
		MyPojo3 mp= new MyPojo3();
		mp.setName("Archana Reddy");
		String name=mp.getName();
		System.out.println("name is:"+name);
		mp.setAge(25);
		int age=mp.getAge();
		System.out.println("age is:"+age);
		mp.setHeight((float)5.6);
		Float height=mp.getHeight();
        System.out.println("height is:"+height);
        List<String> l= new ArrayList<String>();
        l.add("Hyderabad");
        l.add("Canada");
        l.add("Paris");
        l.add("ladak");
        mp.setLocation(l);
        List<String> location=mp.getLocation();
        System.out.println("location is:"+location);
        List<Object> obj= new ArrayList<Object>();
        obj.add(199);
        obj.add("Telecom Nagar");
        obj.add("Green Land Colany");
        obj.add("Gachibowli");
        obj.add(500010);
        mp.setAddress(obj);
        mp.setMarried(true);
        Boolean status=mp.getMarried();
        System.out.println("married status is:"+status);
        List<Object> address=mp.getAddress();
        System.out.println("Address is:"+address);
        ObjectMapper om=new ObjectMapper();
		System.out.println(om.writeValueAsString(mp));
	}

}
