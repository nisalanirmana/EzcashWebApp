<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<head>
<meta charset="utf-8">
<style>
table,th,td {
	border: 1px solid black;
}

th {
	background-color: #0489B1;
	color: white;
	padding: 5px;
}

td {
	background-color: #F2F2F2;
	color: black;
	padding: 5px;
}
</style>
</head>


<body>

	<table id="system" style="width: 100%">
		<tr>
			<td><input type="checkbox" name="chk"></td>
			<th>Group</th>
			<th>ATM Name</th>
			<th>Comm Status</th>
			<th>Last Download Time</th>
		</tr>
		
		<tbody>
		<tr>
		<td><input type="checkbox" name="chk"></td>
			<td>1</td>
			<td>Dehiwala</td>
			<td>Connected</td>
			<td>02.06.2014:10.10</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="chk"></td>
			<td>1</td>
			<td>Nawala</td>
			<td>Connected</td>
			<td>02.06.2014:10.10</td>
		</tr>
		<tr>
			<td><input type="checkbox" name="chk"></td>
			<td>1</td>
			<td>Gampaha</td>
			<td>Disconnected</td>
			<td>02.06.2014:10.10</td>
		</tr>
		</tbody>
	</table>
	
	

<input type="button" value="Add Row" onclick="addRow('system')">
 
    <input type="button" value="Delete Row" onclick="deleteRow('system')">
 
  

<script>
function addRow(tableID)
{
	var table=document.getElementById(tableID);
var rowCount=table.rows.length;
var row=table.insertRow(rowCount);

var cell1=row.insertCell(0);
var element1=document.createElement("input");
element1.type="text";
element1.name="txtbox[]";
cell1.appendChild(element1);

var cell2=row.insertCell(1);
var element2=document.createElement("input");
element2.type="text";
element2.name="txtbox[]";
cell2.appendChild(element2);

var cell3=row.insertCell(2);
var element3=document.createElement("input");
element3.type="text";
element3.name="txtbox[]";
cell3.appendChild(element3);

var cell4=row.insertCell(3);
var element4=document.createElement("input");
element4.type="text";
element4.name="txtbox[]";
cell4.appendChild(element4);
}

function deleteRow(tableID)
{try
{var table=document.getElementById(tableID);
var rowCount=table.rows.length;
for(var i=0;i<rowCount;i++)
{var row=table.rows[i];
var chkbox=row.cells[0].childNodes[0];
if(null!=chkbox&&true==chkbox.checked)
{table.deleteRow(i);rowCount--;i--;}}}
catch(e){alert(e);}}
</script>

</body>
</html>
