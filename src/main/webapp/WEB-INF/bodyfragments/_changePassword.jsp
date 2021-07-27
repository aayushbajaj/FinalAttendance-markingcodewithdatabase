<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style><%@include file="/WEB-INF/css/session.css"%></style>

<div class="container forget-password">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="text-center">
                                <img class="img-changePassword" src="${pageContext.request.contextPath}/resources/images/car-key.png"" alt="car-key" border="0">
                                <h4 class="text-center">Change Password?</h4>
                                <b><%@ include file="businessMessage.jsp"%></b>
                                <p>You can reset your password here.</p>
				<sf:form class="form" method="post"
					action="${pageContext.request.contextPath}/user/changepassword"
					modelAttribute="form">
					<sf:hidden path="id"/>

					<div class="form-group">
					<s:bind path="oldPassword">
						<div class="input-group">
							<sf:input path="${status.expression}"
								placeholder="Old Password" class="form-control" type="password"/>
								<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
							</s:bind>
						</div>
					</div>
					<div class="form-group">
					<s:bind path="newPassword">
						<div class="input-group">
							<sf:input path="${status.expression}"
								placeholder="New Password" class="form-control" type="password"/>
								<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
							</s:bind>
						</div>
					<div class="form-group">
					<s:bind path="confirmPassword">
						<div class="input-group">
							<sf:input path="${status.expression}"
								placeholder="Confirm Password" class="form-control" type="password"/>
								<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
							</s:bind>
						</div>
					<div class="form-group">
						<input name="btnForget"
							class="btn btn-lg btn-primary btn-block btnForget"
							value="Reset Password" type="submit">
					</div>

				</sf:form>
			</div>
                        </div>
        </div>