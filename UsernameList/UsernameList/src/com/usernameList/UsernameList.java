package com.usernameList;

import java.util.ArrayList;

public class UsernameList {
	
	private String message;	
	private Result<Boolean, ArrayList<String>> result;

	   public Result<Boolean, ArrayList<String>> getResult() {
		return result;
	}
	   
	private SuggestedNames suggestedNames = new SuggestedNames();

	public void setResult(Result<Boolean, ArrayList<String>> result) {
		this.result = result;
	}

	public void setMessage(String message){
	      this.message  = message;
	   }

	   public void getMessage(){
	      System.out.println("Your Message : " + message);
	   }
	   
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Result<Boolean, ArrayList<String>> checkUsername(String userName) throws Exception{
		
		try {
			
			Util.validateUserLength(userName);
			ArrayList<String> users = getUserNames();
			ArrayList<String> restrictions = getRestrictions();
			Boolean isValidUsername = users.contains(userName.trim());
			isValidUsername = users.contains(userName.toUpperCase().trim());
			Boolean isValidAsRestricion = Util.validateRestrictions(userName, restrictions);
			
			if(isValidUsername || !isValidAsRestricion){
				result = getSuggestedUsernames(userName, users);
						 
				return result;
			}
			else{
				result = new Result<Boolean, ArrayList<String>>(Boolean.TRUE, null);
				return result;
			}
			
			 
			
		} catch (Exception e) {
			//e.printStackTrace();
			throw new Exception(e);			
		}
		
	}

	

	private ArrayList<String> getRestrictions() {
		return DbController.getBase(Constants.DATA_BASE_RESTRICTIONS);
	}


	private Result<Boolean, ArrayList<String>> getSuggestedUsernames(String userName, ArrayList<String> users) {
		ArrayList<String> sn =suggestedNames.getSuggestedNames(userName);
		Result<Boolean, ArrayList<String>> suggestedResult = new Result<Boolean, ArrayList<String>>(Boolean.FALSE, sn);
		return suggestedResult ;
	}
	
	

	private ArrayList<String> getUserNames() {
		return DbController.getBase(Constants.DATA_BASE_USERS);
	}
	
	

}
