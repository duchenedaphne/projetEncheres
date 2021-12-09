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
	<%@ include file="jspf/header.jspf" %>
		      <p>logged : ${sessionScope['logged']}</p>
	
	 <!-- Formulaire de Connexion -->
	<form class="box" action="<%=request.getContextPath()%>/ServletConnection" method="post" name="login">
		<h1 class="box-title">Connexion</h1>
		<label for="username"></label>
		<p>Identifiant :</p><input type="text" class="box-input" name="username" placeholder="Identifiant">
        <label for="password"></label>
        <p>Mot de passe :</p><input type="password" class="box-input" name="password" placeholder="Mot de passe" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
               title="Doit contenir au moins 8 caractère, un chiffre, une majuscule et une minuscule" >
        <!-- <label for="logged"></label>
        <input type="hidden" name="logged" value="true"> -->
        <label for="submit"></label>
        <input type="submit" value="Connexion" name="submit" class="box-button" >
        
        <!-- Se souvenir de moi -->
            <div>
        <!-- Ceci est la case à cocher et nous allons chercher pour notre cookie "remembermeu" si on le trouve alors on va cocher la case avec "checked"-->
                <input type="checkbox" id="rememberme" name="rememberme" value="1">
                <label for="rememberme">Se souvenir de moi</label>
            </div>
            <!-- Mot de passe oublié -->
            <a href="">Mot de passe oublié ?</a>
		<p class="box-register">Vous êtes nouveau ici? <a href="<%=request.getContextPath()%>/ServletInscription">S'inscrire</a></p>
		<?php if (! empty($message)) { ?>
  				<p class="errorMessage"><?php echo $message; ?></p>
		<?php } ?>
	</form>
	<!-- Fin de Formulaire de Connexion -->
	
	
</body>

<!-- Pied de page -->
       <%@ include file="jspf/footer.jspf" %>
       
       
</html>