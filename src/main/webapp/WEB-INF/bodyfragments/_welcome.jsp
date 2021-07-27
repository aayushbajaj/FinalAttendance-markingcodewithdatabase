<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!-- Begin page content -->
<main>

	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active carousel-img" id="carousel-img1">
			
				<div class="carousel-caption text-end">
					<h1>Be calm and attend the session</h1>
<!-- 					<p>Some representative placeholder content for the third slide
						of this carousel.</p> -->
					<p>
						<a class="btn btn-lg btn-primary animate__animated animate__backInDown" href="#">Be Marked</a>
					</p>
				</div>
			</div>
			<div class="carousel-item carousel-img" id="carousel-img2">
		
				<div class="carousel-caption text-end">
					<h1>One more for good measure.</h1>
					<p>Some representative placeholder content for the third slide
						of this carousel.</p>
					<p>
						<a class="btn btn-lg btn-primary animate__animated animate__backInDown" href="#">Be Attentive</a>
					</p>
				</div>
			</div>
			<div class="carousel-item carousel-img" id="carousel-img3">

			
				<div class="carousel-caption text-end">
					<h1>One more for good measure.</h1>
					<p>Some representative placeholder content for the third slide
						of this carousel.</p>
					<p>
						<a class="btn btn-lg btn-primary animate__animated animate__backInDown" href="#">Be  Loyal</a>
					</p>
				</div>
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<!-- Marketing messaging and featurettes
  ================================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->

	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row roles">
			<div class="col-lg-4">
				
				<span style="color:#666464  ;margin-left:100px;"><i class="fas fa-user-tie fa-10x"></i></span>
				<h2>Super Admin</h2>
				<p>It provides access to admins. He/she can approve or reject
					admin request for accessing it.</p>
				<p>
					<a class="btn btn-secondary" href="<c:url value="/admin/login"/>">>Login &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<span style="color:#666464 ;margin-left:100px;"><i class="fas fa-user fa-10x"></i></span>
				<h2>Admin</h2>
				<p>Admin is responsible for managing session, trainers and
					attendance of the respective users</p>
				<p>
					<a class="btn btn-secondary" href="<c:url value="/admin/login"/>">Login &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<span style="color:#666464  ;margin-left:100px;"><i class="fas fa-user-graduate fa-10x"></i></span>
				<h2>User</h2>
				<p>User can attend session, mark attendance and give feedback to
					the trainers</p>
				<p>
					<a class="btn btn-secondary" href="<c:url value="/user/login"/>">Login &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->


		<!-- START THE FEATURETTES -->

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7 feature-content">
				<h2 class="featurette-heading" style="text-align:center;" >
					What is an Attendance Marking ? </h2>
				<p class="lead" style="text-align:center;" >Any solution that helps to marked the attendance of students in the Educational Institution is called an attendance marking interestingly, does not necessarily have to be a digital tool paper registers time clocks and Excel-based spreadsheets are some of the legacy models of attendance
this management.</p>
			</div>
			<div class="col-md-5">

				<div id="feature-img1" class="feature-img"></div>

			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7 order-md-2 feature-content">
				<h2 class="featurette-heading" style="text-align:center;">
					Why it is Important ? 
				</h2>
				<p class="lead" style="text-align:center; padding-left:50px;">When students improve their attendance rates, they improve their acadmic prospects and chances for graduating.</p>
			</div>
			<div class="col-md-5 order-md-1">

				<div id="feature-img2" class="feature-img"></div>

			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7 feature-content">
				<h2 class="featurette-heading " style="text-align:center;">
					Important Note ! 
				</h2>
				<p class="lead" style="text-align:center;">Punctuality is not about being on TIME. Its basically Respecting your Own Commitments.</p>
			</div>
			<div class="col-md-5">

				<div id="feature-img3" class="feature-img"></div>

			</div>
		</div>

		<hr class="featurette-divider">

		<!-- /END THE FEATURETTES -->

	</div>
	<!-- /.container -->


	<!-- FOOTER -->
	<footer class="footer" style="background-color: #fff;height:50px;">
  <div class="container">
      <div class="text-muted" style="margin-left:450px;">Copyright &copy Attendance Making. All Rights Reserved.</div>

  <div style=" margin:20px 0 0px 460px; padding-bottom:30px;" >
  <i class="fas fa-envelope fa-2x" style="margin-left:75px;color:#888;"></i>
  <i class="fab fa-facebook-square fa-2x" style="margin-left:45px;color:#888;"></i>
  <a href="#"><i class="fas fa-home fa-2x" style="margin-left:45px;color:#888;"></i></a>
  </div>
  </div>
</footer>

</main>