package apitests;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test7 
{
	public static void main(String[] args) 
	{
		//Take values from keyboard for both path and query parameter
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter path parameter value like country name");
		String country=sc.nextLine();
		System.out.println("Enter query parameter value like true or false");
		String option=sc.nextLine();
		sc.close();
		//Create a HTTP request with all details
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://restcountries.com/v3"); //protocol with domain name
		req.basePath("name/"+country); //resources hierarchy with path parameter
		req.queryParam("fullText",option);
		System.out.println("Request");
	    System.out.println("--------");
	    req.given().log().all(); //to display whole request
		//submit request
		Response res=req.get();
		//Get and display response
		System.out.println("Response");
	    System.out.println("--------");
		res.then().log().all(); //to display whole response
	}
}
