
<link rel=stylesheet type="text/css" href="http://127.0.0.1:8080/Web/styles/imdb.css"/>
<%@include file="./includes/header.jsp" %>

<html:form action="/verifAddOrUpdatePersonne.do">
	
	<logic:empty name="PERSONNE">
		<h1>Ajouter une personne</h1>
	</logic:empty>
	<logic:notEmpty name="PERSONNE">
		<h1>Proposer des modifications sur la Personne "<bean:write name="PERSONNE" property="prenom" /> <bean:write name="PERSONNE" property="nom" />"</h1>
		<html:hidden property="id" name="PERSONNE" />
	</logic:notEmpty>
	
		<table>
			<tr>
				<td>Prenom : </td>
				<td>
					<logic:empty name="PERSONNE">
						<html:text property="prenom"  />
					</logic:empty>
					<logic:notEmpty name="PERSONNE">
							<html:text property="prenom"  name="PERSONNE" />
					</logic:notEmpty>
				</td>
			</tr>
			<tr>
				<td>Nom : </td>
				<td>
					<logic:empty name="PERSONNE">
						<html:text property="nom"  />
					</logic:empty>
					<logic:notEmpty name="PERSONNE">
							<html:text property="nom"  name="PERSONNE" />
					</logic:notEmpty>
				</td>
			</tr>
			<tr>
				<td>Date de naissance (yyyy-MM-dd): </td>
				<td>
					<logic:empty name="PERSONNE">
						<html:text property="naissance"  />
					</logic:empty>
					<logic:notEmpty name="PERSONNE">
							<html:text property="naissance"  name="PERSONNE" />
					</logic:notEmpty>
				</td>
			</tr>
			<tr>
				<td>Lien vers la photo : </td>
				<td>
					<logic:empty name="PERSONNE">
						<html:text property="photo"  />
					</logic:empty>
					<logic:notEmpty name="PERSONNE">
							<html:text property="photo"  name="PERSONNE" />
					</logic:notEmpty>
				</td>
			</tr>
		</table>
		<html:submit>Valider</html:submit>
	</html:form>

<%@include file="./includes/footer.jsp" %>