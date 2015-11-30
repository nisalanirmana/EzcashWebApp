<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link href=" <c:url value="/resources/css/table.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>System Overview</title>
<!-- Table Styles -->
<link href=" <c:url value="/resources/themes/blue/style.css" />"
	rel="stylesheet">

<!--  <meta http-equiv="refresh" content="5" />   -->
<!-- Auto Refresh JSP Pages -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- Auto Refresh JSP Pages -->




</head>
<body>




	<h3
		style="margin-left: 2px; font-family: Palatino Linotype; text-align: left;">Basic
		Details</h3>


	<table class="tablesorter">

		<c:forEach var="atm" items="${atm}">

			<tr>
				<th>Atm Id</th>
				<td>${atm.atmId}</td>
			</tr>
			<tr>
				<th>Name</th>
				<td>${atm.atmName}</td>
			</tr>
			<tr>
				<th>Installed Date</th>
				<td>${atm.installedDate}</td>
			</tr>
			<tr>
				<th>Serial No</th>
				<td>${atm.serialNo}</td>
			</tr>
			<tr>
				<th>Alert</th>
				<td>${atm.alert}</td>
			</tr>
			<tr>
				<th>Location</th>
				<td>${atm.atmLocation.locationName}</td>
			</tr>
			<tr>
				<th>Status</th>
				<td><div class="text_div">${atm.status}</div></td>
			</tr>
			<tr>
				<th>Live Packet Time</th>
				<td>${atm.livePktTime}</td>
			</tr>
			<tr>
				<th>Tray 1(Rs.)</th>
				<td>${atm.tray1}</td>
			</tr>
			<tr>
				<th>Tray 2 (Rs.)</th>
				<td>${atm.tray2}</td>
			</tr>
			<tr>
				<th>Reject1 (Rs.)</th>
				<td>${atm.reject1}</td>
			</tr>
			<tr>
				<th>Reject2 (Rs.)</th>
				<td>${atm.reject2}</td>
			</tr>
			
				<tr>
				<th>Battery Level</th>
				<td>${atm.batLevel}</td>
			</tr>

		</c:forEach>

		<c:forEach var="atm" items="${atmoperators}">

			<tr>
				<th>Operators</th>
				<td>${atm.operator.operatorName}</td>
			</tr>

		</c:forEach>
	</table>

<table>
<tr><td>
	<form action="<c:url value="/disableatm/${AtmTab}" />" method="GET">
		<input type='${Disablebtntype}' name="action" value="" style="background-image:url('<c:url value='/resources/img/disable.png'/>');  width: 55px; height: 55px; background-repeat: no-repeat; background-size: 100% 100%;  cursor:pointer;"/> 
	</form>
	</td>
	<td>
	<form action="<c:url value="/enableatm/${AtmTab}" />" method="GET">
		<input type='${Enablebtntype}' name="action" value="" style="background-image:url('<c:url value='/resources/img/enable.png'/>');  width: 55px; height: 55px; background-repeat: no-repeat; background-size: 100% 100%;  cursor:pointer;"/>
	</form>
	</td>
	<td>
	<form action="<c:url value="/unlockatm/${AtmTab}" />" method="GET">
		<input type="submit" name="action" value="" style="background-image:url('<c:url value='/resources/img/unlock.png'/>');  width: 55px; height: 55px; background-repeat: no-repeat; background-size: 100% 100%;  cursor:pointer;"/>
	</form>
	</td>
	<td>
	<form action="<c:url value="/rebootatm/${AtmTab}" />" method="GET">
		<input type="submit" name="action" value="" style="background-image:url('<c:url value='/resources/img/restart.png'/>');  width: 55px; height: 55px; background-repeat: no-repeat; background-size: 100% 100%;  cursor:pointer;"/>
	</form>
	</td>
	</tr>
	</table>
	<h3
		style="margin-left: 2px; font-family: Palatino Linotype; text-align: left;">Alerts</h3>

	<table class="tablesorter">

		<thead>
			<tr>
				<th>Alert Id</th>
				<th>Alert Type</th>
				<th>Triggerd Time</th>
				<th>Solved Time</th>
			</tr>
		<thead>
		<tbody>
			<c:forEach var="atm" items="${atmalerts}">
				<tr>
					<td>${atm.alertId}</td>
					<td>${atm.alertType.alertName}</td>
					<td>${atm.triggeredTime}</td>
					<td>${atm.solvedTime}</td>
				</tr>
			</c:forEach>
		<tbody>
	</table>



	<script>
$(".text_div").text(function () {
    return $(this).text().replace("1", "Connected"); 
});
</script>
	<script>
$(".text_div").text(function () { 
    return $(this).text().replace("0", "Failed"); 
});
</script>
	<script>
$(".text_div").text(function () { 
    return $(this).text().replace("2", "Disabled-Failed"); 
});
</script>
	<script>
$(".text_div").text(function () { 
    return $(this).text().replace("3", "Disabled-Connected"); 
});
    </script>
    


</body>
</html>
