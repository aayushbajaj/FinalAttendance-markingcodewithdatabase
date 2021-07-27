<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
crossorigin="anonymous">
<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
crossorigin="anonymous"></script>
<link rel="canonical"
href="https://getbootstrap.com/docs/5.0/examples/offcanvas/">
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

<!-- <link rel="stylesheet"
href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- <script         src="webjars/bootstrap-datepicker/2.0.4/js/bootstrap-datepicker.js"></script> -->

<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
<link rel="canonical"
href="https://getbootstrap.com/docs/5.0/examples/carousel/">



<!-- Bootstrap core CSS -->

<!-- Favicons -->
<link rel="apple-touch-icon"
href="/docs/5.0/assets/img/favicons/apple-touch-icon.png"
sizes="180x180">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-32x32.png"
sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-16x16.png"
sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.0/assets/img/favicons/manifest.json">
<link rel="mask-icon"
href="/docs/5.0/assets/img/favicons/safari-pinned-tab.svg"
color="#7952b3">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">


<style>
.bd-placeholder-img {
font-size: 1.125rem;
text-anchor: middle;
-webkit-user-select: none;
-moz-user-select: none;
user-select: none;
}
.carousel-img{
background-size:cover;
   
    background-attachment:fixed;
width:100%;
height:95vh;
object-fit:cover;

}
#carousel-img1{background-image:url(resources/images/samantha-borges-gXsJ9Ywb5as-unsplash.jpg);
 background-position:center;}
#carousel-img2{background-image:url(resources/images/finalpic.jfif);
 background-position:focus;}
#carousel-img3{background-image:url(resources/images/nick-morrison-FHnnjk1Yj7Y-unsplash.jpg);
 background-position:center;}
.roles{
padding:50px 0px 0px 0px;
margin-left:15px;nick-morrison-FHnnjk1Yj7Y-unsplash.jpg
}
.roles h2{
text-align:center;
}
.roles p{
text-align:center;
}
.circle{
font-size:100px;
/* width:140px;
height:140px; */
/* border-radius:50%; */
/* background-size:cover;
    background-position:center; */
    margin-left:110px;
 
}
#crl1{
background-image:url(resources/images/teacher-11.png);
}
#crl2{
background-image:url(resources/images/1266192-200.png);
}
#crl3{
background-image:url(resources/images/student-icon-16.jpg);
}

@media ( min-width : 768px) {
.bd-placeholder-img-lg {
font-size: 3.5rem;
}
}

.feature-img{
width:500px;
height:500px;
background-size:cover;
    background-position:center;
}
#feature-img1{background-image:url(resources/images/simon-abrams-k_T9Zj3SE8k-unsplash.jpg);}
#feature-img2{background-image:url(resources/images/chris-montgomery-smgTvepind4-unsplash.jpg);}
#feature-img3{background-image:url(resources/images/alex-kotliarskyi-ourQHRTE2IM-unsplash.jpg);}

.feature-content{
padding-top:13%;
/* margin-left:20px; */
}

.animate__animated.animate__fadeInLeft {
  animate-duration: 2s;
}

.animate__animated.animate__fadeInRight {
  animate-duration: 2s;
}
.animate__animated.animate__backInDown{
  animate-duration: 2s;
}

/*-----------------------------------------------------------------------------------------*/
.footer-distributed{
	background: #fff;
	box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.12);
	box-sizing: border-box;
	width: 100%;
	text-align: left;
	font: bold 16px sans-serif;
	padding: 55px 50px;
	margin-top:90px;
}

.footer-distributed .footer-left,
.footer-distributed .footer-center,
.footer-distributed .footer-right{
	display: inline-block;
	vertical-align: top;
}

/* Footer left */

.footer-distributed .footer-left{
	width: 40%;
}

/* The company logo */

.footer-distributed h3{
	color:  #ffffff;
	font: normal 36px 'Open Sans', cursive;
	margin: 0;
}

