<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/5/2022
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Delete Video</title>
</head>
<body>

<c:if test='${requestScope["message"]!=null}'>
    <span style="color: aqua">${requestScope["message"]}</span>
</c:if>
<form method="post">

    <label>Video Name</label><br>
    <p>${requestScope["videoList"].videoName}</p>
    <p>Are you sure delete</p>
    <button>Delete</button>
</form>
<a href="video?action=listV">Not Delete And Back</a>
</body>
</html>
