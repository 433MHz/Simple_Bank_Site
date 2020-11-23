package sqlDatabase;

import java.sql.*;

import used_by_all.User;

public class AddUserDAO {

	public static void add(User user) {
		String query = "insert into users (name, password, money) values (?, ?, ?)";
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(DatabaseConnectInfo.url, DatabaseConnectInfo.userName, DatabaseConnectInfo.password);
			
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, user.getName());
			st.setString(2, user.getPassword());
			st.setFloat(3, 0);
			st.executeUpdate();
			
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
