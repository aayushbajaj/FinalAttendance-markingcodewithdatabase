<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/ctl/admin/au-admin" />

<c:url var="addSearch" value="/ctl/admin/search" />

<c:url var="editUrl" value="/ctl/admin/au-admin?id=" />


<div class="container">

<sf:form method="post"
action="${pageContext.request.contextPath}/ctl/complain/search"
modelAttribute="form">
<div class="card" style="background-color:#536162; color:white; margin-top:100px;">
<h5 class="card-header"
style="background-color: #536162; color: white;">Admin Report</h5>
<div class="card-body" style="background-color:#536162; color:white;">

<b><%@ include file="businessMessage.jsp"%></b>

<table class="table" style="background-color:#536162; color:white;">
<thead>
<tr>

<th scope="col" style="text-align: center">S.No</th>
<th scope="col" style="text-align: center">First Name</th>
<th scope="col" style="text-align: center">Last Name</th>
<th scope="col" style="text-align: center">Email Id</th>
<th scope="col" style="text-align: center">Contact No</th>
<th scope="col" style="text-align: center">Age </th>
<th scope="col" style="text-align: center">Gender</th>
<th scope="col" style="text-align: center">Status</th>
<th scope="col" style="text-align: center">Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="adm" varStatus="admin">
<tr>

<td scope="row" style="text-align: center">${admin.index+1}</td>
<td scope="row" style="text-align: center">${adm.firstName}</td>
<td scope="row" style="text-align: center">${adm.lastName}</td>
<td scope="row" style="text-align: center">${adm.emailId}</td>
<td scope="row" style="text-align: center">${adm.contactNo}</td>
<td scope="row" style="text-align: center">${adm.age}</td>
<td scope="row" style="text-align: center">${adm.gender}</td>
<td scope="row" style="text-align: center">${adm.status}</td>
<td><a href="${editUrl} ${adm.id}"
class="btn btn-primary btn btn-info">Edit</a></td>
</tr>
</c:forEach>
</tbody>
</table>


</div>
</sf:form>
</div>