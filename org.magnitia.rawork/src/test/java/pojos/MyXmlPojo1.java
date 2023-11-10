package pojos;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JacksonXmlRootElement(localName="Request")
public class MyXmlPojo1
{
	@JacksonXmlProperty(localName="Login")
	private String uid;
	
	@JacksonXmlProperty(localName="Password")
	private String pwd;
	
	public void setLogin(String x)
	{ 
		 this.uid=x;
	} 
	    
	public void setPassword(String x) 
	{ 
		this.pwd=x;
	} 
}
