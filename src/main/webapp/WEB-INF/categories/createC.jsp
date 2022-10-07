<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>Create</title>
</head>
<body>

<c:if test='${requestScope["message"] != null}'>
    <span style="color: aqua">${requestScope["message"]}</span>
</c:if>
<form method="post">
    <label>
        <input type="text" name="category" placeholder="thêm thể loại phim">
    </label>
    <button>Create</button>

</form>
<a href="cate?action=listC">Back To List Categories</a>

</body>
</html>
