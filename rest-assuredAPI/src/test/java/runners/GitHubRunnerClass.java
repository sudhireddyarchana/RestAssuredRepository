package runners;

import utilities.gitHubUtility;

public class GitHubRunnerClass {

	public static void main(String[] args) 
	{
		final String userName="TestingUser9610";
		final String password="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";
		
		//create a repository
		
		gitHubUtility object= new gitHubUtility();
		object.createARepo(userName, password);
		
		//get All repositories
		
		String result=object.getRepos(userName, password);
        System.out.println("Repositories:======>"+result);
        
        //update a Repository
        
        object.updateARepo(userName, password,"TestingRepo116");
        
        //get a specific Repository
        
        object.getARepo(userName, password, "APIRepository");
        
        //delete a specific Repository
        
        object.deleteARepo(userName, password, "UpdatedTestRepository");
	}

}
