package utilities;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
public class StripeAPIUtility 
{
public String createACustomer(String BasePath,String name,String email,String apiKey)
{
	Response response1=given()
	.baseUri("https://api.stripe.com")
	.basePath(BasePath)
	.queryParam("name", name)
	.queryParam("email", email)
	.header("Content-Type", "application/json")
	.header("Authorization", "Bearer "+apiKey)
	.post();
	response1.then().log().all();
	String userId=response1.body().jsonPath().getString("id");
	//System.out.println("userId is:"+userId);
	return userId;
}
public String retrieveACustomer(String basePath,String uid,String apiKey)
{
	Response response2=given()
	.baseUri("https://api.stripe.com")
	.basePath(basePath+"/"+uid)
	.header("Content-Type", "application/json")
	.header("Authorization", "Bearer "+apiKey)
	.get();
	response2.then().log().all();
	String email=response2.body().jsonPath().getString("email");
	return email;
}
public void listAllCustomers(String basePath,String apiKey)
{
	Response response3=given()
			.baseUri("https://api.stripe.com")
			.basePath(basePath)
			.header("Content-Type", "application/json")
			.header("Authorization", "Bearer "+apiKey)
			.get();
			response3.then().log().all();
}
public String updateACustomer(String basePath,String name,String apiKey,String uid)
{
	Response response4=given()
			.baseUri("https://api.stripe.com")
			.basePath(basePath+"/"+uid)
			.queryParam("name", name)
			.header("Content-Type", "application/json")
			.header("Authorization", "Bearer "+apiKey)
			.post();
			response4.then().log().all();
			String Name=response4.body().jsonPath().getString("name");
			return Name;
}
public void deleteACustomer(String basePath,String uid,String apiKey)
{
	Response response5=given()
			.baseUri("https://api.stripe.com")
			.basePath(basePath+"/"+uid)
			.header("Content-Type", "application/json")
			.header("Authorization", "Bearer "+apiKey)
			.delete();
			response5.then().log().all();
}
}
