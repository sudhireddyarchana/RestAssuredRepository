package apitests;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.BookStorePojo1;
import pojos.BookStorePojo2;

public class Test53 
{
	public static void main(String[] args) throws Exception
	{
		//Request payload serialization using class-1
		BookStorePojo1 obj1=new BookStorePojo1();
		obj1.setUserName("TOOLSQA-Test");
		obj1.setPassword("Test@@123");
		//verify that serialized request payload before sending
		ObjectMapper om=new ObjectMapper();
		System.out.println(om.writeValueAsString(obj1));
		//submit request to Resource
        Response res=RestAssured.given()
        		.baseUri("https://bookstore.toolsqa.com")
        		.basePath("Account/v1/GenerateToken")
        		.header("Content-Type","application/json")
        		.body(obj1)
        	.when()
        		.post();
        //Response body deserialization using class-2
        BookStorePojo2 obj2=res.jsonPath().getObject("$",BookStorePojo2.class); //"$" is total response
		System.out.println("Response body:");
		System.out.println("----------------");
		System.out.println(obj2.getToken());
		System.out.println(obj2.getExpires());
		System.out.println(obj2.getStatus());
		System.out.println(obj2.getResult());
	}
}
