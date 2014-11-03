<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Class Scheduler</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<s:include value="assets.jsp"></s:include>
<link rel="stylesheet" type="text/css" href="css/login.css"></link>
</head>
<body>
	<s:include value="navbar.jsp"></s:include>
	<div class="container">
		<h2 id="login-heading" class="text-center">Recover Password</h2>
		<div class="col-lg-8 col-lg-offset-2">
			<div class="col-lg-8 col-lg-offset-2">
				<div class="panel panel-default">
					<div class="panel-body form-panel">
						<form action="ForgotPassword.action" role="form" method="post">
							<div class="form-group">
								<s:textfield name="email" key="global.email"
									placeholder="Email" cssClass="form-control">
								</s:textfield>
								<s:fielderror fieldName="email" cssClass="fieldError" />
							</div>
							<s:submit value="Recover Password" cssClass="btn btn-primary btn-block btn-login" />
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
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>