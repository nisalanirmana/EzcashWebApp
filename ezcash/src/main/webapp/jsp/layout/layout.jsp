<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>

</head>
<body>

	<table border="0" align="center" width="1024">

		<tr>
			<td height="30" colspan="2"><tiles:insertAttribute name="header" />
			</td>
		</tr>

		<tr>
			<td width="124" height="520" valign="top" bgcolor="#f0f0ee"><tiles:insertAttribute
					name="navigation" /></td>



			<td valign="top" width="900" bgcolor="#EBF2FA"><tiles:insertAttribute
					name="body" /></td>
		</tr>

		<tr>
			<td colspan="2" bgcolor="#f0f0ee"><tiles:insertAttribute
					name="footer" /></td>
		</tr>

	</table>

</body>
</html>