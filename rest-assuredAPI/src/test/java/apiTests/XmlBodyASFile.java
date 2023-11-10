package apiTests;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XmlBodyASFile
{

	public static void main(String[] args) 
	{
		File file= new File("src\\test\\resources\\XmlPayloadAsFile\\XmlPayload.xml");
		RequestSpecification req=RestAssured.given();
		req.baseUri("http://reqbin.com");
		req.basePath("/echo/post/xml");
		req.header("Content-Type", "application/xml");
		req.body(file);
		System.out.println("Request=>=>=>");
		req.given().log().all();
		Response res=req.post();
		System.out.println("Response=>=>=>");
		res.then().log().all();
		
	}

}
