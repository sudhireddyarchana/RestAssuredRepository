package apitests;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test5 
{
	public static void main(String[] args) 
	{
		//Take value from keyboard for query parameter
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a city name");
		String city=sc.nextLine();
		sc.close();
		//1. Create a HTTP request with all details
		RequestSpecification req=RestAssured.given();
		req.baseUri("http://api.weatherapi.com/v1"); //protocol with domain name
		req.basePath("current.json"); //resources hierarchy
		req.queryParam("key","e9c3b0195be341c795281747202311");
	    req.queryParam("q",city);
	    System.out.println("Request");
	    System.out.println("--------");
	    req.given().log().all(); //to display whole request
		//2. submit request
		Response res=req.get();
		//3. Get and display response body
		System.out.println("Response");
	    System.out.println("--------");
		res.then().log().all(); //to display whole response
	}
}
