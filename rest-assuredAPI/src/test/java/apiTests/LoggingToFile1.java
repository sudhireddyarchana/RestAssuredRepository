package apiTests;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter; 

public class LoggingToFile1 
{
	public static void main(String[] args) throws Exception 
	{
	    /*way-2:Request and Response as a file
		RequestLoggingFilter and ResponseLoggingFilter classes are useful to get
		request and response into a files
		create a file-1 for request*/
		
		File f1= new File("target\\request.txt");
		FileOutputStream fo1= new FileOutputStream(f1);
		PrintStream ps1= new PrintStream(fo1);
		
		//create file-2 for response
		
		File f2= new File("target\\response.txt");
		FileOutputStream fo2= new FileOutputStream(f2);
		PrintStream ps2= new PrintStream(fo2);
		
		//contact a resource
		
		given()
		.baseUri("https://restcountries.com")
		.basePath("v3.1/all")
		.filter(RequestLoggingFilter.logRequestTo(ps1))
		.filter(ResponseLoggingFilter.logResponseTo(ps2))
		.get();

	}

}
