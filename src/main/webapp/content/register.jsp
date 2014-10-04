<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Signup for Class Scheduler</title>
</head>
<body>
	<h2>Sign up</h2>
	<s:actionerror />
	<s:form action="Register.action" method="post">
		<s:textfield name="name"  key="global.name"></s:textfield>
		<s:textfield name="email"  key="global.email"></s:textfield>
		<s:textfield name="track" key="global.track"></s:textfield>
		<s:textfield name="school" key="global.school"></s:textfield>
		<s:textfield name="username"  key="global.username"></s:textfield>
		<s:password name="password" key="global.password"></s:password>
		<s:password name="password_confirmation" key="global.password_confirmation"></s:password>
		<s:submit method="execute"  value="Register" />
	</s:form>
	<s:a href="index">Back to Home</s:a>
</body>
</html>