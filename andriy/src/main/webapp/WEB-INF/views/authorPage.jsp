<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<html lang="en">

	<head>
		<title>
			Create author
		</title>
	</head>
	
	<body style="text-align: center;">
		<span style="text-align: left;"> <a href="<c:url value="/authors" />"> Back to authors page</a></span>
		
		<hr />
		<c:if test="${empty update}">
			<c:url var="authorUrl" value="/authors/new" />
		</c:if>
		
		<c:if test="${not empty update}">
			<c:url var="authorUrl" value="/authors/id/${author.id}" />
		</c:if>
		
		<form:form acceptCharset="utf-8" modelAttribute="author" action="${authorUrl}"
				method='POST'>
				
				<form:label path="name">Name: </form:label>
				<form:input path="name" style="width: 50%;" type="text" maxlength="64" required="true" />
				<br /><br />
				
				<form:label path="gender">Gender: </form:label>
				<form:input path="gender" style="width: 50%;" type="text" maxlength="6" required="true" />
				<br /><br />
				
				<form:label path="born">Birthday: </form:label>
				<form:input path="born" type="date" required="true" />
				<br /><br />
				
				<input type="submit" value="Save">
		</form:form>
	</body>
</html>