<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Password</th>
			<th>Image</th>
		</tr>
		<c:forEach var="st" items="${stList}">
			<tr>
				<td><c:out value="${st.id}"/></td>
				<td>${st.name}</td>
				<td>${st.gender}</td>
				<td>${st.password}</td>
				<td><img src="images/${st.imagePath}" height="100px" width="100px"></td>
				<td></td>
			</tr>	
		</c:forEach>
	
	</table>
</body>
</html>