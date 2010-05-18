<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>
Bienvenue sur la page d'accueil<br>
<logic:empty name="PRO" scope="session">
	<html:link action="/AfficheFormConnexion.do" >
		<bean:message key="accueil.lien_connexion"/>
	</html:link>
	<br/>
	<html:link action="/AfficheFormAjoutPro.do">
		<bean:message key="accueil.lien_inscription"/>
	</html:link>
</logic:empty>
<br/>
<logic:notEmpty name="PRO" scope="session">
 vous etes connecté
 	<html:link action="/Deconnecte.do">
 	   deconnecte
 	</html:link>
</logic:notEmpty>
<br/>
	<html:link action="/AfficheFormRecherche.do">
 	    <bean:message key="accueil.lien_rechercher"/>
 	</html:link>
</body>
</html>