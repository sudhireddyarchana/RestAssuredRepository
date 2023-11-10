package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PreemptiveAuthentication 
{
	public static void main(String[] args)
	{
		//Preemptive authentication
		RequestSpecification req=RestAssured.given();
	    req.baseUri("http://the-internet.herokuapp.com");
	    req.basePath("basic_auth");
	    req.auth().preemptive().basic("admin","admin");
	    System.out.println("Request");
	    System.out.println("--------");
	    req.given().log().all();
	    Response res=req.get();
	    System.out.println("Response");
	    System.out.println("--------");
	    res.then().log().all();

	}
}
