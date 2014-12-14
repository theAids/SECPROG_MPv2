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
        <script>
            $(document).ready(function () {
            <% if (token == null) {%>
                $(".menubar").css("display", "none");
            <% } else { %>
                $(".unlogged").css("display", "none");
            <% }%>

            });
        </script>


    </head>


    <body>

        <nav class="navbar navbar-inverse navbar-static-top " role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Foobar Bookshop</a>
                </div>

                <!--/.navbar-collapse -->
                <div class=" menubar">
                    <div  class="navbar-collapse collapse" >
                        <ul class="nav navbar-nav navbar-right">
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
                <div id="navbar" class="navbar-collapse collapse ">
                    <div class="navbar-form navbar-right unlogged">
                        <a class="btn btn-primary" href="Login.jsp" role="button">Login</a>
                        <a class="btn btn-success" href="Register.jsp" role="button">Sign-up</a>
                    </div>
                </div><!--/.navbar-collapse -->
            </div>
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div id="profilecontent">
                        <div class="input-group">
                            <input type="text" name="searchbox" class="form-control">
                            <span class="input-group-btn">
                                <button class="btn btn-default" type="button" onclick="searchItem()">Search!</button>
                            </span>
                        </div>
                        <form onclick="loadSearchCat()">
                            <div class="radio" >
                                <label>
                                    <input type="radio" name="filter" value="Books" checked>
                                    Books
                                </label>
                                <label>
                                    <input type="radio" name="filter" value="Magazines">
                                    Magazines
                                </label>
                                <label>
                                    <input type="radio" name="filter" value="Audio CDs">
                                    Audio CDs
                                </label>
                                <label>
                                    <input type="radio" name="filter" value="DVDs">
                                    DVDs
                                </label>
                            </div>
                        </form>
                    </div>

                </div>
                <div class="col-md-8">
                    <div id="profilecontent">
                        <h2 name="sHeader">Books</h2>
                        <div class="table-responsive">
                            <table id="searchTable" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th style="width: 50px">#</th>
                                        <th style="width: 400px">Title</th>
                                        <th>Category</th>
                                        <th>Price</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>

                            </table>
                        </div>
                    </div>

                </div>
            </div>

        </div>

    </div>

    <form class="form-horizontal" name="CreateProductJsp" id = "CreateBookJsp" method="post" action = "CreateProducts">
        <div class="product-choices">
            <input type="submit" name="CreateBookBtn" id="CreateBookBtn" value="CreateProduct"/>
        </div>
    </form>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-1.10.min.js"></script>

    <script>
                            function loadSearchCat() {
                                var xmlhttp;
                                var row;

                                var filter = $('input:radio[name=filter]:checked').val();


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
                                        $('[name=sHeader]').text(filter);
                                        $('#searchTable tr:not(:first)').remove();
                                        $('#searchTable').append(xmlhttp.responseText);
                                    }
                                }
                                $('input:radio[name=filter]').click(function () {
                                    filter = $('input:radio[name=filter]:checked').val();
                                    //$('[name=sHeader]').text(filter);
                                });
                                xmlhttp.open("POST", "getSearchCat?cat=" + filter, true);
                                xmlhttp.send();
                            }

                            function searchItem() {
                                var xmlhttp;
                                var row;
                                var item = $('input:text[name=searchbox]').val();


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
                                        $('#searchTable tr:not(:first)').remove();
                                        $('#searchTable').append(xmlhttp.responseText);

                                    }
                                }

                                xmlhttp.open("POST", "searchItem?search=" + item, true);
                                xmlhttp.send();
                            }


                            $(document).ready(function () {
                                loadSearchCat();
                                

                                <% if (token == null) {%>
                                       $(".menubar").css("display", "none");
                                <% } else { %>
                                       $(".unlogged").css("display", "none");
                                <% }%>
                                    
                            }
                            );

    </script>
    <!-- Placed at the end of the document so the pages load faster -->


</body>
</html>

