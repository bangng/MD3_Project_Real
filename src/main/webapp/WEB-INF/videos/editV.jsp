<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/5/2022
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="video?action=listV">Back To List Video</a>
<c:if test='${requestScope["message"]!=null}'>
    <span style="color: aqua">${requestScope["message"]}</span>
</c:if>
<form method="post">
    <label>videoName</label><br>
    <input type="text" name="videoName" value='${requestScope["videoList"].videoName}'><br>
    <label>dateByVideo</label><br>
    <input type="text" name="dateByVideo" value='${requestScope["videoList"].dateByVideo}'><br>
    <label>Đất Nước</label><br>
    <input type="text" name="country" value='${requestScope["videoList"].country}'><br>
    <button>Edit</button>
</form>
</body>
</html>
