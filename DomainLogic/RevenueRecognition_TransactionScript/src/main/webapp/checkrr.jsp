<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CheckRR</title>
</head>

<h3>Check Revenue Recognition</h3>
          
<form action="/checkRecognizedRevenue" action="GET">
	<table border="2">
	<tr>
	<td>Contract ID:</td>
	<td> <select name="cid">
	<c:forEach items="${contracts}" var="contract" >
		<option value="${contract[0]}">Product ID: ${contract[1]}; Revenue: ${contract[2]}, Date Signed: ${contract[3]}</option>
	</c:forEach>
	</select> </td>
	</tr>
	
	<tr>
	<td>Date as of: </td>
	<td><input type="date" name="date"></td> 
	</tr>
	</table>
	</br>
	<input type="submit" value="CHECK RECOGNIZED REVENUE">
</form>

</body>
</html>