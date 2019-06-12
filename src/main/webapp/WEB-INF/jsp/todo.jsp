<%@ include file="common/header.jspf"%>
<%@ include file="common/nav.jspf"%>

<body>
	<div class="container">
		<form:form method="post" modelAttribute="todo">
			<fieldset class="form-group">
				<form:hidden path="id" />
				<form:label path="desc">Description</form:label>
				<form:input type="text" path="desc" class="form-control"
					placeholder="Plz enter desc" required="true"></form:input>
				<form:errors path="desc" cssClass="text-warning"></form:errors>
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" id="targetDate" path="targetDate"
					class="form-control" required="true"></form:input>
				<form:errors path="targetDate" cssClass="text-warning"></form:errors>
			</fieldset>
			<button class="btn btn-success" type="submit">Add</button>
		</form:form>
		<%-- <p>welcome ${name} </p> --%>
	</div>
	
	<%@ include file="common/footer.jspf"%>