package utilities;

import static io.restassured.RestAssured.*;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookStoreUtility 
{
public String createUser(String path,String payload) 
{
	 Response response=given()
	.baseUri("https://bookstore.toolsqa.com")
	.basePath(path)
	.header("Content-Type", "application/json")
	.body(payload)
	.post();
	// String res=response.asString();
	 String uid=response.body().jsonPath().getString("userID");
	 System.out.println("uid is:"+uid);
	 /*File f=new File("src/test/resources/myuserid.txt");
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
	    }*/
	 response.then().log().all();
	 return uid;
}
public String verifyUser(String path,String payload)
{
	Response response1=given()
	.baseUri("https://bookstore.toolsqa.com")
	.basePath(path)
	.header("Content-Type", "application/json")
	.body(payload)
	.post();
	 String res=response1.asString();
	response1.then().log().all();
	return res;
}
public String generateToken(String path,String payload)
{
	Response response2=given()
	.baseUri("https://bookstore.toolsqa.com")
	.basePath(path)
	.header("Content-Type", "application/json")
	.body(payload)
	.post();
	String token=response2.body().jsonPath().getString("token");
	System.out.println("token is=======>"+token);
	response2.then().log().all();
	return token;
}
public String addBook(String path,String payload,String token)
{
	Response response3=given()
	.baseUri("https://bookstore.toolsqa.com")
	.basePath(path)
	.header("Content-Type", "application/json")
	.header("Authorization","Bearer "+token)
	.body(payload)
	.post();
	response3.then().log().all();
	String isbn=response3.body().jsonPath().getString("books[0].isbn");
	System.out.println("ISBN is:=====:"+isbn);
	return response3.asPrettyString();
}
public String getBook(String path,String isbn,String token)
{
	Response response4=given()
	.baseUri("https://bookstore.toolsqa.com")
	.basePath(path)
	.queryParam("ISBN", isbn)
	.header("Content-Type", "application/json")
	.header("Authorization", "Bearer "+token)
	.get();
	response4.then().log().all();
	 return(response4.body().jsonPath().getString("title"));
}
public String getAllBooks(String path,String token)
{
	Response response4=given()
	.baseUri("https://bookstore.toolsqa.com")
	.basePath(path)
	.header("Content-Type", "application/json")
	.header("Authorization", "Bearer "+token)
	.get();
	response4.then().log().all();
	 return(response4.body().asPrettyString());
}
public String updateBook(String bp,String payload,String isbn,String token)
{
	  Response res=given()
	 .baseUri("https://bookstore.toolsqa.com")
	 .basePath(bp+"/"+isbn)
	 .header("Content-Type","application/json")
	 .header("Authorization","Bearer "+token)
	 .body(payload)
	 .put();
	 res.then().log().all();
	 return(res.body().jsonPath().getString("books[3].author"));
}
public String deleteBook(String bp,String payload,String token)
{
	  Response res=given()
	 .baseUri("https://bookstore.toolsqa.com")
	 .basePath(bp)
	 .header("Authorization","Bearer "+token)
	 .header("Content-Type","application/json")
	 .body(payload)
	 .delete();
	 res.then().log().all();
	 return res.body().asPrettyString();
}
public void deleteUser(String bp,String uid,String token)
{
	 RequestSpecification req=RestAssured.given();
	 req.baseUri("https://bookstore.toolsqa.com");
	 req.basePath(bp+"/"+uid);
	 req.header("Authorization","Bearer "+token);
	 Response res=req.delete();
	 res.then().log().all();
}
}
