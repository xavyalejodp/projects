package com.usernameList;

import java.util.ArrayList;
import java.util.Collections;

public class Result<T1, T2> {
	
	private Boolean isValid;
	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	private ArrayList<String> list;
	
	public Result(Boolean isValid, ArrayList<String> list) {
		this.setIsValid(isValid);
		this.setList(list);
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		if(list != null)
		{
			Collections.sort(list);
			this.list = list;
		}
	}
	
	

}
