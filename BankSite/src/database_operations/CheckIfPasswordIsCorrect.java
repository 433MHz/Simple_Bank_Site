package database_operations;

import database.UserDatabaseEmulator;

public class CheckIfPasswordIsCorrect {

	/*
	 * Check if password in String is same as in
	 * database, return true if yes, return false
	 * if not.
	 */
	
	public static boolean check(UserDatabaseEmulator user, String password){
		if(user.getPassword().equals(password)){
			return true;
		}
		else {
			return false;
		}
	}
}
