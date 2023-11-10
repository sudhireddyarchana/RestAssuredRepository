package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class Test2 
{
	public static void main(String[] args) 
	{
		//1. Make a Request
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		//2. Submit request via HTTP method to get response
		Response res=RestAssured.get("/posts/34"); //path parameter
		//3. Analyze response
		String z=res.getBody().asString();
		System.out.println(z);
	}
}
