package log_in;

import used_by_all.DataHolder;
import used_by_all.User;
import used_by_all.UserHashMap;

public class LogIn {
public static UserReturn logIn(String login, String password){
	UserReturn dataHolder = new UserReturn();
	
	if(UserHashMap.getUsersHashMap().containsKey(login)) {
	User user = UserHashMap.getUsersHashMap().get(login);
		if(user.getPassword() == password) {
			dataHolder.set("LoggedIn", user, true);
		}
		
		else {
			dataHolder.set("Password is incorrect", false);}
		return dataHolder;}
	
	else {
		dataHolder.set("This login is not registered", false);
		return dataHolder;}
}}

