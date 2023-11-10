package apitests;

import java.util.Scanner;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test3 
{
	public static void main(String[] args) 
	{
		//Get test data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a value to path parameter in b/w 1 to 100");
		int x=sc.nextInt();
		sc.close();
		//1. Make a Request
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		//2. Submit request via HTTP method to get response
		Response res=RestAssured.get("/posts/"+x); //path parameter
		//3. Analyze response
		String z=res.getBody().asString();
		System.out.println(z);
	}
}






