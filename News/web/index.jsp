<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>首页</title>
		<link href="css/bootstrap-4.3.1.css" rel="stylesheet">
		<link rel="stylesheet" href="css/index.css">
		<script src="js/jquery-3.4.1.js"></script>
		<script>
			$(document).ready(function () {
				var home=$("#home");
				var well=$("#well");
				var sd=$("#sd");
				var op=$("#op");
				var go=$("#go");
				var enter=$("#enter");
				var nav_home=$("#nav-home-tab");
				var nav_profile=$("#nav-profile-tab");
				var nav_contact=$("#nav-contact-tab");
				var uid='<%=session.getAttribute("uid")%>';
				var flag='<%=session.getAttribute("flag")%>';
				home.html("未登入");
				well.hide();
				enter.show();
				sd.hide();
				op.hide();
				if(uid!='null'){
					home.html(uid);
					op.show();
					enter.hide();
					sd.show();
				}
				function send(){
					$.ajax({
						type: "POST",
						url: "index",
						dateType:"text",
						async:false,
						data:$("#enter").serialize(),
						success:function (data) {
							var str=data.toString();
							if(str.length>10){
								alert("用户名或密码错误！")
							}else {
								home.html(data);
								op.show();
								enter.hide();
								sd.show();
							}
						},
						error:function () {
							alert("登入失败，请刷新页面重试！");
						}
					});
				}
				function exit(){
					$.ajax({
						type: "GET",
						url: "userExit",
						dateType:"text",
						async:false,
						success:function (data) {
							home.html("未登入");
							well.hide();
							enter.show();
							sd.hide();
							op.hide();
						},
						error:function () {
							alert("error");
						}
					});
				}
				$("#ex").click(function () {
					exit();
				});
				go.click(function () {
					if($("#uid").val()==''||$("#pwd").val()==''){
						alert("用户名或密码不能为空");
						return false;
					}else {
						send();
					}
				});
				// $("#expor").click(function () {
				// 	$("#expor").attr("href","/jsp/login.jsp");
				// });
			});

		</script>
	</head>
	<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="navbar">
		<a class="navbar-brand" href="#" id="well">欢迎：</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto" >
				<li class="nav-item active">
