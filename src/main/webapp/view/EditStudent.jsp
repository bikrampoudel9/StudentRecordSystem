<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post" enctype="multipart/form-data" >
		<div>
			<label for="studentId">Student Id</label>
			<input type="text" name="stdId" id="studentId" value="${student.id}" readonly/>
		</div>
		<div>
			<label for="studentName">Student Name</label>
			<input type="text" name="stdName" id="studentName" value="${student.name}"/>
		</div>
		<div>
			<label>Gender:</label>
			<input type="radio" name="gender" value="Male" id="maleRadio" <c:if test="${fn:toLowerCase(student.gender) eq 'male' }">checked</c:if> />
			<label for="maleRadio">Male</label>
			
			<input type="radio" name="gender" value="Female" id="femaleRadio"/>
			<label for="femaleRadio">Female</label>
		</div>
		<div>
			<label for="pass">Password</label>
			<input type="password" name="password" id="pass"/>
		</div>
		
		<div>
			<input type="file" name="image"/>
		</div>
		
		<div>
			<input type="submit"/>
		</div>
	</form>
</body>
</html>