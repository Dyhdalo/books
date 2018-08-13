<%@include file="header.jsp"%>

<body>

	<h2 style="text-align: center">Author page</h2>
	
	<div style="text-align: right;">
		<span> <a href="<c:url value="/authors/new" />"> Add</a></span>
	</div>

	<hr />
	<br />

	<div>
		<table id="authorTable">
			<thead>
				<tr>
					<th>
						Name
					</th>
					<th>
						Gender
					</th>
					<th>
						Birthday
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
					<c:forEach items="${authors}" var="author">
						<tr>
							<td>
								<a href="<c:url value="/authors/author/${author.id}" />"> ${author.name}</a>
							</td>
							<td>
								${author.gender}
							</td>
							<td>
								${author.born}
							</td>
							<td>
								<a href="<c:url value="/authors/id/${author.id}" />"> Change</a>
							</td>
							<td>
								<a href="<c:url value="/authors/id/${author.id}/delete" />"> Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</div>
	
	<br />
	
	<div style="text-align: center;">
		<a href="<c:url value="/authors/older55" />"> Older 55</a>
		<a href="<c:url value="/authors/greatestAuthor" />"> Authors with most books</a>
	</div>
	
<%@include file="footer.jsp"%>