package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test11
{
	public static void main(String[] args)
	{
		//Way-2: JSON string value as Request body
		String x="{\r\n" + 
				"    \"userId\": 1,\r\n" + 
				"    \"title\": \"hi\",\r\n" + 
				"    \"body\": \"how are you\"\r\n" + 
				"  }";
		//Create a HTTP request with body parameters
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://jsonplaceholder.typicode.com"); //protocol with domain name
		req.basePath("posts"); //resources hierarchy
		req.header("Content-Type","application/json"); //header
		req.body(x); //body as a string
		System.out.println("Request");
	    System.out.println("--------");
	    req.given().log().all();
	    //Submit Request via POST method
	    Response res=req.post();
	    //Display whole Response
	    System.out.println("Response");
	    System.out.println("--------");
	    res.then().log().all();

	}

}
