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
<c:url var="addUrl" value="/ctl/userFeedBack" />

<c:url var="addSearch" value="/ctl/userFeedBack/search" />

<sf:form method="post"
	action="${pageContext.request.contextPath}/ctl/userFeedBack/search"
	modelAttribute="form">

	<div class="container text-dark" height=500px;">
		<div class="card">
			<h5 class="card-header"
				style="background-color: #536162; color: white;">Session
				Feedback</h5>
			<div class="card-body"
				style="background-color: #536162; color: white;">
				<div class="row g-5">

					<s:bind path="sessionId">
						<div class="col" style="padding-left: 30%;">
							<sf:input path="${status.expression}" class="form-control"
								placeholder="Search By Session Id" />
						</div>
					</s:bind>
					<div class="col">
						<input type="submit" class="btn btn-primary btn btn-info"
							name="operation" value="Search">
					</div>
				</div>
				<b><%@ include file="businessMessage.jsp"%></b>
				
				<table class="table"
					style="background-color: #536162; color: white;">


					<thead>
						<tr>
							<th scope="col" style="text-align: center">S.No</th>
							<th scope="col" style="text-align: center">Session Id</th>
							<th scope="col" style="text-align: center">User's
								Suggestions</th>
							<th scope="col" style="text-align: center">User's Experience</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="ses" varStatus="sess">
							<tr>

								<td scope="row" style="text-align: center">${sess.index+1}</td>
								<td scope="row" style="text-align: center">${ses.session.sessionId}</td>
								<td scope="row" style="text-align: center">${ses.subject}</td>
								<td scope="row" style="text-align: center">${ses.message}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</sf:form>
