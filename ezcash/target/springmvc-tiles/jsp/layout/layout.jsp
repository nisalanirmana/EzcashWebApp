<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<script type="text/javascript" src="js/sivalabs.js"></script>
</head>
<body>

<table border="1" style="border-collapse: collapse;" cellpadding="2" cellspacing="2" align="center" width="1024">    <tbody><tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="header" /></td>
    </tr>
    <tr>
        <td width="150" height="450" valign="top" rowspan="2">
         <tiles:insertAttribute name="navigation" />
        </td>
        <td>
        
        </td>
    </tr>
    
       <tr>
          <td valign="top" width="650">

         <tiles:insertAttribute name="body" />

        </td>
    </tr>
    
    
    <tr>
        <td height="30" colspan="2">

         <tiles:insertAttribute name="footer" />

        </td>
    </tr>
</tbody></table></body>
</html>