package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BodyAsAString 
{
	public static void main(String[] args) 
	{
		String s= "{\r\n" + 
				"\"userId\":\"101\",\r\n" + 
				"\"title\":\"Hi\",\r\n" + 
				"\"Body\":\"Good morning\"\r\n" + 
				"}";
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://jsonplaceholder.typicode.com");
		req.basePath("/posts");
		req.header("Content-Type", "application/json");
		req.body(s);
		System.out.println("Request");
		System.out.println("==============");
		req.given().log().all();
		Response res=req.post();
		System.out.println("Response");
		System.out.println("===============");
		res.then().log().all();

	}

}
