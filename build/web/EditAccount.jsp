<%-- 
    Document   : Homepage
    Created on : Nov 9, 2014, 8:43:36 PM
    Author     : aids
--%>

<%@page import="Security.AccessController"%>
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
    <%
        UserDAOInterface userIM = new UserDAOImplementation();
        UserBean user = (UserBean) session.getAttribute("client_user");
        AccessController acl = (AccessController) session.getAttribute("acl");
        if(user == null || acl.getEDIT_USER() == 0){
            response.sendRedirect("Unauthorized.jsp");
            return;
        }        
        //UserBean user = userIM.getUser("eyjaneh_");
        
        boolean isCustomer = false;
        CustomerBean c = null;
        String[] bAdd=null;
        String coun=""; 
        String postal=""; //correct
        String billing="";
                        
        String[] dAdd=null;
        String dcoun=""; //correct
        String dpostal=""; //correct
        String delivery="";
        
        String type = userIM.getUserType(user);
        
        if(type.equals("Customer")){
            isCustomer = true;
            c = userIM.getCustomer(user.getUsername());
            bAdd = c.getbAddress().split(" ");
            coun = bAdd[bAdd.length-1]; //correct
            postal = bAdd[bAdd.length-2]; //correct
            billing = c.getbAddress();
            billing = billing.replaceAll("\\s*\\w+\\s+\\w+$", ""); //correct
                        
            dAdd = c.getdAddress().split(" ");
            dcoun = dAdd[dAdd.length-1]; //correct
            dpostal = dAdd[dAdd.length-2]; //correct
            delivery = c.getdAddress();
            delivery = delivery.replaceAll("\\s*\\w+\\s+\\w+$", ""); //correct
            //System.out.println(c.getbAddress());
        }
        
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
                <h2>EDIT YOUR ACCOUNT</h2>
                <form class="form-horizontal" name="regForm" id = "regForm" method="post" action = "editAccount" role="form">
                    <div class="form-group">

                        <div class="col-md-6 col-md-offset-3">
                            <div><label>Account Information</label></div> 
                            <div class="col-md-12">
                                <input type="hidden" hidden = "true" class="form-control" name="userID" id="userID"/>
                            </div>
                            
                            <div class="col-md-12">
                                <input type="text" required = "true" pattern="^[a-zA-Z0-9_]{8,30}$" title = "Only alphanumeric characters and underscore are allowed. Minimum of 8 characters and maximum of 30." placeholder="Username" class="form-control" name="username" id="username"/>
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
                            
                            <div id ="bAddress">
                            <div><label style= "color:#54C571" class="col-md-6 col-md-offset-2 control-label">Billing Address</label></div>

                            <div class="col-md-12">
                                <input type="text" required="true" placeholder="Address: House #, Street, Subdivision, City" class="form-control" name="badd" id="badd"/>
                            </div>

                            <div class="col-md-4">
                                <input type="text" required="true" placeholder="Postal Code" class="form-control" name="bpostal" id="bpostal"/>
                            </div>

                            <div class="col-md-6">
                                <select name="bcountry" id="bcountry" class="form-control"></select>
                            </div>
                            </div>
                            
                            <div id="aCheck" class="col-md-9 checkbox">
                                <label>
                                    <input id = "bcheck" onclick="checkAddress();" type="checkbox"> Assign the same address for my delivery address
                                </label>
                            </div>

                            <div id="dAddress">
                                <div><label style= "color:#54C571" class="col-md-6 col-md-offset-2 control-label">Delivery Address</label></div>

                                <div class="col-md-12">
                                    <input type="text" placeholder="Address: House #, Street, Subdivision, City" class="form-control" name="dadd" id="dadd"/>
                                </div>

                                <div class="col-md-4">
                                    <input type="text" placeholder="Postal Code" class="form-control" name="dpostal" id="dpostal"/>
                                </div>

                                <div class="col-md-6">
                                    <select name="dcountry" id="dcountry" class="form-control"></select>
                                 </div>
                            </div>


                            <div class="col-md-12">
                                <button type="submit" class="btn btn-success btn-block">Save</button>
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
            var submit = 1;
            var oname = "<%= user.getUsername() %>";
            var oemail = "<%= user.getEmail() %>";
            
            
            function checkUsernameEmailAvailability(){
                var uname = $("#username").val();
                var email = $("#email").val();
                
                /*if(uname == oname){
                    alert("NO CHANGE USERNAME!");
                }*/
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
                            if(oname == uname){
                                //submit = 1;
                                return;
                            }
                            
                            $("#username").attr('data-original-title', "Username is already in use");
                            $("#username").popover({placement: 'right'});
                            $("#username").popover("show");
                            //$("#username").tooltip({autoHide: 'false'});
                            
                            $("#email").attr('data-original-title', "Please enter valid e-mail address");
                            $("#email").popover("hide");
                            submit = 0;
                            
                        }else if(msg.trim() == "email"){
                            if(oemail == email){
                                //submit = 1;
                                return;
                            }
                            
                            $("#email").attr('data-original-title', "E-mail address is already in use");
                            $("#email").popover({placement: 'right'});
                            $("#email").popover("show");
                            $("#username").attr('data-original-title', "Only alphanumeric characters and underscore are allowed. Minimum of 8 characters and maximum of 30.");
                            $("#username").popover("hide");
                            
                            submit = 0;
                        }else if(msg.trim() == "both"){
                            if(oname == uname && email == oemail){
                                return;
                            }
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
            
            function fillCountry(){
                var bc = $("#bcountry");
                var dc = $("#dcountry");
                
                $.getJSON('json/countries.json', function(data){
 
                    //clear the current content of the select
                    bc.html('');
                    dc.html('');
 
                    //iterate over the data and append a select option
                    $.each(data.country, function(key, val){ 
                    bc.append('<option value="' + val.code + '">' + val.name + '</option>');
                    dc.append('<option value="' + val.code + '">' + val.name + '</option>');
                    });
                    <% if(isCustomer){%>
                    $("#bcountry").val("<%= coun %>");
                    $("#dcountry").val("<%= dcoun %>");
                    
                    <%}%>
                    
                });
                
            }
            
            function checkAddress() {
                if ($("#bcheck").is(":checked")) {
                    /* CODE FOR WHEN BCHECK IS CHECKED */
                    $("#dAddress").hide();
                    
                    /*COPY VALUE*/
                    $("#dadd").val($("#badd").val());
                    //$("#dstreet").val($("#bstreet").val());
                    //$("#dsubdivision").val($("#bsubdivision").val());
                    //$("#dcity").val($("#bcity").val());
                    $("#dpostal").val($("#bpostal").val());
                    $("#dcountry").val($("#bcountry").val());
                    
                    /*IN CASE VALUES CHANGE AFTER CHECKING THE BOX*/
                     $('#badd').on('keyup', function(event){
                        var key = String.fromCharCode(event.which);
                        if (!event.shiftKey) {
                            key = key.toLowerCase();
                        }
                        $('#dadd').val($(this).val() );
                     });
                     /*
                     $('#bstreet').on('keyup', function(event){
                        var key = String.fromCharCode(event.which);
                        if (!event.shiftKey) {
                            key = key.toLowerCase();
                        }
                        $('#dstreet').val($(this).val());
                     });
                     
                     $('#bsubdivision').on('keyup', function(event){
                        var key = String.fromCharCode(event.which);
                        if (!event.shiftKey) {
                            key = key.toLowerCase();
                        }
                        $('#dsubdivision').val($(this).val());
                     });
                     
                     $('#bcity').on('keyup', function(event){
                        var key = String.fromCharCode(event.which);
                        if (!event.shiftKey) {
                            key = key.toLowerCase();
                        }
                        $('#dcity').val($(this).val());
                     });*/
                     
                     $('#bpostal').on('keyup', function(event){
                        var key = String.fromCharCode(event.which);
                        if (!event.shiftKey) {
                            key = key.toLowerCase();
                        }
                        $('#dpostal').val($(this).val());
                     });
                     
                     $('#bcountry').on('change', function(event){
                        
                        $('#dcountry').val($('#bcountry').val());
                     });
                    
                } else {
                    /* CODE FOR WHEN BCHECK IS UNCHECKED */
                    $("#dAddress").show();
                    $('#badd').off("keyup");
                    //$('#bstreet').off("keyup");
                    //$('#bsubdivision').off("keyup");
                    //$('#bcity').off("keyup");
                    $('#bpostal').off("keyup");
                    $('#bcountry').off("change");
                    
                    
                    $('#dadd').val("");
                    //$('#dstreet').val("");
                    //$('#dsubdivision').val("");
                    //$('#dcity').val("");
                    $('#dpostal').val("");
                    $('#dcountry').val("PH");
                }
            }
            
           
            $(document).ready(function () {
                fillCountry();
                
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
                
                $("#userID").val("<%= user.getUserID() %>");
                $("#username").val("<%= user.getUsername() %>");
                $("#email").val("<%= user.getEmail() %>");
                $("#firstname").val("<%= user.getFname() %>");
                $("#middleI").val("<%= user.getMinitial() %>");
                $("#lastname").val("<%= user.getLname() %>");
                $("#bcountry").val("PH");
                
                <%
                    if(isCustomer){
                        
                        
                    
                %>
               $("#badd").val("<%= billing %>");
               $("#bpostal").val("<%= postal %>");
               //$("#bcountry").val("<%= coun %>");
               $("#dadd").val("<%= delivery %>");
               $("#dcountry").val("<%= dcoun %>");
               $("#dpostal").val("<%= dpostal %>");
               
               
                <%
                    }else{
                %>
                        $("#bAddress").hide();
                        $("#dAddress").hide();
                        $("#aCheck").hide();
                <%
                  
                  
                }%>
                
                
                
                //alert($("#userID").val());
            });
        </script>
    </body>
</html>

