<%-- 
    Document   : Homepage
    Created on : Nov 9, 2014, 8:43:36 PM
    Author     : aids
--%>

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

    <body>

        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Foobar Bookshop</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <div class="navbar-form navbar-right">
                        <a class="btn btn-success" href="Register.jsp" role="button">Sign-up</a>
                    </div>
                </div><!--/.navbar-collapse -->
            </div>
        </nav>

        <div class="container-fluid" id="mainpage">
            <div class="row">
                <div class="col-md-8">
                    <div class="section1">
                        <h1>Your  </h1>
                        <h1>online bookshop</h1>
                        <div class="col-md-8 col-md-offset-2">
                            <button class="btn btn-lg btn-success">Search store</button>
                        </div>
                    </div>

                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="register">
                            <h1>Log-in</h1>
                            <h5>Be Foorb!</h5>
                            <form class="form-horizontal" role="form" method="post" action="login">
                                <div class="form-group">
                                    <div class="col-md-12">
                                        <input type="text" name="username"  id="username" class="form-control" placeholder="username"/>
                                    </div>
                                    <div class="col-md-12">
                                        <input type="password" class="form-control" name="password" placeholder="password"/>
                                    </div>
                                    <div class="col-md-12">
                                        <button type="submit" class="btn btn-success btn-block">Log-in</button>
                                    </div>
                            </form>

                        </div>
                    </div>

                </div>
            </div>
        </div>


        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

