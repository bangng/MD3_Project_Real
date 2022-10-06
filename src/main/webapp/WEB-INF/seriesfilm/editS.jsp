<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2022
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="series?action=listS">Back To List Series Film</a>
<c:if test='${requestScope["message"]!=null}'>
    <span style="color: aqua">${requestScope["message"]}</span>
</c:if>
<form method="post">
    <label>Series Film</label><br>
    <input type="text" name="seriesName" value='${requestScope["seriesFilmList"].seriesName}'>
    <button>Edit</button>
</form>
</body>
</html>