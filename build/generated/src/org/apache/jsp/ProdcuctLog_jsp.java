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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>Foobar</title>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"scss/stylesheets/screen.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/bootstrap-table.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/datepicker.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-table.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-datepicker.js\"></script>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            function loadXMLDoc()\n");
      out.write("            {\n");
      out.write("                var xmlhttp;\n");
      out.write("                if (window.XMLHttpRequest)\n");
      out.write("                {// code for IE7+, Firefox, Chrome, Opera, Safari\n");
      out.write("                    xmlhttp=new XMLHttpRequest();\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {// code for IE6, IE5\n");
      out.write("                    xmlhttp=new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                xmlhttp.onreadystatechange=function()\n");
      out.write("                {\n");
      out.write("                    if (xmlhttp.readyState==4 && xmlhttp.status==200)\n");
      out.write("                    {\n");
      out.write("                        //var x = document.getElementById(\"logs\").innerHTML;\n");
      out.write("                        document.getElementById(\"logs\").innerHTML = xmlhttp.responseText;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                //var mensahe = document.getElementById(\"logs\").value;\n");
      out.write("                xmlhttp.open(\"GET\",\"productLog\",true);\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("          <script>\n");
      out.write("$(function () {\n");
      out.write("  $('#datepicker').datepicker({  \n");
      out.write("        todayHighlight: true\n");
      out.write("  });\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("        \n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-inverse navbar-static-top\" role=\"navigation\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Foobar Bookshop</a>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"navbar\" class=\"navbar-collapse collapse\">\n");
      out.write("                    <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li><a href=\"#\">Store</a></li>\n");
      out.write("                        <li><a href=\"#\">Settings</a></li>\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Aids</a>\n");
      out.write("                            <ul class=\"dropdown-menu\" role=\"menu\">\n");
      out.write("                                <li><a href=\"#\">Action</a></li>\n");
      out.write("                                <li><a href=\"#\">Another action</a></li>\n");
      out.write("                                <li><a href=\"#\">Something else here</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>       \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("    <center><h3><span class=\"label label-default\">Product Logs</span></h3></center>\n");
      out.write("    <center>\n");
      out.write("    <label>Select Date: </label>\n");
      out.write("  \n");
      out.write("<div id=\"datepicker\" class=\"input-group date\" data-date-format=\"mm-dd-yyyy\">\n");
      out.write("    <input class=\"form-control\" type=\"text\"/>\n");
      out.write("    <span class=\"input-group-addon\"><i class=\"glyphicon glyphicon-calendar\"></i></span>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <button id =\"date_select\" type=\"submit\" class=\"btn btn-default\" onclick=\"loadXMLDoc()\">View All Product Logs</button></center>\n");
      out.write("    \n");
      out.write("   \n");
      out.write("    \n");
      out.write("    <table id=\"logs\" class=\"table table-striped table-bordered display\" data-toggle=\"table\" data-cache=\"false\" data-height=\"400\">\n");
      out.write("     <thead>\n");
      out.write("        <tr>\n");
      out.write("            <th>Log Date and Timestamp</th>\n");
      out.write("            <th>Username</th>\n");
      out.write("            <th>Product Name</th>\n");
      out.write("            <th>Activity</th> \n");
      out.write("        </tr>\n");
      out.write("    </thead>\n");
      out.write("    \n");
      out.write("  \n");
      out.write("    </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
