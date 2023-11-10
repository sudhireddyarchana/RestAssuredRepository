package apiTests;

import java.io.File;
import java.util.List;
import java.util.Map;

import io.restassured.path.json.JsonPath;

public class JsonPathExample 
{
  public static void main(String[] args) 
  {
	  //connect to JSON file
	  
	File f=new File("src\\test\\resources\\JsonPayload.json");
	JsonPath jp= new JsonPath(f);
	
	//1.get value of data1 field
	
	String x=jp.getString("data1");
	System.out.println(x);
	
	//2. get values of "data2" field
	
	List<Object> y=jp.getList("data2");
	String name=y.get(0).toString();
	System.out.println("name:"+name);
	System.out.println(y);
	
	//3.get JSON object values of "data3" field
	
	Map<Object,Object> map=jp.getMap("data3");
	System.out.println(map);
	Boolean b=map.containsKey("age");
	System.out.println(b);
	
	//4. get array of unnamed JSON Object values of "data4" field
	
	List<Map<String,Object>> z=jp.getList("data4");
	System.out.println(z);
	String d=z.get(1).toString();
	System.out.println(d);
	
	//get values of "data5"
	
	Map<String,Map<String,Object>> s=jp.getMap("data5");
    System.out.println(s);
  }
}
