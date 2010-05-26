<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajouter un film � un producteur</title>
</head>
<body>
Ajouter un film au producteur <bean:write name="PERSONNE" property="prenom" /> <bean:write name="PERSONNE" property="nom" />
<html:form action="/actionAjouterPersonneToFilm.do" >
	<html:hidden property="codeProducteur" name="PERSONNE" value="id" />
	<html:hidden property="FromFilm" value="false" />
	<html:select property="id">
		<html:options collection="FILMS" labelProperty="titre" property="id" />
	</html:select>
	<html:submit>Ajouter</html:submit>
</html:form>
</body>
</html>