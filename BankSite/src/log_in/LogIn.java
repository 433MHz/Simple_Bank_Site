package log_in;

import used_by_all.DataHolder;
import used_by_all.DataHolderUserExtended;
import used_by_all.User;
import used_by_all.UserHashMap;

public class LogIn {
public static DataHolderUserExtended logIn(String login, String password){
	DataHolderUserExtended dataHolder = new DataHolderUserExtended();
	
	if(UserHashMap.getUsersHashMap().containsKey(login)) {
	User user = UserHashMap.getUsersHashMap().get(login);
		if(user.getPassword().equals(password)) {
			dataHolder.set("LoggedIn", user, true);
		}
		
		else {
			dataHolder.set("Password is incorrect", false);}
		return dataHolder;}
	
	else {
		dataHolder.set("This login is not registered", false);
		return dataHolder;}
}}

