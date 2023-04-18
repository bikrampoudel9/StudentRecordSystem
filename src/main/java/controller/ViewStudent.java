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

@WebServlet("/viewStudent")
public class ViewStudent extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDao sdao = new StudentDao();
		ArrayList<Student> studentList =  sdao.fetchStudentRecord();
		request.setAttribute("stList",studentList);
		RequestDispatcher rd = request.getRequestDispatcher("view/View.jsp");
		rd.forward(request, response);
	}
}
