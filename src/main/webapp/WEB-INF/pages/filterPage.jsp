<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 31.10.2021
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Filter by price</title>
</head>
<body>
<h2>FILTER PRODUCTS BY PRICE PAGE</h2>
<c:url value="/filter" var="var"/>
<form action="${var}" method="post">
    <p><input type="number" name="from" placeholder="from" min="1" required>
    <p><input type="number" name="to" placeholder="to" min="2" required>
    <p><input type="submit" value="Filter"></p>
    <a href="<c:url value="/"/>">Back</a>
</form>
</body>
</html>
