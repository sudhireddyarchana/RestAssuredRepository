package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryparamsExample3_1
{
	public static void main(String[] args)
	{
	RequestSpecification req=RestAssured.given();
	req.baseUri("https://restcountries.com/v3.1/name");
	req.basePath("/india");
	req.queryParam("fullText", "true");
	req.header("Content-Type", "application/json");
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
