package login_register_redirector;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database_operations.UserOperation;

@WebServlet("/RegisterServlet")
public class RegisterSerlvet extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		
		/*
		 * If user name exist in database, forward to index.jsp and show "User login is in use, try other name"
		 * If user created successfully, forward to index.jsp and show "User successfully created"
		 */
		
		if(UserOperation.add(request.getParameter("loginText"), request.getParameter("passwordText"))) {
			request.setAttribute("indexInfo", "User login is in use, try other name");
		}
		else {
			request.setAttribute("indexInfo", "User successfully created");
		}
		requestDispatcher.forward(request, response);
	}
}
