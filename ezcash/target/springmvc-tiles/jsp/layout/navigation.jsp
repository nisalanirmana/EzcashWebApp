<!--  <p><a href="createUser.do">Create User</a></p><p><a href="listUsers.do">View Users</a></p><p><a href="logout.do">Logout</a></p>-->

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

<div class="menu">

    <ul>
        <li>
            <spring:url value="/system" var="systemUrl" htmlEscape="true"/>
            <a href="${systemUrl}">Overview</a>
        </li>
                <li>
            <spring:url value="/atm" var="atmUrl" htmlEscape="true"/>
            <a href="${atmUrl}">ATM</a>
        </li>
                <li>
            <spring:url value="/transaction" var="transactionUrl" htmlEscape="true"/>
            <a href="${transactionUrl}">Transaction</a>
        </li>
                <li>
            <spring:url value="/users" var="usersUrl" htmlEscape="true"/>
            <a href="${usersUrl}">Users</a>
        </li>
                <li>
            <spring:url value="/operators" var="operatorsUrl" htmlEscape="true"/>
            <a href="${operatorsUrl}">Operators</a>
        </li>
                <li>
            <spring:url value="/maintenance" var="maintenanceUrl" htmlEscape="true"/>
            <a href="${maintenanceUrl}">Maintenance</a>
        </li>
                <li>
            <spring:url value="/alerts" var="alertsUrl" htmlEscape="true"/>
            <a href="${alertsUrl}">Alerts</a>
        </li>
                <li>
            <spring:url value="/about" var="aboutUrl" htmlEscape="true"/>
            <a href="${aboutUrl}">About</a>
        </li>
                
    </ul>
</div>


</body>
</html>


