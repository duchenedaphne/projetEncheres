<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="jspf/header.jspf" %>
	<p>T'es déjà connecté frère !
	<form action="<%=request.getContextPath()%>/ServletDeconnection" method="post" name="unlog">
		<input type="submit" value="Déconnexion">
	</form>
</body>
	<%@ include file="jspf/footer.jspf" %>
</html>