package apitests;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class Test1 
{
	public static void main(String[] args) 
	{
		//1. Make a Request
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
		//2. Submit request via HTTP method to get response
		Response res=RestAssured.get();
		//3. Analyze response
		System.out.println("Status line is:");
		String x=res.getStatusLine();
		System.out.println(x);
		System.out.println("Headers are:");
		Headers y=res.getHeaders();
		List<Header> lh=y.asList();
		for(Header h:lh)
		{
			System.out.println(h.getName()+"<---->"+h.getValue());
		}
		System.out.println("Respnose Body is:");
		String z=res.getBody().asString();
		System.out.println(z);
	}
}
