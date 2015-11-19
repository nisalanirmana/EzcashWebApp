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
<body>

	<h3
		style="margin-left: 2px; font-family: Palatino Linotype; text-align: left;">System
		Overview</h3>


	<table class="tablesorter">
		<thead>
			<tr>
				<th colspan="2">Action</th>
				<th>Atm Id</th>
				<th>Name</th>
				<th>Serial No</th>
				<th>Location</th>
				<th>Status</th>
				<th>Tray 1(Rs.)</th>
				<th>Tray 2 (Rs.)</th>


			</tr>
		</thead>
		<tbody>
			<c:forEach var="atm" items="${atm}">
				<tr>
					<td><a href="<c:url value='/removeatm/${atm.atmId}' />"><img
							src="<c:url value='/resources/img/delete.png'/>" /></a></td>
					<td><a href="<c:url value='/editAtm/${atm.atmId}' />"><img
							src="<c:url value='/resources/img/edit.png'/>" /></a></td>
					<td>${atm.atmId}</td>
					<td>${atm.atmName}</td>
					<td>${atm.serialNo}</td>
					<td>${atm.atmLocation.locationName}</td>
					<td><div class="text_div">${atm.status}</div></td>
					<td>${atm.tray1}</td>
					<td>${atm.tray2}</td>
			</c:forEach>
		</tbody>
	</table>
	<h3
		style="margin-left: 2px; font-family: Palatino Linotype; text-align: left;">Add/Edit
		Atm</h3>
	<table class="tablesorter">



		<thead>
			<form:form method="post" action='${taskAtm}'>

				<tr>
					<td>Atm Id</td>
					<td><input type="text" style="width: 100%" name="atmId"
						value="${atmAttribute[0].atmId}" readonly></td>

				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" style="width: 100%" name="atmName"
						value="${atmAttribute[0].atmName}" required></td>

				</tr>
				<tr>
					<td>Location</td>

					<td><select name="atmLocation" style="width: 100%">
							<option value="${atmAttribute[0].atmLocation.locationName}"
								label="${atmAttribute[0].atmLocation.locationName}" />
							<c:forEach var="atl" items="${atmlocationdrpdwnlist}">
								<option>${atl}</option>
							</c:forEach>
					</select></td>
					<td>Not here</td>
					<td></td>

				</tr>
				<tr>
					<td>Serial No</td>
					<td><input type="text" style="width: 100%" class="text"
						name="serialNo" value="${atmAttribute[0].serialNo}" required>
					</td>

				</tr>
				<tr>
					<td>Tray1 Amount</td>
					<td><input type="text" style="width: 100%" class="text"
						name="tray1" value="${atmAttribute[0].tray1}" required></td>
				</tr>
				<tr>
					<td>Tray2 Amount</td>
					<td><input type="text" style="width: 100%" class="text"
						name="tray2" value="${atmAttribute[0].tray2}" required></td>
				</tr>
				<tr>

					<td>Atm Code</td>
					<td><input type="text" style="width: 100%" class="text"
						name="atmcode" value="${atmAttribute[0].atmCode}" required>
					</td>
				</tr>
				<tr>
					<td>Tray1 Note</td>

					<td><input type="text" style="width: 100%" class="text"
						name="tray1NoteValue" value="${atmAttribute[0].tray1NoteValue}"
						required></td>
				</tr>
				<tr>
					<td>Tray2 Note</td>
					<td><input type="text" style="width: 100%" class="text"
						name="tray2NoteValue" value="${atmAttribute[0].tray2NoteValue}"
						required></td>

				</tr>
				<tr>
					<td>
					<td><input type="submit" style="width: 40%"
						value='${taskshowAtm}' name='${taskAtm}'></td>
					<td></td>

				</tr>




			</form:form>
	</table>
	<h3
		style="margin-left: 2px; font-family: Palatino Linotype; text-align: left;">Add
		New Atm Location</h3>
	<table class="tablesorter">

		<form:form method="post" action='${taskAtmLocation}'>
			<thead>
				<tr>
					<th colspan="2">Task</th>
					<th>Location Id</th>
					<th>Location Name</th>
					<th>Location X</th>
					<th>Location Y</th>
				</tr>
			<thead>
			<tbody>


				<c:forEach var="atmloc" items="${atmlocationlist}">
					<tr>
						<td><a
							href="<c:url value='/removeatmlocation/${atmloc.locationId}' />"><img
								src="<c:url value='/resources/img/delete.png'/>" /></a></td>
						<td><a
							href="<c:url value='/editAtmLocation/${atmloc.locationId}' />"><img
								src="<c:url value='/resources/img/edit.png'/>" /></a></td>


						<td>${atmloc.locationId}</td>
						<td>${atmloc.locationName}</td>
						<td>${atmloc.locationX}</td>
						<td>${atmloc.locationY}</td>


					</tr>


				</c:forEach>

				<tr>
					<td colspan="2"><input type="submit" style="width: 90%"
						value='${taskshowAtmLocation}' name='${taskAtmLocation}'></td>
					<td><input type="text" style="width: 80%" class="text"
						name="locationId" value="${atmLocationAttribute[0].locationId}"
						readonly></td>
					<td><input type="text" style="width: 80%" class="text"
						name="locationName"
						value="${atmLocationAttribute[0].locationName}" required></td>
					<td><input type="text" style="width: 80%" class="text"
						name="locationX" value="${atmLocationAttribute[0].locationX}"
						required></td>
					<td><input type="text" style="width: 80%" class="text"
						name="locationY" value="${atmLocationAttribute[0].locationY}"
						required></td>
				</tr>
			<tbody>
		</form:form>
	</table>




	<h3
		style="margin-left: 2px; font-family: Palatino Linotype; text-align: left;">Assigned
		Operators</h3>
	<table class="tablesorter">
		<form:form method="post" action="assignAtmOperator">

			<thead>
				<tr>
					<th>Task</th>
					<th>Id</th>
					<th>Atm Name</th>
					<th>ATM Operator</th>
					<th>ATM Operator Type</th>

				</tr>
			<thead>
			<tbody>


				<c:forEach var="atmop" items="${atmassignoplist}">
					<tr>
						<td><a
							href="<c:url value='/removeAssignedAtmOperator/${atmop.assignId}' />"><img
								src="<c:url value='/resources/img/delete.png'/>" /></a></td>
						<td>${atmop.assignId}</td>
						<td>${atmop.atm.atmName}</td>
						<td>${atmop.operator.operatorName}</td>
						<td><div class="text_div1">${atmop.operator.operatorType}</div></td>


					</tr>


				</c:forEach>
				<tr>
					<td><input type="submit" style="width: 90%" value="Save"
						name="assignAtmOperator"></td>

					<td><input type="text" style="width: 80%" class="text"
						name="assignId" value="${atmLocationAttribute[0].locationName}"
						readonly></td>

					<td><select name="atmId">
							<option value="" label="............." />
							<c:forEach var="at" items="${atmdrpdwnlist}">
								<option>${at}</option>
							</c:forEach>
					</select></td>

					<td><select name="operatorId">
							<option value="" label="............." />
							<c:forEach var="op" items="${operatordrpdwnlist}">
								<option>${op}</option>
							</c:forEach>
					</select></td>
					<td></td>

				</tr>
			<tbody>
		</form:form>








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
$( "div:contains('Failed')" ).css( "background-color", "#FF3366" );
</script>

<script>
$(".text_div1").text(function () { 
    return $(this).text().replace("0", "ATM Operator"); 
});
$(".text_div1").text(function () { 
    return $(this).text().replace("1", "Finance Division"); 
});
</script>

</body>
</html>