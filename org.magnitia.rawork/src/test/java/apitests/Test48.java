package apitests;


import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class Test48
{
	public static void main(String[] args)
	{
		//Response data logs
		given()
			.baseUri("http://api.weatherapi.com/v1/current.json")
			.queryParam("key","e9c3b0195be341c795281747202311")
			.queryParam("q","hyderabad")
		.when()
			.get()
		.then()
			.statusCode(200)
			.statusCode(describedAs("weatherapi status code should be 200",is(200)))
			.header("contentType",describedAs("weatherapi response body should be in JSON",
					              containsStringIgnoringCase("JSON")))
			.body("location.country",describedAs("weatherapi body should be contains india",is("india")));
	}
}






