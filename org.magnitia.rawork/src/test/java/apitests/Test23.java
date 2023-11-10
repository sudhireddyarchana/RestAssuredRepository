package apitests;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test23 
{
	public static void main(String[] args) 
	{
		//Take value from keyboard for query parameter
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a city name or other details as per API doc");
		String city=sc.nextLine();
		sc.close(); 
		//call getCurrentTemperature() method
		float output=getCurrentTemperature("current.json",
				                           "e9c3b0195be341c795281747202311",
				                           city);
		System.out.println(output);
	}
	public static float getCurrentTemperature(String bp, String apikey, String city)
	{
		//1. Create a HTTP request with all details
		RequestSpecification req=RestAssured.given();
		req.baseUri("http://api.weatherapi.com/v1"); //protocol with domain name
		req.basePath(bp); //resources hierarchy
		req.queryParam("key",apikey);
	    req.queryParam("q",city);
		//2. submit request
		Response res=req.get();
		//3. Get and display response body
		float x=res.body().jsonPath().getFloat("current.temp_c");
		return(x);
	}
}
