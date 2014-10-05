<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login to Class Scheduler</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<h2>Class Scheduler - Login</h2>
	<s:actionmessage />
	<s:actionerror />
	<s:form action="Login.action" method="post">
		<s:textfield name="username"  key="global.username"></s:textfield>
		<s:password name="password" key="global.password"></s:password>
		<s:submit method="execute"  value="Login" />
	</s:form>
	<s:a href="register">Sign up</s:a>
</body>
</html>