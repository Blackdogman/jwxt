<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
	<form action="<%=basePath%>classInfoController/distributeStudent.do" method="post">
		<input type="hidden" name="id" value="${classInfo.id }">
		<div class="panel admin-panel">
			<div class="panel-head" id="add">
				<strong><span class="icon-pencil-square-o"></span>分配学生&nbsp;&nbsp;班级：<font
					color="red">${classInfo.className }</font></strong>
			</div>
			<div class="body-content">分配学生成功！</div>
		</div>
	</form>
	<a href="<%=basePath%>classInfoController/listPage.do">继续分配</a>
</body>
</html>