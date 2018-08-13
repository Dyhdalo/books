<%@include file="header.jsp"%>

<body>

	<h2 style="text-align: center">Number of books by genre</h2>
	
	<div style="text-align: left;">
		<span> <a href="<c:url value="/books" />"> Back to books page</a></span>
	</div>

	<hr />
	<br />

	<div>
		<table id="genreTable">
			<thead>
				<tr>
					<th>
						Genre
					</th>
					<th>
						Number of books
					</th>
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${booksByGenre}" var="book">
						<tr>
							<td>
								${book.genre}
							</td>
							<td>
								${book.numberOfBooks}
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</div>
	
<%@include file="footer.jsp"%>