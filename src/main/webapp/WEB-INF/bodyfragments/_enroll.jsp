<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<style><%@include file="/WEB-INF/css/session.css"%></style>
<div class="container">
	<%-- <br>
<nav style="-bs-breadcrumb-divider: '&gt;';" aria-label="breadcrumb">
<ol class="breadcrumb">
<li class="breadcrumb-item"><a href="<c:url value="/welcome"/>">Home</a></li>
<li class="breadcrumb-item active" aria-current="page">Enroll</li>
</ol>
</nav>
<br> --%>

	<div class="card">
		<h5 class="card-header"
			style="background-color: #548CA8; color: white; text-align: center;">Enroll
		</h5>
		<div class="card-body">
			<b><%@ include file="businessMessage.jsp"%></b>
			<sf:form method="post"
				action="${pageContext.request.contextPath}/ctl/enroll"
				modelAttribute="form">
				<sf:hidden path="id" />
				<sf:hidden path="sessionId" />
				<sf:hidden path="userId" />


				<div class="col-md-6">
					<s:bind path="status">
						<label for="inputEmail4" class="form-label">Status</label>
						<sf:select class="form-control" path="${status.expression}">
							<sf:option value="" label="Select" />
							<sf:options items="${stautsMap}" />
						</sf:select>
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>


				<br>
				<div class="col-12">
					<input type="submit" name="operation"
						class="btn btn-primary pull-right" value="Save">
				</div>
			</sf:form>
		</div>
	</div>
</div>

