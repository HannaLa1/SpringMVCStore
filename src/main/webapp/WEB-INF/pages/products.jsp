<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 31.10.2021
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products</title>

    <style>
        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 14px;
            border-collapse: collapse;
            text-align: center;
            margin-right: 280px;
        }

        th, td:first-child {
            background: #fca5cb;
            color: white;
            padding: 5px 20px;
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
<h1>StoreApp</h1>

<table align="right">
    <tr>
        <th>Id</th>
        <th>Name of product</th>
        <th>Price</th>
        <th>Date added</th>
        <th>Time added</th>
        <th colspan="2">Action</th>
    </tr>

    <c:forEach var="product" items="${productsList}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.localeDate}</td>
            <td>${product.localeTime}</td>
            <td><a href="<c:url value="/edit/${product.id}"/>">update</a></td>
            <td><a href="<c:url value="/delete/${product.id}"/>">delete</a></td>
        </tr>
    </c:forEach>
</table>

<c:url value="/find" var="find"/>
<form action="${find}" method="POST">
    <p><input type="search" name="name" placeholder="Find a product..." maxlength="30" required>
    <p>
        <c:set value="Search" var="find"/>
        <input type="submit" value="${find}">
    </p>
</form>

<br/>
<br/>
<h2>ACTIONS</h2>
<a href="<c:url value="/add"/>">Add a new product</a>
<br/>
<br/>

<a href="<c:url value="/filter"/>">Filter by price</a>
<br/>
<br/>

<a href="<c:url value="/sortPriceIncreasing"/>">Sort by price in ascending order</a>
<br/>
<br/>

<a href="<c:url value="/sortPriceDecreasing"/>">Sort by price in descending order</a>
<br/>
<br/>

<a href="<c:url value="/sortByOrder"/>">Sort by date of addition</a>
</body>
</html>
