<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/layout1/css/template.css" />
</head>
<body>
	<div id="header" class="cadre">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div id="content" class="cadre">
		<div id="menu" class="cadre">
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
		</div>
		<div id="body" class="cadre">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
	</div>
	<div id="footer" class="cadre">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</body>
</html>