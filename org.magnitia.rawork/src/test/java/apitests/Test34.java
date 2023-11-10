package apitests;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test34 
{
	@Test
	public void uploadFile()
	{
		//Create request
		File f=new File("C:\\Users\\AA\\Pictures\\charminar.jpg");
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://the-internet.herokuapp.com");
		req.basePath("upload");
		req.multiPart("file",f,"multipart/form-data");//control name is "file" by default
		//common MIME type for any type of file is "multipart/form-data"
		//submit request
		Response res=req.post(); //HTTP POST method to upload file
		//Display response
		System.out.println(res.statusCode());
		System.out.println(res.body().asPrettyString());
	}

}
