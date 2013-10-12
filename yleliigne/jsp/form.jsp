<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

  <c:if test="${not empty errors}">
    <div style="color:red">
      <c:forEach var="error" items="${errors}">
        <c:out value="${error}"></c:out><br />
      </c:forEach>
    </div>
    <br/><br/>
  </c:if>

  <form method="POST">

    Eesnimi: <input name="firstName" value="${param.firstName}"><br/>
    Perekonnanimi: <input name="name" value="${param.name}"><br/>
    Vanusegrupp:

    <select name="ageGroupId">
      <c:forEach var="entry" items="${formData.ageGroups}">
        <c:set var="selected" value="" scope="request"/>
        <c:if test="${entry.key == param.ageGroupId}">
          <c:set var="selected" value="selected=\"selected\"" scope="request"/>
        </c:if>
        <option value="${entry.key}" ${selected}>${entry.value}</option>
      </c:forEach>
    </select>

    <br/><br/>

    <input type="submit" value="Saada">

  </form>

</body>
</html>