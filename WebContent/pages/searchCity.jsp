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

	<form>
		Nome: <input formaction="../SearchCities?name=${name}&country=${countryCode}" type="text"
			name="name" id="name"> <br>
		<br>Nazione: <select name="countryCode">
		<option value="nessuna">- Nessuna Nazione</option>
			<option value="countries">
			<c:choose>
				<c:when test="${countries}">
					<c:forEach items="${countries}" var="count">${count}</c:forEach>
				</c:when>
				<c:otherwise>Nessuna nazione</c:otherwise>
			</c:choose>
			</option>
		</select> <br>
		<br> <input formaction="../SearchCities?name=${name}&countryCode=${country}"
			type="submit" value="Cerca">
	</form>

</body>
</html>