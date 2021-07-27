<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container">
	<br>
	<nav style="-bs-breadcrumb-divider: '&gt;';" aria-label="breadcrumb">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="<c:url value="/welcome"/>">Home</a></li>
			<li class="breadcrumb-item active" aria-current="page">Session FeedBack</li>
		</ol>
	</nav>
	<br>

	<div class="card">
		<h5 class="card-header"
			style="background-color: #18334f; color: white;">Session FeedBack
			</h5>
		<div class="card-body">
			<b><%@ include file="businessMessage.jsp"%></b>
			<sf:form method="post"
				action="${pageContext.request.contextPath}/ctl/userFeedBack"
				modelAttribute="form">
				<sf:hidden path="id"/>
			
				<div class="col-md-6">
					<s:bind path="subject">
						<label class="form-label">Your Experience</label>
							<sf:textarea path="${status.expression}" placeholder="Share your experience"
										class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				<div class="col-md-6">
					<s:bind path="message">
						<label class="form-label">Any Suggestions</label>
							<sf:textarea path="${status.expression}" rows="4" cols="4" placeholder="Any suggestions"
										class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
		<br>
				<div class="col-12">
					<input type="submit" name="operation" class="btn btn-primary pull-right"
								value="Save">
				</div>
			</sf:form>
		</div>
	</div>
</div>