package apiTests;
import static io.restassured.RestAssured.*;

import java.util.Scanner;

import io.restassured.response.Response;
public class APIKeyExample {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a city name");
		String city=sc.nextLine();
		sc.close();
		float output=getCurrentTemperature("/current.json","0d831a485069444fb25101724232709",city);
	    System.out.println(output);
	}
	public static float getCurrentTemperature(String Basepath,String apiKey,String city)
	{
		Response response=given()
		.baseUri("http://api.weatherapi.com/v1") //protocol with domain name
		.basePath(Basepath) //resources hierarchy
		.queryParam("key", apiKey)
		.queryParam("q", city)
		.get();
		Float f=response.body().jsonPath().getFloat("current.temp_c");
		response.then().log().all();
		return(f);
	}

	

}
