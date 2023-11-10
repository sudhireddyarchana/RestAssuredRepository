package utilities;
 
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class gitHubUtility 
{
public void createARepo(String uname,String pwd)
{
	String payload="{\r\n" + 
			"\"name\":\"TestingRepository\"\r\n" + 
			"}";
	Response response1=given()
	.baseUri("https://api.github.com")
	.basePath("user/repos")
	.auth().basic(uname, pwd)
	.header("Authorization", "Bearer "+pwd)
	.header("Content-Type", "application/json")
	.body(payload)
	.post();
	response1.then().log().all();
	String id=response1.body().jsonPath().getString("id");
	String name=response1.body().jsonPath().getString("name");
	System.out.println("ID is:"+id);
	System.out.println("name is:"+name);
}
public String getRepos(String uName,String pwd)
{
     Response response2=given()
     .baseUri("https://api.github.com")
     .basePath("users/"+uName+"/repos")
     .auth().basic(uName, pwd)
     .header("accept", "application/vnd.github+json")
     .header("Authorization", "Bearer "+pwd)
     .get();
     //response2.then().log().all(); 
     return response2.asPrettyString();
}
public void updateARepo(String uName,String pwd,String reponame)
{
	String repoName="{\r\n" + 
			"\"name\":\"UpdatedRepo\"\r\n" + 
			"}";
	  Response response3=given()
	  .baseUri("https://api.github.com")
	  .basePath("repos/"+uName+"/"+reponame)
	  .auth().basic(uName, pwd)
	  .header("accept", "application/vnd.github+json")
	  .header("Authorization", "Bearer "+pwd)
	  .body(repoName)
	  .patch();
	  String name=response3.body().jsonPath().getString("name");
	  System.out.println("updated repo name is:"+name);
	  response3.then().log().all();
}
public void getARepo(String uName,String pwd,String reponame)
{
	  Response response4=given()
	  .baseUri("https://api.github.com")
	  .basePath("repos/"+uName+"/"+reponame)
	  .auth().basic(uName, pwd)
	  .header("Authorization","Bearer "+pwd)
	  .get();
	  response4.then().log().all();
}
public void deleteARepo(String uName,String pwd,String reponame)
{
	  Response response5=given()
	  .baseUri("https://api.github.com")
	  .basePath("repos/"+uName+"/"+reponame)
	  .auth().basic(uName, pwd)
	  .header("accept", "application/vnd.github+json")
	  .header("Authorization","Bearer "+pwd)
	  .delete();
	  response5.then().log().all();
}
}