<%--					用户名--%>
					<a class="nav-link" id="home" ><span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item dropdown" id="op">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">操作</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown" >
						<a class="dropdown-item" href="#">修改资料</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" id="ex" style="cursor: pointer;">退出登录</a>
					</div>
				</li>
				<li class="nav-item" id="sd">

					<a class="nav-link" href="newsAdd">新闻管理</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0" id="enter">
					<input class="form-control mr-sm-2" type="text" placeholder="用户名" aria-label="Search" id="uid" name="uid">
					<input class="form-control mr-sm-2" type="password" placeholder="密码" aria-label="Search" id="pwd" name="pwd">
					<button class="btn btn-outline-success my-2 my-sm-0" type="button" id="go">登入</button>
			</form>
		</div>
	</nav>
	<div class="container mt-3 " id="banner">
		<div class="row">
			<div class="col-12">
				<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleControls" data-slide-to="0" class="active"></li>
						<li data-target="#carouselExampleControls" data-slide-to="1"></li>
						<li data-target="#carouselExampleControls" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<c:forEach items="${slide}" var="slide" begin="0" end="0" step="1">
								<a href="newMinute?title=${slide.title}"><img class="d-block w-100" src="${pageContext.request.contextPath}${slide.imgPath}" alt="First slide"></a>
								<div class="carousel-caption d-none d-md-block">
									<h5 class="solie">${slide.title}</h5>
								</div>
							</c:forEach>
						</div>
						<div class="carousel-item">
							<c:forEach items="${slide}" var="slide" begin="1" end="1" step="1">
								<a href="newMinute?title=${slide.title}"><img class="d-block w-100" src="${pageContext.request.contextPath}${slide.imgPath}" alt="First slide"></a>
								<div class="carousel-caption d-none d-md-block">
									<h5 class="solie">${slide.title}</h5>
								</div>
							</c:forEach>
						</div>
						<div class="carousel-item">
							<c:forEach items="${slide}" var="slide" begin="2" end="2" step="1">
								<a href="newMinute?title=${slide.title}"><img class="d-block w-100" src="${pageContext.request.contextPath}${slide.imgPath}" alt="First slide"></a>
								<div class="carousel-caption d-none d-md-block">
									<h5 class="solie">${slide.title}</h5>
								</div>
							</c:forEach>
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
		<hr>
	</div>
	<section >
		<div class="container" >
			<div class="row" >
				<div class="col-md-6 col-12" id="writ" >
					<h3>新闻分类</h3>
					<hr>
					<div class="row">
						<div class="col-4">
							<div class="text-center classes"> 体育 </div>
						</div>
						<div class="col-4">
							<div class="text-center classes" > 社会</div>
						</div>
						<div class="col-4">
							<div class="text-center classes" >军事 </div>
						</div>
					</div>
					<hr>
					<div class="row" >
						<div class="col-4" >
							<a href="#" id="expor"><div class="text-center classes" >探索 </div></a>
						</div>
						<div class="col-4" >
							<a href="category?type=science"><div class="text-center classes">科技 </div></a>
						</div>
						<div class="col-4">
							<div class="text-center classes" >健康</div>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-4">
							<div class="text-center classes"> 教育</div>
						</div>
						<div class="col-4">
							<div class="text-center classes">文化 </div>
						</div>
						<div class="col-4">
							<div class="text-center classes"> 其他</div>
						</div>
					</div>
					<hr>
				</div>
				<div class="col-md-6 col-12" >
					<h3>NEWS</h3>
					<nav>
						<div class="nav nav-tabs" id="nav-tab" role="tablist">
							<a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">国内新闻</a>
							<a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">国际新闻</a>
							<a class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">娱乐新闻</a>
						</div>
					</nav>
					<div class="tab-content " id="nav-tabContent">
						<div class="tab-pane fade show active no1" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
							<table>
								<c:forEach items="${nation}" var="nation">
									<tr>
										<td><a href="newMinute?title=${nation.title}">${nation.title}</a></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="tab-pane fade no2" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
							<table>
								<c:forEach items="${intern}" var="intern">
									<tr>
										<td><a href="newMinute?title=${intern.title}">${intern.title}</a></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="tab-pane fade no3" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
							<table>
								<c:forEach items="${hoblly}" var="hoblly">
									<tr>
										<td><a href="newMinute?title=${hoblly.title}">${hoblly.title}</a></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section >
		<hr>
		<div class="container print">
			<div class="row">
				<div class="col-lg-4 col-md-6 col-12">
					<c:forEach items="${stick}" var="stick" begin="0" end="0" step="1">
					<ul class="list-unstyled">
						<li class="media">
								<img src="${pageContext.request.contextPath}${stick.imgPath}" alt="" class="mr-3 rounded-circle img">
							<div class="media-body">
								<h5 class="mt-0 mb-1 btn btn-primary read">置顶 </h5>
								<p class="mb-0"><a href="newMinute?title=${stick.title}">${stick.des}</a></p>
							</div>
						</li>
					</ul>
					</c:forEach>
				</div>
				<div class="col-lg-4 col-md-6 col-12">
					<c:forEach items="${stick}" var="stick" begin="1" end="1" step="1">
					<ul class="list-unstyled">
						<li class="media">
							<img src="${pageContext.request.contextPath}${stick.imgPath}" alt="" class="mr-3 rounded-circle img">
							<div class="media-body">
								<h5 class="mt-0 mb-1 btn btn-primary read">置顶 </h5>
								<p class="mb-0"><a href="newMinute?title=${stick.title}">${stick.des}</a></p>
							</div>
						</li>
					</ul>
					</c:forEach>
				</div>
				<div class="col-lg-4 d-md-none d-lg-block">
					<c:forEach items="${stick}" var="stick" begin="2" end="2" step="1">
					<ul class="list-unstyled">
						<li class="media">
							<img src="${pageContext.request.contextPath}${stick.imgPath}" alt="" class="mr-3 rounded-circle img">
							<div class="media-body">
							<h5 class="mt-0 mb-1 btn btn-primary read">置顶 </h5>
							<p class="mb-0"><a href="newMinute?title=${stick.title}">${stick.des}</a></p>
							</div>
						</li>
					</ul>
				</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<hr>
	<div class="container" >

			</div>
			<hr>
			<div class=" " id="hot">
				<div class="card" id="hot-a">

					<video width="400px" height="200px" style="position: relative;top: 15px" loop="loop" controls="controls" >
<%--						 autoplay="autoplay" --%>
						<source src="/voide/vcd.mp4">
					</video>
					<div class="card-body">
						<h5 class="card-title">穿越时空看澳门</h5>
						<p class="card-text">20年沧桑巨变 穿越时空看澳门<br>来源：央视网2019年12月20日 22:42</p>
						<a href="#" class="btn btn-primary" id="but">查看</a>
					</div>
				</div>
				<div class="row mx-0">
					<div class="col-12 card bg-light mx-auto">
						<h3 class="text-center card-header">热点新闻</h3>
						<div id="news">

							<c:forEach items="${list}" var="list">
								<tr>
									<td><a href="newMinute?title=${list.title}">${list.title}</a><span style="float: right">${list.time}</span></td>
									<br>

								</tr>

							</c:forEach>

								<span id="bar">第（${page}）页&nbsp;<button id="up">上</button>&nbsp;<button id="down">下</button>共（${count}）页</span>

						</div>
					</div>

				</div>
			</div>
	<hr>
	<footer class="text-center">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<p>Copyright © MyWebsite. All rights reserved.</p>
				</div>
			</div>
		</div>
	</footer>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap-4.3.1.js"></script>
	</body>
</html>