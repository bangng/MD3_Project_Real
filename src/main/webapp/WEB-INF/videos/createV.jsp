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
        <input type="text" name="videoName" placeholder="Thêm tên cho phim">
    </label>
    <label>
        <input type="text" name="dateByVideo" placeholder="thêm năm sản xuất cho phim">
    </label>
    <label>
        <input type="text" name="country" placeholder="thêm nước cho phim">
    </label>
    <label>
        <select multiple>
            <c:forEach items='${requestScope["categoriesList"]}' var="ct">
                <option>${ct.category}</option>
            </c:forEach>
        </select>

    </label>

    <button>Create</button>

</form>
<a href="video?action=listV">Back To List Video</a>

</body>
</html>
