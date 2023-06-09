package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentDao {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/students_record";
		String username = "root";
		String password = "";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
	
	public String registerStudent(Student student) {
		String message = "";
		try {
			
			Connection con =  getConnection();
			String query = "insert into registration values(?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,student.getId());
			pst.setString(2,student.getName());
			pst.setString(3,student.getGender());
			pst.setString(4,student.getPassword());
			pst.setString(5,student.getImagePath());
			int rows = pst.executeUpdate();
			if(rows >= 1) {
				message = "Successfully Added";
			}
			con.close();	
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			message = e.getMessage();
		}
		return message;	
	}
	public ArrayList<Student> fetchStudentRecord(){
		ArrayList<Student> studentList = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String query = "select * from registration";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			while(table.next()) {
				String id = table.getString(1);
				String name = table.getString(2);
				String gender = table.getString(3);
				String password = table.getString(4);
				String imagePath = table.getString(5);
				
				Student student = new Student(id,name,gender,password,imagePath);
				studentList.add(student);		
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return studentList;
		
					
	}
	
	public boolean checkLogin(String id, String password) {
		boolean isValid = false;
		try {
			Connection con = getConnection();
			String query = "select * from registration where id=? and password=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, id);
			st.setString(2, password);
			ResultSet table = st.executeQuery();
			if(table.next()) {
				isValid = true;
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
		
	}
	
	public Student getStudentRecordById(String id) {
		Connection con = null;
		Student student = null;
		try {
			con = getConnection();
			String query = "select * from registration where id=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1,id);
			ResultSet table = st.executeQuery();
			while(table.next()) {
				String id2 = table.getString(1);
				String name = table.getString(2);
				String gender = table.getString(3);
				String password = table.getString(4);
				String decryptedPassword = AESEncryption.decrypt(password);
				String imagePath = table.getString(5);
				
				student = new Student(id,name,gender,decryptedPassword,imagePath);
						
			}			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return student;
		
	}
	
	public String updateStudent(Student student) {
		String message = "";
		try {
			
			Connection con =  getConnection();
			String query = "UPDATE registration SET name=?, gender=?,password=?,image_path=? where id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,student.getName());
			pst.setString(2,student.getGender());
			pst.setString(3,student.getPassword());
			pst.setString(4,student.getImagePath());
			pst.setString(5,student.getId());

			int rows = pst.executeUpdate();
			if(rows >= 1) {
				message = "Successfully Registered";
			}
			con.close();	
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			message = e.getMessage();
		}
		return message;	
	}
	
	
	
	
	
		
	
	
	
}
