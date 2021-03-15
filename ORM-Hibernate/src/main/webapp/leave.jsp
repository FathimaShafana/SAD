<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply Leave</title>
</head>
<body>
<form action="leave" method="get">
	<table border="2">
	
	<tr>
	<td> <label for="leaves">Choose the type of leave:</label> </td>
	<td>
	<select id="leaves" name="leaves" size="2">
 	 <option value="sick">Sick</option>
 	 <option value="annual">Annual</option>
  	</select>	</td>
	</table>
	</br>
	<input type="submit" value="APPLY LEAVE">
</form>
</body>
</html>