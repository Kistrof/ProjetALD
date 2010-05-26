<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un film à un acteur</title>
</head>
<body>
Ajouter une récompense à l'acteur <bean:write name="PERSONNE" property="prenom" /> <bean:write name="PERSONNE" property="nom" />
<html:form action="/actionAjouterRecompenseToPersonne.do" >
	<input type="hidden" name="personneid" value="<bean:write name="PERSONNE" property="id" />" />
	<html:select property="prixid">
		<html:options collection="PRIXS" labelProperty="titreComplet" property="id" />
	</html:select>
	
	<table>
		<tr>
			<td>Année : </td>
			<td><html:text property="annee" /></td>
		</tr>	
	</table>
	
	<html:submit>Ajouter</html:submit>
</html:form>
</body>
</html>