package bank_account_operations;

import java.util.LinkedList;

import database.UserDatabaseEmulator;
import database_operations.UserOperation;

public class MoneyOption {
	
	
	/*
	 * Add money into user account and return string with information
	 * about operation status
	 */
	public static String add(UserDatabaseEmulator user, float money) {
		
		if(money>=0) {
			user.setMoney(user.getMoney()+money);
			return "Added succesly";
		}
		else {
			return "Value cannot be lesser than 0";
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

}
