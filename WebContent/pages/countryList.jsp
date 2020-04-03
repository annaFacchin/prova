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
<title>countryList</title>
</head>
<body>
<h2>Lista Nazioni: </h2>
	<br>
	${output} 
	<br>
		<c:forEach items="${countries}" var="country">
			<li>Name: <a href="../CityListServlet?country=${country.name}">${country.name}</a><br>
			Population: ${country.population}
		</c:forEach>

</body>
</html>