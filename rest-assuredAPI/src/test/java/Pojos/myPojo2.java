package Pojos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class myPojo2 
{
	@JsonProperty("userId")
	private int uid;
	@JsonProperty("title")
	private List<String> t;
	@JsonProperty("body")
	private String b;
	
	public int getuserId() {
		return uid;
	}
	public void setuserId(int uid) {
		this.uid = uid;
	}
	public List<String> gettitle() {
		return t;
	}
	public void settitle(List<String> t) {
		this.t = t;
	}
	public String getbody() {
		return b;
	}
	public void setbody(String b) {
		this.b = b;
	}
	
}
