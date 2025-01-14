package com.bookstore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class adminloginfilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		Object admin = request.getSession().getAttribute("admin");
		String uri = request.getRequestURI(); 
		if (uri.endsWith(".css") || uri.endsWith(".js")) { 
			filter.doFilter(request, resp); 
		}
		if(admin == null) {
			request.setAttribute("error", "尚未登陆");
			//创建一个错误页面跳转过来然后将error信息显示出来，给错误页面设置时间，时间过后自动跳转到登录页面
			//过滤器不过滤js和css文件
			request.getRequestDispatcher("/adminjsps/error.jsp").forward(request, resp);
		}else {
			filter.doFilter(request, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		//System.out.println("舒适化成功");
	}
	
}
