<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
      <link href=" <c:url value="/resources/css/table.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>System Overview</title>
        
       
        
        
    </head>
    <body>
    
    
    	<div>
	        <h3 style="margin-left:2px;font-family: Palatino Linotype;text-align: left;" >System Overview</h3>
	      
	       
	        <table class="tableatm">
	         <col width="195">
	              <col width="195">
	             <col width="195">   
	             <col width="195"> 
	        <tr>
	        	
	        	<th>Name</th>
	        	<th>Location</th>
	        	<th>Status</th>
	        	<th>Cash Balance</th>
	        	
	        	</tr>
	        	
				<c:forEach var="atm" items="${atmlist}" >
	        	<tr>
	        	
					<td>${atm.atmName}</td>
					<td>${atm.atmLocation.locationName}</td>
					<td>${atm.status}</td>
					<td>No Data</td>
				</c:forEach>	        	
			</table>
			
				
    	</div>
    </body>
</html>
