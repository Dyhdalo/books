<%@include file="header.jsp"%>

<body>

	<h2 style="text-align: center">Authors older than 55</h2>
	
	<div style="text-align: left;">
		<span> <a href="<c:url value="/authors" />"> Back to authors page</a></span>
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
				</tr>
				</thead>
				<tbody>
					<c:forEach items="${authors}" var="author">
						<tr>
							<td>
								${author.name}
							</td>
							<td>
								${author.gender}
							</td>
							<td>
								${author.born}
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
	</div>
	
<%@include file="footer.jsp"%>