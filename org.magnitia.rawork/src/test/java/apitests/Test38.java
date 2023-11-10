package apitests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test38 
{
	@Test
	public void method()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://restcountries.com");
		req.basePath("v3.1/all");
		Response res=req.get();
		Headers hs=res.getHeaders();
		for(Header h:hs)
		{
			System.out.println(h.getName()+":"+h.getValue());
		}
	}

}
