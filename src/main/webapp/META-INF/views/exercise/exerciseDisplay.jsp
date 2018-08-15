<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../default/header.jsp"%>

<table id="table_template">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>

    </tr>
    <c:forEach items="${exercises}" var="exercise">
        <tr>
            <td>${exercise.id}</td>
            <td>${exercise.title}</td>
            <td>${exercise.description}</td>
            <td>
                <form action="/exerciseEdit" method="get">
                    <button type="submit" name="exerciseId" value="${exercise.id}" class="btn-link">Edit</button>
                </form>
            </td>
            <td>
                <form action="/exerciseDelete" method="post">
                    <button type="submit" name="exerciseId" value="${exercise.id}" class="btn-link">Delete</button>
                </form>

            </td>
        </tr>
    </c:forEach>
</table>

<h4>Add new exercise:</h4>
<form action="/exerciseAdd" method="POST">
    <label>
        Exercise title:
        <input type="text" name="exerciseTitle">
    </label></br>
    <label>
        Exercise description:
        <input type="text" name="exerciseDescription">
    </label></br>
    <input type="submit">
</form>

<%@include file="../default/footer.jsp"%>