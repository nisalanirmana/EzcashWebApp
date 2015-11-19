<!--  <p><a href="createUser.do">Create User</a></p><p><a href="listUsers.do">View Users</a></p><p><a href="logout.do">Logout</a></p>-->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href=" <c:url value="/resources/css/main.css" />" rel="stylesheet">
<!-- <link rel="stylesheet" href="/resources/css/main.css" /> -->

</head>
<body>

	<div class="navigation_body">

		<ul>
			<li class="var_nav">
				<div class="link_bg"></div>
				<div class="link_title">
					<div class=icon>
						<img src="<c:url value='/resources/img/menu_icon/overview.png'/>" />
					</div>
					<spring:url value="/authenticated" var="authenticatedUrl"
						htmlEscape="true" />

					<a href="${authenticatedUrl}"
						class="a ${sessionScope.MenuTab eq 'system'?'currentTab':'Tab'}"><span>Overview</span></a>

				</div>
			</li>

			<li class="var_nav">
				<div class="link_bg"></div>
				<div class="link_title">
					<div class=icon>
						<img src="<c:url value='/resources/img/menu_icon/atm.png'/>" />
					</div>

					<spring:url value="/atmList" var="atmUrl" htmlEscape="true" />
					<a href="${atmUrl}"
						class="a ${sessionScope.MenuTab eq 'atm'?'currentTab':'Tab'}"><span>ATM</span></a>

				</div>
			</li>

			<li class="var_nav">
				<div class="link_bg"></div>
				<div class="link_title">
					<div class=icon>
						<img
							src="<c:url value='/resources/img/menu_icon/transaction.png'/>" />
					</div>
					<spring:url value="/transaction" var="transactionUrl"
						htmlEscape="true" />
					<a href="${transactionUrl}"
						class="a ${sessionScope.MenuTab eq 'transaction'?'currentTab':'Tab'}"><span>Transaction</span></a>
				</div>
			</li>

			<li class="var_nav">
				<div class="link_bg"></div>
				<div class="link_title">
					<div class=icon>
						<img src="<c:url value='/resources/img/menu_icon/users.png'/>" />
					</div>
					<spring:url value="/users" var="usersUrl" htmlEscape="true" />
					<a href="${usersUrl}"
						class="a ${sessionScope.MenuTab eq 'users'?'currentTab':'Tab'}"><span>Users</span></a>
				</div>
			</li>
			<li class="var_nav">
				<div class="link_bg"></div>
				<div class="link_title">
					<div class=icon>
						<img src="<c:url value='/resources/img/menu_icon/operators.png'/>" />
					</div>
					<spring:url value="/operators" var="operatorsUrl" htmlEscape="true" />
					<a href="${operatorsUrl}"
						class="a ${sessionScope.MenuTab eq 'operators'?'currentTab':'Tab'}"><span>Operators</span></a>
				</div>
			</li>

			<li class="var_nav">
				<div class="link_bg"></div>
				<div class="link_title">
					<div class=icon>
						<img
							src="<c:url value='/resources/img/menu_icon/maintenance.png'/>" />
					</div>
					<spring:url value="/maintenance" var="maintenanceUrl"
						htmlEscape="true" />
					<a href="${maintenanceUrl}"
						class="a ${sessionScope.MenuTab eq 'maintenance'?'currentTab':'Tab'}"><span>Maintenance</span></a>
				</div>
			</li>

			<li class="var_nav">
				<div class="link_bg"></div>
				<div class="link_title">
					<div class=icon>
						<img src="<c:url value='/resources/img/menu_icon/alerts.png'/>" />
					</div>
					<spring:url value="/alerts" var="alertsUrl" htmlEscape="true" />
					<a href="${alertsUrl}"
						class="a ${sessionScope.MenuTab eq 'alerts'?'currentTab':'Tab'}"><span>Alerts</span></a>
				</div>
			</li>
			<!--  
         <li class="var_nav">
        	<div class="link_bg"></div>
        		<div class="link_title">
        			<div class=icon> 
        				<img src="<c:url value='/resources/img/menu_icon/about.png'/>" />
        			</div>
            				<spring:url value="/about" var="aboutUrl" htmlEscape="true"/>
            					<a href="${aboutUrl}" class="a ${sessionScope.MenuTab eq 'about'?'currentTab':'Tab'}"><span>About</span></a>
            	</div>				
        </li>
        -->

		</ul>
	</div>
</body>
</html>


