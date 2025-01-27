package com.bookstore.servlet;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bookstore.po.Book;
import com.bookstore.service.adminbookservice;
import com.bookstore.service.admincategoryservice;

import cn.itcast.commons.CommonUtils;

/**
 * Servlet implementation class adminupdatebookservlet
 */
@WebServlet("/adminupdatebookservlet")
public class adminupdatebookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminupdatebookservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		FileItemFactory f = new DiskFileItemFactory();
		ServletFileUpload s = new ServletFileUpload(f);
		s.setFileSizeMax(80*1024*1024);
		List<FileItem> file =  null;
		try {
			file=s.parseRequest(request);
		} catch (FileUploadException e) {
			//文件过大
			error("上传的图片大于80M",request,response);
			e.printStackTrace();
			return;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		for(FileItem fileitem:file) {
			if(fileitem.isFormField()) {
				map.put(fileitem.getFieldName(),fileitem.getString("utf-8"));
				
			}
		}
		Book b = new Book();
		try {
			BeanUtils.populate(b, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileItem fileitem = file.get(2);
		String filename = fileitem.getName();
		//System.out.print("+++++++++++++++++++++33333+"+fileitem.getName());
		int index = filename.lastIndexOf("\\");
		if(index!=-1) {
			filename = filename.substring(index+1);
		}
		filename = CommonUtils.uuid()+"_"+filename;
		if(!filename.toLowerCase().endsWith(".jpg")) {
			//文件后缀名不符
			error("上传的图片后缀名不符",request,response);
			return;
		}
		String path = this.getServletContext().getRealPath("/book_img");
		File destfile = new File(path,filename);
		try {
			fileitem.write(destfile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(destfile.getAbsolutePath());
		Image image = icon.getImage();
		if(image.getWidth(null)> 1000 || image.getHeight(null)> 1000) {
			destfile.delete();
			error("上传的图片大于1k*1k",request,response);
			return;
		}
		b.setImage_w("book_img/"+filename);
		//获取第二个图片
		
		FileItem fileitem1 = file.get(3);
		String filename1 = fileitem1.getName();
		int index1 = filename1.lastIndexOf("\\");
		if(index1!=-1) {
			filename1 = filename1.substring(index1+1);
		}
		filename1 = CommonUtils.uuid()+"_"+filename1;
		if(!filename1.toLowerCase().endsWith(".jpg")) {
			//文件后缀名不符
		}
		String path1 = this.getServletContext().getRealPath("/book_img");
		File destfile1 = new File(path1,filename1);
		try {
			fileitem1.write(destfile1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon1 = new ImageIcon(destfile1.getAbsolutePath());
		Image image1 = icon1.getImage();
		if(image1.getWidth(null)> 1000 || image1.getHeight(null)> 1000) {
			destfile1.delete();
		}
		b.setImage_b("book_img/"+filename1);
		adminbookservice a = new adminbookservice();
		try {
			a.edit(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			error("输入有误！请检查输入字段",request,response);
		}
		request.setAttribute("msg", "修改成功");
		request.getRequestDispatcher("adminjsps/msg.jsp").forward(request, response);
		
	}
	private void error(String msg,HttpServletRequest req,HttpServletResponse res) 
		throws ServletException,IOException{
		req.setAttribute("msg",msg);
		req.setAttribute("parents",new admincategoryservice().findbyparents());
		req.getRequestDispatcher("adminjsps/admin/book/edit.jsp").forward(req,res);
		
	}

}
