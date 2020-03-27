package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Operation;

/**
 * Servlet implementation class editBook
 */
@WebServlet("/editBook")
public class editBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String book_name = request.getParameter("Name");
		// In the future, the author could be more than 1
		String book_author = request.getParameter("Author");
		String book_state = request.getParameter("State");
		String book_pub_date = request.getParameter("Pub_Date");
		String pages = request.getParameter("Pages");
		int book_pages = Integer.parseInt(pages);
		Operation operation = new Operation();
		operation.edit(book_author, book_pub_date, book_name, book_pages, book_state);
		
	}

}
