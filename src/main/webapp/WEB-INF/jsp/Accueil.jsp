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
	<!-- En-tête de la page -->
        <%@ include file="jspf/header.jspf" %>

        <!-- Bloc information -->
        <p>100% GRATUIT  /  Ecologique / Solidaire </p>
        
        <!--Fin Bloc information -->
        
        <p>Carroussel </p>
        <!--Bloc Cards -->
       		<div class="card" style="width: 18rem;">
  				<img class="card-img-top" src="img/Aspirateur.jpg" alt="Card image cap">
  					<div class="card-body">
    					<p class="card-text">Prix: 200 points Fin de l'enchère : 07/01/2022 Vendeur : Jacques</p>
 					</div>
			</div>
		<!--Fin Bloc Cards-->
		<a href="Accueilconnected.html" class="btn btn-primary">Voir Toutes les offres partenaires</a>
    
    </body>
        <!-- Pied de page -->
        <%@ include file="jspf/footer.jspf" %>
</body>
</html>