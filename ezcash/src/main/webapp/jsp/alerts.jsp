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



	<h3
		style="margin-left: 2px; font-family: Palatino Linotype; text-align: left;">ATM
		Alerts</h3>
		<form:form action="getdatesalerts" method="post">

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
		
					<td><input type="submit" value="Filter Alerts">
					</td>
				</tr>


			</table>
		</form:form>

	<table class="tablesorter1">
	    <col width="50">
		<col width="194">
		<col width="194">
		<col width="194">
		<col width="194">
		<thead>
			<tr>
				<th>Task</th>
				<th>ATM Name</th>
				<th>Alert Type</th>
				<th>Triggered Time</th>
				<th>Cleared Time</th>


			</tr>
		<thead>
		<tbody>

			<c:forEach var="alert" items="${alerts}">

				<tr>
					<td><a href="<c:url value='/removeAlert/${alert.alertId}' />"><img
							src="<c:url value='/resources/img/delete.png'/>" /></a></td>
					<td>${alert.atm.atmName}</td>
					<td><div>${alert.alertType.alertName}</div></td>
					<td>${alert.triggeredTime}</td>
					<td>${alert.solvedTime}</td>

				</tr>



			</c:forEach>
		<tbody>
	</table>



	<script>
$( "tr:contains('Power')" ).css( "background-color", "#F5A9D0" );
</script>

	<script>
$( "tr:contains('Door')" ).css( "background-color", "#A9F5A9" );
</script>

	<script>
$( "tr:contains('Cash')" ).css( "background-color", "#A9D0F5" );
</script>

	<script>
$( "tr:contains('Shock')" ).css( "background-color", "#F2F5A9" );
</script>

</body>
</body>
</html>
