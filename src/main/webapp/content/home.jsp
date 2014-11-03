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
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<div class="alert alert-success alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<span>
						Welcome,
						<s:property value="%{user.getName()}" />
					</span>
				</div>
				<div class="jumbotron">
					<h2>This Page is a Work in progress. Please check back soon.</h2>
					<s:combobox	headerKey="-1" headerValue="--- Select ---" list="fruits" name="yourFruits"/>
				</div>
			</div>
		</div>
	</div>
</body>
</html>