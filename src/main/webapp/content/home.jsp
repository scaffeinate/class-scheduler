<%@page import="com.ooad.project.class_scheduler.model.UserModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<s:include value="assets.jsp"></s:include>
<title>Class Scheduler</title>
</head>
<body>
	<s:include value="navbar.jsp"></s:include>
	<h4>Hello <s:property value="%{user.getName()}" /></h4>
</body>
</html>