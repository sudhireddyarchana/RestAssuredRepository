package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test14
{
	public static void main(String[] args)
	{
		//Creating a String variable
		String x="<Request>\r\n" + 
				"    <Login>login</Login>\r\n" + 
				"    <Password>password</Password>\r\n" + 
				" </Request>";
		//Create and submit HTTP request with body parameters via POST method
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://reqbin.com");
		req.basePath("echo/post/xml");
		req.header("Content-Type","application/xml");
		req.body(x); //body as a string value
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
