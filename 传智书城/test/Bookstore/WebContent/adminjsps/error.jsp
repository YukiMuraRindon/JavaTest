<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String url = "http://localhost:8080/Bookstore/adminjsps/login.jsp";
%> 
<html>
   <head>            
   		<meta http-equiv=refresh content=5;url=<%=url %>>           
   </head> 
       <body>
       	<div align="center">
			<h2 style=color:red>请使用您的账号登陆系统</h2>
			<h2 style=color:red><span id=jump>5</span> 秒钟后页面将自动返回登录页面...</h2>
		</div>     
      </body>
        <script type="text/javascript">  
			//设定倒数秒数  
			var t = 5;  
			//显示倒数秒数  
			function showTime(){  
			    t -= 1;  
			    document.getElementById('jump').innerHTML= t;  
			    if(t==0){  
			        location.href=url;  
			    }  
			    //每秒执行一次,showTime()  
			    setTimeout("showTime()",800);  
			}  
			//执行showTime()  
			showTime();  
		</script>
</html> 