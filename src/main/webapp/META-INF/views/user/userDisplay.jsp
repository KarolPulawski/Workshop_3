<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../default/header.jsp"%>

<table id="table_template">
    <tr>
        <th>User id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Group id</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.user_group_id}</td>

            <td>
                <form action="/userEdit" method="get">
                    <button type="submit" name="userId" value="${user.id}" class="btn-link">Edit</button>
                </form>
            </td>
            <td>
                <form action="/userDelete" method="post">
                    <button type="submit" name="userId" value="${user.id}" class="btn-link">Delete</button>
                </form>

            </td>
        </tr>
    </c:forEach>
</table>

<h4>Add new user:</h4>
<form action="/userAdd" method="POST">
    <label>
        New user name:
        <input type="text" name="userName">
    </label></br>
    <label>
        New email:
        <input type="text" name="userEmail">
    </label></br>
    <label>
        New user password:
        <input type="password" name="userPassword">
    </label></br>
    <label>
        New user group:
        <input type="number" name="userGroupId">
    </label></br>
    <input type="submit">
</form>

<%@include file="../default/footer.jsp"%>