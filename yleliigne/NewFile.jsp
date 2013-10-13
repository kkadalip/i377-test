
	<br />
	<br />
	<br />

	<form method="get" action="${searchLink}">
		<input name="searchString" id="searchStringBox" value="" /> <input
			type="submit" id="filterButton" value="Filtreeri" /> <br /> <br />
		<table class="listTable" id="listTable">
			<thead>
				<tr>
					<th scope="col">Nimi</th>
					<th scope="col">Kood</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope['unitsList']}" var="item">
					<tr>
							<td>
								<div id="row_${item.code}">${item.name}</div>
						</td>
							<td>${item.code}</td>
							<td><a href="/part3example/Search?do=delete&id=${unit.id}"
								id="delete_${unit.code}">Kustuta</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>