package apiTests;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BodyParamsBodyAsFile 
{
	public static void main(String[] args)
	{
	//way-1: Request body as File	
		File f=new File("src\\test\\resources\\JsonPayloadAsFile\\File1.json");
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://jsonplaceholder.typicode.com");
		req.basePath("/posts");
		req.header("Content-Type", "application/json");
		req.body(f);
		System.out.println("Request");
		System.out.println("==============");
		req.given().log().all();
		//submit request via POST method
		Response res=req.post();
		System.out.println("Response");
		System.out.println("===============");
		res.then().log().all();

	}

}
