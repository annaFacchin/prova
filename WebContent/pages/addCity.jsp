<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add City</title>
</head>
<body>

<h3>Aggiungi citta</h3>
	<form action="../AddOrEditCity" method="POST">
		Nome: <input type="text" value="${city.name}" name="newName" /> <br><br>
		Nazione: <input type="text" value ="${city.countryCode}" name="newCountryCode" /> <br><br>
		Popolazione: <input type="text" value ="${city.population}" name="newPopulation" /> <br><br>
		<input type="hidden" value="${city.id}" name="newId" /> <br>
		<input type="submit" value="SALVA" /> <br>
	</form>

</body>
</html>