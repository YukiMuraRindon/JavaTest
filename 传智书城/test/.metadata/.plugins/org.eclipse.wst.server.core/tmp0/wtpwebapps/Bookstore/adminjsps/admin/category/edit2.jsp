<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="adminjsps/admin/css/bootstrap.css">
<script type="text/javascript" src="adminjsps/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="adminjsps/admin/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function checkForm() {
			if(!$("#cname").val()) {
				alert("分类名不能为空！");
				return false;
			}
			if(!$("#pid").val()) {
				alert("一级分类不能为空！");
				return false;
			}
			if(!$("#desc").val()) {
				alert("分类描述不能为空！");
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<div class="page-header">
		<h3 align="center">修改二级分类</h3><br/>
		<p style="font-weight: 900; color: red">${msg}</p>
		<form class="form-horizontal"
			action="adminjsps/admin/category/list.jsp>" method="post"
			onsubmit="return checkForm()">
			<input type="hidden" name="cid" value=""/>
			<div class="form-group">
				<label for="cname" class="col-sm-offset-1 col-sm-2 control-label">一级分类：</label>
				<div class="col-sm-7">
					<select class="form-control">
			    		<option value="">===选择1级分类===</option>
			    		<option value="1"  selected='selected'>程序设计</option>
			    		<option value="2">办公室用书</option>
			    		<option value="3">图形 图像 多媒体</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="cname" class="col-sm-offset-1 col-sm-2 control-label">分类名称：</label>
				<div class="col-sm-7">
					<input type="text" name="cname" id="cname" class="form-control"
						value="Java Javascript">
				</div>
			</div>
			<div class="form-group">
				<label for="desc" class="col-sm-offset-1 col-sm-2 control-label">分类描述：</label>
				<div class="col-sm-7">
					<textarea name="desc" id="desc" rows="5" cols="50" class="form-control">Java Javascript分类</textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-7 col-sm-3">
					<button type="submit" class="btn btn-primary">修改二级分类</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-primary" onclick="history.go(-1)">返回列表</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>