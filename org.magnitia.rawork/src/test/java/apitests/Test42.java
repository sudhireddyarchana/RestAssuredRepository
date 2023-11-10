package apitests;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Test42 
{
	@Test
	public void method()
	{
		//Connect to JSON file
		File f=new File("src\\test\\resources\\jsonpayload.json");
		JsonPath jp=new JsonPath(f);
		//way-1 (get cars vales using GPATH(subset of JSONPath expressions))
        List<String> l=jp.getList("data5.msa.cars");
        for(int i=0;i<l.size();i++)
        {
        	System.out.println(l.get(i));
        }
        //way-2 (get cars values using JAVA code)
        Map<String,Map<String,Object>> m=jp.getMap("data5");
        for(int i=0;i<((List<Object>) m.get("msa").get("cars")).size();i++)
		{
			System.out.println(((List<Object>) m.get("msa").get("cars")).get(i));
		}
	}
}
