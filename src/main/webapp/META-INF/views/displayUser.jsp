<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

    <h1>AVAILABLE USERS</h1>

    <table>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <%--<td>--%>
                    <%--<a href=<c:url value="/displayUser?group_id=${group.id}"/> >DISPLAY USERS</a>--%>
                <%--</td>--%>

            </tr>
        </c:forEach>
    </table>

<%@include file="default/footer.jsp"%>