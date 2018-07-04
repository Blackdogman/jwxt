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
<script>
	$(function() {
		var array = new Array();
		<c:forEach items="${ids}" var="item" >
		array.push("${item}"); //对象，加引号       
		</c:forEach>
		for (var i = 0; i < array.length; i++) {
			$("#" + array[i]).attr("checked", "checked");
		}
	})
</script>
</head>
<body>
	<form action="<%=basePath%>MenuController/fpMenu.do" method="get">
		<input type="hidden" name="roleId" value="${role.roleId }">
		<div class="panel admin-panel">
			<div class="panel-head" id="add">
				<strong><span class="icon-pencil-square-o"></span>分配菜单&nbsp;&nbsp;角色：<font
					color="blue">${role.roleName }${role.roleId }</font></strong>
			</div>
			<div class="body-content">
				<c:forEach items="${menuList }" var="m">
					<div class="field">
						<input type="checkbox" name="menuIds" value="${m.menuId }"
							style="width: auto;" id="${m.menuId }">${m.anthortyName }
						<div class="tips"></div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label></label>
			</div>
			<div class="field">
				<input type="submit" value="提交"
					class="button bg-main icon-check-square-o">
			</div>
		</div>
	</form>
</body>
</html>