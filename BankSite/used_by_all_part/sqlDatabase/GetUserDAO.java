package sqlDatabase;

import java.sql.*;

import used_by_all.User;

public class GetUserDAO {
	public static User get(String login) {
		String query = "select * from users where name = '" + login + "'";

		if (IsUserDAO.check(login)) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(DatabaseConnectInfo.url, DatabaseConnectInfo.userName, DatabaseConnectInfo.password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				rs.next();

				User user = new User();
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setMoney(rs.getFloat("money"));

				st.close();
				con.close();

				return user;
			} catch (Exception e) {
				System.out.println(e);
			}
			return null;
		} else {
			return null;
		}
	}
}
