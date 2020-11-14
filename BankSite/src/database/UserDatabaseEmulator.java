package database;

import history_database.OperationsHistory;

public class UserDatabaseEmulator {
private String name;
private String password;
private float money;
private OperationsHistory operationsHistory = new OperationsHistory();

public OperationsHistory getOperationsHistory() {
	return operationsHistory;
}

public void setOperationsHistory(OperationsHistory operationsHistory) {
	this.operationsHistory = operationsHistory;
}

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
