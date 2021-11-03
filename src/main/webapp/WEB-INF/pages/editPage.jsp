<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 31.10.2021
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <c:if test="${empty product.name}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty product.name}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty product.name}">
    <c:url value="/add" var="add"/>
</c:if>
<c:if test="${!empty product.name}">
    <c:url value="/edit" var="update"/>
</c:if>
<form action="${empty product.name ? add : update}" id="product" name="product" method="POST">
    <c:choose>
        <c:when test="${!empty product.name}">
            <p>EDIT PRODUCT PAGE</p>
            <input type="hidden" name="id" value="${product.id}">
        </c:when>
        <c:otherwise>
            <p>ADD PRODUCT PAGE</p>
        </c:otherwise>
    </c:choose>
    <p><input type="text" name="name" placeholder="name" value="${product.name}">
    <p><input type="number" name="price" placeholder="price" value="${product.price}">
    <p>
        <c:set value="Add" var="add"/>
        <c:set value="Update" var="update"/>
        <input type="submit" value="${empty product.name ? add : update}">
    </p>
    <a href="<c:url value="/"/>">Back</a>

    <c:choose>
        <c:when test="${!empty(product.name) and product.price!=null}">
            <h1>Error caused!</h1>
            <p> <spring:hasBindErrors name="product">
                <c:forEach var="error" items="${errors.allErrors}">
                    <b><spring:message message="${error}"/></b>
                    <br/>
                    <br/>
                </c:forEach>
            </spring:hasBindErrors></p>
        </c:when>
        <c:otherwise>
            <p>INPUT PARAMETERS FOR PRODUCT</p>
        </c:otherwise>
    </c:choose>
</form>
</body>
</html>
