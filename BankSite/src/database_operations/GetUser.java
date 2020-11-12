package database_operations;

import java.util.HashMap;

import database.UserDatabaseEmulator;
import database.UserHashMap;

public class GetUser {

	private static UserDatabaseEmulator user;
	
	public static UserDatabaseEmulator get(String login) {
		HashMap<String, UserDatabaseEmulator> hashmap = UserHashMap.getUsersHashMap();
		if(CheckIfUserExist.check(login)) {
			user = hashmap.get(login);
			return user;
		}
		else {
			return null;
		}
	}
}
