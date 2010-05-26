<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>

<logic:empty name="PRO" scope="session">
	
		<html:form action="/VerifLogin.do" styleId="formulaire_connexion">
		<fieldset>
			<label class="inline" for="login">
				<bean:message key="formconnexion.label_login"/>
			</label>
			<html:text property="login" styleClass="petitChamp"   /> 
			
			
			<br/>
			<label class="inline"  for="pass">
				<bean:message key="formconnexion.label_mdp"/>
			</label>
			<html:password property="pass" styleClass="petitChamp" />
				
					<div id="div_boutons_submit">
						<html:submit>ok</html:submit>
					</div>
		</fieldset>
		</html:form>

</logic:empty>
<logic:notEmpty name="PRO"  scope="session">
	<span id="zone_connecte">
	  <bean:message key="formconnexion.message_connecte"/>
	 <bean:write name="PRO" scope="session" property="pseudo"/>
	 <br/>
	 <html:link action="/Deconnecte.do">
 	   <bean:message key="formconnexion.nom_lien_deconnecte" />
 	  </html:link>
	</span>
</logic:notEmpty>
