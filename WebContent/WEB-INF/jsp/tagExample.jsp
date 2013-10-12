<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>

<c:forEach begin="1" end="10">
  Hello world!<br />
</c:forEach>

<br />

<c:set var="var1" value="world" />
Hello, ${var1}!

<br />

<c:set var="var1" value="world"/>

<br />

<c:set var="test" value="true" />
<c:if test="${test}">
  In if statement
</c:if>

<br />

<% pageContext.setAttribute("elements", new String[] {"yks", "kaks", "kolm"}); %>
<c:forEach items="${elements}"
           var="element"
           varStatus="status">
  ${element} - ${status.first}<br />
</c:forEach>

<br />

<jsp:include page="menu.jsp" />

<br />

<a href="<c:url value="/Home" />">Home</a>
<br />
<c:url value="/Home" var="homeLink"/>
<a href="${homeLink}">Home</a>
<br />

UserName is <%= request.getParameter("userName") %>

<br />

<%-- Comment --%> vs <!-- This is an HTML comment -->

Hello <% System.out.println("world"); %>

Today's date is <%= new java.util.Date() %>

</body>
</html>