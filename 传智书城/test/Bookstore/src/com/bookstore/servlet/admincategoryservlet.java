package com.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.po.Category;
import com.bookstore.service.admincategoryservice;
import com.bookstore.util.CommonUtils;

/**
 * Servlet implementation class admincategoryservlet
 */
@WebServlet("/admincategoryservlet")
public class admincategoryservlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	admincategoryservice cc = new admincategoryservice();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admincategoryservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public String findall(HttpServletRequest req,HttpServletResponse res) 
    	throws ServletException,IOException{
    		
    		List<Category> list = cc.findall();
    		req.setAttribute("parents", list);
	    	return "adminjsps/admin/category/list.jsp";
    }
    public String addParent(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
    	String name=req.getParameter("cname");
    	String cname = new String(name.getBytes("ISO-8859-1"),"UTF-8");
    	String ddesc = req.getParameter("desc");
    	String desc = new String(ddesc.getBytes("ISO-8859-1"),"UTF-8");
    	Category c = new Category();
    	c.setCname(cname);
    	c.setDesc(desc);
    	c.setCid(CommonUtils.uuid());
    	cc.addParent(c);  
    	return findall(req,res);
    }
    public String addChild(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
    	String pid = req.getParameter("pid");
    	List<Category> list = cc.findbyparents();
    	req.setAttribute("pid", pid);
    	req.setAttribute("parents", list);
    	
    	return "adminjsps/admin/category/add2.jsp";
    }
    public String addChildren(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
    	String name=req.getParameter("cname");
    	String cname = new String(name.getBytes("ISO-8859-1"),"UTF-8");
    	String ddesc = req.getParameter("desc");
    	String desc = new String(ddesc.getBytes("ISO-8859-1"),"UTF-8");
    	String pid = req.getParameter("pid");
    	Category c = new Category();
    	c.setCname(cname);
    	c.setDesc(desc);
    	c.setPid(pid);
    	c.setCid(CommonUtils.uuid());
    	cc.addParent(c);  
    	return findall(req,res);
    }

}
