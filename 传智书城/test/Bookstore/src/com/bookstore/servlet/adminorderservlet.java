package com.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.po.Book;
import com.bookstore.po.Category;
import com.bookstore.po.Order;
import com.bookstore.service.orderservice;
import com.bookstore.util.PageBean;

/**
 * Servlet implementation class adminorderservlet
 */
@WebServlet("/adminorderservlet")
public class adminorderservlet extends BaseServlet {
	orderservice o = new orderservice();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminorderservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private int getPc(HttpServletRequest req) {
		int pc=1;
		String param =req.getParameter("pc");
		if(param != null && !param.trim().isEmpty()) {
			pc = Integer.parseInt(param);
		}
		return pc;
	}
	public String getUrl(HttpServletRequest req) {
		String url = req.getRequestURI()+"?"+req.getQueryString();
		int index = url.lastIndexOf("&pc=");
		if(index != -1 ) {
			url= url.substring(0,index);
		}
		return url;
	}
    
	public String fingall(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
				int pc=getPc(req);
				String url = getUrl(req);
				PageBean<Order> pb = o.findall(pc);
				pb.setUrl(url);
				req.setAttribute("pb", pb);
				return "f:/adminjsps/admin/order/list.jsp";
		}
	
	public String findbystatus(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
				int pc=getPc(req);
				String url = getUrl(req);
				String status1 = req.getParameter("status");
				int status = Integer.parseInt(status1);
				PageBean<Order> pb = o.findbystatus(status, pc);
				pb.setUrl(url);
				req.setAttribute("pb", pb);
				return "f:/adminjsps/admin/order/list.jsp";
	}
	public String load(HttpServletRequest req,HttpServletResponse res) 
			throws ServletException,IOException{
				String oid = req.getParameter("oid");
				Order oo = o.load(oid);
				req.setAttribute("order", oo);
				String btn = req.getParameter("btn");
				req.setAttribute("btn", btn);
				return "f:/adminjsps/admin/order/desc.jsp";
	}
	public String cancel(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String oid = req.getParameter("oid");
		int status = o.findstatus(oid);
		if(status !=1) {
			req.setAttribute("code", "error");
			req.setAttribute("msg", "订单状态错误不能取消！");
			return "f:/adminjsps/msg.jsp";
		}
		o.updatestatus(oid, 5);
		req.setAttribute("code", "sucess");
		req.setAttribute("msg","订单已取消");
		return "f:/adminjsps/msg.jsp";
	}
	public String deliver(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String oid =  req.getParameter("oid");
		int status = o.findstatus(oid);
		if(status !=2) {
			req.setAttribute("code", "error");
			req.setAttribute("msg", "订单状态错误不能发货！");
			return "f:/adminjsps/msg.jsp";
		}
		o.updatestatus(oid, 3);
		req.setAttribute("code", "sucess");
		req.setAttribute("msg","订单已发货");
		return "f:/adminjsps/msg.jsp";
	}
}
