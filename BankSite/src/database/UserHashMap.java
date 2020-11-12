package database;

import java.util.HashMap;

public class UserHashMap {
private static HashMap<String, UserDatabaseEmulator> usersHashMap = new HashMap<String, UserDatabaseEmulator>();

public static boolean isLoginInDatabase(String login) {
	return usersHashMap.containsKey(login);
}

public static void add(String login, UserDatabaseEmulator user) {
	usersHashMap.put(login, user);
}

public static HashMap<String, UserDatabaseEmulator> getUsersHashMap() {
	return usersHashMap;
}

public static void setUsersHashMap(HashMap<String, UserDatabaseEmulator> usersHashMap) {
	UserHashMap.usersHashMap = usersHashMap;
}


}
