package apiTests;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class LoggingToConsole
{
	public static void main(String[] args) 
	{
	//RestAssured allows us to log request and response in two ways
    //one is Console and other one is As a File
    //Way-1:To Console
	  Response res=given()
	  .baseUri("https://restcountries.com")
	  .basePath("v3.1/all")
	  .given().log().all()
	  .get();
	  res.then().log().all();

	}

}
