
<%@page import="java.sql.ResultSet"%>
<%@page import="model.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style>
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>This is jsp page</h1>
	
	
	<%
		StudentDao sdao = new StudentDao();
		ResultSet table = sdao.fetchStudentRecord();
		if(table != null){
	%>	
			<table border = "1">
			 	<tr>
					<th>id</th>
					<th>names</th>
					<th>gender</th>
					<th>password</th>	
				</tr>
				<%
					while(table.next()){
						String id = table.getString("id");
						String name = table.getString("name");
						String gender = table.getString("gender");
						String password = table.getString("password");
				%>		
						<tr>
							<td><%= id %></td>
							<td><%= name %></td>
							<td><%= gender %></td>
							<td><%= password %></td>
						</tr>		
				<%
					}
				%>
				
				
			</table> 
			
	<%		
		}	
	%>
</body>
</html>
