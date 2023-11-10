package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test103 
{
	public static void main(String[] args) 
	{
		//1. Make a Request
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
		//2. Submit request via HTTP method to get response
		Response res=RestAssured.get();
		//3. validate Headers
		String y=res.getHeaders().getValue("Content-Type");
		y=y.toLowerCase(); //convert value into lower case for easy validation
		if(y.contains("json"))
		{
			System.out.println("Body is in json format");
		}
		else if(y.contains("xml"))
		{
			System.out.println("Body is in xml format");
		}
		else if(y.contains("html"))
		{
			System.out.println("Body is in html format");
		}
		else
		{
			System.out.println("Body is in plan text");
		}
	}
}
