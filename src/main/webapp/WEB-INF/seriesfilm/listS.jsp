<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<jsp:include page='/WEB-INF/boostrap/boostrap.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
<head>
    <title>Title</title>
</head>
<body>
<a href="series?action=createS">Create Series Film</a>
<form method="post">
    <table border="1">
        <tr>
            <th>STT</th>
            <th>Series</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items='${requestScope["seriesFilmList"]}' var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.seriesName}</td>
                <td><a href="series?action=editS&id=${s.id}">Edit</a></td>
                <td><a href="series?action=deleteS&id=${s.id}">Delete</a></td>
            </tr>

        </c:forEach>
    </table>


</form>
</body>
</html>