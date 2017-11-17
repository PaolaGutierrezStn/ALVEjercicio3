<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lecteur Form</title>
</head>
<body>
	<form action="LecteurController">
		<label>Name:</label><br>
		<input type = "text" name= "name" value = "${lecteur.name}" /><br>
		
		<label>Phone:</label><br>
		<input type = "text" name= "phone" value = "${lecteur.phone}" /><br>
		
		<label>Address:</label><br>
		<input type = "text" name= "address" value = "${lecteur.address}" /><br>
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>


