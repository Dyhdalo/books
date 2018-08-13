<%@include file="header.jsp"%>

<body>

	<h2 style="text-align: center">Books of nice authors</h2>
	
	<div style="text-align: left;">
		<span> <a href="<c:url value="/books" />"> Back to books page</a></span>
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
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${books}" var="book">
						<tr>
							<td>
								${book.name}
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
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</div>
	
<%@include file="footer.jsp"%>