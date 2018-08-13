<%@include file="header.jsp"%>

<body>

	<h2 style="text-align: center"> ${authorBook.id} Author with book</h2>
	
	<div style="text-align: left;">
		<span> <a href="<c:url value="/authors/books" />"> Back to authors with books page</a></span>
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
				</tr>
				</thead>
				<tbody>
						<tr>
							<td>
								${authorBook.author.name}
							</td>
							<td>
								${authorBook.book.name}
							</td>
						</tr>
				</tbody>
		</table>
	</div>
	
<%@include file="footer.jsp"%>