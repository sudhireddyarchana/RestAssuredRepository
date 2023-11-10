package apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.PostsPOJO;

public class Test52 
{
	public static void main(String[] args)
	{
		//packing the request using POJO class object
		PostsPOJO obj1=new PostsPOJO();
		obj1.setUserId(4);
		obj1.setTitle("Hi");
		obj1.setBody("how are you?");
		Response res=RestAssured.given()
				.baseUri("https://jsonplaceholder.typicode.com")
				.basePath("posts")
				.header("Content-Type","application/json")
				.body(obj1)
			.when()
				.post();
		//unpacking response using same POJO class object
		PostsPOJO obj2=res.jsonPath().getObject("$",PostsPOJO.class); //"$" is total response
		System.out.println("POST:");
		System.out.println("----------------");
		System.out.println(obj2.getId());
		System.out.println(obj2.getUserId());
		System.out.println(obj2.getTitle());
		System.out.println(obj2.getBody());
	}
}
