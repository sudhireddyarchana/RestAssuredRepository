package apitests;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Test41 
{
	@Test
	public void method()
	{
		//Connect to JSON file
		File f=new File("src\\test\\resources\\jsonpayload.json");
		JsonPath jp=new JsonPath(f);
		//way-1 (get cars vales using GPATH(subset of JSONPath expressions))
        Float h=jp.getFloat("data4[1].height");
        System.out.println(h);
        //way-2 (get cars values using JAVA code)
        List<Map<String,Object>> l=jp.getList("data4");
       	System.out.println(l.get(1).get("height"));
	}
}
