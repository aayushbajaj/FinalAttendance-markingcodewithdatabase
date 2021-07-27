<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<style><%@include file="/WEB-INF/css/session.css"%></style>
<c:url var="addUrl" value="/ctl/enroll" />

<c:url var="addSearch" value="/ctl/enroll/search" />

<c:url var="editUrl" value="/ctl/enroll?id=" />

<sf:form method="post"
	action="${pageContext.request.contextPath}/ctl/enroll/search"
	modelAttribute="form">
	<div class="container text-dark">
		<!-- <div class="jumbotron"> -->
		<div class="card" style="background-color: #536162; color: white;">
			<h5 class="card-header"
				style="background-color: #536162; color: white;">User's Enrollment List</h5>

			<b><%@ include file="businessMessage.jsp"%></b>
			<br>

			<table class="table" style="background-color: #536162; color: white;">
				<thead>
					<tr>
						<th scope="col">S.No</th>
						<th scope="col">User Name</th>
						<th scope="col">Session Id</th>
						<th scope="col">Status</th>
						<th class="float-right">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="en" varStatus="enroll">
						<tr>
							<td scope="row">${enroll.index+1}</td>
							<td scope="row">${en.user.firstName}${en.user.lastName}</td>
							<td scope="row">${en.session.sessionId}</td>
							<td scope="row">${en.status}</td>
							<td><a href="${editUrl}${en.id}" class="btn btn-info">Edit</a>

							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	</div>
</sf:form>
</div>



