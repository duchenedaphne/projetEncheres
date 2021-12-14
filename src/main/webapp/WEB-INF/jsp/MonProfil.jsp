<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Title -->
<link rel="icon" href="img/logotitlee4.png">
<title>ENI-Encheres</title>
<!-- CSS Styles -->
<link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css" />
<link href="css/styles.css" rel="stylesheet">
<!-- Bootstrap CSS -->
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> -->
</head>
<body>

	<!-- Header -->
	<%@ include file="jspf/headerLogged.jspf" %>
	   <div class=" p-2 mb-3 d-flex" style="height: 80px; background-color: rgb(189,221,227);" >
            <span class="container-fluid d-flex pull-left align-self-center text-white  w-25" style=" font-weight-bold">
            Mon Profil</span> 
            <div class="d-flex justify-content-between w-100 ">
            <img class="align-self-end" src='img/nuage1.svg' alt='' width="200px">
            <img class="align-self-end" src='img/nuage2.svg' alt='' width="200px">
            <img class="align-self-end" src='img/nuage3.svg' alt='' width="150px">
            </div>                                                            
        </div>

		<div>
			<div class="border">
				<p>Pseudo : ${sessionScope['username'] }</p>
				<p>Adresse Mail : ${sessionScope['mail'] }</p>
				<p>Mot de passe : ************ </p>
				
				
				
				<button type="button" class="btn tbn-info" data-toggle="modal" data-target="#modal_infos_compte">Modifier infos</button>
				
				<!-- Modal -->
				<div class="modal fade" id="modal_infos_compte" role="dialog">
					<div class="modal-dialog">
						<!-- Modal content -->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"></button>
								<h3 class="modal-title">Modifier les informations personnelles</h3>
							</div>
							<div class="modal-body">test</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
						</div>
					</div>
					
				</div>
			</div>
			
			<div class="border">
				<p>Nom : ${sessionScope['nom'] }</p>
				<p>Prénom : ${sessionScope['prenom'] }</p>
				<c:choose>
					<c:when test="${!empty sessionScope.telephone}">
						<p>Numéro de téléphone : ${sessionScope['telephone'] }</p>
					</c:when>
					<c:otherwise>
						<p>Numéro de téléphone : Non Renseigné</p>
					</c:otherwise>
				</c:choose>
				<p>Adresse : ${sessionScope['rue'] }</p>
				<p>${sessionScope['codepostal'] } ${sessionScope['ville'] }</p>
			</div>	
		</div>
		
	
</body>

<%@ include file="jspf/footer.jspf" %>
</html>