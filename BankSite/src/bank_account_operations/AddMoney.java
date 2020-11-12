package bank_account_operations;

import database.UserDatabaseEmulator;
import database_operations.GetUser;

public class AddMoney {
	
	public static String add(UserDatabaseEmulator user, float money) {
		
		if(money>=0) {
			user.setMoney(user.getMoney()+money);
			return "Added succesly";
		}
		else {
			return "Value cannot be lesser than 0";
		}
	}

}
