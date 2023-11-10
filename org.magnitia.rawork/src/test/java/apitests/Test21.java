package apitests;

import io.restassured.RestAssured;
import io.restassured.authentication.FormAuthConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test21
{
	public static void main(String[] args)
	{
		//form authentication
		//use inspect to take action, name of user-id and password fields in HTML form
		FormAuthConfig fc=new FormAuthConfig("index.php","uid","password");
		RequestSpecification req=RestAssured.given();
	    req.baseUri("https://demo.guru99.com");
	    req.basePath("V1/index.php");
	    req.auth().form("mngr356676","deqUpav",fc);
	    System.out.println("Request");
	    System.out.println("--------");
	    req.given().log().all();
	    Response res=req.post();
	    System.out.println("Response");
	    System.out.println("--------");
	    res.then().log().all();

	}
}
