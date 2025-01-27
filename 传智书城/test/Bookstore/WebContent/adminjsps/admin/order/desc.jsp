<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>订单详情</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/bootstrap.css'/>">
<script type="text/javascript" src="<c:url value='/adminjsps/admin/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/adminjsps/admin/js/bootstrap.min.js'/>"></script>
<style>
.divRow {
	border: 2px solid #e9c9b2;
	margin-top:10px;
	padding-top: 10px;
	padding-bottom: 10px;
	padding-left: 20px;
	padding-right: 20px;
}
.td {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="page-header">
		<div class="row">
			<div class="col-xs-10">
				<strong>订单号：</strong>${order.oid}(
				<c:choose>
					<c:when test="${order.status eq 1 }">等待付款</c:when>
					<c:when test="${order.status eq 2 }">准备发货</c:when>
					<c:when test="${order.status eq 3 }">等待确认</c:when>
					<c:when test="${order.status eq 4 }">交易成功</c:when>
					<c:when test="${order.status eq 5 }">已取消</c:when>
				</c:choose>
				)&nbsp;&nbsp;
				<strong>下单时间：</strong>${order.ordertime}
			</div>
			<div class="col-xs-2">
				<input  type="button"  class="btn btn-primary active" onclick="history.go(-1)" value="返回列表"/>
			</div>
		</div>
		
		<div class="divRow">
			<dl>
				<dt>收货人信息</dt>
				<dd>${order.address }</dd>
			</dl>
			<dl>
				<dt>商品清单</dt>
			</dl>
			<table class="table">
				<tr class="active"> 
					<th colspan="2">商品名称</th>
					<th align="left" width="50px">单价</th>
					<th align="left" width="50px">数量</th>
					<th align="left" width="50px">小计</th>
				</tr>
				<c:forEach items="${order.orderItemList }" var="orderItem">
					<tr>
						<td width="75px">
							<img width="70" src="<c:url value='/${orderItem.image_b }'/>" />
						</td>
						<td >${orderItem.bname }</td>
						<td>&yen;${orderItem.currPrice }</td>
						<td>${orderItem.quantity }</td>
						<td>&yen;${orderItem.subtotal }</td>
					</tr>
				</c:forEach>
			</table>
			<div align="right">
				<strong>合　　计：</strong>
				<strong class="text-warning">&yen;${order.total }</strong><br/><br/>
				<c:if test="${order.status eq 2 and btn eq 'deliver' }">
					<a id="deliver" class="btn btn-primary btn-xs active" href="<c:url value='/adminorderservlet?method=deliver&oid=${order.oid }'/>">发　　货</a>
				</c:if>
				<c:if test="${order.status eq 1 and btn eq 'cancel' }">
					<a id="cancel" class="btn btn-primary btn-xs active" href="<c:url value='/adminorderservlet?method=cancel&oid=${order.oid }'/>">取　　消</a>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>