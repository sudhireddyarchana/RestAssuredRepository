package apitests;


import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.*;

public class Test47
{
	public static void main(String[] args)
	{
		given()
			.baseUri("https://restcountries.com")
			.basePath("v3.1/all")
		.when()
			.get()
		.then()
		.statusCode(200)
		.header("Content-Type",containsStringIgnoringCase("JSON"))
		//1. field's value testing
		.body("[93].capital[0]",is("New Delhi"))   //value with case
		.body("[93].capital[0].length()",is(9)) //value length
		.body("[93].capital[0]",containsString("w De")) //value contains
		.body("[93].capital[0]",startsWith("Ne")) //value starts with
		.body("[93].capital[0]",endsWith("hi")) //value ends with
		.body("[93].capital[0]",equalToIgnoringCase("new delhi")) //value without case
		.body("[93].capital[0]",equalToCompressingWhiteSpace("New    Delhi")) 
		                                      //value without considering count of spaces
		.body("[93].capital[0]",containsStringIgnoringCase("ew de")) 
		                                                    //value contains without case
		.body("[93].capital[0]",not("Delhi")) //value not a Delhi
		.body("[93].capital[0]",isA(String.class)) //value type is String
		.body("find{it.name.common in ['India','INDIA','india']}.region",equalTo("Asia"))
		.body("[93].capital[0]",matchesRegex("^[A-Z][a-z]+[\\s][A-Z][a-z]+$")) 
																//value format 
		.body("[93].capital[0]",matchesRegex("^[^0-9]+$")) //value not a number
		//2. array of values testing
		.body("find{it.name.common=='India'}.borders",hasSize(6)) //size of array of values(way-1)
		.body("find{it.name.common=='India'}.borders.size()",is(6)) //size of array of values(way-2)
		.body("find{it.name.common=='India'}.borders",hasItem("PAK")) //item in an array of values
		.body("find{it.name.common=='India'}.borders",hasItems("BGD","PAK")) //some or all items in an array
		.body("find{it.name.common=='India'}.borders",contains("BGD", "BTN", "MMR", "CHN", "NPL", "PAK"))
		                                                //with considering order of all values
		.body("find{it.name.common=='India'}.borders",
				containsInAnyOrder("BGD", "BTN", "NPL", "PAK", "MMR", "CHN"))
		                                          //without considering order of all values
		.body("find{it.name.common=='India'}.borders[0].length()",is(3)) 
		                                          //specific border value size
		.body("find{it.name.common=='India'}.borders*.length()",contains(3,3,3,3,3,3))
		                                         //all border values size
		.body("findAll{it.borders=~'IND'}.size()",is(7))
		.body("findAll{it.borders=~'IND'}.name.common",hasItem("Sri Lanka"))
		.body("find{it.name.common=='Malaysia'}.latlng.min()",is(2.5F))
		.body("find{it.name.common=='Malaysia'}.latlng.max()",is(112.5F))
		.body("find{it.name.common=='Malaysia'}.latlng.sum()",is(115.0))
		//3. a JSON object, which has entries as (key,value) pairs
		.body("[93]",hasKey("name")) //search for a key
		.body("[93]",hasValue("Asia")) //search for a value
		.body("[93].name",hasEntry("common","India")) //search for an entry(key,value)
		.body("findAll{it.name.common !in ['India','INDIA','india']}",hasSize(249))
		.body("population.min()",is(0))
		.body("min{it.population}.name.common",
										is("Bouvet Island"))
		.body("population.max()",is(1402112000))
		.body("max{it.population}.name.common",is("China"))
		//4. array of JSON objects(unnamed or named)
		.body("$",hasSize(250)) //on count of all JSON objects in an array
		.body("$.size()",is(250)) //on count of all JSON objects in an array
		.time(lessThan(5000L)) //response time in milliseconds
		.time(lessThan(5L),TimeUnit.SECONDS); //response time in seconds
	}
}




