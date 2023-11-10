package apitests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test25 
{
	@Test
	public void getCurrentTemperature()
	{
		//1. Create a HTTP request with all details
		RequestSpecification req=RestAssured.given();
		req.baseUri("http://api.weatherapi.com/v1"); 
		req.basePath("current.json"); 
		req.queryParam("key","e9c3b0195be341c795281747202311");
	    req.queryParam("q","pune");
		//2. submit request
		Response res=req.get();
		//3. Get and display response body
		String x=res.body().jsonPath().getString("location.name");
		if(x.equalsIgnoreCase("puna"))
		{
			Reporter.log("Test passed");
			Assert.assertTrue(true);
		}
		else
		{
			Reporter.log("Test Fail");
			Assert.assertTrue(false);
		}
	}
}




