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
            Nouvelle Vente</span> 
            <div class="d-flex justify-content-between w-100 ">
            <img class="align-self-end" src='img/nuage1.svg' alt='' width="200px">
            <img class="align-self-end" src='img/nuage2.svg' alt='' width="200px">
            <img class="align-self-end" src='img/nuage3.svg' alt='' width="150px">
            </div>                                                            
        </div>
        
        
        
        <div class="container  shadow rounded mb-5" style="background-color: #eeeeee;">
	<form class="box" action="" method="post" name="">
		<h1 class="box-title text-center mb-4">Nouvelle Vente</h1>
		<div class="container-fluid d-flex justify-content-evenly">
			<div class="d-flex flex-column">
				<label for="article">Article : </label>
		        <input type="text" class="box-input align-middle" name="article" placeholder="" required>
		        <label for="description">Description : </label>
		        <TEXTAREA name="description" rows=4 cols=40 required></TEXTAREA>
		        <label for="categories">Catégorie : </label>
		        <select id="categories" class="form-control" required>
                                <option selected>Choississez une catégorie</option>
                                <option>Ameublement</option>
                                <option>Sport</option>
                                <option>Informatique</option>
                                <option>Vêtement</option>
                            </select>
		        <label for="photoArticle">Photo de l'article : </label>
		        <input type="file" accept="image/*" required>
		        <label for="credit">Mise à prix : </label>
		        <input id="credit" type="number" value="100" min="0" max="999" required>
		        <label for="DébutEnchère">Début de l'enchère : </label>
		        <input type="date" name="DébutEnchère" required>
		        <label for="FinEnchère">Fin de l'enchère : </label>
		        <input type="date" name="FinEnchère" required>
		     
		     	<div class="d-flex flex-column border mt-4 mb-4">
	  			<h3 class="box-title text-center">Retrait</h3>
	  			<label for="rue">Rue : </label>
		        <input type="text" class="box-input align-middle" name="rue" placeholder="${sessionScope['rue'] }" required>
		        <label for="codepostal">Code postal : </label>
		        <input type="text" class="box-input align-middle" name="codepostal" placeholder="${sessionScope['codepostal'] }" required>
		        <label for="ville">Ville : </label>
		        <input type="text" class="box-input align-middle" name="ville" placeholder="${sessionScope['ville'] }" required>
   			</div>
	        </div>
	  	</div>
	  	

	  	
	   
   	 	<div class="container-fluid d-flex justify-content-evenly text-center mt-4 p-3">
	   	 	<div class="mr-4">
	        	<input type="submit" value="Enregistrer" name="submit" class="box-button">
	        </div>
	        <div class="mr-4 ml-4">
	        	<input type="reset" value="Réinitialiser" name="reset" class="box-button">
	   		</div>
	   		<div class="mr-4 ml-4">
	        	<input type="reset" value="Annuler la vente" name="reset" onclick="location.href='<%=request.getContextPath()%>/ServletAccueil'" class="box-button">
	   		</div>
	   		
   		</div>
	</form>
	</div>


	
</body>

<%@ include file="jspf/footer.jspf" %>
</html>