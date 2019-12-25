<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>title</title>
        <link rel="stylesheet" href="../css/editnews.css">
        <script src="../js/jquery-3.4.1.js"></script>

	</head>
	<body>
    <div id="newsedit">
        <h3>编辑新闻</h3>
        <form action="newsUP" method="post" enctype="multipart/form-data" id="doda">
            <label>
                主题：
                <select name="sub">
                    <c:forEach items="${subject}" var="subject">
                        <option value="${subject.subject}">${subject.subject}</option>
                    </c:forEach>
                </select>
            </label><br>
            <c:forEach items="${list}" var="list">
            标题：<input type="text" name="title" id="edtitle" value="${list.title}" readonly><br><br>
            轮播：<input type="radio" name="slide" value="1">是 <input type="radio" name="slide" value="0" checked="checked">否 <br>
            置顶：<input type="radio" name="top" value="1">是 <input type="radio" name="top" value="0" checked="checked">否 <br>
            作者：<input type="text" name="writer" id="edwriter" value="${list.writer}"><br><br>
            摘要：<textarea id="eddes" name="des" >${list.des}</textarea><br><br>
            内容：<textarea name="msg" id="edmsg">${list.msg}</textarea><br><br>
            文件上传：<input type="file" id="edfile" name="img" value="${list.imgPath}"><br><br>
            </c:forEach>
            <button type="button" name="sub" id="sub">提交</button><button type="reset">重置</button>
        </form>
    </div>
	</body>
</html>