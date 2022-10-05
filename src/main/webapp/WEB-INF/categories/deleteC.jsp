<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/4/2022
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Delete Categories</title>
</head>
<body>

<c:if test='${requestScope["message"]!=null}'>
    <span style="color: aqua">${requestScope["message"]}</span>
</c:if>
<form method="post">

    <label>Category</label><br>
    <p>${requestScope["categories"].category}</p>
    <p>Are you sure delete</p>
    <button>Delete</button>
</form>
<a href="cate?action=listC">Not Delete And Back</a>
</body>
</html>
