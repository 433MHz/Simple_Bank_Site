package database_operations;

import java.util.HashMap;

import database.UserDatabaseEmulator;
import database.UserHashMap;

public class UserOperation {
	
	/*
	 * If user login exist in database then return true, if not
	 * then create new user and return false
	 */
	public static boolean add (String login, String password) {
		if(UserOperation.isIsDatabase(login)) {return true;}
		else {
			UserDatabaseEmulator temporaryUser = new UserDatabaseEmulator(login, password);
			UserHashMap.add(login, temporaryUser);
			return false;}
	}
	
	
	
	/*
	 * Check if password in String is same as in
	 * database, return true if yes, return false
	 * if not.
	 */
	public static boolean isPasswordCorrect(UserDatabaseEmulator user, String password){
		if(user.getPassword().equals(password))	{return true;}
		
		else {return false;}}
	
	
	
	/*
	 * Check if user login is in database
	 */
	public static boolean isIsDatabase(String login) {
		return UserHashMap.isLoginInDatabase(login);
	}
	
	
	
	
	/*
	 * Get UserDatabaseEmulator object
	 */
	public static UserDatabaseEmulator getObject(String login) {
		UserDatabaseEmulator user;
		HashMap<String, UserDatabaseEmulator> hashmap = UserHashMap.getUsersHashMap();
		if(UserOperation.isIsDatabase(login)) {
			user = hashmap.get(login);
			return user;
		}
		else {
			return null;
		}
	}
	
	
}

