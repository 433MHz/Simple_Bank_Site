package database_operations;

import java.util.HashMap;
import java.util.LinkedList;
import database.UserDatabaseEmulator;
import database.UserHashMap;

public class UserOperation {
	
	/*
	 * If user login exist in database then return true, if not
	 * then create new user and return false
	 */
	public static boolean add(String login, String password) {
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
	
	
	
	/*
	 * Remove money from sender account and add this value to receiver account
	 */
	public static String send(UserDatabaseEmulator userSender, float reciverMoney, String reciverName) {
UserDatabaseEmulator userReciver;
		
		if(UserOperation.isIsDatabase(reciverName)) {
			if(reciverMoney < 0) {
				return "You can't send negative value";
			}
			else if(userSender.getMoney() > reciverMoney) {
				userSender.setMoney(userSender.getMoney() - reciverMoney);
				userReciver = UserOperation.getObject(reciverName);
				userReciver.setMoney(userReciver.getMoney() + reciverMoney);
				userSender.getOperationsHistory().putIn(userSender.getName(), userReciver.getName(), reciverMoney, "Sended");
				userReciver.getOperationsHistory().putIn(userSender.getName(), userReciver.getName(), reciverMoney, "Recived");
				return "Sended";
			}
			else {
				return "You don't have enought money balance on your account";
			}
		}
		
		else {
			return "User name not exist";
		}
	}
	
	
	
	/*
	 * Add money into user account and return string with information
	 * about operation status
	 */
	public static String addMoney(UserDatabaseEmulator user, float money) {
		
		if(money>=0) {
			user.setMoney(user.getMoney()+money);
			return "Added succesly";
		}
		else {
			return "Value cannot be lesser than 0";
		}
	}
		
		
		
		/*
		 * Returns LinkedList from UserDatabaseEmulator object that have OperationsHistory object inside
		 */
		public static LinkedList<LinkedList> getOperationsHistory(UserDatabaseEmulator user) {
			return user.getOperationsHistory().get();
		}
	
}

