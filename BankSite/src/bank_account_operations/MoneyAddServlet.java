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

@WebServlet("/AddMoney")
public class MoneyAddServlet extends HttpServlet{

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		float money;
		User user = (User) session.getAttribute("user");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("bankAccount.jsp");
		
		try {
			money = Float.parseFloat(request.getParameter("moneyAdd"));
			String addOperationInfo = MoneyOption.add(user, money);
			request.setAttribute("infoAdd", addOperationInfo);
			requestDispatcher.forward(request, response);
		}
		catch (Exception e) {
			request.setAttribute("infoAdd", "Value must be a number");
			requestDispatcher.forward(request, response);
		}
	}
}
