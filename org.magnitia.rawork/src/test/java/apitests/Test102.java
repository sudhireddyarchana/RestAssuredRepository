package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test102 
{
	public static void main(String[] args) 
	{
		//1. Make a Request
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
		//2. Submit request via HTTP method to get response
		Response res=RestAssured.get();
		//3. validate Status code
		int x=res.getStatusCode();
		if(x==200)
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
	}
}
