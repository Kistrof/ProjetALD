<link rel=stylesheet type="text/css" href="http://127.0.0.1:8080/Web/styles/imdb.css">
<%@include file="./includes/header.jsp" %>
<h1><bean:message key="formajoutpro.titre"/></h1>
<html:form action="/AjoutPro.do">
 <label for="login"><bean:message key="formajoutpro.login"/></label>
 
 <html:text property="pseudo" />
	 <span class="spanError">
	 	<html:errors property="formrecherche.erreurs.champs_vide" />
	 	<html:errors property="login_doublon" />
	 </span>
 <br/>
 <label for="pass"><bean:message key="formajoutpro.pass"/></label>
<html:password property="pass"/>
 	<span class="spanError">
 		<html:errors property="pass"/>
 	</span>
<br/>
 <label for="pass"><bean:message key="formajoutpro.repass"/></label>
 <html:password property="repass"/>
 <span class="spanError">
 	<html:errors property="repass_erreur"/>
 	<html:errors property="repass_vide"/>
 </span>
 <br/>
 
<html:submit><bean:message key="formajoutpro.bouton_valider"/></html:submit>
</html:form>

<%@include file="./includes/footer.jsp" %>
