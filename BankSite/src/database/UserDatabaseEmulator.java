package database;

public class UserDatabaseEmulator {
String name;
String password;
float money;

public UserDatabaseEmulator(String login, String password){
	this.name = login;
	this.password = password;
	this.money = 0;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public float getMoney() {
	return money;
}
public void setMoney(float money) {
	this.money = money;
}


}
