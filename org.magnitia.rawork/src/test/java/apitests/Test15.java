package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.MyXmlPojo1;

public class Test15
{
	public static void main(String[] args)
	{
		//Creating an object to POJO class
		MyXmlPojo1 obj=new MyXmlPojo1();
		obj.setLogin("login");
		obj.setPassword("password");
		//Create a HTTP request with body parameters
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://reqbin.com");
		req.basePath("echo/post/xml");
		req.header("Content-Type","application/xml");
		req.body(obj); //body as an object of POJO class
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
