package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class XmlBodyAString
{
    public static void main(String[] args) 
	{
		String s="<Request>\r\n" + 
				"	<Login>archana</Login>\r\n" + 
				"	<Password>bubby</Password>\r\n" + 
				"</Request>";
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://reqbin.com");
		req.basePath("/echo/post/xml");
		req.header("Content-Type", "application/xml");
		req.body(s);
		System.out.println("Request=>=>=>");
		req.given().log().all();
		Response res=req.post();
		System.out.println("Response=>=>=>");
		res.then().log().all();
		
	}

}
