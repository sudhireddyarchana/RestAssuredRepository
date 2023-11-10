package apitests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test28
{
	public String userpayload;
	public String uid;
	public String token;
	public String bookpayload;
	public String isbn;
	public String booktitle;
	public String updatepayload;
	public String upadatedtitle;
	public String deletepayload;	
	
	@Test(priority=1)
	public void createUser() throws Exception
	{
		userpayload="{\r\n" + 
	    		"  \"userName\": \"batch263api7to9\",\r\n" + 
	    		"  \"password\": \"Cheating@263\"\r\n" + 
	    		"}";
	    RequestSpecification req=RestAssured.given();
	    req.baseUri("https://bookstore.toolsqa.com");
	    req.basePath("Account/v1/User");
	    req.header("Content-Type","application/json");
	    req.body(userpayload);
	    Response res=req.post();
	    res.then().log().all();
	    uid=res.body().jsonPath().getString("userID");
	    if(res.getStatusCode()==201 && uid!=null)
	    {
	    	Reporter.log("Successful creation of new user");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Reporter.log("Unsuccessful creation of new user");
	    	Assert.assertTrue(false);
	    }
	}
	
	@Test(priority=2, dependsOnMethods={"createUser"})
	public void verifyUser()
	{
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath("Account/v1/Authorized");
		 req.header("Content-Type","application/json");
		 req.body(userpayload);
		 Response res=req.post();
		 res.then().log().all();
		 String useroutput=res.body().asString();
		 Reporter.log(useroutput);
	}
	
	@Test(priority=3, dependsOnMethods={"createUser"})
	public void generateToken()
	{
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath("Account/v1/GenerateToken");
		 req.header("Content-Type","application/json");
		 req.body(userpayload);
		 Response res=req.post();
		 res.then().log().all();
		 token=res.body().jsonPath().getString("token");
		 if(res.getStatusCode()==200 && token!=null)
		 {
		    Reporter.log("Successful creation of token");
		    Assert.assertTrue(true);
		 }
		 else
		 {
			Reporter.log("Unsuccessful creation of token");
		    Assert.assertTrue(false);
		 }
	}
	
	@Test(priority=4, dependsOnMethods={"generateToken"})
	public void addBook()
	{
		 bookpayload="{\r\n" + 
					"  \"userId\": \""+uid+"\",\r\n" + 
					"  \"collectionOfIsbns\": [\r\n" + 
					"    {\r\n" + 
					"      \"isbn\": \"9781449337711\"\r\n" + 
					"    }\r\n" + 
					"  ]\r\n" + 
					"}";
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath("BookStore/v1/Books");
		 req.header("Content-Type","application/json");
		 req.header("Authorization","Bearer "+token);
		 req.body(bookpayload);
		 Response res=req.post();
		 res.then().log().all();
		 isbn=res.body().jsonPath().getString("books[0].isbn");
		 if(res.getStatusCode()==200 && isbn!=null)
		 {
		    Reporter.log("Successful addition of book to user");
		    Assert.assertTrue(true);
		 }
		 else
		 {
		    Reporter.log("Unsuccessful addition of book to user");
		    Assert.assertTrue(false);
		 }
	}
	
	@Test(priority=5, dependsOnMethods={"addBook"})
	public void getBook()
	{
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath("BookStore/v1/Book");
		 req.queryParam("ISBN",isbn);
		 req.header("Authorization","Bearer "+token);
		 req.header("Content-Type","application/json");
		 Response res=req.get();
		 res.then().log().all();
		 booktitle=res.body().jsonPath().getString("title");
		 Reporter.log(booktitle);
	}
	
	@Test(priority=6, dependsOnMethods={"addBook"})
	public void updateBook()
	{
		updatepayload="{\r\n" + 
				"  \"userId\": \""+uid+"\",\r\n" + 
				"  \"isbn\": \"9781449325862\"\r\n" + 
				"}";
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath("BookStore/v1/Books"+"/"+isbn);
		 req.header("Content-Type","application/json");
		 req.header("Authorization","Bearer "+token);
		 req.body(updatepayload);
		 Response res=req.put();
		 res.then().log().all();
		 upadatedtitle=res.body().jsonPath().getString("books[0].title");
		 if(res.getStatusCode()==200 && upadatedtitle!=null)
		 {
		    Reporter.log("Successful updation of book to user");
		    Assert.assertTrue(true);
		 }
		 else
		 {
		    Reporter.log("Unsuccessful updation of book to user");
		    Assert.assertTrue(false);
		 }
	}
	
	@Test(priority=7, dependsOnMethods={"addBook"})
	public void deleteBook()
	{
		deletepayload="{\r\n" + 
				"  \"isbn\": \"9781449325862\",\r\n" + 
				"  \"userId\": \""+uid+"\"\r\n" + 
				"}";
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath("BookStore/v1/Book");
		 req.header("Authorization","Bearer "+token);
		 req.header("Content-Type","application/json");
		 req.body(deletepayload);
		 Response res=req.delete();
		 res.then().log().all();
		 if(res.getStatusCode()==204)
		 {
		    Reporter.log("Successful deletion of book from user");
		    Assert.assertTrue(true);
		 }
		 else
		 {
		    Reporter.log("Unsuccessful deletion of book from user");
		    Assert.assertTrue(false);
		 }
	}
	
	@Test(priority=8, dependsOnMethods={"createUser"})
	public void deleteUser()
	{
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath("Account/v1/User"+"/"+uid);
		 req.header("Authorization","Bearer "+token);
		 Response res=req.delete();
		 res.then().log().all();
		 if(res.getStatusCode()==204)
		 {
		    Reporter.log("Successful deletion of user");
		    Assert.assertTrue(true);
		 }
		 else
		 {
		    Reporter.log("Unsuccessful deletion of user");
		    Assert.assertTrue(false);
		 }
	}
}
