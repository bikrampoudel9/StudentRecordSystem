package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/editStudent")
public class EditStudent extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Student st = new StudentDao().getStudentRecordById(id);
		request.setAttribute("student",st);
		RequestDispatcher rd = request.getRequestDispatcher("view/EditStudent.jsp");
		rd.forward(request, response);
		
	}
}
