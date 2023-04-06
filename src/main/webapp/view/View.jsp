
<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<table border = "1">
		 	<tr>
				<th>id</th>
				<th>names</th>
				<th>gender</th>
				<th>password</th>
				<th>image</th>	
			</tr>
			<c:forEach var="st" items="${studentList}">
				<tr>
					<td><c:out value="${st.id}"/></td>
					<td>${st.name }</td>
					<td>${st.gender}</td>
					<td>${st.password }</td>
					<td>${st.imagePath }</td>
				</tr>
			</c:forEach>
		</table> 
		
</body>
</html>
