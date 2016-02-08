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
		<form:form action="getdatescashout" method="post">

			<table class="tablesorter">


				<tr>

					<td>Start Date</td>
					<td><input type="text" class="datetime" name="fromDate" required></td>

					<td>End Date</td>
					<td><input type="text" class="datetime" name="toDate" required></td>
					 <td>Atm Name</td>
				  
				      <td><select name="atmName">
							<option value="" label="............." />
							<c:forEach var="at" items="${atmdrpdwnlist}">
								<option>${at}</option>
							</c:forEach>
					</select></td>
		
		
					<td><input type="submit" value="Filter Transactions">
					</td>
				</tr>


			</table>
		</form:form>
		<table class="tablesorter">
			<thead>
				<tr>
					<th>Task</th>
					<th>CashOutID</th>
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
						<td>${cashouts.cashOutId}</td>
						<td>${cashouts.atm.atmName}</td>
						<td>${cashouts.cashOutDate}</td>
						<td>${cashouts.amount}</td>
						<td>${cashouts.transactionStatus.statusName}</td>
					</tr>
				</c:forEach>
			<tbody>
		</table>
		<h3 style="margin-left: 2px; font-family: Palatino Linotype;">Transactions Succeeded</h3>
				<table class="tablesorter">
			<thead>
				<tr>
			
					<th>CashOutId</th>
					<th>ATM Name</th>
					<th>Transaction Time</th>
					<th>Transaction Amount</th>
					<th>Status</th>
					<th>T1</th>
					<th>T2</th>
					<th>R1</th>
					<th>R2</th>


				</tr>
			<thead>
			<tbody>
				<c:forEach var="cashouts" items="${TransactionsComp}">
					<tr>

						<td>${cashouts.cashOut.cashOutId}</td>
						<td>${cashouts.cashOut.atm.atmName}</td>
						<td>${cashouts.cashOut.cashOutDate}</td>
						<td>${cashouts.cashOut.amount}</td>
						<td>${cashouts.cashOut.transactionStatus.statusName}</td>
						<td>${cashouts.tray1}</td>
						<td>${cashouts.tray2}</td>
						<td>${cashouts.reject1}</td>
						<td>${cashouts.reject2}</td>
					</tr>
				</c:forEach>
			<tbody>
		</table>
		









	</div>
</body>
</html>
