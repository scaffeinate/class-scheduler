<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Login to Class Scheduler</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<s:include value="assets.jsp"></s:include>
<link rel="stylesheet" type="text/css" href="css/login.css"></link>
</head>
<body>
	<s:include value="navbar.jsp"></s:include>
	<div class="container">
		<h2 id="login-heading" class="text-center">Login</h2>
		<div class="col-lg-8 col-lg-offset-2">
			<div class="col-lg-8 col-lg-offset-2">
				<div class="panel panel-default">
					<div class="panel-body form-panel">
						<s:if test="hasActionMessages()">
							<div class="alert alert-success alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<s:actionmessage cssStyle="list-style: none;" />
							</div>
						</s:if>
						<form action="Login.action" role="form" method="post">
							<div class="form-group">
								<s:textfield name="username" key="global.username"
									placeholder="Username" cssClass="form-control">
								</s:textfield>
								<s:fielderror fieldName="username" cssClass="fieldError" />
							</div>
							<div class="form-group">
								<s:password name="password" key="global.password"
									placeholder="Password" cssClass="form-control">
								</s:password>
								<s:fielderror fieldName="password" cssClass="fieldError" />
							</div>
							<s:submit method="execute" value="Login"
								cssClass="btn btn-success btn-block btn-login" />
						</form>
						<br>	
						<s:if test="hasActionErrors()">
							<div class="alert alert-danger alert-dismissible" role="alert">
								<button type="button" class="close" data-dismiss="alert">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<s:actionerror cssStyle="list-style: none;" />
							</div>
						</s:if>
						<div class="form-links">
							<s:a href="forgot-password">Forgot Password?</s:a>
							<s:a href="register">Sign up</s:a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>