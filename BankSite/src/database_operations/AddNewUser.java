package database_operations;

import database.UserDatabaseEmulator;
import database.UserHashMap;

public class AddNewUser {
	
	/*
	 * If user login exist in database then return true, if not
	 * then create new user and return false
	 */
	public static boolean add (String login, String password) {
		if(CheckIfUserExist.check(login)) {
			return true;
		}
		else {
			UserDatabaseEmulator temporaryUser = new UserDatabaseEmulator(login, password);
			UserHashMap.add(login, temporaryUser);
			return false;
		}
	}

}
