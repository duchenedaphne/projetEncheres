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
	<%@ include file="jspf/headerLogged.jspf" %>
	   <div class=" p-2 mb-3 d-flex" style="height: 80px; background-color: rgb(189,221,227);" >
            <span class="container-fluid d-flex pull-left align-self-center text-white  w-25" style=" font-weight-bold">
            Modifier Mon Profil</span> 
            <div class="d-flex justify-content-between w-100 ">
            <img class="align-self-end" src='img/nuage1.svg' alt='' width="200px">
            <img class="align-self-end" src='img/nuage2.svg' alt='' width="200px">
            <img class="align-self-end" src='img/nuage3.svg' alt='' width="150px">
            </div>                                                            
        </div>


	<div class="container  shadow rounded mb-5" style="background-color: #eeeeee;">
		<form class="box" action="<%=request.getContextPath()%>/ServletModifierProfil" method="post" name="update">
			<h1 class="box-title text-center">Modifier mes infos</h1>
			<div class="container-fluid d-flex justify-content-evenly">
				<div class="d-flex flex-column">
					<label for="updateUsername">Pseudo : </label>
			        <input type="text" class="box-input align-middle" name="updateUsername" placeholder="Nouveau pseudo" >

			        <label for="updateMail">Email : </label>
			        <input type="email" class="box-input align-middle" name="updateMail" placeholder="Nouvelle adresse mail">

			        <label for="updatePassword">Mot de passe : </label>
			        <input type="password" class="box-input align-middle" name="updatePassword" placeholder="Nouveau mot de passe" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" >
			        <label for="checkUpdatedPassword">Confirmation : </label>
			        <input type="password" class="box-input align-middle" name="checkUpdatedPassword" placeholder="Confirmer mot de passe" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" >
		        	
		        </div>
		        
		        <div class="d-flex flex-column">
		        	<label for="updateTelephone">Teléphone : </label>
		        	<input type="text" class="box-input align-middle" name="updateTelephone" placeholder="" >
		        	<label for="updateCodepostal">Code Postal : </label>
		        	<input type="text" class="box-input align-middle" name="updateCodepostal" placeholder="" >
		        	<label for="updateRue">Adresse : </label>
		        	<input type="text" class="box-input align-middle" name="updateRue" placeholder="" >
		        	<label for="updateVille">Ville : </label>
		        	<input type="text" class="box-input align-middle" name="updateVille" placeholder="" >
		        	<div class="mr-4">
		        		<input type="submit" value="Modifier" name="submit" class="box-button">
		        	</div>
		        </div>
		        
		        
		   </div>

		</form>
	</div>
	<a href="<%=request.getContextPath()%>/ServletSupprimerProfil" class="btn btn-primary">Supprimer mon compte définitivement</a>
</body>

<%@ include file="jspf/footer.jspf" %>
</html>