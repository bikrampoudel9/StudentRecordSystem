package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import databases.StudentDao;


@SuppressWarnings("serial")
@WebServlet("/registration")
public class StudentRegistration extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws  IOException, ServletException {
		
		
		String id = request.getParameter("stdId");
		String name = request.getParameter("stdName");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		
		System.out.println(id+name+gender+password);
		
		//response.sendRedirect("https://www.google.com/")
//		RequestDispatcher rd = request.getRequestDispatcher("anotherServlet");
// 		rd.forward(request, response);
		

		
		StudentDao sdao = new StudentDao();
		String message = sdao.registerStudent(id, name, gender, password);
//		
//		PrintWriter out = response.getWriter();
// 		out.println("<h1>"+message+"</h1>");
// 		
// 		response.setContentType("text/html");
 		
		
	}
}
