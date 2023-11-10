package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookStorePojo2
{
	//Private properties
	@JsonProperty("token") private String t;
	@JsonProperty("expires") private String e;
	@JsonProperty("status") private String s;
	@JsonProperty("result") private String r;

    //getters
    public String getToken()
    { 
		 return(this.t); 
	} 
    
    public String getExpires() 
    { 
    	return(this.e); 
	} 
   
    public String getStatus() 
    { 
    	return(this.s); 
	} 
    
    public String getResult() 
    { 
    	return(this.r); 
	}
}
