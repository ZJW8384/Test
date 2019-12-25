<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%--<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>--%>
<%--<!DOCTYPE html>--%>
<html>
	<head>
		<title>title</title>
        <link href="../css/bootstrap-4.3.1.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/index.css">
        <link rel="stylesheet" href="../css/hander.css">
        <script src="../js/jquery-3.4.1.js"></script>
	</head>
	<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="navbar">
        <a class="navbar-brand" href="index.jsp" id="well">首页</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto" >
                <li class="nav-item active navs">
                    <%--					用户名--%>
                    <a class="nav-link" href="#" id="home" >国际<span class="sr-only">(current)</span></a>
                </li>

                <li class="nav-item active navs" >
                    <a class="nav-link" href="#">国内</a>
                </li>
                <li class="nav-item active navs" >
                    <a class="nav-link" href="#">娱乐</a>
                </li>
                <li class="nav-item active navs" >
                    <a class="nav-link" href="category?type=science">科技</a>
                </li>
                <li class="nav-item active navs" >
                    <a class="nav-link" href="3">探索</a>
                </li>
                <li class="nav-item active navs" >
                    <a class="nav-link" href="#">体育</a>
                </li>
                <li class="nav-item active navs" >
                    <a class="nav-link" href="#">社会</a>
                </li>
                <li class="nav-item active navs" >
                    <a class="nav-link" href="#">文化</a>
                 </li>
                <li class="nav-item active navs" >
                    <a class="nav-link" href="#">教育</a>
                </li>
                <li class="nav-item active navs" >
                    <a class="nav-link" href="#">其他</a>
                </li>



            </ul>
<%--            <form class="form-inline my-2 my-lg-0" id="enter">--%>
<%--                <input class="form-control mr-sm-2" type="text" placeholder="用户名" aria-label="Search" id="uid" name="uid">--%>
<%--                <input class="form-control mr-sm-2" type="password" placeholder="密码" aria-label="Search" id="pwd" name="pwd">--%>
<%--                <button class="btn btn-outline-success my-2 my-sm-0" type="button" id="go">登入</button>--%>
<%--            </form>--%>
        </div>
    </nav>
	</body>
</html>
