package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PathParamsExample
{
	public static void main(String[] args) 
	{
		//way-1
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
		Response res=RestAssured.get("1");
		String x=res.asString();
		System.out.println("body is:"+x);
		//way-2
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/users/5";
		Response res1=RestAssured.get();
		String x1=res1.asString();
		System.out.println("body is:"+x1);
		//way-3
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		Response res2=RestAssured.get("/users/7");
		String x2=res2.asString();
		System.out.println("body is:"+x2);
	}

}
