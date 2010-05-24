<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fiche Personne</title>
</head>
<body>
	<h1><u><bean:write name="PERSONNE" property="prenom" /> <bean:write name="PERSONNE" property="nom" /></u></h1>
	Popularit� : <bean:write name="PERSONNE" property="popularite" /><br/>
	N� le : <bean:write name="PERSONNE" property="naissance" /><br/>
	Lien vers la photo : <bean:write name="PERSONNE" property="photo" /><br/>
	<br/>
	<h3><u>R�compenses</u></h3>
	<logic:iterate id="recompense" name="PERSONNE" property="recompenses">
		<bean:write name="recompense" property="prix" /><br/>
	</logic:iterate>
	<br/>
	<h3><u>Filmographie</u></h3>
	<logic:iterate id="film" name="PERSONNE" property="filmographie">
		<bean:write name="film" property="titre" /><br/>
	</logic:iterate>
	<br/>
	<h3><u>R�alisations</u></h3>
	<logic:iterate id="realisation" name="PERSONNE" property="realisations">
		<bean:write name="realisation" property="titre" /><br/>
	</logic:iterate>
	<br/>
	<h3><u>Productions</u></h3>
	<logic:iterate id="production" name="PERSONNE" property="productions">
		<bean:write name="production" property="titre" /><br/>
	</logic:iterate>
	<br/>
	<html:link action="/modifPersonne" paramId="id" paramName="PERSONNE" paramProperty="id" >Modifier cette personne</html:link>
</body>
</html>