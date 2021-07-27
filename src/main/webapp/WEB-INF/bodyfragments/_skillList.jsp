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
<c:url var="addUrl" value="/ctl/skill" />

<c:url var="addSearch" value="/ctl/skill/search" />

<c:url var="editUrl" value="/ctl/skill?id=" />


<div class="container">

	<sf:form method="post"
		action="${pageContext.request.contextPath}/ctl/skill/search"
		modelAttribute="form">
		<div class="card" style="background-color: #536162; color: white;">
			<h5 class="card-header"
				style="background-color: #536162; color: white;">SkillSet
				Report</h5>
			<div class="card-body">
				<div class="row g-3">
					<s:bind path="type">
						<div class="col" style="padding-left: 30%">
							<sf:input path="${status.expression}" class="form-control"
								placeholder="Search By Type" />
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
							<th scope="col"
								style="text-align: center; vertical-align: middle;">Select</th>
							<th scope="col" style="text-align: center">S.No</th>
							<th scope="col" style="text-align: center">Session Id</th>
							<th scope="col" style="text-align: center">Session Type</th>
							<th scope="col" style="text-align: center">Session
								Description</th>
							<th scope="col" style="text-align: center">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="sk" varStatus="skill">
							<tr>
								<td scope="row"
									style="text-align: center; vertical-align: middle;"><input
									type="checkbox" class="case" name="ids" value="${sk.id}"></td>
								<td scope="row" style="text-align: center">${skill.index+1}</td>
								<td scope="row" style="text-align: center">${sk.skillId}</td>
								<td scope="row" style="text-align: center">${sk.type}</td>
								<td scope="row" style="text-align: center">${sk.description}</td>
								<td style="text-align: center"><a
									href="${editUrl} ${sk.id}" class="btn btn-primary btn btn-info">Edit</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="clearfix"></div>
				<ul class="pagination pull-right">
					<%-- <li><input type="submit" name="operation"
class="btn  btn-primary btn-sm"
<c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
value="Previous"></li> --%>
					<li></li>
					<li><input type="submit" name="operation"
						class="btn  btn-primary btn-sm"
						<c:if test="${listsize == 0}">disabled="disabled"</c:if>
						value="Delete"></li>
					<li></li>

					<li><input type="submit" name="operation"
						class="btn  btn-primary btn-sm" style="margin-left: 60px;"
						value="New"></li>
					<li></li>


					
				</ul>
			</div>

		</div>
	</sf:form>
</div>

