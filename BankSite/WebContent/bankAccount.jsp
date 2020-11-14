<%@page import="database_operations.UserOperation"%>
<%@page import="java.util.LinkedList"%>
<%@page import="database.UserDatabaseEmulator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Bank Account</title>
</head>
<body>
<%! UserDatabaseEmulator user; %>
<%user = (UserDatabaseEmulator) session.getAttribute("user"); %>


Hello <%out.print(user.getName()); %> <br>
You have on your account: <%out.print(user.getMoney()); %> USD<br>
<br>

<h1>Add money</h1><br>
<form action="AddMoney" method="post">
How much money you want to add? <input type="text" name="moneyAdd"> <input type="submit" name="moneyAddButton" value="Send"><br>
<% if(request.getAttribute("infoAdd") != null){out.print(request.getAttribute("infoAdd"));} %>
<br>
</form>

<h1>Money transfer</h1><br>
<form action="SendMoney" method="post">
To who you want send money? (type reciver login) <input type="text" name="reciverNameMoneyTransfer"><br> 
How much you want send?                          <input type="text" name="moneyAmountMoneyTransfer"><br>
<input type="submit" name="moneyTransferButton" value="Send"><br>
<% if(request.getAttribute("infoSend") != null){out.print(request.getAttribute("infoSend"));} %><br><br>
</form>

<% for(LinkedList<LinkedList> x : (LinkedList<LinkedList>) UserOperation.getOperationsHistory(user)){
	out.print(x.toString());
	out.print("<br>");
}
	%>
</body>
</html>