<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

    <h1>EXERCISE</h1>


        <h2>${exercise.id}    ${exercise.description}</h2>


    <table id="table_template">
        <tr>
            <th>Solution id</th>
            <th>Solution created</th>
            <th>Solution updated</th>
            <th>Solution description</th>
            <th>User name</th>
            <th>User email</th>
        </tr>
        <c:forEach items="${solutions}" var="solution">
            <tr>
                <%--<td>--%>
                    <%--<a href=<c:url value="/displayExercise?exercise_id=${solution.exercise_id}"/> >${solution.id}</a>--%>
                <%--</td>--%>
                <td>${solution.id}</td>
                <td>${solution.created}</td>
                <td>${solution.updated}</td>
                <td>${solution.description}</td>

                    <c:forEach items="${users}" var="user">
                        <c:if test="${solution.users_id == user.id}">
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                        </c:if>
                    </c:forEach>

            </tr>
        </c:forEach>
    </table>


<%@include file="default/footer.jsp"%>