.footer-distributed h3 span{
	color:  lightseagreen;
}

/* Footer links */

.footer-distributed .footer-links{
	color:  #ffffff;
	margin: 20px 0 12px;
	padding: 0;
}

.footer-distributed .footer-links a{
	display:inline-block;
	line-height: 1.8;
  font-weight:400;
	text-decoration: none;
	color:  inherit;
}

.footer-distributed .footer-company-name{
	color:  #222;
	font-size: 14px;
	font-weight: normal;
	margin: 0;
}

/* Footer Center */

.footer-distributed .footer-center{
	width: 35%;
}

.footer-distributed .footer-center i{
	background-color:  #33383b;
	color: #ffffff;
	font-size: 25px;
	width: 38px;
	height: 38px;
	border-radius: 50%;
	text-align: center;
	line-height: 42px;
	margin: 10px 15px;
	vertical-align: middle;
}

.footer-distributed .footer-center i.fa-envelope{
	font-size: 17px;
	line-height: 38px;
}

.footer-distributed .footer-center p{
	display: inline-block;
	color: #ffffff;
  font-weight:400;
	vertical-align: middle;
	margin:0;
}

.footer-distributed .footer-center p span{
	display:block;
	font-weight: normal;
	font-size:14px;
	line-height:2;
}

.footer-distributed .footer-center p a{
	color:  lightseagreen;
	text-decoration: none;;
}

.footer-distributed .footer-links a:before {
  content: "|";
  font-weight:300;
  font-size: 20px;
  left: 0;
  color: #fff;
  display: inline-block;
  padding-right: 5px;
}

.footer-distributed .footer-links .link-1:before {
  content: none;
}

/* Footer Right */

.footer-distributed .footer-right{
	width: 20%;
}

.footer-distributed .footer-company-about{
	line-height: 20px;
	color:  #92999f;
	font-size: 13px;
	font-weight: normal;
	margin: 0;
}

.footer-distributed .footer-company-about span{
	display: block;
	color:  #ffffff;
	font-size: 14px;
	font-weight: bold;
	margin-bottom: 20px;
}

.footer-distributed .footer-icons{
	margin-top: 25px;
}

.footer-distributed .footer-icons a{
	display: inline-block;
	width: 35px;
	height: 35px;
	cursor: pointer;
	background-color:  #33383b;
	border-radius: 2px;

	font-size: 20px;
	color: #ffffff;
	text-align: center;
	line-height: 35px;

	margin-right: 3px;
	margin-bottom: 5px;
}

/* If you don't want the footer to be responsive, remove these media queries */

@media (max-width: 880px) {

	.footer-distributed{
		font: bold 14px sans-serif;
	}

	.footer-distributed .footer-left,
	.footer-distributed .footer-center,
	.footer-distributed .footer-right{
		display: block;
		width: 100%;
		margin-bottom: 40px;
		text-align: center;
	}

	.footer-distributed .footer-center i{
		margin-left: 0;
	}

}
</style>

<script>
$(function() {
$("#datepicker").datepicker({
dateFormat : 'mm/dd/yy',
changeMonth : true,
changeYear : true,
defaultDate : '01/01/1990'
});
});
</script>

<script language="javascript">
$(function() {
$("#selectall").click(function() {
$('.case').attr('checked', this.checked);
});
$(".case").click(function() {

if ($(".case").length == $(".case:checked").length) {
$("#selectall").attr("checked", "checked");
} else {
$("#selectall").removeAttr("checked");
}

});
});

$(document).ready(function() {
$("#formButton").click(function() {
$("#form1").toggle();
});
});
</script>




</head>
<body class="hold-transition sidebar-mini layout-fixed">

<div class="wrapper">
<tiles:insertAttribute name="header" />

<tiles:insertAttribute name="body" />

<tiles:insertAttribute name="footer" />

</div>
</body>
</html>

