package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyJsonPojo1
{
	@JsonProperty("userId")
	private int uid;
	
	@JsonProperty("title")
	private String t;
	
	@JsonProperty("body")
	private String b;
	
	public void setUserId(int x)
	{
		this.uid=x;
	}
	
	public void setTitle(String x)
	{
		this.t=x;
	}
	
	public void setBody(String x)
	{
		this.b=x;
	}
}
