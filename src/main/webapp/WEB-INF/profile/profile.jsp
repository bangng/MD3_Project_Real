<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/4/2022
  Time: 9:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page='../boostrap/boostrap.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>WELCOME : ${user.name}</h1>
<a href="users?action=logout">LOG OUT</a>
<a href="users?action=change_avatar">Change avatar</a>
</body>
</html>
