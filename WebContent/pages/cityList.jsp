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
<title>cityList</title>
</head>
<body>
	<h2>Lista Città:</h2>
	<br>
	<a href="searchCity.jsp">Cerca citta</a>
	
	<a href="../CountryListServlet?continent=${cont}">Torna alle nazioni</a><br><br>

	<c:forEach items="${cities}" var="city">
		<li>City: ${city.name} <br>
		Country: ${city.countryCode}<br>
		Population: ${city.population} <br> 
		<a href="/AddOrUpdateCity?id=${city.id}">Edit</a> 
		</li>
		<br><br>
	</c:forEach>

</body>
</html>