package com.usernameList;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.math.BigInteger;

public final class  Util {
	
	/**
	 * Generates random string for suggestions
	 * @return
	 */
	public static String randomGenerator(){
		String randomString = null;
		try {
			SecureRandom random = new SecureRandom();
			randomString = (new BigInteger(32, random)).toString(32);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return randomString;
	}
	
	
	public static void validateUserLength(String userName) throws Exception
	{
		userName = userName == null ? "":userName;
		if( userName.length() < Constants.USER_NAME_LENGTH ||  userName.trim().equals("") )
		{
			throw new Exception("Please set the user name correctly "+ Constants.USER_NAME_LENGTH + " or more characters are required.");
		}
	}
	
    public static Boolean validateRestrictions(String userName, ArrayList<String> restrictions) {
		
		for (String restriction : restrictions) {
			if(userName.toUpperCase().contains(restriction.toUpperCase())){
				return Boolean.FALSE;
			}
		}		
		return Boolean.TRUE;
	}
	


	
	  

	 
	

}
