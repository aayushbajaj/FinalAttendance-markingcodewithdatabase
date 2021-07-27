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

<c:url var="addSearch" value="/ctl/trainer/search" />

<c:url var="editUrl" value="/ctl/trainer?id=" />

<sf:form method="post"
	action="${pageContext.request.contextPath}/ctl/trainer/search"
	modelAttribute="form">

	<div class="container text-dark">
		<div class="card" style="background-color: #536162; color: white;">
			<h5 class="card-header"
				style="background-color: #536162; color: white;">Trainer Report</h5>
			<div class="card-body">
				<div class="row g-5">
					<s:bind path="name">
						<div style="padding-left: 30%;" class="col">
							<sf:input path="${status.expression}" class="form-control"
								placeholder="Search By Name" />
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
							<th scope="col" style="text-align: center; vertical-align: middle;">Select</th>
							<th scope="col" style="text-align: center">Trainer Id</th>
							<th scope="col" style="text-align: center">Name</th>
							
							<th scope="col" style="text-align: center">Session Id</th>
							
							<th scope="col" style="text-align: center">Skill Type</th>
							<th scope="col" style="text-align: center">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="tr" varStatus="trainer">
							<tr>
								<td scope="row"
									style="text-align: center; vertical-align: middle;"><input
									type="checkbox" class="case" name="ids" value="${tr.id}"></td>
								<td scope="row" style="text-align: center">${tr.trainerId}</td>
								<td scope="row" style="text-align: center">${tr.name}</td>	
								<td scope="row" style="text-align: center">${tr.session.sessionId}</td>	
								<td scope="row" style="text-align: center">${tr.skill.type}</td>
								<td style="text-align: center"><a
									href="${editUrl} ${tr.id}" class="btn btn-primary btn btn-info">Edit</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="clearfix"></div>

				<ul class="pagination pull-right">
					

					<li><input type="submit" name="operation"
						class="btn btn-primary btn btn-info"
						<c:if test="${listsize == 0}">disabled="disabled"</c:if>
						value="Delete"></li>

					
				</ul>
			</div>
		</div>
	</div>


</sf:form>
