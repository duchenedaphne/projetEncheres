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
            Mes Enchères</span> 
            <div class="d-flex justify-content-between w-100 ">
            <img class="align-self-end" src='img/nuage1.svg' alt='' width="200px">
            <img class="align-self-end" src='img/nuage2.svg' alt='' width="200px">
            <img class="align-self-end" src='img/nuage3.svg' alt='' width="150px">
            </div>                                                            
        </div>
        
        <div class=" border" >
        <span>Mes ventes</span>
        </div>
        
        <!--Bloc Cards -->
        
        <div class="container pt-5 pb-5">
        	<div class="row">
        		<div class="col">
        			<div class="card w-50 shadow">
        				<img class="card-img-top" src="img/hoover.jpg" alt="Card image cap">
                      	<div class="card-body">
                      	<h5 class="card-title">
                      	Aspirateur
                      	</h5>
                        <p class="card-text">
                        Prix : 200 points <br>
                        Fin de l'enchère : 07/01/2022 <br>
                        Vendeur : Jacques</p>
                        <a href="#" class="btn btn-primary">Voir l'article</a>
                     	</div>
                     	<div class="card-footer">
                     		<small class="text-muted"></small>
                     	</div>
        			</div>
        		</div>
        		<div class="col">
        			<div class="card w-50 shadow">
        				<img class="card-img-top" src="img/ordinateur.jpg" alt="Card image cap">
                      	<div class="card-body">
                      	<h5 class="card-title">
                      	Ordinateur de bureau
                      	</h5>
                        <p class="card-text">
                        Prix : 500 points <br>
                        Fin de l'enchère : 03/02/2022 <br>
                        Vendeur : Véronique</p>
                        <a href="#" class="btn btn-primary">Voir l'article</a>
                     	</div>
                     	<div class="card-footer">
                     		<small class="text-muted"></small>
                     	</div>
        			</div>
        		</div>
			</div>
		</div>
        <!--Fin Bloc Cards-->
        		
        <div class=" border" >
        <span>Mes enchères</span>
        </div>
        <!--Bloc Cards -->
        
        <div class="container pt-5 pb-5">
        	<div class="row">
        		<div class="col">
        			<div class="card w-25 shadow">
        				<img class="card-img-top" src="img/pneus.jpg" alt="Card image cap">
                      	<div class="card-body">
                      	<h5 class="card-title">
                      	2 pneus michelin
                      	</h5>
                        <p class="card-text">
                        Prix : 150 points <br>
                        Fin de l'enchère : 07/04/2022 <br>
                        Vendeur : Marc</p>
                        <a href="#" class="btn btn-primary">Voir l'article</a>
                     	</div>
                     	<div class="card-footer">
                     		<small class="text-muted"></small>
                     	</div>
        			</div>
        		</div>
        	</div>
        </div>

        <!--Fin Bloc Cards-->

	
</body>

<%@ include file="jspf/footer.jspf" %>
</html>