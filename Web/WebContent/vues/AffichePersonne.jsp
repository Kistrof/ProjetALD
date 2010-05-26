<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="metier.Film"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fiche Personne</title>
</head>
<body>
	<h1><u><bean:write name="PERSONNE" property="prenom" /> <bean:write name="PERSONNE" property="nom" /></u></h1>
	Popularité : <bean:write name="PERSONNE" property="popularite" /><br/>
	Né le : <bean:write name="PERSONNE" property="naissance" /><br/>
	Lien vers la photo : <bean:write name="PERSONNE" property="photo" /><br/>
	Dernière mise à jour : <bean:write name="PERSONNE" property="date_maj" /><br/>
	<br/>
	<h3><u>Récompenses</u></h3>
	<logic:iterate id="recompense" name="PERSONNE" property="recompenses">
		<bean:write name="recompense" property="prix" /><br/>
	</logic:iterate>
	<html:link action="/ajouterRecompense" paramId="id" paramName="PERSONNE" paramProperty="id" >Ajouter une récompense</html:link>
	<br/>
	<h3><u>Filmographie</u></h3>
	<logic:iterate id="film" name="PERSONNE" property="filmographie">
		<bean:write name="film" property="titre" /><br/>
	</logic:iterate>
	<html:link action="/ajouterFilmographie" paramId="id" paramName="PERSONNE" paramProperty="id" >Ajouter un film</html:link>
	<br/>
	<h3><u>Réalisations</u></h3>
	<logic:iterate id="realisation" name="PERSONNE" property="realisations">
		<bean:write name="realisation" property="titre" /><br/>
	</logic:iterate>
	<html:link action="/ajouterRealisation" paramId="id" paramName="PERSONNE" paramProperty="id" >Ajouter une réalisation</html:link>
	<br/>
	<h3><u>Productions</u></h3>
	<logic:iterate id="production" name="PERSONNE" property="productions">
		<bean:write name="production" property="titre" /><br/>
	</logic:iterate>
	<html:link action="/ajouterProduction" paramId="id" paramName="PERSONNE" paramProperty="id" >Ajouter une production</html:link>
	<br/>
	<html:link action="/modifPersonne" paramId="id" paramName="PERSONNE" paramProperty="id" >Modifier cette personne</html:link>
</body>
</html>