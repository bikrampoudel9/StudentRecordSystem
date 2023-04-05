package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
	public ResultSet fetchStudentRecord(){
		try {
			Connection con = getConnection();
			String query = "select * from registration";
			PreparedStatement st = con.prepareStatement(query);
			ResultSet table = st.executeQuery();
			con.close();
			return table;		
//			while(table.next()) {
//				String id = table.getString(1);
//				String name = table.getString(2);
//				String gender = table.getString(3);
//				String password = table.getString(4);
//				
//				System.out.println(id+" "+name+" "+gender+" "+password);
//			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;				
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
	
	
	
	
	
		
	
	
	
}
