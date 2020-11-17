package used_by_all;

import java.util.HashMap;

public class UserHashMap {
private static HashMap<String, User> usersHashMap = new HashMap<String, User>();



public static HashMap<String, User> getUsersHashMap() {
	return usersHashMap;
}

public static void setUsersHashMap(HashMap<String, User> usersHashMap) {
	UserHashMap.usersHashMap = usersHashMap;
}

public static void addUser(User user) {
	usersHashMap.put(user.getName(), user);
}
}
