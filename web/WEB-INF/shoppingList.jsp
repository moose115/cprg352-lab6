<%-- 
    Document   : shoppingList.jsp
    Created on : 2022-10-21, 22:40:25
    Author     : musta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="?action=logout">Logout</a></p>
        <form action="?action=add" method="POST">
            <h2>List</h2>
            <label>Add item:</label>
            <input name="item" />
            <button type="submit">Add</button>
        </form>
        <form action="?action=delete" method="POST">
            <c:forEach var="item" items="${items}" varStatus="loop">
                <input type="radio" name="item" value="${loop.index}" id="${item}-${loop.index}" />
                <label>${item}</label>
                </br>
            </c:forEach>
            <button type="submit">Delete</button>
        </form>
    </body>
</html>
