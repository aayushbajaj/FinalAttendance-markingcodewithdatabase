<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<nav class="navbar navbar-expand-lg fixed-top navbar-dark "
	style="background-color: #476072; height: 80px;"
	aria-label="Main navigation">
	<div class="container-fluid">
		<a class="navbar-brand" href="<c:url value="/welcome"/>">Attendance
			Marking</a>
		<button class="navbar-toggler p-0 border-0" type="button"
			data-bs-toggle="offcanvas" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="navbar-collapse offcanvas-collapse"
			id="navbarsExampleDefault">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">


				<c:if test="${sessionScope.admin != null }">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/welcome"/>">Home</a></li>

					<c:if test="${sessionScope.admin.roleId == 1 }">
						<li class="nav-item"><a class="nav-link"
							href="<c:url value="/ctl/admin/search"/>">Admin Report</a></li>

						<li class="nav-item"><a class="nav-link"
							href="<c:url value="/admin/changepassword"/>">Change Password</a></li>

					</c:if>

					<c:if test="${sessionScope.admin.roleId == 2 }">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown01"
							data-bs-toggle="dropdown" aria-expanded="false">Skill Set</a>
							<ul class="dropdown-menu" aria-labelledby="dropdown01">
								<li><a class="dropdown-item"
									href="<c:url value="/ctl/skill"/>">Add Skill Set</a></li>
								<li><a class="dropdown-item"
									href="<c:url value="/ctl/skill/search"/>">SkillSet Report</a></li>

							</ul></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown01"
							data-bs-toggle="dropdown" aria-expanded="false">Session</a>
							<ul class="dropdown-menu" aria-labelledby="dropdown01">
								<li><a class="dropdown-item"
									href="<c:url value="/ctl/session"/>">Add Session</a></li>
								<li><a class="dropdown-item"
									href="<c:url value="/ctl/session/search"/>">Session Update</a></li>

							</ul></li>

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown01"
							data-bs-toggle="dropdown" aria-expanded="false">Trainer</a>
							<ul class="dropdown-menu" aria-labelledby="dropdown01">
								<li><a class="dropdown-item"
									href="<c:url value="/ctl/trainer"/>">Add Trainer</a></li>
								<li><a class="dropdown-item"
									href="<c:url value="/ctl/trainer/search"/>">Trainer Update</a></li>

							</ul></li>


							<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown01"
							data-bs-toggle="dropdown" aria-expanded="false">Mark attendance</a>
							<ul class="dropdown-menu" aria-labelledby="dropdown01">
								<li><a class="dropdown-item"
									href="<c:url value="/ctl/enroll/search"/>">Enroll List</a></li>
								<li><a class="dropdown-item"
									href="<c:url value="/ctl/attendance"/>">Attendance Report</a></li>

							</ul></li>
							
							<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown01"
							data-bs-toggle="dropdown" aria-expanded="false">Report List</a>
							<ul class="dropdown-menu" aria-labelledby="dropdown01">
								<li><a class="dropdown-item"
									href="<c:url value="/ctl/session/report"/>">Report</a></li>
								<li><a class="dropdown-item"
									href="<c:url value="/ctl/userFeedBack/session/search"/>">Feedback Report</a></li>

							</ul></li>
							
							
						
						<li class="nav-item"><a class="nav-link"
							href="<c:url value="/admin/changepassword"/>">Change Password</a></li>

					</c:if>

				</c:if>

				<c:if test="${sessionScope.user != null }">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/home"/>">Home</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/ctl/session/user/search"/>">Sessions</a></li>

					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/ctl/attendance/user/attend/search"/>">Attend
							Session Report</a></li>

					<%-- <li class="nav-item"><a class="nav-link"
href="<c:url value="/ctl/userFeedBack"/>">FeedBack</a></li> --%>

					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/user/changepassword"/>">Change Password</a></li>

				</c:if>



				<c:if
					test="${sessionScope.user == null && sessionScope.admin ==null }">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="dropdown01"
						data-bs-toggle="dropdown" aria-expanded="false">Registration</a>
						<ul class="dropdown-menu" aria-labelledby="dropdown01">
							<li><a class="dropdown-item"
								href="<c:url value="/user/us-signUp"/>">User Registration</a></li>
							<li><a class="dropdown-item"
								href="<c:url value="/admin/ad-signUp"/>">Admin Registration</a></li>

						</ul></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="dropdown01"
						data-bs-toggle="dropdown" aria-expanded="false">Login</a>
						<ul class="dropdown-menu" aria-labelledby="dropdown01">
							<li><a class="dropdown-item"
								href="<c:url value="/user/login"/>">User Login</a></li>
							<li><a class="dropdown-item"
								href="<c:url value="/admin/login"/>">Admin Login</a></li>

						</ul></li>

				</c:if>

				<c:if test="${sessionScope.user != null}">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/user/login"/>">Logout</a></li>
				</c:if>

				<c:if test="${sessionScope.admin != null}">
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/admin/login"/>">Logout</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>
<div style="margin-top: 57px"></div>