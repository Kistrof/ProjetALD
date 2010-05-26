<link rel=stylesheet type="text/css" href="http://127.0.0.1:8080/Web/styles/imdb.css"/>
<%@include file="./includes/header.jsp" %>

	<html:form action="/Recherche.do">
		<label for="champsrecherche" class="rechercheFilm">
			<logic:empty name="PRO" scope="session">
				<bean:message key="formrecherche.label_recherche_session_non_active"/>
			</logic:empty>
			<logic:notEmpty name="PRO" scope="session">
				<bean:message key="formrecherche.label_recherche_session_active"/>
			</logic:notEmpty>
		</label>
		<html:text property="champRecherche"/>
		<html:submit>
			<bean:message key="formrecherche.bouton_submit"/>
		</html:submit>
		<span class="spanErrors">
			<html:errors property="recherche_vide" />
		</span>
	</html:form>
	
	<logic:empty name="PRO" scope="session">
		<logic:notEmpty name="RECHERCHE_FILM" scope="request">
			<bean:message key="rechercheform.message_affiche_list_film"/>
			<bean:write name="CHAINE_RECHERCHE" scope="request"/>'
			<ul>
				<logic:iterate id="Recherche" name="RECHERCHE_FILM" scope="request">
					<li>
					<bean:write name="Recherche" property="titre"/>
					</li>
				</logic:iterate>
			</ul>
		</logic:notEmpty>
	</logic:empty>
	
	<logic:notEmpty name="PRO" scope="session">
		<logic:notEmpty name="RECHERCHE_FILM" scope="request">
			<bean:message key="rechercheform.message_affiche_list_film"/>
			<bean:write name="CHAINE_RECHERCHE" scope="request"/>'
			<ul>
				<logic:iterate id="Recherche" name="RECHERCHE_FILM" scope="request">
					<li>
						<html:link action="/AfficheFilm.do" paramId="id" paramName="Recherche" paramProperty="id"> 
						<bean:write name="Recherche" property="titre"/>
						</html:link>
					</li>
				</logic:iterate>
			</ul>
		</logic:notEmpty >
		<br/>
		<logic:notEmpty  name="RECHERCHE_PERSONNE" scope="request">
			<bean:message key="rechercheform.message_affiche_list_personnes"/>
			<bean:write name="CHAINE_RECHERCHE" scope="request"/>'
			<ul>
				<logic:iterate id="Recherche" name="RECHERCHE_PERSONNE" scope="request">
					<li>
						<html:link action="/AffichePersonne.do" paramId="id" paramName="Recherche" paramProperty="id"> 
							<bean:write name="Recherche" property="prenom"/>
							&nbsp;
							<bean:write name="Recherche" property="nom"/>
						</html:link>
					</li>
				</logic:iterate>
			</ul>
		</logic:notEmpty>
	</logic:notEmpty>
	
<br/>
<center>

</center>
<%@ include file="./includes/footer.jsp" %>