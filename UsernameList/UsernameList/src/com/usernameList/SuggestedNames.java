package com.usernameList;

import java.util.ArrayList;

public class SuggestedNames {

	private ArrayList<String> suggestions = new ArrayList<String>();
	
	public  ArrayList<String> getSuggestedNames(String user){
	
		ArrayList<String> restrictions = DbController.getBase(Constants.DATA_BASE_RESTRICTIONS);
		ArrayList<String> users = DbController.getBase(Constants.DATA_BASE_USERS);
		suggestions.clear();
		for(int i = 0; i < 14; i++){
			this.suggestions.add(generateSuggestion(user, this.suggestions, restrictions, users));
		}
		return this.suggestions;	
		
	}
	
	private String generateSuggestion(String user, ArrayList<String> suggestions, ArrayList<String> restrictions, ArrayList<String> users)
	{
		String suggestion="";
		
		try {
			boolean exit= false;
			
			if(!Util.validateRestrictions(user, restrictions))
			{
				user = "";
			}
			do
			{
				
			suggestion = user + Util.randomGenerator();
			
			
			if(suggestions.contains(suggestion)){
				exit = false;
			}
			else {
				exit = true;
			}

			
			}
			while(!exit);
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return suggestion; 
	}
	
	
	
}
