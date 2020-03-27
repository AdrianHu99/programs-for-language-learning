package Controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import Util.Operation;

/**
 * Servlet implementation class addBook
 */
@WebServlet("/addBook")
public class addBook extends HttpServlet {
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
		System.out.println("The name of the book is " + book_name);
		System.out.println("The author of the book is " + book_author);
		System.out.println("The publish date of the book is " + book_pub_date);
		System.out.println("The book has " + book_pages + " pages");
		System.out.println("The book is " + book_state);
		
		Operation operation = new Operation();
		operation.add(book_author, book_pub_date, book_name, book_pages, book_state);
		
		
		/*String location = request.getParameter("location");
		String[] s = request.getParameterValues("location");*/
		
		
	}

}
