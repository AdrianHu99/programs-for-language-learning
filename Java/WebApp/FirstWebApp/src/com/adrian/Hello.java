package com.adrian;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Hello
 */


public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("userName");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if(username != "" && username != null){
			session.setAttribute("saved", username);
			context.setAttribute("saved", username);
		}
		out.println("Hello!" + username );
		out.println("Your session value is " + (String)session.getAttribute("saved"));
		out.println("Your context value is " + (String)context.getAttribute("saved"));
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("userName");
		String fullname = request.getParameter("fullName");
		out.println("Hello from post method!" + username+ "We know your full name is " + fullname);
		String prof = request.getParameter("prof");
		out.println("Your profession is " + prof);
		//String location = request.getParameter("location");
		String[] s = request.getParameterValues("location");
		out.println("You are at " + s.length + " places");
		for(int i = 0; i < s.length; i++){
			out.println(s[i]);
		}
				
	
	}
}












