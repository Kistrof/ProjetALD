<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>recherche</title>
</head>
<body>
	<html:form action="/Recherche.do">
		<label for="champsrecherche">
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
						<html:link action="/afficheFilm.do" paramId="id" paramName="Recherche" paramProperty="id"> 
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
						<html:link action="/afficheFilm.do" paramId="id" paramName="Recherche" paramProperty="id"> 
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
	<html:link action="/Accueil.do">
		<bean:message key="formrecherche.lien.retour_accueil"/>
	</html:link>
</center>
</body>
</html>