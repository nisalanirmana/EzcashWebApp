<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
    

    
      <link href=" <c:url value="/resources/css/table.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>System Overview</title>
       <link href=" <c:url value="/resources/css/ui-lightness/jquery-ui-1.7.2.custom.css" />" rel="stylesheet"> 
        <script src="<c:url value="/resources/js/jquery-1.3.2.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui-1.7.2.custom.min.js" />"></script>
        <script src="<c:url value="/resources/js/timepicker.js" />"></script>
<script type="text/javascript">
$(function() {
    $('.datetime').datepicker({
    	duration: '',
        showTime: true,
        dateFormat:"yy-mm-dd",
		time24h: true
     });
});
</script>
    </head>
    <body>
    

    
    
    
    	<div>
	        <h3 style="margin-left:2px;font-family: Palatino Linotype;" >Transactions</h3>
	      <form:form  action="getdates" method="post" >
	      <table>
			
			
			<tr>
				
				<td>Start Date</td>
				<td><input type="text" class="text"  name="fromDate" placeholder="dd/mm/yyyy"></td>
				
				<td>End Date</td>
				<td><input type="text" class="text"  name="toDate" placeholder="dd/mm/yyyy"></td>
			<td><input type="submit" value="Filter Transactions">	</td>
			</tr>
			
		
		</table>
	     </form:form>
	        <table class="tableatm">
	        <tr>
	        	
	        	<th>Transaction Time</th>
	        	<th>Transaction Amount</th>
	        	
	        	
	        	</tr>
	        	
				<c:forEach var="transactions" items="${transactions}" >
	        	<tr>
	        	
					<td>${transactions.cashOut.cashOutDate}</td>
					<td>${transactions.amount}</td>
					
				</c:forEach>	        	
			</table>
			
				
    	</div>
    </body>
</html>
