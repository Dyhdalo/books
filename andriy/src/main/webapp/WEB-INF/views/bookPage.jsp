<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<html lang="en">

	<head>
		<title>
			Create book
		</title>
	</head>
	
	<body style="text-align: center;">
		<span style="text-align: left;"> <a href="<c:url value="/books" />"> Back to books page</a></span>
		
		<hr />
		<c:if test="${empty update}">
			<c:url var="bookUrl" value="/books/new" />
		</c:if>
		
		<c:if test="${not empty update}">
			<c:url var="bookUrl" value="/books/id/${book.id}" />
		</c:if>
		
		<form:form acceptCharset="utf-8" modelAttribute="book" action="${bookUrl}"
				method='POST'>
				
				<form:label path="name">Name: </form:label>
				<form:input path="name" style="width: 50%;" type="text" maxlength="126" required="true" />
				<br /><br />
				
				<form:label path="published">Published: </form:label>
				<form:input path="published" type="date" required="true" />
				<br /><br />
				
				<form:label path="genre">Genre: </form:label>
				<form:input path="genre" style="width: 50%;" type="text" maxlength="64" required="true" />
				<br /><br />
				
				<form:label path="rating">Rating: </form:label>
				<form:input path="rating" style="width: 50%;" type="text" maxlength="1" required="true" />
				<br /><br />
				
				<input type="submit" value="Save">
		</form:form>
	</body>
</html>