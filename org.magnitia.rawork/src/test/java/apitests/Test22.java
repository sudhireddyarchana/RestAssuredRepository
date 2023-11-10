package apitests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test22
{
	public static void main(String[] args) throws Exception
	{
		//send requests and get responses
		String x="{\r\n" + 
	    		"  \"userName\": \"batch263api7to9\",\r\n" + 
	    		"  \"password\": \"Cheating@263\"\r\n" + 
	    		"}";
		String uid=createUser("Account/v1/User",x);
		System.out.println(uid);
		String output=verifyUser("Account/v1/Authorized",x);
		System.out.println(output);
		String token=generateToken("Account/v1/GenerateToken",x);
		System.out.println(token);
		//Add book
		String y="{\r\n" + 
				"  \"userId\": \""+uid+"\",\r\n" + 
				"  \"collectionOfIsbns\": [\r\n" + 
				"    {\r\n" + 
				"      \"isbn\": \"9781449337711\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		String isbn=addBook("BookStore/v1/Books",y,token);
		System.out.println(isbn);
		//Get book
		String bt=getBook("BookStore/v1/Book",isbn,token);
		System.out.println(bt);
		//update book
		String z="{\r\n" + 
				"  \"userId\": \""+uid+"\",\r\n" + 
				"  \"isbn\": \"9781449325862\"\r\n" + 
				"}";
		String mbt=updateBook("BookStore/v1/Books",z,isbn,token);
		System.out.println(mbt);
		//delete book
		String w="{\r\n" + 
				"  \"isbn\": \"9781449325862\",\r\n" + 
				"  \"userId\": \""+uid+"\"\r\n" + 
				"}";
		deleteBook("BookStore/v1/Book",w,token);
		//delete user
		deleteUser("Account/v1/User",uid,token);
	}
	
	public static String createUser(String bp, String payload) throws Exception
	{
	    RequestSpecification req=RestAssured.given();
	    req.baseUri("https://bookstore.toolsqa.com");
	    req.basePath(bp);
	    req.header("Content-Type","application/json");
	    req.body(payload);
	    Response res=req.post();
	    res.then().log().all();
	    String uid=res.body().jsonPath().getString("userID");
	    File f=new File("src/test/resources/myuserid.txt");
	    if(uid!=null)
	    {
	    	FileWriter fw=new FileWriter(f);
	    	BufferedWriter bw=new BufferedWriter(fw);
	    	bw.write(uid);
	    	bw.close();
	    	fw.close();
	    }
	    else
	    {
	    	FileReader fr=new FileReader(f);
	    	BufferedReader br=new BufferedReader(fr);
	    	uid=br.readLine();
	    	br.close();
	    	fr.close();
	    }
	    return(uid);
	}
	public static String verifyUser(String bp, String payload)
	{
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath(bp);
		 req.header("Content-Type","application/json");
		 req.body(payload);
		 Response res=req.post();
		 res.then().log().all();
		 return(res.body().asString());
	}
	public static String generateToken(String bp, String payload)
	{
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath(bp);
		 req.header("Content-Type","application/json");
		 req.body(payload);
		 Response res=req.post();
		 res.then().log().all();
		 return(res.body().jsonPath().getString("token"));
	}
	public static String addBook(String bp, String payload, String token)
	{
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath(bp);
		 req.header("Content-Type","application/json");
		 req.header("Authorization","Bearer "+token);
		 req.body(payload);
		 Response res=req.post();
		 res.then().log().all();
		 return(res.body().jsonPath().getString("books[0].isbn"));
	}
	public static String getBook(String bp, String isbn, String token)
	{
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath(bp);
		 req.queryParam("ISBN",isbn);
		 req.header("Authorization","Bearer "+token);
		 req.header("Content-Type","application/json");
		 Response res=req.get();
		 res.then().log().all();
		 return(res.body().jsonPath().getString("title"));
	}
	public static String updateBook(String bp,String payload,String isbn,String token)
	{
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath(bp+"/"+isbn);
		 req.header("Content-Type","application/json");
		 req.header("Authorization","Bearer "+token);
		 req.body(payload);
		 Response res=req.put();
		 res.then().log().all();
		 return(res.body().jsonPath().getString("books[0].title"));
	}
	public static void deleteBook(String bp,String payload,String token)
	{
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath(bp);
		 req.header("Authorization","Bearer "+token);
		 req.header("Content-Type","application/json");
		 req.body(payload);
		 Response res=req.delete();
		 res.then().log().all();
	}
	public static void deleteUser(String bp,String uid,String token)
	{
		 RequestSpecification req=RestAssured.given();
		 req.baseUri("https://bookstore.toolsqa.com");
		 req.basePath(bp+"/"+uid);
		 req.header("Authorization","Bearer "+token);
		 Response res=req.delete();
		 res.then().log().all();
	}
}
