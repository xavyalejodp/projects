package com.usernameList;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constants {
	private static Properties prop;
	static{
		prop = new Properties();
    	InputStream input = null;

    	try {

    		String filename = "application.properties";
    		input = Constants.class.getClassLoader().getResourceAsStream(filename);
    		if(input==null){
    	            System.out.println("Sorry, unable to find " + filename);
    		}

    		//load a properties file from class path, inside static method
    		prop.load(input);


    	} catch (IOException ex) {
    		ex.printStackTrace();
        } finally{
        	if(input!=null){
        		try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	}
        }

	}
	public static int USER_NAME_LENGTH = Integer.parseInt(prop.getProperty("app.usernameList.usernameLength"));
	public static int USER_SUGGESTIONS = Integer.parseInt(prop.getProperty("app.usernameList.userSuggestions"));
	public static String DATA_BASE_USERS = prop.getProperty("app.usernameList.dataBaseUsers");
	public static String DATA_BASE_RESTRICTIONS = prop.getProperty("app.usernameList.dataBaseRestrictions");
	public static String FILE_NAME_USERS = prop.getProperty("app.usernameList.fileNameUsers");
	public static String FILE_NAME_RESTRICTIONS = prop.getProperty("app.usernameList.fileNameRestrictions");
}
