<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container">
	<br>
	<nav style="-bs-breadcrumb-divider: '&gt;';" aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item active" aria-current="page">Forget Password</li>
		</ol>
	</nav>
	<br>

	<div class="card">
		<h5 class="card-header"
			style="background-color: #18334f; color: white;">Forget Password
			</h5>
		<div class="card-body">
			<b><%@ include file="businessMessage.jsp"%></b>
			<sf:form method="post"
							action="${pageContext.request.contextPath}/user/forgetPassword" modelAttribute="form"
							>
								<b><%@ include file="businessMessage.jsp"%></b>
								<div class="col-md-6">
								<s:bind path="email">
									<label>Email Id:</label>
									<sf:input path="${status.expression}" placeholder="Enter Login"
										class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
							<br>
							<input type="submit" name="operation" class="btn btn-primary pull-right"
								value="Go">
						</sf:form>
		</div>
	</div>
</div>