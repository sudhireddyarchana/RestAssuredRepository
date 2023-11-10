package apitests;

import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test27 
{
	@Test
	@Parameters({"apikey","city"})
	public void getCurrentTemperature(
			@Optional("e9c3b0195be341c795281747202311") String x, 
			@Optional("Hyderabad") String y)
	{
		//1. Create a HTTP request with all details
		RequestSpecification req=RestAssured.given();
		req.baseUri("http://api.weatherapi.com/v1"); 
		req.basePath("current.json"); 
		req.queryParam("key",x);
	    req.queryParam("q",y);
		//2. submit request
		Response res=req.get();
		//3. Get and display response body
		float z=res.body().jsonPath().getFloat("current.temp_c");
		Reporter.log(z+"");
	}
}




