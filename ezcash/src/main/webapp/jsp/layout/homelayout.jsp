<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<body >

<table border="0" align="center" width="1024"  >
    <tr>
        <td valign="top" width="900"   >
        
			<tiles:insertAttribute name="body" />
		</td>
    </tr>
    
    <tr>
        <td colspan="2" bgcolor="#f0f0ee">
			<tiles:insertAttribute name="footer" />
		</td>
    </tr>
    
</table>

</body>
</html>