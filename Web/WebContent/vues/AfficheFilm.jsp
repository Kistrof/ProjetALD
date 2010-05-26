
<link rel=stylesheet type="text/css" href="http://127.0.0.1:8080/Web/styles/imdb.css"/>
<%@include file="./includes/header.jsp" %>

	<h1><bean:write name="FILM" property="titre" /></h1>
	Ann�e de sortie : <bean:write name="FILM" property="annee_sortie" /><br/>
	Cout : <bean:write name="FILM" property="cout" /><br/>
	Lien vers l'affiche : <bean:write name="FILM" property="affiche" /><br/>
	Description : <bean:write name="FILM" property="description" /><br/>
	Note : <bean:write name="FILM" property="note_moyenne" /><br/>
	Derni�re mise � jour : <bean:write name="FILM" property="date_maj" /><br/>
	<br/>
	R�compenses :<br/>
<logic:iterate id="recompense" name="FILM" property="recompenses">
	<bean:write name="recompense" property="prix" /><br/>
</logic:iterate>
	<br/>
	<b>Casting :</b><br/>
<logic:iterate id="acteur" name="FILM" property="acteurs">
	<bean:write name="acteur" property="prenom" /> <bean:write name="acteur" property="nom" /><br/>
</logic:iterate>
	<html:link action="/ajouterActeur" paramId="id" paramName="FILM" paramProperty="id" >Ajouter un acteur</html:link>
	<br/><br/>
	<b>Producteurs :</b><br/>
<logic:iterate id="producteur" name="FILM" property="producteurs">
	<bean:write name="producteur" property="prenom" /> <bean:write name="acteur" property="nom" /><br/>
</logic:iterate>
	<html:link action="/ajouterProducteur" paramId="id" paramName="FILM" paramProperty="id" >Ajouter un producteur</html:link>
	<br/><br/>
	<b>R�alisateurs :</b><br/>
<logic:iterate id="realisateur" name="FILM" property="realisateurs">
	<bean:write name="realisateur" property="prenom" /> <bean:write name="acteur" property="nom" /><br/>
</logic:iterate>
	<html:link action="/ajouterRealisateur" paramId="id" paramName="FILM" paramProperty="id" >Ajouter un r�alisateur</html:link><br/>
	<br/>

	<html:link action="/noterFilm" paramId="id" paramName="FILM" paramProperty="id" >Noter ce film</html:link>

<%@include file="./includes/footer.jsp" %>


