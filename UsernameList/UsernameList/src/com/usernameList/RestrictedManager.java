package com.usernameList;

import java.util.ArrayList;

public class RestrictedManager {

	private ArrayList<String> restrictedWords;
	
	public RestrictedManager() {
		restrictedWords = DbController.getBase(Constants.DATA_BASE_RESTRICTIONS);
	}
	public void addRestrictedWord(String word) throws Exception{
		if(restrictedWords.contains(word)){
			throw new Exception("Word already created.");
		}
		
		createWord(word);
	}
	private void createWord(String word) {
		DbController.createRestrictedWord(word);
	}

}
