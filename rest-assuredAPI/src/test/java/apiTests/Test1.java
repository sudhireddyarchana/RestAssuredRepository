package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test1 
{
	public static void main(String[] args) 
	{
	RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
	Response res=RestAssured.get();
	int x=res.getStatusCode();
	System.out.println("status code:"+x);
	String y=res.headers().getValue("Content-Type");
	System.out.println("Header value is:"+y);
	String z=res.getBody().asString();
	System.out.println("Body:"+z);
	String z1=res.getBody().asPrettyString();
	System.out.println("Body is:"+z1);
	
	
	}

}
