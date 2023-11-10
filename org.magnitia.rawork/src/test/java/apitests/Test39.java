package apitests;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Test39 
{
	@Test
	public void method()
	{
		//Connect to JSON file
		File f=new File("src\\test\\resources\\jsonpayload.json");
		JsonPath jp=new JsonPath(f);
		//1. get value of "data1" field
        String x=jp.getString("data1");
        System.out.println(x);
        //2. get values of "data2" field
        List<Object> y=jp.getList("data2");
        System.out.println(y);
        //3. get JSON Object values of "data3" field
        Map<String,Object> z=jp.getMap("data3");
        System.out.println(z);
        //4. get array of unnamed JSON Object values of "data4" field
        List<Map<String,Object>> w=jp.getList("data4");
        System.out.println(w);
        //5. get values of "data5"
        Map<String,Map<String,Object>> s=jp.getMap("data5");
        System.out.println(s);
	}
}
