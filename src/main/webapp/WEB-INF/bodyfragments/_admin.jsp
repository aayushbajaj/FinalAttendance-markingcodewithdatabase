<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container">
	
	<div class="card" style="margin-top:90px;">
		<h5 class="card-header"
			style="background-color: #18334f; color: white;">Admin
			</h5>
		<div class="card-body">
			<b><%@ include file="businessMessage.jsp"%></b>
			<sf:form method="post"
				action="${pageContext.request.contextPath}/ctl/admin/au-admin"
				modelAttribute="form">
				<sf:hidden path="id"/>
				<sf:hidden path="adminId"/>
			
				<div class="col-md-6">
					<s:bind path="firstName">
						<label class="form-label">First Name</label>
							<sf:input path="${status.expression}" placeholder="Enter First Name"
										class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				<div class="col-md-6">
					<s:bind path="lastName">
						<label  class="form-label">Last Name</label>
							<sf:input path="${status.expression}" placeholder="Enter Last Name"
										class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				<div class="col-md-6">
						<s:bind path="email">
						<label class="form-label">Email</label>
							<sf:input path="${status.expression}" placeholder="Enter Email"
										class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="password">
						<label class="form-label">Password</label>
							<sf:input type="password" path="${status.expression}" placeholder="Enter Password"
										class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				
				
				<div class="col-md-6">
					<s:bind path="gender">
						<label  class="form-label">Gender</label>
								<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options   items="${gender}" />
								</sf:select>
						<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="contactNo">
						<label  class="form-label">Contact No</label>
							<sf:input  path="${status.expression}" placeholder="Enter Contact No"
										class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="age">
						<label  class="form-label">Age</label>
							<sf:input  path="${status.expression}" placeholder="Enter Age"
										class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				
				<div class="col-md-6">
					<s:bind path="status">
						<label  class="form-label">Status</label>
							<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options   items="${stautsMap}" />
								</sf:select>
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
</div>