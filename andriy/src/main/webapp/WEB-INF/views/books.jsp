<%@include file="header.jsp"%>

<body>

	<h2 style="text-align: center">Book page</h2>
	
	<div style="text-align: right;">
		<span> <a href="<c:url value="/books/new" />"> Add</a></span>
	</div>

	<hr />
	<br />

	<div>
		<table id="bookTable">
			<thead>
				<tr>
					<th>
						Name
					</th>
					<th>
						Published
					</th>
					<th>
						Genre
					</th>
					<th>
						Rating
					</th>
					<th>
						Update
					</th>
					<th>
						Delete
					</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${books}" var="book">
						<tr>
							<td>
								<a href="<c:url value="/books/book/${book.id}" />"> ${book.name}</a>
							</td>
							<td>
								${book.published}
							</td>
							<td>
								${book.genre}
							</td>
							<td>
								${book.rating}
							</td>
							<td>
								<a href="<c:url value="/books/id/${book.id}" />"> Change</a>
							</td>
							<td>
								<a href="<c:url value="/books/id/${book.id}/delete" />"> Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</div>
	
	<br />
	
	<div style="text-align: center;">
		<a href="<c:url value="/books/niceAuthor" />"> Books of nice authors</a>
		<a href="<c:url value="/books/genre" />"> Books by genre</a>
	</div>
	
<%@include file="footer.jsp"%>