package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.StudentDao;

@WebServlet("/view")
public class View extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDao sDao = new StudentDao();
		ArrayList<Student> studentList = sDao.fetchStudentRecord();
		RequestDispatcher rd = req.getRequestDispatcher("view/View.jsp");
		req.setAttribute("studentList",studentList);
		rd.forward(req, resp);
	}
}
