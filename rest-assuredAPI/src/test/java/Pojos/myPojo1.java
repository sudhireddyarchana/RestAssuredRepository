package Pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class myPojo1 
{
@JsonProperty("userId")
private int uid;
@JsonProperty("title")
private String t;
@JsonProperty("body")
private String b;
public int getuserId() {
	return uid;
}
public void setuserId(int uid) {
	this.uid = uid;
}
public String gettitle() {
	return t;
}
public void settitle(String t) {
	this.t = t;
}
public String getbody() {
	return b;
}
public void setbody(String b) {
	this.b = b;
}
}
