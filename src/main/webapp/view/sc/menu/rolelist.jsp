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
	<form method="post" action="">
		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder"> 留言管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">
					<li>
						
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="120">ID</th>
					<th>角色名称</th>
					<th>描述</th>
					<th>状态</th>
					<th>创建时间</th>
					<th colspan="2">操作</th>
				</tr>
				<c:forEach items="${roleList }" var="role">
					<tr>
						<td><input type="checkbox" name="id[]" value="1" /></td>
						<td>${role.roleName }</td>
						<td>${role.roleDesc }</td>
						<td>${role.roleState }</td>
						<td><fmt:formatDate value="${role.createTime }"/>
						
					</td>
						<td><div class="button-group">
								<a class="button border-blue"
									href="<%=basePath%>RoleController/fpRoleUI.do?userLoginName=${userLoginName}"
									"><span class="icon-trash-o"></span>
									分配角色</a> 
							</div></td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
	<script type="text/javascript">
		function del(id) {
			if (confirm("您确定要删除吗?")) {

			}
		}

		$("#checkall").click(function() {
			$("input[name='id[]']").each(function() {
				if (this.checked) {
					this.checked = false;
				} else {
					this.checked = true;
				}
			});
		})

		function DelSelect() {
			var Checkbox = false;
			$("input[name='id[]']").each(function() {
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
	</script>
</body>
</html>