<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<style><%@include file="/WEB-INF/css/session.css"%></style>
 <div class=" main "> 
        <div class="col-md-7 content animate__animated animate__backInDown">
            <div class="col-sm-6 img-main"><img class="login-img" src="${pageContext.request.contextPath}/resources/images/windows-J_s7hzjV9i0-unsplash.jpg"></div>
            <div class="col-sm-12 form-box">
            
                
          
                <div class="form-div ">
                    <sf:form method="post" action="${pageContext.request.contextPath}/user/login"
				modelAttribute="form" id="user" class="col-sm-7 input-group1 animate__animated animate__fadeInRight">
				<b><%@ include file="businessMessage.jsp"%></b>
	
				
					<h3 style="margin-top:-20px;">User Login</h3>
					
					<s:bind path="emailId">
								<sf:input path="${status.expression}" autocomplete="off" placeholder="Enter Employee Id"
										class="input-field" />
							<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
			
							</s:bind>
							<s:bind path="password">
								<sf:input type="password" path="${status.expression}" placeholder="Enter Password" class="input-field" />
									<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
				
							</s:bind>
                     <input type="submit" name="operation" class=" submit-btn1" value="Submit">
                        <span class="class="register-span">Don't have Account?</span>
                        <span class="class="register-span"><a href="<c:url value="/user/us-signUp"/>">Register Here</a></span>
                    </sf:form>

        </div>    
        </div> 
    </div>