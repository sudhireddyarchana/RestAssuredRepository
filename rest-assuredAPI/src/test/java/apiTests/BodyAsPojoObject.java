package apiTests;

import Pojos.myPojo1;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BodyAsPojoObject 
{
   public static void main(String[] args)
   {
	   myPojo1 mp= new myPojo1();
	   mp.setuserId(1);
	   mp.settitle("Hi");
	   mp.setbody("how r u");
	 //Create a HTTP request with body parameters
	   RequestSpecification req=RestAssured.given();
	   req.baseUri("https://jsonplaceholder.typicode.com");
	   req.basePath("/posts");
	   req.header("Content-Type", "application/json");
	   req.body(mp);
	   System.out.println("Request");
	   System.out.println("--------------------");
	   req.given().log().all();
	   //submit request via POST method
	   Response res=req.post();
	   System.out.println("Response");
	   System.out.println("--------------------");
	   res.then().log().all();
	   
}
}
