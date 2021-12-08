<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" href="img/logotitlee4.png">
<title>ENI-Encheres</title>
	 <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>


<body>
	<header>
	
		<div class="container-fluid d-flex justify-content-between shadow p-3 mb-5 bg-white rounded">
			<div id="logo" class="pull-left">
		                <a href="<%=request.getContextPath()%>/ServletAccueil"><img src="img/logo.svg" alt="logo" title="" width="120px" /></a>
	        </div>
	        <nav id="nav-menu-container">
	            <ul class="nav-menu">
	                <li class="nav-item">
	                    <a class="nav-link" href="<%=request.getContextPath()%>/ServletConnection">Se connecter</a>
	                </li>
	                <li class="nav-item">
	                    <a class="nav-link" href="Inscription.html">S'inscrire</a>
	                </li>
	            </ul>
	        </nav>
		</div>
	</header>
	
	 <!-- Formulaire de Connexion -->
	<form class="box" action="<%=request.getContextPath()%>/ServletConnection" method="post" name="login">
		<h1 class="box-title">Connexion</h1>
		<label for="username"></label>
		<input type="text" class="box-input" name="username" placeholder="Nom d'utilisateur">
		<label for="password"></label>
		<input type="password" class="box-input" name="password" placeholder="Mot de passe">
		<label for="submit"></label>
		<input 	type="submit" value="Submit" name="submit" class="box-button" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
				title="Doit contenir au moins 8 caractère, un chiffre, une majuscule et une minuscule" required>
		<p class="box-register">Vous êtes nouveau ici? <a href="Inscription.html">S'inscrire</a></p>
		<?php if (! empty($message)) { ?>
  				<p class="errorMessage"><?php echo $message; ?></p>
		<?php } ?>
	</form>
	<!-- Fin de Formulaire de Connexion -->
	
	
</body>

<!-- Pied de page -->
       <footer>
       	<div class="container-fluid d-flex justify-content-between shadow p-3 mb-5 bg-white rounded text-center">
           <p>© Copyright - Tous droits réservés</p>
           <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
           </div>
       </footer>
       
       
</html>