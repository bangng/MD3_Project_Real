<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/4/2022
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page='../boostrap/boostrap.jsp'>
    <jsp:param name="articleId" value=""/>
</jsp:include>
<html>
<head>
    <title>Title</title>
    <style>
        .bg-image-vertical {
            position: relative;
            overflow: hidden;
            background-repeat: no-repeat;
            background-position: right center;
            background-size: auto 100%;
        }

        @media (min-width: 1025px) {
            .h-custom-2 {
                height: 100%;
            }
        }
    </style>
</head>
<body>
<section class="vh-100">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-6 text-black">

                <div class="px-5 ms-xl-4">
                    <i style="color: blueviolet" class="bi bi-virus"></i>
                    <i style="color: blueviolet" class="bi bi-virus"></i>
                    <i style="color: blueviolet" class="bi bi-virus"></i>
                    <i style="color: blueviolet" class="bi bi-virus"></i>
                    <i style="color: blueviolet" class="bi bi-virus"></i>
                    <i style="color: blueviolet" class="bi bi-virus"></i>
                    <i style="color: blueviolet" class="bi bi-virus"></i>
                </div>

                <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">



                        <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Log in</h3>

                        <div class="form-outline mb-4">
                            <input name="username" type="text" id="form2Example18" class="form-control form-control-lg" />
                            <label class="form-label" for="form2Example18">Email address</label>
                        </div>  <form style="width: 23rem;" method="post">

                        <div class="form-outline mb-4">
                            <input name="password" type="password" id="form2Example28" class="form-control form-control-lg" />
                            <label class="form-label" for="form2Example28">Password</label>
                        </div>

                        <div class="pt-1 mb-4">
                            <button  class="btn btn-info btn-lg btn-block" type="submit">Login</button>
                        </div>

                        <p class="small mb-5 pb-lg-2"><a class="text-muted" href="#!">Forgot password?</a></p>
                        <p>Don't have an account? <a href="#!" class="link-info">Register here</a></p>

                    </form>

                </div>

            </div>
            <div class="col-sm-6 px-0 d-none d-sm-block">
                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img3.webp"
                     alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
            </div>
        </div>
    </div>
</section>
</body>
</html>
