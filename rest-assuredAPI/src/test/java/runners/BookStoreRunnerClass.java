package runners;

import java.io.IOException;

import utilities.BookStoreUtility;

public class BookStoreRunnerClass 
{
	public static void main(String[] args) throws IOException
	{
		String payload="{\r\n" + 
				"\"userName\":\"bubbyarchana102\",\r\n" + 
				"\"password\":\"Bubby@923\"\r\n" + 
				"}";
		
		String ISBN="9781449325862";
		String ISBN1="9781449365035";
		//calling createUser method
		BookStoreUtility object=new BookStoreUtility();
		String uid=object.createUser("Account/v1/User", payload);
		 System.out.println("create user response=====:>"+uid);
		String payloadForAddbook="{\r\n" + 
					"  \"userId\": \""+uid+"\",\r\n" + 
					"  \"collectionOfIsbns\": [\r\n" + 
					"    {\r\n" + 
					"      \"isbn\": \"9781449325862\"\r\n" + 
					"    }\r\n" + 
					"  ]\r\n" + 
					"}";
		//update book
		String payloadForAddbook1="{\r\n" + 
				"  \"userId\": \""+uid+"\",\r\n" + 
				"  \"isbn\": \"9781449365035\"\r\n" + 
				"}";
		//delete book
				String w="{\r\n" + 
						"  \"isbn\": \"9781449365035\",\r\n" + 
						"  \"userId\": \""+uid+"\"\r\n" + 
						"}";
        //calling verifyUser method
        String result2=object.verifyUser("Account/v1/Authorized", payload);
	    System.out.println("verify user response=====:>"+result2);
	    //calling generateToken method
	    String Token=object.generateToken("Account/v1/GenerateToken", payload);
	    System.out.println("generate Token response====:>"+Token);
	    //get all books
	    String allBooks=object.getAllBooks("BookStore/v1/Books", Token);
	    System.out.println("All books:"+allBooks);
	     //add book method
	    String result4=object.addBook("BookStore/v1/Books", payloadForAddbook,Token);
	    System.out.println("add book response========:"+result4);
	    
	    //update book
	    String authorName=object.updateBook("BookStore/v1/Books", payloadForAddbook1, ISBN, Token);
	    System.out.println("author is:"+authorName);
	    //delete book
	    String result6=object.deleteBook("BookStore/v1/Book", w, Token);
	    System.out.println("delete book response is"+result6);
	  //get book using ISBN
	    String result5=object.getBook("BookStore/v1/Book", ISBN1, Token);
	    System.out.println("get book response is:========="+result5);
	    //delete user
	    object.deleteUser("Account/v1/User", uid, Token);
	}

}
