<%@include file="header.jsp"%>

<body>

	<h2 style="text-align: center">Author with Book page</h2>
	
	<div style="text-align: right;">
		<span> <a href="<c:url value="/authors/books/new" />"> Add</a></span>
	</div>

	<hr />
	<br />

	<div>
		<table id="authorBookTable">
			<thead>
				<tr>
					<th>
						Author
					</th>
					<th>
						Book
					</th>
					<th>
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
					<c:forEach items="${authorsWithBooks}" var="authorWithBook">
						<tr>
							<td>
								${authorWithBook.author.name}
							</td>
							<td>
								${authorWithBook.book.name}
							</td>
							<td>
								<a href="<c:url value="/authors/books/author/book/${authorWithBook.id}" />"> View</a>
							</td>
							<td>
								<a href="<c:url value="/authors/books/id/${authorWithBook.id}" />"> Change</a>
							</td>
							<td>
								<a href="<c:url value="/authors/books/id/${authorWithBook.id}/delete" />"> Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</div>
	
<%@include file="footer.jsp"%>