<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Class Scheduler</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<s:include value="content/assets.jsp"></s:include>
<link rel="stylesheet" type="text/css" href="css/index.css" />
</head>
<body>
	<s:include value="content/navbar.jsp"></s:include>
	<div id="index-page" class="container">
		<div class="col-lg-6">
			<div id="about" class="panel panel-default">
				<div class="panel-body">
					<h3>About</h3>
					<hr>
					<p>The Product is designed to be used by the Students at
						Different Universities in the World. Students often needs to keep
						a track of schedule of their classes and to know if a class is
						cancelled or rescheduled. The Class Scheduler Application is
						designed to provide Students with the functionality to have a
						mobile application that stores the entire schedule of the Student
						and providing Notifications some time before a class is actually
						scheduled to start. Also the Product will provide instant
						notification when a class is cancelled or rescheduled on their
						phone itself.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="jumbotron">
				<h2 class="text-center">To Get Started</h2><br>
				<div class="row">
					<div class="col-lg-6 col-lg-offset-3">
						<p>
							<s:a href="register" cssClass="btn btn-primary btn-block btn-md">
							Sign up</s:a>
						</p>
						<p>
							Or <s:a href="login">Login</s:a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>