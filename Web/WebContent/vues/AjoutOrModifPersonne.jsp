<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout/édition d'une personne</title>
</head>
<body>
<logic:empty name="PERSONNE">
	<h1>Ajouter une personne</h1>
</logic:empty>
<logic:notEmpty name="PERSONNE">
	<h1>Proposer des modifications sur la Personne "<bean:write name="PERSONNE" property="prenom" /> <bean:write name="PERSONNE" property="nom" />"</h1>
</logic:notEmpty>
	<html:form action="/verifAddOrUpdatePersonne.do">
		<table>
			<tr>
				<td>Prenom : </td>
				<td>
						<html:text property="prenom" />
				</td>
			</tr>
			<tr>
				<td>Nom : </td>
				<td>
						<html:text property="nom" />
				</td>
			</tr>
			<tr>
				<td>Date de naissance : </td>
				<td>
						<html:text property="naissance" />
				</td>
			</tr>
			<tr>
				<td>Lien vers la photo : </td>
				<td>
						<html:text property="photo" />
				</td>
			</tr>
		</table>
		<html:submit>Valider</html:submit>
	</html:form>
</body>
</html>