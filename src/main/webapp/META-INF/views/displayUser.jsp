<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

    <h1>AVAILABLE USERS</h1>

    <table>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td>
                    <ul>
                        <c:forEach items="${solutions}" var = "solution">

                                <c:if test = "${solution.users_id == user.id}">
                                    <li>
                                        <c:out value=" ${solution.users_id} "/>
                                        <c:out value=" ${solution.updated} "/>
                                        <%--<c:out value=" ${solution.description} "/>--%>
                                        <c:out value=" ${user.id} "/>

                                        <a href=<c:url value="/displayUser?group_id=${group.id}"/> >DISPLAY DETAILS</a>
                                    </li>
                                </c:if>
                                <%--<c:out value=" ${solution.users_id} "/>--%>
                                <%--<c:out value=" ${user.id} "/>--%>
                                <%--<c:out value="TEST" />--%>

                        </c:forEach>
                    </ul>
                </td>
                <%--<td>--%>
                    <%--<a href=<c:url value="/displayUser?group_id=${group.id}"/> >DISPLAY USERS</a>--%>
                <%--</td>--%>

            </tr>
        </c:forEach>
    </table>

<%@include file="default/footer.jsp"%>