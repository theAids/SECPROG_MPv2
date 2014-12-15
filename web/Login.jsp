<%-- 
    Document   : Homepage
    Created on : Nov 9, 2014, 8:43:36 PM
    Author     : aids
--%>

<%@page import="Bean.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String token = (String) session.getAttribute("client_token");

        if (token != null) {
            response.sendRedirect("SearchPage.jsp");
        } 
        
        
%>
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

    <body>

        <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Foobar Bookshop</a>
                </div>
        </nav>

        <div class="container">
            <div class="jumbotron" id="content">
                <h2>Log in to your account</h2>
                <form class="form-horizontal" method="post" action="login" role="form">
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <label for="username" class="col-md-3 control-label">Username</label>
                            <div class="col-md-9">
                                
                                <input type="text" required = "true"  class="form-control" name="username" id="username"/>
                            </div>
                            <label for="password" class="col-md-3 control-label">Password</label>
                            <div class="col-md-9">
                                <input type="password" required = "true"   class="form-control" name="password" id="password"/>
                            </div>
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-success btn-block">Log in</button>
                            </div>
                        </div>

                    </div>
                </form>
            </div>

        </div>


        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

