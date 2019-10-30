<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" >
<title>${cinema.getNomCinema()}</title>
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
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

	<!-- header-section-starts -->
	<div class="full">
			<div class="menu">
				<ul>
					<li><a class="active" href="${pageContext.request.contextPath}/Accueil"><i class="home"></i></a></li>
					<li><a href="${pageContext.request.contextPath}/Accueil?liste=true"><div class="cat"><i class="watching"></i><i class="watching1"></i></div></a></li>
					<li><a href="${pageContext.request.contextPath}/Erreur"><div class="bk"><i class="booking"></i><i class="booking1"></i></div></a></li>
					<li><a href="${pageContext.request.contextPath}/Contact"><div class="cnt"><i class="contact"></i><i class="contact1"></i></div></a></li>
				</ul>
			</div>
		<div class="main">
		<div class="header">
		
			<div class="top-header">
				<div class="logo">
					<a href="${pageContext.request.contextPath}/Accueil"></a>
					<p>${cinema.getNomCinema()}</p>
				
				</div>
				<ul class="nav navbar-nav navbar-right">
      				<c:if test="${session == null}">
      				<li><a href="#myModal2" data-toggle="modal"><span class="glyphicon glyphicon-user"></span> S'inscrire</a></li>
      				<li><a href="#myModal"  data-toggle="modal"><span class="glyphicon glyphicon-log-in"></span>Se connecter</a></li>
    				</c:if>
    				<c:if test="${session != null}"><li><a href="${pageContext.request.contextPath}/Connect?deconnect=true"><span class="glyphicon glyphicon-log-out"></span>Se deconnecter</a></li></c:if>
    			</ul>
				<div class="text-center">
	
</div>

<!-- Modal HTML -->
<c:if test="${session == null}">
<div id="myModal" class="modal fade">
	<div class="modal-dialog modal-login">
		<div class="modal-content">
			<div class="modal-header">				
				<h4 class="modal-title">Se connecter</h4>
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
				<form action="${pageContext.request.contextPath}/Connect" method="post">
					<div class="form-group">
						<i class="fa fa-user"></i>
						<input type="email" name="email" class="form-control" placeholder="Email" required="required">
					</div>
					<div class="form-group">
						<i class="fa fa-lock"></i>
						<input type="password" name="mdp" class="form-control" placeholder="Mot de passe" required="required">					
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary btn-block btn-lg" value="Connexion">
					</div>
				</form>				
				
			</div>
			<div class="modal-footer">
				<p><c:if test="${param.erreur == 'true'}">Mot de passe ou mail incorrect!</c:if></p>
			</div>
		</div>
	</div>
</div>
<!--FIN MODAL-->    

<!-- DEBUT MODAL INSCRIPTIONS-->
<div id="myModal2" class="modal fade">
	<div class="modal-dialog modal-login">
		<div class="modal-content">
			<div class="modal-header">				
				<h4 class="modal-title">S'inscrire</h4>
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
				<form action="${pageContext.request.contextPath}/Subscribe" method="post">
					<div class="form-group">
						<i class="fa fa-user"></i>
						<input type="email" name="email" class="form-control" placeholder="Adresse mail..." required="required">
					</div>
					<div class="form-group">
						<i class="fa fa-lock"></i>
						<input type="password" name="mdp" class="form-control" placeholder="Mot de passe..." required="required">					
					</div>
					<div class="form-group">
						<i class="fa fa-mail"></i>
						<input type="password" name="conf" class="form-control" placeholder="Confirmation..." required="required">
					</div>
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary btn-block btn-lg" value="Connexion">
					</div>
				</form>				
				
			</div>
			<div class="modal-footer">
				<p><c:if test="${param.erreur == 'true'}">Une erreur est survenue!</c:if></p>
				<p><c:if test="${param.mdp == 'true'}">Les deux mots de passes ne correspondent pas</c:if></p>
			</div>
		</div>
	</div>
