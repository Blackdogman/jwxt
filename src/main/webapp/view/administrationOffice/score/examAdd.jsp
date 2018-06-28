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
    <script src="bootstrap/js/bootstrap.js"></script>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <div class="col-md-4 col-sm-4">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="input1" class="col-sm-4 col-xs-4 control-label">学科</label>
                    <div class="col-sm-8 col-xs-8">
                        <select class="form-control" id="input1">
                            <option value="1">你好</option>
                            <option value="1">你好</option>
                            <option value="1">你好</option>
                            <option value="1">你好</option>
                            <option value="1">你好</option>
                            <option value="1">你好</option>
                            <option value="1">你好</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="input2" class="col-sm-4 col-xs-4 control-label">学年</label>
                    <div class="col-sm-8 col-xs-8">
                        <input type="text" class="form-control" id="input2" placeholder="请输入名字">
                    </div>
                </div>
                <div class="form-group">
                    <label for="input3" class="col-sm-4 col-xs-4 control-label">学期</label>
                    <div class="col-sm-8 col-xs-8">
                        <input type="text" class="form-control" id="input3" placeholder="请输入名字">
                    </div>
                </div>
                <div class="form-group">
                    <label for="input4" class="col-sm-4 col-xs-4 control-label">考试名称</label>
                    <div class="col-sm-8 col-xs-8">
                        <input type="text" class="form-control" id="input4" placeholder="请输入名字">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-8 col-xs-offset-4 col-xs-8">
                        <button type="submit" class="btn btn-default">登录</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-8 col-sm-8">
            <div class="form-group col-sm-5">
                <label for="input1233" class="col-sm-4 col-xs-4 control-label">学科</label>
                <div class="col-sm-8 col-xs-8">
                    <select class="form-control" id="input1233">
                        <option value="1">你好</option>
                        <option value="1">你好</option>
                        <option value="1">你好</option>
                        <option value="1">你好</option>
                        <option value="1">你好</option>
                        <option value="1">你好</option>
                        <option value="1">你好</option>
                    </select>
                </div>
            </div>
            <div class="form-group col-sm-5">
                <label for="input12333" class="col-sm-4 col-xs-4 control-label">学科</label>
                <div class="col-sm-8 col-xs-8">
                    <select class="form-control" id="input12333">
                        <option value="1">你好</option>
                        <option value="1">你好</option>
                        <option value="1">你好</option>
                        <option value="1">你好</option>
                        <option value="1">你好</option>
                        <option value="1">你好</option>
                        <option value="1">你好</option>
                    </select>
                </div>
            </div>
            <select multiple="multiple" size="12" class="col-md-12">
                <option value ="volvo">Volvo</option>
                <option value ="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
                <option value ="volvo">Volvo</option>
                <option value ="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
                <option value ="volvo">Volvo</option>
                <option value ="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
                <option value ="volvo">Volvo</option>
                <option value ="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
                <option value ="volvo">Volvo</option>
                <option value ="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
                <option value ="volvo">Volvo</option>
                <option value ="saab">Saab</option>
                <option value="opel">Opel</option>
                <option value="audi">Audi</option>
            </select>
        </div>
    </div>
</div>

</body>
</html>