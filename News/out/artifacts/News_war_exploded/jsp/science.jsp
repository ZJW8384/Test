<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>科技</title>
		<link rel="stylesheet" href="../css/science.css">
	</head>
	<body>
    <%@include file="hander.jsp"%>
        <div id="head"><h1>科&nbsp;&nbsp;&nbsp;技</h1></div>
	<img src="../images/trues.jpg" alt="" style="opacity: .4;width: 1350px;height: 900px;z-index: -1;">
	<div id="tk">
		<table>
			<c:forEach items="${type}" var="type">
			<tr>
				<td><a href="newMinute?title=${type.title}">${type.title}</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div id="mores">
		<table>
				<c:forEach items="${type}" var="type" begin="0" end="4" step="1">
					<tr>
						<td>
							<img src="${pageContext.request.contextPath}${type.imgPath}" alt="" id="mimg">
							<p id="des" ><a href="newMinute?title=${type.title}" style="color: #040505!important;" }>${fn:substring(type.des, 0,75 )}</a></p>
						</td>
					</tr>
				</c:forEach>
		</table>
	</div>
	</body>
</html>