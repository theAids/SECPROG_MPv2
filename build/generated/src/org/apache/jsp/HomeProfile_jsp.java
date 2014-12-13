package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class HomeProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
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
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <div id=\"profilecontent\">\n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <input type=\"text\" name=\"searchbox\" class=\"form-control\">\n");
      out.write("                            <span class=\"input-group-btn\">\n");
      out.write("                                <button class=\"btn btn-default\" type=\"button\" onclick=\"searchItem()\">Search!</button>\n");
      out.write("                            </span>\n");
      out.write("                        </div>\n");
      out.write("                        <form onclick=\"loadSearchCat()\">\n");
      out.write("                            <div class=\"radio\" >\n");
      out.write("                                <label>\n");
      out.write("                                    <input type=\"radio\" name=\"filter\" value=\"Books\" checked>\n");
      out.write("                                    Books\n");
      out.write("                                </label>\n");
      out.write("                                <label>\n");
      out.write("                                    <input type=\"radio\" name=\"filter\" value=\"Magazines\">\n");
      out.write("                                    Magazines\n");
      out.write("                                </label>\n");
      out.write("                                <label>\n");
      out.write("                                    <input type=\"radio\" name=\"filter\" value=\"Audio CDs\">\n");
      out.write("                                    Audio CDs\n");
      out.write("                                </label>\n");
      out.write("                                <label>\n");
      out.write("                                    <input type=\"radio\" name=\"filter\" value=\"DVDs\">\n");
      out.write("                                    DVDs\n");
      out.write("                                </label>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    <div id=\"profilecontent\">\n");
      out.write("                        <h2 name=\"sHeader\">Books</h2>\n");
      out.write("                        <div class=\"table-responsive\">\n");
      out.write("                            <table id=\"searchTable\" class=\"table table-striped\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th style=\"width: 50px\">#</th>\n");
      out.write("                                        <th style=\"width: 400px\">Title</th>\n");
      out.write("                                        <th>Price</th>\n");
      out.write("                                        <th>Status</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                </thead>\n");
      out.write("\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery-1.10.min.js\"></script>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("\n");
      out.write("        \n");
      out.write("        function loadSearchCat() {\n");
      out.write("            var xmlhttp;\n");
      out.write("            var row;\n");
      out.write("            \n");
      out.write("            var filter = $('input:radio[name=filter]:checked').val();\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            if (window.XMLHttpRequest)\n");
      out.write("            {// code for IE7+, Firefox, Chrome, Opera, Safari\n");
      out.write("                xmlhttp = new XMLHttpRequest();\n");
      out.write("            }\n");
      out.write("            else\n");
      out.write("            {// code for IE6, IE5\n");
      out.write("                xmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("            }\n");
      out.write("            xmlhttp.onreadystatechange = function ()\n");
      out.write("            {\n");
      out.write("                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                {\n");
      out.write("                    $('#searchTable tr:not(:first)').remove();\n");
      out.write("                    $('#searchTable').append(xmlhttp.responseText); \n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            $('input:radio[name=filter]').click(function () {\n");
      out.write("                filter = $('input:radio[name=filter]:checked').val();\n");
      out.write("                //$('[name=sHeader]').text(filter);\n");
      out.write("            });\n");
      out.write("            xmlhttp.open(\"POST\", \"getSearchCat?cat=\"+filter, true);\n");
      out.write("            xmlhttp.send();\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function searchItem() {\n");
      out.write("            var xmlhttp;\n");
      out.write("            var row;\n");
      out.write("            var item = $('input:text[name=searchbox]').val();\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            if (window.XMLHttpRequest)\n");
      out.write("            {// code for IE7+, Firefox, Chrome, Opera, Safari\n");
      out.write("                xmlhttp = new XMLHttpRequest();\n");
      out.write("            }\n");
      out.write("            else\n");
      out.write("            {// code for IE6, IE5\n");
      out.write("                xmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("            }\n");
      out.write("            xmlhttp.onreadystatechange = function ()\n");
      out.write("            {\n");
      out.write("                if (xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                {\n");
      out.write("                    $('#searchTable tr:not(:first)').remove();\n");
      out.write("                    $('#searchTable').append(xmlhttp.responseText); \n");
      out.write("                  \n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            xmlhttp.open(\"POST\", \"searchItem?search=\"+item, true);\n");
      out.write("            xmlhttp.send();\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        function link(){\n");
      out.write("            //alert($(\"#link\").text());\n");
      out.write("            window.location = \"getProductInfo?param=\"+$(\"#link\").text();\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        $(document).ready(function () {\n");
      out.write("            loadSearchCat();\n");
      out.write("   \n");
      out.write("        });\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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
