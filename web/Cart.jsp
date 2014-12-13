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
        <link href="scss/stylesheets/screen.css" rel="stylesheet"/>
    </head>

    <body>

        <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Foobar Bookshop</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Store</a></li>
                        <li><a href="#">Settings</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Aids</a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something else here</a></li>
                            </ul>
                        </li>
                    </ul>       
                </div>
            </div>
        </nav>



        <div class="container">
            <div class="jumbotron">
                <h2 name="sHeader">Shopping Cart</h2>
                <div class="table-responsive">
                    <table id="cartTable" class="table table-striped">
                        <thead>
                            <tr>
                                <th style="width: 50px">#</th>
                                <th style="width: 400px">Title</th>
                                <th>Category</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th></th>
                            </tr>
                        </thead>
                    </table>
                </div>
                <br/>
                <h4 style="display: inline-block">Total Amount:</h4>
                <h4 style="display: inline-block;color:#5BC236">00.00php</h4>
                <a href="#" class="btn btn-primary">Checkout</a>
                <a href="SearchPage.jsp" class="btn btn-success">Search More</a>
            </div>
        </div>



        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.10.min.js"></script>
        <!-- Placed at the end of the document so the pages load faster -->


    </body>
</html>

