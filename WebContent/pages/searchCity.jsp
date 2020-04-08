<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca e modifica citta</title>
</head>
<body>

	<h2>Ricerca citta</h2>

	<form action="SearchCities">
		Nome: <input type="text" name="name" id="name"> <br> <br>Nazione:
		<select name="countryCode">
			<option value="">- Nessuna Nazione</option>
			<c:forEach items="${countryList}" var="count">
				<option value="${country.code}">${country}</option>
			</c:forEach>
		</select> <br> <br> <input type="submit" value="Cerca">
	</form>

</body>
</html>