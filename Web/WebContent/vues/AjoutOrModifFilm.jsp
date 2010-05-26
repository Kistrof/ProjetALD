
<link rel=stylesheet type="text/css" href="http://127.0.0.1:8080/Web/styles/imdb.css"/>
<%@include file="./includes/header.jsp" %>

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

<%@include file="./includes/footer.jsp" %>