package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Operation;

/**
 * Servlet implementation class deleteBook
 */
@WebServlet("/deleteBook")
public class deleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String book_name = request.getParameter("Name");
		
		Operation operation = new Operation();
		operation.delete(book_name);
		
		//System.out.println("The book is successfully deleted!");
		
		
		
	}

}
