package apitests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test37
{
	@Test
	public void method()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://restcountries.com");
		req.basePath("v3.1/all");
		Response res=req.get();
		int sc=res.getStatusCode();
		System.out.println(sc);
	}
}
