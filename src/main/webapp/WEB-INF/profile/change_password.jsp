<%--
  Created by IntelliJ IDEA.
  User: Chinh
  Date: 10/5/2022
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Change Password</h1>
<a href="WEB-INF/index.jsp"></a>
<c:if test='${requestScope["message"]!=null}'>
    <p style="color: red">${requestScope["message"]}</p>
</c:if>
<form method="post">
    Old Password<br>
    <input type="text" name="oldPassword"><br>
    New Password<br>
    <input type="text" name="newPassword"><br>
    Repeat Password<br>
    <input type="text" name="repeatPassword"><br>
    <button>Submit</button>
</form>
</body>
</html>
