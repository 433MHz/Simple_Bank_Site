package bank_account_operations;

import database.UserDatabaseEmulator;
import database_operations.UserOperation;

public class MoneyOption {
	
	
	/*
	 * Add money into user account and return string with information
	 * about operation status
	 */
	public static String add(UserDatabaseEmulator user, float money) {
		return UserOperation.addMoney(user, money);
	}
	
	
	
	/*
	 * Remove money from sender account and add this value to receiver account
	 */
	public static String send(UserDatabaseEmulator userSender, float reciverMoney, String reciverName) {
		return UserOperation.send(userSender, reciverMoney, reciverName);
	}
}
