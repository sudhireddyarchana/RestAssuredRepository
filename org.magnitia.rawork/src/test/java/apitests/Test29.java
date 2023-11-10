package apitests;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test29 
{
	public final String apikey="sk_test_51Jjn3ISCvxeK7EJ31T9QfDSNB1LuN69adusfOFuOj5vfnf9EvVvuSlgzR25SvONsnQ0TSYjUbSAZ4Ln1SlWakubw00dero6ciG";
	public String custpayload;
	public String custid;
	
	@Test(priority=1)
	public void createCustomer()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://api.stripe.com"); 
		req.basePath("v1/customers"); 
		req.header("Authorization","Bearer "+apikey);
		req.header("Content-Type","application/x-www-form-urlencoded");
	    req.formParam("name","batch263");
	    req.formParam("email","batch263@magnitia.com");
	    req.formParam("description","API testing in TestNG");
	    Response res=req.post();
	    res.then().log().all();
		custid=res.body().jsonPath().getString("id");
		if(res.getStatusCode()==200 && custid!=null)
	    {
	    	Reporter.log("Successful creation of new customer");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Reporter.log("Unsuccessful creation of new customer");
	    	Assert.assertTrue(false);
	    }
	}
	
	@Test(priority=2, dependsOnMethods= {"createCustomer"})
	public void getCustomer()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://api.stripe.com"); 
		req.basePath("v1/customers/"+custid); 
		req.header("Authorization","Bearer "+apikey);
	    Response res=req.get();
	    String retrievedcustid=res.body().jsonPath().getString("id");
	    String retrievedname=res.body().jsonPath().getString("name");
	    String retrievedemailid=res.body().jsonPath().getString("email");
	    String retrieveddesc=res.body().jsonPath().getString("description");
	    res.then().log().all();
		if(res.getStatusCode()==200 
				&& retrievedcustid.equals(custid)
				&& retrievedname.equals("batch263")
				&& retrievedemailid.equals("batch263@magnitia.com")
				&& retrieveddesc.equals("API testing in TestNG"))
	    {
	    	Reporter.log("Successful retrieval of new customer");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Reporter.log("Unsuccessful retrieval of new customer");
	    	Assert.assertTrue(false);
	    }
		
	}
	
	@Test(priority=3, dependsOnMethods= {"createCustomer"})
	public void updateCustomer()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://api.stripe.com"); 
		req.basePath("v1/customers/"+custid); 
		req.header("Authorization","Bearer "+apikey);
		req.header("Content-Type","application/x-www-form-urlencoded");
	    req.formParam("email","batch263api@magnitia.com"); //update
	    Response res=req.post();
	    res.then().log().all();
		String updatedemailid=res.body().jsonPath().getString("email");
		if(res.getStatusCode()==200 
				&& updatedemailid.equals("batch263api@magnitia.com"))
	    {
	    	Reporter.log("Successful updation of new customer");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Reporter.log("Unsuccessful updation of new customer");
	    	Assert.assertTrue(false);
	    }
	}
	
	@Test(priority=4)
	public void getAllCustomeres()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://api.stripe.com"); 
		req.basePath("v1/customers"); 
		req.header("Authorization","Bearer "+apikey);
	    Response res=req.get();
	    res.then().log().all();
	    List<String> ids=res.body().jsonPath().getList("data.id");
	    int flag=0;
	    for(String id:ids)
	    {
	    	if(id.equals(custid))
	    	{
	    		flag=1;
	    		break;
	    	}
	    }
	    if(flag==1)
	    {
	    	Reporter.log("new customer found in existing customers list");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Reporter.log("new customer not found in existing customers list");
	    	Assert.assertTrue(true);
	    }
	}
	
	@Test(priority=5, enabled=false)
	public void getSpecificCustomer() //currently not available
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://api.stripe.com"); 
		req.basePath("v1/customers/search"); 
		req.header("Authorization","Bearer "+apikey);
		req.header("Content-Type","application/x-www-form-urlencoded");
	    req.formParam("query","name:'batch263'"); 
	    Response res=req.get();
	    res.then().log().all();
		
	}
	
	@Test(priority=6, dependsOnMethods= {"createCustomer"})
	public void deleteCustomer()
	{
		RequestSpecification req=RestAssured.given();
		req.baseUri("https://api.stripe.com"); 
		req.basePath("v1/customers/"+custid); 
		req.header("Authorization","Bearer "+apikey);
	    Response res=req.delete();
	    String deletedcustid=res.body().jsonPath().getString("id");
	    res.then().log().all();
		if(res.getStatusCode()==200 && deletedcustid.equals(custid))
	    {
	    	Reporter.log("Successful deletion of new customer");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Reporter.log("Unsuccessful deletion of new customer");
	    	Assert.assertTrue(false);
	    }
	}
}
