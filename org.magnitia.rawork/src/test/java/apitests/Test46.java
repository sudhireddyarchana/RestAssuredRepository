package apitests;

import io.restassured.RestAssured;

import java.util.Scanner;
import org.hamcrest.Matchers;

public class Test46
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
		//Connect to Rest API, submit request, get response and validate that response
		RestAssured.given() 
    		.baseUri("https://restcountries.com") 
    	    .basePath("v3.1/all") 
        .when() 
    	    .get()
    	.then()
    		.statusCode(200)
    		.header("Content-Type","application/json")
    	    .body("find{it.name.common=='"+c+"'}.capital[0]",
    	    			Matchers.equalToIgnoringCase(expected))
    	    .time(Matchers.lessThan(2000L));
	}
}




