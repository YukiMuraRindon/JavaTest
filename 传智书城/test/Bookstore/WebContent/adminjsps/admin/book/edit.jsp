<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
<title>添加图书</title>
<link rel="stylesheet" type="text/css" href="<c:url value='adminjsps/admin/css/bootstrap.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='jquery/jquery.datepick.css'/>">
<script type="text/javascript" src="<c:url value='adminjsps/admin/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='jquery/jquery.datepick.js'/>"></script>
<script type="text/javascript" src="<c:url value='jquery/jquery.datepick-zh-CN.js'/>"></script>
<script type="text/javascript" src="<c:url value='adminjsps/admin/js/bootstrap.min.js'/>"></script>
<script type="text/javascript">
$(function () {
	$("#publishtime").datepick({dateFormat:"yyyy-mm-dd"});
	$("#printtime").datepick({dateFormat:"yyyy-mm-dd"});

	$("#btn").click(function() {
		var bname = $("#bname").val();
		var currprice = $("#currPrice").val();
		var price = $("#price").val();
		var discount = $("#discount").val();
		var author = $("#author").val();
		var press = $("#press").val();
		var pid = $("#pid").val();
		var cid = $("#cid").val();
		var image_w = $("#image_w").val();
		var image_b = $("#image_b").val();
		if(!bname || !currprice || !price || !discount || !author || !press || !pid || !cid || !image_w || !image_b) {
			alert("图名、当前价、定价、折扣、作者、出版社、1级分类、2级分类、大图、小图都不能为空！");
			return false;
		}
		
		if(isNaN(currprice) || isNaN(price) || isNaN(discount)) {
			alert("当前价、定价、折扣必须是合法小数！");
			return false;
		}
		$("#form").submit();
	});
});
function loadChildren() {
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
		url : "/Bookstore/admin/adminbookservlet",
		data : {
			method : "ajaxfindchildren",
			pid : pid
		},
		type : "POST",
		dataType : "json",
		success : function(arr) {
			// 3. 得到cid，删除它的内容
			$("#cid").empty();//删除元素的子元素
			$("#cid").append($("<option value=\"\">====请选择2级分类====</option>"));//4.添加头
			// 5. 循环遍历数组，把每个对象转换成<option>添加到cid中
			for (var i = 0; i < arr.length; i++) {
				var option = $("<option>").val(arr[i].cid).text(
						arr[i].cname);
				$("#cid").append(option);
			}
		}
	});
}
</script>
</head>
<body>
	<div class="page-header">
		<h3 align="center">修改图书</h3><br/>
		<p style="font-weight: 900; color: red;">${msg}</p>
		<form class="form-horizontal" action="<c:url value='/adminupdatebookservlet'/>"
			enctype="multipart/form-data" method="post" id="form">
			<input type="hidden" class="form-control" id="bid" name="bid" value="${book.bid}"/>
			<div class="form-group">
				<label for="bname" class="col-sm-2 control-label">书名：</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="bname" name="bname" value="${book.bname}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="image_w" class="col-sm-2 control-label">大图：</label>
				<div class="col-sm-6">
					<input type="file" class="form-control" id="image_w" name="image_w" />
				</div>
			</div>
			<div class="form-group">
				<label for="image_b" class="col-sm-2 control-label">小图：</label>
				<div class="col-sm-6">
					<input type="file" class="form-control" id="image_b" name="image_b"/>
				</div>
			</div>
			<div class="form-group">
				<label for="price" class="col-sm-2 control-label">当前价格：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="currPrice" name="currPrice" value="${book.currPrice}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="disprice" class="col-sm-2 control-label">定价：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="price" name="price" value="${book.price}"/>
				</div>
				<label for="discount" class="col-sm-1 control-label">折扣：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="discount" name="discount" value="${book.discount}"/>
				</div>
				<label for="discount" class="control-label pull-left">折</label>
			</div>
			<hr/>
			<div class="form-group">
				<label for="author" class="col-sm-2 control-label">作者：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="author" name="author" value="${book.author}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="press" class="col-sm-2 control-label">出版社：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="press" id="press" value="${book.press}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="publishtime" class="col-sm-2 control-label">出版时间：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" id="publishtime" name="publishtime" value="${book.publishtime}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="edition" class="col-sm-2 control-label">版次：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="edition" id="edition" value="${book.edition}"/>
				</div>
				<label for="pageNum" class="col-sm-1 control-label">页数：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="pageNum" id="pageNum" value="${book.pageNum}"/>
				</div>
				<label for="wordNum" class="col-sm-1 control-label">字数：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="wordNum" id="wordNum" value="${book.wordNum}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="printtime" class="col-sm-2 control-label">印刷时间：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="printtime" id="printtime" value="${book.printtime }"/>
				</div>
				<label for="booksize" class="col-sm-1 control-label">开本：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="booksize" id="booksize" value="${book.booksize}"/>
				</div>
				<label for="paper" class="col-sm-1 control-label">纸张：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="paper" id="paper" value="${book.paper}"/>
				</div>
			</div>
			<div class="form-group">
				<label for="pid" class="col-sm-2 control-label">一级分类：</label>
				<div class="col-sm-3">
					<select name="pid" id="pid" class="form-control" onchange="loadChildren()">
						<option value="" selected='selected'>===选择1级分类===</option>
						<c:forEach items="${parents}" var="parents">
							<option value="${parents.cid}" <c:if test="${parents.cid eq book.pid}">selected="selected"</c:if>>${parents.cname}</option>
						</c:forEach>
					</select>
				</div>
				<label for="cid" class="col-sm-2 control-label">二级分类：</label>
				<div class="col-sm-3">
					<select name="cid" id="cid" class="form-control" >
						<c:forEach items="${childs}" var="childs">
							<option value="${childs.cid}" <c:if test="${childs.cid eq book.cid}">selected="selected"</c:if>>${childs.cname}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<br/>
			<div class="form-group">
				<div class="col-sm-offset-8 col-sm-3">
					<button type="button" id="btn" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-primary" onclick="history.go(-1)">返回列表</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>