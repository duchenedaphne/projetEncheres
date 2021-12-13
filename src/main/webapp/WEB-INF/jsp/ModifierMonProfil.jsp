<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Title -->
<link rel="icon" href="img/logotitlee4.png">
<title>ENI-Encheres</title>
<!-- CSS Styles -->
<link href="css/styles.css" rel="stylesheet">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

	<!-- Header -->
	<%@ include file="jspf/header.jspf" %>
	<div class=" h p-2 mb-3 container-fluid d-flex justify-content-between" style="height: 80px; background-color: rgb(189,221,227);" >
            <div class="container-fluid d-flex pull-left align-items-center">
			Modifier Mon Profil
            </div>                                                                 
        </div>


	<div class="container  shadow rounded mb-5" style="background-color: #eeeeee;">
	<form class="box" action="<%=request.getContextPath()%>/ServletInscription" method="post" name="inscription">
		<h1 class="box-title text-center">Inscription</h1>
		<div class="container-fluid d-flex justify-content-evenly">
			<div class="d-flex flex-column">
				<label for="username">Pseudo : </label>
		        <input type="text" class="box-input align-middle" name="username" placeholder="" required>
		        <label for="prenom">Prénom : </label>
		        <input type="text" class="box-input align-middle" name="prenom" placeholder="" required>
		        <label for="telephone">Teléphone : </label>
		        <input type="text" class="box-input align-middle" name="telephone" placeholder="">
		        <label for="codepostal">Code Postal : </label>
		        <input type="text" class="box-input align-middle" name="codepostal" placeholder="" required>
		        <label for="MotDePasse">Mot de passe : </label>
		        <input type="password" class="box-input align-middle" name="MotDePasse" placeholder="" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>
	        </div>
	        <div class="d-flex flex-column">
		        <label for="nom">Nom : </label>
		        <input type="text" class="box-input align-middle" name="nom" placeholder="" required>
		        <label for="mail">Email : </label>
		        <input type="text" class="box-input align-middle" name="mail" placeholder="" required>
		        <label for="rue">Adresse : </label>
		        <input type="text" class="box-input align-middle" name="rue" placeholder="" required>
		        <label for="ville">Ville : </label>
		        <input type="text" class="box-input align-middle" name="ville" placeholder="" required>
		        <label for="CheckMotDePasse">Confirmation : </label>
		        <input type="password" class="box-input align-middle" name="CheckMotDePasse" placeholder="" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required>
		   </div>
	  	</div>
	   
   	 	<div class="container-fluid d-flex justify-content-evenly text-center mt-4 p-3">
	   	 	<div class="mr-4">
	        	<input type="submit" value="Créer" name="submit" class="box-button">
	        </div>
	        <div class="mr-4 ml-4">
	        	<input type="reset" value="Annuler" name="reset" onclick="location.href='<%=request.getContextPath()%>/ServletAccueil'" class="box-button">
	   		</div>
   		</div>
		<span class="box-register container-fluid d-flex justify-content-center text-center mt-4 pb-4">Vous avez déjà un compte ? <a href="<%=request.getContextPath()%>/ServletConnection">Se Connecter</a></span>
	</form>
	</div>
</body>

<%@ include file="jspf/footer.jspf" %>
</html>