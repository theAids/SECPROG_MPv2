<%-- 
    Document   : Homepage
    Created on : Nov 9, 2014, 8:43:36 PM
    Author     : aids
--%>

<%@page import="Security.AccessController"%>
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
        //UserBean user = (UserBean) session.getAttribute("client_user");
        AccessController acl = (AccessController) session.getAttribute("acl");
        /*if(user == null || acl.getCREATE_USER() == 0){
            response.sendRedirect("Unauthorized.jsp");
            return;
        }*/
        UserBean user = userIM.getUser("eyjaneh_");
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
                <h2>Create Administrative Account</h2>
                <h5>Account will expire within 24 hours if not verified.</h5>
                <form class="form-horizontal" name="regForm" id = "regForm" method="post" action = "createMgr" role="form">
                    <div class="form-group">

                        <div class="col-md-6 col-md-offset-3">
                            <div><label>Account Information</label></div>   
                            <div class="col-md-12">
                                <input type="text" required = "true" pattern="^[a-zA-Z0-9_]{8,30}$" title = "Only alphanumeric characters and underscore are allowed. Minimum of 8 characters and maximum of 30." placeholder="Username" class="form-control" name="username" id="username"/>
                            </div>

                            <div class="col-md-12">
                                <input type="password" required = "true"  pattern=".{6,30}" title="Minimum of 6 characters and maximum of 30." onchange="form.vpassword.pattern = this.value;" placeholder="Password" class="form-control" name="password" id="password"/>
                            </div>

                            <div class="col-md-12">
                                <input type="password" required = "true"  pattern=".{6,30}" title="Password and Verify Password must match" placeholder="Verify Password" class="form-control" id="vpassword"/>
                            </div>

                            <div class="col-md-12">
                                <input type="email" required = "true"  title="Please enter valid e-mail address" pattern="([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})" placeholder="E-mail Address" class="form-control" name="email" id="email"/>
                            </div>


                            <div><label>Personal Information</label></div>   
                            <div class="col-md-12">
                                <input type="text" required = "true" placeholder="First Name" class="form-control" name="firstname" id="firstname"/>
                            </div>

                            <div class="col-md-12">
                                <input type="text" required = "true" placeholder="Middle Initial" class="form-control" name="middleI" id="middleI"/>
                            </div>

                            <div class="col-md-12">
                                <input type="text" required = "true" placeholder="Last Name" class="form-control" name="lastname" id="lastname"/>
                            </div>
                            
                            <div><label class="col-md-6 col-md-offset-2 control-label">Account Type</label></div>
                            <div><label  class="col-md-1 col-md-offset-11 control-label"></label></div>
                            <div class="col-md-offset-4 row">
                                <div class="col-md-7">
                                    <select class="col-md-5 form-control" name="accountType" id="accountType">
                                        <option value="Administrator">Administrator</option>
                                        <option value="Account">Account</option>
                                        <option value="Book">Book</option>
                                        <option value="CD">CD</option>
                                        <option value="DVD">DVD</option>
                                        <option value="Magazine">Magazine</option>
                                    </select>
                                </div>
                            </div>
                            
                            
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-success btn-block">Create</button>
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
            var submit = 0;
            
            function checkUsernameEmailAvailability(){
                var uname = $("#username").val();
                var email = $("#email").val();
                
                var xmlhttp;
                if (window.XMLHttpRequest)
                {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp = new XMLHttpRequest();
                }
                else
                {// code for IE6, IE5
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange = function()
                {
                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
                    {
                        var msg = xmlhttp.responseText;
                        //alert(msg);
                        
                        if(msg.trim() == "username"){
                            $("#username").attr('data-original-title', "Username is already in use");
                            $("#username").popover({placement: 'right'});
                            $("#username").popover("show");
                            //$("#username").tooltip({autoHide: 'false'});
                            
                            $("#email").attr('data-original-title', "Please enter valid e-mail address");
                            $("#email").popover("hide");
                            submit = 0;
                            
                        }else if(msg.trim() == "email"){
                            $("#email").attr('data-original-title', "E-mail address is already in use");
                            $("#email").popover({placement: 'right'});
                            $("#email").popover("show");
                            $("#username").attr('data-original-title', "Only alphanumeric characters and underscore are allowed. Minimum of 8 characters and maximum of 30.");
                            $("#username").popover("hide");
                            
                            submit = 0;
                        }else if(msg.trim() == "both"){
                            $("#username").attr('data-original-title', "Username is already in use");
                            $("#username").popover({placement: 'right'});
                            $("#username").popover("show");
                            
                            $("#email").attr('data-original-title', "E-mail address is already in use");
                            $("#email").popover({placement: 'right'});
                            $("#email").popover("show");
                            
                            submit = 0;
                        }else{
                            $("#email").attr('data-original-title', "Please enter valid e-mail address");
                            $("#email").popover("hide");
                            
                            $("#username").attr('data-original-title', "Only alphanumeric characters and underscore are allowed. Minimum of 8 characters and maximum of 30.");
                            $("#username").popover("hide");
                            
                            submit = 1;
                        }
                    }
                }
                xmlhttp.open("POST", "checkAvailability?uname=" + uname+"&email=" + email);
                xmlhttp.send();
            }
            
            
            $(document).ready(function () {
                
                /* FOR CHECKING USERNAME AVAILABILITY */
                $('#username').on('keyup', function(event){
                        checkUsernameEmailAvailability();
                });
                
                $('#email').on('keyup', function(event){
                        checkUsernameEmailAvailability();
                });
                
                 $("#regForm").submit(function(event){ 
                    if ( submit != 1) {
                        event.preventDefault(); 
                    }
                }); 
                //alert("HI");
            });
        </script>
    </body>
</html>

