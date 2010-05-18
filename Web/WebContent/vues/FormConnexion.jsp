<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>connexion</title>
</head>
<body>
<h1><bean:message key="formconnexion.titre" /></h1>
	<html:form action="/VerifLogin.do">
	<table>
		<tr>
			<td>
				<bean:message key="formconnexion.label_login"/>
			</td>
			<td>
				<html:text property="login" />
					<span class="spanError">
						<html:errors property="login"/>
					</span>	
			</td>
		</tr>
		<tr>
			<td>
				<bean:message key="formconnexion.label_mdp"/>
			</td>
			<td>
				<html:password property="pass" />
					<span class="spanError">
						<html:errors property="pass"/>
					</span>	
			</td>
		</tr>
		<tr colspan="2">
			<td>
				<html:submit>valider</html:submit>
			</td>
		</tr>
	</table>
	</html:form>
</body>
</html>