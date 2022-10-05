<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/4/2022
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="cate?action=listC">Back To List Categories</a>
<c:if test='${requestScope["message"]!=null}'>
    <span style="color: aqua">${requestScope["message"]}</span>
</c:if>
<form method="post">
    <label>Category</label><br>
    <input type="text" name="category" value='${requestScope["categories"].category}'>
    <button>Edit</button>
</form>
</body>
</html>
