<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta charset="utf-8">
	<title>${movie.getNomFilm()}</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- Custom Theme files -->
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- Custom Theme files -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- Custom Theme files -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<script type="application/x-javascript">
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!--webfont-->
	<link
		href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
		rel='stylesheet' type='text/css'>
<title>${movie.getNomFilm()}</title>
</head>
<body>
<div class="full">
	<div class="menu">
				<ul>
					<li><a href="${pageContext.request.contextPath}/Accueil"><i class="home"></i></a></li>
					<li><a href="${pageContext.request.contextPath}/Accueil?liste=true"><div class="cat"><i class="watching"></i><i class="watching1"></i></div></a></li>
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
			<h3 class="head"><a href="#" class="btn btn-warning btn-lg " role="button" aria-pressed="true">${movie.getNomFilm()}</a></h3>
			<div class="col-md-9 reviews-grids">
				<div class="review">
					<div class="movie-pic">
						<img src="${movie.getLien()}">
					</div>
					<div class="review-info">
						<p class="info">REALISATEUR: &nbsp;&nbsp;&nbsp;&nbsp;${movie.getNomRealisateur()}</p>
						<p class="info">GENRE:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${movie.getGenre()}</p>
						<p class="info">ANNEE:&nbsp;&nbsp;&nbsp; &nbsp; ${movie.getAnnee()}</p>
						<c:if test="${movie.isActif() == 1 }"><button type="button" class="btn btn-success">Actif</button></c:if><c:if test="${movie.isActif() == 0 }"><button type="button" class="btn btn-danger">Non Disponible</button></c:if> </p>
						<br/>
						<p>CAST:&nbsp;&nbsp;&nbsp; &nbsp;<c:forEach items="${Acteurs}" var="a">${a.getNom()} ${a.getPrenom()},&nbsp; </c:forEach></p>
						<br/>
						<p>RESUME:<br/>${movie.getResume()}</p><br/>					
					<div class="wt text-center">
					<c:if test="${session == 'Adminxyzabc12345' }"><a href="${pageContext.request.contextPath}/EditFilm?id=${movie.getId()}">Modifier</a></c:if>	
					</div>
					
						
					</div>

					
					</div>
					<div class="clearfix"></div>
				<c:if test="${session == 'Adminxyzabc12345' }">
					<form class="needs-validation" novalidate method="post" action="${pageContext.request.contextPath}/Film?idF=${movie.getId()}">
	  						<select name="selectAct" class="mdb-select validate md-form" searchable="Search here..">
								<option value="" disabled selected>Sélectionner un acteur</option>
								<c:forEach items="${AllActeurs}" var="a">
									<option value="${a.getId()}">${a.getNom()} ${a.getPrenom()}</option>
								</c:forEach>
	  						</select>
	  						<button class="btn btn-warning btn-sm">Submit</button>
						</form>
				</c:if>
			</div>
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