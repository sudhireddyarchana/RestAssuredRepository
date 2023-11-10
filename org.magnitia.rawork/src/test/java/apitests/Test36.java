package apitests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test36
{
	@Test(priority=1)
	public void loggingToConsole()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://restcountries.com");
		req.basePath("v3.1/all");
		req.log().all(); //display whole request in console
		Response res=req.get();
		res.then().log().all(); //display whole response in console
	}
	
	@Test(priority=2)
	public void loggingToFiles() throws Exception
	{
		//Create file1 for request
		File f1=new File("target\\myrequest.txt");
		FileOutputStream fo1=new FileOutputStream(f1);
		PrintStream ps1=new PrintStream(fo1);
		//Create file2 for Response
		File f2=new File("target\\myresponse.txt");
	    FileOutputStream fo2=new FileOutputStream(f2);
	    PrintStream ps2=new PrintStream(fo2);
	    //Contact a resource
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://restcountries.com");
		req.basePath("v3.1/all");
		req.filter(RequestLoggingFilter.logRequestTo(ps1));
		req.filter(ResponseLoggingFilter.logResponseTo(ps2));
		Response res=req.get();
	}
	
	@Test(priority=3)
	public void loggingToOneFile() throws Exception
	{
		//Create file1 for request
		File f=new File("target\\myrequestresponse.txt");
		FileOutputStream fo=new FileOutputStream(f);
	    PrintStream ps=new PrintStream(fo);
	    //Contact a resource
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://restcountries.com");
		req.basePath("v3.1/all");
		req.filter(RequestLoggingFilter.logRequestTo(ps));
		req.filter(ResponseLoggingFilter.logResponseTo(ps));
		//submit request
		Response res=req.get();
	}
}





