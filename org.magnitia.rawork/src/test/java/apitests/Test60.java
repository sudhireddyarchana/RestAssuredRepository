package apitests;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.InjectPOJO;

public class Test60 
{
	public static void main(String[] args) throws Exception
	{
		//Provide values to extra fields
	    InjectableValues.Std iv=new InjectableValues.Std();
	    iv.addValue("lastUpdated", LocalDateTime.now()); 
	    iv.addValue("doneBy","batch263");
	    ObjectMapper om=new ObjectMapper();  
	    om.setInjectableValues(iv);
	    //Desrialize Json payload into object of Pojo classs 
	    String body="{\r\n" + 
	    		"  \"userId\":111,\r\n" + 
	    		"  \"password\":\"students\"\r\n" + 
	    		"}"; 
	    InjectPOJO obj=om.readValue(body, InjectPOJO.class); 
	    System.out.println(obj.getUserId()+","+obj.getPassword()+","+obj.getLastUpdated()+","+obj.getDoneBy()); 

	}

}
