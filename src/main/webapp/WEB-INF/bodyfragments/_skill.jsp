<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container">
	

	<div class="card">
		<h5 class="card-header"
			style="background-color: #18334f; color: white; margin-top:40px;">Skill Set
			</h5>
		<div class="card-body">
			<b><%@ include file="businessMessage.jsp"%></b>
			<sf:form method="post"
				action="${pageContext.request.contextPath}/ctl/skill"
				modelAttribute="form">
				<sf:hidden path="id"/>
				<sf:hidden path="skillId"/>
			
				<div class="col-md-6">
					<s:bind path="type">
						<label  class="form-label">Skill Type</label>
							<sf:input path="${status.expression}" placeholder="Enter the topic "
										class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				<div class="col-md-6">
					<s:bind path="description">
						<label  class="form-label">Description</label>
							<sf:textarea path="${status.expression}" rows="4" cols="4" placeholder="Enter Decription"
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