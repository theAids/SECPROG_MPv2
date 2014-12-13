<%-- 
    Document   : Homepage
    Created on : Nov 9, 2014, 8:43:36 PM
    Author     : aids
--%>

<%@page import="java.lang.String"%>
<%@page import="Security.Authenticator"%>
<%@page import="Bean.CustomerBean"%>
<%@page import="Bean.UserBean"%>
<%@page import="DAO.Implementation.UserDAOImplementation"%>
<%@page import="DAO.Interface.UserDAOInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Foobar</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="scss/stylesheets/screen.css" rel="stylesheet">
       
    </head>
    <%
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
        
    %>

    <body>

        <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Foobar Bookshop</a>
                </div>
        </nav>

        <div class="container">
            <div class="jumbotron" id="content">
                <h2>ACTIVATE ACCOUNT</h2>
                <form class="form-horizontal" name="regForm" id = "regForm" method="post" action = "activateAccount" role="form">
                    <div class="form-group">

                        <div class="col-md-6 col-md-offset-3">
                            <div><label>Password</label></div> 
                            <div class="col-md-12">
                                <input type="hidden" class="form-control" name="userID" id="userID"/>
                            </div>

                            <div class="col-md-12">
                                <input type="password" required = "true"  pattern=".{6,30}" title="Minimum of 6 characters and maximum of 30." onchange="form.vpassword.pattern = this.value;" placeholder="Old Password" class="form-control" name="password" id="password"/>
                            </div>

                            <div class="col-md-12">
                                <input type="password" required = "true"  pattern=".{6,30}" title="Minimum of 6 characters and maximum of 30." onchange="form.vpassword.pattern = this.value;" placeholder="New Password" class="form-control" name="npassword" id="npassword"/>
                            </div>

                            <div class="col-md-12">
                                <input type="password" required = "true"  pattern=".{6,30}" title="Password and Verify Password must match" placeholder="Verify New Password" class="form-control" id="vnpassword"/>
                            </div>


                            <div class="col-md-12">
                                <button type="submit" class="btn btn-success btn-block">Activate</button>
                            </div>

                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">

                        </div>
                    </div>

                </form>
            </div>

        </div>


        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-1.10.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
        <script>
            var submit = 1;
            
           
            $(document).ready(function () {
                //checkOldPass();
                
                
                
                $("#userID").val("<%= user.getUserID() %>");
                
                $("#regForm").submit(function(event){ 
                    if ( submit != 1) {
                        event.preventDefault(); 
                    }
                });
                
                
                
                //alert($("#userID").val());
            });
        </script>
    </body>
</html>

