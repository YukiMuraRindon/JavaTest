package com.bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.po.Admin;
import com.bookstore.service.adminservice;

/**
 * Servlet implementation class adminservlet
 */
@WebServlet("/adminservlet")
public class adminservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public adminservlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取登录的请求的参数
		String method = request.getParameter("method");
		if(method.equals("login")) {
			this.login(request,response);
		}
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("adminname");
		String pwd = request.getParameter("adminpwd");
		Admin a = new Admin(name,pwd);
		adminservice b = new adminservice();
		Admin admin = b.login(a);
		if(admin == null) {
			request.setAttribute("msg","登录失败");
			request.getRequestDispatcher("adminjsps/error.jsp").forward(request,response);
			//response.setHeader("Refresh","3;url=adminjsps/error.jsp");
		}else {
			request.setAttribute("msg","登录成功");
			request.getSession().setAttribute("admin",admin);
			response.sendRedirect("adminjsps/admin/index.jsp");

		}
		
	}

}
