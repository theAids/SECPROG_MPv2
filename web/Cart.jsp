<%-- 
    Document   : Homepage
    Created on : Nov 9, 2014, 8:43:36 PM
    Author     : aids
--%>

<%@page import="Bean.OrderingBean"%>
<%@page import="Bean.ProductBean"%>
<%@page import="Bean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.Implementation.ProductImplementation"%>
<%@page import="DAO.Implementation.OrderingImplementation"%>
<%@page import="Bean.OrderBean"%>
<%@page import="Bean.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String token = (String) session.getAttribute("client_token");
    UserBean user = new UserBean();

    if (token != null) {
        user = (UserBean) session.getAttribute("client_user");
    } else {
        response.sendRedirect("Unauthorized.jsp");

    }

    ArrayList<OrderingBean> cart = new ArrayList<OrderingBean>();
    cart = (ArrayList<OrderingBean>) session.getAttribute("cart");

    float total = 0;
    if (cart != null) {
        for (OrderingBean bean : cart) {
            total += bean.getPrice() * bean.getQuantity();
        }
    }
%>
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
                <div  class="navbar-collapse collapse" >
                    <ul class="nav navbar-nav navbar-right menubar">
                        <li><a href="SearchPage.jsp">Search</a></li>
                        <li><a href="Cart.jsp">Cart</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=user.getUsername()%></a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="Transactions.jsp">Transactions</a></li>
                                <li><a href="logout">Logout</a></li>
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
                <h4 style="display: inline-block;color:#5BC236"><%=total%>php</h4>
                <a href="Checkout.jsp" class="btn btn-primary">Checkout</a>
                <a href="SearchPage.jsp" class="btn btn-success">Search More</a>
            </div>
        </div>



        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.10.min.js"></script>
        <script>
            function loadCart() {
                var xmlhttp;
                var row;


                if (window.XMLHttpRequest)
                {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp = new XMLHttpRequest();
                }
                else
                {// code for IE6, IE5
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange = function ()
                {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        $('#cartTable tr:not(:first)').remove();
                        $('#cartTable').append(xmlhttp.responseText);
                    }
                }

                xmlhttp.open("POST", "getCart", true);
                xmlhttp.send();
            }

            $(document).ready(function () {
                loadCart();
            });
        </script>
        <!-- Placed at the end of the document so the pages load faster -->


    </body>
</html>

