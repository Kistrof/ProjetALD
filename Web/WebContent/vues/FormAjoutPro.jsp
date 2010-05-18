<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ajout pro</title>
</head>
<body>
<h1><bean:message key="formajoutpro.titre"/></h1>
<html:form action="/AjoutPro.do">
 <label for="login"><bean:message key="formajoutpro.login"/></label>
 <html:text property="pseudo" />
	 <span class="spanError">
	 	<html:errors property="login" />
	 </span>
 <br/>
 <label for="pass"><bean:message key="formajoutpro.pass"/></label>
<html:text property="pass"/>
 	<span class="spanError">
 		<html:errors property="pass"/>
 	</span>
<br/>
<html:submit><bean:message key="formajoutpro.bouton_valider"/></html:submit>
</html:form>

</body>
</html>