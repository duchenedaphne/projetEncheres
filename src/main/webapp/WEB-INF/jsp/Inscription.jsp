<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Title -->
<link rel="icon" href="img/logotitlee4.png">
<title>Inscription</title>
<!-- CSS Styles -->
<link href="css/styles.css" rel="stylesheet">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

	<%@ include file="jspf/header.jspf" %>

	<form class="box" action="<%=request.getContextPath()%>/ServletInscription" method="post" name="inscription">
		<h1 class="box-title">Inscription</h1>
		<label for="pseudo"></label>
		<p>Pseudo :</p><input type="text" class="box-input" name="pseudo" placeholder="">
		<label for="nom"></label>
		<p>Nom :</p><input type="text" class="box-input" name="nom" placeholder="">
		<label for="prenom"></label>
		<p>Prénom :</p><input type="text" class="box-input" name="prenom" placeholder="">
		<label for="mail"></label>
		<p>Email :</p><input type="text" class="box-input" name="mail" placeholder="">
		<label for="password"></label>
		<input type="password" class="box-input" name="password" placeholder="Mot de passe">
		<label for="submit"></label>
		<input type="submit" value="Connexion " name="submit" class="box-button">
		<p class="box-register">Vous avez déjà un compte ? <a href="<%=request.getContextPath()%>/ServletConnection">Se Connecter</a></p>
		<?php if (! empty($message)) { ?>
  				<p class="errorMessage"><?php echo $message; ?></p>
		<?php } ?>
	</form>
</body>

<%@ include file="jspf/footer.jspf" %>
</html>