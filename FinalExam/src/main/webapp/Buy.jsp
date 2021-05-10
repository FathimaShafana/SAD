<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy</title>
</head>

<h3>Add Contract</h3>
            
<form action="/buy" action="GET">
	<table border="2">
	<tr>
	<td>Choose Product: </td>
	<td><select name="pid">
	<c:forEach items="${products}" var="product" >
		<option value="${product[0]}">${product[1]}</option>
	</c:forEach>
	
	<td><select name="order">
	<c:forEach items="${products}" var="stock" >
		<option value="${stock[0]}">${stock[1]}</option>
	</c:forEach>
	</select> </td>
	</tr>
	
	
	</table>
	</br>
	<input type="submit" value="BUY">
</form>

</body>
</html>