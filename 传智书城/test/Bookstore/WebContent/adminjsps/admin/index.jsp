<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value='css/bootstrap.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='css/font-awesome.min.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='css/b.tabs.css'/>">
<style type="text/css">
div.menuSideBar li.nav-header {
	font-size: 14px;
	padding: 3px 15px;
}

div.menuSideBar .nav-list>li>a, div.menuSideBar .dropdown-menu li a {
	-webkit-border-radius: 0px;
	-moz-border-radius: 0px;
	-ms-border-radius: 0px;
	border-radius: 0px;
}
</style>

</head>
<body>

	<div class="content">
		<div class="container">
			<h3 class="page-header"><span class="glyphicon glyphicon-book"></span> 网上书城管理系统</h3>
			<div>
				<div class="row-fluid">
					<div class="col-md-2" style="padding-left: 0px;">
						<div class="well menuSideBar" style="padding: 8px 0px;">
							<ul class="nav nav-list" id="menuSideBar">
								<li class="nav-header">导航菜单</li>
								<li class="nav-divider"></li>
								<li mid="tab1" funurl="<c:url value='/admincategoryservlet?method=findall'/>"><a
									tabindex="-1" href="javascript:void(0);">分类管理</a></li>
								<li mid="tab2" funurl="<c:url value='/adminbookservlet?method=findbycombination'/>"><a
									tabindex="-1" href="javascript:void(0);">图书管理</a></li>
								<li mid="tab3" funurl="<c:url value='/adminorderservlet?method=fingall'/>"><a
									tabindex="-1" href="javascript:void(0);">订单管理</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-10" id="mainFrameTabs" style="padding: 0px;">
						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active noclose"><a
								href="#bTabs_navTabsMainPage" data-toggle="tab">首页</a></li>
						</ul>
						<!-- Tab panes -->
						<div class="tab-content">
							<div class="tab-pane active" id="bTabs_navTabsMainPage">
								<div class="page-header">
									<h2
										style="font-size: 31.5px; text-align: center; font-weight: normal;">欢迎使用</h2>
								</div>
								<div style="text-align: center; font-size: 20px; line-height: 20px;">
									Welcome to use bTabs plugin!
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/b.tabs.js"></script>
	<script type="text/javascript" src="js/demo.js"></script>
</body>
</html>
