<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
	
}
</style>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<h1>Register User</h1>
	<form:form method="POST" modelAttribute="user.employee">
		<spring:bind path="username">
			<div>
				<form:input type="text" path="username" class="form-control"
					placeholder="Username" autofocus="true"></form:input>
				<form:errors path="username" class="error"></form:errors>
			</div>
		</spring:bind>
		<spring:bind path="password">
			<div>
				<form:input type="password" path="password" class="form-control"
					placeholder="Password"></form:input>
				<form:errors path="password" class="error"></form:errors>
			</div>
		</spring:bind>

		<spring:bind path="passwordConfirm">
			<div>
				<form:input type="password" path="passwordConfirm"
					class="form-control" placeholder="Confirm your password"></form:input>
				<form:errors path="passwordConfirm" class="error"></form:errors>
			</div>
		</spring:bind>
		<spring:bind path="email">
			<div>
				<form:input type="text" path="email" class="form-control"
					placeholder="Email" autofocus="true"></form:input>
				<form:errors path="email" class="error"></form:errors>
			</div>
		</spring:bind>
		<td>
		<Input type="submit" name="submit" value="REGISTER">
	</td>
	</form:form>
	
	<form action="/employee/${user.emp.id}/delete" method="GET">
                            <input type="submit" value="Delete">
        </form>
	
	<table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Level</th>
                <th>Birthday</th>
                <th>Base Salary</th>
                  <th>Addresses</th>
		    <th>Username</th>
                <th>Email</th>
             </tr>
        
        
        <tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.employee.id}"/></td>
                    <td><c:out value="${user.username}"/></td>
                    <td><c:out value="${employee.level}"/></td>
                    <td><c:out value="${user.emp.birthday}"/></td>
                    <td><c:out value="${user.emp.salary}"/></td>
                    <td><c:out value="${user.employee.address}"/></td>
		<td><c:out value="${user.username}"/></td>
                    <td><c:out value="${user.email}"/></td>
		    
		    </table>                              
</body>
</html>
