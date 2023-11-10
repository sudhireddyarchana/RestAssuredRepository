package apiTests;

import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryparamsExample2 
{
	public static void main(String[] args) 
	{
	//take the input from keyboard
		Scanner sc= new Scanner(System.in);
		System.out.println("please enter a city name");
		String city=sc.nextLine();
        sc.close();
        RequestSpecification request=RestAssured.given();
        request.baseUri("http://api.weatherapi.com");
        request.basePath("/v1/current.json");
        request.queryParam("key", "0d831a485069444fb25101724232709");
        request.queryParam("q", city);
        System.out.println("Request");
        System.out.println("---------------");
        //to display whole request
        request.given().log().all();
        Response res=request.get();
        System.out.println("Response");
        System.out.println("----------------");
      //to display whole response
        res.then().log().all();
	}

}
