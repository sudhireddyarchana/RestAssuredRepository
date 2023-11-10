package apitests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test31 
{
	public final String clientID="266575742681-2phr4lvnfbklnni94d9d5on6jt3adqnc.apps.googleusercontent.com";
	public final String clientsecret="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";
	public final String desktopcode="4/0AVHEtk5VSnV5_54I6BQ6KYnJ1D16eimdNxOCI0bghS9GMEuqyt8bTb0eVnAtWuLmEHORTw";
	
	@Test
	public void getAccessToken()
	{
		Response res=RestAssured.given().urlEncodingEnabled(false)
            .baseUri("https://www.googleapis.com/oauth2/v4/token")
            .queryParam("code",desktopcode)
            .queryParam("client_id",clientID)
            .queryParam("client_secret",clientsecret)
            .queryParam("redirect_uri", "http://localhost")
            .queryParam("grant_type","authorization_code")
            .when().post();
		System.out.println("The response with Access Token is : " +res.asPrettyString());
		String AccessToken = res.jsonPath().get("access_token");
		System.out.println(AccessToken);
	} 
}
