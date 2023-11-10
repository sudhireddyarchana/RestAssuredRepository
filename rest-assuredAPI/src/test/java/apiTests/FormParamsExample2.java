package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FormParamsExample2 
{
	public static void main(String[] args) 
	{
		//Create a HTTP request with form parameters for API1
	RequestSpecification req=RestAssured.given();	
	req.baseUri("https://www.smatbot.com");
	req.basePath("kya_backend/pagehub/chatbot_utils");
	req.header("Content-Type", "application/x-www-form-urlencoded");
    req.formParam("action", "init_chat");
    req.formParam("device_print", "ed79cf898a7951b5f8858d2d7f4f106f");
    req.formParam("chatbot_id", "4174");
    req	.formParam("name","SmatBot");
	req	.formParam("language_code","default");
    //Submit Request via POST method
    Response res=req.post();
   String x=res.jsonPath().getString("cb_session");
   System.out.println(x);
 //Create a HTTP request with form parameters for API2
 		RequestSpecification req2=RestAssured.given();
 		req2.baseUri("https://www.smatbot.com");
 		req2.basePath("kya_backend/pagehub/chatbot_utils");
 		req2.header("Content-Type","application/x-www-form-urlencoded"); //optional
 		req2.formParam("action","answer");
 		req2.formParam("answer_text","test");
 		req2.formParam("cb_session",x); //parameterized
 		req2.formParam("question_id",4017);
 		req2.formParam("is_logical",0);
 		req2.formParam("sequence",2);
 		req2.formParam("chatbot_id",4174);
 		req2.formParam("option","undefined");
 		req2.formParam("visitor_link_traversal","");
 		req2.formParam("language_code","default");
 		System.out.println("Request");
 	    System.out.println("--------");
 	    req2.given().log().all();
 	    //Submit Request via POST method
 	    Response res2=req2.post();
 	    //Display whole Response
 	    System.out.println("Response");
 	    System.out.println("--------");
 	    res2.then().log().all();
	}

}
