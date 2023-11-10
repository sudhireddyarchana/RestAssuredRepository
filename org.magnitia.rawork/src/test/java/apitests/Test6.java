package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test6 
{
	public static void main(String[] args) 
	{
		//Create a HTTP request with all details
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://restcountries.com/v3.1"); //protocol with domain name
		req.basePath("name/india"); //resources hierarchy with path parameter value
		req.queryParam("fullText","true"); //query parameter name with value
		System.out.println("Request");
	    System.out.println("--------");
	    req.given().log().all(); //to display whole request
		//submit request
		Response res=req.get();
		//Get and display response
		System.out.println("Response");
	    System.out.println("--------");
		res.then().log().all(); //to display whole response
	}
}




