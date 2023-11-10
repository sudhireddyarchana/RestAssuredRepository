package apitests;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Test40 
{
	@Test
	public void method()
	{
		//Connect to JSON file
		File f=new File("src\\test\\resources\\jsonpayload.json");
		JsonPath jp=new JsonPath(f);
		//way-1 (get cars vales using GPATH(subset of JSONPath expressions))
        String x=jp.getString("data5.msa.cars[2]");
        System.out.println(x);
        //way-2 (get cars values using JAVA code)
        Map<String,Map<String,Object>> m=jp.getMap("data5");
        System.out.println(((List<String>) m.get("msa").get("cars")).get(2));
	}
}
