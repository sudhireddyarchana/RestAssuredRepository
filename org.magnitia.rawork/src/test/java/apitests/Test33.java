package apitests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utilities.GmailAPIUtility;

public class Test33 
{
	public final String emailid="magnitiait@gmail.com";
	public final String password="Magnitia@262";
	//Step-1: get clientId and client-secret manually via navigation(one time only)
	public final String clientID="266575742681-2phr4lvnfbklnni94d9d5on6jt3adqnc.apps.googleusercontent.com";
	public final String clientsecret="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";
	public String desktopcode;
	public String AccessToken;
	public GmailAPIUtility obj;
	
	@BeforeClass
	public void setup() throws Exception
	{
		//Create object to utility class
		obj=new GmailAPIUtility();
		//Get desktop code
		desktopcode=obj.getDesktopCode(clientID, emailid, password);
		//Get access token
		AccessToken=obj.getAccessToken(desktopcode, clientID, clientsecret);
		System.out.println(AccessToken);
	}
	
	@Test(priority=1)
	public void getMailsWithDifferentParams()
	{
		//Get mails by giving max count
		Response res1=obj.getAllMailsViaMaxResults(AccessToken,emailid,200,true); //our required count is 200
		res1.then().log().all();
		//Get mails by giving page number
		Response res2=obj.getAllMailsViaPageToken(AccessToken, emailid,3,false); //page number is 3
		res2.then().log().all();
		//Get mails by giving search query
		Response res3=obj.getAllMailsViaQuery(AccessToken, emailid,"from:manoj.selenium44@gmail.com",true);
		res3.then().log().all();	
	}
	
	@Test(priority=2)
	public void getSpecificMail()
	{
		Response res1=obj.getAllMailsViaPageToken(AccessToken, emailid,1,false); //page number is 1
		res1.then().log().all();
		int count=res1.body().jsonPath().getInt("messages.size()");
		for(int i=0; i<count;i++)
		{
			String id=res1.body().jsonPath().getString("messages["+i+"].id");
			Response res2=obj.getMail(AccessToken, emailid, id);
			System.out.println(res2.body().jsonPath().getString("snippet"));
		}
	}
	
	@Test(priority=3)
	public void deleteSpecificMail()
	{
		Response res1=obj.getAllMailsViaQuery(AccessToken, emailid,"from:manoj.selenium44@gmail.com",true);
		res1.then().log().all();
		String id=res1.body().jsonPath().getString("messages[0].id");
		Response res2=obj.getMail(AccessToken, emailid, id);
		res2.then().log().all();
		Response res3=obj.deleteMail(AccessToken, emailid, id);
		res3.then().log().all();
	}
	
	@Test(priority=4)
	public void sendMailTospecificToAddress()
	{
		//Step-2: get base64 encoded value for mail content manually via navigation(for every new mail)
		String encodedbody="RnJvbTogbWFnbml0aWFpdEBnbWFpbC5jb20KVG86IG1hZ25pdGlhaXRAZ21haWwuY29tClN1YmplY3Q6IFRlc3QgRW1haWwKCkhpIHN0dWRlbnRzLCBwbGVhc2UgYWN0aXZlLiBkb24ndCBnZXQgYm9yaW5nLgpSZWdhcmRzCkd1cnUK";
		Response res1=obj.sendMail(AccessToken, emailid,encodedbody);
		res1.then().log().all();
	}
}








