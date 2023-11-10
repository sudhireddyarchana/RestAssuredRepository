package pojos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class InjectPOJO
{
	@JsonUnwrapped
	private int userId; 
	
	@JsonUnwrapped
	private String password; 
	
	@JacksonInject("lastUpdated")
	private LocalDateTime lu; 
	
	@JacksonInject("doneBy")
	private String db; 
	
	public int getUserId()
	{
		return(userId);
	}
	public String getPassword()
	{
		return(password);
	}
	public LocalDateTime getLastUpdated()
	{
		return(lu);
	}
	public String getDoneBy()
	{
		return(db);
	}

}
