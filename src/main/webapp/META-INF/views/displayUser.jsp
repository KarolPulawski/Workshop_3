<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>
<link rel = "stylesheet" href="/META-INF/views/css/table.css">

    <h1>AVAILABLE USERS</h1>

    <table id="table_template">
        <tr>
            <th>User id</th>
            <th>User name</th>
            <th>User email</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                    <a href=<c:url value="/displaySolution?user_id=${user.id}"/> >${user.id}</a>
                </td>
                <td>${user.username}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>

<%@include file="default/footer.jsp"%>