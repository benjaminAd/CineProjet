<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${cinema.getNomCinema()}</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Cinema Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
</head>
<body>
	<!-- header-section-starts -->
	<div class="full">
			<div class="menu">
				<ul>
					<li><a href="${pageContext.request.contextPath}/Accueil"><div class="hm"><i class="home1"></i><i class="home2"></i></div></a></li>
					<li><a href="${pageContext.request.contextPath}/Accueil?liste=true"><div class="cat"><i class="watching"></i><i class="watching1"></i></div></a></li>
					<li><a href="${pageContext.request.contextPath}/Erreur"><div class="bk"><i class="booking"></i><i class="booking1"></i></div></a></li>
					<li><a class="active" href="${pageContext.request.contextPath}/Contact"><div class="cnt"><i class="contact"></i><i class="contact1"></i></div></a></li>
				</ul>
			</div>
		<div class="main">
		<div class="contact-content">
			<div class="top-header span_top">
				<div class="logo">
					<p>${cinema.getNomCinema()}</p>
				</div>
				<div class="search v-search">
					<form>
						<input type="text" value="Search.." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search..';}"/>
						<input type="submit" value="">
					</form>
				</div>
				<div class="clearfix"></div>
			</div>
			<!---contact-->
<div class="main-contact">
		 <h3 class="head">CONTACT</h3>
		 <p>WE'RE ALWAYS HERE TO HELP YOU</p>
		 <div class="contact-form">
			 <form>
				 <div class="col-md-6 contact-left">
					  <input type="text" placeholder="Name" required/>
					  <input type="text" placeholder="E-mail" required/>
					  <input type="text" placeholder="Phone" required/>
				  </div>
				  <div class="col-md-6 contact-right">
					 <textarea placeholder="Message"></textarea>
					 <input type="submit" value="SEND"/>
				 </div>
				 <div class="clearfix"></div>
			 </form>
	     </div>
		 <div class="contact_info">
			 <h3>Find Us Here</h3>
			 <div class="map">
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3727.1713410128364!2d55.497796614357014!3d-20.905425124776137!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x2178802f9f62e5cb%3A0xd5f8b7e2d93ebc39!2sParc%20Technologique%20Universitaire%2C%202%20Rue%20Joseph%20Wetzell%2C%20Sainte-Clotilde%2097490%2C%20R%C3%A9union!5e0!3m2!1sen!2s!4v1571312023850!5m2!1sen!2s" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
			</div>
	 </div>
</div>
	<div class="footer">
		<h6>Disclaimer : </h6>
		<p class="claim">This is a freebies and not an official website, I have no intention of disclose any movie, brand, news.My goal here is to train or excercise my skill and share this freebies.</p>
		<a href="example@mail.com">example@mail.com</a>
		<div class="copyright">
			<p> Template by  <a href="http://w3layouts.com">  W3layouts</a></p>
		</div>
	</div>	
	</div>
	<div class="clearfix"></div>
	</div>
</body>
</html>