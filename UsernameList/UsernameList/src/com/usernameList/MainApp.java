package com.usernameList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	private static ApplicationContext context;

	public static void main(String[] args) {
		 context = new ClassPathXmlApplicationContext("Beans.xml");

		 UsernameList obj = (UsernameList) context.getBean("UsernameList");
	      
	     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      try{  
			    while(true){
			    	System.out.println("OPTIONS");
			    	System.out.println("1. Username List");
			    	System.out.println("2. Restriction List Add");
			    	System.out.println("3. Exit");	
			    	System.out.print("Select an option: ");
			    	String s = br.readLine();
			    	
			    	if(s.equals("1"))
			    	{
			    		
				    	try {
							System.out.print("Please enter the user name: ");
							s = br.readLine();
							Result<Boolean, ArrayList<String>> result =obj.checkUsername(s);
							
							if(result.getIsValid()){
								System.out.println("Username is valid!");
								
							}
							else{
								System.out.println("Username is invalid!");
								System.out.println("Username suggestions:");
								System.out.println(result.getList());	        		        	
							}
						} catch (Exception e) {
							System.err.println(e.getMessage());
						}
			        }else
			    	if(s.equals("2")){
			    		System.out.print("Enter the new restricted word:");
			    		s = br.readLine();
			    		RestrictedManager restrictedManager = new RestrictedManager();
			    		restrictedManager.addRestrictedWord(s);
			    	}else
			    	
			    	if(s.equals("3")){
			    		System.exit(0);
			    	}else
			    		
			    	{
			    		System.out.println("Wrong Option...");
			    	}
			    	
			    	
			    }
	         
	      }
	      	catch (Exception e) {
	        	System.out.println(e.getMessage());
	        }

	}

}
