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

        <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Foobar Bookshop</a>
                </div>
        </nav>

        <div class="container">
            <div class="jumbotron" id="content">
                <h2>Register for Foo-ree!</h2>
                <form class="form-horizontal" name="regForm" id = "regForm" method="post" action = "registration" role="form">
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

                            <div><label style= "color:#54C571" class="col-md-6 col-md-offset-2 control-label">Billing Address</label></div>

                            <div class="col-md-12">
                                <input type="text" required="true" placeholder="House #" class="form-control" name="bhouse" id="bhouse"/>
                            </div>

                            <div class="col-md-12">
                                <input type="text" required="true"  placeholder="Street" class="form-control" name="bstreet" id="bstreet"/>
                            </div>

                            <div class="col-md-12">
                                <input type="text" placeholder="Subdivision" class="form-control" name="bsubdivision" id="bsubdivision"/>
                            </div>

                            <div class="col-md-12">
                                <input type="text" required="true" placeholder="City" class="form-control" name="bcity" id="bcity"/>
                            </div>

                            <div class="col-md-4">
                                <input type="text" required="true" placeholder="Postal Code" class="form-control" name="bpostal" id="bpostal"/>
                            </div>

                            <div class="col-md-6">
                                <select name="bcountry" id="bcountry" class="form-control"></select>
                            </div>

                            <div  class="col-md-9 checkbox">
                                <label>
                                    <input id = "bcheck" onclick="checkAddress();" type="checkbox"> Assign the same address for my delivery address
                                </label>
                            </div>

                            <div id="dAddress">
                                <div><label style= "color:#54C571" class="col-md-6 col-md-offset-2 control-label">Delivery Address</label></div>

                                <div class="col-md-12">
                                    <input type="text" placeholder="House #" class="form-control" name="dhouse" id="dhouse"/>
                                </div>

                                <div class="col-md-12">
                                    <input type="text" placeholder="Street" class="form-control" name="dstreet" id="dstreet"/>
                                </div>

                                <div class="col-md-12">
                                    <input type="text" placeholder="Subdivision" class="form-control" name="dsubdivision" id="dsubdivision"/>
                                </div>

                                <div class="col-md-12">
                                    <input type="text" placeholder="City" class="form-control" name="dcity" id="dcity"/>
                                </div>

                                <div class="col-md-4">
                                    <input type="text" placeholder="Postal Code" class="form-control" name="dpostal" id="dpostal"/>
                                </div>

                                <div class="col-md-6">
                                    <select name="dcountry" id="dcountry" class="form-control"></select>
                                 </div>
                            </div>


                            <div class="col-md-12">
                                <button type="submit" class="btn btn-success btn-block">Register</button>
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
                });
    
            }
            
            function checkAddress() {
                if ($("#bcheck").is(":checked")) {
                    /* CODE FOR WHEN BCHECK IS CHECKED */
                    $("#dAddress").hide();
                    
                    /*COPY VALUE*/
                    $("#dhouse").val($("#bhouse").val());
                    $("#dstreet").val($("#bstreet").val());
                    $("#dsubdivision").val($("#bsubdivision").val());
                    $("#dcity").val($("#bcity").val());
                    $("#dpostal").val($("#bpostal").val());
                    $("#dcountry").val($("#bcountry").val());
                    
                    /*IN CASE VALUES CHANGE AFTER CHECKING THE BOX*/
                     $('#bhouse').on('keyup', function(event){
                        var key = String.fromCharCode(event.which);
                        if (!event.shiftKey) {
                            key = key.toLowerCase();
                        }
                        $('#dhouse').val($(this).val() );
                     });
                     
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
                     });
                     
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
                    $('#bhouse').off("keyup");
                    $('#bstreet').off("keyup");
                    $('#bsubdivision').off("keyup");
                    $('#bcity').off("keyup");
                    $('#bpostal').off("keyup");
                    $('#bcountry').off("change");
                    
                    
                    $('#dhouse').val("");
                    $('#dstreet').val("");
                    $('#dsubdivision').val("");
                    $('#dcity').val("");
                    $('#dpostal').val("");
                    $('#dcountry').val("AF");
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
                //alert("HI");
            });
        </script>
    </body>
</html>

