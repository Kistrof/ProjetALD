<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Erreurs</title>
</head>
<body>
	<h1>Erreurs rencontrées</h1>
	<html:errors/><br/>
	<br/>
	<html:link action="/Accueil">Retour à l'accueil</html:link>
</body>
</html:html>