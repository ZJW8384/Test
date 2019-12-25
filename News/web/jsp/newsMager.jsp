<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<% String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath %>">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<title>新闻管理</title>
        <link href="../css/bootstrap-4.3.1.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/jquery-editable-select.css">
        <script src="../js/jquery-3.4.1.js"></script>
        <script src="../js/jquery-editable-select.js"></script>
        <link rel="stylesheet" href="../css/newsMager.css">

        <script>
            $(document).ready(function () {
               var home= $("#home");
               var user='<%=session.getAttribute("uid")%>';
               home.html(user);
               var title=$("input[name='title']").val();
               var des=$("textarea[name='des']").val();
               var msg=$("textarea[name='msg']").val();
               //主要操作
               var addnw=$("#addnw");
               var editnw=$("#editnw");
               var addst=$("#addst");
               var editst=$("#editst");
               //功能模块
                var subadd=$("#subadd");
                var nadd=$("#newsadd");
                var nedit=$("#newsedit");
                var editsub=$("#editsub");
                var ipt=$("#ipt");
                var add=$("#adds");
                var submit=$("#submit");
                ipt.hide();
                subadd.hide();
                nedit.hide();
                editsub.hide();
               addnw.click(function () {
                   nedit.hide();
                   subadd.hide();
                   editsub.hide();
                   nadd.show();
               });
                editnw.click(function () {
                  nadd.hide();
                  subadd.hide();
                    editsub.hide();
                  nedit.show();
                });
                $("button[name='sub']").click(function () {
                    if(title=='' ||des==''||msg==''){
                        alert("内容不能为空");
                        return false;
                    }
                });
                addst.click(function () {
                    subadd.show();
                    nedit.hide();
                    editsub.hide();
                    nadd.hide();
                });
                editst.click(function () {
                    subadd.hide();
                    nedit.hide();
                    nadd.hide();
                    editsub.show()
                });
                add.click(function () {
                    ipt.show();
                });
                submit.click(function () {
                    if($("#su").val()==''){
                        alert("数据不能为空！");
                        return false;
                    }else {
                        send();
                        ipt.hide();
                    }
                });
                function send() {
                    $.ajax({
                        url:"subjectCont",
                        type:"GET",
                        dadaType:"text",
                        data:$("#ipt").serialize(),
                        success:function (data) {
                            var json=jQuery.parseJSON(data);
                            var str=json.toString();
                            for(var i=0;i<str.length;i++){
                                var sub=json[i].subject;
                                var td='<td>'+sub+"</td>";
                                $("#subadd").append('<tr>'+td+'</td>');
                            }
                        },
                        error:function () {
                            alert("失败");
                        }
                    })
                }

                $(document).ready(function () {
                    var sub=$("#sub");
                    sub.click(function () {
                        $.ajax({
                            url:"category",
                            type:"POST",
                            dataType:"text",
                            data:$("#doda").serialize(),
                            success:function (data) {
                                var json=jQuery.parseJSON(data);
                                var str=json.toString();
                                var inp="href=newsUP?title=";
                                for(var i=0;i<str.length;i++){
                                    var td='<td><a '+inp+''+json[i].title+'>'+json[i].title+'</a></td>';
                                    $("#tab").html("<tr>"+td+"</tr>");
                                }
                            },
                            error:function () {
                                alert("error");
                            }
                        })
                    })
                })

            })
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
                <a class="nav-link" id="go" href="userExit" >退出</a>
            </ul>
        </div>
    </nav>
    <div id="util">
        <span class="pad" id="addnw">添加新闻</span><br>
        <span class="pad" id="editnw">编辑新闻</span><br>
        <span class="pad" id="addst">添加主题</span><br>
        <span class="pad" id="editst">编辑主题</span><br>
    </div>
    <div id="newsadd">
        <h3>新闻添加</h3>
        <form action="newsAdd" method="post" enctype="multipart/form-data">
            <label>
                主题：
                <select name="subject">
                    <c:forEach items="${subject}" var="subject">
                    <option value="${subject.subject}">${subject.subject}</option>
                    </c:forEach>
                     </select>
            </label><br>
            标题：<input type="text" name="title" id="title"><br><br>
            作者：<input type="text" name="writer" id="writer"><br>
            轮播：<input type="radio" name="slide" value="1">是 <input type="radio" name="slide" value="0" checked="checked">否 <br>
            置顶：<input type="radio" name="top" value="1">是 <input type="radio" name="top" value="0" checked="checked">否 <br>
            摘要：<textarea id="des" name="des" ></textarea><br><br>
            内容：<textarea name="msg" id="msg"></textarea><br><br>
            文件上传：<input type="file" id="file" name="file"><br><br>
            <button type="submit" name="sub">提交</button><button type="reset">重置</button>
        </form>
    </div>
        <div id="newsedit">
            <div id="div-input">
                <form action="#" method="post" id="doda">
                标题：<input type="text" name="title">作者：<input type="text" name="writer">主题：<input type="text" name="subject"><button type="button" id="sub">查询</button><br><br>
                </form>
            </div>
            <div id="div-table">
                <table id="tab">
                    <c:forEach items="${list}" var="list" begin="0" end="15" step="1">
                        <tr>
                            <td><a href="newsUP?title=${list.title}">${list.title}</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <div id="subadd">
            <table border="1" cellspacing="0" cellpadding="0" id="ap">
                <tr>
                    <c:forEach items="${subject}" var="subject" begin="0" end="7" step="1">
                        <td>${subject.subject}</td>
                    </c:forEach>
                </tr>
                <tr>
                    <c:forEach items="${subject}" var="subject" begin="8" end="16" step="1">
                        <td>${subject.subject}</td>
                    </c:forEach>
                </tr>
            </table >
            <span id="adds"> + </span><br>
            <form action="#" id="ipt">
                <input type="text" id="su" name="sub"><br><br>
                <button type="button" id="submit">提交</button>
            </form>
        </div>
        <div id="editsub">
            <form action="subjectCont" method="post" id="tan">
                <c:forEach items="${subject}" var="subject" begin="0" end="4" step="1">
                        <input value="${subject.subject}" name="sub">
                </c:forEach>
                <br>
                <c:forEach items="${subject}" var="subject" begin="5" end="12" step="1">
                    <input value="${subject.subject}" name="sub">
                </c:forEach> <br><br>
                <button type="submit" id="sut">提交</button><button type="reset">重置</button>
            </form>
    </div>
	</body>
</html>