package com.usernameList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class DbController {

	private static ArrayList<String> users;
	private static ArrayList<String> restrictions;
	
	
	
	
	public static ArrayList<String> getBase(String base) {
		// TODO Auto-generated method stub
		
		if(base.equals(Constants.DATA_BASE_USERS)){
			if(users == null || users.size() == 0){
				users = new ArrayList<String>();
				users = getUsers();				
			}
			return users;
		}
		
		if(base.equals(Constants.DATA_BASE_RESTRICTIONS)){
			if(restrictions == null || restrictions.size() == 0){
				restrictions = new ArrayList<String>();
				restrictions = getRestrictions();				
			}
			return restrictions;
		}
		
		return null;
	}
	
	private static ArrayList<String> getUsers(){
		return readFile(Constants.FILE_NAME_USERS);		
	}
	
	private static ArrayList<String> getRestrictions(){
		
		return readFile(Constants.FILE_NAME_RESTRICTIONS);	
	}
	
	
	private static ArrayList<String>readFile(String fileName) {

		ArrayList<String> data = null;
		BufferedReader br = null;

		try {

			String sCurrentLine;
			File file  = new File(fileName);
			if(!file.exists()){
				file.createNewFile();
			}
			br = new BufferedReader(new FileReader(fileName));
			data = new ArrayList<String>();

			while ((sCurrentLine = br.readLine()) != null) {
				if(!sCurrentLine.trim().equals("") )
					data.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		return data;

	}

	public static void createRestrictedWord(String word) {
		fileWriter(Constants.FILE_NAME_RESTRICTIONS, word);
	}
	
	private static void fileWriter(String fileName, String... data)
	{
		Writer output;
		try {
			output = new BufferedWriter(new FileWriter(fileName, Boolean.TRUE));
			for (String value : data) {
				output.write("\n"+value);
			}
			output.close();
			restrictions=  getRestrictions();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  //clears file every time
		
		
	}
	


}
