<!DOCTYPE html>
<html>
<head>
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
<title>Liste des films</title>
</head>
<body>
<div class="full">
			<div class="menu">
				<ul>
					<li><a href="${pageContext.request.contextPath}/Accueil"><i class="home"></i></a></li>
					<li><a class="active" href="${pageContext.request.contextPath}/Accueil?liste=true"><div class="cat"><i class="watching"></i><i class="watching1"></i></div></a></li>
					<li><a href="${pageContext.request.contextPath}/Erreur"><div class="bk"><i class="booking"></i><i class="booking1"></i></div></a></li>
					<li><a href="${pageContext.request.contextPath}/Contact"><div class="cnt"><i class="contact"></i><i class="contact1"></i></div></a></li>
				</ul>
			</div>
	<div class="main">
		<div class="header">
		<div class="top-header">
				<div class="logo">
					
				</div>
			
			<div class="clearfix"></div>
		
		<div class="reviews-section">
			<h3 class="head"><a href="#" class="btn btn-warning btn-lg " role="button" aria-pressed="true">Films à l'affiche</a></h3>
			<div class="col-md-9 reviews-grids">
			<c:forEach items="${cinema.getSalles()}" var="f">
				<div class="review">
					<div class="movie-pic">
						<a href="${pageContext.request.contextPath}/Film?id=${f.getFilm().getId()}"><img src="${f.getFilm().getLien()}" alt="" /></a>
					</div>
					<div class="review-info">
						<p class="info">REALISATEUR: &nbsp;&nbsp;&nbsp;&nbsp;${f.getFilm().getNomRealisateur()}</p>
						<p class="info">GENRE:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${f.getFilm().getGenre()}</p>
						<p class="info">ANNEE:&nbsp;&nbsp;&nbsp; &nbsp; ${f.getFilm().getAnnee()}</p>
						<c:if test="${f.getFilm().isActif() == 1 }"><button type="button" class="btn btn-success">Actif</button></c:if><c:if test="${f.getFilm().isActif() == 0 }"><button type="button" class="btn btn-danger">Non Disponible</button></c:if> </p>
						<p class="info">SALLE:&nbsp;&nbsp;&nbsp; &nbsp;${f.getNom()}</p>
						<p class="info">PLACES:&nbsp;&nbsp;&nbsp; &nbsp;${f.getNbPlaces()}</p>
					
					<div class="wt text-center">
						<c:if test="${session == 'Adminxyzabc12345' }"><a href="${pageContext.request.contextPath}/Edit?i=${f.getId()}">Modifier Salle</a></c:if>
					</div>
					
					<div class="wt text-center">
						<c:if test="${session == 'Adminxyzabc12345' }"><a href="${pageContext.request.contextPath}/RemoveSalle?id=${f.getId()}">Supprimer Salle</a></c:if>
					</div>	
					</div>

					
					</div>
					<div class="clearfix"></div>
			</c:forEach>
			</div>	
			<c:if test="${session == 'Adminxyzabc12345' }"><a href="${pageContext.request.contextPath}/AddSalle" class="btn btn-warning btn-sm " role="button" aria-pressed="true">Ajouter une salle</a><br/><br/></c:if>
			<c:if test="${session == 'Adminxyzabc12345' }"><a href="${pageContext.request.contextPath}/AddFilm" class="btn btn-warning btn-sm " role="button" aria-pressed="true">Ajouter un film</a><br/><br/></c:if>
			<c:if test="${session == 'Adminxyzabc12345' }"><a href="${pageContext.request.contextPath}/AddActor" class="btn btn-warning btn-sm " role="button" aria-pressed="true">Ajouter un acteur</a></c:if>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<div class="review-slider">
	<ul id="flexiselDemo1">
		<c:forEach items="${cinema.getFilms()}" var="f">
			<li><a href="${pageContext.request.contextPath}/Film?id=${f.getId()}"><img src="${f.getLien()}" alt="image ${f.getNomFilm()}"/></a></li>
		</c:forEach>
	</ul>
</div>
<script type="text/javascript">
	$(window).load(function() {
		 $("#flexiselDemo1").flexisel({
			visibleItems: 6,
			animationSpeed: 1000,
			autoPlay: true,
			autoPlaySpeed: 3000,    		
			pauseOnHover: false,
			enableResponsiveBreakpoints: true,
			responsiveBreakpoints: { 
				portrait: { 
					changePoint:480,
					visibleItems: 2
				}, 
				landscape: { 
					changePoint:640,
					visibleItems: 3
				},
				tablet: { 
					changePoint:768,
					visibleItems: 3
				}
			}
		});
	});
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.flexisel.js"></script>			
<div class="clearfix"></div>
</body>
</html>