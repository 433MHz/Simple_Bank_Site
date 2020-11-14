<%@page import="database_operations.UserOperation"%>
<%@page import="java.util.LinkedList"%>
<%@page import="database.UserDatabaseEmulator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%! UserDatabaseEmulator user;%>
<% user = (UserDatabaseEmulator) session.getAttribute("user"); %>
	<title>Operations history for <%user.getName(); %></title>
</head>
<body style="text-align: center; padding: 70px;">

<form action="bankAccount.jsp" method="post"><input type="submit" value = "Back to bank account"></form><br>
<h1>Operations History of <%user.getName(); %> user</h1><br><br>

<% for(LinkedList<LinkedList> x : (LinkedList<LinkedList>) UserOperation.getOperationsHistory(user)){
	out.print(x.toString());
	out.print("<br>");
}
	%>
</body>
</html>