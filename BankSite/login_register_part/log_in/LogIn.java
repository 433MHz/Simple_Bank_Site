package log_in;

import sqlDatabase.GetUserDAO;
import sqlDatabase.IsUserDAO;
import used_by_all.DataHolderUserExtended;
import used_by_all.User;

public class LogIn {
	public static DataHolderUserExtended logIn(String login, String password) {
		DataHolderUserExtended dataHolder = new DataHolderUserExtended();

		if (IsUserDAO.check(login)) {
			User user = GetUserDAO.get(login);
			if (user.getPassword().equals(password)) {
				dataHolder.set("LoggedIn", user, true);
			}

			else {
				dataHolder.set("Password is incorrect", false);
			}
			return dataHolder;
		}

		else {
			dataHolder.set("This login is not registered", false);
			return dataHolder;
		}
	}
}
