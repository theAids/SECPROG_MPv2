<%-- 
    Document   : ProdcuctLog
    Created on : 12 8, 14, 12:06:22 PM
    Author     : kimberly
--%>
<%@page import="Bean.ProductLogBean"%>
<%@page import="DAO.Implementation.ProductlogImplementation"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.ProductBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <link href="css/bootstrap-table.css" rel="stylesheet">
        <link href="css/datepicker.css" rel="stylesheet" type="text/css">
        
        
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootstrap-table.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        
        <script>
            function loadXMLDoc()
            {
                var xmlhttp;
                if (window.XMLHttpRequest)
                {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp=new XMLHttpRequest();
                }
                else
                {// code for IE6, IE5
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange=function()
                {
                    if (xmlhttp.readyState==4 && xmlhttp.status==200)
                    {
                        //var x = document.getElementById("logs").innerHTML;
                        document.getElementById("logs").innerHTML = xmlhttp.responseText;
                    }
                }
                //var mensahe = document.getElementById("logs").value;
                xmlhttp.open("GET","productLog",true);
                xmlhttp.send();
            }
        </script>
        
          <script>
$(function () {
  $('#datepicker').datepicker({  
        todayHighlight: true
  });
});
</script>
        

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
    <center><h3><span class="label label-default">Product Logs</span></h3></center>
    <center>
    <label>Select Date: </label>
  
<div id="datepicker" class="input-group date" data-date-format="mm-dd-yyyy">
    <input class="form-control" type="text"/>
    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
</div>


        
        <button id ="date_select" type="submit" class="btn btn-default" onclick="loadXMLDoc()">View All Product Logs</button></center>
    
   
    
    <table id="logs" class="table table-striped table-bordered display" data-toggle="table" data-cache="false" data-height="400">
     <thead>
        <tr>
            <th>Log Date and Timestamp</th>
            <th>Username</th>
            <th>Product Name</th>
            <th>Activity</th> 
        </tr>
    </thead>
    
  
    </table>
        </div>
    </body>
</html>
