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
<link
	href=" <c:url value="/resources/css/ui-lightness/jquery-ui-1.7.2.custom.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.3.2.min.js" />"></script>
<script
	src="<c:url value="/resources/js/jquery-ui-1.7.2.custom.min.js" />"></script>
<script src="<c:url value="/resources/js/timepicker.js" />"></script>
<link href=" <c:url value="/resources/themes/blue/style.css" />"
	rel="stylesheet">
<script type="text/javascript">
$(function() {
    $('.datetime').datepicker({
    	duration: '',
        showTime: true,
        dateFormat:"dd-mm-yy",
		time24h: true
     });
});
</script>



</head>
<body>





	<div>
		<h3 style="margin-left: 2px; font-family: Palatino Linotype;">Transactions</h3>
		<form:form action="getdates" method="post">

			<table class="tablesorter">


				<tr>

					<td>Start Date</td>
					<td><input type="text" class="datetime" name="fromDate"></td>

					<td>End Date</td>
					<td><input type="text" class="datetime" name="toDate"></td>
					<!--  
				<td>Atm Name</td>
				<td><input type="text" class="text"  name="atmName"></td>
			-->
					<td><input type="submit" value="Filter Transactions">
					</td>
				</tr>


			</table>
		</form:form>
		<table class="tablesorter">
			<thead>
				<tr>
				<th>Task</th>
					<th>ATM Name</th>
					<th>Transaction Time</th>
					<th>Transaction Amount</th>
					<th>Status</th>


				</tr>
			<thead>
			<tbody>
				<c:forEach var="cashouts" items="${cashouts}">
					<tr>
					<td><a href="<c:url value='/removeTransaction/${cashouts.cashOutId}' />"><img
							src="<c:url value='/resources/img/delete.png'/>" /></a></td>
						<td>${cashouts.atm.atmName}</td>
						<td>${cashouts.cashOutDate}</td>
						<td>${cashouts.amount}</td>
						<td>${cashouts.transactionStatus.statusName}</td>
					</tr>
				</c:forEach>
			<tbody>
		</table>

		<table class="tablesorter">
			<thead>
				<tr>
				     <th>Task</th>
					<th>ATM Name</th>
					<th>Created Time</th>
					<th>End Time</th>
					<th>Tray1 Amount</th>
					<th>Tray2 Amount</th>
					<th>Type</th>


				</tr>
			<thead>
			<tbody>
				<c:forEach var="reloads" items="${reloads}">
					<tr>
					<td><a href="<c:url value='/removeTransaction/${reloads.transactionId}' />"><img
							src="<c:url value='/resources/img/delete.png'/>" /></a></td>
						<td>${reloads.atmReload.atm.atmName}</td>
						<td>${reloads.atmReload.taskCreatedTime}</td>
						<td>${reloads.atmReload.reloadEndTime}</td>
						<td>${reloads.tray1}</td>
						<td>${reloads.tray2}</td>
						<td>${reloads.atmReload.transactionStatus.statusName}</td>
					</tr>
				</c:forEach>
			<tbody>
		</table>







	</div>
</body>
</html>
