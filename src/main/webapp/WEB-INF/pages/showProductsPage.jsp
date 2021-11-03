<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 31.10.2021
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Result products</title>

    <style>
        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 14px;
            border-collapse: collapse;
            text-align: center;
        }
        th, td:first-child {
            background: #fca5cb;
            color: white;
            padding: 5px 15px;
        }
        th, td {
            border-style: solid;
            border-width: 0 1px 1px 0;
            border-color: white;
        }
        td {
            border-color: whitesmoke;
        }
        th:first-child, td:first-child {
            text-align: left;
        }
    </style>
</head>
<body>
<h2>RESULT PRODUCTS:</h2>
<a href="<c:url value="/"/>">Back to main page</a>
<br/>
<br/>

<table>
    <tr>
        <th>Id</th>
        <th>Name of product</th>
        <th>Price</th>
        <th>Date added</th>
        <th>Time added</th>
    </tr>

    <c:forEach var="product" items="${productsList}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.localeDate}</td>
            <td>${product.localeTime}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
