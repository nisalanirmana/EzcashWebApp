<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href=" <c:url value="/resources/css/table.css" />"
	rel="stylesheet">
<link href=" <c:url value="/resources/themes/blue/style.css" />"
	rel="stylesheet">
<link
	href=" <c:url value="/resources/css/ui-lightness/jquery-ui-1.7.2.custom.css" />"
	rel="stylesheet">
<!-- Date Picker -->
<script src="<c:url value="/resources/js/jquery-1.8.3.js" />"></script>
<script
	src="<c:url value="/resources/js/jquery-ui-1.7.2.custom.min.js" />"></script>
<!-- Time Picker -->
<script src="<c:url value="/resources/js/timepicker.js" />"></script>

</head>
<body>
	<div>
		<h3
			style="margin-left: 2px; font-family: Palatino Linotype; text-align: left;">Operators</h3>


		<table class="tablesorter">
			<thead>
				<tr>
					<th colspan="2">Task</th>
					<th>Operator Id</th>
					<th>Operator Name</th>
					<th>Pin Number</th>
					<th>Phone Number</th>
					<th>Email</th>
					<th>Operator Type</th>


				</tr>
			<thead>
			<tbody>
				<c:forEach var="op" items="${operators}">
					<tr>
						<td><a
							href="<c:url value='/editOperator/${op.operatorId}' />"><img
								src="<c:url value='/resources/img/edit.png'/>" /></a></td>
						<td><a
							href="<c:url value='/removeoperator/${op.operatorId}' />"><img
								src="<c:url value='/resources/img/delete.png'/>" /></a></td>
						<td>${op.operatorId}</td>
						<td>${op.operatorName}</td>
						<td>${op.operatorPin}</td>
						<td>${op.phoneNumber}</td>
						<td>${op.email}</td>
						<td><div class="text_div">${op.operatorType}</div></td>
				</c:forEach>

				<tr>

					<form:form method="post" action='${taskOperator}'>
						<td colspan="2"><input type="submit" style="width: 90%"
							value='${taskshowOperator}' name='${taskOperator}'></td>
						<td><input type="text" style="width: 80%" class="text"
							name="operatorId" value="${operatorAttribute[0].operatorId}"
							readonly></td>
						<td><input type="text" style="width: 80%" class="text"
							name="operatorName" value="${operatorAttribute[0].operatorName}"
							required></td>
						<td><input type="text" style="width: 80%" class="text"
							name="operatorPin" value="${operatorAttribute[0].operatorPin}"
							required></td>
						<td><input type="text" style="width: 80%" class="text"
							name="phoneNumber" value="${operatorAttribute[0].phoneNumber}"
							required></td>
						<td><input type="text" style="width: 80%" class="text"
							name="email" value="${operatorAttribute[0].email}" required></td>
						<td><select name="operatorType">
								<option>${operatorAttribute[0].operatorType eq '1' ? 'Finance Division':operatorAttribute[0].operatorType eq '0' ? 'ATM Operator':''}</option>
								<option>${operatorAttribute[0].operatorType eq '1' ? 'ATM Operator':operatorAttribute[0].operatorType eq '0' ? 'Finance Division':'ATM Operator'}</option>
								<option>${operatorAttribute[0].operatorType eq '1' ? '':operatorAttribute[0].operatorType eq '0' ? '':'Finance Division'}</option>


						</select></td>
					</form:form>
				</tr>
			<tbody>
		</table>


	</div>

	<script>
$(".text_div").text(function () { 
    return $(this).text().replace("0", "ATM Operator"); 
});
$(".text_div").text(function () { 
    return $(this).text().replace("1", "Finance Division"); 
});
</script>
</body>
</html>
