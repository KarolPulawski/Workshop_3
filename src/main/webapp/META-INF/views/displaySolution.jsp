<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="default/header.jsp"%>

    <h1>AVAILABLE SOLUTIONS</h1>

    <table id="table_template">
        <tr>
            <th>Solution id</th>
            <th>Solution created</th>
            <th>Solution updated</th>
            <th>Solution description</th>
        </tr>
        <c:forEach items="${solutions}" var="solution">
            <tr>
                <td>
                    <a href=<c:url value="/displayExercise?exercise_id=${solution.exercise_id}"/> >${solution.id}</a>
                </td>
                <td>${solution.created}</td>
                <td>${solution.updated}</td>
                <td>${solution.description}</td>
                <td>${solution.exercise_id}</td>
            </tr>
        </c:forEach>
    </table>



<%@include file="default/footer.jsp"%>