package apitests;


import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class Test49
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
			.statusCode(describedAs("weatherapi status code test",is(200)))
			.contentType(describedAs("weatherapi header test",containsStringIgnoringCase("JSON")))
			.body("location.country",describedAs("weatherapi body test",is("India")))
			.log().all()
			.log().ifError()
			.log().ifValidationFails()
			.log().ifStatusCodeIsEqualTo(200)
			.log().ifStatusCodeMatches(is(200))
			.log().everything();
	}
}






