package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test4 
{
	public static void main(String[] args) 
	{
		//Create a HTTP request with all details
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://www.google.co.in"); //protocol with domain name
		req.basePath("search"); //resources hierarchy
		req.queryParam("q","gold rate in india");
		req.given().log().all(); //to display whole request
		//submit request
		Response res=req.get();
		//display whole response
		res.then().log().all(); 
	}
}






