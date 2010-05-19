<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Noter un film</title>
</head>
<body>
	<h1>Attribuer une note au film "<bean:write name="FILM" property="titre" />"</h1>
	<html:form action="/actionNoterFilm.do">
		<html:hidden property="id" name="FILM" />
		Donnez une note entre 0 et 10 : <html:text property="note" /><br/>
		<html:submit>Valider</html:submit>
	</html:form>
</body>
</html>