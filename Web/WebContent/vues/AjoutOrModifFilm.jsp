<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajouter un film</h1>
	<html:form action="/verifAddOrUpdateFilm.do">
		<table>
			<tr>
				<td>Titre du film : </td>
				<td><html:text property="titre" /></td>
			</tr>
			<tr>
				<td>Ann�e de sortie : </td>
				<td><html:text property="annee_sortie" /></td>
			</tr>
			<tr>
				<td>Co�t du film : </td>
				<td><html:text property="cout" /></td>
			</tr>
			<tr>
				<td>Lien vers l'affiche : </td>
				<td><html:text property="affiche" /></td>
			</tr>
			<tr>
				<td>Description : </td>
				<td><html:textarea property="description" rows="5" cols="40" /></td>
			</tr>
		</table>
		<html:submit>Valider</html:submit>
	</html:form>
</body>
</html>