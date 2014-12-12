<%-- 
    Document   : Homepage
    Created on : Nov 9, 2014, 8:43:36 PM
    Author     : aids
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Security.AccessController"%>
<%@page import="Bean.UserBean"%>
<%@page import="DAO.Implementation.UserDAOImplementation"%>
<%@page import="DAO.Interface.UserDAOInterface"%>
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
        
        /*if(user == null || acl.getUNLOCK_USER() == 0){
            response.sendRedirect("Unauthorized.jsp");
            return;
        }*/
        //UserBean user = userIM.getUser("eyjaneh_");
        //user.setPassword("helloworld");
        
        ArrayList<UserBean> aUsers = userIM.getAllUser();
        ArrayList<UserBean> lockedUsers = new ArrayList<UserBean>();
        
        for(UserBean u: aUsers){
            if(u.getStatus() == 3){
                lockedUsers.add(u);
            }
        }
        
        
        //System.out.println("NOT A CUSTOMER");
        
    %>
   
    <script>
    var a = 0;
                    function deleteRowAcc(o) {
                        //no clue what to put here?
                        var p = o.parentNode.parentNode;
                        p.parentNode.removeChild(p);
                        //alert("o: " + o);
                        //alert("o.parentNode: " + o.parentNode);
                        //alert("o.parentNode.parentNode: " + p);
                        //alert("o.row1: " + $(p.cells[1]).text());
                        var x = $(p.cells[0]).text();
                        alert(x);
                        return x;

                    }
                    function unlockAccount(row) {
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
                                //alert(xmlhttp.responseText);
                            }
                        }

                        var username = deleteRowAcc(row);
                        xmlhttp.open("POST", "unlockAccount?username=" + username, true);
                        xmlhttp.send();
                        //alert("deleted " + username + "!");
                        //alert(itemID);

                    }
</script>
    <body>

        <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Foobar Bookshop</a>
                </div>
        </nav>

        <div class="container">
            <div class="jumbotron" id="content">
                <h2>Unlock Accounts</h2>
                <div>These accounts have been locked</div>
                
                <table class="table table-hover" id = "viewLocked">
                    <thead>

                        <tr>
                            <th>Username</th>
                            <th>Unlock</th>
                        </tr>
                        </thead>
                        <tbody>
                            <% for (UserBean lbean : lockedUsers) {%> 
                            <tr>
                            <td><%= lbean.getUsername() %></td>
                            
                            <td><button type="button" onclick="unlockAccount(this)" class="btn btn-danger btn-xs">Unlock</button></td>
                            </tr>

                            <%}%>
                            </tbody>
                </table>
                       
            </div>

        </div>


        <!-- Placed at the end of the document so the pages load faster -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

