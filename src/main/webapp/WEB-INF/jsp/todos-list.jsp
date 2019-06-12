<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>
<body>
	<div class="container">
		Hi ${name}, <br />
		<table class="table table-striped">
			<caption style="caption-side: top; text-align: center">Your
				Todos</caption>
			<thead>
				<tr>
					<th>Description</th>
					<th>Targate Date</th>
					<th>Is it Done?</th>
					<th></th>
					<th></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate}"
								pattern="dd/MM/yyyy" /></td>
						<td>${todo.isDone}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-todo?id=${todo.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-todo?id=${todo.id}">delete</a></td>
					</tr>
				</c:forEach>
		</table>
		<div>
			<a class="button" href="/add-todo">Add todo</a>
		</div>
		</body>
<%@ include file="common/footer.jspf"%>