package apiTests;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FileDownload
{

	public static void main(String[] args) throws IOException 
	{
		//Create HTTP request and submit
				Response res=given()
						                .baseUri("https://chercher.tech")
						                .basePath("files/minion.zip") //required file name as path parameter
					                    .when()
						                .get();
				//Diplay response details
				System.out.println(res.getStatusCode());
				System.out.println(res.getHeader("Content-Type"));
				res.then().log().all();
				//save that downloaded file content into a new local file
				byte[] dowloadedFile=res.getBody().asByteArray();
				File f=new File("target\\minios-from-rest-assured.zip");
				FileOutputStream fo=new FileOutputStream(f);
				fo.write(dowloadedFile);
				fo.close();

	}

}
