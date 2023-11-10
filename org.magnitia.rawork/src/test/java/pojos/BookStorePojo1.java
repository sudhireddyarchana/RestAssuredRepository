package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookStorePojo1
{
	//Private properties
	@JsonProperty("userName") private String un;
	@JsonProperty("password") private String pwd;
	
	//setters
	public void setUserName(String x)
    {
        this.un=x;
    }
	public void setPassword(String x)
    {
        this.pwd=x;
    }
}
