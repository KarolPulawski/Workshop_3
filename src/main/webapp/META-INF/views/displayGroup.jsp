<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

    <h1>AVAILABLE GROUPS</h1>

    <table>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td>${group.name}</td>
                <td>
                    <a href=<c:url value="/displayUser?group_id=${group.id}"/> >DISPLAY USERS</a>
                </td>

            </tr>
        </c:forEach>
    </table>

<%@include file="default/footer.jsp"%>