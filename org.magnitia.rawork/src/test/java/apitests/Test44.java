package apitests;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test44 
{
	@Test
	public void method()
	{
		Response res=RestAssured.given() 
   	                 .baseUri("https://restcountries.com") 
   	                 .basePath("v3.1/all").when().get(); 
		//1. get count of JSON objects in an Array of JSON objects(total response)
		int x=res.getBody().jsonPath().getInt("$.size()");
		System.out.println(x);
		//2. get count of fields in 1st country JSON object and display those fields
		int y=res.getBody().jsonPath().getInt("[0].size()");
		System.out.println(y);
		Map<String,Object> lf=res.getBody().jsonPath().getMap("[0]");
		System.out.println(lf.keySet());
		//3. get count of fields in "maps" in 1st country json object
		int z=res.getBody().jsonPath().getInt("[0].maps.size()");
		System.out.println(z);
		Map<String,Object> lm=res.getBody().jsonPath().getMap("[0].maps");
		System.out.println(lm.keySet());
		//4. get value of "common" field in 1st country json object	
		String a=res.getBody().jsonPath().getString("[0].name.nativeName.spa.common");
		System.out.println(a);
		//5. get boolean value of "independent" field in 1st country json object	
		boolean b=res.getBody().jsonPath().getBoolean("[0].independent");
		System.out.println(b);
		//6. get all float values of "latlng" field in 1st country json object	
		List<Float> c=res.getBody().jsonPath().getList("[0].latlng");
		System.out.println(c.get(0));
		System.out.println(c.get(1));
		//7. get only float longitude value of "latlng" field in 1st country json object	
		float d=res.getBody().jsonPath().getFloat("[0].latlng[1]");
		System.out.println(d);	
		//8. get count of countries, which have "idd.root" as "+1"
		int e=res.getBody().jsonPath()
				.getInt("findAll{it.idd.root=='+9' && it.idd.suffixes[0]=='1'}.size()");
		System.out.println(e);	
		//9. get names of countries, which have "idd.root" as "+1"
		List<String> f=res.getBody().jsonPath()
				  .getList("findAll{it.idd.root=='+9' && it.idd.suffixes[0]=='1'}.name.common");
		System.out.println(f);	
		//10 find India and then get and display borders
		List<String> bl1=res.getBody().jsonPath()
				.getList("find{it.name.common=='India'}.borders");
		System.out.println(bl1);	
		//11 find India/india/INDIA and then get and display borders
		List<String> bl2=res.getBody().jsonPath()
						.getList("find{it.name.common in ['India','india','INDIA']}.borders");
		System.out.println(bl2);
		//12. get highest population value
		long maxp=res.getBody().jsonPath().getLong("population.max()");
		System.out.println(maxp);
		//13. find highest populated country name
		String hpcn=res.getBody().jsonPath().getString("max{it.population}.name.common");
		System.out.println(hpcn);
		//14. get lowest population value
		int minp=res.getBody().jsonPath().getInt("population.min()");
		System.out.println(minp);
		//15. find lowest populated country name
		String lpcn=res.getBody().jsonPath().getString("min{it.population}.name.common");
		System.out.println(lpcn);
		//16. get sum of values
		float sum=res.getBody().jsonPath()
				.getFloat("find{it.name.common=='Malaysia'}.latlng.sum()");
		System.out.println(sum);	
	}
}











