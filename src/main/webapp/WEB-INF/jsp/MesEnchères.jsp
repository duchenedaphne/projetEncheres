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


	
</body>

<%@ include file="jspf/footer.jspf" %>
</html>