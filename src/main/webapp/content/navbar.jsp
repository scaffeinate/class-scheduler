<%@ taglib prefix="s" uri="/struts-tags"%>
<nav class="navbar navbar-default navbar-custom navbar-fixed-top" role="navigation">
	<div class="container">
		<s:if test='%{#session.login == true}' >
			<s:a href="home" cssClass="navbar-brand">Class Scheduler</s:a>
		</s:if>
		<s:if test='%{#session.login == null}' >
			<s:a href="index" cssClass="navbar-brand">Class Scheduler</s:a>
		</s:if>
		<ul class="nav navbar-nav navbar-right">
	      	<s:if test='%{#session.login == true}' >
	      		<li><s:a href="home">Home</s:a></li>
	      		<li><a href="#"><%= session.getAttribute("current_user") %></a></li>
	      		<li><s:a action="Logout">Logout</s:a></li>
	      	</s:if>
	      	<s:if test='%{#session.login == null}'>
				<li><s:a href="register">Sign up</s:a></li>	      	
	      		<li><s:a href="login">Login</s:a></li>
	      	</s:if>
	      	
	     </ul>
	</div>
</nav>