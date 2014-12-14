<%-- 
    Document   : Homepage
    Created on : Nov 9, 2014, 8:43:36 PM
    Author     : aids
--%>

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
    <script>
    <%
        HttpSession userSession = null;
        userSession = request.getSession();
        
        UserDAOInterface userIM = new UserDAOImplementation();
        UserBean user = (UserBean) userSession.getAttribute("client_user");
        //UserBean user = userIM.getUser("eyjaneh_");
        if(user == null){
            response.sendRedirect("Unauthorized.jsp");
            return;
        }
        boolean isCustomer = false;
        CustomerBean c = null;
        
        String type = userIM.getUserType(user);
        
        if(type.equals("Customer")){
            isCustomer = true;
            c = userIM.getCustomer(user.getUsername());
            //System.out.println(c.getbAddress());
        }
        
        //System.out.println("NOT A CUSTOMER");
        
    %>
        </script>

    <body>

        <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Foobar Bookshop</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <div class="navbar-form navbar-right">
                        <form method="link" action="logout">
                            <button type="submit" class="btn btn-danger btn-xs">Log-out</button>
                        </form>
                    </div>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="jumbotron" id="content">
                <h2>View Account Details</h2>
                
                    <div class="form-group">

                        <div class="col-md-6 col-md-offset-3">
                            <div><label>Account Information</label></div>   
                            <div align='left' class='col-md-offset-3'>
                                <label>Username</label>
                                <span id="username">Username</span>
                            </div>

                            <div align='left' class='col-md-offset-3'>
                                <label>E-mail Address</label>
                                <span id="email">E-mail</span>
                            </div>
                            
                            <div><label>Personal Information</label></div>   
                            <div align='left' class='col-md-offset-3'>
                                <label>Name: </label>
                                <span id="name">Name</span>
                            </div>

                            <div id=bAddDiv" align='left' class='col-md-offset-3'>
                                <label>Billing Address</label>
                                <span id="bAdd" class="col-md-10">billin Add</span>
                            </div>
                            
                           <div id="dAddDiv" align='left' class='col-md-offset-3'>
                                <label>Delivery Address</label>
                                <span id="dAdd" class="col-md-10">delivery address</span>
                            </div>


                            <div class="col-md-12">
                                <button onclick="location.href='EditAccount.jsp'" class="btn btn-success btn-block">Edit Profile</button>
                            </div>
                            <div class="col-md-12">
                                <button onclick="location.href='EditPassword.jsp'" class="btn btn-success btn-block">Edit Password</button>
                            </div>
                            

                        </div>
                    </div>
                    
                        <div class="row">

                        </div>
                    </div>

               
            </div>

        </div>
            
           


        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery-1.10.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
         <script>
                $(document).ready(function() {
                //alert("HI");
                $("#username").text("<%= user.getUsername() %>");
                $("#email").text("<%= user.getEmail() %>");
                $("#name").text("<%= user.getFname() + " " + user.getMinitial() + " " + user.getLname() %>");
                
                <% if(isCustomer){ %>
                $("#bAdd").text("<%= c.getbAddress() %>");
                $("#dAdd").text("<%= c.getdAddress() %>");
                <% }else{ %>
                $("#bAdd").hide();
                $("#dAdd").hide();
                <% } %>
                
                
            });
            </script>
        
    </body>
</html>

