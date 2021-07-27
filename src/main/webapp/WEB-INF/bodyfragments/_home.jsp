<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<style><%@include file="/WEB-INF/css/session.css"%></style>
<div >
       <img class="notification-img" src="${pageContext.request.contextPath}/resources/images/paolo-chiabrando-qVgOxgXfPsQ-unsplash.jpg">
</div>
<div class="notification-card">
<div class='post-it'>
	<h1>Notification</h1>
  	<div class="card-body">
			<c:if test="${success!=null}">
				<div class="alert alert-warning" role="alert">${success}</div>
			</c:if>
			<c:if test="${error!=null}">
				<div class="alert alert-warning" role="alert">${error}</div>
			</c:if>
			
			<c:if test="${warning!=null}">
				<div class="alert alert-warning" role="alert">${warning}</div>
			</c:if>
			
		</div>
      
</div>
	
	</div>