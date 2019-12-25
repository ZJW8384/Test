<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>新闻</title>
        <link rel="stylesheet" href="../css/news.css">
        <script src="../js/jquery-3.4.1.js"></script>
        <script>
            $(document).ready(function () {
                var user="<%=session.getAttribute("uid")%>";
                var discuss=$("#discuss");
                var  log=$("#log");
                log.hide();
                if(user=="null"){
                    log.show();
                    discuss.hide();
                }
                function send() {
                    $.ajax({
                        type:"POST",
                        url:"noteCont",
                        data:$("#data").serialize(),
                        dataType:"text",
                        success:function (data) {
                                var json=jQuery.parseJSON(data);
                                var str=json.toString();
                                for (var i=0;i<str.length;i++){
                                    var uid=json[i].uid;
                                    var msg=json[i].msg;
                                    var time=json[i].time;
                                    var td='<td>'+uid+'</td><td>'+msg+'</td><td>'+time+'</td>';
                                    $("#pingl").html('<tr>'+td+'</tr>');
                                }
                        },
                        error:function () {
                                alert("评论失败！");
                        }
                    })
                }
                $("#buts").click(function () {
                    var p=$("#pingl");
                    if(p.val()==''){
                        alert("评论内容不能为空");
                        return false;
                    }else {
                        send();
                    }
                    p.html("");
                })
            })
        </script>
	</head>
	<body>
<%@include file="hander.jsp"%>
<br>
        <div id="info">
            <c:forEach items="${news}" var="list">
                <h1 style="display: block;text-align: center">${list.title}</h1><br>
                <p id="mess">作者：${list.writer}  ${list.time}</p>
                <img src="${pageContext.request.contextPath}${list.imgPath}" alt="" style="display: block;margin: 0 auto"><br><br>
                <div style="width: 1000px;margin: 0 auto">${list.msg}</div>
            </c:forEach>
        </div>
            <br><br>
        <span id="log"><a href="#">请登入后评论</a></span>
        <div id="discuss">
            <form action="" method="post" id="data">
                <c:forEach items="${news}" var="list">
                    <input type="hidden" value="${list.title}" name="title">
                </c:forEach>
                <span id="user">用户名：<input type="text" name="uid" value="<%=session.getAttribute("uid")%>" readonly></span><span> IP：<input type="text" readonly name="ip" value="<%=session.getAttribute("ip")%>"></span><br><br><br>
                <label for="pi">评论：</label><textarea name="pinl" id="pi"></textarea><br>
               <span style="position: relative;left: 200px"><button type="button" id="buts">评论</button><button type="reset">重置</button></span>
            </form>

        </div>
<fieldset>
    <legend style="font-size: 15px;position: absolute;left: 200px;">用户评论：</legend>
            <div id="foot">
                <table id="pingl">
                    <c:if test="${empty note}">
                        <td></td>
                        <td>暂无评论</td>
                    </c:if>
                    <c:forEach items="${note}" var="note">
                        <tr>
                            <td>${note.uid}</td>
                            <td>${note.msg}</td>
                            <td> </td><td></td>
                            <td>${note.time}</td>
                        </tr>
                    </c:forEach>
                </table>
                </div>
                </fieldset>
	</body>
</html>
