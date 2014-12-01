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
				<h3>Selected Courses</h3>
				<hr>
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<td>Course Code</td>
							<td>Course Name</td>
							<td>Professor</td>
							<td>Days</td>
							<td>Timings</td>
						</tr>
					</thead>
					<s:iterator value="selectedCourses">
						<tr>

							<td><s:property value="coursecode" /></td>
							<td><s:property value="coursename" /></td>
							<td><s:property value="professor" /></td>
							<td><s:property value="day1" /> <s:if test="day2.length() != 0"> & <s:property value="day2" /></s:if></td>
							<td><s:property value="starttime" /> - <s:property
									value="endtime" /></td>
						</tr>
					</s:iterator>
				</table>
				<form action="RegisterCourse.action">
					<s:hidden value="%{itemId}"></s:hidden>
					<div class="row">
						<div class="col-lg-6">
							<s:submit value="Register" cssClass="btn btn-primary"></s:submit>
						</div>
						<div class="col-lg-6">
							<s:a href="home" cssClass="btn btn-default">Cancel</s:a>
						</div>
					</div>
				</form>
				<br><br>
				<s:if test="hasActionMessages()">
					<div class="alert alert-success alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<s:actionmessage cssStyle="list-style: none;" />
					</div>
				</s:if>
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
</body>
</html>