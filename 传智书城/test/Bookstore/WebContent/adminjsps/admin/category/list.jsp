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
	<title>分类列表</title>
	<link rel="stylesheet" type="text/css" href="adminjsps/admin/css/bootstrap.css">
	<script type="text/javascript" src="adminjsps/admin/js/jquery.min.js"></script>
	<script type="text/javascript" src="adminjsps/admin/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="page-header">
		<h2 style="text-align: center;">分类列表</h2>
		<table class="table table-bordered">
			<caption align="right">
				<a  class="btn btn-primary btn-xs active" href="adminjsps/admin/category/add.jsp">添加一级分类</a>
			</caption>
			<tr align="center">
				<th>分类名称</th>
				<th>描述</th>
				<th>操作</th>
			</tr>
			<tr class="info">
				<td>程序设计</td>
				<td>程序设计相关分类</td>
				<td align="right"><a class="btn btn-primary btn-xs active"
					href="adminjsps/admin/category/add2.jsp">添加二级分类</a>
					<a class="btn btn-primary btn-xs active" href="adminjsps/admin/category/edit.jsp">修改</a>
					<a class="btn btn-danger btn-xs active" onclick="return confirm('您是否真要删除该一级分类？')"
					href="javascript:alert('删除一级分类成功！');">删除</a></td>
			</tr>
			<tr >
				<td>Java Javascript</td>
				<td>Java Javascript相关分类</td>
				<td align="right"><a class="btn btn-primary btn-xs active"
					href="adminjsps/admin/category/edit2.jsp">修改</a>
					<a class="btn btn-danger btn-xs active" onclick="return confirm('您是否真要删除该二级分类？')"
					href="javascript:alert('删除二级分类成功！');">删除</a></td>
			</tr>
			<tr >
				<td>JSP</td>
				<td>JSP相关分类</td>
				<td align="right"><a class="btn btn-primary btn-xs active"
					href="adminjsps/admin/category/edit2.jsp">修改</a>
					<a class="btn btn-danger btn-xs active" onclick="return confirm('您是否真要删除该二级分类？')"
					href="javascript:alert('删除二级分类成功！');">删除</a></td>
			</tr>
			<tr >
				<td>C C++ VC VC++</td>
				<td>C C++ VC VC++相关分类</td>
				<td align="right"><a class="btn btn-primary btn-xs active"
					href="adminjsps/admin/category/edit2.jsp">修改</a>
					<a class="btn btn-danger btn-xs active" onclick="return confirm('您是否真要删除该二级分类？')"
					href="javascript:alert('删除二级分类成功！');">删除</a></td>
			</tr>
			<tr class="info">
				<td>办公室用书</td>
				<td>办公室用书相关分类</td>
				<td align="right"><a class="btn btn-primary btn-xs active"
					href="adminjsps/admin/category/add2.jsp">添加二级分类</a>
					<a class="btn btn-primary btn-xs active" href="adminjsps/admin/category/edit.jsp">修改</a>
					<a class="btn btn-danger btn-xs active" onclick="return confirm('您是否真要删除该一级分类？')"
					href="javascript:alert('删除一级分类成功！');">删除</a></td>
			</tr>
			<tr >
				<td>微软Office</td>
				<td>微软Office相关分类</td>
				<td align="right"><a class="btn btn-primary btn-xs active"
					href="adminjsps/admin/category/edit2.jsp">修改</a>
					<a class="btn btn-danger btn-xs active" onclick="return confirm('您是否真要删除该二级分类？')"
					href="javascript:alert('删除二级分类成功！');">删除</a></td>
			</tr>
			<tr >
				<td>计算机初级入门</td>
				<td>计算机初级入门相关分类</td>
				<td align="right">
				<a class="btn btn-primary btn-xs active" href="adminjsps/admin/category/edit2.jsp">修改</a>
				<a class="btn btn-danger btn-xs active" onclick="return confirm('您是否真要删除该二级分类？')"
					href="javascript:alert('删除二级分类成功！');">删除</a></td>
			</tr>


			<tr class="info">
				<td>图形 图像 多媒体</td>
				<td>图形 图像 多媒体相关分类</td>
				<td align="right"><a class="btn btn-primary btn-xs active"
					href="adminjsps/admin/category/add2.jsp">添加二级分类</a>
					<a class="btn btn-primary btn-xs active" href="adminjsps/admin/category/edit.jsp">修改</a>
					<a class="btn btn-danger btn-xs active" onclick="return confirm('您是否真要删除该一级分类？')"
					href="javascript:alert('删除一级分类成功！');">删除</a></td>
			</tr>
				<tr>
				<td>Photoshop</td>
				<td>Photoshop相关分类</td>
				<td align="right">
				<a class="btn btn-primary btn-xs active" href="adminjsps/admin/category/edit2.jsp">修改</a>
				<a class="btn btn-danger btn-xs active" onclick="return confirm('您是否真要删除该二级分类？')"
					href="javascript:alert('删除二级分类成功！');">删除</a></td>
			</tr>
		</table>
		<div class="pull-right">
			<ul class="pagination">
			    <li><a href="#">&laquo;</a></li>
			    <li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li><a href="#">&raquo;</a></li>
			</ul>
		</div>
	</div>
</body>
</html>