package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databases.StudentDao;

@WebServlet("/login")
public class Login extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		StudentDao sDao = new StudentDao();
		boolean isValid =  sDao.checkLogin(id,password);
		HttpSession session = request.getSession();
		if(isValid == true) {
			session.setAttribute("loggedInId",id);
			response.sendRedirect("StudentProfile.jsp");
		}
		else {
			session.setAttribute("loginError","Invalid id or password");
			response.sendRedirect("Login.jsp");		
		}
		
	}
}
