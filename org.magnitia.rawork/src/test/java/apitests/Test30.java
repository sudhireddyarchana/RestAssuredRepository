package apitests;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test30
{
	public final String uname="kalamgit143";
	public final String pwd="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";
	public String repoid;
	public String reponame;
	
	@Test(priority=1)
	public void createRepo()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://api.github.com"); 
		req.basePath("user/repos"); 
		req.auth().basic(uname, pwd);
		req.header("Authorization","Bearer "+pwd);
		String repopayload="{\r\n" + 
				"    \"name\":\"batch263apirepo\"\r\n" + 
				"}";
		req.header("Content-Type","application/json");
		req.body(repopayload);
	    Response res=req.post();
	    res.then().log().all(); //logging for us
		repoid=res.body().jsonPath().getString("id"); 
		reponame=res.body().jsonPath().getString("name"); 
		if(res.getStatusCode()==201 
				&& repoid!=null
				&& reponame.equals("batch263apirepo"))
	    {
	    	Reporter.log("Successful creation of new repo"); //reporting for management
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Reporter.log("Unsuccessful creation of new repo");
	    	Assert.assertTrue(false);
	    }
	}
	
	@Test(priority=2, dependsOnMethods= {"createRepo"})
	public void getAllRepos()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://api.github.com"); 
		req.basePath("users/"+uname+"/repos"); 
		req.auth().basic(uname, pwd);
		req.header("Authorization","Bearer "+pwd);
		req.header("accept","application/vnd.github+json");
	    Response res=req.get();
	    res.then().log().all(); //logging for us
	    List<String> names=res.body().jsonPath().getList("name");
	    int flag=0;
	    for(String name:names)
	    {
	    	if(name.equals(reponame))
	    	{
	    		flag=1;
	    		break;
	    	}
	    }
	    if(flag==1)
	    {
	    	Reporter.log("newely created repo found in existing repos"); //reporting for management
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Reporter.log("newely created repo not found in existing repos");
	    	Assert.assertTrue(false);
	    }
	}
	
	@Test(priority=3,dependsOnMethods= {"getAllRepos"})
	public void updateRepo()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://api.github.com"); 
		req.basePath("repos/"+uname+"/"+reponame); 
		req.auth().basic(uname, pwd);
		req.header("Authorization","Bearer "+pwd);
		String updatepayload="{\r\n" + 
				"    \"name\":\"batch263apirepoupdated\"\r\n" + 
				"}";
		req.header("Content-Type","application/json");
		req.body(updatepayload);
	    Response res=req.patch();
	    res.then().log().all(); //logging for us
		reponame=res.body().jsonPath().getString("name"); //copy updated name
		if(res.getStatusCode()==200 
				&& reponame.equals("batch263apirepoupdated"))
	    {
	    	Reporter.log("Successful updation of new repo"); //reporting for management
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Reporter.log("Unsuccessful updation of new repo");
	    	Assert.assertTrue(false);
	    }
	}
	
	@Test(priority=4, dependsOnMethods= {"updateRepo"})
	public void deleteRepo()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://api.github.com"); 
		req.basePath("repos/"+uname+"/"+reponame); 
		req.auth().basic(uname, pwd);
		req.header("Authorization","Bearer "+pwd);
	    Response res=req.delete();
	    res.then().log().all(); //logging for us
		if(res.getStatusCode()==204)
	    {
	    	Reporter.log("Successful deletion of repo"); //reporting for management
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Reporter.log("Unsuccessful deletion of repo");
	    	Assert.assertTrue(false);
	    }
	}
	
	@Test(priority=5, dependsOnMethods= {"deleteRepo"})
	public void getRepo()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://api.github.com"); 
		req.basePath("repos/"+uname+"/"+reponame); 
		req.auth().basic(uname, pwd);
		req.header("Authorization","Bearer "+pwd);
	    Response res=req.get();
	    res.then().log().all(); //logging for us
	    if(res.getStatusCode()==404)
	    {
	    	Reporter.log("newely created repo succesfully deleted");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Reporter.log("newely created repo not succesfully deleted");
	    	Assert.assertTrue(false);
	    }
	}
}
