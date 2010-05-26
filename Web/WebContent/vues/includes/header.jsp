<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<div id="header">
	<div id="banniere">
	
	</div>
	<div id="zone_connexion">
	<%@ include file="FormConnexion.jsp" %>
	</div>

</div>
<div id="menu">
	<html:link action="/AfficheFormRecherche.do">
 	    <bean:message key="accueil.lien_rechercher"/>
 	</html:link>
 		<html:link action="/AfficheFormAjoutPro.do" >
		<bean:message key="accueil.lien_connexion"/>
	</html:link>
</div>

<div id="corps">