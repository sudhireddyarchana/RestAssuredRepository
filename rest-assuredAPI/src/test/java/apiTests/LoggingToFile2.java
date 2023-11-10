package apiTests;
import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
public class LoggingToFile2 
{
	public static void main(String[] args) throws Exception 
	{
		//way-3:request and response into single file
		
		//create file for request and response
		File f= new File("target\\ReqRes.txt");
		FileOutputStream fo= new FileOutputStream(f);
		PrintStream ps= new PrintStream(fo);
 
		//contact a resource
		
		given()
		.baseUri("https://restcountries.com")
		.basePath("v3.1/all")
		.filter(RequestLoggingFilter.logRequestTo(ps))
		.filter(ResponseLoggingFilter.logResponseTo(ps))
		.get();
	}

}
