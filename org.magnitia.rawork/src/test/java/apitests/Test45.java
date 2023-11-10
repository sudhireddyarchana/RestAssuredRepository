package apitests;


import io.restassured.RestAssured;
import java.util.Scanner;

import io.restassured.response.Response;

public class Test45 
{
	public static void main(String[] args)
	{
		//Take test data and expected value from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter country name");
		String c=sc.nextLine();
		System.out.println("Enter expected capital for "+c);
		String expected=sc.nextLine();
		sc.close();
		//Connect to RestAPI fro response
		Response res=RestAssured.given() 
    	         .baseUri("https://restcountries.com") 
    	         .basePath("v3.1/all") 
    	         .when().get(); 
		//get 1st value of "capital" field in given country json object	
		String actual=res.getBody().jsonPath()
				.getString("find{it.name.common=='"+c+"'}.capital[0]");
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed because actual is "+actual);
		}
	}
}




