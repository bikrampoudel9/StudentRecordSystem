<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post" style="border:1px solid black; width:300px;">
		<% if(session.getAttribute("loginError") != null){ %>
		
			<h2><%= session.getAttribute("loginError") %></h2>
			<%session.removeAttribute("loginError");%>	
			
		<%} %>	
		id: <input type="text" name="id"/><br>
		Password: <input type="text" name="password"/><br>
		<input type="submit"/><br>
	
	</form>
</body>
</html>