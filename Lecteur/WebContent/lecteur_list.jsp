<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lecteur</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="LecteurController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>NumberLecteur</th>
			 <th>Name</th>
			 <th>Phone</th>
			 <th>Address</th>
			
		</tr>
		<c:forEach var="lecteur" items="${lecteurs}">
		
		<tr>
			<td>
				<form action= "LecteurController">
					<input type = "hidden" name = "id" value= "${lecteur.numberLecteur}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
			</td>
			<td> ${lecteur.numberLecteur}</td>
			<td> ${lecteur.name}</td>
			<td> ${lecteur.phone}</td>
			<td> ${lecteur.address}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>
	<form action="LecteurReport">
				
					<input type = "submit" name = "btn_reporte" value = "Reporte"/>
				</form>

</body>
</html>