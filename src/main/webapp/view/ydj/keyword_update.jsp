<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <%-- 分页相关 --%>
    <script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/kkpager/jpager.js"></script>
    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>js/kkpager/jpager.css">
    <script type="text/javascript" src="<%=basePath%>view/user/listPage.js"></script>
    <script type="text/javascript">

        $(function () {
            $("#hitme").click(function () {
                // $("#updatePwdForm").submit();
                var oldUserLoginPwd = $("#oldUserLoginPwd").val();
                var newUserLoginPwd = $("#newUserLoginPwd").val();
                $.ajax({
                    url: "<%=basePath%>studentController/updateStudentPwd.do",
                    data: {
                        "oldUserLoginPwd":oldUserLoginPwd,
                        "newUserLoginPwd":newUserLoginPwd
                    },
                    type: "post",
                    success: function(req){
                        if(req){
                            window.parent.document.location.href = "<%=basePath%>view/frame/login.jsp";
                        }else {
                        }   window.location.href = "<%=basePath%>view/ydj/keyword_update.jsp";
                    }
                });
            });
        })

        function check() {
            if (newUserLoginPwd.value != password2.value) {
                check_tip.innerHTML = "<font color=red>两次输入的密码不相符</font>";
            } else {
                check_tip.innerHTML = "<font color=blue>两次输入的密码相符</font>";
            }
        }
    </script>
</head>
<body onload="load()">
<form method="post" id="updatePwdForm" action="<%=basePath%>studentController/updateStudentPwd.do">
    <div class="panel admin-panel">
        <div class="panel-head">
            <strong class="icon-reorder">密码修改</strong>
        </div>
    </div>
    <div class="panel-body"
         style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
        <div class="form-group">
            <div class="field field-icon-right">
                <input type="password" class="input input-big" id="oldUserLoginPwd" name="oldUserLoginPwd"
                       placeholder="旧密码:" data-validate="required:请填写旧密码"/> <span
                    class="icon icon-user margin-small"></span>
            </div>
        </div>
        <div class="form-group">
            <div class="field field-icon-right">
                <input id="newUserLoginPwd" type="password" class="input input-big" name="newUserLoginPwd"
                       placeholder="新密码:" data-validate="required:请填写新密码"/> <span
                    class="icon icon-key margin-small"></span>
            </div>
        </div>
        <div class="form-group">
            <div class="field field-icon-right">
                <input id="password2" type="password" class="input input-big" name="userLoginPwd2"
                       placeholder="请再次输入新密码:" data-validate="required:请填写新密码"/> <span
                    class="icon icon-key margin-small"></span>
            </div>
        </div>
        <div id=check_tip></div>
    </div>
    <div style="padding: 30px;">
        <input type="submit" id="hitme"
               class="button button-block bg-main text-big input-big"
               value="确定">
    </div>
</form>
<script type="text/javascript">
    function del(id) {
        if (confirm("您确定要删除吗?")) {

        }
    }

    $("#checkall").click(function () {
        $("input[name='id[]']").each(function () {
            if (this.checked) {
                this.checked = false;
            } else {
                this.checked = true;
            }
        });
    })

    function DelSelect() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false)
                return false;
        } else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }

    function runjimp() {

    }
</script>
</body>
</html>