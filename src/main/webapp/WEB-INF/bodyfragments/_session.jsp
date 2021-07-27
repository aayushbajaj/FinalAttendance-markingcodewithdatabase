<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<style><%@include file="/WEB-INF/css/session.css"%></style>

<div class="container">
	
	<div class="card">
		<h2 class="card-header">Add Session
			</h2>
		<div class="card-body">
			<b><%@ include file="businessMessage.jsp"%></b>
			
					<sf:form method="post"
				action="${pageContext.request.contextPath}/ctl/session"
				modelAttribute="form">
							<sf:hidden path="id"/>
				<sf:hidden path="sessionId"/>
				<div class="row">
				<s:bind path="skillId">
					<label 
						class="col-sm-3 col-form-label col-form-label-lg label1">Skill Set</label>
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
				<s:bind path="sessionType">
					<label 
						class="col-sm-3 col-form-label col-form-label-lg label1">Status</label>
					<div class="col-sm-5">
						<sf:select class="form-control form-control-lg input1"
							 path="${status.expression}" >
						<sf:option value="" label="Select" />
								<sf:options items="${sType}" />
						</sf:select>	
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="row">
				<s:bind path="date">
					<label 
						class="col-sm-3 col-form-label col-form-label-lg label1">Session Date</label>
					<div class="col-sm-5">
						<sf:input class="form-control form-control-lg input1"
							 path="${status.expression}" autocomplete="off" placeholder="Enter session date"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="row">
				<s:bind path="time">
					<label 
						class="col-sm-3 col-form-label col-form-label-lg label1">Session Time</label>
					<div class="col-sm-5">
						<sf:input type="time" class="form-control form-control-lg input1"
							 path="${status.expression}" autocomplete="off" placeholder="Enter session time"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="row">
				<s:bind path="slot">
					<label 
						class="col-sm-3 col-form-label col-form-label-lg label1">Session Slot</label>
					<div class="col-sm-5">
						<sf:input type="text" class="form-control form-control-lg input1"
							 path="${status.expression}" autocomplete="off" placeholder="Enter session slot"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="row">
				<s:bind path="description">
					<label 
						class="col-sm-3 col-form-label col-form-label-lg label1">Session Description</label>
					<div class="col-sm-5">
						<sf:input type="text" class="form-control form-control-lg input1"
							 path="${status.expression}" autocomplete="off" placeholder="Enter session description"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="col-12">
					<input type="submit" name="operation"
						class="btn  btnSubmit" value="Save">
				</div> 
				
			</sf:form>
	</div>
</div>
</div>

<script>
	$('#date').datepicker({
		format : 'dd/mm/yyyy'
	});
</script>
