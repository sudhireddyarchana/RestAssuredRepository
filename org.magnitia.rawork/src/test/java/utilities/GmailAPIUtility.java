package utilities;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GmailAPIUtility
{
	public String getDesktopCode(String clientID, String emailid, String password) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/gmail.modify&auth_url=https://accounts.google.com/o/oauth2/auth&client_id="+clientID+"&response_type=code&redirect_uri=http://localhost&state=");
		Thread.sleep(5000);
		driver.findElement(By.name("identifier")).sendKeys(emailid);
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Continue']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()='Continue']/parent::button")).click();
		Thread.sleep(5000);
		String[] arr1=driver.getCurrentUrl().split("code=");
	    String arr2[]=arr1[1].split("&scope=");
	    String code=arr2[0];
	    driver.close();
	    return(code);
	}
	public String getAccessToken(String desktopcode, String clientID, String clientsecret)
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
		return(AccessToken);
	}
	public Response getAllMailsViaMaxResults(String AccessToken, String emailid, int max, boolean spam)
	{
		Response r=given().baseUri("https://gmail.googleapis.com")
		           .basePath("/gmail/v1/users/"+emailid+"/messages")
		           .header("Authorization","Bearer "+AccessToken)
		           .queryParam("maxResults",max)
		           .queryParam("includeSpamTrash",spam) //only to work with INBOX+promotions+social
		    .when()
		           .get();
		return(r);
	}
	
	public Response getAllMailsViaPageToken(String AccessToken, String emailid, int pn, boolean spam)
	{
		Response r=given().baseUri("https://gmail.googleapis.com")
		           .basePath("/gmail/v1/users/"+emailid+"/messages")
		           .header("Authorization","Bearer "+AccessToken)
		           .queryParam("pageToken",pn)
		           .queryParam("includeSpamTrash",spam)
		    .when()
		           .get();
		return(r);
	}
	
	public Response getAllMailsViaQuery(String AccessToken, String emailid, String query, boolean spam)
	{
		Response r=given().baseUri("https://gmail.googleapis.com")
		           .basePath("/gmail/v1/users/"+emailid+"/messages")
		           .header("Authorization","Bearer "+AccessToken)
		           .queryParam("q",query)
		           .queryParam("includeSpamTrash",spam)
		    .when()
		           .get();
		return(r);
	}
	
	public Response getMail(String AccessToken, String emailid, String id)
	{
		Response r=given().baseUri("https://gmail.googleapis.com")
		           .basePath("/gmail/v1/users/"+emailid+"/messages/"+id)
		           .header("Authorization","Bearer "+AccessToken)
		           .queryParam("format","minimal")
		    .when()
		           .get();
		return(r);
	}
	
	public Response sendMail(String AccessToken, String emailid, String encodedbody)
	{
		String temp="{\r\n" + 
				"  \"raw\":\""+encodedbody+"\"\r\n" + 
				"}";
		Response r=given().baseUri("https://gmail.googleapis.com")
		           .basePath("/gmail/v1/users/"+emailid+"/messages/send")
		           .header("Authorization","Bearer "+AccessToken)
		           .body(temp)
		    .when()
		           .post();
		return(r);
	}
	
	public Response deleteMail(String AccessToken, String emailid, String id)
	{
		Response r=given().baseUri("https://gmail.googleapis.com")
		           .basePath("/gmail/v1/users/"+emailid+"/messages/"+id)
		           .header("Authorization","Bearer "+AccessToken)
		    .when()
		           .delete();
		return(r);
	}
	
}
