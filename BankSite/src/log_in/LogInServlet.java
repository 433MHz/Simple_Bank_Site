package log_in;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database_operations.UserOperation;
import used_by_all.DataHolder;
import used_by_all.User;
import used_by_all.UserHashMap;

@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet{
public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	DataHolder dataHolder = LogIn.logIn(request.getParameter("loginText"), request.getParameter("passwordText"));	//Get dataHolder object from LogIn
	if(dataHolder.getIsDone()) {
		User user = UserHashMap.getUsersHashMap().get(request.getParameter("loginText"));			//Get user with login as in loginText String
		session.setAttribute("user", user);
		response.sendRedirect("bankAccount.jsp");
	}
	else {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		request.setAttribute("indexInfo", dataHolder.getMessage());
		requestDispatcher.forward(request, response);
	}
}
}
