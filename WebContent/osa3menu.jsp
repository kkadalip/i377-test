<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<ul id="menu">
    <li><a href="Search" id="menu_Search">Otsi</a></li>
    <li><a href="Add" id="menu_Add">Lisa</a></li>
    <li><a href="Admin?do=clear_data" id="menu_ClearData">Tühjenda</a></li>
    <li><a href="Admin?do=insert_data" id="menu_InsertData">Sisesta näidisandmed</a></li>
</ul>
<br /><br /><br />

</body>
</html>