<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>4. Harjutustund</title>
<style type="text/css">
.even {
	color: red;
}
</style>

</head>
<body>
	<form method="post" action="<c:url value='Ex4'/>">
		<%-- ex4.jsp post ei saada servleti Ex4 peale  --%>
		<select name="listName">
			<option value="" />
			<%-- 2. dropdowni kood tuleb siia  --%>
			<c:forEach items="odd, even" var="each">

				<c:if test="${each.equals(param.listName)}">
					<c:set var="selected" value="selected='selected'" scope="request"></c:set>
				</c:if>
				<option ${selected} value="${each}">${each}</option>
			</c:forEach>
		</select> <input type="submit" value="Värskenda">
	</form>

<%-- EKSAMIL KÕIKE SAMA ASJA VAJA TEHA, PUNASE LAHENDAMISEST ÕPIOBJEKTIS JUTTU --%>

	<%-- -${sessionScope[param.listNAme]}- --%>
	<%-- -${param.listName}- --%>
	<%-- 1. kuvamise kood tuleb siia --%>
	<c:forEach items="${sessionScope['listName']}" var="each" varStatus="status">
		<%-- odd asemel listname wut    nüüd requestScope, nüüd sessionScope --%>
		<%-- ctrl tühik --%>
		<c:set var="clazz" value="" scope="request"></c:set>
		<%-- kui paarisarv --%>
		<c:if test="${status.count % 2 == 0}">
			<%-- kas esimene, viimane, count, etc --%>
			<c:set var="clazz" value="even" scope="request"></c:set>
		</c:if>
		<div class="${clazz}">${each.key}.${each.value}.</div>
	</c:forEach>
</body>
</html>