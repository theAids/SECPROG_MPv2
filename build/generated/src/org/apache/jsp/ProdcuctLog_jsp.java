package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Bean.ProductLogBean;
import DAO.Implementation.ProductlogImplementation;
import java.util.ArrayList;
import Bean.ProductBean;

public final class ProdcuctLog_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("        <title>Foobar</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap core CSS -->\r\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"scss/stylesheets/screen.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"css/bootstrap-table.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"css/datepicker.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap-table.js\"></script>\r\n");
      out.write("        <script src=\"js/bootstrap-datepicker.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <script>\r\n");
      out.write("            function loadXMLDoc()\r\n");
      out.write("            {\r\n");
      out.write("                var xmlhttp;\r\n");
      out.write("                if (window.XMLHttpRequest)\r\n");
      out.write("                {// code for IE7+, Firefox, Chrome, Opera, Safari\r\n");
      out.write("                    xmlhttp=new XMLHttpRequest();\r\n");
      out.write("                }\r\n");
      out.write("                else\r\n");
      out.write("                {// code for IE6, IE5\r\n");
      out.write("                    xmlhttp=new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("                }\r\n");
      out.write("                xmlhttp.onreadystatechange=function()\r\n");
      out.write("                {\r\n");
      out.write("                    if (xmlhttp.readyState==4 && xmlhttp.status==200)\r\n");
      out.write("                    {\r\n");
      out.write("                        //var x = document.getElementById(\"logs\").innerHTML;\r\n");
      out.write("                        document.getElementById(\"logs\").innerHTML = xmlhttp.responseText;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                //var mensahe = document.getElementById(\"logs\").value;\r\n");
      out.write("                xmlhttp.open(\"GET\",\"productLog\",true);\r\n");
      out.write("                xmlhttp.send();\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("        \r\n");
      out.write("          <script>\r\n");
      out.write("$(function () {\r\n");
      out.write("  $('#datepicker').datepicker({  \r\n");
      out.write("        todayHighlight: true\r\n");
      out.write("  });\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <nav class=\"navbar navbar-inverse navbar-static-top\" role=\"navigation\">\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"navbar-header\">\r\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Foobar Bookshop</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"navbar\" class=\"navbar-collapse collapse\">\r\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("                        <li><a href=\"#\">Store</a></li>\r\n");
      out.write("                        <li><a href=\"#\">Settings</a></li>\r\n");
      out.write("                        <li class=\"dropdown\">\r\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Aids</a>\r\n");
      out.write("                            <ul class=\"dropdown-menu\" role=\"menu\">\r\n");
      out.write("                                <li><a href=\"#\">Action</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Another action</a></li>\r\n");
      out.write("                                <li><a href=\"#\">Something else here</a></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>       \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        \r\n");
      out.write("    <center><h3><span class=\"label label-default\">Product Logs</span></h3></center>\r\n");
      out.write("    <center>\r\n");
      out.write("    <label>Select Date: </label>\r\n");
      out.write("  \r\n");
      out.write("<div id=\"datepicker\" class=\"input-group date\" data-date-format=\"mm-dd-yyyy\">\r\n");
      out.write("    <input class=\"form-control\" type=\"text\"/>\r\n");
      out.write("    <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-calendar\"></i></span>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <button id =\"date_select\" type=\"submit\" class=\"btn btn-default\" onclick=\"loadXMLDoc()\">View All Product Logs</button></center>\r\n");
      out.write("    \r\n");
      out.write("   \r\n");
      out.write("    \r\n");
      out.write("    <table id=\"logs\" class=\"table table-striped table-bordered display\" data-toggle=\"table\" data-cache=\"false\" data-height=\"400\">\r\n");
      out.write("     <thead>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>Log Date and Timestamp</th>\r\n");
      out.write("            <th>Username</th>\r\n");
      out.write("            <th>Product Name</th>\r\n");
      out.write("            <th>Activity</th> \r\n");
      out.write("        </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("    \r\n");
      out.write("  \r\n");
      out.write("    </table>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
