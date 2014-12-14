<%-- 
    Document   : Homepage
    Created on : Nov 9, 2014, 8:43:36 PM
    Author     : aids
--%>

<%@page import="Bean.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String token = (String) session.getAttribute("client_token");
    UserBean user;

    if (token != null) {
        user = (UserBean) session.getAttribute("client_user");
    } else {
        user = new UserBean();
    }

    if (token == null) {
        response.sendRedirect("Unauthorized.jsp");
        return;
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
        <link href="scss/stylesheets/screen.css" rel="stylesheet">



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
                                <li><a href="#">Transactions</a></li>
                                <li><a href="#">Logout</a></li>
                            </ul>
                        </li>
                    </ul>       
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="jumbotron" style="text-align: center !important">
                <h2>Payment Information</h2>
                <hr/>

                <form id="checkout" method="post" action="checkoutOrder">
                    <div class="radio" >
                        <label >
                            <input type="radio" name="ccn" value="visa" checked>
                            <img src="images/visa.png" style="height:50px;width:90px"/>
                        </label>
                        <label>
                            <input type="radio" name="ccn" value="mastercard">
                            <img src="images/mastercard.png" style="height:50px;width:90px"/>
                        </label>
                    </div>

                    <label>
                        Credit Card Number:
                        <input type="text" required="true" pattern="^[0-9]{16}$" name="ccnumber"/><span id="warning"></span>
                    </label>
                    <br>
                    <label>
                        Expires:
                        <select name="month"></select> / <select name="year"></select><span id="warningdate"></span>
                    </label>
                    <br>
                    <label>
                        Security Code:
                        <input type="" required="true" name="seccode" pattern="^[0-9]{3}$"/>
                    </label>
                    <br>
                    <input type="submit" class="btn btn-success" value="Proceed"/>

                </form>

            </div>
        </div>


        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-1.10.min.js"></script>

        <script>

            $("#checkout").submit(function (event) {
                var ccn = $('[name=ccnumber]').val();
                var card = $('input:radio[name=ccn]:checked').val();
                var month = $('[name=month]').val();
                var year = $('[name=year]').val();
                
                var current = new Date();
                
                if(card == "visa"){
                    if(ccn.charAt(0)!= 4){
                        $("#warning").text("Invalid credit card number").css({"font-style":"italic","color":"red"});
                        alert(month);
                        event.preventDefault();
                    }
                }else if(card == "mastercard"){
                    if(ccn.charAt(0)!= 5 || ccn.charAt(1) > 5 || ccn.charAt(1) < 1){
                        $("#warning").text("Invalid credit card number").css({"font-style":"italic","color":"red"});
                        event.preventDefault();
                    }
                }
                
               if(month <= current.getMonth() && year == current.getFullYear()){
                   $("#warningdate").text("Your card is expired").css({"font-style":"italic","color":"red"});
                        event.preventDefault();
               }
            });

            function initMonth() {
                var i = 1;
                for (; i < 13; i++) {
                    $('[name=month]').append("<option value='" + i + "'>" + i + "</option>");
                }
            }


            function initYear() {
                var current = new Date();
                var i = current.getFullYear();
                var year = i + 20;
                for (; i < year; i++) {
                    $('[name=year]').append("<option value='" + i + "'>" + i + "</option>");
                }
            }

            $(document).ready(function () {
                initMonth();
                initYear();

            });

        </script>
        <!-- Placed at the end of the document so the pages load faster -->


    </body>
</html>

