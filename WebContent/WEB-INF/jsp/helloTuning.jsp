<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head></head>
<body>
<%

  for (int i = 0; i < 10; i++) {
    out.println("Hello world!<br />");
  }

%>

<c:forEach begin="1" end="10">
  <c:out value="Hello world!" /><br />
</c:forEach>

</body>
</html>