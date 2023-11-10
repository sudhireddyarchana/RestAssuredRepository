package apiTests;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryparamsExample3_2
{
	public static void main(String[] args)
	{
	Scanner sc= new Scanner(System.in);
	System.out.println("please enter path paramater value like country name");
	String Country_name=sc.nextLine();
	System.out.println("please enter query paramter value like true or false");
	String option=sc.nextLine();
	sc.close();
	RequestSpecification req=RestAssured.given();
	req.baseUri("https://restcountries.com/v3.1/name");
	req.basePath(Country_name);
	req.queryParam("fullText", option);
	req.header("Content-Type", "application/json");
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
