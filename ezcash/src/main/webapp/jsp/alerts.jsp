<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>

<link href=" <c:url value="/resources/css/table.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alerts</title>
<link href=" <c:url value="/resources/themes/blue/style.css" />"
	rel="stylesheet">

<!-- Auto Refresh JSP Pages -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

<script>
<!-- Auto Refresh Function -->
 function autoRefresh()
{
	window.location = window.location.href;
}

 setInterval('autoRefresh()', 10000); // this will reload page after every 5 secounds; Method I
</script>
</head>
<body>



	<h3
		style="margin-left: 2px; font-family: Palatino Linotype; text-align: left;">ATM
		Alerts</h3>


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
