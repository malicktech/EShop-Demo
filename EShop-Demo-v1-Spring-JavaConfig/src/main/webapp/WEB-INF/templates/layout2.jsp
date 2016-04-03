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
	href=" <%=request.getContextPath()%>/resources/layout2/css/template.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
	
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/jquery/jquery-1.12.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/eboutique.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
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
</div>	
</body>
</html>