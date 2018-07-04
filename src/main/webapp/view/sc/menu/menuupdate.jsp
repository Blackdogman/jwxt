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
	<div class="panel admin-panel">
		<div class="panel-head" id="add">
			<strong><span class="icon-pencil-square-o"></span>修改内容</strong>
		</div>
		<div class="body-content">
			<form method="post" class="form-x"
				action="<%=basePath%>MenuController/add.do">
				<div class="form-group">
					<div class="label">
						<label>父ID：</label>
					</div>
					<div class="field">
						<select name="pId" class="input w50">
							<option value="">---请选择菜单---</option>
							<c:forEach items="${menuList }" var="m">
								<option value="${m.menuId }"
									<c:if test="${m.menuId==menu.pId}">selected</c:if>>${m.anthortyName }</option>
							</c:forEach>
						</select>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>权限名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${menu.anthortyName }" name="anthortyName"
							data-validate="required:请输入用户名" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>权限描述：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${menu.anthortyDesc }" name="anthortyDesc"
							data-validate="required:请输入用户名" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>URL：</label>
					</div>
					<div class="field">
						<input type="text" class="input w50" value="${menu.anthortyUrl }" name="anthortyUrl"
							data-validate="required:请输入用户名" />
						<div class="tips"></div>
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
		</div>
	</div>

</body>
</html>