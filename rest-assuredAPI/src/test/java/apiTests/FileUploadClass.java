package apiTests;
import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.response.Response; 
public class FileUploadClass 
{
	public static void main(String[] args)
	{	
    File file= new File("C:\\APIProject\\APIProject\\rest-assuredAPI\\charminar.png");
    Response res=given()
    .baseUri("https://the-internet.herokuapp.com")
    .basePath("upload")
    .multiPart("file", file, "multipart/form-data")
  //control name is "file" by default
  		//common MIME type for any type of file is "multipart/form-data"
    .post();
    System.out.println(res.statusCode());
    System.out.println(res.body().asPrettyString());
	}

}
