<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fiche Film</title>
</head>
<body>
	<h1><bean:write name="FILM" property="titre" /></h1>
	Année de sortie : <bean:write name="FILM" property="annee_sortie" /><br/>
	Cout : <bean:write name="FILM" property="cout" /><br/>
	Lien vers l'affiche : <bean:write name="FILM" property="affiche" /><br/>
	Description : <bean:write name="FILM" property="description" /><br/>
	Note : <bean:write name="FILM" property="note_moyenne" /><br/>
	Dernière mise à jour : <bean:write name="FILM" property="date_maj" /><br/>
	<br/>
	Récompenses :<br/>
<logic:iterate id="recompense" name="FILM" property="recompenses">
	<bean:write name="recompense" property="prix" /><br/>
</logic:iterate>
	<br/>
	Casting :<br/>
<logic:iterate id="acteur" name="FILM" property="acteurs">
	<bean:write name="acteur" property="prenom" /> <bean:write name="acteur" property="nom" /><br/>
</logic:iterate>
	<html:link action="/ajouterActeur" paramId="id" paramName="FILM" paramProperty="id" >Ajouter un acteur</html:link>
	<br/>
	Producteurs :<br/>
<logic:iterate id="producteur" name="FILM" property="producteurs">
	<bean:write name="producteur" property="prenom" /> <bean:write name="acteur" property="nom" /><br/>
</logic:iterate>
	<html:link action="/ajouterProducteur" paramId="id" paramName="FILM" paramProperty="id" >Ajouter un producteur</html:link>
	<br/>
	Réalisateurs :<br/>
<logic:iterate id="realisateur" name="FILM" property="realisateurs">
	<bean:write name="realisateur" property="prenom" /> <bean:write name="acteur" property="nom" /><br/>
</logic:iterate>
	<html:link action="/ajouterRealisateur" paramId="id" paramName="FILM" paramProperty="id" >Ajouter un réalisateur</html:link>
	<br/>
	<html:link action="/noterFilm" paramId="id" paramName="FILM" paramProperty="id" >Noter ce film</html:link>
	<br/>
	<html:link action="/modifFilm" paramId="id" paramName="FILM" paramProperty="id" >Proposer des modifications</html:link>
</body>
</html>