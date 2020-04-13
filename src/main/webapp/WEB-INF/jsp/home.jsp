<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Web Application</title>
</head>
<body>
	<font color="red">${errorMessage}</font>
	Please enter Task details: <br/>
    <form method="post">
        Name : <input type="text" name="name" /> <br/>
        Description : <input type="text" name="description" /> <br/>
        <input type="submit" />
    </form>
</body>
</html>