package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Security.AccessController;
import Bean.UserBean;
import DAO.Implementation.UserDAOImplementation;
import DAO.Interface.UserDAOInterface;

public final class CreateManager_jsp extends org.apache.jasper.runtime.HttpJspBase
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
        //UserBean user = (UserBean) session.getAttribute("client_user");
        AccessController acl = (AccessController) session.getAttribute("acl");
        /*if(user == null || acl.getCREATE_USER() == 0){
            response.sendRedirect("Unauthorized.jsp");
            return;
        }*/
        UserBean user = userIM.getUser("eyjaneh_");
        //user.setPassword("helloworld");
        
        String type = userIM.getUserType(user);
        
        
        //System.out.println("NOT A CUSTOMER");
        
    
      out.write("\n");
      out.write("    \n");
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
      out.write("                <h2>Create Administrative Account</h2>\n");
      out.write("                <h5>Account will expire within 24 hours if not verified.</h5>\n");
      out.write("                <form class=\"form-horizontal\" name=\"regForm\" id = \"regForm\" method=\"post\" action = \"createMgr\" role=\"form\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("\n");
      out.write("                        <div class=\"col-md-6 col-md-offset-3\">\n");
      out.write("                            <div><label>Account Information</label></div>   \n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <input type=\"text\" required = \"true\" pattern=\"^[a-zA-Z0-9_]{8,30}$\" title = \"Only alphanumeric characters and underscore are allowed. Minimum of 8 characters and maximum of 30.\" placeholder=\"Username\" class=\"form-control\" name=\"username\" id=\"username\"/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <input type=\"password\" required = \"true\"  pattern=\".{6,30}\" title=\"Minimum of 6 characters and maximum of 30.\" onchange=\"form.vpassword.pattern = this.value;\" placeholder=\"Password\" class=\"form-control\" name=\"password\" id=\"password\"/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <input type=\"password\" required = \"true\"  pattern=\".{6,30}\" title=\"Password and Verify Password must match\" placeholder=\"Verify Password\" class=\"form-control\" id=\"vpassword\"/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <input type=\"email\" required = \"true\"  title=\"Please enter valid e-mail address\" pattern=\"([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})\" placeholder=\"E-mail Address\" class=\"form-control\" name=\"email\" id=\"email\"/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <div><label>Personal Information</label></div>   \n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <input type=\"text\" required = \"true\" placeholder=\"First Name\" class=\"form-control\" name=\"firstname\" id=\"firstname\"/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <input type=\"text\" required = \"true\" placeholder=\"Middle Initial\" class=\"form-control\" name=\"middleI\" id=\"middleI\"/>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <input type=\"text\" required = \"true\" placeholder=\"Last Name\" class=\"form-control\" name=\"lastname\" id=\"lastname\"/>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            <div><label class=\"col-md-6 col-md-offset-2 control-label\">Account Type</label></div>\n");
      out.write("                            <div><label  class=\"col-md-1 col-md-offset-11 control-label\"></label></div>\n");
      out.write("                            <div class=\"col-md-offset-4 row\">\n");
      out.write("                                <div class=\"col-md-7\">\n");
      out.write("                                    <select class=\"col-md-5 form-control\" name=\"accountType\" id=\"accountType\">\n");
      out.write("                                        <option value=\"Administrator\">Administrator</option>\n");
      out.write("                                        <option value=\"Account\">Account</option>\n");
      out.write("                                        <option value=\"Book\">Book</option>\n");
      out.write("                                        <option value=\"CD\">CD</option>\n");
      out.write("                                        <option value=\"DVD\">DVD</option>\n");
      out.write("                                        <option value=\"Magazine\">Magazine</option>\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            <div class=\"col-md-12\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-success btn-block\">Create</button>\n");
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
      out.write("            function checkUsernameEmailAvailability(){\n");
      out.write("                var uname = $(\"#username\").val();\n");
      out.write("                var email = $(\"#email\").val();\n");
      out.write("                \n");
      out.write("                var xmlhttp;\n");
      out.write("                if (window.XMLHttpRequest)\n");
      out.write("                {// code for IE7+, Firefox, Chrome, Opera, Safari\n");
      out.write("                    xmlhttp = new XMLHttpRequest();\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {// code for IE6, IE5\n");
      out.write("                    xmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("                }\n");
      out.write("                xmlhttp.onreadystatechange = function()\n");
      out.write("                {\n");
      out.write("                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                    {\n");
      out.write("                        var msg = xmlhttp.responseText;\n");
      out.write("                        //alert(msg);\n");
      out.write("                        \n");
      out.write("                        if(msg.trim() == \"username\"){\n");
      out.write("                            $(\"#username\").attr('data-original-title', \"Username is already in use\");\n");
      out.write("                            $(\"#username\").popover({placement: 'right'});\n");
      out.write("                            $(\"#username\").popover(\"show\");\n");
      out.write("                            //$(\"#username\").tooltip({autoHide: 'false'});\n");
      out.write("                            \n");
      out.write("                            $(\"#email\").attr('data-original-title', \"Please enter valid e-mail address\");\n");
      out.write("                            $(\"#email\").popover(\"hide\");\n");
      out.write("                            submit = 0;\n");
      out.write("                            \n");
      out.write("                        }else if(msg.trim() == \"email\"){\n");
      out.write("                            $(\"#email\").attr('data-original-title', \"E-mail address is already in use\");\n");
      out.write("                            $(\"#email\").popover({placement: 'right'});\n");
      out.write("                            $(\"#email\").popover(\"show\");\n");
      out.write("                            $(\"#username\").attr('data-original-title', \"Only alphanumeric characters and underscore are allowed. Minimum of 8 characters and maximum of 30.\");\n");
      out.write("                            $(\"#username\").popover(\"hide\");\n");
      out.write("                            \n");
      out.write("                            submit = 0;\n");
      out.write("                        }else if(msg.trim() == \"both\"){\n");
      out.write("                            $(\"#username\").attr('data-original-title', \"Username is already in use\");\n");
      out.write("                            $(\"#username\").popover({placement: 'right'});\n");
      out.write("                            $(\"#username\").popover(\"show\");\n");
      out.write("                            \n");
      out.write("                            $(\"#email\").attr('data-original-title', \"E-mail address is already in use\");\n");
      out.write("                            $(\"#email\").popover({placement: 'right'});\n");
      out.write("                            $(\"#email\").popover(\"show\");\n");
      out.write("                            \n");
      out.write("                            submit = 0;\n");
      out.write("                        }else{\n");
      out.write("                            $(\"#email\").attr('data-original-title', \"Please enter valid e-mail address\");\n");
      out.write("                            $(\"#email\").popover(\"hide\");\n");
      out.write("                            \n");
      out.write("                            $(\"#username\").attr('data-original-title', \"Only alphanumeric characters and underscore are allowed. Minimum of 8 characters and maximum of 30.\");\n");
      out.write("                            $(\"#username\").popover(\"hide\");\n");
      out.write("                            \n");
      out.write("                            submit = 1;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                xmlhttp.open(\"POST\", \"checkAvailability?uname=\" + uname+\"&email=\" + email);\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            $(document).ready(function () {\n");
      out.write("                \n");
      out.write("                /* FOR CHECKING USERNAME AVAILABILITY */\n");
      out.write("                $('#username').on('keyup', function(event){\n");
      out.write("                        checkUsernameEmailAvailability();\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $('#email').on('keyup', function(event){\n");
      out.write("                        checkUsernameEmailAvailability();\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                 $(\"#regForm\").submit(function(event){ \n");
      out.write("                    if ( submit != 1) {\n");
      out.write("                        event.preventDefault(); \n");
      out.write("                    }\n");
      out.write("                }); \n");
      out.write("                //alert(\"HI\");\n");
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
