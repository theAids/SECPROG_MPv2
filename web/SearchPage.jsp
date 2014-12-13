<%-- 
    Document   : Homepage
    Created on : Nov 9, 2014, 8:43:36 PM
    Author     : aids
--%>

<%@page import="Bean.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    UserBean user = (UserBean) session.getAttribute("client_user");
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

        <nav class="navbar navbar-inverse navbar-static-top " role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Foobar Bookshop</a>
                </div>
                
                <div  class="navbar-collapse collapse" >
                    <ul class="nav navbar-nav navbar-right menubar">
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
    <!--
    <form class="form-horizontal" name="CreateProductJsp" id = "CreateBookJsp" method="post" action = "CreateProducts">
            <div class="product-choices">
                <input type="submit" name="CreateBookBtn" id="CreateBookBtn" value="CreateProduct"/>
            </div>
        </form>
    -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-1.10.min.js"></script>

    <script>
        
        function renderTop(){
            
        
            if(<%= user%>== null){
                $(".menubar").hide();
            }
        }
        
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
            xmlhttp.open("POST", "getSearchCat?cat="+filter, true);
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
            
            xmlhttp.open("POST", "searchItem?search="+item, true);
            xmlhttp.send();
        }
        
        function link(){
            //alert($("#link").text());
            window.location = "getProductInfo?param="+$("#link").text();
        }

        $(document).ready(function () {
            loadSearchCat();
            renderTop();
   
        });

    </script>
    <!-- Placed at the end of the document so the pages load faster -->


</body>
</html>

