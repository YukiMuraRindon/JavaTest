<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>图书分类</title>
<link rel="stylesheet" type="text/css" href="<c:url value='adminjsps/admin/css/bootstrap.css'/>">
<script type="text/javascript" src="<c:url value='adminjsps/admin/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='adminjsps/admin/js/bootstrap.min.js'/>"></script>
<style type="text/css">
.td {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
<script type="text/javascript">
	function LoadChildren() {
		/*
		1. 获取pid
		2. 发出异步请求，功能之：
		  3. 得到一个数组
		  4. 获取cid元素(<select>)，把内部的<option>全部删除
		  5. 添加一个头（<option>请选择2级分类</option>）
		  6. 循环数组，把数组中每个对象转换成一个<option>添加到cid中
		 */
		// 1. 获取pid
		var pid = $("#pid").val();
		// 2. 发送异步请求
		$.ajax({
			async : true,
			cache : false,
			url : "/Bookstore/adminbookservlet",
			data : {
				method : "ajaxfindchildren",
				pid : pid
			},
			type : "POST",
			dataType : "json",
			success : function(json) {
				// 3. 得到cid，删除它的内容
				//console.log(arr);
				$("#cid").empty();//删除元素的子元素
				$("#cid").append($("<option value=\"\">====请选择2级分类====</option>"));//4.添加头
				// 5. 循环遍历数组，把每个对象转换成<option>添加到cid中
				for (var i = 0; i < json.length; i++) {
					var option = $("<option>").val(json[i].cid).text(
							json[i].cname);
					$("#cid").append(option);
				}
			},
			error : function(json){
				console.log(json);
			}
		});
	}
</script>
</head>
<body>
	<div class="page-header">
		<form class="form-inline" action="adminbookservlet">
			<input type="hidden" name="method" value="findbycombination">
			<div class="form-group">
				<label for="pid">一级分类:</label> 
				<select class="form-control input-sm" id="pid" name="pid" onchange="LoadChildren()">
					<option value="" selected='selected'>===选择1级分类===</option>
					<c:forEach items="${parents}" var="parent">
						<option value="${parent.cid}">${parent.cname}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="cid ">二级分类:</label> 
				<select class="form-control input-sm" id="cid" name="cid">
					<option value="">====请选择2级分类====</option>
				</select>
			</div>
			<div class="input-group">
				<input type="text" name="bname" class="form-control" placeholder="请输入你要查询的书名">
				<span class="input-group-btn"> 
					<button class="btn  btn-info" type="submit">搜索</button>
				</span>
			</div>
			<div class="input-group pull-right">
				<a class="btn btn-primary btn-xs active" href="<c:url value='/adminbookservlet?method=addPre'/>">添加图书</a>
			</div>
			<!-- /input-group -->
		</form>
		<br />
		<table class="table table-condensed" style="table-layout: fixed;">
			<tr>
				<th width="200px">书名</th>
				<th>封面</th>
				<th>定价</th>
				<th>折扣</th>
				<th>当前价</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${pb.beanList}" var="book">
				<tr>
					<td class="td"><a href="<c:url value='/adminbookservlet?method=load&bid=${book.bid}'/>">${book.bname}</a>
					</td>
					<td>
						<a href="<c:url value='/adminbookservlet?method=load&bid=${book.bid}'/>"> 
							<img border="0" width="70" src="<c:url value='/${book.image_b}'/>" />
						</a>
					</td>
					<td>&yen;${book.price}</td>
					<td>${book.discount}折</td>
					<td>&yen;${book.currPrice}</td>
					<td>
						<a class="btn btn-primary btn-xs active" href="<c:url value='/adminbookservlet?method=editPre&bid=${book.bid}'/>">修改</a> 
						<a class="btn btn-danger btn-xs active" onclick="return confirm('您是否真要删除该书？')" href="<c:url value='/adminbookservlet?method=delete&bid=${book.bid}'/>">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div class="pull-right">
			<%@include file="/adminjsps/pager/pager.jsp" %>
		</div>
	</div>
</body>
</html>