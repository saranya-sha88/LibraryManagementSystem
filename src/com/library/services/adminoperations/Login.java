package com.library.services.adminoperations;

public class Login {
	
	private static String USERNAME = "admin";
	private static String PASSWORD = "admin";
	
	public boolean validate(String username,String password)
	{
		if((USERNAME.equals(username))&&(PASSWORD.equals(password)))
			return true;
		else
			return false;
	}

}
