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
    <title>Form Delete Series Film</title>
</head>
<body>

<c:if test='${requestScope["message"]!=null}'>
    <span style="color: aqua">${requestScope["message"]}</span>
</c:if>
<form method="post">

    <label>Series Film</label><br>
    <p>${requestScope["seriesFilm"].seriesName}</p>
    <p>Are you sure delete</p>
    <button>Delete</button>
</form>
<a href="series?action=listS">Not Delete And Back</a>
</body>
</html>