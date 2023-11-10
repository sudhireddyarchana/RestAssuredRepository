package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParamsExample1 
{
	public static void main(String[] args)
	{
		RequestSpecification request=RestAssured.given();
		request.baseUri("https://www.google.co.in/");
		request.basePath("search");
		request.queryParam("q", "what is the score of cricket match");
		//to display whole request
		request.given().log().all();
		Response res=request.get();
		//to display whole response
		res.then().log().all();
		//String s=res.body().asString();
		//System.out.println("Price is:"+s);
		
	}

}
