package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test9 
{
	public static void main(String[] args) 
	{
		//Create a HTTP request with all details
		RestAssured.urlEncodingEnabled=false; //to identify matrix parameters in URI
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://petstore.swagger.io"); //protocol with domain name
		//resources hierarchy with matrix parameter value
		req.basePath("v2/pet/findByStatus;matrixParm=test"); 
		req.queryParam("offset","0");
		req.queryParam("pageSize","20");
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




