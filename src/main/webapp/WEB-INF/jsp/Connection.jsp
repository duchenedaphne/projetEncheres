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
	 <!-- Header -->
	<%@ include file="jspf/header.jspf" %>
		
	   <div class=" h p-2 mb-3 container-fluid d-flex justify-content-between" style="height: 80px; background-color: rgb(189,221,227);" >
            <div class="container-fluid d-flex pull-left align-items-center">
			Connexion
            </div>                                                                 
        </div>
		      <p>logged : ${sessionScope['logged']}</p>
	
	 <!-- Formulaire de Connexion -->
	 <div class="container  shadow rounded mb-5 w-25" style="background-color: #eeeeee;">
	<form class="box " action="<%=request.getContextPath()%>/ServletConnection" method="post" name="login">
		<h1 class="box-title text-center">Connexion</h1>
		<div class="container-fluid d-flex justify-content-center text-center">
		<label for="username"></label>
		<div class="d-flex flex-column justify-content-start" >
		<span class="mb-4">Identifiant : </span>
		<label for="password"></label>
        <span class="">Mot De Passe : </span>
        </div>
        <div class="d-flex flex-column " >
        <input type="text" class="box-input align-middle mb-4 " name="username" placeholder="Identifiant">
        <input type="password" class="box-input align-middle " name="password" placeholder="Mot de passe" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
               title="Doit contenir au moins 8 caractère, un chiffre, une majuscule et une minuscule" >
        </div>
        </div>
        <!-- <label for="logged"></label>
        <input type="hidden" name="logged" value="true"> -->
        <div class="container-fluid d-flex justify-content-center text-center mt-4 p-3">
        <label for="submit"></label>
        <input type="submit" value="Connexion" name="submit" class="box-button" >
        <div class="row">
        <div class="d-line">
        <input type="checkbox" id="rememberme" name="rememberme" value="1">
        <label for="rememberme">Se souvenir de moi</label>
        </div>
        <a href="">Mot de passe oublié ?</a>
        </div>
        </div>
        <p class="box-register container-fluid d-flex justify-content-center text-center mt-4 pb-4">Vous êtes nouveau ici ? <a href="<%=request.getContextPath()%>/ServletInscription">S'inscrire</a></p>

        <!-- Ceci est la case à cocher et nous allons chercher pour notre cookie "remembermeu" si on le trouve alors on va cocher la case avec "checked"-->

           	</form>
	</div>
	<!-- Fin de Formulaire de Connexion -->
	
	
</body>

<!-- Pied de page -->
       <%@ include file="jspf/footer.jspf" %>
       
       
</html>