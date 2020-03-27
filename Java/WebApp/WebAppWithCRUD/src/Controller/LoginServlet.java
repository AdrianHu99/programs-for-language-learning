package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;
import DAO.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login") // By this, the servlet will be connected to login.jsp as the action in login.jsp is Login
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId, password;
		
		// Get the data from login.jsp
		userId = request.getParameter("userId");
		password = request.getParameter("password");

		LoginService loginservice = new LoginService();
		boolean result = loginservice.authenticate(userId, password);
		if(result){
			User user = loginservice.getUserDetails(userId);
			
			// Because it send redirect to success.jsp, the request and the response of this jsp will not be saved,
			// so we need session to store the information we need in success.jsp
			
			/*request.getSession().setAttribute("user", user);
			response.sendRedirect("success.jsp");*/
			
			request.setAttribute("user", user);
			
			// Or we can use dispatcher to transfer the data to success.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
			return;
		}else{
			response.sendRedirect("login.jsp");
			return;
		}
		
		
		
	}

}