<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

    <h1>5 LATEST SOLUTIONS</h1>

    <table id="table_template">
        <tr>
            <th>Solution id</th>
            <th>Solution created</th>
            <th>Solution updated</th>
            <th>Solution description</th>
            <th>User id</th>
            <th>Exercise id</th>
        </tr>
        <c:forEach items="${solutions}" var="solution">
            <tr>
                <td>${solution.id}</td>
                <td>${solution.created}</td>
                <td>${solution.updated}</td>
                <td>${solution.description}</td>
                <td>${solution.users_id}</td>
                <td>${solution.exercise_id}</td>
            </tr>
        </c:forEach>
    </table>

    <h1>MANAGMENTS</h1>

    <p>
        <a href=<c:url value="groupManage"/> >Group manager</a>
        <a href=<c:url value="/META-INF/views/groupManage.jsp"/> >Group manager2</a>
    </p>
    <%--<p>--%>
        <%--<a href=<c:url value="userManage"/> >User manager</a>--%>
    <%--</p>--%>
    <%--<p>--%>
        <%--<a href=<c:url value="taskManage"/> >Task manager</a>--%>
    <%--</p>--%>

<%@include file="default/footer.jsp"%>