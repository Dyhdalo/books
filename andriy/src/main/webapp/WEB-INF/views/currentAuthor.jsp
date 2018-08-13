<%@include file="header.jsp"%>

<body>

	<h2 style="text-align: center"> ${author.id} Author</h2>
	
	<div style="text-align: left;">
		<span> <a href="<c:url value="/authors" />"> Back to authors page</a></span>
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
						Gender
					</th>
					<th>
						Birthday
					</th>
				</tr>
				</thead>
				<tbody>
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
				</tbody>
		</table>
	</div>
	
<%@include file="footer.jsp"%>