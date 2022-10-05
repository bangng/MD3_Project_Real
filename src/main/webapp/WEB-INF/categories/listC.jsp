

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
<a href="cate?action=createC">Create Category</a>
<form method="post">
    <table border="1">
        <tr>
            <th>STT</th>
            <th>Category</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items='${requestScope["categoriesList"]}' var="c">
           <tr>
               <td>${c.id}</td>
               <td>${c.category}</td>
               <td><a href="cate?action=editC&id=${c.id}">Edit</a></td>
               <td><a href="cate?action=deleteC&id=${c.id}">Delete</a></td>
           </tr>

        </c:forEach>
    </table>


</form>
</body>
</html>