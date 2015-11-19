<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href=" <c:url value="/resources/css/table.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
<link href=" <c:url value="/resources/themes/blue/style.css" />"
	rel="stylesheet">
</head>
<body>
	<div>
		<h3
			style="margin-left: 2px; font-family: Palatino Linotype; text-align: left;">Users</h3>


		<table class="tablesorter">
			<thead>
				<tr>

					<th>User Name</th>
					<th>User Type</th>
					<th>Phone Number</th>
					<th>Email</th>


				</tr>
			<thead>
			<tbody>
				<c:forEach var="u" items="${users}">
					<tr>

						<td>${u.userName}</td>
						<td>${u.userType.typeName}</td>
						<td>${u.phoneNumber}</td>
						<td>${u.email}</td>
				</c:forEach>
			<tbody>
		</table>
	</div>

	<h3
		style="margin-left: 2px; font-family: Palatino Linotype; text-align: left;">Add
		New User</h3>
	<table class="tablesorter">



		<thead>
			<form:form method="post" action="addWebUser">
				<tr>
					<td>User Name</td>
					<td><input type="text" style="width: 100%" name="userName"
						required></td>

				</tr>
				<tr>
					<td>User Type</td>

					<td><select name="userType" style="width: 100%">
							<option value="" label="............." />

							<option>Admin</option>
							<option>User</option>
					</select></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" style="width: 100%" class="text"
						name="password" required></td>

				</tr>
				<tr>
					<td>Re-Type Password</td>
					<td><input type="password" style="width: 100%" class="text"
						name="passwordconfirm" required></td>
					<td>
						<div style="color: red">${Msgpass}</div>
					</td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" style="width: 100%" class="text"
						name="email" required></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="text" style="width: 100%" class="text"
						name="phoneNumber" required></td>
				</tr>

				<tr>
					<td>
					<td><input type="submit" style="width: 40%" value="Add User"></td>
					<td></td>

				</tr>

			</form:form>
	</table>

</body>
</html>
