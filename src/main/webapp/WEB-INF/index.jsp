<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>--%>
<jsp:include page='boostrap/boostrap.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="mp3?action=create">Create Video</a>
<video width="320" height="240" controls>
    <source src='https://firebasestorage.googleapis.com/v0/b/chinhrobeto.appspot.com/o/yt1s.com%20-%20Phim%20Ng%E1%BA%AFn%20T%C3%ACnh%20Y%C3%AAu%20S%C3%B3ng%20Bi%E1%BB%83n%20%20T%E1%BA%ADp%2040%20%20Linh%20v%E1%BB%81%20qu%C3%AA%20s%E1%BB%91ng%20t%E1%BA%A1m%20bi%E1%BB%87t%20x%C3%B3m%20tr%E1%BB%8D%20S%C3%B3ng%20Bi%E1%BB%83n%20%20Kh%E1%BA%A3i%20C%C3%A0%20Kh%E1%BB%8Ba.mp4?alt=media&token=3684291c-97f9-480c-97c1-1119dbdf212d' type="video/mp4">

    Your browser does not support the video tag.
</video>

<h1>WEBSITE Xbet Viet</h1>

<div>

<div>
    <p>test ${requestScope['currentPage']}</p>
    <p>no of page ${requestScope['noOfPages']}</p>
    <p>video list ${requestScope['videoList']}</p>

    <c:if test="${currentPage != 1}">
        <a href="video?page=${currentPage - 1}">Previous</a>
    </c:if>
    <c:forEach begin="1" end="${noOfPages}" var="i">
        <c:choose>
            <c:when test="${currentPage eq i}">
                <a>${i}</a>
            </c:when>
            <c:otherwise>
                <a href="video?page=${i}">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <%--For displaying Next link --%>
    <c:if test="${currentPage lt noOfPages}">
        <a href="video?page=${currentPage + 1}">Next</a>
    </c:if></div>

    <c:forEach items='${requestScope["videoList"]}' var="vd">
        <div><video src="${vd.linkVideo}"></video>
            <p>${vd.videoName}</p>
            <p>${vd.dateByVideo}</p>
            <p>${vd.country}</p>
        </div>
    </c:forEach>
</div>


</body>
</html>