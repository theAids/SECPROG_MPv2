package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Bean.CustomerBean;
import Bean.UserBean;
import DAO.Implementation.UserDAOImplementation;
import DAO.Interface.UserDAOInterface;

public final class ActivateAccount_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    ");

        UserDAOInterface userIM = new UserDAOImplementation();
        UserBean user = (UserBean) session.getAttribute("client_user");
        if(user == null){
            response.sendRedirect("Unauthorized.jsp");
            return;
        }
        //UserBean user = userIM.getUser("eyjaneh_");
        //user.setPassword("helloworld");
        
        String type = userIM.getUserType(user);
        
        
        //System.out.println("NOT A CUSTOMER");
        
    
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-inverse navbar-static-top\" role=\"navigation\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Foobar Bookshop</a>\n");
      out.write("                </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"jumbotron\" id=\"content\">\n");
      out.write("                <h2>ACTIVATE ACCOUNT</h2>\n");
      out.write("                <form class=\"form-horizontal\" name=\"regForm\" id = \"regForm\" method=\"post\" action = \"activateAccount\" role=\"form\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("\n");
      out.write("                        <div class=\"col-md-6 col-md-offset-3\">\n");
      out.write("                            <div><label>Password</label></div> \n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <input type=\"hidden\" class=\"form-control\" name=\"userID\" id=\"userID\"/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <input type=\"password\" required = \"true\"  pattern=\".{6,30}\" title=\"Minimum of 6 characters and maximum of 30.\" onchange=\"form.vpassword.pattern = this.value;\" placeholder=\"Old Password\" class=\"form-control\" name=\"password\" id=\"opassword\"/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <input type=\"password\" required = \"true\"  pattern=\".{6,30}\" title=\"Minimum of 6 characters and maximum of 30.\" onchange=\"form.vpassword.pattern = this.value;\" placeholder=\"New Password\" class=\"form-control\" name=\"password\" id=\"npassword\"/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <input type=\"password\" required = \"true\"  pattern=\".{6,30}\" title=\"Password and Verify Password must match\" placeholder=\"Verify New Password\" class=\"form-control\" id=\"vnpassword\"/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-success btn-block\">Activate</button>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Placed at the end of the document so the pages load faster -->\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery-1.10.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("        <script>\n");
      out.write("            var submit = 0;\n");
      out.write("            \n");
      out.write("           \n");
      out.write("            $(document).ready(function () {\n");
      out.write("                //checkOldPass();\n");
      out.write("                \n");
      out.write("                $('#opassword').on('keyup', function(event){\n");
      out.write("                        var key = String.fromCharCode(event.which);\n");
      out.write("                        if (!event.shiftKey) {\n");
      out.write("                            key = key.toLowerCase();\n");
      out.write("                        }\n");
      out.write("                        if($(this).val() != \"");
      out.print( user.getPassword() );
      out.write("\"){\n");
      out.write("                            submit = 0;\n");
      out.write("                            $(\"#opassword\").attr('data-original-title', \"Invalid Old Password. Must match password set by Administrator\");\n");
      out.write("                            $(\"#opassword\").popover({placement: 'right'});\n");
      out.write("                            $(\"#opassword\").popover(\"show\");\n");
      out.write("                        }else{\n");
      out.write("                            $(\"#opassword\").popover(\"hide\");\n");
      out.write("                            submit = 1;\n");
      out.write("                        }\n");
      out.write("                            \n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $(\"#userID\").val(\"");
      out.print( user.getUserID() );
      out.write("\");\n");
      out.write("                \n");
      out.write("                $(\"#regForm\").submit(function(event){ \n");
      out.write("                    if ( submit != 1) {\n");
      out.write("                        event.preventDefault(); \n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("                //alert($(\"#userID\").val());\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
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
