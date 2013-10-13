<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/" var="base" />
<c:url value="Osa3" var="homeLink" />
<c:url value="Search" var="searchLink" />
<c:url value="Add" var="addLink" />
<c:url value="Admin" var="adminLink" />

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
    <li><a href="${searchLink}" id="menu_Search">Otsi</a></li>
    <li><a href="${addLink}" id="menu_Add">Lisa</a></li> <%-- /part3example/Add --%>
    <li><a href="${adminLink}?do=clear_data" id="menu_ClearData">Tühjenda</a></li> <%-- /part3example/Admin?do=clear_data --%>
    <li><a href="${adminLink}?do=insert_data" id="menu_InsertData">Sisesta näidisandmed</a></li> <%-- /part3example/Admin?do=insert_data --%>
</ul>

<br /><br /><br />

<form method="get" action="${searchLink}">
  <input name="searchString" id="searchStringBox" value=""/>
  <input type="submit" id="filterButton" value="Filtreeri" />
<br /><br />
<table class="listTable" id="listTable">
    <thead>
      <tr>
          <th scope="col">Nimi</th>
          <th scope="col">Kood</th>
          <th scope="col"></th>
        </tr>
    </thead>
    <tbody>
    
        <tr>
          <td>
            <div id="row_1-1-1">Legal</div>
          </td>
          <td>
            1-1-1
          </td>
          <td>
            
            <a href="/part3example/Search?do=delete&id=931" id="delete_1-1-1">Kustuta</a>
          </td>
        </tr>
    
        <tr>
          <td>
            <div id="row_1-2">Production</div>
          </td>
          <td>
            1-2
          </td>
          <td>
            
            <a href="/part3example/Search?do=delete&id=933" id="delete_1-2">Kustuta</a>
          </td>
        </tr>
    
        <tr>
          <td>
            <div id="row_1-1-1">Legal</div>
          </td>
          <td>
            1-1-1
          </td>
          <td>
            
            <a href="/part3example/Search?do=delete&id=937" id="delete_1-1-1">Kustuta</a>
          </td>
        </tr>
    
        <tr>
          <td>
            <div id="row_1-1-2">Archives</div>
          </td>
          <td>
            1-1-2
          </td>
          <td>
            
            <a href="/part3example/Search?do=delete&id=938" id="delete_1-1-2">Kustuta</a>
          </td>
        </tr>
    
        <tr>
          <td>
            <div id="row_1-2">Production</div>
          </td>
          <td>
            1-2
          </td>
          <td>
            
            <a href="/part3example/Search?do=delete&id=939" id="delete_1-2">Kustuta</a>
          </td>
        </tr>
    
        <tr>
          <td>
            <div id="row_2">Sales</div>
          </td>
          <td>
            2
          </td>
          <td>
            
            <a href="/part3example/Search?do=delete&id=940" id="delete_2">Kustuta</a>
          </td>
        </tr>
    
    </tbody>
</table>
</form>
</body>
</html>