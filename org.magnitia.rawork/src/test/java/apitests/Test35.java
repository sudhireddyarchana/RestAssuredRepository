package apitests;

import java.io.File;
import java.io.FileOutputStream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test35 
{
	@Test
	public void fileDownload() throws Exception
	{
		//Create HTTP request and submit
		Response res=RestAssured.given()
				                .baseUri("https://chercher.tech")
				                .basePath("files/minion.zip") //required file name as path parameter
			                    .when()
				                .get();
		//Diplay response details
		System.out.println(res.getStatusCode());
		System.out.println(res.getHeader("Content-Type"));
		//save that downloaded file content into a new local file
		byte[] dowloadedFile=res.getBody().asByteArray();
		File f=new File("target\\minios-from-rest-assured.zip");
		FileOutputStream fo=new FileOutputStream(f);
		fo.write(dowloadedFile);
		fo.close();
	}
}
