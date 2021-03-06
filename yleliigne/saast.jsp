<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <%@include file="/static/style.css"%> --%>
<%-- <c:set var="test" value="test" /> --%>

<%--<c:url value="/osa3" var="homeLink" />--%>
<c:url value="Osa3" var="homeLink" />
<c:url value="/" var="base" />
<%-- base on src --%>
<%--<c:url value="/osa3/osa3.jsp" var="jsp" />--%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Part 3</title>

<style type="text/css">
<!--
@import url("${base}/static/style.css");
-->
</style>
</head>

<body>
	<form method="post" action="<c:url value='Osa3'/>">
		<select name="listName">
			<option value="" />
			<c:forEach items="unit, swag" var="each">

				<%--et oleks by default selected midagi --%>
				<c:set var="selected" value="" scope="request" />
				<c:if test="${each.equals(param.listName)}">
					<c:set var="selected" value="selected='selected'" scope="request"></c:set>
				</c:if>

				<option ${selected} value="${each}">${each}</option>
			</c:forEach>
		</select> <input type="submit" value="Värskenda" />
	</form>

	<c:forEach items="${requestScope[param.listName]}" var="each"
		varStatus="status">
		<c:set var="clazz" value="" scope="request" />
		<c:if test="${status.count % 2 == 0}">
			<c:set var="clazz" value="unit" scope="request"></c:set>
		</c:if>

		<c:set var="clazz" value="swag" scope="request"></c:set>
		<div class="${clazz}">${each.key}.${each.value}.</div>
	</c:forEach>

	-${requestScope[param.listName]}- swag
	-${sessionScope[param.listName]}-
	
	-${requestScope['unitsList']}- 
	
	<c:forEach items="${requestScope[param.listName]}" var="each">
		${each.key}. ${each.value}.<br />
	</c:forEach>

	<form method="get" action="${homeLink}"></form>
	<br />
	<br />
	<br />

	<ul id="menu">
		<li><a href="${homeLink}/Search" id="menu_Search">Otsi</a></li>
		<li><a href="${homeLink}/Add" id="menu_Add">Lisa</a></li>
		<li><a href="${homeLink}/Admin?do=clear_data" id="menu_ClearData">Tühjenda</a></li>
		<li><a href="${homeLink}/Admin?do=insert_data"
			id="menu_InsertData">Sisesta näidisandmed</a></li>
	</ul>
	<br />
	<br />
	<br />

	<%-- pageContext, pageScope --%>
	<c:forEach items="${requestScope['unitMap']}" var="each">
		
			${each.key}. ${each.value}<br />
	</c:forEach>
	<%--
		<c:forEach items="defaultValues" var="each">
			<c:set var="selected" value="selected='selected'" scope="request"></c:set>
			<option ${selected} value="${each}">${each}</option>
			<c:out value="${each}"></c:out>
			<c:out value="${param.listName}"></c:out>
			<c:out value="${selected}"></c:out>
		</c:forEach>
		--%>

	<%-- DROPDOWNI KOOD --%>


	<form method="post" action="${homeLink}">
		<%-- osa3.jsp post ei saada servleti Osa3 peale  --%>
		<select name="listName">
			<option value="" />
			<%-- 2. dropdowni kood tuleb siia  --%>
			<c:forEach items="defaultValues" var="each">
				<c:if test="${each.equals(param.listName)}">
					<c:set var="selected" value="selected='selected'" scope="request"></c:set>
				</c:if>
				<option ${selected} value="${each}">${each}</option>
			</c:forEach>
		</select> <input type="submit" value="Värskenda" />
	</form>

	${sessionScope[param.listNAme]} ${param.listName}
	<%-- -${sessionScope[param.listNAme]}- --%>
	<%-- -${param.listName}- --%>
	<%-- 1. kuvamise kood tuleb siia --%>
	<c:forEach items="${sessionScope['listName']}" var="each"
		varStatus="status">
		<%-- odd asemel listname wut    nüüd requestScope, nüüd sessionScope --%>
		<%-- ctrl tühik --%>
		<c:set var="clazz" value="" scope="request"></c:set>
		<c:if test="${status.count % 2 == 0}">
			<%-- kas esimene, viimane, count, etc --%>
			<c:set var="clazz" value="defaultValues" scope="request"></c:set>
		</c:if>
		<div class="${clazz}">${each.key}.${each.value}.</div>
	</c:forEach>

	<c:forEach items="${sessionScope['listName']}" var="each"
		varStatus="status">
		<c:set var="asd" value="defaultValues" scope="request"></c:set>
		<div class="${asd}">${each.key}.${each.value}.</div>

		<c:out value="${each}"></c:out>
	</c:forEach>

	<form method="get" action="${homeLink}/Search">
		<input name="searchString" id="searchStringBox"
			value="${param.filterText}" /> <input type="submit"
			id="filterButton" value="Filtreeri" /> <br /> <br />
		<table class="listTable" id="listTable">
			<thead>
				<tr>
					<th scope="col">Nimi</th>
					<th scope="col">Kood</th>
					<th scope="col"></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${sessionScope['listName']}" var="each"
					varStatus="status">
					<%-- odd asemel listname wut    nüüd requestScope, nüüd sessionScope --%>
					<%-- ctrl tühik --%>
					<c:set var="clazz" value="" scope="request"></c:set>
					<div class="${clazz}">${each.key}.${each.value}.</div>
				</c:forEach>
			</tbody>
		</table>



	<c:forEach var="swag" items="${swagMap}">
    	Key: ${swagMap.key}  - Value: ${swagMap.value}
	</c:forEach>

		-
		<table>
			<c:forEach items="${unitList}" var="unit">
				<tr>
					<td>${unit.id}</td>
					<td>${unit.name}</td>
					<td>${unit.code}</td>
				</tr>
			</c:forEach>
		</table>
		-



	</form>
</body>
</html>
