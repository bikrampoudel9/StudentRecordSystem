package controller;

import java.io.IOException;

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

@WebServlet("/updateStudent")
@MultipartConfig
public class UpdateStudent extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("stdId");
		String name = request.getParameter("stdName");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String encryptedPassword = AESEncryption.encrypt(password);
		String relativePath = "userImage/"+id+".png";
	
		Student student = new Student(id,name,gender,encryptedPassword,relativePath);
		StudentDao sDao = new StudentDao();
		String message =  sDao.updateStudent(student);
		Part image = request.getPart("image");
		
		if(message.equals("Successfully Registered") && image!=null && image.getInputStream().available() > 0) {
			String imagePath = getServletContext().getInitParameter("imagePath");
			String fullPath = imagePath+relativePath;
			image.write(fullPath);
		}
		response.sendRedirect("editStudent?id="+id);
	}
}
