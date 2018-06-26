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
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="<%=basePath%>administrationOfficeController/addTeacher.do">
            <div class="form-group">
                <div class="label">

                </div>
                <div class="field">
                    <span style="color:red;">${errorMessage}</span>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>工号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="teacherId" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="teacherName" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>出生日期：</label>
                </div>
                <div class="field">
                    <input type="date" class="input w50" value="" name="teacherBirthday" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>性别：</label>
                </div>
                <div class="field">
                    <select class="input w50" name="teacherSex">
                        <option>--- 请选择 ---</option>
                        <option value="1">男</option>
                        <option value="0">女</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>住址：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="teacherAddress" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>民族：</label>
                </div>
                <div class="field">
                    <select class="input w50" name="teacherNationality">
                        <option>--- 请选择 ---</option>
                        <option value="1">汉族</option>
                        <option value="2">少数民族</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>身份证号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="teacherCitizenId" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>政治面貌：</label>
                </div>
                <div class="field">
                    <select class="input w50" name="teacherPoliticalStatus">
                        <option>--- 请选择 ---</option>
                        <option value="1">群众</option>
                        <option value="2">少先队员</option>
                        <option value="3">共青团员</option>
                        <option value="4">党员</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>联系电话：</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="teacherPhone" data-validate="required:请输入标题"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>

    </div>
</div>

</body>
</html>