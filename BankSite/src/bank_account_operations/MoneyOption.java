package bank_account_operations;

import database_operations.UserOperation;
import used_by_all.User;

public class MoneyOption {
	
	
	/*
	 * Add money into user account and return string with information
	 * about operation status
	 */
	public static String add(User user, float money) {
		return UserOperation.addMoney(user, money);
	}
	
	
	
	/*
	 * Remove money from sender account and add this value to receiver account
	 */
	public static String send(User userSender, float reciverMoney, String reciverName) {
		return UserOperation.send(userSender, reciverMoney, reciverName);
	}
}
