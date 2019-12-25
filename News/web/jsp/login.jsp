<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>title</title>
		<script src="../js/jquery-3.4.1.js"></script>
		<script>
			$(document).ready(function () {
					var st='<%=session.getAttribute("st")%>';
					// var jsons=jQuery.parseJSON(st);
					// var str=jsons.toString();
					// for(var i=0;i<str.length;i++){
					//
					// }
					// 	alert(st);
				var a=0;
				<c:set var="a" value="" />
				<c:forEach items="${list}" var="list" begin="a" end="10" step="1">

				</c:forEach>
			})
		</script>
	</head>
	<body>

<table>
	<c:forEach items="${list}" var="list" begin="0" end="10" step="1">
		<tr>
			<td><a href="#">${list.title}</a>&nbsp;${list.time}</td>
		</tr>
	</c:forEach>
</table>

	</body>
</html>