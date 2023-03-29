package servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="anotherServlet",urlPatterns = {"/anotherServlet"})
public class AnotherServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String id = request.getParameter("stdId");
		PrintWriter out = response.getWriter();
		out.println("id: "+id);
		
		ServletConfig config = getServletConfig();
		out.println("Driver: "+config.getInitParameter("driver"));
		
		
		
	}
	
	
}
