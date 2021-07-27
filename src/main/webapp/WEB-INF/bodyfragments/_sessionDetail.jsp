<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<style><%@include file="/WEB-INF/css/session.css"%></style>
<div class="session-main" >

	<div class="session-detail">
		<h3 >Session Detail</h3>
			<b><%@ include file="businessMessage.jsp"%></b>
			<sf:form method="post" action="${pageContext.request.contextPath}/ctl/session" modelAttribute="form">
				<sf:hidden path="id"/>
				<sf:hidden path="sessionId"/>
			
				<div class="col-md-10">
						<span class="form-label"><b>Session Id :</b></span>
							<span class="form-value">${form.sessionId}</span>
				</div>
				<div class="col-md-6">
						<span  class="form-label"><b> Date :</b></span>
							<span class="form-value">${form.date}</span>
				</div>
				
				<div class="col-md-6">
						<span  class="form-label"><b>Slot : </b></span>
							<span class="form-value">${form.slot}</span>
				</div>
				
				<div class="col-md-6">
						<span  class="form-label"><b> Time : </b></span>
							<span class="form-value">${form.time}</span>
				</div>
				
				<div class="col-md-6">
						<span  class="form-label"><b> Description : </b></span>
							<span class="form-value">${form.description}</span>
				</div>
				
				<div class="col-md-6">
						<span  class="form-label"><b> SkillSet Id : </b></span>
							<span class="form-value">${form.skills.skillId}</span>
				</div>
				
				<div class="col-md-6">
						<span  class="form-label"><b> SkillSet Type: </b></span>
							<span class="form-value">${form.skills.type}</span>
				</div>
				<div class="col-md-6">
						<span  class="form-label"><b> SkillSet Description: </b></span>
							<span class="form-value">${form.skills.description}</span>
				</div>
				
				<div class="col-md-6" style="margin-left="80px;>
							<button "><a class="btn btn-info" href="<c:url value="/ctl/enroll/add?operation=Enroll&sId=${form.id}"/>">Enroll</a></button>
				</div>
				
				
			</sf:form>
		</div> 
</div>












