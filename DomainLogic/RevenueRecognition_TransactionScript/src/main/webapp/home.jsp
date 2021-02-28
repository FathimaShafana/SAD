<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>

<h3>Add Contract</h3>
            
<form action="addContract" action="GET">
	<table border="2">
	<tr>
	<td>Choose Product: </td>
	<td><select name="pid">
	<c:forEach items="${products}" var="product" >
		<option value="${product[0]}">${product[1]}</option>
	</c:forEach>
	</select> </td>
	</tr>
	
	<tr>
	<td>Date signed:</td>
	<td> <input type="date" name="date"></td>
	</tr>
	
	<tr>
	<td>Contract Price:</td>
	<td> <input type="text" name="price"></td> 
	</tr>
	
	</table>
	</br>
	<input type="submit" value="ADD CONTRACT">
</form>

</body>
</html>