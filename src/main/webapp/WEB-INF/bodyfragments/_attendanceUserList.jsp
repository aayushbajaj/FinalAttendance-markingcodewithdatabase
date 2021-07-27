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
<c:url var="addUrl" value="/ctl/trainer" />

<c:url var="addSearch" value="/ctl/attendance/user/search" />

<c:url var="editUrl" value="/ctl/trainer?id=" />


<div class="container">

	<sf:form method="post"
		action="${pageContext.request.contextPath}/ctl/attendance/user/search"
		modelAttribute="form">
		<div class="card" style="background-color: #536162;">
			<h5 class="card-header"
				style="background-color: #536162; color: white;">Mark
				Attendance</h5>

			
			<table class="table" style="background-color: #536162; color: white;">
				<thead>
					<tr>
						<th style="text-align: center">Mark Attendance</th>
						<th scope="col" style="text-align: center">S.no</th>
						<th scope="col" style="text-align: center">User Id</th>
						<th scope="col" style="text-align: center">Name</th>
						<th scope="col" style="text-align: center">Status</th> 
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="us" varStatus="user">
						<tr>
							<td td scope="row"
								style="text-align: center; vertical-align: middle;"><input
								type="checkbox" class="case" name="ids" value="${us.user.id}"></td>
							<td scope="row" style="text-align: center;">${user.index+1}</td>
							<td scope="row" style="text-align: center;">${us.user.userId}</td>
							<td scope="row" style="text-align: center;">${us.user.firstName} ${us.user.lastName}</td>
							<td scope="row" style="text-align: center;">${us.status}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>



		</div>
		<div class="col-md-12 text-center">
			<input type="submit" style="margin-top: 30px" value="Save"
				name="operation" class="btn btn-info">
		</div>

	</sf:form>
</div>

