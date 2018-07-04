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
						<button type="button" class="button border-green" id="checkall">
							<span class="icon-check"></span> 全选
						</button>
						<button type="submit" class="button border-red">
							<span class="icon-trash-o"></span> 批量删除
						</button> <a href="<%=basePath%>MenuController/addUI.do"
						class="button border-blue"><span class="icon-trash-o"></span>增加</a>
					</li>
				</ul>
			</div>
			<table class="table table-hover text-center">
				<tr>
					<th width="120">ID</th>
					<th>父ID</th>
					<th>名称</th>
					<th>描述</th>
					<th>URL</th>
					<th>创建时间</th>
					<th colspan="2">操作</th>
				</tr>
				<c:forEach items="${menulist }" var="menu">
					<tr>
						<td><input type="checkbox" name="id[]" value="1" /></td>
						<td>${menu.pId }</td>
						<td>${menu.anthortyName }</td>
						<td>${menu.anthortyDesc }</td>
						<td>${menu.anthortyUrl }</td>
						<td><fmt:formatDate value="${menu.createTime }"/>
						
					</td>
						<td><div class="button-group">
								<a class="button border-red"
									href="<%=basePath%>MenuController/delete.do?menuId=${menu.menuId }"
									onclick="return del(1)"><span class="icon-trash-o"></span>
									删除</a> <a class="button border-green"
									href="<%=basePath%>MenuController/updateUI.do?menuId=${menu.menuId }"><span
									class="icon-trash-o"></span> 修改</a>
									<a class="button border-blue"
									href="<%=basePath%>MenuController/fpMenuUI.do?roleId=${roleid }"><span
									class="icon-trash-o"></span> 分配</a>
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