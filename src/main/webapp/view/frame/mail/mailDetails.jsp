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
            <div class="form-group">
                <div class="label">
                    <label>收件人：</label>
                </div>
                <div class="field">
                    <input name="toUserID" class="input w50" value="${sysMail.toUserName}" type="text" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>发件人：</label>
                </div>
                <div class="field">
                    <input name="fromUserId" class="input w50" value="${sysMail.fromUserName}" type="text" readonly="readonly"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>标题：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${sysMail.mailSubject}" name="mailSubject" readonly="readonly"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>内容：</label>
                </div>
                <div class="field">
                    <textarea name="mailContent" readonly="readonly" class="input" style="height:450px; border:1px solid #ddd;">${sysMail.mailContent}</textarea>
                    <div class="tips"></div>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>