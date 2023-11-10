package apiTests;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PathParamsExample2 
{
	public static void main(String[] args)
	{
	//Get test data from the keyboard
		Scanner sc= new Scanner(System.in);
		System.out.println("please enter any value :");
		int value=sc.nextInt();
		sc.close();
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		//submit request via 'http' method
		Response res=RestAssured.get("/posts/"+value);
		//analyze the response
		String x=res.body().asString();
		System.out.println("body is:"+x);
		
		

	}

}
