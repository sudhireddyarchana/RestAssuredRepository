package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.MyJsonPojo1;

public class Test12
{
	public static void main(String[] args)
	{
		//Way-3: Serialization or packing values into JSON payload
		MyJsonPojo1 obj=new MyJsonPojo1();
		obj.setUserId(1);
		obj.setTitle("wishes");
		obj.setBody("All the best students");
		//Create a HTTP request with body parameters
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://jsonplaceholder.typicode.com"); //protocol with domain name
		req.basePath("posts"); //resources hierarchy
		req.header("Content-Type","application/json"); //header
		req.body(obj); //body as object of corresponding POJO class
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
