<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Title -->
<link rel="icon" href="img/logotitlee4.png">
<title>Inscription</title>
<!-- CSS Styles -->
<link href="css/styles.css" rel="stylesheet">
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<%@ include file="jspf/header.jspf" %>
	<p>Erreur d'exécution !
	<form action="<%=request.getContextPath()%>/ServletDeconnection" method="post" name="unlog">
		<input type="submit" value="Déconnexion">
	</form>
</body>
	<%@ include file="jspf/footer.jspf" %>
</html>