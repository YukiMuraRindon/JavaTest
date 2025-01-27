<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员登录页</title>
<link rel="stylesheet" type="text/css" href="<c:url value='admin/css/bootstrap.css'/>">
<script type="text/javascript" src="<c:url value='admin/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='admin/js/bootstrap.min.js'/>"></script>
<style type="text/css">
	.title{
		margin-top: 100px;
		margin-left: 20px;
	}
	.center-block {
		height:200px;
		background-color:#D1EEEE;
		padding-top:40px;
		margin-top: 50;
	}
</style>
	<script type="text/javascript">
		function checkForm() {
			if(!$("#adminname").val()) {
				alert("管理员名称不能为空！");
				return false;
			}
			if(!$("#adminpwd").val()) {
				alert("管理员密码不能为空！");
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<div class="title">
		<h2>管理员登录</h2>
	</div>
	<div class="center-block">
	    <form class="form-horizontal" action="<c:url value='/adminservlet'/>" method="post" onsubmit="return checkForm()">
		<input type="hidden" name="method" value="login"/>
			<div class="form-group">
				<label for="adminname" class="col-sm-5 control-label">管理员账号：</label>
				<div class="col-sm-3">
					<input type="text" name="adminname" class="form-control" id="adminname"
						placeholder="管理员账号">
				</div>
				
			</div>
			<div class="form-group">
				<label for="adminpwd" class="col-sm-5 control-label">密码：</label>
				<div class="col-sm-3">
					<input type="password" name="adminpwd" class="form-control" id="adminpwd"
						placeholder="密码">
				</div>
				
			</div>
			<center><font color = "red">${msg}</font>
			<div class="form-group">
				<div class="col-sm-offset-7 col-sm-4">
					<button type="submit" class="btn  btn-primary">进入后台</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>