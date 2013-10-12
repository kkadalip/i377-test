<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>

<br />
<c:forEach var="row" items="${requestScope[param.rowsKeyAsParam]}">
    ${row.text} <a href="?entity=${param.entity}&action=edit&id=${row.id}">muuda</a><br />
</c:forEach>
<br />


</body>
</html>