<!DOCTYPE html>
<html>
<head>
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
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'/>



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
<title>Ajouter un acteur</title>
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
						    <form method="post" action="${pageContext.request.contextPath}/AddActor">
								<h2>Ajouter un Acteur</h2>
								
								<hr>
						        <div class="form-group">
									<label for="nom">Nom :</label>
						        	<input type="text" class="form-control" name="nom" required="required" id="nom"/>
						        </div>
						        <div class="form-group">
									<label for="prenom">Prénom :</label>
						        	<input type="text" class="form-control" name="prenom" required="required" id="prenom"/>
						        </div>
						        <div class="form-group">
									<label for="nat">Nationalité :</label>
						        	<input type="text" class="form-control" name="nat" required="required" id="nat"/>
						        </div>
						        <div class="form-group">
									<label for="age">Âge :</label>
						        	<input type="number" class="form-control" name="age" required="required" id="age"/>
						        </div>
						        <div class="form-group">
									<label for="sexe">Sexe :</label>
						        	<input type="text" class="form-control" name="sexe" required="required" id="sexe" />
						        </div>
								<div class="form-group">
									<select class="custom-select custom-select-lg mb-3" searchable="Search here.." name="films" size="${films.size()}" multiple>
										<c:forEach items="${films}" var="f">
									  	<option value="${f.getId()}">${f.getNomFilm()}</option>
									  </c:forEach>
						  			</select>
						        </div>        
								<div class="form-group">
						            <button type="submit" class="btn btn-primary btn-lg">AJOUTER</button>
						        </div>
						        <p>Appuyez sur Ctrl(Windows) ou Cmd(Mac Os) pour sélectionner plusieurs films</p>
						    	<p><c:if test="${param.erreur == 'true'}">Une erreur est survenue!</c:if></p>
								<p><c:if test="${param.longueur == 'true'}">Veuillez sélectionner des films</c:if></p>
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