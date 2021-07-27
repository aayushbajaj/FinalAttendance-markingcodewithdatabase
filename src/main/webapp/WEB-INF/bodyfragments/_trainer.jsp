<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<style><%@include file="/WEB-INF/css/session.css"%></style>
<div class="container">

		<div class="card">
		<h2 class="card-header">Add Trainer
			</h2>
		<div class="card-body">
			<b><%@ include file="businessMessage.jsp"%></b>
			<sf:form method="post"
				action="${pageContext.request.contextPath}/ctl/trainer"
				modelAttribute="form">
				 <sf:hidden path="id" />
				<sf:hidden path="trainerId" />
					
					<div class="row">
				<s:bind path="sessionId">
					<label 
						class="col-sm-3 col-form-label col-form-label-lg label1">Session</label>
					<div class="col-sm-5">
						<sf:select class="form-control form-control-lg input1"
							 path="${status.expression}" >
						<sf:option value="-1" label="Select" />
								<sf:options itemLabel="sessionId" itemValue="id" items="${sessionList}" />
						</sf:select>	
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				
				<div class="row">
				<s:bind path="skillId">
					<label 
						class="col-sm-3 col-form-label col-form-label-lg label1">Skill set</label>
					<div class="col-sm-5">
						<sf:select class="form-control form-control-lg input1"
							 path="${status.expression}" >
						<sf:option value="-1" label="Select" />
								<sf:options itemLabel="skillId" itemValue="id" items="${skillList}" />
						</sf:select>	
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
						
				
				<div class="row">
				<s:bind path="name">
					<label 
						class="col-sm-3 col-form-label col-form-label-lg label1">Name</label>
					<div class="col-sm-5">
						<sf:input type="text" class="form-control form-control-lg input1"
							 path="${status.expression}" autocomplete="off" placeholder="Enter name"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}" /></font>
					</s:bind>
				</div>

				<div class="row">
				<s:bind path="email">
					<label
						class="col-sm-3 col-form-label col-form-label-lg label1">Email</label>
					<div class="col-sm-5">
						<sf:input type="email" class="form-control form-control-lg input1"
							 path="${status.expression}" autocomplete="off" placeholder="Enter Email"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="row">
				<s:bind path="contactNo">
					<label 
						class="col-sm-3 col-form-label col-form-label-lg label1">Contact No</label>
					<div class="col-sm-5">
						<sf:input type="text" class="form-control form-control-lg input1"
							 path="${status.expression}" autocomplete="off" placeholder="Enter name"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>

				
				<div class="col-12">
					<input type="submit" name="operation"
						class="btn  btnSubmit"  value="Save">
				</div> 
			</sf:form>
		</div>
	</div>
</div> 