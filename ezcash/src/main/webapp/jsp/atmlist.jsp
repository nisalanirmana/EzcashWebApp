<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href=" <c:url value="/resources/css/main.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4 style="font-family: Palatino Linotype;">Atm List</h4>

	<div class="navigation_bodyAtm">
		<ul>
			<c:forEach var="atm" items="${atmlist1}">


				<li class="var_navAtm">
					<div class="link_bgAtm"></div>
					<div class="link_titleAtm">
						<div class=iconAtm>
							<img src="<c:url value='/resources/img/menu_icon/atmlist.png'/>" />
						</div>


						<spring:url value="/${atm.atmName}" var="authenticatedUrl"
							htmlEscape="true" />
						<div class="aAtm">
							<a href="${authenticatedUrl}"
								class="a ${sessionScope.AtmTab eq atm.atmName?'currentTabAtm':'Tab'}"><span
								class="sapanAtm">${atm.atmName}</span></a>
						</div>
					</div>
				</li>


			</c:forEach>

		</ul>
	</div>
</body>
</html>

