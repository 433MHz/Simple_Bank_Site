package login_register_redirector;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import database.UserDatabaseEmulator;
import database_operations.UserOperation;

@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet{
public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
	HttpSession session = request.getSession();
	UserDatabaseEmulator user;
	String login = request.getParameter("loginText");
	String password = request.getParameter("passwordText");
	
	if(UserOperation.isIsDatabase(login)) {
		user = UserOperation.getObject(login);
		
		if(UserOperation.isPasswordCorrect(user, password)) {
			session.setAttribute("user", user);
			response.sendRedirect("bankAccount.jsp");
		}
		
		else {
			request.setAttribute("indexInfo", "Password is incorrect");
			requestDispatcher.forward(request, response);
		}
	}
	
	
	else {
		request.setAttribute("indexInfo", "Login doesn't exist");
		requestDispatcher.forward(request, response);
	}
}
}
