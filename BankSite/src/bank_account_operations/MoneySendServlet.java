package bank_account_operations;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import used_by_all.User;

@WebServlet("/SendMoney")
public class MoneySendServlet extends HttpServlet{
public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("bankAccount.jsp");
	
	User userSender;
	String userReciver;
	Float money;
	
	userSender = (User) session.getAttribute("user");
	userReciver = request.getParameter("reciverNameMoneyTransfer");
	try {
	money = Float.parseFloat(request.getParameter("moneyAmountMoneyTransfer"));
	String operationInfo = MoneyOption.send(userSender, money, userReciver);
	request.setAttribute("infoSend", operationInfo);
	requestDispatcher.forward(request, response);
	}
	catch (Exception e) {
		request.setAttribute("infoSend", "Value must be a number");
		requestDispatcher.forward(request, response);
	}
}
}
