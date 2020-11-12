package bank_account_operations;

import database.UserDatabaseEmulator;
import database_operations.CheckIfUserExist;
import database_operations.GetUser;

public class SendMoney {
	
	public static String send(UserDatabaseEmulator userSender, float reciverMoney, String reciverName) {
		UserDatabaseEmulator userReciver;
		
		if(CheckIfUserExist.check(reciverName)) {
			if(reciverMoney < 0) {
				return "You can't send negative value";
			}
			else if(userSender.getMoney() > reciverMoney) {
				userSender.setMoney(userSender.getMoney() - reciverMoney);
				userReciver = GetUser.get(reciverName);
				userReciver.setMoney(userReciver.getMoney() + reciverMoney);
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
