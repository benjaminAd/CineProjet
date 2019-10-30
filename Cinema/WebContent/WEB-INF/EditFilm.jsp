<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
		rel='stylesheet' type='text/css'/>



<style type="text/css">
body {
	color: #fff;
	background: grey;
	font-family: 'Roboto', sans-serif;
}
   .form-control {
	min-height: 41px;
	box-shadow: none;
	border-color: #ddd;
}
.form-control, .btn {        
       border-radius: 3px;
   }
.signup-form {
	width: 390px;
	margin: 0 auto;
	padding: 30px 0;
}
.signup-form form {
	color: #999;
	border-radius: 3px;
   	margin-bottom: 15px;
       background: #fff;
       box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
       padding: 30px;
   }
.signup-form h2 {
	color: #333;
	font-weight: bold;
       margin-top: 0;
   }
   .signup-form hr {
       margin: 0 -30px 20px;
   }
.signup-form .form-group {
	margin-bottom: 20px;
}
   .signup-form label {
	font-weight: normal;
	font-size: 13px;
}
.signup-form input[type="checkbox"] {
	margin-top: 2px;
}    
   .signup-form .btn {        
       font-size: 16px;
       font-weight: bold;
	background-color:#FF7F50;
	border: none;
	min-width: 140px;
	opacity:0.5;
   }
.signup-form .btn:hover, .signup-form .btn:active {
	background: #FF7F50;
	opacity:1;
	outline: none !important;
}
.signup-form a {
	color: #fff;
       text-decoration: underline;
}
   .signup-form a:hover {
       text-decoration: none;
   }
   .signup-form form a {
	color: #3598dc;
       text-decoration: none;
}
   .signup-form form a:hover {
	text-decoration: underline;
}
</style>
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
	
				<div class="logo">
					
				</div>
			
			<div class="clearfix"></div>
		
		<div class="reviews-section">
			
			<div class="col-md-9 reviews-grids">
				<div class="review">
					<div class="d-flex justify-content-center">
						<div class="signup-form">
    <form method="POST" action="${pageContext.request.contextPath}/EditFilm?id=${id}">
		<h2>Modifier un Film</h2>
		
		<hr>
        <div class="form-group">
			<label for="titre">Titre :</label>
        	<input type="text" class="form-control" name="titre" required="required" id="titre" value="${film.getNomFilm()}"/>
        </div>
        <div class="form-group">
			<label for="genre">Genre :</label>
        	<input type="text" class="form-control" name="genre" required="required" id="titre" value="${film.getGenre()}"/>
        </div>
        <div class="form-group">
			<label for="rea">Réalisateur :</label>
        	<input type="text" class="form-control" name="rea" required="required" id="rea" value="${film.getNomRealisateur()}"/>
        </div>
        <div class="form-group">
			<label for="annee">Année de sortie :</label>
        	<input type="number" class="form-control" name="annee" required="required" id="annee" value="${film.getAnnee()}"/>
        </div>
        <div class="form-group">
			<label for="lien">Lien de l'image</label>
        	<input type="text" class="form-control" name="lien" required="required" id="lien" value="${film.getLien()}"/>
        </div>
        <div class="form-group">
			<label for="resume">Résumé:</label>
			<textarea name="resume" id="resume" class="form-control" required="required" >${film.getResume()}</textarea>
        </div>
		<div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg">MODIFIER</button>
        </div>
		<c:if test="${param.erreur == 'erreur'}"><p>Une erreur est survenue</p></c:if>
    </form>
</div>
			
					</div>
					<div class="review-info">
						
					
					<div class="wt text-center">
					
					</div>
					
						
					</div>

					
					</div>
					<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			
		</div>
	</div>
</div>		
<div class="clearfix"></div>
</body>
</html>