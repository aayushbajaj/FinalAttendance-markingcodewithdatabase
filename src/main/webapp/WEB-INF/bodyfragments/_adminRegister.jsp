<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<style><%@include file="/WEB-INF/css/session.css"%></style>
 <div class=" main "> 
       <img class="registration-img-admin" src="${pageContext.request.contextPath}/resources/images/patrick-robert-doyle-yUvZYHV2Zbw-unsplash.jpg">
       <div class="registration-form-admin">
			<b><%@ include file="businessMessage.jsp"%></b>
			
					<h3 style="margin-left:350px;">Admin Registration</h3>
					<sf:form method="post"
				action="${pageContext.request.contextPath}/admin/ad-signUp"
				modelAttribute="form">		
				
				
				
				<  <div class="row">
				<s:bind path="firstName">
					<label 
						class="col-sm-5 col-form-label col-form-label-lg label2">First Name</label>
					<div class="col-sm-7">
						<sf:input type="text" class="form-control form-control-lg input2"
							 path="${status.expression}" autocomplete="off" placeholder="Enter First name"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div> 
				
				<div class="row">
				<s:bind path="lastName">
					<label 
						class="col-sm-5 col-form-label col-form-label-lg label2">Last Name</label>
					<div class="col-sm-7">
						<sf:input type="text" class="form-control form-control-lg input2"
							 path="${status.expression}" autocomplete="off" placeholder="Enter Last name"/>
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
							 path="${status.expression}" autocomplete="off" placeholder="Enter emailId"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="row">
				<s:bind path="age">
					<label 
						class="col-sm-5 col-form-label col-form-label-lg label2">Age</label>
					<div class="col-sm-7">
						<sf:input type="number" class="form-control form-control-lg input2"
							 path="${status.expression}" autocomplete="off" placeholder="Enter Age"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="row">
				<s:bind path="contactNo">
					<label 
						class="col-sm-5 col-form-label col-form-label-lg label2">Phone Number</label>
					<div class="col-sm-7">
						<sf:input type="text" class="form-control form-control-lg input2"
							 path="${status.expression}" autocomplete="off" placeholder="Enter Phone Number"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				
				<div class="row">
				<s:bind path="gender">
					<label class="col-sm-5 col-form-label col-form-label-lg label2">Gender</label>
					<div class="col-sm-7">
						<sf:select class="form-control form-control-lg input2" path="${status.expression}" >
						<sf:option value="" label="Select" />
						<sf:options items="${gender}" />
						</sf:select>	
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
							 path="${status.expression}" autocomplete="off" placeholder="Enter password"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				<div class="row">
				<s:bind path="confirmPassword">
					<label
						class="col-sm-5 col-form-label col-form-label-lg label2">Confirm Password</label>
					<div class="col-sm-7">
						<sf:input type="password" class="form-control form-control-lg input2"
							 path="${status.expression}" placeholder="Confirm password"/>
					</div>
					<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
					</s:bind>
				</div>
				
				
				<div class="reg-submit">
					<input type="submit" name="operation"
						class="btn" style="background-color:#548CA8; width:170px;border-radius:20px; font-weight:500; font-size:19px;" value="save">
				</div> 
			</sf:form>
	</div>
    </div>
    
   