<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>System Overview</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href=" <c:url value="/resources/css/table.css" />"
	rel="stylesheet">
<link href=" <c:url value="/resources/themes/blue/style.css" />"
	rel="stylesheet">

<!-- Text Replace -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!-- Text Replace -->
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


	<table>
		<tr>
			<td width="550">

				<h3
					style="margin-left: 2px; font-family: Palatino Linotype; text-align: left;">System
					Overview</h3>
			</td>

			<td><img style='background-color: #84b4fb;'
				src="<c:url value='/resources/img/user.png'/>" /></td>

			<td><spring:url value="/logout" var="logoutUrl"
					htmlEscape="true" />
				<h4
					style="margin-right: 2px; font-family: Palatino Linotype; text-align: right;">Admin
					: ${LoginUser}</h4></td>
			<td><span
				style="font-family: Palatino Linotype; text-align: right;"><a
					href="${logoutUrl}">LogOut</a></span></td>
		</tr>
	</table>
	<table class="tablesorter">
		<thead>
			<tr>

				<th>Name</th>
				<th>Location</th>
				<th>Status</th>
				<th>Live Packet Time</th>
				<th>Tray 1(Rs.)</th>
				<th>Tray 2 (Rs.)</th>
				<th>Reject1 (Rs.)</th>
				<th>Reject2 (Rs.)</th>


			</tr>
		</thead>
		<tbody>
			<c:forEach var="atm" items="${atmlist}">
				<tr>

					<td>${atm.atmName}</td>
					<td>${atm.atmLocation.locationName}</td>
					<td><div class="text_div">${atm.status}</div></td>
					<td>${atm.livePktTime}</td>
					<td>${atm.tray1}</td>
					<td>${atm.tray2}</td>
					<td>${atm.reject1}</td>
					<td>${atm.reject2}</td>
			</c:forEach>
		</tbody>
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
	<script>
$( "div:contains('Failed')" ).css( "background-color", "#FF3366" );
</script>

</body>
</html>
