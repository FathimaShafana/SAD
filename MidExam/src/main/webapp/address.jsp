<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address Edit</title>
</head>
<body>
<h1>Edit address</h1>
        <hr>
        <form action="/address/${address.id}/editAddress" method="POST">
          <h3>Employee Details</h3>
          House no: <input type="text" name="houseNo"><br>
          Street: <input type="text" name="street"><br>
          City: <input type="text" name="city"><br>
          ZipCode: <input type="text" name="zipCode"><br>
        
          <input type="submit" value ="EDIT">
        </form>

</body>
</html>