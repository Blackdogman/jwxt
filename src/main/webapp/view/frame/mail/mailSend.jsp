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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>发送邮件</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=basePath%>mailController/mailSend.do">
            <input type="hidden" id="mailId" name="mailId" value="${sysMail.mailId}" />
            <div class="form-group">
                <div class="label">
                    <label>收件人：</label>
                </div>
                <div class="field">
                    <select name="toUserId" id="toUserId" class="input w50">
                        <option value="">请选择收件人</option>
                        <c:forEach items="${userList}" var="user">
                            <c:if test="${user.userId == sysMail.toUserId}">
                                <option value="${user.userId}" selected="selected">${user.userLoginName}</option>
                            </c:if>
                            <c:if test="${user.userId != sysMail.toUserId}">
                                <option value="${user.userId}">${user.userLoginName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" id="mailSubject" value="${sysMail.mailSubject}" name="mailSubject"
                           data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>内容：</label>
                </div>
                <div class="field">
                    <textarea name="mailContent" id="mailContent" class="input"
                              style="height:450px; border:1px solid #ddd;">${sysMail.mailContent}</textarea>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                    <button class="button bg-main icon-check-square-o" type="button" onclick="saveDraft();"> 保存至草稿箱
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function saveDraft() {
        var toUserId = $("#toUserId").val();
        var mailSubject = $("#mailSubject").val();
        var mailContent = $("#mailContent").val();
        var mailId = $("#mailId").val();
        $.ajax({
            url: "<%=basePath%>mailController/saveDraft.do",
            data: {
                "toUserId": toUserId,
                "mailSubject": mailSubject,
                "mailContent": mailContent,
                "mailId": mailId
            },
            type: "post",
            success: function (mailId) {
                alert("mailId: " + mailId);
                $("#mailId").val(mailId);
            }
        });
    }
</script>
</body>
</html>