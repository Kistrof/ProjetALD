
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
				<td>
					<logic:empty name="FILM">
						<html:text property="titre"  />
					</logic:empty>
					<logic:notEmpty name="FILM">
							<html:text property="titre"  name="FILM" />
					</logic:notEmpty>
				</td>
			</tr>
			<tr>
				<td>Année de sortie : </td>
				<td>
					<logic:empty name="FILM">
						<html:text property="annee_sortie"  />
					</logic:empty>
					<logic:notEmpty name="FILM">
							<html:text property="annee_sortie"  name="FILM" />
					</logic:notEmpty>
				</td>
			</tr>
			<tr>
				<td>Coût du film : </td>
				<td>
					<logic:empty name="FILM">
						<html:text property="cout"  />
					</logic:empty>
					<logic:notEmpty name="FILM">
							<html:text property="cout"  name="FILM" />
					</logic:notEmpty>
				</td>
			</tr>
			<tr>
				<td>Lien vers l'affiche : </td>
				<td>
					<logic:empty name="FILM">
						<html:text property="affiche"  />
					</logic:empty>
					<logic:notEmpty name="FILM">
							<html:text property="affiche"  name="FILM" />
					</logic:notEmpty>
				</td>
			</tr>
			<tr>
				<td>Description : </td>
				<td>
					<logic:empty name="FILM">
						<html:textarea property="description" rows="5" cols="40" />
					</logic:empty>
					<logic:notEmpty name="FILM">
							<html:textarea property="description" name="FILM" rows="5" cols="40" />
					</logic:notEmpty>
				</td>
			</tr>
		</table>
		<html:submit>Valider</html:submit>
	</html:form>

<%@include file="./includes/footer.jsp" %>