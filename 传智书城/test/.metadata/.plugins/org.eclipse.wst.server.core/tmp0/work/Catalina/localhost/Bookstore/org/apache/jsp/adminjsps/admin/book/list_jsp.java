/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.42
 * Generated at: 2019-07-02 09:18:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.adminjsps.admin.book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>图书分类</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\thref=\"adminjsps/admin/css/bootstrap.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"adminjsps/admin/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"adminjsps/admin/js/bootstrap.min.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".td {\r\n");
      out.write("\twhite-space:nowrap;\r\n");
      out.write("   \toverflow:hidden;\r\n");
      out.write("   \ttext-overflow:ellipsis;  \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"page-header\">\r\n");
      out.write("\t\t<div align=\"right\">\r\n");
      out.write("\t\t\t<a class=\"btn btn-primary btn-xs active\"\r\n");
      out.write("\t\t\t\thref=\"adminjsps/admin/book/add.jsp\">添加图书</a>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form class=\"form-inline\">\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label for=\"exampleInput\">一级分类:</label> <select\r\n");
      out.write("\t\t\t\t\tclass=\"form-control input-sm\" id=\"exampleInput\">\r\n");
      out.write("\t\t\t\t\t<option value=\"\" selected='selected'>===选择1级分类===</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"1\">程序设计</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"2\">办公室用书</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"3\">图形 图像 多媒体</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label for=\"exampleInput2 input-sm\">二级分类:</label> <select\r\n");
      out.write("\t\t\t\t\tclass=\"form-control\" id=\"exampleInput2\">\r\n");
      out.write("\t\t\t\t\t<option value=\"\" selected='selected'>===选择2级分类===</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"1\">Java Javascript</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"2\">JSP</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"3\">C C++ VC VC++</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"请输入你要查询的书名\">\r\n");
      out.write("\t\t\t\t<span class=\"input-group-btn\">\r\n");
      out.write("\t\t\t\t\t<button class=\"btn  btn-info\" type=\"submit\">搜索</button>\r\n");
      out.write("\t\t\t\t</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /input-group -->\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t<table class=\"table table-condensed\" style=\"table-layout:fixed;\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th width=\"200px\">书名</th>\r\n");
      out.write("\t\t\t\t<th>封面</th>\r\n");
      out.write("\t\t\t\t<th>定价</th>\r\n");
      out.write("\t\t\t\t<th>折扣</th>\r\n");
      out.write("\t\t\t\t<th>现价</th>\r\n");
      out.write("\t\t\t\t<th>一级分类</th>\r\n");
      out.write("\t\t\t\t<th width=\"160px\">二级分类</th>\r\n");
      out.write("\t\t\t\t<th>操作</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"td\"><a href=\"adminjsps/admin/book/desc.jsp\">Spring实战(第3版)（In\r\n");
      out.write("\t\t\t\t\tAction系列中最畅销的Spring图书，近十万读者学习Spring的共同选择）</a></td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<a href=\"adminjsps/admin/book/desc.jsp\">\r\n");
      out.write("\t\t\t\t\t\t<img border=\"0\" width=\"70\"src=\"");
      out.print(path);
      out.write("/book_img/23254532-1_b.jpg\" />\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>&yen;59</td>\r\n");
      out.write("\t\t\t\t<td>6.7折</td>\r\n");
      out.write("\t\t\t\t<td>&yen;40.7</td>\r\n");
      out.write("\t\t\t\t<td>程序设计</td>\r\n");
      out.write("\t\t\t\t<td>Java JavaScript</td>\r\n");
      out.write("\t\t\t\t<td><a class=\"btn btn-primary btn-xs active\"\r\n");
      out.write("\t\t\t\t\thref=\"adminjsps/admin/book/edit.jsp\">修改</a> <a\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger btn-xs active\"\r\n");
      out.write("\t\t\t\t\tonclick=\"return confirm('您是否真要删除该二级分类？')\"\r\n");
      out.write("\t\t\t\t\thref=\"javascript:alert('删除二级分类成功！');\">删除</a></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"td\"><a href=\"adminjsps/admin/book/desc.jsp\">Spring实战(第3版)（In\r\n");
      out.write("\t\t\t\t\tAction系列中最畅销的Spring图书，近十万读者学习Spring的共同选择）</a></td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<a href=\"adminjsps/admin/book/desc.jsp\">\r\n");
      out.write("\t\t\t\t\t\t<img border=\"0\" width=\"70\"src=\"");
      out.print(path);
      out.write("/book_img/23254532-1_b.jpg\" />\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>&yen;59</td>\r\n");
      out.write("\t\t\t\t<td>6.7折</td>\r\n");
      out.write("\t\t\t\t<td>&yen;40.7</td>\r\n");
      out.write("\t\t\t\t<td>程序设计</td>\r\n");
      out.write("\t\t\t\t<td>Java JavaScript</td>\r\n");
      out.write("\t\t\t\t<td><a class=\"btn btn-primary btn-xs active\"\r\n");
      out.write("\t\t\t\t\thref=\"adminjsps/admin/book/edit.jsp\">修改</a> <a\r\n");
      out.write("\t\t\t\t\tclass=\"btn btn-danger btn-xs active\"\r\n");
      out.write("\t\t\t\t\tonclick=\"return confirm('您是否真要删除该图书？')\"\r\n");
      out.write("\t\t\t\t\thref=\"javascript:alert('删除成功！');\">删除</a></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<div class=\"pull-right\">\r\n");
      out.write("\t\t\t<ul class=\"pagination\">\r\n");
      out.write("\t\t\t    <li><a href=\"#\">&laquo;</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">1</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">2</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">3</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">4</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">5</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">&raquo;</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
