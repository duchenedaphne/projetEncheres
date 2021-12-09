<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Title -->
<title>ENI-Encheres</title>
<!-- CSS Styles -->
<link href="css/styles.css" rel="stylesheet">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

	<c:if test="${empty sessionScope.logged}">
	
	<body>
	    <!-- En-tête de la page -->
	        <%@ include file="jspf/header.jspf" %>
	      <p>logged : ${sessionScope['logged']}</p>
	
	        <!-- Bloc information -->
	        
	        <div class="banniereinformation">
	            <div>
	                <div class='' >    <img src='' data-src='' class='' alt=''><img src='' data-src='' class='' alt=''></div>  
	                    <div>
	                        <H3>gratuit</H3>
	                    </div>
	            </div>
	                <div>
	                    <div class='' >    <img src='' data-src='' class='' alt=''><img src='' data-src='' class='' alt=''></div>  
	                    <div>
	                        <H3>Ecologique</H3>
	                    </div>
	            </div>                    
	                <div class='' >    <img src='' data-src='' class='' alt=''><img src='' data-src='' class='' alt=''></div>  
	                    <div>
	                        <H3>Solidaire</H3>
	                    </div>                                
	        </div>
	        
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
	        
	    		<a href="<%=request.getContextPath()%>/ServletConnection" class="btn btn-primary">Voir Toutes les offres partenaires</a>
	    </body>
	        <!-- Pied de page -->
	        <%@ include file="jspf/footer.jspf" %>
	</c:if>
	
	<c:if test="${!empty sessionScope.logged}">
		<%@ include file="jspf/header.jspf" %>
<p>logged : ${sessionScope['logged']}</p>
<section class="container haute">
                <div class="text-center rounded my-5 haute ">
                    <h1 class="p-3 bordure">Liste des enchères</h1>
                </div>

                <form method="get" action="" class=" p-5 rounded bordure " style="background: #fff;">
                    <h2>Filtres :</h2>

                    <div class="md-form  active-pink-2 mb-3 mt-0">
                        <input class="form-control" type="text" placeholder="Rechercher..." aria-label="Search">
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword" class="col-sm-2 col-form-label">Catégorie :</label>
                        <div class="col-sm-10">
                            <select id="inputState" class="form-control">
                                <option selected>Toutes</option>
                                <option>Ameublement</option>
                                <option>Sport</option>
                                <option>Informatique</option>
                                <option>Vêtement</option>
                            </select>
                        </div>
                    </div>

                    <div class="d-flex justify-content-end pt-5">
                        <button class="btn btn-action" type="submit">Rerchercher</button>
                    </div>
                </form>
            </section>
        <!--Fin Bloc Filtre -->
        
        
        <!--Bloc Cards -->
        <div class="card" style="width: 18rem;">
  			<img class="card-img-top" src="img/Aspirateur.jpg" alt="Card image cap">
  				<div class="card-body">
    				<h5 class="card-title">Aspirateur</h5>
    				<p class="card-text">Prix: 200 points Fin de l'enchère : 07/01/2022 Vendeur : Jacques</p>
    				<a href="#" class="btn btn-primary">Voir l'article</a>
  				</div>
		</div>
		<!--Fin Bloc Cards-->

</body>

	<%@ include file="jspf/footer.jspf" %>
	</c:if>
</html>