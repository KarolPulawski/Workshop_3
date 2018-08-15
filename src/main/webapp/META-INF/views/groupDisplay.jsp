<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

    <table id="table_template">
        <tr>
            <th>Group id</th>
            <th>Group name</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td>${group.id}</td>
                <td>${group.name}</td>
                <td>
                    <form action="/groupEdit" method="get">
                        <button type="submit" name="groupId" value="${group.id}" class="btn-link">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="/groupDelete" method="post">
                        <button type="submit" name="groupId" value="${group.id}" class="btn-link">Delete</button>
                    </form>

                </td>
            </tr>
        </c:forEach>
    </table>

    <h4>Add new group:</h4>
    <form action="/groupAdd" method="POST">
        <label>
            Group name:
            <input type="text" name="groupName">
        </label>
        <input type="submit">
    </form>

<%@include file="default/footer.jsp"%>