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
<a href="video?action=createV">Create Videos</a>
<form method="post">
    <table border="1">
        <tr>
            <th>STT</th>
            <th>NameVideo</th>
            <th>Date</th>
            <th>Link</th>
            <th>Country</th>
            <th>Category</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items='${requestScope["videoList"]}' var="v">
            <tr>
                <td>${v.id}</td>
                <td>${v.videoName}</td>
                <td>${v.dateByVideo}</td>
                <td>${v.linkVideo}</td>
                <td>${v.country}</td>
                <td>${v.categoriesSet}</td>



                <td><a href="video?action=editV&id=${v.id}">Edit</a></td>
                <td><a href="video?action=deleteV&id=${v.id}">Delete</a></td>
            </tr>

        </c:forEach>
    </table>


</form>
</body>
</html>