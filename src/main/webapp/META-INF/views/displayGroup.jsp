<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

    <h1>AVAILABLE GROUPS</h1>

    <table id="table_template">
        <tr>
            <th>Group id</th>
            <th>Group name</th>
        </tr>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td>
                    <a href=<c:url value="/displayUser?group_id=${group.id}"/> >${group.id}</a>
                </td>
                <td>${group.name}</td>
            </tr>
        </c:forEach>
    </table>

<%@include file="default/footer.jsp"%>