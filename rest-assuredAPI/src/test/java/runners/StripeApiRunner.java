package runners;

import utilities.StripeAPIUtility;

public class StripeApiRunner
{
	public static void main(String[] args)
	{
		String ApiKey="sk_test_51Nt2X4SAougwendAJhtScZOeats7lBOiI6O1GxamAGKmnh88YOs"
				+ "7SbH1Com2hYJb9C0NidIJ7VxGkWyd0mREDZ8600vwU5MkFh";
		StripeAPIUtility object=new StripeAPIUtility();
		//create a customer
		
		String uid=object.createACustomer("/v1/customers", "malavika","archana12@gmail.com",ApiKey);
		System.out.println("userId is:"+uid);
		
        //retrieve a customer
		
		String result=object.retrieveACustomer("v1/customers", uid, ApiKey);
		System.out.println("email is:"+result);
		
		//list all customers
		
		object.listAllCustomers("v1/customers", ApiKey);
		
		//update a customer
		
		String name=object.updateACustomer("v1/customers", "priya", ApiKey, uid);
		System.out.println("updated name is:"+name);
		
		//delete a customer
		
		object.deleteACustomer("v1/customers", uid, ApiKey);
	}

}
