<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>


<body>
    <!-- En-tête de la page -->
        <%@ include file="jspf/header.jspf" %>
        <%! boolean logged = false;
        	
        %>

         <!-- Carousel -->
        <div class="container-fluid">
 			<div id="carouselHeader" class="carousel slide" data-bs-ride="carousel">
 				<div class="carousel-indicators">
 					<button type="button" data-bs-target="#carouselHeader" data-bs-slide-to="0" class="active" current="true" aria-label="First slide"></button>
 					<button type="button" data-bs-target="#carouselHeader" data-bs-slide-to="1" aria-label="second slide"></button>
 					<button type="button" data-bs-target="#carouselHeader" data-bs-slide-to="2" aria-label="third slide"></button>
 				</div>
 			
 			
  			
  			<div class="carousel-inner">
    			<div class="carousel-item active">
      				<img class="d-block w-100" src="img/nuage.png" alt="First slide">
    			</div>
    			<div class="carousel-item">
      				<img class="d-block w-100" src="img/CarouselHeader2.png" alt="Second slide">
    			</div>
    			<div class="carousel-item">
      				<img class="d-block w-100" src="img/logorenard.png" alt="Third slide">
    			</div>
  			</div>
  			
 			<button class="carousel-control-prev" type="button" data-bs-target="#carouselHeader" data-slide="prev">
    			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    			<span class="visually-hidden">Précédent</span>
  			</button>
  			<button class="carousel-control-next" type="button" data-bs-target="#carouselHeader" data-slide="next">
    			<span class="carousel-control-next-icon" aria-hidden="true"></span>
    			<span class="visually-hidden">Suivant</span>
  			</button>
  			</div>
		</div>
		
        <!-- Bloc information --> 
        <div class="container-fluid d-flex justify-content-between" style="background-color: rgb(209,225,184);">
            <div class="d-inline">
                <div class='' ><img src='img/100.png' alt=''></div>  
                    <div>
                        <H3>Gratuit</H3>
                    </div>
            </div>
                <span class="align-middle">middle</span>
				<img class="align-middle" src="img/100.png"/>
            </div>                    
                <div class='' ><img src='' data-src='' class='' alt=''></div>  
                    <div>
                        <H3>Solidaire</H3>
                    </div>                                
        </div>
        
        <!--Bloc Cards -->
               <div class="card shadow" style="width: 18rem;">
                  <img class="card-img-top" src="img/Aspirateur.jpg" alt="Card image cap">
                      <div class="card-body">
                      	<h5 class="card-title">
                      	Aspirateur
                      	</h5>
                        <p class="card-text">
                        Prix : 200 points <br>
                        Fin de l'enchère : 07/01/2022 <br>
                        Vendeur : Jacques</p>
                     </div>
            </div>
        <!--Fin Bloc Cards-->
        
    		<div class="justify-content-between">
    			<div class=""></div>
    			<a href="<%=request.getContextPath()%>/ServletConnection">
    			<button type="button" class="btn btn-primary btn-sm">VOIR TOUS LES UNIVERS</button>
    			</a>
    		</div>
    		<br/>
    </body>
        <!-- Pied de page -->
        <%@ include file="jspf/footer.jspf" %>
</body>
</html>