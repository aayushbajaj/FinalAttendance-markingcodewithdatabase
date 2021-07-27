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
		action="${pageContext.request.contextPath}/ctl/attendance/session/search"
		modelAttribute="form">
		<div class="card" style="background-color: #536162; color: white;">
			<h5 class="card-header"
				style="background-color: #18334f; color: white;">Attended
				Sessions</h5>
			<div class="card-body">

				<b><%@ include file="businessMessage.jsp"%></b>
				
				<table class="table"
					style="background-color: #536162; color: white;">
					<thead>
						<tr>
							<th scope="col" style="text-align: center">S.No</th>
							<th scope="col" style="text-align: center">User Id</th>
							<th scope="col" style="text-align: center">Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="us" varStatus="user">
							<tr>
								<td scope="row">${user.index+1}</td>
								<td scope="row">${us.user.userId}</td>
								<td scope="row">${us.user.firstName}${us.user.lastName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>

		</div>
	</sf:form>
</div>

