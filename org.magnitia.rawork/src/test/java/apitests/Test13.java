package apitests;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test13
{
	public static void main(String[] args)
	{
		//Creating a File instance/object 
		File f=new File("src\\test\\resources\\datafiles\\mydata.xml");
		//Create a HTTP request with body parameters in XML
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://reqbin.com");
		req.basePath("echo/post/xml");
		req.header("Content-Type","text/xml");
		req.body(f); //body as a .xml file
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
