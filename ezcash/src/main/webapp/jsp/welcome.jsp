<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
		<meta charset="utf-8">
	    <link href="resources/css/style.css" rel='stylesheet' type='text/css' />
<title>Welcome To eZ-Cash ATM Managment System</title>
</head>
<body>


	<!-----start-main---->
	<div class="login-form">

<h1>Dialog eZCash Management System</h1>
<br>
		<form:form method="post" action="authenticate">
			<li><input type="text" class="text" name="name"
				placeholder="User Name" required><a href="#"
				class=" icon user"></a></li>
			<li><input type="password" name="password"
				placeholder="Password" required><a href="#"
				class=" icon lock"></a></li>

			<input type="submit" value="Login">
		<div style="color:red">${Msg}</div>
		</form:form>
		
	</div>
	<!--//End-login-form-->




</body>




</html>
