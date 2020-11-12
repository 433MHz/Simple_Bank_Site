package database_operations;

import database.UserHashMap;

public class CheckIfUserExist {
	public static boolean check(String login) {
		return UserHashMap.isLoginInDatabase(login);
	}
}
