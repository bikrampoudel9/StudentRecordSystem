<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%-- <%
		Students st = new Students();
	%> --%>
	<jsp:useBean id="st" class="model.Student" scope="page"/>
	<%-- <%
		st.setName("Ram");	
	%> --%>
	<jsp:setProperty name="st" property="name" value="Subash"/>
	
	<%-- <h1><%= st.getName() %></h1> --%>
	
	<h1>  
		<jsp:getProperty name="st" property = "name"/>	
		
	</h1>
	
	
</body>
</html>