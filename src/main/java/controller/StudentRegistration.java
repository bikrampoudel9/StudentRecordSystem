package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.AESEncryption;
import model.Student;
import model.StudentDao;


@SuppressWarnings("serial")
@WebServlet("/registration")
@MultipartConfig
public class StudentRegistration extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) throws  IOException, ServletException {
		
		String id = request.getParameter("stdId");
		String name = request.getParameter("stdName");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String encryptedPassword = AESEncryption.encrypt(password);
		String relativePath = "userImage/"+id+".png";
		
		Student st = new Student(id,name,gender,encryptedPassword,relativePath);
		
		StudentDao studentDao = new StudentDao();
		String message = studentDao.registerStudent(st);	
		if(message.equals("Successfully Added")) {
			Part image = request.getPart("image");
			String imagePath = getServletContext().getInitParameter("imagePath");
			String fullPath = imagePath+relativePath;
			image.write(fullPath);
		}
		
		
		
	}
}
