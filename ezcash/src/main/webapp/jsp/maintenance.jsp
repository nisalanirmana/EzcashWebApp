<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      	<link href=" <c:url value="/resources/css/table.css" />" rel="stylesheet">
      	<link href=" <c:url value="/resources/themes/blue/style.css" />" rel="stylesheet" > 
<link href=" <c:url value="/resources/css/ui-lightness/jquery-ui-1.7.2.custom.css" />" rel="stylesheet"> 
<!-- Date Picker -->
<script src="<c:url value="/resources/js/jquery-1.8.3.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui-1.7.2.custom.min.js" />"></script>
<!-- Time Picker -->
<script src="<c:url value="/resources/js/timepicker.js" />"></script>



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


			
			<!-- Reload -->
<h3 style="margin-left:2px;font-family: Palatino Linotype;text-align: left;" >Reload Tasks</h3>

		 <table  class="tablesorter">

	      
	
		<thead>
	        <tr>
	        	<th>Action</th>
	        	<th>Reload No</th>
	        	<th>Atm</th>
	        	<th>Operator</th>
	        	<th>ExpireTime</th>
	        	<th>Tray1 Amount</th>
	        	<th>Tray2 Amount</th>
	        	<th>Status</th>
	   
	        
     	
	        	
	        	</tr>
	        	<thead>
	      
	      <tbody>
				<c:forEach var="d" items="${reloadtasks}" >
	        	<tr>
	        		<td><a href="<c:url value='/remove/${d.reloadId}' />" ><img src="<c:url value='/resources/img/delete.png'/>" /></a></td>
	        		<td>${d.reloadId}</td>
					<td>${d.atm.atmName}</td>
					<td>${d.operator.operatorName}</td>
					<td>${d.taskExpiryTime}</td>
					<td>${d.tray1}</td>
					<td>${d.tray2}</td>
					<td><div class="text_div">${d.status}</div></td>
					
					
					
				</tr>
					
				</c:forEach>	
				   <tbody> 	

	<tr>   
		<form:form method="post" action="addReload">
			
			<td colspan="2">
				<input type="submit" style="width:100%" value="Add AtmReload">
			</td>
			
	
			<td>
						<select name="atm" >
                      	<option value="" label="............." />
						<c:forEach var="at" items="${atmdrpdwnlist}" >
                       <option>${at}</option>
						</c:forEach>
                       </select>
			</td>
			
			<td>
						<select name="operator" >
                      	<option value="" label="............." />
						<c:forEach var="op" items="${operatordrpdwnlist}" >
                       <option>${op}</option>
						</c:forEach>
                       </select>
			
			</td>
			
			<td>
				<input type="text" style="width:100%" class="datetime" name="taskExpiryTime" required>
			</td>
			
			<td>
				<input type="text" size="10" class="text" name="tray1" required>
			</td>
			
			<td >
				<input type="text" size="10" class="text" name="tray2" required>
			</td>
			<td>
			</td>
			
			
		

		</form:form>
	</tr>
	           	
			</table>
				
<script>
$(".text_div").text(function () { 
    return $(this).text().replace("1", "Task Created"); 
});
$(".text_div").text(function () { 
    return $(this).text().replace("2", "OTK sent"); 
});
$(".text_div").text(function () { 
    return $(this).text().replace("3", "Reload Started"); 
});
$(".text_div").text(function () { 
    return $(this).text().replace("4", "Reload End"); 
});
$(".text_div").text(function () { 
    return $(this).text().replace("5", "Cashout started "); 
});
$(".text_div").text(function () { 
    return $(this).text().replace("6", "Cashout OK"); 
});
</script>		






</body>

 
</html>
