<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<html lang="en">

	<head>
		<title>
			Book with author (create/update)
		</title>
	</head>
	
	<body style="text-align: center;">
		<span style="text-align: left;"> <a href="<c:url value="/authors/books" />"> Back to authors with books page</a></span>
		
		<hr />
		<c:if test="${empty update}">
			<c:url var="authorUrl" value="/authors/books/new" />
		</c:if>
		
		<c:if test="${not empty update}">
			<c:url var="authorUrl" value="/authors/books/id/${authorWithBook.id}" />
		</c:if>
		
		<form:form acceptCharset="utf-8" modelAttribute="authorWithBook" action="${authorUrl}"
				method='POST'>
				
				<form:label path="author">Author: </form:label>
				<form:select path="author" required="true">
					<c:if test="${empty update}">
						<form:option value="NONE" label="--- Select author ---" />
					</c:if>
					<c:if test="${not empty update}">
						<form:option value="${authorWithBook.author.id}" label="${authorWithBook.author.name}" />
					</c:if>
						<form:options items="${authors}" />
				</form:select>
				<br /><br />
				
				<form:label path="book">Book: </form:label>
				<form:select path="book" required="true">
					<c:if test="${empty update}">
						<form:option value="NONE" label="--- Select book ---" />
					</c:if>
					<c:if test="${not empty update}">
						<form:option value="${authorWithBook.book.id}" label="${authorWithBook.book.name}" />
					</c:if>
						<form:options items="${books}" />
				</form:select>
				<br /><br />
				
				<input type="submit" value="Save">
		</form:form>
	</body>
</html>