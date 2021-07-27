<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<style><%@include file="/WEB-INF/css/session.css"%></style>
<script type="text/javascript" src="/WEB-INF/css/style.js"></script>
 <div class=" main "> 
       <img class="registration-img" src="${pageContext.request.contextPath}/resources/images/kimberly-farmer-lUaaKCUANVI-unsplash.jpg">
       <div class="registration-form">
			 <b><%@ include file="businessMessage.jsp"%></b>
				<h3 style="margin:-80px 0 40px 300px;">User Registration</h3>
					<sf:form  method="post"
				action="${pageContext.request.contextPath}/user/us-signUp"
				modelAttribute="form" >
							<sf:hidden path="id"/>
				
				<div class="row">
				<s:bind path="firstName">
					<label 
						class="col-sm-5 col-form-label col-form-label-lg label2">First Name</label>
					<div class="col-sm-7">
						<sf:input type="text" class="form-control form-control-lg input2"
							 path="${status.expression}" autocomplete="off" placeholder="Enter first name" />
					</div>
					<font color="red" style="font-size: 15px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="row">
				<s:bind path="lastName">
					<label 
						class="col-sm-5 col-form-label col-form-label-lg label2">Last Name</label>
					<div class="col-sm-7">
						<sf:input type="text" class="form-control form-control-lg input2"
							 path="${status.expression}" autocomplete="off" placeholder="Enter Last Name"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="row">
				<s:bind path="email">
					<label 
						class="col-sm-5 col-form-label col-form-label-lg label2">Email Id</label>
					<div class="col-sm-7">
						<sf:input type="email" class="form-control form-control-lg input2"
							 path="${status.expression}" autocomplete="off" placeholder="Enter Email id"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="row">
				<s:bind path="password">
					<label 
						class="col-sm-5 col-form-label col-form-label-lg label2">Password</label>
					<div class="col-sm-7">
						<sf:input type="password" class="form-control form-control-lg input2"
							 path="${status.expression}" autocomplete="off" placeholder="Password"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="row">
				<s:bind path="confirmPassword">
					<label 
						class="col-sm-5 col-form-label col-form-label-lg label2">Confirm password</label>
					<div class="col-sm-7">
						<sf:input type="password" class="form-control form-control-lg input2"
							 path="${status.expression}" autocomplete="off" placeholder="Confirm password"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				
				<div class="reg-submit">
					<input type="submit" name="operation"
						class="btn" style="background-color:#548CA8; width:170px;border-radius:20px; font-weight:500; font-size:19px;" value="save" >
				</div> 
			</sf:form>
	</div>
    </div>