</div>
<!--FIN MODAL INSCRIPTION-->
</c:if>
				<div class="clearfix"></div>
				
			</div>
			<div class="header-info">
				<h1>JOKER</h1>
				<p class="age"><a href="#">-16 ans</a></p>
				<p class="review">Note:	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;&nbsp;  8,5/10</p>
				<p class="review reviewgo">Genre	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp; Thriller</p>
				<p class="special">Le film, qui relate une histoire originale inedite sur grand ecran, se focalise sur la figure emblematique de l'ennemi jure de Batman. Il brosse le portrait d'Arthur Fleck, un homme sans concession meprise par la societe.  </p>
				<a class="video" href="#"><i class="video1"></i>Regarder trailer</a>
				<a class="book" href="#"><i class="book1"></i>Acheter place</a>
			</div>
		</div>
		<div class="review-slider">
			 <ul id="flexiselDemo1">
			<c:forEach items="${cinema.getFilms()}" var="f">
				<li><a href="${pageContext.request.contextPath}/Film?id=${f.getId()}"><img src="${f.getLien()}" alt="image ${f.getNomFilm()}"/></a></li>
			</c:forEach>
		</ul>
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
						visibleItems: 4
					}
				}
			});
			});
		</script>
		<script type="text/javascript" src="js/jquery.flexisel.js"></script>	
		</div>
		<div class="video">
			<iframe  src="https://www.youtube.com/embed/ZoIxOE74wBw" frameborder="0" allowfullscreen></iframe>
			
		</div>
		<div class="news">
			<div class="col-md-6 news-left-grid">
				<h3>Ne soyez plus jamais en retard,</h3>
				<h2>Achetez vos tickets directement sur le site</h2>
				<h4>Facile, simple & rapide.</h4>
				<a href="#"><i class="book"></i>Acheter place</a>
				<p>Jusqu'à<strong>-10%</strong>Avec la carte INF+</p>
			</div>
			<div class="col-md-6 news-right-grid">
				
				
				
				<a class="more" href="#"></a>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="more-reviews">
			 <ul id="flexiselDemo2">
			<li><img src="images/m1.jpg" alt=""/></li>
			<li><img src="images/m2.jpg" alt=""/></li>
			<li><img src="images/m3.jpg" alt=""/></li>
			<li><img src="images/m4.jpg" alt=""/></li>
		</ul>
			<script type="text/javascript">
		$(window).load(function() {
			
		  $("#flexiselDemo2").flexisel({
				visibleItems: 4,
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
		<script type="text/javascript" src="js/jquery.flexisel.js"></script>	
		</div>	
	<div class="footer">
		
		</div>
	</div>	
	</div>
	</div>
	<div class="clearfix"></div>
<%--<p>Voici la liste des films disponibles:</p>
<table>
	<th>Titre:</th>
	<th>Genre:</th>
	<th>Nom du Réalisateur:</th>
	<th>Résumé:</th>
	<th>Année de Sortie:</th>
	<th>Actif:</th>
	<th>Salle:</th>
	<c:forEach var="message" items="${cinema.getFilms()}">
		<tr>
		<td class="mid"><a href="${pageContext.request.contextPath}/Film?id=${message.getId()}">${message.getNomFilm()}</a></td>
		<td class="mid">${message.getGenre()}</td>
		<td class="mid">${message.getNomRealisateur()}</td>
		<td id="resume">${message.getResume()}</td>
		<td class="mid">${message.getAnnee()}</td>
		<td class="mid"><c:if test="${message.isActif() == 1}">Oui</c:if><c:if test="${message.isActif() == 0}">Non</c:if></td>
		<td class="mid"><c:out value="${message.getSalle()}"/></td>
		<c:if test="${session == 'Adminxyzabc12345'}"><td class="mid"><a href="${pageContext.request.contextPath}/Edit?i=${message.getId()}&Salle=${cinema.getNbSalle()}">Modifier</a></td></c:if>
		</tr>
	</c:forEach>
</table>
<c:if test="${session == 'Adminxyzabc12345'}"><a href="${pageContext.request.contextPath}/Edit?add=True&Salle=${cinema.getNbSalle()}">Ajouter un Film</a></c:if>
<p><c:if test="${param.change == 'True'}"><c:out value="La modification a été effectuer"/></c:if></p>--%>	
</body>
</html>