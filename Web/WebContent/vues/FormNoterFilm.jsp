<%@include file="./includes/header.jsp" %>
<link rel=stylesheet type="text/css" href="http://127.0.0.1:8080/Web/styles/imdb.css">
	<h1>Attribuer une note au film "<bean:write name="FILM" property="titre" />"</h1>
	<html:form action="/actionNoterFilm.do">
		<html:hidden property="id" name="FILM" />
		Donnez une note entre 0 et 10 : <html:text property="note" /><br/>
		<html:submit>Valider</html:submit>
	</html:form>
<%@include file="./includes/footer.jsp" %>
	