<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout/édition d'un film</title>
</head>
<body>
	<html:form action="/verifAddOrUpdateFilm.do">
<logic:empty name="FILM">
		<h1>Ajouter un film</h1>
</logic:empty><logic:notEmpty name="FILM">
		<h1>Proposer des modifications sur le film "<bean:write name="FILM" property="titre" />"</h1>
		<html:hidden property="id" name="FILM" />
</logic:notEmpty>
		<table>
			<tr>
				<td>Titre du film : </td>
				<td><html:text property="titre" name="FILM" /></td>
			</tr>
			<tr>
				<td>Année de sortie : </td>
				<td><html:text property="annee_sortie" name="FILM" /></td>
			</tr>
			<tr>
				<td>Coût du film : </td>
				<td><html:text property="cout" name="FILM" /></td>
			</tr>
			<tr>
				<td>Lien vers l'affiche : </td>
				<td><html:text property="affiche" name="FILM" /></td>
			</tr>
			<tr>
				<td>Description : </td>
				<td><html:textarea property="description" name="FILM" rows="5" cols="40" /></td>
			</tr>
		</table>
		<html:submit>Valider</html:submit>
	</html:form>
</body>
</html>