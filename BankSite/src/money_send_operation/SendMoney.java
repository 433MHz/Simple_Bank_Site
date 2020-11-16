package money_send_operation;

import used_by_all.DataHolder;
import used_by_all.User;
import used_by_all.UserHashMap;

public class SendMoney {

	public static DataHolder send(User sender, String reciverName, String value) {
		DataHolder dataHolder = new DataHolder();
		User reciver;
		float money;
		
		if(reciverName.equals(UserHashMap.getUsersHashMap().get(reciverName).getName())) {
			reciver = UserHashMap.getUsersHashMap().get(reciverName);
			
			try {money = Float.parseFloat(value);}
			catch (Exception e) {
				dataHolder.set("Value must be a number", false);
				return dataHolder;
				}
			
			if(sender.getMoney() >= money) {
				sender.setMoney(sender.getMoney() - money);
				reciver.setMoney(reciver.getMoney() + money);
				dataHolder.set("Sended", true);
				return dataHolder;
			}
			else {
				dataHolder.set("You don't have enought money", false);
				return dataHolder;
			}
		}
		else {
			dataHolder.set("Reciver name don't exist", false);
			return dataHolder;
		}
	}
}
