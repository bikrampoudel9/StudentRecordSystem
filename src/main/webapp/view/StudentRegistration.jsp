<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="../registration" method="post" enctype="multipart/form-data" >
		<div>
			<label for="studentId">Student Id</label>
			<input type="text" name="stdId" id="studentId"/>
		</div>
		<div>
			<label for="studentName">Student Name</label>
			<input type="text" name="stdName" id="studentName"/>
		</div>
		<div>
			<label>Gender:</label>
			<input type="radio" name="gender" value="Male" id="maleRadio"/>
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